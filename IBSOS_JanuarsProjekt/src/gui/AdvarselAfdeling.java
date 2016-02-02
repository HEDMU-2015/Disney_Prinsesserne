package gui;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdvarselAfdeling extends Application {

	public void start(Stage primaryStage) {
		Stage stage = new Stage();
		BorderPane sceneBox = new BorderPane();

		stage.setTitle("ADVARSEL");
		stage.setScene(new Scene(sceneBox, 450, 200));
		stage.initModality(Modality.APPLICATION_MODAL);// låser den gamel vindue
		stage.show();
		sceneBox.setPadding(new Insets(10, 20, 10, 20));

		//OverSkrift
		Text heading = new Text("ADVARSEL");
	    heading.setFont(Font.font("Arial", FontWeight.BLACK, 20));
	    
		VBox headBox = new VBox(10);
	    headBox.setAlignment(Pos.BASELINE_CENTER);
		headBox.getChildren().add(heading);
		sceneBox.setTop(headBox);
		
		
		//Brødtekst
		Label text = new Label();
		text.setPrefWidth(300);
	    text.setWrapText(true);
		text.setText("Der er tilknyttet en eller flere medarbejdere til den pågældene afdeling."
				+ "\nVær venligst sikker på, der ingen medarbejdere er tilknyttet afdelingen inden sletningen.");
		HBox textBox = new HBox(10);
		textBox.setAlignment(Pos.BASELINE_CENTER);
		textBox.getChildren().add(text);
		sceneBox.setCenter(textBox);
		
		
		// OK knap
		Button OK = new Button();
		OK.setText("OK");
		OK.setPrefSize(100, 20);
		OK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				stage.close();
				System.out.println("advarsel lukket");
			}});
		HBox okBox = new HBox(10);
		okBox.setAlignment(Pos.BOTTOM_RIGHT);
		okBox.getChildren().add(OK);
		sceneBox.setBottom(okBox);
	}
}