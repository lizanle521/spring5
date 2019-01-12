package controller;

import entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class TestController {

    @Autowired
    private People people;

    @RequestMapping("/people")
    @ResponseBody
    public String get(){
        return people.toString();
    }
}
