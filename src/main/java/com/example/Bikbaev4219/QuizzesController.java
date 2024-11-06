package com.example.Bikbaev4219;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class QuizzesController {
    private List<QuizTask> quizTasks = new ArrayList<>();

    @PostMapping("/api/quizzes")
    public QuizTask addQuiz(@Valid @RequestBody QuizTask quizTask) {
        Date currentDate = new Date(System.currentTimeMillis());
        long millis = currentDate.getTime();
        quizTask.setId(millis);
        quizTasks.add(quizTask);
        return  quizTask;
    }

    @GetMapping("/api/quizzes")
    public List<QuizTask> getQuizzes() {
        return quizTasks;
    }

    @GetMapping("/api/quizzes/{id}")
    public QuizTask getQuizById(@PathVariable long id) {
        for (QuizTask quizTask : quizTasks) {
            if (quizTask.getId() == id) {
                return quizTask;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found :(");
    }

    @GetMapping("/api/quizzes/{id}/solve")
    public QuizResult solveQuiz(@PathVariable long id, @RequestParam AnswerJson answers) {
        for (QuizTask quizTask : quizTasks) {
            if (quizTask.getId() == id) {
                boolean isTrue = quizTask.isTrueAnswers(answers.getAnswer());
                return new QuizResult(isTrue, isTrue ?
                        "Congratulations, you're right!"
                        : "Wrong answer! Please, try again.");
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found :(");
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public QuizResult solveQuizPost(@PathVariable long id, @RequestBody AnswerJson answers) {
        for (QuizTask quizTask : quizTasks) {
            if (quizTask.getId() == id) {
                boolean isTrue = quizTask.isTrueAnswers(answers.getAnswer());
                return new QuizResult(isTrue, isTrue ?
                        "Congratulations, you're right!"
                        : "Wrong answer! Please, try again.");
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found :(");
    }
}
