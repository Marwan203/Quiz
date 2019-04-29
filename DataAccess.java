package com.example.demo;

import java.sql.*;


public class DataAccess implements DataAccessable{
    public void insert_A_Quiz(Quiz quiz){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            String SQL = "insert into Quiz Values ('"+quiz.getQuizId()+"' , '"+quiz.getQuizTitle()+"' , '"+quiz.getNumberOfQuestions()+"' , '"+quiz.getQuizPassScore()+"' , '"+quiz.getQuizDuration()+"' , '"+quiz.getSkillType()+"')";
            st = C.createStatement();
            st.execute(SQL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void insert_A_Question(Question Ques , Quiz quiz){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            String SQL = "insert into Question VALUES ('"+Ques.getQuestionID()+"' , '"+Ques.getQuestionContent()+"' , '"+Ques.getCorrectChoice()+"' , '"+Ques.getNumber_Of_Choices()+"' , '"+quiz.getQuizId()+"')";
            st = C.createStatement();
            st.execute(SQL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void insert_A_Choice(Choice choice , Question Ques){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            String SQL = "insert into Choice values ('"+choice.getChoiceID()+"' , '"+choice.getChoiceContent()+"' , '"+Ques.getQuestionID()+"')";
            st = C.createStatement();
            st.execute(SQL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void Update(){

    }
    public void delete(){

    }
    public void search(){

    }
}
