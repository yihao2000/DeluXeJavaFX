package views.frames;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import views.View;

public class SideCardContent extends VBox{
	private Button dashboardButton, findJobButton, companyJobButton, companyAdvertisementButton, companyApplicantButton, studentDashboardButton, viewReportButton;
	private String st1;
	
	public SideCardContent() {
		// TODO Auto-generated constructor stub
		dashboardButton = new Button("Dashboard");
		findJobButton = new Button("Find new Job");
		companyJobButton = new Button("View All Job");
		companyAdvertisementButton = new Button("Manage Advertisement");
		companyApplicantButton = new Button("Manage Applicant");
		studentDashboardButton = new Button("Dashboard");
		viewReportButton = new Button("View Report");
		
		setElements();
	}
	
	public void setElements() {
//		     
		 this.setSpacing(5);
		 dashboardButton.setPrefHeight(35);
	     dashboardButton.setPrefWidth(200);
	     dashboardButton.setStyle("-fx-background-color: #6d706a; -fx-text-fill: #AAAAAA;");
	     dashboardButton.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     st1 = dashboardButton.getStyle();
	     dashboardButton.setOnMouseEntered(e -> dashboardButton.setStyle(View.HOVERED_BUTTON_STYLE));
	     dashboardButton.setOnMouseExited(e -> dashboardButton.setStyle(st1));
	     
	     

	     
	     findJobButton.setPrefHeight(35);
	     findJobButton.setPrefWidth(200);
	     findJobButton.setStyle("-fx-background-color: #6d706a; -fx-text-fill: #AAAAAA;");
	     findJobButton.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     findJobButton.setOnMouseEntered(e -> findJobButton.setStyle(View.HOVERED_BUTTON_STYLE));
	     findJobButton.setOnMouseExited(e -> findJobButton.setStyle(st1));
	    
	     companyJobButton.setPrefHeight(35);
	     companyJobButton.setPrefWidth(200);
	     companyJobButton.setStyle("-fx-background-color: #6d706a; -fx-text-fill: #AAAAAA;");
	     companyJobButton.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     companyJobButton.setOnMouseEntered(e -> companyJobButton.setStyle(View.HOVERED_BUTTON_STYLE));
	     companyJobButton.setOnMouseExited(e -> companyJobButton.setStyle(st1));
	     
	     
	     companyAdvertisementButton.setPrefHeight(35);
	     companyAdvertisementButton.setPrefWidth(200);
	     companyAdvertisementButton.setStyle("-fx-background-color: #6d706a; -fx-text-fill: #AAAAAA;");
	     companyAdvertisementButton.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     companyAdvertisementButton.setOnMouseEntered(e -> companyAdvertisementButton.setStyle(View.HOVERED_BUTTON_STYLE));
	     companyAdvertisementButton.setOnMouseExited(e -> companyAdvertisementButton.setStyle(st1));
	     
	     
	     companyApplicantButton.setPrefHeight(35);
	     companyApplicantButton.setPrefWidth(200);
	     companyApplicantButton.setStyle("-fx-background-color: #6d706a; -fx-text-fill: #AAAAAA;");
	     companyApplicantButton.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     companyApplicantButton.setOnMouseEntered(e -> companyApplicantButton.setStyle(View.HOVERED_BUTTON_STYLE));
	     companyApplicantButton.setOnMouseExited(e -> companyApplicantButton.setStyle(st1));
		
	     
	     studentDashboardButton.setPrefHeight(35);
	     studentDashboardButton.setPrefWidth(200);
	     studentDashboardButton.setStyle("-fx-background-color: #6d706a; -fx-text-fill: #AAAAAA;");
	     studentDashboardButton.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     st1 = studentDashboardButton.getStyle();
	     studentDashboardButton.setOnMouseEntered(e -> studentDashboardButton.setStyle(View.HOVERED_BUTTON_STYLE));
	     studentDashboardButton.setOnMouseExited(e -> studentDashboardButton.setStyle(st1));
	     
	     viewReportButton.setPrefHeight(35);
	     viewReportButton.setPrefWidth(200);
	     viewReportButton.setStyle("-fx-background-color: #6d706a; -fx-text-fill: #AAAAAA;");
	     viewReportButton.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     st1 = viewReportButton.getStyle();
	     viewReportButton.setOnMouseEntered(e -> viewReportButton.setStyle(View.HOVERED_BUTTON_STYLE));
	     viewReportButton.setOnMouseExited(e -> viewReportButton.setStyle(st1));
	     
//		this.getChildren().addAll(dashboardButton, findJobButton);
	}

	public Button getDashboardButton() {
		return dashboardButton;
	}

	public void setDashboardButton(Button dashboardButton) {
		this.dashboardButton = dashboardButton;
	}

	public Button getFindJobButton() {
		return findJobButton;
	}

	public void setFindJobButton(Button findJobButton) {
		this.findJobButton = findJobButton;
	}

	public String getSt1() {
		return st1;
	}

	public void setSt1(String st1) {
		this.st1 = st1;
	}

	public Button getCompanyJobButton() {
		return companyJobButton;
	}

	public void setCompanyJobButton(Button companyJobButton) {
		this.companyJobButton = companyJobButton;
	}

	public Button getCompanyAdvertisementButton() {
		return companyAdvertisementButton;
	}

	public void setCompanyAdvertisementButton(Button companyAdvertisementButton) {
		this.companyAdvertisementButton = companyAdvertisementButton;
	}

	public Button getCompanyApplicantButton() {
		return companyApplicantButton;
	}

	public void setCompanyApplicantButton(Button companyApplicantButton) {
		this.companyApplicantButton = companyApplicantButton;
	}

	public Button getStudentDashboardButton() {
		return studentDashboardButton;
	}

	public void setStudentDashboardButton(Button studentDashboardButton) {
		this.studentDashboardButton = studentDashboardButton;
	}

	public Button getViewReportButton() {
		return viewReportButton;
	}

	public void setViewReportButton(Button viewReportButton) {
		this.viewReportButton = viewReportButton;
	}
	
	
	
	
	

}
