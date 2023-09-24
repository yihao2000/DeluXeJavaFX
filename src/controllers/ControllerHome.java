package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import jfxtras.labs.scene.control.window.CloseIcon;
import jfxtras.labs.scene.control.window.MinimizeIcon;
import jfxtras.labs.scene.control.window.Window;
import main.Main;
import utils.Connect;
import utils.Logger;
import views.View;
import views.ViewHome;
import views.frames.AdvertisementListItem;
import views.frames.AllInternshipListItem;
import views.frames.ApplicationListItem;
import views.frames.CompanyAdvertisementList;
import views.frames.CompanyJobListItem;
import views.frames.JobListItem;
import views.frames.OtherCompanyJobListItem;
import views.frames.PopUpAddNewAdvertisement;
import views.frames.PopUpAddNewInternship;
import views.frames.PopUpAddNewJob;
import views.frames.PopUpAllApplicationListItem;
import views.frames.PopUpAllInternshipDetail;
import views.frames.PopUpAllWishListItems;
import views.frames.PopUpApplicationDetail;
import views.frames.PopUpAppliedInternshipDetail;
import views.frames.PopUpApplyConfirmation;
import views.frames.PopUpApplyInternshipConfirmation;
import views.frames.PopUpCompanyManagedJobDetail;
import views.frames.PopUpJobDetail;
import views.frames.PopUpRegularApplicationDetail;
import views.frames.PopUpRegularReportDetail;
import views.frames.PopUpStudentApplicationDetail;
import views.frames.PopUpStudentReportDetail;
import views.frames.RegularApplicationListItem;
import views.frames.RegularReportListItem;
import views.frames.StudentApplicationListItem;
import views.frames.StudentAppliedInternshipListItem;
import views.frames.StudentReportListItem;
import views.frames.WishListItem;
import models.*;

