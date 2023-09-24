package views;

import java.sql.Timestamp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import main.Main;
import models.WishItem;
import utils.Logger;
import views.frames.ApplicationListItem;
import views.frames.CompanyJobListItem;
import views.frames.SideCard;
import views.frames.WishListItem;

public class ViewHome extends View{
    private final MenuBar menuBar;
    private final Label helloUserLabel, jobLabel, wishListLabel, noWishListLabel, applicationLabel, noApplicationLabel,advertisementListLabel, noAdvertisementLabel, findNextStepOfYourCareerLabel, viewAllWishList, viewAllApplication, viewCompanyAllJob, jobManagedByCompanyLabel, viewJobManagedByCompanyLabel, jobManagedByOtherCompanyLabel, viewJobManagedByOtherCompanyLabel, viewCompanyAdvertisement, advertisementPostedByCompanyLabel, viewAllAdvertisementLabel, noAdvertisementCompanyLabel, noJobManagedByYourCompanyLabel, nobJobManagedByOtherCompanyLabel, viewAllCompanyApplicantLabel, viewRegularApplicantLabel, viewAllRegularApplicantLabel, viewStudentApplicantLabel, viewAllStudentApplicantLabel, noRegularApplicantLabel, noStudentApplicantLabel, noRegularApplicantLabel2, noStudentApplicantLabel2, helloStudentLabel, viewAllInternshipTitleLabel, viewAllInternshipLabel, viewAllAppliedInternshipTitleLabel, viewAllAppliedInternshipLabel, noStudentAppliedInternshipLabel, noStudentInternshipLabel, helloStaffLabel, viewAllRegularReportTitleLabel, viewAllRegularReportLabel, noRegularReportLabel, viewAllStudentReportTitleLabel, viewAllStudentReportLabel, noStudentReportLabel;
    private final Menu menuManage;
    private final MenuItem miLogout, miAddJob, miUpdateJob, miRemoveJob, miPostAdvertisement, miPostInternships, miViewWishList, miViewApplication;
    private final VBox contentHolder, menuBarHolder, contentSplitLeft, contentSplitRight, advertisementList, jobList, jobManagedByCompanyBox, jobManagedByOtherCompanyBox, companyAdvertisementBox, regularApplicantBox, studentApplicantBox, studentAppliedInternshipBox, studentAllInternshipBox, regularReportBox, studentReportBox;
    private final HBox contentSplitHolder, wishListTitleContainer, applicationTitleContainer , jobManagedByCompanyTitleContainer, jobManagedByOtherCompanyTitleContainer, addNewCompanyJobHolder, advertisementTitleContainer, addNewAdvertisementHolder, regularApplicantTitleContainer, studentApplicantTitleContainer, studentInternshipTitleContainer, studentAppliedInternshipTitleContainer, regularReportTitleContainer, studentReportTitleContainer;
    private final Button addNewCompanyJobButton, addNewAdvertisementButton;
    
    
    
    
    private WishListItem wishListItem;
    private final SideCard sideCard;
    private ApplicationListItem applicationListItem;
    private final ScrollPane jobView;
    

