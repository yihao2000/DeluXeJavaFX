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

public class StudentApplicationListItem extends HBox{

	private final VBox jobDetail;
	private final HBox buttonContainer;
	private final Label jobName, applicantName;
	private final Button viewButton, acceptButton, removeButton;
	
	

	public StudentApplicationListItem(String jobName, String applicantName) {
		jobDetail = new VBox();
		this.jobName = new Label("Job Applied: "+jobName);
		this.applicantName = new Label("Applicant Name: "+applicantName);
		this.viewButton = new Button("View");
		this.removeButton= new Button("Remove");
		this.buttonContainer = new HBox();
		this.acceptButton = new Button("Accept");

		
		
		setElements();
	}
	
	public void setElements() {
		
		jobDetail.setMinWidth(550);
		jobDetail.setMaxWidth(550);
		buttonContainer.setSpacing(9);
		
		jobName.setTextFill(Color.WHITE);
		jobName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,17));
		
		applicantName.setTextFill(Color.LIGHTGREY);
		applicantName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));

		
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.getChildren().addAll(viewButton, acceptButton, removeButton);
		
		
		
		jobDetail.getChildren().addAll(jobName, applicantName, buttonContainer);
		
		
		
	
		
		
		viewButton.setStyle("-fx-background-color: #4267B2");
		viewButton.setTextFill(Color.WHITE);
		
		removeButton.setStyle("-fx-background-color: #FF5C5C");
		removeButton.setTextFill(Color.WHITE);
		
		acceptButton.setStyle("-fx-background-color: #5DBB63");
		acceptButton.setTextFill(Color.WHITE);
		
		
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

	public Label getJobName() {
		return jobName;
	}

	public Label getApplicantName() {
		return applicantName;
	}

	public Button getViewButton() {
		return viewButton;
	}

	public Button getAcceptButton() {
		return acceptButton;
	}

	public Button getRemoveButton() {
		return removeButton;
	}
	
	
}
