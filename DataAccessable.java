package com.example.demo;

public interface DataAccessable {
    public void insert_A_Quiz(Quiz quiz);
    public void insert_A_Question(Question Ques , Quiz quiz);
    public void insert_A_Choice(Choice choice , Question Quest);
    public void Update();
    public void delete();
    public void search();
}
