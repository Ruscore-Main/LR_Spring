package com.example.Bikbaev4219.businesslayer;

import com.example.Bikbaev4219.dto.QuizTaskResponse;
import com.example.Bikbaev4219.entities.Answer;
import com.example.Bikbaev4219.entities.Option;
import com.example.Bikbaev4219.entities.QuizTask;
import com.example.Bikbaev4219.persistence.AnswerRepository;
import com.example.Bikbaev4219.persistence.OptionRepository;
import com.example.Bikbaev4219.persistence.QuizTaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizTaskService {
    private final QuizTaskRepository quizTaskRepository;
    private final AnswerRepository answerRepository;
    private final OptionRepository optionRepository;

    @Autowired
    public QuizTaskService(
            QuizTaskRepository quizTaskRepository,
            AnswerRepository answerRepository,
            OptionRepository optionRepository) {
        this.quizTaskRepository = quizTaskRepository;
        this.answerRepository = answerRepository;
        this.optionRepository = optionRepository;
    }
    public Optional<QuizTask> findQuizById(long id) {
        return quizTaskRepository.findById(id);
    }
    public List<QuizTaskResponse> getAllQuizzes() {
        List<QuizTaskResponse> quizTaskResponses = new ArrayList<>();
        quizTaskRepository.findAll().forEach(
                quizTask -> quizTaskResponses.add(toQuizTaskResponse(quizTask))
        );

        return quizTaskResponses;
    }
    public QuizTaskResponse save(QuizTask toSave) {
        QuizTask newQuizTask = quizTaskRepository.save(new QuizTask(toSave.getTitle(), toSave.getText()));


        List<Option> options = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();


        toSave.getOptions().forEach(el -> {
            Option newOption = new Option(el.getOption());
            newOption.setQuizTask(newQuizTask);
            optionRepository.save(newOption);
            options.add(newOption);
        });
        toSave.getAnswer().forEach(el -> {
            Answer newAnswer = new Answer(el.getTrueAnswerIndex());
            newAnswer.setQuizTask(newQuizTask);
            answerRepository.save(newAnswer);
            answers.add(newAnswer);
        });

        newQuizTask.setOptions(options);

        return toQuizTaskResponse(newQuizTask);
    }

    private QuizTaskResponse toQuizTaskResponse(QuizTask quizTask) {
        QuizTaskResponse quizTaskResponse = new QuizTaskResponse();
        quizTaskResponse.setId(quizTask.getId());
        List<String> stringOptions = new ArrayList<>();
        quizTask.getOptions().forEach(
                el -> stringOptions.add(el.getOption())
        );
        quizTaskResponse.setOptions(stringOptions);
        return quizTaskResponse;
    }
}


