package views.frames;

import java.sql.Timestamp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ApplicationListItem extends HBox{
	private VBox applicationDetailContainer, buttonContainer;
	private Label jobNameLabel, jobSalaryLabel,cvApplicationDateLabel;
	private Button removeButton, viewButton;

	public ApplicationListItem(String jobName, double jobSalary, String jobDesc, Timestamp cvApplicationDate) {
		// TODO Auto-generated constructor stub
		applicationDetailContainer = new VBox();
		jobNameLabel = new Label("Job Name: " + jobName);
		jobSalaryLabel = new Label("Job Salary: " + jobSalary);
		String timeFormat = cvApplicationDate.getDate() + "" + "-" + (cvApplicationDate.getMonth()+1) + "" + "-" +(cvApplicationDate.getYear()+1900)+"";
		cvApplicationDateLabel = new Label("App Date: "+timeFormat);
		removeButton = new Button("Remove");
		buttonContainer = new VBox();
		viewButton = new Button("View");
		
		
		setElements();
	}
	
	public void setElements() {
		this.setStyle("-fx-background-color: #393939; -fx-background-radius: 8px;");
		this.setPadding(new Insets(9, 9, 9, 0));
		this.setAlignment(Pos.CENTER_LEFT);
		this.setMaxWidth(350);
	
		
		applicationDetailContainer.setSpacing(5);
		applicationDetailContainer.setMaxWidth(285);
		applicationDetailContainer.setMinWidth(285);
		
		jobNameLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		jobNameLabel.setTextFill(Color.WHITE);
		
		jobSalaryLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		jobSalaryLabel.setTextFill(Color.WHITE);
		
		cvApplicationDateLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		cvApplicationDateLabel.setTextFill(Color.WHITE);
		
		removeButton.setStyle("-fx-background-color: #FF5C5C");
		removeButton.setTextFill(Color.WHITE);
		
		viewButton.setStyle("-fx-background-color: #4267B2");
		viewButton.setMinWidth(60);
		viewButton.setTextFill(Color.WHITE);
		
		buttonContainer.getChildren().addAll(viewButton, removeButton);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(8);
		
		applicationDetailContainer.getChildren().addAll(jobNameLabel, jobSalaryLabel, cvApplicationDateLabel);
		this.getChildren().addAll(applicationDetailContainer, buttonContainer);
		
	}

	public VBox getApplicationDetailContainer() {
		return applicationDetailContainer;
	}

	public void setApplicationDetailContainer(VBox applicationDetailContainer) {
		this.applicationDetailContainer = applicationDetailContainer;
	}

	public Label getJobNameLabel() {
		return jobNameLabel;
	}

	public void setJobNameLabel(Label jobNameLabel) {
		this.jobNameLabel = jobNameLabel;
	}

	public Label getJobSalaryLabel() {
		return jobSalaryLabel;
	}

	public void setJobSalaryLabel(Label jobSalaryLabel) {
		this.jobSalaryLabel = jobSalaryLabel;
	}

	public Label getCvApplicationDateLabel() {
		return cvApplicationDateLabel;
	}

	public void setCvApplicationDateLabel(Label cvApplicationDateLabel) {
		this.cvApplicationDateLabel = cvApplicationDateLabel;
	}

	public Button getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(Button removeButton) {
		this.removeButton = removeButton;
	}

	public VBox getButtonContainer() {
		return buttonContainer;
	}

	public void setButtonContainer(VBox buttonContainer) {
		this.buttonContainer = buttonContainer;
	}

	public Button getViewButton() {
		return viewButton;
	}

	public void setViewButton(Button viewButton) {
		this.viewButton = viewButton;
	}
	
	
	
	
	

}
