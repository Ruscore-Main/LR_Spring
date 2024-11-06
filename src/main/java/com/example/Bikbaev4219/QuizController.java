package com.example.Bikbaev4219;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@RestController
public class QuizController {
    private final List<QuizTask> quizTasks = List.of(
            new QuizTask(1, "The Java Logo",
                    "What is depicted on Java Logo?", List.of(
                    "Robot",
                    "Tea leaf",
                    "Cup of coffee",
                    "Bug"
                    ), List.of(1)),

            new QuizTask(2, "Java Code",
                    "What is the output of the following code?\nSystem.out.println(5 + 3 + \"Hello\" + 2 + 1);",
                    List.of(
                    "1. Hello531",
                    "2. 8Hello21",
                    "3. 8Hello",
                    "4. 8Hello"
                    ), List.of(1)),

            new QuizTask(3, "Java Code",
                    "Which of the following is a valid way to declare an array in Java?",
                    List.of(
                            "1. int arr;",
                            "2. int arr;",
                            "3. Both A and B",
                            "4. None of the above"

                    ), List.of(2)),

            new QuizTask(4, "Java Code",
                    "What is the size of an int in Java?",
                    List.of(
                            "1. 8 bits",
                            "2. 16 bits",
                            "3. 32 bits",
                            "4. 64 bits"
                    ), List.of(2))
    );

    @GetMapping("/api/quiz")
    public List<QuizTask> getQuizTasks() {
        return quizTasks;
    }

    @PostMapping("/api/quiz")
    public QuizResult getQuizTasks(@RequestParam int question, @RequestParam List<Integer> answers) {
        boolean isTrue = quizTasks.get(question).isTrueAnswers(answers);
        return  new QuizResult(isTrue, isTrue ?
                "Congratulations, you're right!"
                : "Wrong answer! Please, try again.");
    }
}
