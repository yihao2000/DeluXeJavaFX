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

public class PopUpAddNewInternship extends VBox{

	private final Label addNewInternship, internshipTitle, internshipDesc;
	private final HBox internshipTitleContainer, internshipDescContainer, buttonContainer;
	private final TextField internshipTitleTf, internshipDescTf;
	private final Separator separator;
	private final Button addButton, closeButton;
	
	public PopUpAddNewInternship() {
		addNewInternship = new Label("Add New Internship for this Job");
		internshipTitle = new Label("Internship Name: ");
		internshipDesc = new Label("Internship Desc: ");
		
		internshipTitleContainer = new HBox();
		internshipDescContainer = new HBox();
		buttonContainer = new HBox();
		
		internshipTitleTf = new TextField();
		internshipDescTf = new TextField();

		
		addButton = new Button("Add new Internship");
		closeButton = new Button("Back to dashboard");
		
		
		
		
		
		separator = new Separator();
		
		setElements();
	}
	
	public void setElements() {
		
		internshipTitleContainer.getChildren().addAll(internshipTitle, internshipTitleTf);
		internshipTitleContainer.setMaxWidth(550);
		
		internshipDescContainer.getChildren().addAll(internshipDesc, internshipDescTf);
		internshipDescContainer.setMaxWidth(550);
		internshipDescContainer.setSpacing(9);
		

		
		buttonContainer.getChildren().addAll(addButton, closeButton);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(15);
		
		
		addNewInternship.setFont(Font.font("Segoe UI",FontWeight.BOLD,26));
     	addNewInternship.setTextFill(Color.WHITE);
		
		internshipTitle.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,18));
     	internshipTitle.setTextFill(Color.WHITE);
     	
     	internshipDesc.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,18));
     	internshipDesc.setTextFill(Color.WHITE);
     	

     	
     	internshipTitleTf.setMinWidth(400);
     	internshipTitleTf.setMaxWidth(400);
     	internshipTitleTf.setMinHeight(30);
     	internshipTitleTf.setPromptText("Enter Internship Title (Must be Filled)");
     	
     	internshipDescTf.setMinWidth(400);
     	internshipDescTf.setMaxWidth(400);
     	internshipDescTf.setMinHeight(200);
     	internshipDescTf.setAlignment(Pos.TOP_LEFT);
     	internshipDescTf.setPromptText("Enter Internship Desc (Must be Filled)");
     	
  
     	
     
     	
     	
     	addButton.setStyle("-fx-background-color: #60bc64");
		addButton.setTextFill(Color.WHITE);
		
		
		closeButton.setStyle("-fx-background-color: #4267B2");
		closeButton.setTextFill(Color.WHITE);
     	
		this.setAlignment(Pos.CENTER);
		this.maxWidth(500);
	
		this.getChildren().addAll(addNewInternship, separator, internshipTitleContainer,internshipDescContainer, buttonContainer);
		this.setStyle("-fx-background-color: #232323");
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setSpacing(15);
		
		
		
		
		
	}

	public Label getAddNewInternship() {
		return addNewInternship;
	}

	public Label getInternshipTitle() {
		return internshipTitle;
	}

	public Label getInternshipDesc() {
		return internshipDesc;
	}

	public HBox getInternshipTitleContainer() {
		return internshipTitleContainer;
	}

	public HBox getInternshipDescContainer() {
		return internshipDescContainer;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public TextField getInternshipTitleTf() {
		return internshipTitleTf;
	}

	public TextField getInternshipDescTf() {
		return internshipDescTf;
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
