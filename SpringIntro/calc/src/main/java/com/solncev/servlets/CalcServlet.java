package com.solncev.servlets;

import com.solncev.enums.Operator;
import com.solncev.helpers.ConfigSingleton;
import com.solncev.services.CalculatorService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 16.02.2017.
 */
public class CalcServlet extends HttpServlet {
    CalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        Configuration cfg = ConfigSingleton.getConfig(req.getServletContext());
        Template tmpl = cfg.getTemplate("index.ftl");
        try {
            tmpl.process(null, resp.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        int first = Integer.parseInt(req.getParameter("first"));
        int second = Integer.parseInt(req.getParameter("second"));
        Operator operator = Operator.valueOf(req.getParameter("operator"));
//        String s = first + second;
        String s = calculatorService.getResultOfCalculation(first, second, operator);
        resp.sendRedirect("/answer?answer=" + s);
    }
}
