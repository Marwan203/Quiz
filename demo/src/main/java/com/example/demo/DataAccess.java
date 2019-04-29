package com.example.demo;

import java.sql.*;

import org.json.simple.JSONObject;
public class DataAccess{
    private static int quizID;
    private int questionId;
    private int PersonScore;
    private int PassScore ;

    public DataAccess(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            st = C.createStatement();
            resultSet = st.executeQuery("select MAX(QuizID) as QuizID from Quiz");
            resultSet.next();
            this.quizID = resultSet.getInt("QuizID");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void insert_A_Quiz(Quiz quiz){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            String SQL = "insert into Quiz Values ('"+quiz.getQuizTitle()+"' , '"+quiz.getNumberOfQuestions()+"' , '"+quiz.getQuizPassScore()+"' , '"+quiz.getQuizDuration()+"' , '"+quiz.getSkillType()+"')";
            st = C.createStatement();
            st.execute(SQL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void getQuizId(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            st = C.createStatement();
            resultSet = st.executeQuery("select MAX(QuizID) as QuizID from Quiz");
            resultSet.next();
            this.quizID = resultSet.getInt("QuizID");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void insert_A_Question(Question Ques){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            String SQL = "insert into Question VALUES ('"+Ques.getQuestionContent()+"' , '"+Ques.getCorrectChoice()+"' , '"+Ques.getNumber_Of_Choices()+"' , '"+quizID+"')";
            st = C.createStatement();
            st.execute(SQL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void getQuestionId(){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        ResultSet resultSet = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            st = C.createStatement();
            resultSet = st.executeQuery("select MAX(QuestionID) as QuestionID from Question");
            resultSet.next();
            questionId = resultSet.getInt("QuestionID");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    public void insert_A_Choice(Choice choice){
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionUrl);
            String SQL = "insert into Choice values ('"+choice.getChoiceContent()+"' , '"+questionId+"')";
            st = C.createStatement();
            st.execute(SQL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void GetPersonScore(Quiz quiz){
        PersonScore = quiz.getPersonScore();
        PassScore = quiz.getQuizPassScore();
    }

    public void InserPersonScore (){
        String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionURL);
            String SQL = "insert into Demo values ('"+quizID+"' , '"+PersonScore+"')";
            st = C.createStatement();
            st.execute(SQL);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public JSONObject fetch_Person_Score(){
        String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        JSONObject json = new JSONObject();
        ResultSet resultSet = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionURL);
            st = C.createStatement();
            int PersonScore ;
            resultSet=st.executeQuery("select PersonScore from Demo where QuizId = '"+quizID+"'");
            resultSet.next();
            PersonScore = resultSet.getInt("PersonScore");
            if (PersonScore > PassScore){
                json.put("PersonScore" , resultSet.getInt("PersonScore"));
                return json;
            }
            else {
                json.put("PersonScore" , "lessThenPassScore");
                return json;
            }
        }
        catch(Exception e) {
            return null;
        }
    }
    public JSONObject fetch_Quiz_list(){
        String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=Quiz DB;integratedSecurity=true;";
        Connection C = null;
        Statement st = null;
        JSONObject json = new JSONObject();
        ResultSet resultSet = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            C = DriverManager.getConnection(connectionURL);
            st = C.createStatement();
            resultSet=st.executeQuery("select Title ,Skill_Type from Quiz ");
            while (resultSet.next()){
                json.put(resultSet.getString("Title") , resultSet.getString("Skill_Type"));
            }
            return json;
        }
        catch(Exception e) {
            return null;
        }
    }
    public void Update(){

    }
    public void delete(){

    }
    public void search(){

    }
}
