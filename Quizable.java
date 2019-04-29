package com.example.demo;

import java.util.ArrayList;

public interface Quizable {
    public int getQuizId();
    public void setNumberOfQuestions(int numberOfQuestions);
    public int getNumberOfQuestions();
    public void setQuizTitle(String quizTitle);
    public String getQuizTitle();
    public void setSkillType(String skillType);
    public String getSkillType();
    public void setQuizPassScore(int quizPassScore);
    public int getQuizPassScore();
    public void setQuizDuration(float quizDuration);
    public double getQuizDuration();
    public void setPersonScore(int personScore);
    public int getPersonScore();
    public void makeQuiz();
    public void setQuestions(ArrayList<Question> questions);
    public ArrayList<Question> getQuestions();
}
