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
import main.Main;

public class PopUpAdvertisement extends VBox{
	private final Label title, desc, companyName, phoneNumber;
	private final HBox buttonContainer;
	private final Button buttonOk;
	
	
	
	public PopUpAdvertisement(String title, String desc, String companyName, String phoneNumber) {
		super();
		this.title = new Label(title);
		this.desc = new Label(desc);
		this.companyName = new Label(companyName);
		this.phoneNumber = new Label("Contact us at: "+phoneNumber);
		buttonContainer = new HBox();
		buttonOk = new Button("Back to Dashboard");
		
		
		setElements();
	}
	
	public void setElements() {
		
		buttonContainer.getChildren().addAll(buttonOk);
		buttonContainer.setAlignment(Pos.CENTER);
		
		buttonOk.setStyle("-fx-background-color: #4267B2");
		buttonOk.setTextFill(Color.WHITE);
		
		title.setFont(Font.font("Segoe UI",FontWeight.BOLD,18));
     	title.setTextFill(Color.WHITE);
     	
     	desc.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,15));
     	desc.setTextFill(Color.LIGHTGREY);
     	
     	companyName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	companyName.setTextFill(Color.WHITE);
     	
     	phoneNumber.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	phoneNumber.setTextFill(Color.WHITE);
		
		
		
		
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setMaxWidth(Main.DEFAULT_WIDTH/3*2);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-background-color: #585454; -fx-border-radius: 10px; -fx-background-radius: 10px");
		this.getChildren().addAll(title, desc, companyName, phoneNumber, buttonContainer);
	}
	
	

	public HBox getButtonContainer() {
		return buttonContainer;
	}
	public Button getButtonOk() {
		return buttonOk;
	}

	public Label getTitle() {
		return title;
	}

	public Label getDesc() {
		return desc;
	}

	public Label getCompanyName() {
		return companyName;
	}

	public Label getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
	
	
	
	
	
	
	
	

}
