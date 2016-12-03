package com.solncev;

import com.solncev.servlets.CalculatorServlet;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;

/**
 * Created by Марат on 04.12.2016.
 */
public class CalculatorServletTest {
    private static final String INPUT = "/calculator/1+1";

    private static CalculatorServlet calculatorServlet;
    private static HttpServletResponse response;
    private static HttpServletRequest request;

    @BeforeClass
    public static void setUp() {
        calculatorServlet = new CalculatorServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        PrintWriter printWriter = mock(PrintWriter.class);
        when(request.getRequestURI()).thenReturn(INPUT);
        try {
            when(response.getWriter()).thenReturn(printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doPostShouldSetResponseStatus() {
        try {
            calculatorServlet.doPost(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        verify(response).setStatus(405);
    }

    @Test
    public void doGetShouldWorkCorrectly() {
        try {
            new CalculatorServlet().doGet(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
        verify(request).getRequestURI();
    }
}
