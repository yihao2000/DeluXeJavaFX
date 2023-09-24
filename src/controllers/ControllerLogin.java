package controllers;

import java.sql.SQLException;

import main.Main;
import models.Account;
import models.Company;
import models.Staff;
import models.Student;
import models.User;
import utils.Logger;
import views.View;
import views.ViewLogin;

public class ControllerLogin extends ViewController{
	
	private final ViewLogin vl;

	public ControllerLogin(View view) {
		super(view);
		vl = (ViewLogin) view;
		
		vl.getBtnLogin().setOnAction(e -> {
			 String loginUserEmail, loginUserPassword;
             loginUserEmail = vl.getTfEmail().getText();
             loginUserPassword = vl.getPfPassword().getText();

             vl.getAlertLogin().setTitle("Login Failed");
             vl.getAlertLogin().setContentText("");

             if(loginUserEmail.isEmpty()){
                 vl.getAlertLogin().setHeaderText("Email must be filled");
                 vl.getAlertLogin().show();
             }else if(loginUserPassword.isEmpty()){
                 vl.getAlertLogin().setHeaderText("Password must be filled");
                 vl.getAlertLogin().show();
             }else{
            	 
            	 User user = new User(0, "", loginUserEmail, loginUserPassword, "", "");
            	 Company company = new Company(0, "", loginUserEmail, loginUserPassword, "" , "");
            	 Student student = new Student(0, "", loginUserEmail, loginUserPassword, "", "");
            	 Staff staff = new Staff(0, "", loginUserEmail, loginUserPassword, null);
            	 
            	 int acc = -1;
            	 
            	 
                 if(user.login() != null) {
                	 
					 user = (User)user.login();
					 acc = 0;
					
					 Main.currModel = user;
				 }else if(company.login() != null) {

					 company = (Company)company.login();
					 acc = 1;
					 Main.currModel = company;
				 }else if(student.login() != null) {
					 student = (Student)student.login();
					 acc = 2;
					 Main.currModel = student;
				 }else if(staff.login() != null) {
					 staff = (Staff)staff.login();
					 acc = 3;
					 Main.currModel = staff;
				 }
                 
                 Main.currAccount = acc;
        
                 if(acc != -1){
                     //Correct Login
                     Logger.log("Auth","Login Successful!");
                     Main.getInstance().openHome();
                 }else if(acc == -1){
                     //Incorrect Login
                     Logger.log("Auth","Login attempt failed");
                     vl.getAlertLogin().setHeaderText("Incorrect Email / Password Combination");
                     vl.getAlertLogin().show();
                 }
             }
		});
		
		vl.getBtnRegister().setOnAction(e -> {
			Main.getInstance().openRegister();
		});
	}

	public void clearAllField() {
		vl.getTfEmail().setText("");
		vl.getPfPassword().setText("");
	}


}
