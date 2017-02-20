package com.solncev.controller;

import com.solncev.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Марат on 19.02.2017.
 */
@Controller
public class MainController {
    List<User> users;

    public MainController() {
        users = new ArrayList<>();
    }

    private static Date getDate(String date) throws ParseException {
        if (date.equals("")) {
            return null;
        }
        DateFormat formatter;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }

    private static boolean isCorrect(String name, String surname, String patronymic) {
        return !(name.equals("") || surname.equals("") || patronymic.equals(""));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "/table", method = RequestMethod.POST)
    public String getTablePage(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("patronymic") String patronymic,
                               @RequestParam("date") String date,
                               @RequestParam("gender") String gender,
                               Model model) {
        User user = null;
        if (isCorrect(name, surname, patronymic)) {
            try {
                user = new User(name, surname, patronymic, getDate(date), gender);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            users.add(user);
        }
        model.addAttribute("users", users);
        return "table";
    }
}
