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
import models.Internship;
import models.Job;

public class PopUpApplyInternshipConfirmation extends VBox{
	
	private final Label internshipNameLabel, internshipDescLabel, companyNameLabel, youLabel, cvTitleLabel, cvDescLabel, pleaseFillLabel;
	private final HBox buttonContainer;
	private final Button closeButton, applyButton;
	private final VBox cvField;
	private final TextField tfCvDesc, tfTranscriptDesc;
	private final Separator separator;
	private Company company;
	private Alert alert;
	private Internship internship;
	
	
	
	public PopUpApplyInternshipConfirmation(Internship internship,  Company company) {
		this.internshipNameLabel = new Label(internship.getName());
		this.internshipDescLabel = new Label(internship.getDesc());
		this.companyNameLabel = new Label(company.getName());
		this.internship = internship;
		this.company = company;
		this.youLabel = new Label("You are going to apply internship as: ");
		this.cvField = new VBox();
		this.cvTitleLabel = new Label("CV Description");
		this.cvDescLabel = new Label("Transcript Description");
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
		
		internshipNameLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	internshipNameLabel.setTextFill(Color.WHITE);
     	
     	internshipDescLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,15));
     	internshipDescLabel.setTextFill(Color.LIGHTGREY);
     	
  
     	
     	companyNameLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	companyNameLabel.setTextFill(Color.WHITE);

     	
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
		
		this.getChildren().addAll(youLabel, internshipNameLabel, internshipDescLabel,  separator, cvField,buttonContainer);
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public Label getInternshipNameLabel() {
		return internshipNameLabel;
	}

	public Label getInternshipDescLabel() {
		return internshipDescLabel;
	}

	public Label getCompanyNameLabel() {
		return companyNameLabel;
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

	public Label getPleaseFillLabel() {
		return pleaseFillLabel;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public Button getCloseButton() {
		return closeButton;
	}

	public Button getApplyButton() {
		return applyButton;
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

	public Separator getSeparator() {
		return separator;
	}
	
	
	

}
