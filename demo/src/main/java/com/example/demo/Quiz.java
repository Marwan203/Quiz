package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int QuizId ;
    private int NumberOfQuestions;
    private String QuizTitle ;
    private String SkillType;
    private int QuizPassScore;
    private double QuizDuration;
    private int PersonScore = 50;

    public int getQuizId() {
        return QuizId;
    }

    public int getNumberOfQuestions() {
        return NumberOfQuestions;
    }

    public String getQuizTitle() {
        return QuizTitle;
    }

    public String getSkillType() {
        return SkillType;
    }

    public int getQuizPassScore() {
        return QuizPassScore;
    }

    public double getQuizDuration() {
        return QuizDuration;
    }

    public int getPersonScore() {
        return PersonScore;
    }

    public void setQuizId(int quizId) {
        QuizId = quizId;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        NumberOfQuestions = numberOfQuestions;
    }

    public void setQuizTitle(String quizTitle) {
        QuizTitle = quizTitle;
    }

    public void setSkillType(String skillType) {
        SkillType = skillType;
    }

    public void setQuizPassScore(int quizPassScore) {
        QuizPassScore = quizPassScore;
    }

    public void setQuizDuration(float quizDuration) {
        QuizDuration = quizDuration;
    }

    public void setPersonScore(int personScore) {
        PersonScore = personScore;
    }
}
