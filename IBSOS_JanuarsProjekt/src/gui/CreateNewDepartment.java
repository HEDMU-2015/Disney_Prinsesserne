package gui;

import data.DataLayer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewDepartment extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage stage = new Stage();
		BorderPane sceneBox = new BorderPane();

		stage.setTitle("Opret ny afdeling");
		stage.setScene(new Scene(sceneBox, 450, 200));
		stage.initModality(Modality.APPLICATION_MODAL);// låser den gamel vindue
		stage.show();
		sceneBox.setPadding(new Insets(10, 20, 10, 20));

		// OverSkrift
		Text heading = new Text("Opret ny afdeling");
		heading.setFont(Font.font("Arial", FontWeight.BLACK, 20));

		VBox headBox = new VBox(10);
		headBox.setAlignment(Pos.BASELINE_CENTER);
		headBox.getChildren().add(heading);
		sceneBox.setTop(headBox);

		// indsæt titel område
		TextField titelArea = new TextField();
		HBox titelAreaBox = new HBox(10);
		titelAreaBox.setAlignment(Pos.CENTER);
		titelAreaBox.getChildren().add(titelArea);
		sceneBox.setCenter(titelAreaBox);

		// tekst
		Label titel = new Label("Titel");
		titel.setFont(new Font("Arial", 18));
		HBox titelBox = new HBox(10);
		titelBox.setAlignment(Pos.CENTER_RIGHT);
		titelBox.getChildren().add(titel);
		sceneBox.setLeft(titelBox);

		// OK knap
		Button OK = new Button();
		OK.setText("OK");
		OK.setPrefSize(100, 20);
		OK.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Det virker");
				DataLayer DBdepartment = DataLayer.getInstance();
				
				if(DBdepartment.createNewDepartment(titelArea.getText()) == true){
					AdvarselAfdeling AA = new AdvarselAfdeling();
					AA.start(primaryStage);
				}
				if (titelArea.getText().isEmpty()) {
					DialogBOX_TOM emty = new DialogBOX_TOM();
					emty.start(primaryStage);
					System.out.println("Den er tom");
					
				}else  {
					DBdepartment.createNewDepartment(titelArea.getText());
					System.out.println("Opret ny afdeling gemt");
					stage.close();
				}
			}
		});

		// Annuller knap
		Button back = new Button();
		back.setText("Annuller");
		back.setPrefSize(100, 20);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Opretmenu createMenu = new Opretmenu();
				createMenu.start(primaryStage);
				stage.close();
				System.out.println("Går tilbage til Opret menu");
			}
		});//

		HBox backBOX = new HBox(10);
		backBOX.setAlignment(Pos.TOP_CENTER);
		backBOX.setAlignment(Pos.BOTTOM_RIGHT);
		backBOX.getChildren().addAll(OK, back);
		sceneBox.setBottom(backBOX);

	}

}

