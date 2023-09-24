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

public class WishListItem extends HBox{
		private VBox jobDetailContainer, buttonContainer;
		private Label jobNameLabel, jobSalaryLabel, jobDescLabel;
		private Button removeButton, viewButton;

	public WishListItem(String jobName, double jobSalary, String jobDesc) {
		jobDetailContainer = new VBox();
		jobNameLabel = new Label("Job Name: " + jobName);
		jobSalaryLabel = new Label("Job Salary: " + jobSalary);
		jobDescLabel = new Label("Job Desc: "+jobDesc);
		removeButton = new Button("Remove");
		viewButton = new Button("View");
		
		buttonContainer = new VBox();
		
		
		setElements();
		
		
		// TODO Auto-generated constructor stub
	}

	
	public void setElements() {
		this.setStyle("-fx-background-color: #393939; -fx-background-radius: 8px;");
		this.setPadding(new Insets(9, 9, 9, 0));
		this.setAlignment(Pos.CENTER_LEFT);
		this.setMaxWidth(350);
		
		
		jobDetailContainer.setSpacing(5);
		jobDetailContainer.setMaxWidth(285);
		jobDetailContainer.setMinWidth(285);
	
		jobNameLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		jobNameLabel.setTextFill(Color.WHITE);
		
		jobSalaryLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		jobSalaryLabel.setTextFill(Color.WHITE);
		
		jobDescLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		jobDescLabel.setTextFill(Color.WHITE);
		
		removeButton.setStyle("-fx-background-color: #FF5C5C");
		removeButton.setTextFill(Color.WHITE);
		
		viewButton.setStyle("-fx-background-color: #4267B2");
		viewButton.setMinWidth(60);
		viewButton.setTextFill(Color.WHITE);
		
		
		
		buttonContainer.getChildren().addAll(viewButton, removeButton);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(8);
		
	
		
		this.getChildren().addAll(jobDetailContainer, buttonContainer);
		jobDetailContainer.getChildren().addAll(jobNameLabel, jobSalaryLabel, jobDescLabel);
		
		
	}

	public VBox getJobDetailContainer() {
		return jobDetailContainer;
	}

	public void setJobDetailContainer(VBox jobDetailContainer) {
		this.jobDetailContainer = jobDetailContainer;
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

	public Label getJobDescLabel() {
		return jobDescLabel;
	}

	public void setJobDescLabel(Label jobDescLabel) {
		this.jobDescLabel = jobDescLabel;
	}

	public Button getRemoveButton() {
		return removeButton;
	}

	public void setRemoveButton(Button removeButton) {
		this.removeButton = removeButton;
	}


	public Button getViewButton() {
		return viewButton;
	}


	public void setViewButton(Button viewButton) {
		this.viewButton = viewButton;
	}
	
	
	
	
	
	

}
