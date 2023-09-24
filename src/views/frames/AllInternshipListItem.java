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

public class AllInternshipListItem extends HBox{
	
	private VBox internshipDetail;
	private HBox buttonContainer;
	private Label internshipName, companyName, internshipDescription;
	private Button viewButton, applyButton;
	
	

	public AllInternshipListItem(String internshipName, String internshipDesc, String companyName) {
		internshipDetail = new VBox();
		this.internshipName = new Label("Internship Name: "+internshipName);
		this.companyName = new Label("Company Name: "+companyName);
		this.internshipDescription = new Label("Internship Desc: "+internshipDesc);

		this.viewButton = new Button("View");
		this.buttonContainer = new HBox();
		this.applyButton = new Button("Apply");
		
		
		setElements();
	}
	
	public void setElements() {
		
		internshipDetail.setMinWidth(620);
		internshipDetail.setMaxWidth(620);
		buttonContainer.setSpacing(5);
		
		internshipName.setTextFill(Color.WHITE);
		internshipName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,17));
		
		companyName.setTextFill(Color.LIGHTGREY);
		companyName.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));

		internshipDescription.setTextFill(Color.LIGHTGREY);
		internshipDescription.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,13));
		

		buttonContainer.setAlignment(Pos.CENTER);
		
		viewButton.setStyle("-fx-background-color: #4267B2");
		viewButton.setTextFill(Color.WHITE);
		
		applyButton.setStyle("-fx-background-color: #5DBB63");
		applyButton.setTextFill(Color.WHITE);
		
		
		internshipDetail.getChildren().addAll(internshipName, internshipDescription, companyName);
		buttonContainer.getChildren().addAll(viewButton, applyButton);
		
	
		this.getChildren().addAll(internshipDetail, buttonContainer);
		this.setPadding(new Insets(9, 9,9,9));
		this.setAlignment(Pos.CENTER_LEFT);
	
		this.setStyle("-fx-background-color: #393939; -fx-background-radius: 10px;");
	}

	public VBox getInternshipDetail() {
		return internshipDetail;
	}

	public void setInternshipDetail(VBox internshipDetail) {
		this.internshipDetail = internshipDetail;
	}

	public HBox getButtonContainer() {
		return buttonContainer;
	}

	public void setButtonContainer(HBox buttonContainer) {
		this.buttonContainer = buttonContainer;
	}

	public Label getInternshipName() {
		return internshipName;
	}

	public void setInternshipName(Label internshipName) {
		this.internshipName = internshipName;
	}

	public Label getCompanyName() {
		return companyName;
	}

	public void setCompanyName(Label companyName) {
		this.companyName = companyName;
	}

	public Label getInternshipDescription() {
		return internshipDescription;
	}

	public void setInternshipDescription(Label internshipDescription) {
		this.internshipDescription = internshipDescription;
	}



	public Button getViewButton() {
		return viewButton;
	}

	public void setViewButton(Button viewButton) {
		this.viewButton = viewButton;
	}

	public Button getApplyButton() {
		return applyButton;
	}

	public void setApplyButton(Button applyButton) {
		this.applyButton = applyButton;
	}

	
	
}
