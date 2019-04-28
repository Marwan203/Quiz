package com.example.demo;

import java.util.ArrayList;

public interface Questionable {
    public void setQuestionContent(String questionContent);
    public String getQuestionContent();
    public void setCorrectChoice(String correctChoice);
    public String getCorrectChoice();
    public void setNumber_Of_Choices(int number_Of_Choices);
    public int getNumber_Of_Choices();
    public void setChoices(ArrayList<Choice> choices);
    public ArrayList<Choice> getChoices();
}
