package views.frames;

import java.sql.Timestamp;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;

public class PopUpCompanyManagedJobDetail extends VBox{

	
	private final Label jobDetailTitleLabel, jobNameLabel, jobDescriptionLabel, jobSalaryLabel;
	private final Button closeButton, updateButton;
	private final VBox jobDetailContainer;
	private final Separator separator;
	private final TextField textField;
	private final HBox buttonContainer;
	
	private final String jobDesc;
	public PopUpCompanyManagedJobDetail(String jobName, String jobDesc, double jobSalary) {
		this.jobNameLabel = new Label("Job Name: "+jobName);
		this.jobDescriptionLabel = new Label("Job Description");
		this.jobSalaryLabel = new Label("Job Salary: "+(jobSalary+""));
		this.jobDetailTitleLabel = new Label("Job Detail");
		this.jobDetailContainer = new VBox();
		this.closeButton = new Button("Back to dashboard");
		this.separator = new Separator();
		this.textField = new TextField();
		this.updateButton = new Button("Update");
		this.buttonContainer = new HBox();
		
		this.jobDesc = jobDesc;
		setElements();
	}
	
	public void setElements() {
		jobDetailTitleLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
     	jobDetailTitleLabel.setTextFill(Color.WHITE);
     	
     	jobNameLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	jobNameLabel.setTextFill(Color.WHITE);
     	
    	jobDescriptionLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,15));
     	jobDescriptionLabel.setTextFill(Color.LIGHTGREY);
     	
     	
     	jobSalaryLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	jobSalaryLabel.setTextFill(Color.WHITE);
     	
     
     	
     	closeButton.setStyle("-fx-background-color: #FF5C5C");
		closeButton.setTextFill(Color.WHITE);
		
		updateButton.setStyle("-fx-background-color: #4267B2");
		updateButton.setTextFill(Color.WHITE);
		
		separator.setOrientation(Orientation.HORIZONTAL);
		separator.setPadding(new Insets(0, 20, 0, 20));


		jobDetailContainer.setAlignment(Pos.TOP_LEFT);
     	jobDetailContainer.getChildren().addAll(jobNameLabel, jobSalaryLabel, jobDescriptionLabel, textField);
		jobDetailContainer.setMaxWidth(370);
		
		jobDetailContainer.setSpacing(10);
     	
		textField.setMinHeight(200);
     	textField.setAlignment(Pos.TOP_LEFT);
     	textField.setText(jobDesc);
     	
     	buttonContainer.getChildren().addAll(updateButton, closeButton);
     	buttonContainer.setSpacing(10);
     	buttonContainer.setAlignment(Pos.CENTER);
     	
     	
     	
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setMaxWidth(600);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-background-color: #585454; -fx-border-radius: 10px; -fx-background-radius: 10px");
		
		this.getChildren().addAll(jobDetailTitleLabel,separator, jobDetailContainer,   buttonContainer);
		
	}

	public Label getJobNameLabel() {
		return jobNameLabel;
	}

	public Label getJobDescriptionLabel() {
		return jobDescriptionLabel;
	}

	public Label getJobSalaryLabel() {
		return jobSalaryLabel;
	}

	

	public Label getYouAreApplyingLabel() {
		return jobDetailTitleLabel;
	}



	public Button getCloseButton() {
		return closeButton;
	}

	public Label getJobDetailTitleLabel() {
		return jobDetailTitleLabel;
	}

	public Button getUpdateButton() {
		return updateButton;
	}

	public VBox getJobDetailContainer() {
		return jobDetailContainer;
	}

	public Separator getSeparator() {
		return separator;
	}

	public TextField getTextField() {
		return textField;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public String getJobDesc() {
		return jobDesc;
	}
	
	
	
}


