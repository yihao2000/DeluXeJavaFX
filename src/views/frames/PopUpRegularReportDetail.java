package views.frames;

import java.sql.Timestamp;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;

public class PopUpRegularReportDetail extends VBox{
	private final Label youAreApplyingLabel, jobNameLabel, jobDescriptionLabel, jobSalaryLabel, applicationDateLabel, cvDescLabel, transcriptDescLabel;
	private final Separator separator;
	private final VBox cvField;
	private final Button closeButton;

	

	public PopUpRegularReportDetail(String jobName, String jobDesc, double jobSalary, Timestamp applicationDate, String cvDesc, String transcriptDesc) {
		String applicationDateFormat = (applicationDate.getDate()+"") + "-" +((applicationDate.getMonth()+1)+"") + "-" + ((applicationDate.getYear()+1900)+"");
		this.jobNameLabel = new Label(jobName);
		this.jobDescriptionLabel = new Label(jobDesc);
		this.jobSalaryLabel = new Label(jobSalary+"");
		this.applicationDateLabel = new Label("Applied on: "+applicationDateFormat);
		this.cvDescLabel = new Label("CV Description: "+cvDesc);
		this.transcriptDescLabel = new Label("Transcript Description: "+transcriptDesc);
		this.youAreApplyingLabel = new Label("Report Detail: ");
		this.separator = new Separator();
		this.cvField = new VBox();
		this.closeButton = new Button("Back to dashboard");
	
		
		setElements();
	}
	
	public void setElements() {
		youAreApplyingLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
     	youAreApplyingLabel.setTextFill(Color.WHITE);
     	
     	jobNameLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	jobNameLabel.setTextFill(Color.WHITE);
     	
    	jobDescriptionLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,15));
     	jobDescriptionLabel.setTextFill(Color.LIGHTGREY);
     	
     	
     	jobSalaryLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	jobSalaryLabel.setTextFill(Color.WHITE);
     	
     	separator.setOrientation(Orientation.HORIZONTAL);
     	separator.setPadding(new Insets(0, 150, 0, 150));
     	
     	applicationDateLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	applicationDateLabel.setTextFill(Color.WHITE);
     	
     	cvDescLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	cvDescLabel.setTextFill(Color.WHITE);
     	
     	transcriptDescLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	transcriptDescLabel.setTextFill(Color.WHITE);
     	
     	closeButton.setStyle("-fx-background-color: #4267B2");
		closeButton.setTextFill(Color.WHITE);
     	
     	
     	
     	
     	cvField.setAlignment(Pos.CENTER);
     	cvField.getChildren().addAll(applicationDateLabel, cvDescLabel, transcriptDescLabel);
		cvField.setMaxWidth(370);
		
		cvField.setSpacing(10);
     	
     
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setMaxWidth(Main.DEFAULT_WIDTH-150);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-background-color: #585454; -fx-border-radius: 10px; -fx-background-radius: 10px");
		
		this.getChildren().addAll(youAreApplyingLabel, jobNameLabel, jobDescriptionLabel, jobSalaryLabel, separator, cvField, closeButton);
		
	}

	public Label getYouAreApplyingLabel() {
		return youAreApplyingLabel;
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

	public Label getApplicationDateLabel() {
		return applicationDateLabel;
	}

	public Label getCvDescLabel() {
		return cvDescLabel;
	}

	public Label getTranscriptDescLabel() {
		return transcriptDescLabel;
	}

	public Separator getSeparator() {
		return separator;
	}

	public VBox getCvField() {
		return cvField;
	}

	public Button getCloseButton() {
		return closeButton;
	}
	
	
	

}
