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

public class CompanyJobListItem extends HBox{

	VBox jobDetail;
	HBox buttonContainer;
	Label jobName, companyName, jobDescription, jobSalary;
	Button viewButton, removeButton, openInternshipButton, closeInternshipButton;
	
	

	public CompanyJobListItem(String jobName, String companyName, String jobDesc, double jobSalary) {
		jobDetail = new VBox();
		this.jobName = new Label("Job Name: "+jobName);
		this.companyName = new Label("Company Name: "+companyName);
		this.jobDescription = new Label("Job Desc: "+jobDesc);
		this.jobSalary = new Label("Job Salary: "+(jobSalary+""));
		this.viewButton = new Button("View");
		this.removeButton= new Button("Remove");
		this.buttonContainer = new HBox();
		this.openInternshipButton = new Button("Open Internship");
		this.closeInternshipButton = new Button("Close Internship");
		
		
		setElements();
	}
	
	public void setElements() {
		
		jobDetail.setMinWidth(480);
		jobDetail.setMaxWidth(480);
		buttonContainer.setSpacing(9);
		
		jobName.setTextFill(Color.WHITE);
		jobName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,17));
		
		companyName.setTextFill(Color.LIGHTGREY);
		companyName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));

		jobDescription.setTextFill(Color.LIGHTGREY);
		jobDescription.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));
		
		jobSalary.setTextFill(Color.WHITE);
		jobSalary.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
		buttonContainer.setAlignment(Pos.CENTER);
		
		openInternshipButton.setTextFill(Color.WHITE);
		openInternshipButton.setStyle("-fx-background-color: #FF8C00");
		
		closeInternshipButton.setTextFill(Color.WHITE);
		closeInternshipButton.setStyle("-fx-background-color: #D2691E");
		
		jobDetail.getChildren().addAll(jobName, companyName, jobDescription, jobSalary);
		
		
		
	
		
		
		viewButton.setStyle("-fx-background-color: #4267B2");
		viewButton.setTextFill(Color.WHITE);
		removeButton.setStyle("-fx-background-color: #FF5C5C");
		removeButton.setTextFill(Color.WHITE);
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

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public void setButtonContainer(HBox buttonContainer) {
		this.buttonContainer = buttonContainer;
	}

	public Button getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(Button removeButton) {
		this.removeButton = removeButton;
	}

	public Button getOpenInternshipButton() {
		return openInternshipButton;
	}

	public void setOpenInternshipButton(Button openInternshipButton) {
		this.openInternshipButton = openInternshipButton;
	}

	public Button getCloseInternshipButton() {
		return closeInternshipButton;
	}

	public void setCloseInternshipButton(Button closeInternshipButton) {
		this.closeInternshipButton = closeInternshipButton;
	}
	
	
	

	
}
