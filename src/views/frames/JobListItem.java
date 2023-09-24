package views.frames;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JobListItem extends HBox{
	VBox jobDetail;
	HBox buttonContainer;
	Label jobName, companyName, jobDescription, jobSalary;
	Button viewButton, applyButton, wishListButton;
	
	

	public JobListItem(String jobName, String companyName, String jobDesc, double jobSalary) {
		jobDetail = new VBox();
		this.jobName = new Label("Job Name: "+jobName);
		this.companyName = new Label("Company Name: "+companyName);
		this.jobDescription = new Label("Job Desc: "+jobDesc);
		this.jobSalary = new Label("Job Salary: "+(jobSalary+""));
		this.viewButton = new Button("View");
		this.applyButton= new Button("Apply");
		this.wishListButton = new Button("Add to Wishlist!");
		this.buttonContainer = new HBox();
		
		
		setElements();
	}
	
	public void setElements() {
		
		jobDetail.setMinWidth(530);
		buttonContainer.setSpacing(5);
		
		jobName.setTextFill(Color.WHITE);
		jobName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,17));
		
		companyName.setTextFill(Color.LIGHTGREY);
		companyName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));

		jobDescription.setTextFill(Color.LIGHTGREY);
		jobDescription.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));
		
		jobSalary.setTextFill(Color.WHITE);
		jobSalary.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
		buttonContainer.setAlignment(Pos.CENTER);
		
		jobDetail.getChildren().addAll(jobName, companyName, jobDescription, jobSalary);
		buttonContainer.getChildren().addAll(viewButton, applyButton, wishListButton);
		
		
		viewButton.setStyle("-fx-background-color: #4267B2");
		viewButton.setTextFill(Color.WHITE);
		
		applyButton.setStyle("-fx-background-color: #5DBB63");
		applyButton.setTextFill(Color.WHITE);
		
		wishListButton.setStyle("-fx-background-color: #FFB347");
		wishListButton.setTextFill(Color.WHITE);
		
		this.getChildren().addAll(jobDetail, buttonContainer);
		this.setPadding(new Insets(9, 9,9,9));
		this.setAlignment(Pos.CENTER_LEFT);
		this.setStyle("-fx-background-color: #393939; -fx-background-radius: 10px;");
	}

	public VBox getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(VBox jobDetail) {
		this.jobDetail = jobDetail;
	}

	public Label getJobName() {
		return jobName;
	}

	public void setJobName(Label jobName) {
		this.jobName = jobName;
	}

	public Label getCompanyName() {
		return companyName;
	}

	public void setCompanyName(Label companyName) {
		this.companyName = companyName;
	}

	public Label getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(Label jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Label getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(Label jobSalary) {
		this.jobSalary = jobSalary;
	}

	public Button getViewButton() {
		return viewButton;
	}

	public void setViewButton(Button viewButton) {
		this.viewButton = viewButton;
	}

	public Button getApplyButton() {
		return applyButton;
	}

	public void setApplyButton(Button applyButton) {
		this.applyButton = applyButton;
	}

	public Button getWishListButton() {
		return wishListButton;
	}

	public void setWishListButton(Button wishListButton) {
		this.wishListButton = wishListButton;
	}
	
	
	

}
