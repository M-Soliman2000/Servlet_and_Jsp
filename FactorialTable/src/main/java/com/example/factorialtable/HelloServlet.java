package com.example.factorialtable;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int maxFactorial=Integer.parseInt(request.getParameter("MaxFactorial"));
        Long []factorialArr=calFacrorials(maxFactorial);

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Number   --->  Factorial </h1>");
        out.println("<pre>");
        for (int i = 0; i <= maxFactorial; i++) {
            out.format( "%10d  %20d",i  , factorialArr[i]);
            out.println("<br> ");
        }
        out.println("</pre>");
        out.println("</body></html>");
    }
    public Long[] calFacrorials (int num)
    {
        ArrayList<Integer> factorials=new ArrayList<>();
        Long arr[]=new Long[num+1];
        arr[0]=1l;

        for(int i=1;i<=num;i++)
        {
            arr[i]=arr[i-1]*i;
        }
        return arr;
    }

    public void destroy() {
    }
}