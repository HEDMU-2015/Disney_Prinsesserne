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

public class KAmenu extends Application {

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Kompetenceansvarlig administrationsmenu");
		GridPane box = new GridPane();
		primaryStage.setScene(new Scene(box, 300, 250));
		primaryStage.show();
		box.setAlignment(Pos.CENTER);
		box.setHgap(10);
		box.setVgap(10);

		Button search = new Button(); //søg knap
		search.setText("Søg");
		search.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				KA_Søg søg = new KA_Søg();
				søg.start(primaryStage);
				System.out.println("Går til søg");
			}});//slutningen af søg knap
		
		
		Button create = new Button(); //opret knap
		create.setText("Opret");
		create.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Opretmenu opretMenu = new Opretmenu();
				opretMenu.start(primaryStage);
				System.out.println("Går til Opret Menu");
			}});//slutningen af opret knap
		
		
		Button update = new Button(); //opdater knap
		update.setText("Opdater");
		update.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("AV!!?? !!!");
			}});//slutningen af opdater knap
		
		
		Button delete = new Button(); //slet knap
		delete.setText("Slet");
		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("SERIØST STOP!!?? !!!");
			}});//slutningen af slet knap
		
		HBox searchBOX = new HBox(10);
		searchBOX.setAlignment(Pos.CENTER_RIGHT);
		searchBOX.getChildren().add(search);
		box.add(search,0,0);
		
		HBox createBOX = new HBox(10);
		createBOX.setAlignment(Pos.CENTER);
		createBOX.getChildren().add(create);
		box.add(create,1,0);
		
		HBox updateBOX = new HBox(10);
		updateBOX.setAlignment(Pos.BOTTOM_LEFT);
		updateBOX.getChildren().add(update);
		box.add(update,0,1);
		
		HBox deleteBOX = new HBox(10);
		deleteBOX.setAlignment(Pos.CENTER);
		deleteBOX.getChildren().add(delete);
		box.add(delete,1,1);
		
	//TODO
	//Tilbage knap	
		Button back = new Button();
		back.setText("<-");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Hovedmenu toHovedmenu = new Hovedmenu();
				toHovedmenu.start(primaryStage);
				System.out.println("SERIØST STOP!!?? !!!");
			}});//slutningen af tilbage knap
		
		HBox backBOX = new HBox(10);
		backBOX.setAlignment(Pos.CENTER);
		backBOX.getChildren().add(back);
		box.add(back,2,2);
}}