package views.frames;

import javafx.geometry.Insets;
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

public class PopUpAddNewJob extends VBox{
	private final Label addNewJob, jobTitle, jobDesc, jobSalary;
	private final HBox jobTitleContainer, jobDescContainer, jobSalaryContainer, buttonContainer;
	private final TextField jobTitleTf, jobDescTf, jobSalaryTf;
	private final Separator separator;
	private final Button addButton, closeButton;
	
	public PopUpAddNewJob() {
		addNewJob = new Label("Add New Job");
		jobTitle = new Label("Job Name: ");
		jobDesc = new Label("Job Desc: ");
		jobSalary = new Label("Job Salary: ");
		
		jobTitleContainer = new HBox();
		jobDescContainer = new HBox();
		jobSalaryContainer = new HBox();
		buttonContainer = new HBox();
		
		jobTitleTf = new TextField();
		jobDescTf = new TextField();
		jobSalaryTf = new TextField();
		
		addButton = new Button("Add new Job");
		closeButton = new Button("Back to dashboard");
		
		
		
		
		
		separator = new Separator();
		
		setElements();
	}
	
	public void setElements() {
		
		jobTitleContainer.getChildren().addAll(jobTitle, jobTitleTf);
		jobTitleContainer.setMaxWidth(550);
		
		jobDescContainer.getChildren().addAll(jobDesc, jobDescTf);
		jobDescContainer.setMaxWidth(550);
		jobDescContainer.setSpacing(9);
		
		jobSalaryContainer.getChildren().addAll(jobSalary, jobSalaryTf);
		jobSalaryContainer.setMaxWidth(550);
		
		buttonContainer.getChildren().addAll(addButton, closeButton);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(15);
		
		
		addNewJob.setFont(Font.font("Segoe UI",FontWeight.BOLD,26));
     	addNewJob.setTextFill(Color.WHITE);
		
		jobTitle.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,18));
     	jobTitle.setTextFill(Color.WHITE);
     	
     	jobDesc.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,18));
     	jobDesc.setTextFill(Color.WHITE);
     	
     	
     	jobSalary.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,18));
     	jobSalary.setTextFill(Color.WHITE);
     	
     	jobTitleTf.setMinWidth(400);
     	jobTitleTf.setMaxWidth(400);
     	jobTitleTf.setMinHeight(30);
     	jobTitleTf.setPromptText("Enter Your Job Title (Must be Filled)");
     	
     	jobDescTf.setMinWidth(400);
     	jobDescTf.setMaxWidth(400);
     	jobDescTf.setMinHeight(200);
     	jobDescTf.setAlignment(Pos.TOP_LEFT);
     	jobDescTf.setPromptText("Enter Your Job Desc (Must be Filled)");
     	
  
     	
     	jobSalaryTf.setMinWidth(400);
     	jobSalaryTf.setMaxWidth(400);
     	jobSalaryTf.setMinHeight(30);
     	jobSalaryTf.setPromptText("Enter Job Salary (Must be number)");
     	
     	
     	
     	addButton.setStyle("-fx-background-color: #60bc64");
		addButton.setTextFill(Color.WHITE);
		
		
		closeButton.setStyle("-fx-background-color: #4267B2");
		closeButton.setTextFill(Color.WHITE);
     	
		this.setAlignment(Pos.CENTER);
		this.maxWidth(500);
	
		this.getChildren().addAll(addNewJob, separator, jobTitleContainer,jobDescContainer, jobSalaryContainer, buttonContainer);
		this.setStyle("-fx-background-color: #232323");
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setSpacing(15);
		
		
		
		
		
	}

	public Label getAddNewJob() {
		return addNewJob;
	}

	public Label getJobTitle() {
		return jobTitle;
	}

	public Label getJobDesc() {
		return jobDesc;
	}

	public Label getJobSalary() {
		return jobSalary;
	}

	public HBox getJobTitleContainer() {
		return jobTitleContainer;
	}

	public HBox getJobDescContainer() {
		return jobDescContainer;
	}

	public HBox getJobSalaryContainer() {
		return jobSalaryContainer;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public TextField getJobTitleTf() {
		return jobTitleTf;
	}

	public TextField getJobDescTf() {
		return jobDescTf;
	}

	public TextField getJobSalaryTf() {
		return jobSalaryTf;
	}

	public Separator getSeparator() {
		return separator;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getCloseButton() {
		return closeButton;
	}
	
	
	

}
