package com.example.Bikbaev4219.presentation;

import com.example.Bikbaev4219.AnswerJson;
import com.example.Bikbaev4219.dto.QuizResult;
import com.example.Bikbaev4219.dto.QuizTaskResponse;
import com.example.Bikbaev4219.entities.QuizTask;
import com.example.Bikbaev4219.businesslayer.QuizTaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
public class QuizzesController {
    @Autowired
    QuizTaskService quizTaskService;

    @PostMapping("/api/quizzes")
    public QuizTaskResponse addQuiz(@Valid @RequestBody QuizTask quizTask) {
        return quizTaskService.save(quizTask);
    }

    @GetMapping("/api/quizzes")
    public List<QuizTaskResponse> getQuizzes() {
        return quizTaskService.getAllQuizzes();
    }

    @GetMapping("/api/quizzes/{id}")
    public QuizTask getQuizById(@PathVariable long id) {

        Optional<QuizTask> quizTask = quizTaskService.findQuizById(id);
        if (quizTask.isPresent()) {
            return quizTask.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found :(");
    }

    @GetMapping("/api/quizzes/{id}/solve")
    public QuizResult solveQuiz(@PathVariable long id, @RequestParam AnswerJson answers) {
        Optional<QuizTask> quizTask = quizTaskService.findQuizById(id);
        if (quizTask.isPresent()) {
            boolean isTrue = quizTask.get().isTrueAnswers(answers.getAnswer());
            return new QuizResult(isTrue, isTrue ?
                    "Congratulations, you're right!"
                    : "Wrong answer! Please, try again.");
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found :(");
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public QuizResult solveQuizPost(@PathVariable long id, @RequestBody AnswerJson answers) {
        Optional<QuizTask> quizTask = quizTaskService.findQuizById(id);
        if (quizTask.isPresent()) {
            boolean isTrue = quizTask.get().isTrueAnswers(answers.getAnswer());
            return new QuizResult(isTrue, isTrue ?
                    "Congratulations, you're right!"
                    : "Wrong answer! Please, try again.");
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found :(");
    }
}
