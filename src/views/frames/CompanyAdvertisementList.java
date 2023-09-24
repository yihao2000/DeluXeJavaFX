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

public class CompanyAdvertisementList extends HBox{

	private Label companyNameLabel, advertisementTitleLabel, advertisementDescLabel;
	private VBox descriptionBox;
	private HBox buttonContainer;
	private Button detailButton, removeButton;

	public CompanyAdvertisementList(String companyName, String advertisementTitle, String advertisementDesc) {
		// TODO Auto-generated constructor stub
		descriptionBox = new VBox();
		
		companyNameLabel = new Label("Company Name: "+companyName);
		advertisementTitleLabel = new Label("Title: "+advertisementTitle);
		advertisementDescLabel = new Label("Desc: "+advertisementDesc);
		detailButton = new Button("View Detail");
		removeButton = new Button("Remove");
		
		buttonContainer = new HBox();
		
		
		
		setElements();
	}
	
	
	public void setElements() {
		
		this.setStyle("-fx-background-color: #393939; -fx-background-radius: 10px;");
		this.minWidth(600);
		this.setPadding(new Insets(13, 13, 13, 9));
		this.setAlignment(Pos.CENTER_LEFT);
		
		advertisementTitleLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
		advertisementTitleLabel.setTextFill(Color.WHITE);
		
		advertisementDescLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
		advertisementDescLabel.setTextFill(Color.WHITE);
		
		companyNameLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		companyNameLabel.setTextFill(Color.WHITE);
		
		removeButton.setStyle("-fx-background-color: #FF5C5C");
		removeButton.setTextFill(Color.WHITE);

		detailButton.setStyle("-fx-background-color: #4267B2");
		detailButton.setMinWidth(60);
		detailButton.setTextFill(Color.WHITE);
		
		buttonContainer.getChildren().addAll(detailButton, removeButton);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setSpacing(10);
		
		descriptionBox.setMinWidth(580);
		
		this.getChildren().addAll(descriptionBox, buttonContainer);
		descriptionBox.getChildren().addAll( advertisementTitleLabel, advertisementDescLabel, companyNameLabel);
	}


	public Label getCompanyNameLabel() {
		return companyNameLabel;
	}


	public void setCompanyNameLabel(Label companyNameLabel) {
		this.companyNameLabel = companyNameLabel;
	}


	public Label getAdvertisementTitleLabel() {
		return advertisementTitleLabel;
	}


	public void setAdvertisementTitleLabel(Label advertisementTitleLabel) {
		this.advertisementTitleLabel = advertisementTitleLabel;
	}


	public Label getAdvertisementDescLabel() {
		return advertisementDescLabel;
	}


	public void setAdvertisementDescLabel(Label advertisementDescLabel) {
		this.advertisementDescLabel = advertisementDescLabel;
	}


	public VBox getDescriptionBox() {
		return descriptionBox;
	}


	public void setDescriptionBox(VBox descriptionBox) {
		this.descriptionBox = descriptionBox;
	}


	public Button getDetailButton() {
		return detailButton;
	}


	public void setDetailButton(Button removeButton) {
		this.detailButton = removeButton;
	}


	public Button getRemoveButton() {
		return removeButton;
	}


	public void setRemoveButton(Button removeButton) {
		this.removeButton = removeButton;
	}
	
	
}