    public ViewHome(int w, int h){
    	
        super(w, h);
        
        contentHolder = new VBox();
        menuBarHolder = new VBox();
        helloUserLabel = new Label("Hello User !");
        parentFrame.setCenter(contentHolder);
        menuBar = new MenuBar();
        menuManage = new Menu("Manage");
       
        miLogout = new MenuItem("Log Out");
        miAddJob = new MenuItem("Add Job");
        miUpdateJob = new MenuItem("Update Job");
        miRemoveJob = new MenuItem("Remove Job");
        miPostAdvertisement = new MenuItem("Post Advertisement");
        miPostInternships = new MenuItem("Post Internships");
        miViewWishList = new MenuItem("View WishList");
        miViewApplication = new MenuItem("View Application");
        
        
        jobLabel = new Label("Job");
        wishListLabel = new Label("Your WishList");
        noWishListLabel = new Label("You currently don't have any wish list yet!");
        
        applicationLabel = new Label("Your Application");
        noApplicationLabel = new Label("You currently don't have any application yet!");
        
        sideCard = new SideCard();
        contentSplitHolder = new HBox();
        contentSplitLeft = new VBox();
        contentSplitRight = new VBox();
        
        advertisementListLabel = new Label("Advertisements");
        advertisementList = new VBox();
        noAdvertisementLabel = new Label("There is no advertisement available yet !");
        
        findNextStepOfYourCareerLabel = new Label("Find Next Step of Your Career !");
        
        jobView = new ScrollPane();
        jobList = new VBox();
        
        wishListTitleContainer = new HBox();
        applicationTitleContainer = new HBox();
        
        viewAllWishList = new Label("View All");
        viewAllApplication = new Label("View All");
        
        viewCompanyAllJob = new Label("View All Job");
        
        jobManagedByCompanyTitleContainer = new HBox();
        jobManagedByCompanyLabel = new Label("Job Managed by Your Company");
        jobManagedByCompanyBox = new VBox();
        
        jobManagedByOtherCompanyBox = new VBox();
        
        viewJobManagedByCompanyLabel = new Label("View All");
        viewJobManagedByOtherCompanyLabel = new Label("View All");
        
        jobManagedByOtherCompanyTitleContainer = new HBox();
        
        jobManagedByOtherCompanyLabel = new Label("Job Managed by Other Company");
        
        addNewCompanyJobHolder = new HBox();
        addNewCompanyJobButton = new Button("Add New Job");
        
        
        
        viewCompanyAdvertisement = new Label("View All Advertisement");
        advertisementPostedByCompanyLabel = new Label("Advertisement Posted by Your Company");

        advertisementTitleContainer = new HBox();
        viewAllAdvertisementLabel = new Label("View All");
        
        companyAdvertisementBox = new VBox();
        
        noAdvertisementCompanyLabel = new Label("There is no advertisement posted by your company yet!");
        
        
        addNewAdvertisementHolder = new HBox();
        addNewAdvertisementButton = new Button("Add New Advertisement");
        
        
        noJobManagedByYourCompanyLabel = new Label("There is no job posted by your company yet!");
        nobJobManagedByOtherCompanyLabel = new Label("There is no job posted by other company yet!");
        
        viewAllCompanyApplicantLabel = new Label("View All Applicant");
        
        viewRegularApplicantLabel = new Label("Regular Applicant Application");
        viewAllRegularApplicantLabel = new Label("View All");
        
        
        regularApplicantBox = new VBox();
        studentApplicantBox = new VBox();
        
        regularApplicantTitleContainer = new HBox();
        
        viewStudentApplicantLabel = new Label("Student Applicant Application");
        viewAllStudentApplicantLabel = new Label("View All");
        
        studentApplicantTitleContainer = new HBox();
        
        noRegularApplicantLabel = new Label("There is no Regular User applied to your company yet!");
        noStudentApplicantLabel = new Label("There is no Student who applied internship to your company yet!");
        
        
        noRegularApplicantLabel2 = new Label("There is no Regular User applied to your company yet!");
        noStudentApplicantLabel2 = new Label("There is no Student who applied internship to your company yet!");
        
        
        studentInternshipTitleContainer = new HBox();
        helloStudentLabel = new Label("Hello, Student!");
        viewAllInternshipTitleLabel = new Label("View All Internship Available");
        viewAllInternshipLabel = new Label("View All");
        
        
        viewAllAppliedInternshipTitleLabel = new Label("View All Applied Internship");
        viewAllAppliedInternshipLabel = new Label("View All");
        
        studentAppliedInternshipTitleContainer = new HBox();
        
        
        studentAppliedInternshipBox = new VBox();
        studentAllInternshipBox = new VBox();
        
        noStudentAppliedInternshipLabel = new Label("There is no internship that you applied yet!");
        noStudentInternshipLabel = new Label("There is no student internship available yet!");
        
        helloStaffLabel = new Label("Hello, Staff !");
        viewAllRegularReportTitleLabel = new Label("View All Regular Report");
        viewAllRegularReportLabel = new Label("View All");
        regularReportTitleContainer = new HBox();
        regularReportBox = new VBox();
        
        noRegularReportLabel = new Label("There is no report in your company yet!");
        
        viewAllStudentReportTitleLabel = new Label("View All Student Report");
        
        viewAllStudentReportLabel = new Label("View All");
        noStudentReportLabel = new Label("There is no student report in your company yet!");
        
        studentReportTitleContainer = new HBox();
        studentReportBox = new VBox();
        
        setElements();
    }

