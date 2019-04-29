package com.example.demo;



import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.*;


@Entity
public class Quiz implements Quizable {
    @Id
    @GeneratedValue
    private int QuizId;
    private int NumberOfQuestions;
    private String QuizTitle ;
    private String SkillType;
    private int QuizPassScore;
    private double QuizDuration;
    private int PersonScore ;
    private ArrayList<Question> Questions = new ArrayList();

    public Quiz(){

    }
    public void makeQuiz(){
        DataAccess Data = new DataAccess();
        Scanner input = new Scanner (System.in);
        System.out.println("Enter The Quiz Title");
        QuizTitle = input.nextLine();
        System.out.println("Enter The Quiz Duration");
        QuizDuration = input.nextDouble();
        input.nextLine();
        System.out.println("Enter The Quiz skill type");
        SkillType = input.nextLine();
        System.out.println("Enter The Quiz Pass Score");
        QuizPassScore = input.nextInt();
        input.nextLine();
        System.out.println("Enter The Number of Questions ");
        NumberOfQuestions = input.nextInt();
        input.nextLine();
        Data.insert_A_Quiz(this);
        for (int Counter = 1 ; Counter<=NumberOfQuestions ; Counter++){
            Question Q = new Question();
            System.out.println("Enter The Question " + Counter +" Content");
            Q.setQuestionContent(input.nextLine());
            System.out.println("Enter The Question " + Counter +" Correct Choice");
            Q.setCorrectChoice(input.nextLine());
            System.out.println("Enter The Question " + Counter +" Number OF Choices");
            Q.setNumber_Of_Choices(input.nextInt());
            input.nextLine();
            Data.insert_A_Question(Q,this);
            for (int counter = 1 ; counter<=Q.getNumber_Of_Choices();counter++){
                Choice cho = new Choice();
                System.out.println("Enter The ChoiceContent");
                cho.setChoiceContent(input.nextLine());
                Q.getChoices().add(cho);
                Data.insert_A_Choice(cho,Q);
            }
            Questions.add(Q);
        }
    }
    public int getQuizId() {
        return QuizId;
    }
    public void setNumberOfQuestions(int numberOfQuestions) {
        NumberOfQuestions = numberOfQuestions;
    }
    public int getNumberOfQuestions() {
        return NumberOfQuestions;
    }
    public void setQuizTitle(String quizTitle) {
        QuizTitle = quizTitle;
    }
    public String getQuizTitle() {
        return QuizTitle;
    }
    public void setSkillType(String skillType) {
        SkillType = skillType;
    }
    public String getSkillType() {
        return SkillType;
    }
    public void setQuizPassScore(int quizPassScore) {
        QuizPassScore = quizPassScore;
    }
    public int getQuizPassScore() {
        return QuizPassScore;
    }
    public void setQuizDuration(float quizDuration) {
        QuizDuration = quizDuration;
    }
    public double getQuizDuration() {
        return QuizDuration;
    }
    public void setPersonScore(int personScore) {
        PersonScore = personScore;
    }
    public int getPersonScore() {
        return PersonScore;
    }

    public void setQuestions(ArrayList<Question> questions) {
        Questions = questions;
    }

    public ArrayList<Question> getQuestions() {
        return Questions;
    }
}
