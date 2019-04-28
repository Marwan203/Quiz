package com.example.demo;



import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.*;


@Entity
public class Quiz implements Quizable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int QuizId;
    private int NumberOfQuestions;
    private String QuizTitle ;
    private String SkillType;
    private int QuizPassScore;
    private double QuizDuration;
    public int PersonScore ;
    private ArrayList<String> PersonChoices = new ArrayList<String>();
    private ArrayList<Question> Questions = new ArrayList<Question>();

    public Quiz(){
        PersonScore = 0 ;
    }
    public void makeQuiz(){
        DataAccess Data = new DataAccess();
        Scanner input = new Scanner (System.in);
        System.out.println("Enter The Quiz Title");
        this.QuizTitle = input.nextLine();
        System.out.println("Enter The Quiz Duration");
        this.QuizDuration = input.nextDouble();
        input.nextLine();
        System.out.println("Enter The Quiz skill type");
        this.SkillType = input.nextLine();
        System.out.println("Enter The Quiz Pass Score");
        this.QuizPassScore = input.nextInt();
        input.nextLine();
        System.out.println("Enter The Number of Questions ");
        this.NumberOfQuestions = input.nextInt();
        input.nextLine();
        Data.insert_A_Quiz(this);
        Data.getQuizId();
        for (int Counter = 1 ; Counter<=NumberOfQuestions ; Counter++){
            Question Q = new Question();
            System.out.println("Enter The Question " + Counter +" Content");
            Q.setQuestionContent(input.nextLine());
            System.out.println("Enter The Question " + Counter +" Correct Choice");
            Q.setCorrectChoice(input.nextLine());
            System.out.println("Enter The Question " + Counter +" Number OF Choices");
            Q.setNumber_Of_Choices(input.nextInt());
            input.nextLine();
            Data.insert_A_Question(Q);
            Data.getQuestionId();
            for (int counter = 1 ; counter<=Q.getNumber_Of_Choices();counter++){
                Choice cho = new Choice();
                System.out.println("Enter The ChoiceContent");
                cho.setChoiceContent(input.nextLine());
                Q.getChoices().add(cho);
                Data.insert_A_Choice(cho);
            }
            Questions.add(Q);
        }
    }


    @Override
    public void TakePersonChoices() {
        Scanner input = new Scanner(System.in);
        String entered = new String();
        for(int Counter = 0 ; Counter<this.Questions.size();Counter++){
            System.out.println("Enter Your Choice For Question Number "+ (Counter+1));
            entered = input.nextLine();
            PersonChoices.add(entered);
        }
    }

    @Override
    public void CalculatePersonScore() {
        DataAccess DB = new DataAccess();
        for(int Counter = 0  ;Counter<this.Questions.size(); Counter++){
            if (PersonChoices.get(Counter).equals( Questions.get(Counter).getCorrectChoice())){
                PersonScore++;
            }
            else {
                PersonScore--;
            }
        }
        DB.GetPersonScore(this);
        DB.getQuizId();
        DB.InserPersonScore();
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
