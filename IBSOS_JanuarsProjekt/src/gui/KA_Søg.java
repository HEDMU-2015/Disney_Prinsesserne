package gui;


import java.util.ArrayList;
import java.util.List;

import data.DataLayer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logik.FindingEmployeesFromSkills;
import logik.Logik_SK;
import logik.SamlerTilGUI;


public class KA_Søg extends Application {
	FindingEmployeesFromSkills fefs = new FindingEmployeesFromSkills();
	List<List> udtræk = new ArrayList<>();
	 List<String> første = new ArrayList<>();
	 List<String> anden = new ArrayList<>();
	 List<String> tredje = new ArrayList<>();
	 
	public void start(Stage primaryStage) {		
		primaryStage.setTitle("Søg");
		GridPane sceneBox = new GridPane();
		primaryStage.setScene(new Scene(sceneBox, 600, 600));
		primaryStage.show();
		sceneBox.setAlignment(Pos.CENTER);
		sceneBox.setHgap(10);
		sceneBox.setVgap(10);

		//Søge fældt
		TextField searchArea = new TextField();
		HBox searchAreaBox = new HBox(10);
		searchAreaBox.setAlignment(Pos.CENTER);
		searchAreaBox.getChildren().add(searchArea);
		sceneBox.add(searchArea, 0, 0);

		
		
		
		// Kompetencer
		CheckBox skillCheckBox = new CheckBox("Kompetencer");
		skillCheckBox.setSelected(true);
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
	   
		//resultat
		TextArea text = new TextArea();
		text.setPrefRowCount(15);
		text.setPrefColumnCount(30);
		text.setWrapText(true);
		text.setPrefWidth(300);
		
		HBox resultBox = new HBox(10);
		resultBox.setAlignment(Pos.CENTER_RIGHT);
		resultBox.getChildren().add(text);
		sceneBox.add(text, 0, 5);
		//resultat slut
		
		
		
		// Søg knap
		Button search = new Button(); // søg knap
		search.setText("Søg");
		search.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Logik_SK searchSplit = new Logik_SK();
				
				if (skillCategoryCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på overemne");
					searchSplit.kørSøgestrengenIgennemFlereTingForAtÆndreDenTilNogetViKanBrugeISQL(searchArea.getText());
					System.out.println("det her : "+searchArea.getText());
					
					
				} else if (skillCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på Kompetencer");
					System.out.println("det her : "+searchArea.getText());
					
					//System.out.println("resultat " + fefs.findingEmplyeesFromSkills(searchArea.getText()));

					System.out.println("*****************************************");

					for (int i = 0; i < udtræk.size(); i++) {
						System.out.println(udtræk.get(i));
					}
					
					
					
					udtræk = fefs.findingEmplyeesFromSkills(searchArea.getText());
					
					første = udtræk.get(0);
					anden = udtræk.get(1);
					tredje = udtræk.get(2);
					
					String cssDefault = første+"\n\n "+anden+"\n\n "+tredje;
			        text.setText(cssDefault);
				
				/*	for (int i = 0; i < første.size(); i++) {
						System.out.println("--> " + første.get(i));	
						String ting = første.get(i);
						text.setText(ting);
					}
					for (int j = 0; j < anden.size(); j++) {
						System.out.println("---> " + anden.get(j));
						String tingt = anden.get(j);
						text.setText(tingt);
					}
					for (int k = 0; k < tredje.size(); k++) {
						System.out.println("----> " + tredje.get(k));
						String ting = tredje.get(k);
						text.setText(ting);
					}*/
					
					
					
				} else if (employeeCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på Medarbejder");
					searchSplit.kørSøgestrengenIgennemFlereTingForAtÆndreDenTilNogetViKanBrugeISQL(searchArea.getText());
					System.out.println("det her : "+searchArea.getText());
					
				} else if (departmentCheckBox.isSelected() == true) {
					System.out.println("Der bliver søgt på Afdelinger");
					searchSplit.kørSøgestrengenIgennemFlereTingForAtÆndreDenTilNogetViKanBrugeISQL(searchArea.getText());
					System.out.print("Det her: " + searchArea.getText());
				}
			}
		});
		HBox searchBOX = new HBox(10);
		searchBOX.setAlignment(Pos.CENTER_RIGHT);
		searchBOX.getChildren().add(search);
		sceneBox.add(search, 1, 0);
		
		
		// REsultat
		
	/*	TableView<String> table = new TableView<String>(FXCollections.observableArrayList());
		table.setEditable(true);

		TableColumn nameCol = new TableColumn("Navn");
		TableColumn emailCol = new TableColumn("Email");
		TableColumn departmentCol = new TableColumn("Afdeling");
		TableColumn skillCategoryCol = new TableColumn("Overemne");
		TableColumn skillCol = new TableColumn("Kompetencer");

		table.getColumns().addAll(nameCol, emailCol, skillCol,skillCategoryCol,departmentCol);*/
		//departmentCol.setVisible(false);
		
					
			
				

		// Tilbage knap
		Button back = new Button();
		back.setText("<-");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Hovedmenu hovedmenu = new Hovedmenu();
				hovedmenu.start(primaryStage);
				System.out.println("SERIØST STOP!!?? !!!");
			}
		});// slutningen af tilbage knap

		HBox backBOX = new HBox(10);
		backBOX.setAlignment(Pos.CENTER);
		backBOX.getChildren().add(back);
		sceneBox.add(back, 3, 0);

		
		
		// Opret knap
		Button create = new Button(); // opret ny knap
		create.setText("Opret ny");
		create.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			
				Opretmenu createMenu = new Opretmenu();
				createMenu.start(primaryStage);
				
				
			}});
		HBox createBOX = new HBox(10);
		createBOX.setAlignment(Pos.BOTTOM_RIGHT);
		createBOX.getChildren().add(create);
		sceneBox.add(create, 1, 5);
	}
}

