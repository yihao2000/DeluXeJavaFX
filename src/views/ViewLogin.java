package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ViewLogin extends View{
	private VBox vbContentHolder, vbLoginBox;
	private TextField tfEmail;
	private PasswordField pfPassword;
	private Label lbEmail, lbPassword, lbTitle;
	private Button btnLogin, btnRegister;
	private Alert alertLogin;
	
	
	
	
	

	public ViewLogin(int w, int h) {
		super(w, h);
		vbContentHolder = new VBox();
		vbLoginBox = new VBox();
		tfEmail = new TextField();
		pfPassword = new PasswordField();
		lbEmail = new Label("Email Address");
		lbPassword = new Label("Password");
		lbTitle = new Label("DeluXe");
		btnLogin = new Button("Login");
		btnRegister = new Button("Register Instead");
		alertLogin = new Alert(Alert.AlertType.ERROR);
		
		setElements();
		
		// TODO Auto-generated constructor stub
	}






	@Override
	public void setElements() {
		parentFrame.setCenter(vbContentHolder);
		vbContentHolder.setAlignment(Pos.CENTER);
		lbTitle.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 40));
		lbTitle.setStyle("-fx-text-fill: #AAAAAA");
		
		tfEmail.setPrefWidth(350);
		tfEmail.setMaxWidth(350);
		tfEmail.setPromptText("Enter your email");
		
		pfPassword.setPrefWidth(350);
		pfPassword.setMaxWidth(350);
		pfPassword.setPromptText("Enter your password");
		
		lbEmail.setTextFill(Color.WHITE);
		lbEmail.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		
		lbPassword.setTextFill(Color.WHITE);
		lbPassword.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		
		String st1;
	     btnLogin.setStyle("-fx-background-color: #bbbbbb; -fx-border-color: transparent; -fx-border-radius: 3px; -fx-text-fill: #232323;");
	     st1 = btnLogin.getStyle();
	     btnLogin.setOnMouseEntered(e -> btnLogin.setStyle(HOVERED_BUTTON_STYLE));
	     btnLogin.setOnMouseExited(e -> btnLogin.setStyle(st1));
	     btnLogin.setPrefHeight(40);
	     btnLogin.setPrefWidth(180);
	     btnLogin.setFont(Font.font("Segoe UI", FontWeight.BOLD,16));
	     VBox.setMargin(btnLogin, new Insets(30,0,0,0));
	     btnLogin.setDefaultButton(true);
	     
	     
	     btnRegister.setOnMouseEntered(e -> btnRegister.setStyle(HOVERED_BUTTON_STYLE));
	     btnRegister.setOnMouseExited(e -> btnRegister.setStyle(IDLE_BUTTON_STYLE));
	     btnRegister.setPrefHeight(35);
	     btnRegister.setPrefWidth(270);
	     btnRegister.setStyle("-fx-background-color: #464646; -fx-text-fill: #AAAAAA;");
	     btnRegister.setStyle(IDLE_BUTTON_STYLE);
	     btnRegister.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     VBox.setMargin(btnRegister, new Insets(0,0,10,0));
	     
	     vbLoginBox.setPrefWidth(230);
	     vbLoginBox.setMaxWidth(230);
	     vbLoginBox.setPrefHeight(295);
	     vbLoginBox.setAlignment(Pos.CENTER);
	     vbLoginBox.setStyle("-fx-background-color: #343434; -fx-background-radius: 9px");
	     vbLoginBox.setSpacing(12);
	     vbLoginBox.setPadding(new Insets(10,10,10,10));
	     vbLoginBox.getChildren().addAll(lbEmail,  tfEmail, lbPassword,pfPassword,btnLogin);
	     
	     VBox.setMargin(vbLoginBox, new Insets(0,0,100,0));
	     
	     	vbContentHolder.setPrefWidth(600);
	        vbContentHolder.setPrefHeight(700);
	        vbContentHolder.getChildren().addAll(lbTitle, vbLoginBox, btnRegister);
	        vbContentHolder.setStyle("-fx-background-color: #232323");
	        
	        
		
		
		
	}






	public VBox getVbContentHolder() {
		return vbContentHolder;
	}






	public void setVbContentHolder(VBox vbContentHolder) {
		this.vbContentHolder = vbContentHolder;
	}






	public VBox getVbLoginBox() {
		return vbLoginBox;
	}






	public void setVbLoginBox(VBox vbLoginBox) {
		this.vbLoginBox = vbLoginBox;
	}






	public TextField getTfEmail() {
		return tfEmail;
	}






	public void setTfEmail(TextField tfEmail) {
		this.tfEmail = tfEmail;
	}






	public PasswordField getPfPassword() {
		return pfPassword;
	}






	public void setPfPassword(PasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}






	public Label getLbEmail() {
		return lbEmail;
	}






	public void setLbEmail(Label lbEmail) {
		this.lbEmail = lbEmail;
	}






	public Label getLbPassword() {
		return lbPassword;
	}






	public void setLbPassword(Label lbPassword) {
		this.lbPassword = lbPassword;
	}






	public Label getLbTitle() {
		return lbTitle;
	}






	public void setLbTitle(Label lbTitle) {
		this.lbTitle = lbTitle;
	}






	public Button getBtnLogin() {
		return btnLogin;
	}






	public void setBtnLogin(Button btnLogin) {
		this.btnLogin = btnLogin;
	}






	public Button getBtnRegister() {
		return btnRegister;
	}






	public void setBtnRegister(Button btnRegister) {
		this.btnRegister = btnRegister;
	}






	public Alert getAlertLogin() {
		return alertLogin;
	}






	public void setAlertLogin(Alert alertLogin) {
		this.alertLogin = alertLogin;
	}

	
	


}
