package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogBOX_TOM extends Application {
	@Override
	public void start(Stage primaryStage) {
		Stage stage = new Stage();
		BorderPane sceneBox = new BorderPane();

		stage.setTitle("ADVARSEL");
		stage.setScene(new Scene(sceneBox, 300, 200));
		stage.initModality(Modality.APPLICATION_MODAL);// låser den gamel vindue
		stage.show();
		sceneBox.setPadding(new Insets(10, 20, 10, 20));

		//OverSkrift
		Text heading = new Text("Mangelende tekst");
	    heading.setFont(Font.font("Arial", FontWeight.BLACK, 20));
	    
		VBox headBox = new VBox(10);
	    headBox.setAlignment(Pos.CENTER);
		headBox.getChildren().add(heading);
		sceneBox.setTop(headBox);
		
		
		//Brødtekst
		Label text = new Label();
		text.setPrefWidth(300);
	    text.setWrapText(true);
		text.setText("Mangelende tekst i titel boksen");
		HBox textBox = new HBox(10);
		textBox.setAlignment(Pos.CENTER);
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
