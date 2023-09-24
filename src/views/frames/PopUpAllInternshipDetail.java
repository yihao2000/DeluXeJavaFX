package views.frames;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;

public class PopUpAllInternshipDetail extends VBox{
	private final Label internshipNameLabel, internshipDescLabel, companyNameLabel, companyEmailLabel, companyPhoneLabel, companyAddressLabel, contactUsLabel, divider1, divider2;
	private final HBox buttonContainer, contactContainer;
	private final Button closeButton;
	private final Separator separator;
	
	
	public PopUpAllInternshipDetail(String internshipName, String internshipDesc,  String companyName, String companyEmail, String companyPhone, String companyAddress) {
		this.internshipNameLabel = new Label(internshipName);
		this.internshipDescLabel = new Label(internshipDesc);
		this.companyNameLabel = new Label(companyName);
		this.companyEmailLabel = new Label(companyEmail);
		this.companyPhoneLabel = new Label(companyPhone);
		this.companyAddressLabel = new Label(companyAddress);
		this.contactContainer = new HBox();
		this.contactUsLabel = new Label("Contact us at: ");
		
		this.divider1 = new Label("/");
		this.divider2 = new Label("/");
		
		this.separator = new Separator();
		
		
		buttonContainer = new HBox();
		
		this.closeButton = new Button("Close");
		
		setElements();
	}
	
	public void setElements() {
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setMaxWidth(Main.DEFAULT_WIDTH-150);
		this.setPadding(new Insets(15, 15, 15, 15));
		this.setStyle("-fx-background-color: #585454; -fx-border-radius: 10px; -fx-background-radius: 10px");
		
		
		
		internshipNameLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,20));
     	internshipNameLabel.setTextFill(Color.WHITE);
     	
     	internshipDescLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,15));
     	internshipDescLabel.setTextFill(Color.LIGHTGREY);
     	
     	
     	
     	
     	companyNameLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	companyNameLabel.setTextFill(Color.WHITE);
     	

     	
     	contactUsLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	contactUsLabel.setTextFill(Color.WHITE);
     	
     	companyEmailLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
     	companyEmailLabel.setTextFill(Color.LIGHTGREY);
     	
     	companyPhoneLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
     	companyPhoneLabel.setTextFill(Color.LIGHTGREY);
     	
     	companyAddressLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
     	companyAddressLabel.setTextFill(Color.LIGHTGREY);
     	
     	divider1.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
     	divider1.setTextFill(Color.LIGHTGREY);
     	
     	divider2.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
     	divider2.setTextFill(Color.LIGHTGREY);
     	
     	contactContainer.setAlignment(Pos.CENTER);
     	contactContainer.setSpacing(15);
		contactContainer.getChildren().addAll(companyEmailLabel,divider1,  companyPhoneLabel, divider2, companyAddressLabel);
		
		separator.setPadding(new Insets(0, 150, 0, 150));
		
		closeButton.setStyle("-fx-background-color: #FF5C5C");
		closeButton.setTextFill(Color.WHITE);
		
		buttonContainer.getChildren().addAll(closeButton);
		buttonContainer.setAlignment(Pos.CENTER);
		
		this.getChildren().addAll(internshipNameLabel,separator, internshipDescLabel, contactUsLabel, contactContainer, buttonContainer);
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

	public Label getCompanyEmailLabel() {
		return companyEmailLabel;
	}

	public Label getCompanyPhoneLabel() {
		return companyPhoneLabel;
	}

	public Label getCompanyAddressLabel() {
		return companyAddressLabel;
	}

	public Label getContactUsLabel() {
		return contactUsLabel;
	}

	public Label getDivider1() {
		return divider1;
	}

	public Label getDivider2() {
		return divider2;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public HBox getContactContainer() {
		return contactContainer;
	}

	public Button getCloseButton() {
		return closeButton;
	}

	public Separator getSeparator() {
		return separator;
	}
	
	
	

}
