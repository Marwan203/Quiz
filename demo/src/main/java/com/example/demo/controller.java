package com.example.demo;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;



@RestController
public class controller {
    private DataAccess DB = new DataAccess();
    controller(){

    }
    @RequestMapping(value = "/Person/Score",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject GettingPersonScore(){
        return DB.fetch_Person_Score();
    }
    @RequestMapping(value = "/ListOfAvailableQuizzes",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject GetTheList(){
        return DB.fetch_Quiz_list();
    }
}
