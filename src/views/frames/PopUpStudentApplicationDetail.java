package views.frames;

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

public class PopUpStudentApplicationDetail extends VBox{

	private final Label applicationDetailLabel, jobNameLabel, applicantNameLabel, applicantPhoneLabel, applicantEmailLabel, cvDescLabel, transcriptDescLabel, cvDescTitleLabel, transcriptDescTitleLabel, internshipNameLabel, internshipDescLabel;
	private final Separator separator;
	private final VBox cvField, cvDescBox, transcriptDescBox;
	private final Button closeButton;

	

	public PopUpStudentApplicationDetail(String jobName, String applicantName, String applicantPhone,  String applicantEmail, String cvDesc, String transcriptDesc, String internshipName, String internshipDesc) {
		this.jobNameLabel = new Label("Applying internship as: "+jobName);
		this.applicantNameLabel = new Label("Applicant Name: "+applicantName);
		this.applicantPhoneLabel = new Label("Applicant Phone: "+applicantPhone);
		this.applicantEmailLabel = new Label("Applicant Email: "+applicantEmail);
		this.cvDescLabel = new Label(cvDesc);
		this.transcriptDescLabel = new Label(transcriptDesc);
		this.applicationDetailLabel = new Label("Application Detail");
		this.separator = new Separator();
		this.transcriptDescTitleLabel = new Label("Transcript Description: ");
		this.cvDescTitleLabel = new Label("CV Description: ");
		this.cvField = new VBox();
		this.closeButton = new Button("Back to dashboard");
		this.internshipNameLabel = new Label("Internship Name: "+internshipName);
		this.internshipDescLabel = new Label("Internship Desc: "+internshipDesc);
		
		this.cvDescBox = new VBox();
		this.transcriptDescBox = new VBox();
	
		
		setElements();
	}
	
	public void setElements() {
		applicationDetailLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
     	applicationDetailLabel.setTextFill(Color.WHITE);
     	
     	jobNameLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	jobNameLabel.setTextFill(Color.WHITE);
     	
     	internshipNameLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	internshipNameLabel.setTextFill(Color.WHITE);
     	
     	internshipDescLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	internshipDescLabel.setTextFill(Color.WHITE);
     	
    	applicantNameLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,15));
     	applicantNameLabel.setTextFill(Color.LIGHTGREY);
     	
     	
     	applicantPhoneLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	applicantPhoneLabel.setTextFill(Color.WHITE);
     	
     	separator.setOrientation(Orientation.HORIZONTAL);
     	separator.setPadding(new Insets(0, 150, 0, 150));
     	
     	applicantEmailLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	applicantEmailLabel.setTextFill(Color.WHITE);
     	
     	cvDescTitleLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	cvDescTitleLabel.setTextFill(Color.WHITE);
     	
     	transcriptDescTitleLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	transcriptDescTitleLabel.setTextFill(Color.WHITE);
     	
     	cvDescLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
     	cvDescLabel.setTextFill(Color.LIGHTGREY);
     	
     	transcriptDescLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
     	transcriptDescLabel.setTextFill(Color.LIGHTGREY);
     	
     	closeButton.setStyle("-fx-background-color: #4267B2");
		closeButton.setTextFill(Color.WHITE);
     	
     	cvDescBox.getChildren().add(cvDescLabel);
     	cvDescBox.setPadding(new Insets(7, 7, 7, 7));
     	cvDescBox.setMaxWidth(400);
     	cvDescBox.setStyle("-fx-background-color:  #696565; -fx-background-radius: 5px;");
     	cvDescLabel.setMaxWidth(400);
     	
     	transcriptDescBox.getChildren().add(transcriptDescLabel);
     	transcriptDescBox.setPadding(new Insets(7, 7, 7, 7));
     	transcriptDescBox.setMaxWidth(400);
     	transcriptDescBox.setStyle("-fx-background-color:  #696565; -fx-background-radius: 5px;");
     	transcriptDescLabel.setMaxWidth(400);
     	
     	cvField.setAlignment(Pos.CENTER);
     	cvField.getChildren().addAll(cvDescTitleLabel, cvDescBox, transcriptDescTitleLabel, transcriptDescBox);
		cvField.setMaxWidth(400);
			
		cvField.setSpacing(10);
     	
     
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setMaxWidth(Main.DEFAULT_WIDTH-150);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-background-color: #585454; -fx-border-radius: 10px; -fx-background-radius: 10px");
		
		this.getChildren().addAll(applicationDetailLabel, separator, jobNameLabel, internshipNameLabel, internshipDescLabel, applicantNameLabel, applicantPhoneLabel, cvField, closeButton);
		
	}

	public Label getApplicationDetailLabel() {
		return applicationDetailLabel;
	}

	public Label getJobNameLabel() {
		return jobNameLabel;
	}

	public Label getApplicantNameLabel() {
		return applicantNameLabel;
	}

	public Label getApplicantPhoneLabel() {
		return applicantPhoneLabel;
	}

	public Label getApplicantEmailLabel() {
		return applicantEmailLabel;
	}

	public Label getCvDescLabel() {
		return cvDescLabel;
	}

	public Label getTranscriptDescLabel() {
		return transcriptDescLabel;
	}

	public Label getCvDescTitleLabel() {
		return cvDescTitleLabel;
	}

	public Label getTranscriptDescTitleLabel() {
		return transcriptDescTitleLabel;
	}

	public Label getInternshipNameLabel() {
		return internshipNameLabel;
	}

	public Label getInternshipDescLabel() {
		return internshipDescLabel;
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
