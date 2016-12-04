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
    public static void setUp() throws IOException {
        calculatorServlet = new CalculatorServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        PrintWriter printWriter = mock(PrintWriter.class);
        when(request.getRequestURI()).thenReturn(INPUT);
        when(response.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void doPostShouldSetResponseStatus() throws ServletException, IOException {
        calculatorServlet.doPost(request, response);
        verify(response).setStatus(405);
    }

    @Test
    public void doGetShouldWorkCorrectly() throws ServletException, IOException {
        new CalculatorServlet().doGet(request, response);
        verify(request).getRequestURI();
    }
}
