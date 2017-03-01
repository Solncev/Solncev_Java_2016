package com.solncev.controller;

import com.solncev.model.enums.Subject;
import com.solncev.services.JdbcTemplateDao;
import com.solncev.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Марат on 28.02.2017.
 */
@Controller
public class MainController {
    private final ScoreService scoresService;

    @Autowired
    public MainController(JdbcTemplateDao scoresService) {
        this.scoresService = scoresService;
    }

    @RequestMapping("/totalscore")
    @ResponseBody
    public String getTotalScore(@RequestParam(name = "id") String id) {
        return String.valueOf(scoresService.getTotalScore(Long.valueOf(id)));
    }

    @RequestMapping("/averagescore")
    @ResponseBody
    public String getAvgScore(@RequestParam(name = "id") String id) {
        return String.valueOf(scoresService.getAverageScore(Long.valueOf(id)));
    }

    @RequestMapping("/score")
    @ResponseBody
    public String getScore(@RequestParam(name = "id") String id, @RequestParam(name = "subject") String subject) {
        return String.valueOf(scoresService.getScoreBySubject(Long.valueOf(id), Subject.valueOf(subject.toUpperCase())));
    }
}
