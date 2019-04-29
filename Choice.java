package com.example.demo;

import javax.persistence.*;

@Entity
public class Choice implements Choiceable{
    @Id
    @GeneratedValue
    private int ChoiceID ;
    private String ChoiceContent;

    public Choice(){

    }
    public int getChoiceID() {
        return ChoiceID;
    }
    public void setChoiceContent(String choiceContent) {
        ChoiceContent = choiceContent;
    }

    public String getChoiceContent() {
        return ChoiceContent;
    }
}
