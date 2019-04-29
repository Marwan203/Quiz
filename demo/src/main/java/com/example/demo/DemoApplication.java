package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class DemoApplication {
    static {
        System.setProperty("java.awt.headless", "false");
        /* java.awt.GraphicsEnvironment.isHeadless() returns false */
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ArrayList<Quiz> Quizzes = new ArrayList();
        Quiz quiz = new Quiz();
        quiz.makeQuiz();
        Quizzes.add(quiz);
        quiz.TakePersonChoices();
        quiz.CalculatePersonScore();
    }
}
