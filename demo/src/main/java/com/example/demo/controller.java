package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class controller {
    private Quiz Q = new Quiz();
    public void set_a_record(){
        Q.setQuizTitle("C++");
        Q.setSkillType("programming");
        Q.setNumberOfQuestions(10);
        Q.setQuizDuration(1);
        Q.setQuizPassScore(20);
        Q.setPersonScore(25);
    }
    @RequestMapping(value = "/Score",method = RequestMethod.GET)
    @ResponseBody
    public Quiz GettingPersonScore(){
        set_a_record();
        return Q;
    }
}
