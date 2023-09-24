package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ViewRegister extends View{

	
	private VBox vbContentHolder, vbRegisterBox;
	private ComboBox<String> cbAcc;
	private TextField tfEmail, tfPhone, tfAddress, tfName;
	private PasswordField pfPassword, pfConfPassword;
	private Label lbEmail, lbPassword, lbTitle, lbPhone, lbAddress, lbConfPassword, lbRole, lbName;
	private Button btnLogin, btnRegister;
	private Alert alertRegister;
	
	
	
	
	

	public ViewRegister(int w, int h) {
		super(w, h);
		vbContentHolder = new VBox();
		vbRegisterBox = new VBox();
		tfEmail = new TextField();
		tfName = new TextField();
		tfPhone = new TextField();
		tfAddress = new TextField();
		pfPassword = new PasswordField();
		pfConfPassword = new PasswordField();
		lbName = new Label("Name");
		lbEmail = new Label("Email Address");
		lbPassword = new Label("Password");
		lbPhone = new Label("Phone Number");
		lbAddress = new Label("Address");
		lbConfPassword = new Label("Confirm Password");
		lbRole = new Label("Role");
		lbTitle = new Label("DeluXe");
		btnLogin = new Button("Already have an account? Login");
		btnRegister = new Button("Register");
		alertRegister = new Alert(Alert.AlertType.ERROR);
		cbAcc = new ComboBox<>();
		
		setElements();
		
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
		
		tfPhone.setPrefWidth(350);
		tfPhone.setMaxWidth(350);
		tfPhone.setPromptText("Enter your phone");
		
		tfAddress.setPrefWidth(350);
		tfAddress.setMaxWidth(350);
		tfAddress.setPromptText("Enter your address");
		
		tfName.setPrefWidth(350);
		tfName.setMaxWidth(350);
		tfName.setPromptText("Enter ypur name");
		
		pfPassword.setPrefWidth(350);
		pfPassword.setMaxWidth(350);
		pfPassword.setPromptText("Enter your password");
		
		pfConfPassword.setPrefWidth(350);
		pfConfPassword.setMaxWidth(350);
		pfConfPassword.setPromptText("Enter your inputted password");
		
		lbEmail.setTextFill(Color.WHITE);
		lbEmail.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));

		lbName.setTextFill(Color.WHITE);
		lbName.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		
		lbPhone.setTextFill(Color.WHITE);
		lbPhone.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		
		lbAddress.setTextFill(Color.WHITE);
		lbAddress.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		
		lbConfPassword.setTextFill(Color.WHITE);
		lbConfPassword.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		
		cbAcc.setPlaceholder(new Label("Select Account Type"));
		
		lbRole.setTextFill(Color.WHITE);
		lbRole.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));	
		
		lbPassword.setTextFill(Color.WHITE);
		lbPassword.setFont(Font.font("Segoe UI", FontWeight.BOLD, 16));
		
		 String st1;
		 btnRegister.setStyle("-fx-background-color: #bbbbbb; -fx-border-color: transparent; -fx-border-radius: 3px; -fx-text-fill: #232323;");
	     st1 = btnRegister.getStyle();
	     btnRegister.setOnMouseEntered(e -> btnRegister.setStyle(HOVERED_BUTTON_STYLE));
	     btnRegister.setOnMouseExited(e -> btnRegister.setStyle(st1));
	     btnRegister.setPrefHeight(40);
	     btnRegister.setPrefWidth(180);
	     btnRegister.setFont(Font.font("Segoe UI", FontWeight.BOLD,16));
	     VBox.setMargin(btnRegister, new Insets(30,0,0,0));
	     btnRegister.setDefaultButton(true);
	     
	     
	     btnLogin.setOnMouseEntered(e -> btnLogin.setStyle(HOVERED_BUTTON_STYLE));
	     btnLogin.setOnMouseExited(e ->btnLogin.setStyle(IDLE_BUTTON_STYLE));
	     btnLogin.setPrefHeight(35);
	     btnLogin.setPrefWidth(270);
	     btnLogin.setStyle("-fx-background-color: #464646; -fx-text-fill: #AAAAAA;");
	     btnLogin.setStyle(IDLE_BUTTON_STYLE);
	     btnLogin.setFont(Font.font("Segoe UI",FontWeight.BOLD,14));
	     VBox.setMargin(btnRegister, new Insets(0,0,10,0));
	     
	     vbRegisterBox.setPrefWidth(230);
	     vbRegisterBox.setMaxWidth(230);
	     vbRegisterBox.setPrefHeight(295);
	     vbRegisterBox.setAlignment(Pos.CENTER);
	     vbRegisterBox.setStyle("-fx-background-color: #343434; -fx-background-radius: 9px");
	     vbRegisterBox.setSpacing(12);
	     vbRegisterBox.setPadding(new Insets(10,10,10,10));
	     vbRegisterBox.getChildren().addAll( lbRole, cbAcc, lbEmail,  tfEmail, lbName, tfName, lbPassword,pfPassword, lbConfPassword, pfConfPassword, lbPhone, tfPhone, lbAddress, tfAddress,  btnRegister);
	     
	     VBox.setMargin(vbRegisterBox, new Insets(0,0,100,0));
	     
	     	vbContentHolder.setPrefWidth(600);
	        vbContentHolder.setPrefHeight(700);
	        vbContentHolder.getChildren().addAll(lbTitle, vbRegisterBox, btnLogin);
	        vbContentHolder.setStyle("-fx-background-color: #232323");
		
	}
	
	






	public VBox getVbContentHolder() {
		return vbContentHolder;
	}






	public void setVbContentHolder(VBox vbContentHolder) {
		this.vbContentHolder = vbContentHolder;
	}






	public VBox getVbLoginBox() {
		return vbRegisterBox;
	}






	public void setVbLoginBox(VBox vbLoginBox) {
		this.vbRegisterBox = vbLoginBox;
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
		return alertRegister;
	}






	public void setAlertLogin(Alert alertLogin) {
		this.alertRegister = alertLogin;
	}






	public TextField getTfPhone() {
		return tfPhone;
	}






	public void setTfPhone(TextField tfPhone) {
		this.tfPhone = tfPhone;
	}






	public TextField getTfAddress() {
		return tfAddress;
	}






	public void setTfAddress(TextField tfAddress) {
		this.tfAddress = tfAddress;
	}






	public PasswordField getPfConfPassword() {
		return pfConfPassword;
	}






	public void setPfConfPassword(PasswordField pfConfPassword) {
		this.pfConfPassword = pfConfPassword;
	}






	public Label getLbPhone() {
		return lbPhone;
	}






	public void setLbPhone(Label lbPhone) {
		this.lbPhone = lbPhone;
	}






	public Label getLbAddress() {
		return lbAddress;
	}






	public void setLbAddress(Label lbAddress) {
		this.lbAddress = lbAddress;
	}






	public Label getLbConfPassword() {
		return lbConfPassword;
	}






	public void setLbConfPassword(Label lbConfPassword) {
		this.lbConfPassword = lbConfPassword;
	}






	public Alert getAlertRegister() {
		return alertRegister;
	}






	public void setAlertRegister(Alert alertRegister) {
		this.alertRegister = alertRegister;
	}






	public ComboBox<String> getCbAcc() {
		return cbAcc;
	}






	public void setCbAcc(ComboBox<String> cbAcc) {
		this.cbAcc = cbAcc;
	}






	public Label getLbRole() {
		return lbRole;
	}






	public void setLbRole(Label lbRole) {
		this.lbRole = lbRole;
	}






	public VBox getVbRegisterBox() {
		return vbRegisterBox;
	}






	public void setVbRegisterBox(VBox vbRegisterBox) {
		this.vbRegisterBox = vbRegisterBox;
	}






	public TextField getTfName() {
		return tfName;
	}






	public void setTfName(TextField tfName) {
		this.tfName = tfName;
	}






	public Label getLbName() {
		return lbName;
	}






	public void setLbName(Label lbName) {
		this.lbName = lbName;
	}
	
	
	
	
	
	
	
	
	

}
