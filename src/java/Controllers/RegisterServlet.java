/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DbCon;
import Model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bhast
 */
public class RegisterServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        String title = request.getParameter("title");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String nicNo = request.getParameter("nicNo");
        String remarks = request.getParameter("remarks");
        int age = Integer.parseInt(request.getParameter("age"));
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        double annualIncome = Double.parseDouble(request.getParameter("aIncome"));
        
        Employee emp = new Employee();
        
        if( title == null || fName == null || lName == null || nicNo == null || remarks == null || age == 0 || password == null || username == null || annualIncome == 0 ){
       
            out.println("Please Enter values for all the fields");
            RequestDispatcher req = request.getRequestDispatcher("index.html");
            req.include(request, response);
        }else{
          
            emp.setAge(age);
            emp.setAnnualIncome(annualIncome);
            emp.setFname(fName);
            emp.setLName(lName);
            emp.setNicNo(nicNo);
            emp.setPassword(password);
            emp.setRemarks(remarks);
            emp.setTitle(title);
            emp.setUsername(username);
            
            int result = DbCon.regEmployee(emp);
            
            if(result > 0){
            
               out.println("Registered Successfully !");
               RequestDispatcher req = request.getRequestDispatcher("index.html");
               req.include(request, response);
            }else{
            
               out.println("Registration failed !!");
               RequestDispatcher req = request.getRequestDispatcher("index.html");
               req.include(request, response);
            }
        }
        
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
