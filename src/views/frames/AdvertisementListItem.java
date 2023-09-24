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

public class AdvertisementListItem extends HBox{
	private Label companyNameLabel, advertisementTitleLabel, advertisementDescLabel;
	private VBox descriptionBox;
	private Button detailButton;

	public AdvertisementListItem(String companyName, String advertisementTitle, String advertisementDesc) {
		// TODO Auto-generated constructor stub
		descriptionBox = new VBox();
		
		companyNameLabel = new Label("Company Name: "+companyName);
		advertisementTitleLabel = new Label("Title: "+advertisementTitle);
		advertisementDescLabel = new Label("Desc: "+advertisementDesc);
		detailButton = new Button("View Detail");
		
		
		
		setElements();
	}
	
	
	public void setElements() {
		
		this.setStyle("-fx-background-color: #393939; -fx-background-radius: 10px;");
		this.minWidth(600);
		this.setPadding(new Insets(13, 13, 13, 9));
		this.setAlignment(Pos.CENTER_LEFT);
		
		descriptionBox.setMinWidth(630);
		descriptionBox.setMaxWidth(630);
		
		advertisementTitleLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
		advertisementTitleLabel.setTextFill(Color.WHITE);
		
		advertisementDescLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
		advertisementDescLabel.setTextFill(Color.WHITE);
		
		companyNameLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,14));
		companyNameLabel.setTextFill(Color.WHITE);
		
		detailButton.setStyle("-fx-background-color: #4267B2");
		detailButton.setTextFill(Color.WHITE);
		
		
		
		
		
		this.getChildren().addAll(descriptionBox, detailButton);
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

	
	
}
