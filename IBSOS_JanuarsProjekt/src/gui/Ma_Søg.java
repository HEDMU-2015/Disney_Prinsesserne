package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ma_Søg extends Application {
	
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Søg");
		GridPane sceneBox = new GridPane();
		primaryStage.setScene(new Scene(sceneBox, 600, 600));
		primaryStage.show();
		sceneBox.setAlignment(Pos.CENTER);
		sceneBox.setHgap(10);
		sceneBox.setVgap(10);

		TextField searchArea = new TextField();
		HBox searchAreaBox = new HBox(10);
		searchAreaBox.setAlignment(Pos.CENTER);
		searchAreaBox.getChildren().add(searchArea);
		sceneBox.add(searchArea, 0, 0);

		// Kompetencer
		CheckBox skillCheckBox = new CheckBox("Kompetencer");
		skillCheckBox.setSelected(false);
		// Afdelinger
		CheckBox departmentCheckBox = new CheckBox("Afdelinger");
		departmentCheckBox.setSelected(false);
		// MEdarbejder
		CheckBox employeeCheckBox = new CheckBox("Medarbejder");
		employeeCheckBox.setSelected(false);
		// Overemner
		CheckBox skillCategoryCheckBox = new CheckBox("Overemner");
		skillCategoryCheckBox.setSelected(false);

		skillCheckBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (skillCheckBox.isSelected() == true) {
					System.out.println("!!!!KLIK!!!");
					departmentCheckBox.setSelected(false);
					employeeCheckBox.setSelected(false);
					skillCategoryCheckBox.setSelected(false);
				} else {
					System.out.println("!!AFKLIKKET!");
				}
			}
		});

		HBox skillBox = new HBox(10);
		skillBox.setAlignment(Pos.CENTER);
		skillBox.getChildren().add(skillCheckBox);
		sceneBox.add(skillCheckBox, 0, 1);

		// Afdelinger
		departmentCheckBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (departmentCheckBox.isSelected() == true) {
					System.out.println("!!!!KLIK!!!");
					employeeCheckBox.setSelected(false);
					skillCategoryCheckBox.setSelected(false);
					skillCheckBox.setSelected(false);
				} else {
					System.out.println("!!AFKLIKKET!");
				}
			}
		});

		HBox departmentBox = new HBox(10);
		departmentBox.setAlignment(Pos.CENTER);
		departmentBox.getChildren().add(departmentCheckBox);
		sceneBox.add(departmentCheckBox, 0, 2);

		// MEdarbejder
		employeeCheckBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (employeeCheckBox.isSelected() == true) {
					System.out.println("!!!!KLIK!!!");
					departmentCheckBox.setSelected(false);
					skillCategoryCheckBox.setSelected(false);
					skillCheckBox.setSelected(false);
				} else {
					System.out.println("!!AFKLIKKET!");
				}
			}
		});

		HBox employeeBox = new HBox(10);
		employeeBox.setAlignment(Pos.CENTER);
		employeeBox.getChildren().add(employeeCheckBox);
		sceneBox.add(employeeCheckBox, 0, 3);

		// Overemner
		skillCategoryCheckBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (skillCategoryCheckBox.isSelected() == true) {
					System.out.println("!!!!KLIK!!!");
					departmentCheckBox.setSelected(false);
					employeeCheckBox.setSelected(false);
					skillCheckBox.setSelected(false);
				} else {
					System.out.println("!!AFKLIKKET!");
				}
			}
		});

		HBox skillCategoryBox = new HBox(10);
		skillCategoryBox.setAlignment(Pos.CENTER);
		skillCategoryBox.getChildren().add(skillCategoryCheckBox);
		sceneBox.add(skillCategoryCheckBox, 0, 4);

		// REsultat
		TableView table = new TableView();
		table.setEditable(true);

		TableColumn nameCol = new TableColumn("Navn");
		TableColumn emailCol = new TableColumn("Email");
		TableColumn departmentCol = new TableColumn("Afdeling");
		TableColumn skillCategoryCol = new TableColumn("Overemne");
		TableColumn skillCol = new TableColumn("Kompetencer");

		table.getColumns().addAll(nameCol, emailCol, skillCol,departmentCol,skillCategoryCol);
		//departmentCol.setVisible(false);

		HBox resultBox = new HBox(10);
		resultBox.setAlignment(Pos.CENTER_RIGHT);
		resultBox.getChildren().add(table);
		sceneBox.add(table, 0, 5);

		// Søg knap
		Button search = new Button(); // afdelinger knap
		search.setText("Søg");
		search.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (skillCategoryCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på overemne");
				} else if (skillCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på Kompetencer");
				} else if (employeeCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på Medarbejder");
				} else if (departmentCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på Afdelinger");
				}
			}});
		HBox searchBOX = new HBox(10);
		searchBOX.setAlignment(Pos.CENTER_RIGHT);
		searchBOX.getChildren().add(search);
		sceneBox.add(search, 1, 0);

		// Tilbage knap
		Button back = new Button();
		back.setText("<-");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Hovedmenu toHovedmenu = new Hovedmenu();
				toHovedmenu.start(primaryStage);
				System.out.println("SERIØST STOP!!?? !!!");
				
			}
		});// slutningen af tilbage knap

		HBox backBOX = new HBox(10);
		backBOX.setAlignment(Pos.CENTER);
		backBOX.getChildren().add(back);
		sceneBox.add(back, 3, 0);
	}
}

