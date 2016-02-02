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

public class Hovedmenu extends Application {

	public void start(Stage primaryStage) {

		primaryStage.setTitle("Hovedmenu");
		GridPane scene = new GridPane();
		primaryStage.setScene(new Scene(scene, 300, 250));
		primaryStage.show();
		scene.setAlignment(Pos.CENTER);
		scene.setVgap(20);
		
		Button ka = new Button(); //Kompetenceansvarlig knap
		ka.setPrefSize(200, 20);
		ka.setText("Kompetenceansvarlig");
		ka.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				KA_Søg kaSøg = new KA_Søg();
				kaSøg.start(primaryStage);
				System.out.println("Går KAsøg");
			}});//slutningen af kompetenceansvarlig knap
		
		
		
		Button ma = new Button ();//medarbejder knap
		ma.setPrefSize(200, 20);
		ma.setText("Medarbejder");
		ma.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event){
				Ma_Søg søg = new Ma_Søg();
				søg.start(primaryStage);
				System.out.println("Går til MAsøg");			
		}});
		
		HBox kaknap = new HBox(10);
		kaknap.setAlignment(Pos.CENTER);
		kaknap.getChildren().add(ka);
		scene.add(ka,0,0);
	
		HBox maknap = new HBox(10);
		maknap.setAlignment(Pos.CENTER);
		maknap.getChildren().add(ma);
		scene.add(ma,0,1);
		
		
	}
}