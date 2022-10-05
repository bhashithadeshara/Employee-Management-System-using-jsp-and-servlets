/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author bhast
 */
public class Employee {
    
    private String title;
    private String fName;
    private String lName;
    private String nicNo;
    private String remarks;
    private int age;
    private String password;
    private String username;
    private double annualIncome;
    
    public void setTitle(String title){
    
        this.title = title;
    }
    
    public void setFname(String fName){
    
        this.fName = fName;
    }
    
    public void setLName(String lName){
       
        this.lName = lName;
    }
    
    public void setNicNo(String nicNo){
    
        this.nicNo = nicNo;
    }
    
    public void setRemarks(String remarks){
    
        this.remarks = remarks;
    }
    
    public void setPassword(String password){
    
        this.password = password;
    }
    
    public void setUsername(String username){
    
        this.username = username;
    }
    
    public void setAge(int age){
    
        this.age = age;
    }
    
    public void setAnnualIncome(double annualIncome){
    
        this.annualIncome = annualIncome;
    }
    
    public String getTitle(){
    
       return this.title; 
    }
    
    public String getFname(){
    
       return this.fName; 
    }
    
    public String getLname(){
    
       return this.lName; 
    } 
    
    public String getNicNo(){
    
       return this.nicNo; 
    }
    
    public String getRemarks(){
    
       return this.remarks; 
    }
    
    public String getPassword(){
    
       return this.password; 
    }
    
    public String getUsername(){
    
       return this.username; 
    }
    
    public int getAge(){
    
       return this.age; 
    }
   
    public double getAnnualIncome(){
    
       return this.annualIncome; 
    }
         
      
      
      
}
