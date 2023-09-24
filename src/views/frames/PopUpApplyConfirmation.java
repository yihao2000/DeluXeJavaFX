package views.frames;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
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
import models.Company;
import models.Job;

public class PopUpApplyConfirmation extends VBox{
	private final Label jobNameLabel, jobDescLabel, jobSalaryLabel, companyNameLabel, youLabel, cvTitleLabel, cvDescLabel, pleaseFillLabel;
	private final HBox buttonContainer;
	private final Button closeButton, applyButton;
	private final VBox cvField;
	private final TextField tfCvDesc, tfTranscriptDesc;
	private Job job;
	private final Separator separator;
	private Company company;
	private Alert alert;
	
	
	
	public PopUpApplyConfirmation(Job job, Company company) {
		this.jobNameLabel = new Label(job.getName());
		this.jobDescLabel = new Label(job.getDescription());
		this.jobSalaryLabel = new Label("$"+(job.getSalary()+"")+"/year");
		this.companyNameLabel = new Label(company.getName());
		this.job = job;
		this.company = company;
		this.youLabel = new Label("You are going to apply as: ");
		this.cvField = new VBox();
		this.cvTitleLabel = new Label("CV Title");
		this.cvDescLabel = new Label("CV Description");
		this.tfCvDesc = new TextField();
		this.tfTranscriptDesc = new TextField();
		this.pleaseFillLabel = new Label("Please fill the CV below !");
		this.separator = new Separator();
		this.applyButton = new Button("Apply");
		
		alert = new Alert(Alert.AlertType.ERROR);
		

		
		
		buttonContainer = new HBox();
		
		this.closeButton = new Button("Close");
		
		setElements();
	}
	
	public void setElements() {
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setMaxWidth(Main.DEFAULT_WIDTH-150);
		this.setMinHeight(500);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-background-color: #585454; -fx-border-radius: 10px; -fx-background-radius: 10px");
		
		
		youLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
     	youLabel.setTextFill(Color.WHITE);
		
		jobNameLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	jobNameLabel.setTextFill(Color.WHITE);
     	
     	jobDescLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,15));
     	jobDescLabel.setTextFill(Color.LIGHTGREY);
     	
     	
     	jobSalaryLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	jobSalaryLabel.setTextFill(Color.WHITE);
     	
     	companyNameLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	companyNameLabel.setTextFill(Color.WHITE);
     	
     	jobSalaryLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	jobSalaryLabel.setTextFill(Color.WHITE);
     	
     	cvTitleLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	cvTitleLabel.setTextFill(Color.WHITE);
     	
     	cvDescLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	cvDescLabel.setTextFill(Color.WHITE);
     	
     	pleaseFillLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	pleaseFillLabel.setTextFill(Color.WHITE);
     	
     	separator.setOrientation(Orientation.HORIZONTAL);
     	separator.prefWidth(250);
     	separator.setPadding(new Insets(0, 150, 0, 150));
     	
     	applyButton.setStyle("-fx-background-color: #5DBB63");
		applyButton.setTextFill(Color.WHITE);
		
		closeButton.setStyle("-fx-background-color: #FF5C5C");
		closeButton.setTextFill(Color.WHITE);
		
		
		
     	
		buttonContainer.getChildren().addAll(applyButton, closeButton);
		buttonContainer.setSpacing(10);
		buttonContainer.setAlignment(Pos.CENTER);
		cvField.getChildren().addAll(pleaseFillLabel, cvTitleLabel,tfCvDesc, cvDescLabel, tfTranscriptDesc);
		cvField.setMaxWidth(370);
		
		cvField.setSpacing(10);
		
		tfCvDesc.setMinHeight(120);
		tfCvDesc.setAlignment(Pos.TOP_LEFT);
		tfTranscriptDesc.setMinHeight(120);
		tfTranscriptDesc.setAlignment(Pos.TOP_LEFT);
		
		this.getChildren().addAll(youLabel, jobNameLabel, jobDescLabel, jobSalaryLabel, separator, cvField,buttonContainer);
	}

	public Label getJobNameLabel() {
		return jobNameLabel;
	}

	public Label getJobDescLabel() {
		return jobDescLabel;
	}

	public Label getJobSalaryLabel() {
		return jobSalaryLabel;
	}

	public Label getCompanyNameLabel() {
		return companyNameLabel;
	}


	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public Button getCloseButton() {
		return closeButton;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Label getYouLabel() {
		return youLabel;
	}

	public Label getCvTitleLabel() {
		return cvTitleLabel;
	}

	public Label getCvDescLabel() {
		return cvDescLabel;
	}

	public VBox getCvField() {
		return cvField;
	}



	public TextField getTfCvDesc() {
		return tfCvDesc;
	}



	public TextField getTfTranscriptDesc() {
		return tfTranscriptDesc;
	}

	public Label getPleaseFillLabel() {
		return pleaseFillLabel;
	}

	public Button getApplyButton() {
		return applyButton;
	}

	public Separator getSeparator() {
		return separator;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	
	
	
	
	
	
	
	


	
	

}
