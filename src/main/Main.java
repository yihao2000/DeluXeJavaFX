package main;

import controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Model;
import views.*;


import java.sql.SQLException;

public class Main extends Application {
    public static final String VERSION_NAME = "2.1.1";
    public static final int BUILD_NUMBER = 63;
    public static final int DEFAULT_WIDTH = 1024;
    public static final int DEFAULT_HEIGHT = 768;
    
    public static int currAccount = -1;
    public static Model currModel = null;

    private static Main instance = null;
    private static final Stage primaryStage = new Stage();
    
    
    private static ViewLogin vl;
    private static ControllerLogin cl;
    
    private static ViewRegister vr;
    private static ControllerRegister cr;
    
    private static ViewHome vh;
    private static ControllerHome ch;
    

    
    

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        openLogin();

        Main.primaryStage.setTitle("DeluXe");
        Main.primaryStage.setResizable(false);
        Main.primaryStage.show();
    }
    
    public void openHome() {
    	if(vh == null){
            vh = new ViewHome(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            vh.checkRole();
            ch = new ControllerHome(vh);
        }

        //PRELOAD TO PREVENT LAG
//        getViewManageOrdersSet();
//        getViewManageSensorsSet();
        //

        
        vh.changeInto();
    }
    
  
    
    
    public static Main getInstance() {
    	if(instance == null) instance = new Main();
    	return instance;
    }
    
    public Stage getPrimaryStage() {
    	return primaryStage;
    }
    
    public static void openLogin() {
    	if(vl == null) {
    		vl = new ViewLogin(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    		cl = new ControllerLogin(vl);
    		
    	}
    	cl.clearAllField();
    	vl.changeInto();
    	
    }
    
    public void openRegister() {
    	if(vr == null) {
    		vr = new ViewRegister(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    		cr = new ControllerRegister(vr);
    		
    	}
    	cr.clearAllField();
    	vr.changeInto();
    }


	public static ViewHome getVh() {
		return vh;
	}


	public static void setVh(ViewHome vh) {
		Main.vh = vh;
	}


	public static ControllerHome getCh() {
		return ch;
	}


	public static void setCh(ControllerHome ch) {
		Main.ch = ch;
	}
    
    
    

    
}
