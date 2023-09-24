package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import main.Main;
import models.Company;
import models.Student;
import models.User;
import views.View;
import views.ViewRegister;

public class ControllerRegister extends ViewController{
	private final ViewRegister vr;
	private ArrayList<String> errorsList;
		

	public ControllerRegister(View view) {
		// TODO Auto-generated constructor stub
		super(view);
		errorsList = new ArrayList<>();
		
		vr = (ViewRegister)view;
		
		vr.getCbAcc().valueProperty().addListener((observable, oldVal, newVal) -> {
			vr.getLbRole().setText("Register As "+newVal);
		});
		
		vr.getBtnRegister().setOnAction(e -> {
			regUser();
		});
		populateAccountTypes();
		
		vr.getBtnLogin().setOnAction(e -> {
			Main.getInstance().openLogin();
		});
	}
	
	public void regUser(){
        String email, name, phone, address, password, confirmPass, role = null;
        email = vr.getTfEmail().getText();
        name = vr.getTfName().getText();
        phone = vr.getTfPhone().getText();
        address = vr.getTfAddress().getText();
        password = vr.getPfPassword().getText();
        confirmPass = vr.getPfConfPassword().getText();
        role = vr.getCbAcc().getValue();
        if(validateFields(role, name, email, address, phone, password, confirmPass)){
            try {
                if(role.equals("Regular User")){
                    User u = new User(0, name, email, password, phone, address);
                    u.register();
                }else if (role.equals("Company")){
                    Company c = new Company(0, name, email, password, phone, address);
                    c.register();
                }else if (role.equals("College Student")){
                    Student s = new Student(0, name, email, password, phone, address);
                    s.register();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Main.getInstance().openLogin();
        }
    }
	
	
	
	public boolean validateFields(String role, String name, String email, String address, String phone, String password, String confirmPassword){
        boolean flag = true;
        if(role == null || role.isBlank()){
            errorsList.add("You must choose the account type");
            flag = false;
            showErrors();
        }else if(name == null || name.isBlank()){
            errorsList.add("Name must be filled");
            flag = false;
            showErrors();
        }else if(email == null || email.isBlank()){
            errorsList.add("Email must be filled");
            flag = false;
            showErrors();
        }else if(password == null || password.isBlank()) {
            errorsList.add("Password must be filled");
            flag = false;
            showErrors();
        }else if(confirmPassword == null || confirmPassword.isBlank() || !confirmPassword.equals(password)){
            errorsList.add("Passwords don't match");
            flag = false;
            showErrors();
        }else if(address == null || address.isBlank()){
            errorsList.add("Address must be filled");
            flag = false;
            showErrors();
        }else if(phone == null || phone.isBlank()){
            errorsList.add("Phone Number must be filled");
            flag = false;
            showErrors();
        }
        return flag;
    }
	
	public void showErrors(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Failed to create account");
        a.setHeaderText("Account registration failed for the following reasons");
        StringBuilder errorListStr = new StringBuilder();

        for(String err : errorsList){
            errorListStr.append(err);
            errorListStr.append("\n");
        }
        a.setContentText(errorListStr.toString());
        a.show();
        errorsList.clear();
    }
	
	
	
	public void populateAccountTypes() {
		ComboBox<String> cb = vr.getCbAcc();
		cb.getItems().clear();
		cb.getItems().addAll("Regular User", "Company", "College Student");
		
	}
	
	public void clearAllField() {
		vr.getTfEmail().setText("");
		vr.getPfPassword().setText("");
		vr.getTfAddress().setText("");
		vr.getTfPhone().setText("");
		vr.getTfName().setText("");
		vr.getPfConfPassword().setText("");
	}

}
