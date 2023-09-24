package views;

import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;
import models.Application;
import models.Company;
import models.Job;
import models.User;
import utils.Logger;
import views.frames.PopUpAdvertisement;
import views.frames.PopUpApplyConfirmation;
import views.frames.PopUpJobDetail;

public abstract class View {
    public static final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent; -fx-border-color: transparent; -fx-border-radius: 3px; -fx-text-fill: #AAAAAA;";
    public static final String HOVERED_BUTTON_STYLE = "-fx-background-color: transparent; -fx-border-color: #FFFFFF; -fx-border-radius: 3px; -fx-text-fill: #AAAAAA;";
    protected BorderPane parentFrame = new BorderPane();
    private final StackPane stack = new StackPane();
    protected Scene scene;
    private final Label titleHeader = new Label("Deluxe - Job Application [Version "+Main.VERSION_NAME+" build "+Main.BUILD_NUMBER+"]");
    private Label greeting = new Label("Please log in to use this software");
    private final VBox labelHolder = new VBox();

    public View(int w, int h){
        scene = new Scene(stack,w,h);
        stack.getChildren().add(parentFrame);

        titleHeader.setFont(Font.font("Segoe UI", FontWeight.THIN,12));
        titleHeader.setPrefHeight(20);
        titleHeader.setPrefWidth(Main.DEFAULT_WIDTH);
        titleHeader.setAlignment(Pos.TOP_CENTER);
        titleHeader.setTextFill(Color.WHITE);
        titleHeader.setStyle("-fx-background-color: #232323; -fx-text-fill: #999999");

        greeting.setFont(Font.font("Segoe UI", FontWeight.NORMAL,13));
        greeting.setPrefHeight(40);
        greeting.setPrefWidth(Main.DEFAULT_WIDTH);
        greeting.setAlignment(Pos.TOP_CENTER);
        greeting.setTextFill(Color.WHITE);
        greeting.setStyle("-fx-background-color: #232323; -fx-text-fill: #AAAAAA");

        labelHolder.getChildren().addAll(titleHeader,greeting);
        labelHolder.setSpacing(0);

        this.parentFrame.setBottom(labelHolder);
    }

   
    
    
    
    public void popUpAdvertisement(String title,  String desc, String companyName, String phoneNumber) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	PopUpAdvertisement popUp = new PopUpAdvertisement(title, desc, companyName, phoneNumber);
    	darkened.getChildren().add(popUp);
    	stack.getChildren().add(darkened);
    	popUp.getButtonOk().setOnAction(e -> {
    		stack.getChildren().remove(darkened);
    	});
    	
    	
    }
    
    public void popUpJobDetail(String jobName, String jobDesc,  double jobSalary, String companyName, String companyEmail, String companyPhone, String companyAddress) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpJobDetail popUpJobDetail = new PopUpJobDetail(jobName, jobDesc, jobSalary, companyName, companyEmail, companyPhone, companyAddress);
    	darkened.getChildren().add(popUpJobDetail);
    	stack.getChildren().add(darkened);
    	popUpJobDetail.getCloseButton().setOnAction(e -> {
    		stack.getChildren().remove(darkened);
    	});
    	
    }

    public void changeInto() {
        Main.getInstance().getPrimaryStage().setScene(this.scene);
        updatePersonalizedGreeting();
    }
    
    public abstract void setElements();

    public void updatePersonalizedGreeting(){
    
  
           
        greeting = new Label("Deluxe Application");

        
        labelHolder.getChildren().clear();
        labelHolder.getChildren().addAll(titleHeader, greeting);
        greeting.setFont(Font.font("Segoe UI", FontWeight.NORMAL,13));
        greeting.setPrefHeight(40);
        greeting.setPrefWidth(Main.DEFAULT_WIDTH);
        greeting.setAlignment(Pos.TOP_CENTER);
        greeting.setTextFill(Color.WHITE);
        greeting.setStyle("-fx-background-color: #232323; -fx-text-fill: #AAAAAA");
    }

    public static void showSuccess(String title, String header, String message){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setGraphic(new ImageView(View.class.getResource("/checkmark.png").toString()));
        a.setTitle(title);
        a.setHeaderText(header);
        a.setContentText(message);
        a.show();
    }

    public static Background getImageBackground(Image img){
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return new Background(bImg);
    }

    public BorderPane getParentFrame() {
        return parentFrame;
    }

    public Scene getScene() {
        return scene;
    }


	public StackPane getStack() {
		return stack;
	}
	
	
	
    
    
}
