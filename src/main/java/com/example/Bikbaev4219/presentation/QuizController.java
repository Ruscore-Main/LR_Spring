package com.example.Bikbaev4219.presentation;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
//    private final List<QuizTask> quizTasks = List.of(
//            new QuizTask(1, "The Java Logo",
//                    "What is depicted on Java Logo?", List.of(
//                    new Option("Robot"),
//                    new Option("Tea leaf"),
//                    new Option("Cup of coffee"),
//                    new Option("Bug")
//                    ), List.of(new Answer(1))),
//
//            new QuizTask(2, "Java Code",
//                    "What is the output of the following code?\nSystem.out.println(5 + 3 + \"Hello\" + 2 + 1);",
//                    List.of(
//                            new Option("1. Hello531"),
//                            new Option("2. 8Hello21"),
//                            new Option("3. 8Hello"),
//                            new Option("4. 8Hello")
//                    ), List.of(new Answer(1))),
//
//            new QuizTask(3, "Java Code",
//                    "Which of the following is a valid way to declare an array in Java?",
//                    List.of(
//                            new Option("1. int arr;"),
//                            new Option("2. int arr;"),
//                            new Option("3. Both A and B"),
//                            new Option("4. None of the above")
//                    ), List.of(new Answer(2))),
//
//            new QuizTask(4, "Java Code",
//                    "What is the size of an int in Java?",
//                    List.of(
//                            new Option("1. 8 bits"),
//                            new Option("2. 16 bits"),
//                            new Option("3. 32 bits"),
//                            new Option("4. 64 bits")
//                    ), List.of(new Answer(2)))
//    );
//
//    @GetMapping("/api/quiz")
//    public List<QuizTask> getQuizTasks() {
//        return quizTasks;
//    }
//
//    @PostMapping("/api/quiz")
//    public QuizResult getQuizTasks(@RequestParam int question, @RequestParam List<Integer> answers) {
//        boolean isTrue = quizTasks.get(question).isTrueAnswers(answers);
//        return  new QuizResult(isTrue, isTrue ?
//                "Congratulations, you're right!"
//                : "Wrong answer! Please, try again.");
//    }
}
