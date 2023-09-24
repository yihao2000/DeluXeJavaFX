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

public class PopUpAddNewAdvertisement extends VBox{
	private final Label addNewAdvertisement, advertisementTitle, advertisementDesc;
	private final HBox advertisementTitleContainer, advertisementDescContainer, buttonContainer;
	private final TextField advertisementTitleTf, advertisementDescTf;
	private final Separator separator;
	private final Button addButton, closeButton;
	
	public PopUpAddNewAdvertisement() {
		addNewAdvertisement = new Label("Add New Advertisement");
		advertisementTitle = new Label("Advertisement Title: ");
		advertisementDesc = new Label("Advertisement Desc: ");
		
		
		advertisementTitleContainer = new HBox();
		advertisementDescContainer = new HBox();
		buttonContainer = new HBox();
		
		advertisementTitleTf = new TextField();
		advertisementDescTf = new TextField();
		
		addButton = new Button("Post Advertisement");
		closeButton = new Button("Back to dashboard");
		
		
		
		
		
		separator = new Separator();
		
		setElements();
	}
	
	public void setElements() {
		
		advertisementTitleContainer.getChildren().addAll(advertisementTitle, advertisementTitleTf);
		advertisementTitleContainer.setMaxWidth(700);
		advertisementTitleContainer.setSpacing(14);
		
		advertisementDescContainer.getChildren().addAll(advertisementDesc, advertisementDescTf);
		advertisementDescContainer.setMaxWidth(700);
		advertisementDescContainer.setSpacing(9);
		
		
		buttonContainer.getChildren().addAll(addButton, closeButton);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(15);
		
		
		addNewAdvertisement.setFont(Font.font("Segoe UI",FontWeight.BOLD,26));
     	addNewAdvertisement.setTextFill(Color.WHITE);
		
		advertisementTitle.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,18));
     	advertisementTitle.setTextFill(Color.WHITE);
     	
     	advertisementDesc.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,18));
     	advertisementDesc.setTextFill(Color.WHITE);
     	

     	
     	advertisementTitleTf.setMinWidth(400);
     	advertisementTitleTf.setMaxWidth(400);
     	advertisementTitleTf.setMinHeight(30);
     	advertisementTitleTf.setPromptText("Enter Your Advertisement Title (Must be Filled)");
     	
     	
     	advertisementDescTf.setMinWidth(400);
     	advertisementDescTf.setMaxWidth(400);
     	advertisementDescTf.setMinHeight(200);
     	advertisementDescTf.setAlignment(Pos.TOP_LEFT);
     	advertisementDescTf.setPromptText("Enter Your Advertisement Desc (Must be Filled)");
     	
  
     	
     
     	
     	
     	addButton.setStyle("-fx-background-color: #60bc64");
		addButton.setTextFill(Color.WHITE);
		
		
		closeButton.setStyle("-fx-background-color: #FF5C5C");
		closeButton.setTextFill(Color.WHITE);
     	
		this.setAlignment(Pos.CENTER);
		this.maxWidth(500);
	
		this.getChildren().addAll(addNewAdvertisement, separator, advertisementTitleContainer,advertisementDescContainer, buttonContainer);
		this.setStyle("-fx-background-color: #232323");
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setSpacing(15);
		
		
		
		
		
	}

	public Label getAddNewAdvertisement() {
		return addNewAdvertisement;
	}

	public Label getAdvertisementTitle() {
		return advertisementTitle;
	}

	public Label getAdvertisementDesc() {
		return advertisementDesc;
	}

	public HBox getAdvertisementTitleContainer() {
		return advertisementTitleContainer;
	}

	public HBox getAdvertisementDescContainer() {
		return advertisementDescContainer;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public TextField getAdvertisementTitleTf() {
		return advertisementTitleTf;
	}

	public TextField getAdvertisementDescTf() {
		return advertisementDescTf;
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