    public void setElements(){
    	
        menuBar.getMenus().addAll(menuManage);
        menuBar.prefWidth(1024);
        menuBar.setStyle("-fx-background-color: #ABABAB;");
        

        helloUserLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,28));
        helloUserLabel.setTextFill(Color.WHITE);
        
     	wishListLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	wishListLabel.setTextFill(Color.WHITE);
     	
     	noWishListLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noWishListLabel.setTextFill(Color.WHITE);
     	
     	
     	applicationLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	applicationLabel.setTextFill(Color.WHITE);
     	
     	noApplicationLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noApplicationLabel.setTextFill(Color.WHITE);
        
        contentHolder.setPrefWidth(Main.DEFAULT_WIDTH/5*4);
        contentHolder.setPrefHeight(1000);
        contentHolder.setSpacing(10);
        contentHolder.setStyle("-fx-background-color: #232323");
        contentHolder.setPadding(new Insets(30, 20, 0, 20));

        menuBarHolder.getChildren().add(menuBar);
        menuBarHolder.setStyle("-fx-background-color: #232323");
        menuBarHolder.setPadding(new Insets(5,0,10,0));

        menuBarHolder.setAlignment(Pos.TOP_CENTER);
        menuBarHolder.setPadding(new Insets(0,0,0,0));
        
        contentSplitHolder.setPrefWidth(Main.DEFAULT_WIDTH/5*4);
        contentSplitHolder.setSpacing(15);
        
        contentSplitLeft.setMinWidth(750/2);
        contentSplitLeft.setPadding(new Insets(10, 10, 10, 10));
        contentSplitLeft.setSpacing(5);
        contentSplitLeft.setStyle("-fx-background-color: #393939; -fx-background-radius: 10px;");
        
        contentSplitRight.setMinWidth(750/2);
        contentSplitRight.setPadding(new Insets(10, 10, 10, 10));
        contentSplitRight.setSpacing(5);
        contentSplitRight.setStyle("-fx-background-color: #393939; -fx-background-radius: 10px;");
        
        advertisementListLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
        advertisementListLabel.setPadding(new Insets(10, 0,0 ,0));
     	advertisementListLabel.setTextFill(Color.WHITE);
     	
     	
     	noAdvertisementLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noAdvertisementLabel.setTextFill(Color.WHITE);
     	
     	contentSplitHolder.getChildren().addAll(contentSplitLeft, contentSplitRight);
     	
     	viewAllWishList.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllWishList.setTextFill(Color.LIGHTGRAY);
     	
    	viewAllApplication.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllApplication.setTextFill(Color.LIGHTGRAY);
     	
     	
     	findNextStepOfYourCareerLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,28));
     	findNextStepOfYourCareerLabel.setTextFill(Color.WHITE);
     	
     	jobView.setContent(jobList);
     	jobView.setStyle("-fx-background-color: #232323");
     	
     	jobList.setStyle("-fx-background-color: #232323");
     	jobList.setMinWidth(762);
     	jobList.setSpacing(10);
     	
     	
     	
     	wishListTitleContainer.getChildren().addAll(wishListLabel, viewAllWishList);
     	wishListTitleContainer.setAlignment(Pos.CENTER_LEFT);
     	wishListTitleContainer.setSpacing(165);
     	
     	applicationTitleContainer.getChildren().addAll(applicationLabel, viewAllApplication);
     	applicationTitleContainer.setAlignment(Pos.CENTER_LEFT);
     	applicationTitleContainer.setSpacing(135);
     	
     	
    	viewCompanyAllJob.setFont(Font.font("Segoe UI",FontWeight.BOLD,28));
     	viewCompanyAllJob.setTextFill(Color.WHITE);
     	
     	viewCompanyAdvertisement.setFont(Font.font("Segoe UI",FontWeight.BOLD,28));
     	viewCompanyAdvertisement.setTextFill(Color.WHITE);
     	
     	jobManagedByCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	jobManagedByCompanyLabel.setTextFill(Color.WHITE);
     	
     	
     	jobManagedByOtherCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	jobManagedByOtherCompanyLabel.setTextFill(Color.WHITE);
     	
     	
     	jobManagedByCompanyTitleContainer.getChildren().addAll(jobManagedByCompanyLabel, viewJobManagedByCompanyLabel);
     	jobManagedByCompanyTitleContainer.setPadding(new Insets(10, 0, 0, 0));
     	jobManagedByCompanyTitleContainer.setMinWidth(600);
     	jobManagedByCompanyTitleContainer.setAlignment(Pos.CENTER_LEFT);
     	jobManagedByCompanyTitleContainer.setSpacing(335);
     	
     	
     	
     	advertisementTitleContainer.getChildren().addAll(advertisementPostedByCompanyLabel, viewAllAdvertisementLabel);
     	advertisementTitleContainer.setPadding(new Insets(10, 0, 0, 0));
     	advertisementTitleContainer.setMinWidth(600);
     	advertisementTitleContainer.setAlignment(Pos.CENTER_LEFT);
     	advertisementTitleContainer.setSpacing(270);
     	
     	
     	
     	
     	
     	jobManagedByOtherCompanyTitleContainer.getChildren().addAll(jobManagedByOtherCompanyLabel, viewJobManagedByOtherCompanyLabel);
     	jobManagedByOtherCompanyTitleContainer.setPadding(new Insets(10, 0, 0, 0));
     	jobManagedByOtherCompanyTitleContainer.setMinWidth(600);
     	jobManagedByOtherCompanyTitleContainer.setAlignment(Pos.CENTER_LEFT);
     	jobManagedByOtherCompanyTitleContainer.setSpacing(335);
     	
     	viewJobManagedByCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	viewJobManagedByCompanyLabel.setTextFill(Color.LIGHTGREY);
     	
     	viewJobManagedByOtherCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,16));
     	viewJobManagedByOtherCompanyLabel.setTextFill(Color.LIGHTGREY);
     	
     	
     	jobManagedByCompanyBox.setMaxHeight(300);
     	jobManagedByCompanyBox.setMinWidth(500);
     	jobManagedByCompanyBox.setSpacing(10);
     	
     	
     	
     	
     	
     	jobManagedByOtherCompanyBox.setMaxHeight(300);
     	jobManagedByOtherCompanyBox.setMinWidth(500);
     	jobManagedByOtherCompanyBox.setSpacing(10);
     	
     	
     	addNewCompanyJobHolder.getChildren().addAll(addNewCompanyJobButton);
     	
     	addNewCompanyJobHolder.setMinWidth(723);
     	addNewCompanyJobHolder.setMaxWidth(723);
     	addNewCompanyJobHolder.setPadding(new Insets(0, 0, 0, 0));
     	
     	addNewCompanyJobHolder.setAlignment(Pos.CENTER_RIGHT);
     	
     	
    	addNewCompanyJobButton.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
     	addNewCompanyJobButton.setTextFill(Color.WHITE);
     	addNewCompanyJobButton.setStyle("-fx-background-color: #5DBB63");
     	
     	
     	advertisementPostedByCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	advertisementPostedByCompanyLabel.setTextFill(Color.WHITE);
     	
     	viewAllAdvertisementLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllAdvertisementLabel.setTextFill(Color.LIGHTGRAY);
     	
     	
     	
     	
     	companyAdvertisementBox.setMaxHeight(300);
   
     
     	companyAdvertisementBox.setMinWidth(500);
     	companyAdvertisementBox.setSpacing(10);
     	companyAdvertisementBox.setStyle("-fx-background-color: #232323");
     	
     	
     	noAdvertisementCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noAdvertisementCompanyLabel.setTextFill(Color.WHITE);
     	
     	
     	
     	
     	addNewAdvertisementHolder.getChildren().addAll(addNewAdvertisementButton);
     	addNewAdvertisementHolder.setMinWidth(723);
     	addNewAdvertisementHolder.setMaxWidth(723);
     	addNewAdvertisementHolder.setPadding(new Insets(0, 0, 0, 0));
     	addNewAdvertisementHolder.setAlignment(Pos.CENTER_RIGHT);
     	
     	
     	addNewAdvertisementButton.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,14));
     	addNewAdvertisementButton.setTextFill(Color.WHITE);
     	addNewAdvertisementButton.setStyle("-fx-background-color: #5DBB63");
     	
     	
     	noJobManagedByYourCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noJobManagedByYourCompanyLabel.setTextFill(Color.WHITE);
     	
     	nobJobManagedByOtherCompanyLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	nobJobManagedByOtherCompanyLabel.setTextFill(Color.WHITE);
     	
     	
     	viewAllCompanyApplicantLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,28));
     	viewAllCompanyApplicantLabel.setTextFill(Color.WHITE);
     	
     	
     	viewRegularApplicantLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	viewRegularApplicantLabel.setTextFill(Color.WHITE);
     	viewRegularApplicantLabel.setMinWidth(540);
     	
    	viewStudentApplicantLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	viewStudentApplicantLabel.setTextFill(Color.WHITE);
     	viewStudentApplicantLabel.setMinWidth(675);
     	
     	
     	viewAllRegularApplicantLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllRegularApplicantLabel.setTextFill(Color.LIGHTGRAY);
     	
     	viewAllStudentApplicantLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllStudentApplicantLabel.setTextFill(Color.LIGHTGRAY);
     	
     	regularApplicantBox.setMaxHeight(250);
     	regularApplicantBox.setMinHeight(250);
     	regularApplicantBox.setMinWidth(500);
     	regularApplicantBox.setSpacing(10);
     	
     	studentApplicantBox.setMaxHeight(250);
     	studentApplicantBox.setMinHeight(250);
     	studentApplicantBox.setMinWidth(500);
     	studentApplicantBox.setSpacing(10);

     	regularApplicantTitleContainer.getChildren().addAll(viewRegularApplicantLabel, viewAllRegularApplicantLabel);
     	regularApplicantTitleContainer.setAlignment(Pos.CENTER_LEFT);
     	regularApplicantTitleContainer.setSpacing(135);
     	
     	studentApplicantTitleContainer.getChildren().addAll(viewStudentApplicantLabel, viewAllStudentApplicantLabel);
    
     	
    	noRegularApplicantLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noRegularApplicantLabel.setTextFill(Color.WHITE);
     	
     	noStudentApplicantLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noStudentApplicantLabel.setTextFill(Color.WHITE);
     	
     	
     	noRegularApplicantLabel2.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noRegularApplicantLabel2.setTextFill(Color.WHITE);
     	
     	noStudentApplicantLabel2.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noStudentApplicantLabel2.setTextFill(Color.WHITE);
     	
     	
     	helloStudentLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,28));
        helloStudentLabel.setTextFill(Color.WHITE);
         
        
        viewAllInternshipTitleLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	viewAllInternshipTitleLabel.setTextFill(Color.WHITE);
     	viewAllInternshipTitleLabel.setMinWidth(675);
     	
     	
     	viewAllInternshipLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllInternshipLabel.setTextFill(Color.LIGHTGRAY);
     
         
     	viewAllAppliedInternshipTitleLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
       	viewAllAppliedInternshipTitleLabel.setTextFill(Color.WHITE);
       	viewAllAppliedInternshipTitleLabel.setMinWidth(675);
       	
       	viewAllAppliedInternshipLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllAppliedInternshipLabel.setTextFill(Color.LIGHTGRAY);
       	
  
     	
     	studentInternshipTitleContainer.getChildren().addAll(viewAllInternshipTitleLabel, viewAllInternshipLabel);
     	studentAppliedInternshipTitleContainer.getChildren().addAll(viewAllAppliedInternshipTitleLabel, viewAllAppliedInternshipLabel);
     	
     	
     	
     	studentAppliedInternshipBox.setMinHeight(260);
     	studentAppliedInternshipBox.setMaxHeight(260);
     	studentAppliedInternshipBox.setSpacing(10);
  
     	
     	studentAllInternshipBox.setMinHeight(260);
     	studentAllInternshipBox.setMaxHeight(260);
     	studentAllInternshipBox.setSpacing(10);
     	
     	
     	
     	noStudentAppliedInternshipLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noStudentAppliedInternshipLabel.setTextFill(Color.WHITE);
     	
     	noStudentInternshipLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noStudentInternshipLabel.setTextFill(Color.WHITE);

     	
     	helloStaffLabel.setFont(Font.font("Segoe UI",FontWeight.BOLD,28));
        helloStaffLabel.setTextFill(Color.WHITE);
        
        viewAllRegularReportTitleLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
     	viewAllRegularReportTitleLabel.setTextFill(Color.WHITE);
     	viewAllRegularReportTitleLabel.setMinWidth(675);
     	
    	viewAllRegularReportLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllRegularReportLabel.setTextFill(Color.LIGHTGRAY);
     	
     	regularReportBox.setMinHeight(260);
     	regularReportBox.setMaxHeight(260);
     	
     	regularReportTitleContainer.getChildren().addAll(viewAllRegularReportTitleLabel, viewAllRegularReportLabel);
     	
     	
     	
     	noRegularReportLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noRegularReportLabel.setTextFill(Color.WHITE);
        
     	viewAllStudentReportTitleLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,22));
      	viewAllStudentReportTitleLabel.setTextFill(Color.WHITE);
      	viewAllStudentReportTitleLabel.setMinWidth(675);
      	
      	viewAllStudentReportLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,12));
     	viewAllStudentReportLabel.setTextFill(Color.LIGHTGRAY);
     	
    	noStudentReportLabel.setFont(Font.font("Segoe UI",FontWeight.LIGHT,16));
     	noStudentReportLabel.setTextFill(Color.WHITE);
     	
     	
     	
     	studentReportTitleContainer.getChildren().addAll(viewAllStudentReportTitleLabel, viewAllStudentReportLabel);
     	
     	studentReportBox.setMinHeight(260);
     	studentReportBox.setMaxHeight(260);
     	
     	
        parentFrame.setTop(menuBarHolder);
        
        
        
        
        parentFrame.setLeft(sideCard);
        
        parentFrame.setCenter(contentHolder);
        

        
        
    }
    
    public void loadStaffReportHeader() {
    	contentHolder.getChildren().addAll(helloStaffLabel, regularReportTitleContainer, regularReportBox, studentReportTitleContainer, studentReportBox);
    }
    
    public void loadStudentDashboard() {
    	contentHolder.getChildren().addAll(helloStudentLabel,studentAppliedInternshipTitleContainer, studentAppliedInternshipBox, studentInternshipTitleContainer, studentAllInternshipBox);
    }
    
    public void loadCompanyApplicantHeader() {
    	contentHolder.getChildren().addAll(viewAllCompanyApplicantLabel, regularApplicantTitleContainer, regularApplicantBox, studentApplicantTitleContainer, studentApplicantBox);
    }
    
    public void loadCompanyJobHeader() {
    	contentHolder.getChildren().addAll(viewCompanyAllJob,addNewCompanyJobHolder, jobManagedByCompanyTitleContainer, jobManagedByCompanyBox, jobManagedByOtherCompanyTitleContainer, jobManagedByOtherCompanyBox);
    	
    }
    
    public void loadCompanyAdvertisementHeader() {
    	contentHolder.getChildren().addAll(viewCompanyAdvertisement , addNewAdvertisementHolder,advertisementTitleContainer,companyAdvertisementBox);
    }
    
   
    
    
    public void clearJobListContent() {
    	jobList.getChildren().clear();
    }

    public void checkRole(){
    	menuManage.getItems().clear();
    	menuManage.getItems().add(miLogout);
    	
    
        if(Main.currAccount == 0){
            Logger.log("Menu", "User role is Regular User ! Showing User menu");
            loadDashboardContent();
            
            
        }else if(Main.currAccount == 1) {
        	Logger.log("Menu", "User role is Company ! Showing Company menu");
        
        	
        }
        
    }
    
   
    
   
    
    public void loadJobContent() {
    	
    	contentHolder.getChildren().addAll(findNextStepOfYourCareerLabel, jobView);
    
    	
    }
    
    public void clearContent() {
    	contentHolder.getChildren().clear();
    }
    
    public void loadDashboardContent() {
    	 contentHolder.getChildren().addAll(helloUserLabel);
         contentHolder.getChildren().addAll(contentSplitHolder);

         
         contentHolder.getChildren().addAll(advertisementListLabel, advertisementList);
    }
    
    public void displayNoAdvertisement() {
    	advertisementList.getChildren().add(noAdvertisementLabel);
    }
    
    
    
  
    
    
    public void displayNoWishList() {
    	contentSplitLeft.getChildren().addAll(noWishListLabel);
    }
    

    
    
    public void displayNoApplication() {
    	contentSplitRight.getChildren().addAll(noApplicationLabel);
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }


    public MenuItem getMiLogout() {
        return miLogout;
    }



    public VBox getContentHolder() {
        return contentHolder;
    }

    public VBox getMenuBarHolder() {
        return menuBarHolder;
    }

	public SideCard getSideCard() {
		return sideCard;
	}

	public WishListItem getWishListItem() {
		return wishListItem;
	}

	public void setWishListItem(WishListItem wishListItem) {
		this.wishListItem = wishListItem;
	}

	public ApplicationListItem getApplicationListItem() {
		return applicationListItem;
	}

	public void setApplicationListItem(ApplicationListItem applicationListItem) {
		this.applicationListItem = applicationListItem;
	}

	public Label getHelloUserLabel() {
		return helloUserLabel;
	}


	public Label getJobLabel() {
		return jobLabel;
	}

	public Label getWishListLabel() {
		return wishListLabel;
	}

	public Label getNoWishListLabel() {
		return noWishListLabel;
	}

	public Label getApplicationLabel() {
		return applicationLabel;
	}

	public Label getNoApplicationLabel() {
		return noApplicationLabel;
	}

	public Menu getMenuManage() {
		return menuManage;
	}



	public MenuItem getMiAddJob() {
		return miAddJob;
	}

	public MenuItem getMiUpdateJob() {
		return miUpdateJob;
	}

	public MenuItem getMiRemoveJob() {
		return miRemoveJob;
	}

	public MenuItem getMiPostAdvertisement() {
		return miPostAdvertisement;
	}

	public MenuItem getMiPostInternships() {
		return miPostInternships;
	}

	public MenuItem getMiViewWishList() {
		return miViewWishList;
	}

	public MenuItem getMiViewApplication() {
		return miViewApplication;
	}

	public VBox getContentSplitLeft() {
		return contentSplitLeft;
	}

	public VBox getContentSplitRight() {
		return contentSplitRight;
	}

	public HBox getContentSplitHolder() {
		return contentSplitHolder;
	}

	public Label getAdvertisementListLabel() {
		return advertisementListLabel;
	}

	public Label getNoAdvertisementLabel() {
		return noAdvertisementLabel;
	}

	public VBox getAdvertisementList() {
		return advertisementList;
	}

	public Label getFindNextStepOfYourCareerLabel() {
		return findNextStepOfYourCareerLabel;
	}

	public VBox getJobList() {
		return jobList;
	}

	public ScrollPane getJobView() {
		return jobView;
	}

	public Label getViewAllWishList() {
		return viewAllWishList;
	}

	public Label getViewAllApplication() {
		return viewAllApplication;
	}

	public HBox getWishListTitleContainer() {
		return wishListTitleContainer;
	}

	public HBox getApplicationTitleContainer() {
		return applicationTitleContainer;
	}

	public Label getViewCompanyAllJob() {
		return viewCompanyAllJob;
	}

	public Label getJobManagedByCompanyLabel() {
		return jobManagedByCompanyLabel;
	}

	public Label getViewJobManagedByCompanyLabel() {
		return viewJobManagedByCompanyLabel;
	}

	public VBox getJobManagedByCompanyBox() {
		return jobManagedByCompanyBox;
	}

	public HBox getJobManagedByCompanyTitleContainer() {
		return jobManagedByCompanyTitleContainer;
	}

	public Label getJobManagedByOtherCompanyLabel() {
		return jobManagedByOtherCompanyLabel;
	}

	public Label getViewJobManagedByOtherCompanyLabel() {
		return viewJobManagedByOtherCompanyLabel;
	}

	public VBox getJobManagedByOtherCompanyBox() {
		return jobManagedByOtherCompanyBox;
	}

	
	public HBox getJobManagedByOtherCompanyTitleContainer() {
		return jobManagedByOtherCompanyTitleContainer;
	}

	public HBox getAddNewCompanyJobHolder() {
		return addNewCompanyJobHolder;
	}

	public Button getAddNewCompanyJobButton() {
		return addNewCompanyJobButton;
	}

	public Label getViewCompanyAdvertisement() {
		return viewCompanyAdvertisement;
	}

	public Label getAdvertisementPostedByCompanyLabel() {
		return advertisementPostedByCompanyLabel;
	}

	public Label getViewAllAdvertisementLabel() {
		return viewAllAdvertisementLabel;
	}

	public VBox getCompanyAdvertisementBox() {
		return companyAdvertisementBox;
	}

	public HBox getAdvertisementTitleContainer() {
		return advertisementTitleContainer;
	}

	public Label getNoAdvertisementCompanyLabel() {
		return noAdvertisementCompanyLabel;
	}

	public HBox getAddNewAdvertisementHolder() {
		return addNewAdvertisementHolder;
	}

	public Button getAddNewAdvertisementButton() {
		return addNewAdvertisementButton;
	}

	public Label getNoJobManagedByYourCompanyLabel() {
		return noJobManagedByYourCompanyLabel;
	}

	public Label getNobJobManagedByOtherCompanyLabel() {
		return nobJobManagedByOtherCompanyLabel;
	}

	public Label getViewAllCompanyApplicantLabel() {
		return viewAllCompanyApplicantLabel;
	}

	public Label getViewRegularApplicantLabel() {
		return viewRegularApplicantLabel;
	}

	public Label getViewAllRegularApplicantLabel() {
		return viewAllRegularApplicantLabel;
	}

	public Label getViewStudentApplicantLabel() {
		return viewStudentApplicantLabel;
	}

	public Label getViewAllStudentApplicantLabel() {
		return viewAllStudentApplicantLabel;
	}

	public VBox getRegularApplicantBox() {
		return regularApplicantBox;
	}

	public VBox getStudentApplicantBox() {
		return studentApplicantBox;
	}

	public HBox getRegularApplicantTitleContainer() {
		return regularApplicantTitleContainer;
	}

	public HBox getStudentApplicantTitleContainer() {
		return studentApplicantTitleContainer;
	}

	public Label getNoRegularApplicantLabel() {
		return noRegularApplicantLabel;
	}

	public Label getNoStudentApplicantLabel() {
		return noStudentApplicantLabel;
	}

	public Label getNoRegularApplicantLabel2() {
		return noRegularApplicantLabel2;
	}

	public Label getNoStudentApplicantLabel2() {
		return noStudentApplicantLabel2;
	}

	public Label getHelloStudentLabel() {
		return helloStudentLabel;
	}

	public Label getViewAllInternshipTitleLabel() {
		return viewAllInternshipTitleLabel;
	}

	public Label getViewAllInternshipLabel() {
		return viewAllInternshipLabel;
	}

	public Label getViewAllAppliedInternshipTitleLabel() {
		return viewAllAppliedInternshipTitleLabel;
	}

	public Label getViewAllAppliedInternshipLabel() {
		return viewAllAppliedInternshipLabel;
	}

	public VBox getStudentAppliedInternshipBox() {
		return studentAppliedInternshipBox;
	}

	public VBox getStudentAllInternshipBox() {
		return studentAllInternshipBox;
	}

	public HBox getStudentInternshipTitleContainer() {
		return studentInternshipTitleContainer;
	}

	public HBox getStudentAppliedInternshipTitleContainer() {
		return studentAppliedInternshipTitleContainer;
	}

	public Label getNoStudentAppliedInternshipLabel() {
		return noStudentAppliedInternshipLabel;
	}

	public Label getNoStudentInternshipLabel() {
		return noStudentInternshipLabel;
	}

	public Label getHelloStaffLabel() {
		return helloStaffLabel;
	}

	public Label getViewAllReportTitleLabel() {
		return viewAllRegularReportTitleLabel;
	}

	public Label getViewAllReportLabel() {
		return viewAllRegularReportLabel;
	}

	public VBox getReportBox() {
		return regularReportBox;
	}

	public HBox getReportTitleContainer() {
		return regularReportTitleContainer;
	}

	public Label getViewAllRegularReportTitleLabel() {
		return viewAllRegularReportTitleLabel;
	}

	public Label getViewAllRegularReportLabel() {
		return viewAllRegularReportLabel;
	}

	public Label getNoRegularReportLabel() {
		return noRegularReportLabel;
	}

	public VBox getRegularReportBox() {
		return regularReportBox;
	}

	public HBox getRegularReportTitleContainer() {
		return regularReportTitleContainer;
	}

	public Label getViewAllStudentReportTitleLabel() {
		return viewAllStudentReportTitleLabel;
	}

	public Label getViewAllStudentReportLabel() {
		return viewAllStudentReportLabel;
	}

	public Label getNoStudentReportLabel() {
		return noStudentReportLabel;
	}

	public VBox getStudentReportBox() {
		return studentReportBox;
	}

	public HBox getStudentReportTitleContainer() {
		return studentReportTitleContainer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    
    
}
