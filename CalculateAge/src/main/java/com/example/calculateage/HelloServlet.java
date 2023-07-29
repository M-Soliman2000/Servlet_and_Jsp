package com.example.calculateage;

import java.io.*;
import java.time.Instant;
import java.util.Date;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

       // Date d=Date.from(Instant.parse(request.getParameter("Date")));
        //long time=d.getTime();
        String time= request.getParameter("birth");
        boolean ch=false;
        String []arrTime=time.split("-");
        int yearBirth= Integer.parseInt(arrTime[0]);
        int MonthBirth= Integer.parseInt(arrTime[1]);
        int DaysBirth= Integer.parseInt(arrTime[2]);

        time= request.getParameter("age");
        arrTime=time.split("-");
        int yearAge= Integer.parseInt(arrTime[0]);
        int MonthsAge= Integer.parseInt(arrTime[1]);
        int DaysAge= Integer.parseInt(arrTime[2]);

        Long totalDays;

        if(yearAge>yearBirth) {
            totalDays = (30 - DaysBirth + 1) + (12 - MonthBirth) * 30 + (yearAge - (yearBirth + 1)) * 12 * 30 + 0L;

        }
        else if(yearAge==yearBirth)
        {
            totalDays= (30 - DaysBirth + 1) + (MonthsAge - MonthBirth) * 30 + 0L;
        }
        else {
            ch=true;
            totalDays=0L;
        }
        long totalHour = totalDays * 24;
        long totalMinutes = totalHour * 60;
        long totalSecond = totalMinutes * 60;


        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(ch==true)
        {
            out.println("<h1>" +"you enter invalide date = "+ "</h1>");
        }
        out.println("<h1>" +"totalDays = "+ totalDays + "</h1>");
        out.println("<h1>" +"totalMinutes = "+ totalMinutes + "</h1>");
        out.println("<h1>" +" totalSecond =  " + totalSecond + "</h1>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}