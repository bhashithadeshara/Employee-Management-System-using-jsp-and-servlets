<%-- 
    Document   : SearchEmployee
    Created on : Sep 12, 2022, 10:08:08 AM
    Author     : bhast
--%>


<%@page import="Model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Employee Page</title>
    </head>
    <body>
        <h1>Search the Employee by Id</h1>
        
        <form method="get" action="SearchEmployee.jsp">
            <table>
                <tr>
                    <td>Enter NIC number of the employee</td>
                    <td><input type="text" name="nicNo" placeholder="Ex-56124242V"/></td>                    
                </tr>
                 <tr>                    
                    <td><input type="submit" value="Search"/></td>                    
                </tr>
            </table>
        </form>
        
        <% 
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","");
        %>
        
        <table  cellPadding="1" cellSpacing="1" border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Annual Income</th>
                    <th>Login Username</th>
                    <th>Password</th>
                    <th>NIC No</th>
                    <th>Remarks</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    String nicNo = request.getParameter("nicNo");
                    
                  try{
                     
                     Employee emp = new Employee();
                     emp.setNicNo(nicNo);
                     PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE nic_No = ?");
                     ps.setString(1,emp.getNicNo());
                     
                     ResultSet rs = ps.executeQuery();
                     
                     while(rs.next()){
                  %> 
                   
                  <tr>
                      <td><%= rs.getString("title") %></td>
                      <td><%= rs.getString("fName") %></td>
                      <td><%= rs.getString("lName") %></td>                      
                      <td><%= rs.getInt("age") %></td>
                      <td><%= rs.getDouble("aIncome") %></td>
                      <td><%= rs.getString("username") %></td>
                      <td><%= rs.getString("password") %></td>
                      <td><%= rs.getString("nic_No") %></td>
                      <td><%= rs.getString("remarks") %></td>                      
                      
                      
                      
                  </tr>
                  
                  <%  
                    }
                  
                  }catch(Exception ex){
                  
                      out.println("Employee is not available");
                  }
                %>
            </tbody>
        </table>
         
            <a href="index.html">Go to Register Page</a>
    </body>
</html>
