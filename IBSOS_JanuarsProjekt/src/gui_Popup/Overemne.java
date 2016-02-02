package gui_Popup;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Overemne {
	Stage stage;

	public void start(Stage primaryStage) {
		
		stage = new Stage();
		stage.setTitle("Overemne");
		GridPane popUpScene = new GridPane();
		stage.setScene(new Scene(popUpScene, 250, 150));
		stage.initModality(Modality.APPLICATION_MODAL);//sammen med showandwait, låser den gamel vindue
		stage.showAndWait();
		popUpScene.setAlignment(Pos.CENTER);
		
	}
}
