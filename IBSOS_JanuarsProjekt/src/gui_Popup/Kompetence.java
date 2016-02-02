package gui_Popup;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Kompetence {


	public void start(Stage primaryStage) {
		Stage stage = new Stage();
		BorderPane sceneBox = new BorderPane();

		stage.setTitle("");
		stage.setScene(new Scene(sceneBox, 450, 200));
		stage.initModality(Modality.APPLICATION_MODAL);// låser den gamel vindue
		stage.show();
		sceneBox.setPadding(new Insets(10, 20, 10, 20));
		
	}
}