import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ControllerHome extends ViewController{
    private final ViewHome vh;
//    private final ArrayList<Window> activeWindows;

    public ControllerHome(View view) {
        super(view);

//        activeWindows = new ArrayList<>();

        vh = (ViewHome)view;
        
        if(Main.currAccount == 0) {
        	loadWishList();
        	loadApplication();
        	loadAdvertisement();
        	setUserSideBar();
       
        	
        	vh.getSideCard().getSideCardContent().getFindJobButton().setOnAction(e ->{
        		vh.clearJobListContent();
        		vh.clearContent();
        		vh.loadJobContent();
        		loadJobList();
        		
        	});
        	
        	vh.getSideCard().getSideCardContent().getDashboardButton().setOnAction(e ->{
        		vh.clearContent();
        		vh.loadDashboardContent();
        		
        		clearWishList();
        		clearApplication();
        		loadWishList();
            	loadApplication();
        	});
        }else if(Main.currAccount == 1) {
        	setCompanySideBar();
        	vh.loadCompanyJobHeader();
        	loadCompanyJobList();
        	
        	clearOtherCompanyJobList();
    		loadOtherCompanyJobList();
        	
        	
        	vh.getSideCard().getSideCardContent().getCompanyJobButton().setOnAction(e -> {
        		
        		vh.clearContent();
        		clearCompanyJobList();
        		vh.loadCompanyJobHeader();
        		loadCompanyJobList();
        		
        		clearOtherCompanyJobList();
        		loadOtherCompanyJobList();
        		
        	});
        	
        	vh.getSideCard().getSideCardContent().getCompanyAdvertisementButton().setOnAction(e -> {
        		vh.clearContent();
        		clearCompanyAdvertisementList();
        		vh.loadCompanyAdvertisementHeader();
        		loadCompanyAdvertisementList();
        	});
        	
        	vh.getSideCard().getSideCardContent().getCompanyApplicantButton().setOnAction(e -> {
        		 reloadCompanyApplicantPage();
        		
        		
        	});
        	
        	vh.getSideCard().getSideCardContent().getStudentDashboardButton().setOnAction(e -> {
        		vh.clearContent();
        		clearAllStudentInternship();
        		clearStudentApplicantList();
  
            	vh.loadStudentDashboard();
            	
            	loadAllStudentInternship();
            	loadStudentAppliedInternship();
        	});
        	
        	
        
        }else if(Main.currAccount == 2) {
        	setStudentSidebar();
        	vh.loadStudentDashboard();
        	
        	loadAllStudentInternship();
        	loadStudentAppliedInternship();
        }else if(Main.currAccount == 3) {
        	setStaffSideBar();
        	
        	vh.loadStaffReportHeader();
        	
        	loadStaffRegularReportList();
        	loadStaffStudentReportList();
        	
        	vh.getSideCard().getSideCardContent().getViewReportButton().setOnAction(e -> {
        		
        	});
        	
        }
        
        vh.getMiLogout().setOnAction(e -> {
        	if(Main.currModel instanceof Company) {
        	vh.clearContent();
    		clearCompanyAdvertisementList();
    		clearCompanyJobList();
    		clearOtherCompanyJobList();
   
        	}else if(Main.currModel instanceof User) {
        		vh.clearJobListContent();
        		vh.clearContent();
        		clearWishList();
        		clearApplication();
        	}else if(Main.currModel instanceof Student) {
        		vh.clearContent();
        		
        		clearAllStudentInternship();
        		clearStudentAppliedInternship();
        	}else if(Main.currModel instanceof Staff) {
        		vh.clearContent();
        		
        		clearStaffRegularReportList();
        		clearStaffReportHeader();
        		
        		clearStaffRegularReportList();
        		clearStaffStudentReportList();
        	}
        	Main.currModel = null;
        	Main.openLogin();
        	Main.setVh(null);
        	Main.setCh(null);
        	
        });
        
          
    }
    
    
    public void loadStaffStudentReportList() {
    	
    	vh.getViewAllStudentReportLabel().setOnMouseClicked(e -> {
    		popUpAllStudentReport();
    	});
    	
    	ArrayList<Job> jobList = new Job(0, "", "", 0, null).getJobFromCompanyId(((Staff)Main.currModel).getCompany().getId());
    	
    	ArrayList<Internship> internshipList = new ArrayList<>();
    	
    	ArrayList<StudentReport> reportList = new ArrayList<>();    	
    	
    	for (Job job : jobList) {
			if(job.getInternshipByJobId() != null) {
				internshipList.add(job.getInternshipByJobId());
			}
		}
    	
    	ArrayList<StudentApplication> applicationList = new ArrayList<>();
    	
    	for (Internship internship : internshipList) {
			if(StudentApplication.getApplicationFromInternshipId(internship.getId() ) != null) {
				applicationList.addAll(StudentApplication.getApplicationFromInternshipId(internship.getId()));
			}
		}
    	
    	for (StudentApplication studentApplication : applicationList) {
			if(studentApplication.getStudentReportFromStudentApplicationId() != null) {
				reportList.add(studentApplication.getStudentReportFromStudentApplicationId());
			}
		}
    	
    	if(reportList.isEmpty()) {
    		
    	}else {
    		int limit = 0;
    		for (StudentReport report : reportList) {
    			if(limit < 3) {
    				StudentReportListItem item = new StudentReportListItem(report.getApplication().getInternship().getName(), report.getApplication().getStudent().getName());
    				item.getViewButton().setOnAction(e -> {
    					popUpStudentReportDetail(report);
    				});
    				
    				vh.getStudentReportBox().getChildren().addAll(item);
    				
    				
    			}
    			
    			limit++;
    			
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
    }
    
    public void popUpAllStudentReport() {
    	
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Regular Application");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(777);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(775);
    	container.setMaxWidth(775);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	
    	ArrayList<Job> jobList = new Job(0, "", "", 0, null).getJobFromCompanyId(((Staff)Main.currModel).getCompany().getId());
    	
    	ArrayList<Internship> internshipList = new ArrayList<>();
    	
    	ArrayList<StudentReport> reportList = new ArrayList<>();    	
    	
    	for (Job job : jobList) {
			if(job.getInternshipByJobId() != null) {
				internshipList.add(job.getInternshipByJobId());
			}
		}
    	
    	ArrayList<StudentApplication> applicationList = new ArrayList<>();
    	
    	for (Internship internship : internshipList) {
			if(StudentApplication.getApplicationFromInternshipId(internship.getId() ) != null) {
				applicationList.addAll(StudentApplication.getApplicationFromInternshipId(internship.getId()));
			}
		}
    	
    	for (StudentApplication studentApplication : applicationList) {
			if(studentApplication.getStudentReportFromStudentApplicationId() != null) {
				reportList.add(studentApplication.getStudentReportFromStudentApplicationId());
			}
		}
    	
    	if(reportList.isEmpty()) {
    		
    	}else {
    	
    		for (StudentReport report : reportList) {
    		
    				StudentReportListItem item = new StudentReportListItem(report.getApplication().getInternship().getName(), report.getApplication().getStudent().getName());
    				item.getViewButton().setOnAction(e -> {
    					popUpStudentReportDetail(report);
    				});
    				
    				container.getChildren().addAll(item);
    				
    				
    			
    		
    			
    		}
    	}
    	
    	
    	
    	
    	
    	container.getChildren().addAll(buttonContainer);
    	
    	vh.getStack().getChildren().add(darkened);
    }
    
    
    public void loadStaffRegularReportList() {
    	
    	vh.getViewAllRegularReportLabel().setOnMouseClicked(e -> {
    		popUpAllRegularReport();
    	});
    	
    	ArrayList<Job> jobList = new Job(0, "", "", 0, null).getJobFromCompanyId(((Staff)Main.currModel).getCompany().getId());
    	
    	ArrayList<Application> applicationList = new ArrayList<>();
    	
    	ArrayList<Report> reportList = new ArrayList<>();
    	
    	
    	
    	for (Job job : jobList) {
			ArrayList<Application> tempApplicationList = Application.getApplicationFromJobId(job.getId());
			applicationList.addAll(tempApplicationList);
			
			
    		
		}
    	
    
   
    	for (Application application : applicationList) {
    		
    		if(application.getReportFromApplicationId() != null) {
    			reportList.add(application.getReportFromApplicationId());
    		}
	
		}
    
    	if(reportList.isEmpty()) {
    		vh.getRegularReportBox().getChildren().add(vh.getNoRegularReportLabel());
    	}else {
    		
    		int limit = 0;
    		for (Report report : reportList) {
    			if(limit < 3) {
    				
    				RegularReportListItem item = new RegularReportListItem(report.getApplication().getJob().getName(), report.getApplication().getUser().getName());
    				
    				item.getViewButton().setOnAction(e -> {
    					popUpRegularReportDetail(report);
    				});
    				
    				vh.getRegularReportBox().getChildren().add(item);
    			}
			}
    	}
    	
    	
    	
    }
    
    public void popUpAllRegularReport() {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Regular Application");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(777);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(775);
    	container.setMaxWidth(775);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	
    	ArrayList<Job> jobList = new Job(0, "", "", 0, null).getJobFromCompanyId(((Staff)Main.currModel).getCompany().getId());
    	
    	ArrayList<Application> applicationList = new ArrayList<>();
    	
    	ArrayList<Report> reportList = new ArrayList<>();
    	
    	
    	
    	for (Job job : jobList) {
			ArrayList<Application> tempApplicationList = Application.getApplicationFromJobId(job.getId());
			applicationList.addAll(tempApplicationList);
			
			
    		
		}
    	
    	for (Application applicatino : applicationList) {
			Logger.log("DB", applicatino.getCvDesc());
		}
    	
   
    	for (Application application : applicationList) {
    		
    		if(application.getReportFromApplicationId() != null) {
    			reportList.add(application.getReportFromApplicationId());
    		}
	
		}
    	
    	
    	if(!reportList.isEmpty()) {
    		
    		for (Report report : reportList) {
    			RegularReportListItem item = new RegularReportListItem(report.getApplication().getJob().getName(), report.getApplication().getUser().getName());
    			
    			item.getViewButton().setOnAction(e -> {
    				popUpRegularReportDetail(report);
    			});
    			
    			
    			container.getChildren().add(item);
			}
    		
    	}
    	
    	
    	container.getChildren().addAll(buttonContainer);
    	
    	vh.getStack().getChildren().add(darkened);
    	
    }
    
    public void popUpStudentReportDetail(StudentReport report) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpStudentReportDetail popUp = new PopUpStudentReportDetail(report.getApplication().getInternship().getJob().getName(), report.getApplication().getInternship().getJob().getDescription(), report.getApplication().getDate(), report.getApplication().getCvDesc(), report.getApplication().getTranscriptDesc());

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    }
    
    public void popUpRegularReportDetail(Report report) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpRegularReportDetail popUp = new PopUpRegularReportDetail(report.getApplication().getJob().getName(), report.getApplication().getJob().getDescription(), report.getApplication().getJob().getSalary(), report.getApplication().getDate(), report.getApplication().getCvDesc(), report.getApplication().getTranscriptDesc());

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    }
    
    public void clearStaffStudentReportList() {
    	vh.getStudentReportBox().getChildren().clear();
    }
    
    public void clearStaffRegularReportList() {
    	vh.getReportBox().getChildren().clear();
    }
    
    
    public void setStaffSideBar() {
    	vh.getSideCard().getSideCardContent().getChildren().addAll(vh.getSideCard().getSideCardContent().getViewReportButton());
    }
    
    public void clearStaffReportHeader() {
    	vh.getContentHolder().getChildren().clear();
    }
    
    
    public boolean validateInternshipApplied(Model model) {
    	Connect con = Connect.getConnection();
    	Internship internship = (Internship)model;
    	String sql = String.format("SELECT * FROM `studentapplications` WHERE `InternshipID` = %d AND `StudentID` = %d", internship.getId(), ((Student)Main.currModel).getId());
    	
    	ResultSet res = con.executeQuery(sql);
    	
    	try {
			if(res.next()) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return true;
    }
    
    public void popUpAllStudentInternship() {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Regular Application");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(777);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(775);
    	container.setMaxWidth(775);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	
    	try {
			List<Model> internshipList = new Internship(0, "", "", null).getAll();
			
			
			if(!internshipList.isEmpty()) {
				
				
					for (Model model : internshipList) {
						AllInternshipListItem internshipItem = new AllInternshipListItem(((Internship)model).getName(), ((Internship)model).getDesc(),  ((Internship)model).getJob().getCompany().getName());
						
						
						container.getChildren().addAll(internshipItem);
						
						
						if(!validateInternshipApplied(model)) {
							internshipItem.getApplyButton().setDisable(true);
						}
						
						internshipItem.getViewButton().setOnAction(e -> {
							popUpAllInternshipDetail(model);
						});
						
						internshipItem.getApplyButton().setOnAction(e -> {
							popUpApplyInternshipConfirmation(model);
							vh.getStack().getChildren().remove(darkened);						});
					}
				
				
			}else {
				vh.getContentHolder().getChildren().add(vh.getNoStudentInternshipLabel());
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.log("DB", "Failed to retrieve student intership list!");
		}
    	
    	
    	container.getChildren().addAll(buttonContainer);
    	
    	vh.getStack().getChildren().add(darkened);
    	
    	
    }
    
    public void popUpAllStudentAppliedInternship() {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Regular Application");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(777);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(775);
    	container.setMaxWidth(775);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	
    	
    	ArrayList<StudentApplication> studentApplicationList = StudentApplication.getStudentApplicationFromStudentId();
    	
    
    	
    	if(!studentApplicationList.isEmpty()) {
    		
    			
    			for (StudentApplication studentApplication : studentApplicationList) {
    				StudentAppliedInternshipListItem item = new StudentAppliedInternshipListItem(studentApplication.getInternship().getName(), studentApplication.getInternship().getDesc(), studentApplication.getInternship().getJob().getCompany().getName());
    				
    				item.getViewButton().setOnAction(e -> {
    					popUpAppliedInternshipDetail(studentApplication);
    				});
    				
    				item.getRemoveButton().setOnAction(e -> {
    					try {
							studentApplication.delete();
							clearStudentAppliedInternship();
							loadStudentAppliedInternship();
							
							clearAllStudentInternship();
							loadAllStudentInternship();
							
							vh.getStack().getChildren().remove(darkened);
							popUpAllStudentAppliedInternship();
							
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				});
    				
    				
    				container.getChildren().addAll(item);
    				
    				
    		}
    			
    			
			
    	}
    	
    	
    	
    	
    	
    	
    	
    	vh.getStack().getChildren().add(darkened);
    	container.getChildren().addAll(buttonContainer);
    	
    	
    }
    
    public void loadStudentAppliedInternship() {
    	vh.getViewAllAppliedInternshipLabel().setOnMouseClicked(e -> {
    		popUpAllStudentAppliedInternship();
    	});
    	
    	ArrayList<StudentApplication> studentApplicationList = StudentApplication.getStudentApplicationFromStudentId();
    	
    	int limit = 0;
    	
    	if(!studentApplicationList.isEmpty()) {
    		if(limit < 3) {
    			
    			for (StudentApplication studentApplication : studentApplicationList) {
    				StudentAppliedInternshipListItem item = new StudentAppliedInternshipListItem(studentApplication.getInternship().getName(), studentApplication.getInternship().getDesc(), studentApplication.getInternship().getJob().getCompany().getName());
    				
    				item.getViewButton().setOnAction(e -> {
    					popUpAppliedInternshipDetail(studentApplication);
    				});
    				
    				item.getRemoveButton().setOnAction(e -> {
    					try {
							studentApplication.delete();
							clearStudentAppliedInternship();
							loadStudentAppliedInternship();
							
							clearAllStudentInternship();
							loadAllStudentInternship();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				});
    				
    				
    				vh.getStudentAppliedInternshipBox().getChildren().addAll(item);
    				
    				limit++;
    		}
    			
    			
			}
    	}else {
    		vh.getContentHolder().getChildren().add(vh.getNoStudentAppliedInternshipLabel());
    	}
    	
    }
    
    public void popUpAppliedInternshipDetail(StudentApplication studentApplication) {
    	Logger.log("MASUk", "EKO");
    	Internship internship = studentApplication.getInternshipFromStudentApplicationId();
    	
    	Job job = internship.getJobFromInternshipId();
    	
    	
    	if(job == null) {
    		
    	}else {
    		
    		Company company = job.getCompanyFromJobId();
    		
    		VBox darkened = new VBox();
        	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
        	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
        	darkened.setAlignment(Pos.CENTER);
        	

        	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
        	
        	PopUpAppliedInternshipDetail popUp = new PopUpAppliedInternshipDetail(internship.getName(), internship.getDesc(), company.getName(), studentApplication.getDate(), studentApplication.getCvDesc(), studentApplication.getTranscriptDesc());
        	
        	darkened.getChildren().add(popUp);
        	vh.getStack().getChildren().add(darkened);
        	
        	popUp.getCloseButton().setOnAction(e -> {
        		vh.getStack().getChildren().remove(darkened);
        	});
    	}
    	
    }
    
    
    public void popUpAllInternshipDetail(Model model) {
    	Internship internship = (Internship)model;
    	
    	Job job = internship.getJobFromInternshipId();
    	
    	if(job == null) {
    		
    	}else {
    		Company company = job.getCompanyFromJobId();
    		
    		
    		VBox darkened = new VBox();
        	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
        	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
        	darkened.setAlignment(Pos.CENTER);
        	

        	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
        	
        	
        	PopUpAllInternshipDetail popUp = new PopUpAllInternshipDetail(internship.getName(), internship.getDesc(), company.getName(), company.getEmail(), company.getPhone(), company.getEmail());

        	darkened.getChildren().add(popUp);
        	vh.getStack().getChildren().add(darkened);
        	popUp.getCloseButton().setOnAction(e -> {
        		vh.getStack().getChildren().remove(darkened);
        	});
        	
        	
    		
    	}
    	
    	
    }
    
    public void clearStudentAppliedInternship() {
    	vh.getStudentAppliedInternshipBox().getChildren().clear();
    }
    
    public void clearAllStudentInternship() {
    	vh.getStudentAllInternshipBox().getChildren().clear();
    }
    
    
    public void loadAllStudentInternship() {
    	
    	vh.getViewAllInternshipLabel().setOnMouseClicked(e -> {
    		popUpAllStudentInternship();
    	});
    	try {
			List<Model> internshipList = new Internship(0, "", "", null).getAll();
			
			
			int limit = 0;
			if(!internshipList.isEmpty()) {
				
				if(limit < 3) {
					for (Model model : internshipList) {
						AllInternshipListItem internshipItem = new AllInternshipListItem(((Internship)model).getName(), ((Internship)model).getDesc(),  ((Internship)model).getJob().getCompany().getName());
						
						
						vh.getStudentAllInternshipBox().getChildren().addAll(internshipItem);
						
						
						if(!validateInternshipApplied(model)) {
							internshipItem.getApplyButton().setDisable(true);
						}
						
						internshipItem.getViewButton().setOnAction(e -> {
							popUpAllInternshipDetail(model);
						});
						
						internshipItem.getApplyButton().setOnAction(e -> {
							popUpApplyInternshipConfirmation(model);
						});
					}
				}
				
				limit++;
			}else {
				vh.getContentHolder().getChildren().add(vh.getNoStudentInternshipLabel());
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.log("DB", "Failed to retrieve student intership list!");
		}
    	
    }
    
    public void popUpApplyInternshipConfirmation(Model model) {
    	Internship internship = (Internship)model;
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpApplyInternshipConfirmation popUp = new PopUpApplyInternshipConfirmation(internship, internship.getJob().getCompany());
    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	popUp.getApplyButton().setOnAction(e -> {
    		String cvDesc, transcriptDesc;
    		cvDesc = popUp.getTfCvDesc().getText();
    		transcriptDesc = popUp.getTfTranscriptDesc().getText();
    		
    		popUp.getAlert().setTitle("CV Submission Failed !");
    		popUp.getAlert().setContentText("");
    		if(cvDesc.isEmpty()) {
    			 popUp.getAlert().setHeaderText("CV Description must be filled !");
                 popUp.getAlert().show();
    			
    			
    		}else if(transcriptDesc.isEmpty()) {
    			 popUp.getAlert().setHeaderText("Transcript Description must be filled !");
                 popUp.getAlert().show();
    		}else {
    			
    			try {
					new StudentApplication(0, null, cvDesc, transcriptDesc, internship, ((Student)Main.currModel)).insert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			vh.getStack().getChildren().remove(darkened);
    			
    			clearStudentAppliedInternship();
    			clearAllStudentInternship();
    			
    			loadStudentAppliedInternship();
    			loadAllStudentInternship();
    			
    			
    		}
    		
    		
    	});
    	
    	
    	
    	
    }
    
    public void clearStudentDashboard() {
    	vh.getContentHolder().getChildren().clear();
    }
    
    public void setStudentSidebar() {
    	vh.getSideCard().getSideCardContent().getChildren().addAll(vh.getSideCard().getSideCardContent().getStudentDashboardButton());
    }
    
    public void reloadCompanyApplicantPage() {
    	vh.clearContent();
		
		
		vh.loadCompanyApplicantHeader();
		
		clearRegularApplicantList();
		loadRegularApplicantList();
		
		clearStudentApplicantList();
		loadStudentApplicantList();
		
    }
    
    
    
    public void popUpRegularApplicationDetail(Application application) {
    	
    	
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpRegularApplicationDetail popUp = new PopUpRegularApplicationDetail(application.getJob().getName(), application.getUser().getName(), application.getUser().getPhone(), application.getUser().getEmail(), application.getCvDesc(), application.getTranscriptDesc());

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    }
    
    public void loadRegularApplicantList() {
    	vh.getViewAllRegularApplicantLabel().setOnMouseClicked(e -> {
    		popUpAllRegularApplicantList();
    	});
    	ArrayList<Application> applicationList = new ArrayList<>();
    	try {
    		applicationList = Application.getApplicationFromCurrentCompany();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	boolean accepted = true;
    	for (Application application : applicationList) {
    		 accepted = validateApplicationAccepted(application);
    		 
    		 if(accepted == false) {
    			 break;
    		 }
    	
		}
    	
    	if(accepted) {
    		vh.getRegularApplicantBox().getChildren().addAll(vh.getNoRegularApplicantLabel());
    	}else {
    		int limit = 0;
    		for (Application application : applicationList) {
    			
    	    		
    				if(limit < 4 && !validateApplicationAccepted(application)) {
    					RegularApplicationListItem regApp = new RegularApplicationListItem(application.getJob().getName(), application.getUser().getName());
        				regApp.getViewButton().setOnAction(e -> {
        					popUpRegularApplicationDetail(application);
        					
        				});
        				
        				regApp.getAcceptButton().setOnAction(e -> {
        					application.insertAcceptanceReport();
        					 reloadCompanyApplicantPage();

        				});
        				
        				regApp.getRemoveButton().setOnAction(e -> {
        					try {
								application.delete();
								reloadCompanyApplicantPage();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        				});
    					
        				vh.getRegularApplicantBox().getChildren().addAll(regApp);
    				}
    				
    				limit++;
    		
    			
			}
    		
    	}
    	
    	
    	
    }
    
    
    public void popUpAllRegularApplicantList() {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Regular Application");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(757);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(755);
    	container.setMaxWidth(755);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	
    	ArrayList<Application> applicationList = new ArrayList<>();
    	try {
    		applicationList = Application.getApplicationFromCurrentCompany();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	boolean accepted = true;
    	for (Application application : applicationList) {
    		 accepted = validateApplicationAccepted(application);
    		 
    		 if(accepted == false) {
    			 break;
    		 }
    	
		}
    	
    	if(accepted) {
    		container.getChildren().add(vh.getNoRegularApplicantLabel2());
    		
    	}else {
    		for (Application application : applicationList) {
    			
    	    		
    				if(!validateApplicationAccepted(application)) {
    					RegularApplicationListItem regApp = new RegularApplicationListItem(application.getJob().getName(), application.getUser().getName());
        				regApp.getViewButton().setOnAction(e -> {
        					popUpRegularApplicationDetail(application);
        					
        				});
        				
        				regApp.getAcceptButton().setOnAction(e -> {
        					application.insertAcceptanceReport();
        					 reloadCompanyApplicantPage();

        				});
        				
        				regApp.getRemoveButton().setOnAction(e -> {
        					try {
								application.delete();
								reloadCompanyApplicantPage();
								vh.getStack().getChildren().remove(darkened);
								popUpAllRegularApplicantList();
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
        				});
    					
        				container.getChildren().addAll(regApp);
    				}
    				
    			
    		
    			
			}
    		
    	}
    	
		
		container.getChildren().addAll(buttonContainer);
    	
    	
    	vh.getStack().getChildren().add(darkened);
    	
    	
    }
    
    
    public void popUpAllStudentApplicantList() {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Regular Application");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(757);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(755);
    	container.setMaxWidth(755);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	
    	ArrayList<StudentApplication> studentApplicationList = StudentApplication.getStudentApplicationFromCompanyId();
		
		boolean accepted = true;
		
		for (StudentApplication studentApplication : studentApplicationList) {
			accepted = validateStudentApplicationAccepted(studentApplication);
			
			if(accepted == false) {
				break;
			}
		}
	
		
		if(accepted) {
			container.getChildren().addAll(vh.getNoStudentApplicantLabel2());
		}
		
		else{
			
			
			for (StudentApplication studentApplication : studentApplicationList) {
		
			if(!validateStudentApplicationAccepted(studentApplication)) {
				
				StudentApplicationListItem studentApplicationListItem = new StudentApplicationListItem(studentApplication.getInternship().getJob().getName(), studentApplication.getStudent().getName());
				
				studentApplicationListItem.getViewButton().setOnAction(e -> {
					popUpStudentApplicationDetail(studentApplication);
				});
				
				studentApplicationListItem.getAcceptButton().setOnAction(e -> {
					studentApplication.insertAcceptanceReport();
					vh.getStack().getChildren().remove(darkened);
					
					reloadCompanyApplicantPage();
					
					popUpAllStudentApplicantList();
				});
				
				studentApplicationListItem.getRemoveButton().setOnAction(e -> {
					try {
						studentApplication.delete();
						vh.getStack().getChildren().remove(darkened);
						
						reloadCompanyApplicantPage();
						
						popUpAllStudentApplicantList();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				container.getChildren().addAll(studentApplicationListItem);
				
			}
			
			
				
			}
		}
    	
		container.getChildren().addAll(buttonContainer);
    	
    	
    	vh.getStack().getChildren().add(darkened);
    	
    }
    
    public void loadStudentApplicantList() {
    	vh.getViewAllStudentApplicantLabel().setOnMouseClicked(e -> {
    		popUpAllStudentApplicantList();
    	});
    	
			ArrayList<StudentApplication> studentApplicationList = StudentApplication.getStudentApplicationFromCompanyId();
			
			boolean accepted = true;
			
			for (StudentApplication studentApplication : studentApplicationList) {
				accepted = validateStudentApplicationAccepted(studentApplication);
				
				if(accepted == false) {
					break;
				}
			}
			
			int limit = 0;
			
			if(accepted) {
				vh.getStudentApplicantBox().getChildren().addAll(vh.getNoStudentApplicantLabel());
			}
			
			else{
				
				
				for (StudentApplication studentApplication : studentApplicationList) {
			
				if(limit < 4 && !validateStudentApplicationAccepted(studentApplication)) {
					
					StudentApplicationListItem studentApplicationListItem = new StudentApplicationListItem(studentApplication.getInternship().getJob().getName(), studentApplication.getStudent().getName());
					
					studentApplicationListItem.getViewButton().setOnAction(e -> {
						popUpStudentApplicationDetail(studentApplication);
					});
					
					studentApplicationListItem.getAcceptButton().setOnAction(e -> {
						studentApplication.insertAcceptanceReport();
						reloadCompanyApplicantPage();
					});
					
					studentApplicationListItem.getRemoveButton().setOnAction(e -> {
						try {
							studentApplication.delete();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					});
					
					vh.getStudentApplicantBox().getChildren().addAll(studentApplicationListItem);
				}
				
				limit++;
				}
			}
			
		
    	
    	
    }
    
    public void popUpStudentApplicationDetail(StudentApplication studentApplication) {
    	
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	PopUpStudentApplicationDetail popUp = new PopUpStudentApplicationDetail(studentApplication.getInternship().getJob().getName(), studentApplication.getStudent().getName(), studentApplication.getStudent().getPhone(), studentApplication.getStudent().getEmail(), studentApplication.getCvDesc(), studentApplication.getTranscriptDesc(), studentApplication.getInternship().getName(), studentApplication.getInternship().getDesc());
    		
    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    
    
    }
    
    public boolean validateStudentApplicationAccepted(StudentApplication application) {
    	Connect con = Connect.getConnection();
    	String sql = String.format("SELECT * FROM `studentreports` WHERE `StudentApplicationID` = %d", application.getId());
    	ResultSet res = con.executeQuery(sql);
    	
    	try {
			if(res.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
    
    public boolean validateApplicationAccepted(Application application) {
    	Connect con = Connect.getConnection();
    	String sql = String.format("SELECT * FROM `reports` WHERE `ApplicationID` = %d", application.getId());
    	ResultSet res = con.executeQuery(sql);
    	
    	try {
			if(res.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    	
    }
    
    public void clearRegularApplicantList() {
    	vh.getRegularApplicantBox().getChildren().clear();
    }
    
    public void clearStudentApplicantList() {
    	vh.getStudentApplicantBox().getChildren().clear();
    }
    
    public void clearCompanyAdvertisementList() {
    	vh.getCompanyAdvertisementBox().getChildren().clear();
    }
    
   
    
    public boolean isSalaryNumber(String salary) {
    	if(salary == null) {
    		return false;
    	}
    	
    	try {
    		double s = Double.parseDouble(salary);
    	}catch (NumberFormatException e){
    		return false;
    		
    	}
    	
    	return true;
    	
    }
    
    public void popUpAddNewJob() {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpAddNewJob popUp = new PopUpAddNewJob();

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	popUp.getAddButton().setOnAction(e -> {
    		if(popUp.getJobTitleTf().getText().isBlank() || popUp.getJobDescTf().getText().isBlank() || popUp.getJobSalaryTf().getText().isBlank()) {
    			   Alert a = new Alert(Alert.AlertType.ERROR);
    		        a.setTitle("Failed to create new job!");
    		
    		        a.setContentText("Job Title / Job Description / Job Salary Field Must be Filled!");
    		        a.show();
    			
    			
    		}else {
    			if(isSalaryNumber(popUp.getJobSalaryTf().getText()) == false) {
    				Alert a = new Alert(Alert.AlertType.ERROR);
    		        a.setTitle("Failed to create new job!");
    
    		
    		        a.setContentText("Job Salary Field must be filled with number!");
    		        a.show();
    				
    			}else {
    				String sql = String.format("INSERT INTO `jobs` VALUES (%d, %d, '%s', '%s', %f)", 0, ((Company)Main.currModel).getId(), popUp.getJobTitleTf().getText(), popUp.getJobDescTf().getText(), Double.parseDouble(popUp.getJobSalaryTf().getText()));
    				Connect con = Connect.getConnection();
    				con.executeUpdate(sql);
    		
            		
            		
            		vh.getStack().getChildren().remove(darkened);
            		darkened.getChildren().remove(popUp);
            		
            		
            		vh.clearContent();
            		clearCompanyJobList();
            		vh.loadCompanyJobHeader();
            		loadCompanyJobList();
            		
            		clearOtherCompanyJobList();
            		loadOtherCompanyJobList();
    			}
    			
    		}
    	});
    }
    
    
    public void loadCompanyAdvertisementList() {
    	vh.getViewAllAdvertisementLabel().setOnMouseClicked(e -> {
    		popUpAdvertisementListByCompany();
    	});
    	
    	ArrayList<Advertisement> advertisementList = new Advertisement(0, "","", null).getAdvertisementByCompanyIdLimit5(((Company)Main.currModel).getId());
    	
    	if(!advertisementList.isEmpty()) {
    		for (Advertisement advertisement : advertisementList) {
				CompanyAdvertisementList popUp = new CompanyAdvertisementList(advertisement.getCompany().getName(), advertisement.getTitle(), advertisement.getDesc());
				
				popUp.getDetailButton().setOnAction(e -> {
					vh.popUpAdvertisement(advertisement.getTitle(), advertisement.getDesc(), advertisement.getCompany().getName(), advertisement.getCompany().getPhone());
				});
				
				popUp.getRemoveButton().setOnAction(e -> {
					try {
						advertisement.delete();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vh.clearContent();
	        		clearCompanyAdvertisementList();
	        		vh.loadCompanyAdvertisementHeader();
	        		loadCompanyAdvertisementList();
					
				});
				
				
				vh.getCompanyAdvertisementBox().getChildren().addAll(popUp);
			}
    	}else {
    		vh.getContentHolder().getChildren().add(vh.getNoAdvertisementCompanyLabel());
    	}
    	
    	vh.getAddNewAdvertisementButton().setOnAction(e -> {
    		popUpAddNewAdvertisement();    	
    	});
    	
    	
    }
    
    public void popUpAddNewAdvertisement() {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpAddNewAdvertisement popUp = new PopUpAddNewAdvertisement();

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	popUp.getAddButton().setOnAction(e -> {
    		if(popUp.getAdvertisementTitleTf().getText().isBlank() || popUp.getAdvertisementDescTf().getText().isBlank()) {
    			   Alert a = new Alert(Alert.AlertType.ERROR);
    		        a.setTitle("Failed to post advertisement!");
    		
    		        a.setContentText("Advertisement Title & Advertisement Description Must be Filled!");
    		        a.show();
    			
    			
    		}else {
    			
    				String sql = String.format("INSERT INTO `advertisements` VALUES (%d, %d, '%s', '%s')",0,((Company)Main.currModel).getId(), popUp.getAdvertisementTitleTf().getText(), popUp.getAdvertisementDescTf().getText());
    				Connect con = Connect.getConnection();
    				con.executeUpdate(sql);
    		
            		
            		
            		vh.getStack().getChildren().remove(darkened);
            		darkened.getChildren().remove(popUp);
            		
            		
            		vh.clearContent();
            		clearCompanyAdvertisementList();
            		vh.loadCompanyAdvertisementHeader();
            		loadCompanyAdvertisementList();
    			
    			
    		}
    	});
    }
    
    
    
    public void loadOtherCompanyJobList() {
    	ArrayList<Job> jobList = new Job(0, "", "", 0, null).getJobFromOtherCompanyLimit2(((Company)Main.currModel).getId());
    	if(!jobList.isEmpty()) {
    		
    		for (Job job : jobList) {
				OtherCompanyJobListItem otherCompanyJobListItem = new OtherCompanyJobListItem(job.getName(), job.getCompany().getName(), job.getDescription(), job.getSalary());
			
				otherCompanyJobListItem.getViewButton().setOnAction(e -> {
					jobManagedByOtherCompanyPopUpDetail(job.getName(), job.getDescription(), job.getSalary(), job.getCompany().getName(), job.getCompany().getEmail(), job.getCompany().getPhone(), job.getCompany().getAddress());
					
				});
				vh.getJobManagedByOtherCompanyBox().getChildren().addAll(otherCompanyJobListItem);
			}
    	}else {
    		vh.getJobManagedByOtherCompanyBox().getChildren().addAll(vh.getNobJobManagedByOtherCompanyLabel());
    	}
    	
    	vh.getViewJobManagedByOtherCompanyLabel().setOnMouseClicked(e -> {
    		try {
				displayAllJobManagedByOtherCompanyPopUp();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
    	
    	
    }
    
    
    public void clearOtherCompanyJobList() {
    	vh.getJobManagedByOtherCompanyBox().getChildren().clear();
    }
    
    public void clearCompanyJobList() {
    	vh.getJobManagedByCompanyBox().getChildren().clear();
    }
    
  
    public void loadCompanyJobList() {
    	ArrayList<Job> jobList = new Job(0, "", "", 0, null).getJobFromCompanyIdLimit2(((Company)Main.currModel).getId());
    	
    	if(!jobList.isEmpty()) {

    		for (Job job : jobList) {
    			CompanyJobListItem companyJobListItem = new CompanyJobListItem(job.getName(), job.getCompany().getName(), job.getDescription(), job.getSalary());
				
    			
    			companyJobListItem.getRemoveButton().setOnAction(e -> {
    				try {
						job.delete();
						clearCompanyJobList();
						loadCompanyJobList();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    			});
    			companyJobListItem.getViewButton().setOnAction(e -> {
    				jobManagedByCompanyPopUpDetail(job.getId(),job.getName(), job.getDescription(), job.getSalary());
    			});
    			
    		
    			if(job.checkInternship()) {
    				companyJobListItem.getButtonContainer().getChildren().addAll(companyJobListItem.getViewButton(), companyJobListItem.getCloseInternshipButton(), companyJobListItem.getRemoveButton());
    			}else if(!job.checkInternship()) {
    				companyJobListItem.getButtonContainer().getChildren().addAll(companyJobListItem.getViewButton(), companyJobListItem.getOpenInternshipButton(), companyJobListItem.getRemoveButton());
    			}
    			
    			companyJobListItem.getOpenInternshipButton().setOnAction(e -> {
    				popUpAddNewInternship(job.getId());
    				
    				vh.clearContent();
            		clearCompanyJobList();
            		vh.loadCompanyJobHeader();
            		loadCompanyJobList();
            		
            		clearOtherCompanyJobList();
            		loadOtherCompanyJobList();
    			});
    			
    			companyJobListItem.getCloseInternshipButton().setOnAction(e -> {
    				closeInternship(job.getId());
    				
    				vh.clearContent();
            		clearCompanyJobList();
            		vh.loadCompanyJobHeader();
            		loadCompanyJobList();
            		
            		clearOtherCompanyJobList();
            		loadOtherCompanyJobList();
    			});
    			
    			vh.getJobManagedByCompanyBox().getChildren().addAll(companyJobListItem);
			}
    	}else {
    		vh.getJobManagedByCompanyBox().getChildren().addAll(vh.getNoJobManagedByYourCompanyLabel());
    	}
    	
    	vh.getAddNewCompanyJobButton().setOnAction(e -> {
    		popUpAddNewJob();    	
    	});
    	
 
    	
    	vh.getViewJobManagedByCompanyLabel().setOnMouseClicked(e -> {
    		try {
				displayAllJobManagedByCompanyPopUp();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	});
    }
    
    

    
    
    public void closeInternship(int jobId) {
    	Connect con = Connect.getConnection();
    	String sql = String.format("DELETE FROM `internships` WHERE `JobID` = %d", jobId);
    	con.executeUpdate(sql);
    }
    
    

    
    
    public void popUpAddNewInternship(int jobId) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpAddNewInternship popUp = new PopUpAddNewInternship();

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	popUp.getAddButton().setOnAction(e -> {
    		if(popUp.getInternshipTitleTf().getText().isBlank() || popUp.getInternshipDescTf().getText().isBlank()) {
    			   Alert a = new Alert(Alert.AlertType.ERROR);
    		        a.setTitle("Failed to create new Intership for this Job!");
    		
    		        a.setContentText("Internship Title / Internship Description must be Filled!");
    		        a.show();
    			
    			
    		}else {
    			
    				String sql = String.format("INSERT INTO `internships` VALUES (%d, %d, '%s', '%s')", 0, jobId, popUp.getInternshipTitleTf().getText(), popUp.getInternshipDescTf().getText());
    				
    				Connect con = Connect.getConnection();
    				con.executeUpdate(sql);
    		
            		
            		
            		vh.getStack().getChildren().remove(darkened);
            		darkened.getChildren().remove(popUp);
            		
            		
            		vh.clearContent();
            		clearCompanyJobList();
            		vh.loadCompanyJobHeader();
            		loadCompanyJobList();
            		
            		clearOtherCompanyJobList();
            		loadOtherCompanyJobList();
    			
    			
    		}
    	});
    }
    
    public void populateCompanyAllJob(String jobName, String companyName, String jobDesc, double jobSalary) {
    	vh.getJobManagedByCompanyBox().getChildren().addAll(new CompanyJobListItem(jobName, companyName, jobDesc, jobSalary));
    	
    }
    
    
    public void jobManagedByCompanyPopUpDetail(int jobId, String jobName, String jobDesc, double jobSalary) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpCompanyManagedJobDetail popUp = new PopUpCompanyManagedJobDetail(jobName, jobDesc, jobSalary);

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	popUp.getUpdateButton().setOnAction(e -> {
    		if(popUp.getTextField().getText().equals(popUp.getJobDesc()) || popUp.getTextField().getText().isBlank()) {
    			
    		}else {
    			String newDesc = popUp.getTextField().getText();
    			String sql = String.format("UPDATE `jobs` SET `JobDescription` = '%s' WHERE `JobID` = %d", newDesc, jobId);
    			vh.getStack().getChildren().remove(darkened);
    			Connect con = Connect.getConnection();
    			con.executeUpdate(sql);
    			Logger.log("DB", "Sucessfully update job description !");
    			
    			vh.clearContent();
    			clearCompanyJobList();
        		vh.loadCompanyJobHeader();
        		loadCompanyJobList();
    			
    		}
    	});
    }
    
    public void jobManagedByOtherCompanyPopUpDetail(String jobName, String jobDesc, double jobSalary, String companyName, String companyEmail, String companyPhone, String companyAddress) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpJobDetail popUp = new PopUpJobDetail(jobName, jobDesc, jobSalary, companyName, companyEmail, companyPhone, companyAddress);

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	
    }
    
    
    public void popUpAdvertisementListByCompany() {
    	
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Advertisement Posted by Your Company");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(764.5);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(753);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
    	backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	ArrayList<Advertisement> advertisementList = null;
		advertisementList = new Advertisement(0, "", "", null).getAdvertisementByCompanyId(((Company)Main.currModel).getId());
		
		if(advertisementList.isEmpty()) {
			Label noJobListLabel = new Label("You don't have any advertisement posted yet!");
			noJobListLabel.setMinWidth(746.5);
			noJobListLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,20));
	    	noJobListLabel.setTextFill(Color.WHITE);
	    	container.getChildren().add(noJobListLabel);
			
		}else {
			
			for (Advertisement advertisementItem : advertisementList) {
	    		CompanyAdvertisementList popUp = new CompanyAdvertisementList(advertisementItem.getCompany().getName(), advertisementItem.getTitle(),advertisementItem.getDesc());
	    		
	    		 container.getChildren().add(popUp);
	    		 
	    		 
	    		 
	    		 popUp.getDetailButton().setOnAction(e -> {
						vh.popUpAdvertisement(advertisementItem.getTitle(), advertisementItem.getDesc(), advertisementItem.getCompany().getName(), advertisementItem.getCompany().getPhone());
					});
					
					popUp.getRemoveButton().setOnAction(e -> {
						try {
							advertisementItem.delete();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						vh.clearContent();
		        		clearCompanyAdvertisementList();
		        		vh.loadCompanyAdvertisementHeader();
		        		loadCompanyAdvertisementList();
		        		
		        		
		        		vh.getStack().getChildren().remove(darkened);
		        		
//		        		popUpAdvertisementListByCompany();
						
					});
			}
			
		}
		
		container.getChildren().addAll(buttonContainer);
    	
    	
    	vh.getStack().getChildren().add(darkened);
    	
    }
    
    
    public void allJobManagedByCompanyPopUpDetail(int jobId, String jobName, String jobDesc, double jobSalary) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpCompanyManagedJobDetail popUp = new PopUpCompanyManagedJobDetail(jobName, jobDesc, jobSalary);

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	popUp.getUpdateButton().setOnAction(e -> {
    		if(popUp.getTextField().getText().equals(popUp.getJobDesc()) || popUp.getTextField().getText().isBlank()) {
    			
    		}else {
    			String newDesc = popUp.getTextField().getText();
    			String sql = String.format("UPDATE `jobs` SET `JobDescription` = '%s' WHERE `JobID` = %d", newDesc, jobId);
    			vh.getStack().getChildren().remove(darkened);
    			Connect con = Connect.getConnection();
    			con.executeUpdate(sql);
    			Logger.log("DB", "Sucessfully update job description !");
    			
    			vh.clearContent();
    			clearCompanyJobList();
        		vh.loadCompanyJobHeader();
        		loadCompanyJobList();
        		
        		vh.getStack().getChildren().remove(darkened);
        		darkened.getChildren().remove(popUp);
        		
        		try {
					displayAllJobManagedByCompanyPopUp();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    		}
    	});
    }
    
    
public void displayAllJobManagedByOtherCompanyPopUp() throws SQLException {
    	
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Job Managed by Other Company");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(755);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(753);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);  
    	backButton.setStyle("-fx-background-color: #FF5C5C");
    	backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	ArrayList<Job> jobList = null;
		jobList = new Job(0, "", "", 0, null).getJobFromOtherCompany(((Company)Main.currModel).getId());
		
		if(jobList.isEmpty()) {
			Label noJobListLabel = new Label("There is no other Company job added yet!");
			noJobListLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,20));
	    	noJobListLabel.setTextFill(Color.WHITE);
	    	container.getChildren().add(noJobListLabel);
			
		}else {
			
			for (Job jobItem : jobList) {
	    		OtherCompanyJobListItem popUp = new OtherCompanyJobListItem(jobItem.getName(), jobItem.getCompany().getName(),jobItem.getDescription(), jobItem.getSalary());
	    		
	    		 container.getChildren().add(popUp);
	    		 
	    		 
	    		 
	    	    	
	    	    	popUp.getViewButton().setOnAction(e -> {
	    	    		jobManagedByOtherCompanyPopUpDetail(jobItem.getName(), jobItem.getDescription(), jobItem.getSalary(), jobItem.getCompany().getName(), jobItem.getCompany().getEmail(), jobItem.getCompany().getPhone(), jobItem.getCompany().getAddress());
	    	    		
	    	    	});
			}
			
		}
		
		container.getChildren().addAll(buttonContainer);
    	
    	
    	vh.getStack().getChildren().add(darkened);
    }
    
    public void displayAllJobManagedByCompanyPopUp() throws SQLException {
    	
    	VBox darkened = new VBox();
    	
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	darkened.setMinWidth(800);
    	
    	
    	Label label = new Label("Job Managed by Your Company");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(755);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(753);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	backButton.setTextFill(Color.WHITE);
    	backButton.setStyle("-fx-background-color: #FF5C5C");
    	
    	buttonContainer.getChildren().add(backButton);    	
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	ArrayList<Job> jobList = null;
		jobList = new Job(0, "", "", 0, null).getJobFromCompanyId(((Company)Main.currModel).getId());
		
		if(jobList.isEmpty()) {
			Label noJobListLabel = new Label("You don't have any job added yet!");
			noJobListLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,20));
	    	noJobListLabel.setTextFill(Color.WHITE);
	    	container.getChildren().add(noJobListLabel);
			
		}else {
			
			for (Job jobItem : jobList) {
	    		CompanyJobListItem popUp = new CompanyJobListItem(jobItem.getName(), jobItem.getCompany().getName(),jobItem.getDescription(), jobItem.getSalary());
	    		
	    		 container.getChildren().add(popUp);
	    		 
	    		 if(jobItem.checkInternship()) {
	    				popUp.getButtonContainer().getChildren().addAll(popUp.getViewButton(), popUp.getCloseInternshipButton(), popUp.getRemoveButton());
	    			}else if(!jobItem.checkInternship()) {
	    				popUp.getButtonContainer().getChildren().addAll(popUp.getViewButton(), popUp.getOpenInternshipButton(), popUp.getRemoveButton());
	    			}
	    		 
	    	
	    			
	    			popUp.getOpenInternshipButton().setOnAction(e -> {
	    				popUpAddNewInternship(jobItem.getId());
	    				
	    				vh.getStack().getChildren().remove(darkened);

	    			});
	    			
	    			popUp.getCloseInternshipButton().setOnAction(e -> {
	    				closeInternship(jobItem.getId());
	    				
	    				vh.clearContent();
	            		clearCompanyJobList();
	            		vh.loadCompanyJobHeader();
	            		loadCompanyJobList();
	            		
	            		clearOtherCompanyJobList();
	            		loadOtherCompanyJobList();
	            		
	            		try {
							displayAllJobManagedByCompanyPopUp();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    			});
	    		 
	    		 
	    	    	popUp.getRemoveButton().setOnAction(e -> {
	    	    		try {
							jobItem.delete();
							
			    			vh.clearContent();
			    			clearCompanyJobList();
			        		vh.loadCompanyJobHeader();
			        		loadCompanyJobList();
							
							vh.getStack().getChildren().remove(darkened);
							
							displayAllJobManagedByCompanyPopUp();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    	    		
	    	    	});
	    	    	popUp.getViewButton().setOnAction(e -> {
	    	    		allJobManagedByCompanyPopUpDetail(jobItem.getId(),jobItem.getName(), jobItem.getDescription(), jobItem.getSalary());
	    	    		vh.getStack().getChildren().remove(darkened);
	    	    	});
			}
			
		}
		
		container.getChildren().addAll(buttonContainer);
    	
    	
    	vh.getStack().getChildren().add(darkened);
    }
    
    


    
    public void setUserSideBar() {
    	vh.getSideCard().getSideCardContent().getChildren().addAll(vh.getSideCard().getSideCardContent().getDashboardButton(), vh.getSideCard().getSideCardContent().getFindJobButton());
    }
    
    public void setCompanySideBar() {
    	vh.getSideCard().getSideCardContent().getChildren().addAll(vh.getSideCard().getSideCardContent().getCompanyJobButton(), vh.getSideCard().getSideCardContent().getCompanyAdvertisementButton(), vh.getSideCard().getSideCardContent().getCompanyApplicantButton());
    }
    
    
    public void removeWishList() {
//    	try {
//			wishItem.delete();
//			vh.removeWishList();
//			loadWishList();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    }
    
    
    public void loadAdvertisement() {
    	List<Model> advertisementList = null;
    	Advertisement advertisement = new Advertisement(0, "", "", null);
    	try {
			advertisementList = new Advertisement(0, "", "", null).getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(advertisementList == null) {
    		vh.displayNoAdvertisement();
    	}else if(!advertisementList.isEmpty()) {
    		int itemCount = 0;
    		
    		for (Model model : advertisementList) {
				if(itemCount < 3) {
					AdvertisementListItem advertisementListItem = new AdvertisementListItem(((Advertisement)model).getCompany().getName(), ((Advertisement)model).getTitle(), ((Advertisement)model).getDesc());
					advertisementListItem.getDetailButton().setOnAction(e -> {
						vh.popUpAdvertisement(((Advertisement)model).getTitle(), ((Advertisement)model).getDesc(), ((Advertisement)model).getCompany().getName(), ((Advertisement)model).getCompany().getPhone());
					});
					vh.getAdvertisementList().getChildren().add(advertisementListItem);
				}
			}
    	}
    	
    }
  
    public void displayAllApplicationPopUp() {
    	
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Your Application");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(700);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(698);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
    
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	ArrayList<Application> applicationList = null;
		try {
			applicationList = Application.getAllWishItemsByUserId(((User)Main.currModel).getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(applicationList.isEmpty()) {
			Label noWishListLabel = new Label("You don't have any application added yet!");
			noWishListLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,20));
	    	noWishListLabel.setTextFill(Color.WHITE);
	    	container.getChildren().add(noWishListLabel);
			
		}else {
			
			for (Application applicationItem1 : applicationList) {
	    		PopUpAllApplicationListItem popUp = new PopUpAllApplicationListItem(applicationItem1.getJob().getName(), applicationItem1.getJob().getSalary(), applicationItem1.getJob().getDescription(), applicationItem1.getDate());
	    		
	    		 container.getChildren().add(popUp);
	    		 
	    		 
	    		 
	    	    	popUp.getRemoveButton().setOnAction(e -> {
	    	    		try {
							applicationItem1.delete();
							
							clearApplication();
							loadApplication();
							vh.getStack().getChildren().remove(darkened);
							
							displayAllApplicationPopUp();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    	    		
	    	    	});
	    	    	popUp.getViewButton().setOnAction(e -> {
	    	    		popUpApplicationDetail(applicationItem1.getJob(), applicationItem1.getDate(), applicationItem1.getCvDesc(), applicationItem1.getTranscriptDesc());
	    	    	});
			}
			
		}
		
		container.getChildren().addAll(buttonContainer);
    	
    	
    	vh.getStack().getChildren().add(darkened);
    	
    	
    }

    
    public void displayAllWishListPopUp(){
    	
    	
    	
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	
    	Label label = new Label("Your Wishlist");
    	label.setFont(Font.font("Segoe UI",FontWeight.BOLD,22));
    	label.setTextFill(Color.WHITE);
    	
    	Separator separator = new Separator();
    	separator.setOrientation(Orientation.HORIZONTAL);
    	
    	ScrollPane scrollPane = new ScrollPane();
    	scrollPane.setMaxWidth(700);
    	scrollPane.setMaxHeight(Main.DEFAULT_HEIGHT/3*2);
    	scrollPane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4);");
    	
    	
    	VBox container = new VBox();
    	scrollPane.setContent(container);
    	container.setStyle("-fx-background-color: #232323;");
    	container.getChildren().addAll(label, separator);
    	container.setPadding(new Insets(8, 8, 25, 8));
    	container.setSpacing(10);
    	container.setMinWidth(698);
    	
    	HBox buttonContainer = new HBox();
    	buttonContainer.setMinWidth(660);
    	buttonContainer.setAlignment(Pos.CENTER);
    	buttonContainer.setPadding(new Insets(10, 0, 0, 0));
    	
    	Button backButton = new Button("Back to dashboard");
    	buttonContainer.getChildren().add(backButton);    	
    
    	
    	backButton.setStyle("-fx-background-color: #FF5C5C");
		backButton.setTextFill(Color.WHITE);
		
    	backButton.setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	darkened.getChildren().add(scrollPane);
    	
    	ArrayList<WishItem> wishList = null;
		try {
			wishList = WishItem.getAllWishItemsByUserId(((User)Main.currModel).getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(wishList.isEmpty()) {
			Label noWishListLabel = new Label("You don't have add wishlist added yet!");
			noWishListLabel.setFont(Font.font("Segoe UI",FontWeight.MEDIUM,20));
	    	noWishListLabel.setTextFill(Color.WHITE);
	    	container.getChildren().add(noWishListLabel);
			
		}else {
			
			for (WishItem wishItem1 : wishList) {
	    		PopUpAllWishListItems popUp = new PopUpAllWishListItems(wishItem1.getJob().getName(), wishItem1.getJob().getSalary(), wishItem1.getJob().getDescription());
	    		
	    		 container.getChildren().add(popUp);
	    		 
	    		 
	    		 
	    	    	popUp.getRemoveButton().setOnAction(e -> {
	    	    		try {
							wishItem1.delete();
							
							clearWishList();
							loadWishList();
							vh.getStack().getChildren().remove(darkened);
							
							displayAllWishListPopUp();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    	    		
	    	    	});
	    	    	popUp.getViewButton().setOnAction(e -> {
	    	    		vh.popUpJobDetail(wishItem1.getJob().getName(),wishItem1.getJob().getDescription() , wishItem1.getJob().getSalary(), wishItem1.getJob().getCompany().getName(), wishItem1.getJob().getCompany().getEmail(), wishItem1.getJob().getCompany().getPhone(), wishItem1.getJob().getCompany().getAddress());
	    	    	});
			}
			
		}
		
		container.getChildren().addAll(buttonContainer);
    	
    	
    	vh.getStack().getChildren().add(darkened);
    	
    	
//    	vh.getStack().getChildren().remove(darkened);
    	
    	
    }

    
    public void loadWishList() {
    	
    	vh.getContentSplitLeft().getChildren().add(vh.getWishListTitleContainer());
    	vh.getViewAllWishList().setOnMouseClicked(e -> {
    		displayAllWishListPopUp();
    	});
    	ArrayList<WishItem> wishItemList = null;
		try {
			wishItemList = WishItem.getAllWishItemsByUserId(((User)Main.currModel).getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    
			if(wishItemList.isEmpty()) {
				vh.displayNoWishList();
				

			}else if(!wishItemList.isEmpty()) {
				int itemCount = 0;
				for (WishItem wishItem1 : wishItemList) {
					if(itemCount < 2) {
						WishListItem wishListItem = new WishListItem(wishItem1.getJob().getName(), wishItem1.getJob().getSalary(), wishItem1.getJob().getDescription());
						wishListItem.getRemoveButton().setOnAction(e ->{
							try {
								wishItem1.delete();
								clearWishList();
								loadWishList();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						});
						
						wishListItem.getViewButton().setOnAction(e -> {
							vh.popUpJobDetail(wishItem1.getJob().getName(),wishItem1.getJob().getDescription() , wishItem1.getJob().getSalary(), wishItem1.getJob().getCompany().getName(), wishItem1.getJob().getCompany().getEmail(), wishItem1.getJob().getCompany().getPhone(), wishItem1.getJob().getCompany().getAddress());
						});
						
						vh.getContentSplitLeft().getChildren().add(wishListItem);
					}
					itemCount++;
					
					
					
				}
			}
		} 
    
    
    public boolean checkWishlist(int userId, int jobId) {
    	boolean flag = false;
    	ArrayList<WishItem> wishList = null;
    	
    	try {
			wishList = WishItem.getApplicationFromJobAndUserId(userId, jobId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	if(!wishList.isEmpty()) {
    		flag = true;
    		return flag;
    	}
    	
    	
    	return flag;
    	
    	
    }
    
    public boolean checkCompany(int userId, int jobId, int companyId) {
    	boolean flag = false;
    	ArrayList<Application> applicationList = null;
    	try {
			 applicationList = Application.getApplicationFromJobAndUserId(((User)Main.currModel).getId(), jobId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	for (Application application : applicationList) {
			try {
				Job job = (Job)new Job(0, "", "", 0, null).get(application.getJob().getId());
				if(job != null) {
					if(job.getCompany().getId() == companyId) {
						flag = true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	return flag;
    	
    }
    
    public void loadJobList() {
    	List<Model> jobList = null;
    	
    	try {
			jobList = new Job(0, "", "", 0 , null).getAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(jobList == null) {
    		
    	}else if(!jobList.isEmpty()) {
    		for (Model jobItem : jobList) {
				JobListItem jobListItem = new JobListItem(((Job)jobItem).getName(), ((Job)jobItem).getCompany().getName(), ((Job)jobItem).getDescription(), ((Job)jobItem).getSalary());
				jobListItem.getViewButton().setOnAction( e -> {
					vh.popUpJobDetail(((Job)jobItem).getName(),((Job)jobItem).getDescription() , ((Job)jobItem).getSalary(), ((Job)jobItem).getCompany().getName(), ((Job)jobItem).getCompany().getEmail(), ((Job)jobItem).getCompany().getPhone(), ((Job)jobItem).getCompany().getAddress());
				});
				
				if(checkCompany(((User)Main.currModel).getId(), ((Job)jobItem).getId(), ((Job)jobItem).getCompany().getId())) {
					jobListItem.getApplyButton().setDisable(true);
				}else {
					jobListItem.getApplyButton().setOnAction(e -> {
						popUpApplyConfirmation(((Job)jobItem),((Job)jobItem).getCompany());
						
						
						
					});
					
					
				}
				
				jobListItem.getWishListButton().setOnAction(e -> {
					((Job)jobItem).addToUserWishList();
					vh.clearJobListContent();
	        		vh.clearContent();
	        		vh.loadJobContent();
	        		loadJobList();
					
					
				});
				
				if(checkWishlist(((User)Main.currModel).getId(), ((Job)jobItem).getId())) {
					jobListItem.getWishListButton().setDisable(true);
				}
				
				vh.getJobList().getChildren().add(jobListItem);
			}
    	}
    }
    
    public void popUpApplicationDetail(Job job, Timestamp applicationDate, String cvDesc, String transcriptDesc) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpApplicationDetail popUp = new PopUpApplicationDetail(job.getName(), job.getDescription(), job.getSalary(), applicationDate, cvDesc, transcriptDesc);

    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    
    	
    	
    }
    
    
    public void popUpApplyConfirmation(Job job, Company company) {
    	VBox darkened = new VBox();
    	darkened.setPrefWidth(Main.DEFAULT_WIDTH);
    	darkened.setPrefHeight(Main.DEFAULT_HEIGHT);
    	darkened.setAlignment(Pos.CENTER);
    	

    	darkened.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
    	
    	
    	PopUpApplyConfirmation popUp = new PopUpApplyConfirmation(job, company);
    	darkened.getChildren().add(popUp);
    	vh.getStack().getChildren().add(darkened);
    	popUp.getCloseButton().setOnAction(e -> {
    		vh.getStack().getChildren().remove(darkened);
    	});
    	
    	popUp.getApplyButton().setOnAction(e -> {
    		String cvDesc, transcriptDesc;
    		cvDesc = popUp.getTfCvDesc().getText();
    		transcriptDesc = popUp.getTfTranscriptDesc().getText();
    		
    		popUp.getAlert().setTitle("CV Submission Failed !");
    		popUp.getAlert().setContentText("");
    		if(cvDesc.isEmpty()) {
    			 popUp.getAlert().setHeaderText("CV Description must be filled !");
                 popUp.getAlert().show();
    			
    			
    		}else if(transcriptDesc.isEmpty()) {
    			 popUp.getAlert().setHeaderText("Transcript Description must be filled !");
                 popUp.getAlert().show();
    		}else {
    			
    			try {
					new Application(0, null, cvDesc, transcriptDesc, job, ((User)Main.currModel)).insert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			vh.getStack().getChildren().remove(darkened);
    			vh.clearJobListContent();
        		vh.clearContent();
        		vh.loadJobContent();
        		loadJobList();
    			
    			
    			
    		}
    		
    		
    	});
    	
    	
    	
    }
    
    
    
    public void clearWishList() {
    	vh.getContentSplitLeft().getChildren().clear();
    }
    
    public void loadApplication() {
    	vh.getContentSplitRight().getChildren().add(vh.getApplicationTitleContainer());
    	vh.getViewAllApplication().setOnMouseClicked(e -> {
    		displayAllApplicationPopUp();
    	});
    	ArrayList<Application> applicationList= null;
    	
    	try {
			applicationList = Application.getAllWishItemsByUserId(((User)Main.currModel).getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(applicationList.isEmpty()) {
			vh.displayNoApplication();
			

		}else if(!applicationList.isEmpty()) {
			int itemCount = 0;
			for (Application applicationItem1 : applicationList) {
				if(itemCount < 2) {
					ApplicationListItem applicationListItem = new ApplicationListItem(applicationItem1.getJob().getName(), applicationItem1.getJob().getSalary(), applicationItem1.getJob().getDescription(), applicationItem1.getDate());
					applicationListItem.getRemoveButton().setOnAction(e ->{
						try {
							applicationItem1.delete();
							clearApplication();
							loadApplication();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					});
					applicationListItem.getViewButton().setOnAction(e -> {
						popUpApplicationDetail(applicationItem1.getJob(), applicationItem1.getDate(), applicationItem1.getCvDesc(), applicationItem1.getTranscriptDesc());
						
					});
					
					vh.getContentSplitRight().getChildren().add(applicationListItem);
					itemCount++;
				}
				
				
				
				
				
			}
		}
    	
    }
    
    public void clearApplication() {
    	vh.getContentSplitRight().getChildren().clear();
    }

 
}
