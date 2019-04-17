package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Question implements Questionable {
    @Id
    @GeneratedValue
    private int QuestionID ;
    private String QuestionContent;
    private String CorrectChoice;
    private int Number_Of_Choices;
    ArrayList<Choice> Choices = new ArrayList();

    public Question(){

    }

    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionContent(String questionContent) {
        QuestionContent = questionContent;
    }
    public String getQuestionContent(){
        return QuestionContent;
    }

    public void setCorrectChoice(String correctChoice) {
        CorrectChoice = correctChoice;
    }

    public String getCorrectChoice() {
        return CorrectChoice;
    }

    public void setNumber_Of_Choices(int number_Of_Choices) {
        Number_Of_Choices = number_Of_Choices;
    }

    public int getNumber_Of_Choices() {
        return Number_Of_Choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        Choices = choices;
    }

    public ArrayList<Choice> getChoices() {
        return Choices;
    }
}
