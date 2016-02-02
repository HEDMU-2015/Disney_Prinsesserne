package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Opretmenu extends Application {

	public void start(Stage primaryStage) {
	primaryStage.setTitle("Opret ... menu");
	GridPane box = new GridPane();
	primaryStage.setScene(new Scene(box, 400, 250));
	primaryStage.show();
	box.setAlignment(Pos.CENTER);
	box.setHgap(10);
	box.setVgap(10);

	Button Department = new Button(); //afdelinger knap
	Department.setText("Afdeling");
	Department.setPrefSize(150, 20);
	Department.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			CreateNewDepartment toCND = new CreateNewDepartment();
			try {
				toCND.start(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("trykket på opret ny afdeling");
		}});//slutningen af afdeling knap
	
	
	Button Employee = new Button(); //medarbejder knap
	Employee.setText("Medarbejder");
	Employee.setPrefSize(150, 20);
	Employee.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Trykket på opret ny medarbejder");
		}});//slutningen af medarbejder knap
	
	
	Button skillCategory = new Button(); //Overemner knap
	skillCategory.setText("Overemne");
	skillCategory.setPrefSize(150, 20);
	skillCategory.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			System.out.println("Trykket på opret ny overemne");
		}});//slutningen af overemner knap
	
	
	Button skill = new Button(); //kompetence knap
	skill.setText("Kompetence");
	skill.setPrefSize(150, 20);
	skill.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
		
			System.out.println("Trykket på opret ny kompetence");
		}});//slutningen af kompetence knap
	
	
	HBox departmentBOX = new HBox(10);
	departmentBOX.setAlignment(Pos.CENTER_RIGHT);
	departmentBOX.getChildren().add(Department);
	box.add(Department,0,1);
	
	HBox employeeBOX = new HBox(10);
	employeeBOX.setAlignment(Pos.CENTER);
	employeeBOX.getChildren().add(Employee);
	box.add(Employee,1,1);
	
	HBox skillCategoryBOX = new HBox(10);
	skillCategoryBOX.setAlignment(Pos.BOTTOM_LEFT);
	skillCategoryBOX.getChildren().add(skillCategory);
	box.add(skillCategory,0,2);
	
	HBox skillBOX = new HBox(10);
	skillBOX.setAlignment(Pos.CENTER);
	skillBOX.getChildren().add(skill);
	box.add(skill,1,2);
	
	//TODO
	//tilbage knap
	Button back = new Button();
	back.setText("<-");
	back.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			KA_Søg kas = new KA_Søg();
			kas.start(primaryStage);
			System.out.println("Tilbage til KAS");
		}});//slutningen af tilbage knap
	
	HBox backBOX = new HBox(10);
	backBOX.setAlignment(Pos.CENTER);
	backBOX.getChildren().add(back);
	box.add(back,2,0);
}}


