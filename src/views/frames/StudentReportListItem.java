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

public class StudentReportListItem extends HBox{
	private final VBox jobDetail;
	private final HBox buttonContainer;
	private final Label internshipName, applicantName;
	private final Button viewButton;
	
	

	public StudentReportListItem(String internshipName, String applicantName) {
		jobDetail = new VBox();
		this.internshipName = new Label("Internship Applied: "+internshipName);
		this.applicantName = new Label("Applicant Name: "+applicantName);
		this.viewButton = new Button("View");
		this.buttonContainer = new HBox();


		
		
		setElements();
	}
	
	public void setElements() {
		
		jobDetail.setMinWidth(660);
		jobDetail.setMaxWidth(660);
		buttonContainer.setSpacing(9);
		
		internshipName.setTextFill(Color.WHITE);
		internshipName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,17));
		
		applicantName.setTextFill(Color.LIGHTGREY);
		applicantName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));

		
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.getChildren().addAll(viewButton);
		
		
		
		jobDetail.getChildren().addAll(internshipName, applicantName, buttonContainer);
		
		
		
	
		
		
		viewButton.setStyle("-fx-background-color: #4267B2");
		viewButton.setTextFill(Color.WHITE);
		

		
		
		this.getChildren().addAll(jobDetail, buttonContainer);
		this.setPadding(new Insets(9, 9,9,9));
		this.setAlignment(Pos.CENTER_LEFT);
		this.setStyle("-fx-background-color: #393939; -fx-background-radius: 10px;");
	}

	public VBox getJobDetail() {
		return jobDetail;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public Label getInternshipName() {
		return internshipName;
	}

	public Label getApplicantName() {
		return applicantName;
	}

	public Button getViewButton() {
		return viewButton;
	}
	
	

}
