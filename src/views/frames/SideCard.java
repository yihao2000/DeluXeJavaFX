package views.frames;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;

public class SideCard extends VBox{
	private Label logoLabel;
	private SideCardContent sideCardContent;


	public SideCard() {
		// TODO Auto-generated constructor stub
		logoLabel = new Label("DeluXe");
		sideCardContent = new SideCardContent();

		
		setElements();
	}
	
	public void setElements() {
		this.setSpacing(20);
		this.setStyle("-fx-background-color: #7a7e77");
		this.setPadding(new Insets(20, 8, 0, 8));
		logoLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,20));
		logoLabel.setStyle("-fx-text-fill: #ffffff");
		this.setAlignment(Pos.TOP_CENTER);
		this.minWidth(Main.DEFAULT_WIDTH/5);
		logoLabel.setMinWidth(Main.DEFAULT_WIDTH/5);	
		sideCardContent.minWidth(Main.DEFAULT_WIDTH/5);
		this.getChildren().addAll(logoLabel, sideCardContent);
	}

	public Label getLogoLabel() {
		return logoLabel;
	}

	public void setLogoLabel(Label logoLabel) {
		this.logoLabel = logoLabel;
	}

	public SideCardContent getSideCardContent() {
		return sideCardContent;
	}

	public void setSideCardContent(SideCardContent sideCardContent) {
		this.sideCardContent = sideCardContent;
	}



	
	

}
