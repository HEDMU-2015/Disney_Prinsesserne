package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//Jeg har lavet noget nyt :D
// nu er det mig der laver noget

public class DataLayer {
	boolean returner = false;
	ResultSet resultset = null;
	ResultSet resultset2 = null;
	int departmentNumber = 0;
	int skillCategoryNumber = 0;
	int skillNumber = 0;
	
	List<String> resultatListe;
	List<Integer> idListe;
	int i = 1;

	// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url = "jdbc:sqlserver://10.153.246.1:1433;instanceName=SQLExpress;databaseName=IPSOS;user=Elisa;password=12345678";

	// Creating a singleton class.
	private static DataLayer instance = null;

	private DataLayer() {
		// Exists only to defeat instantiation.
	}

	public static DataLayer getInstance() {
		if (instance == null) {
			instance = new DataLayer();
		}
		return instance;
	}

	// Creating a testconnection to our DB :)
	public void testConnection() {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT * FROM Employee");

			while (resultset.next()) {
				/*for (int i = 1; i <= 3; i++)
					//System.out.println((resultset.getString(i)));*/

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean createNewDepartment(String departmentTitle) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT ID FROM Departments WHERE Name = '" + departmentTitle + "'");

			if (resultset.next() == true) {

				System.out.println((resultset.getString(1)));
				System.out.println("afdeling findes allerede + afdelingstitel");
				returner = true;
			} else {

				statement.executeUpdate("INSERT INTO Departments VALUES('" + departmentTitle + "')");
				System.out.println("Yay du må godt :)");
				returner = false;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return returner;

	}

	// TODO employee mangler at sat skills og afdeling på
	public void createNewEmployee(String employeeName, String employeeEmail, String employeeDepartment) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT * FROM Employee WHERE Email = '" + employeeEmail + "'");

			if (resultset.next() == true) {

				System.out.println((resultset.getString(1)));
				System.out.println("Medarbejder findes allerede + medarbejder");

			} else {
				resultset2 = statement
						.executeQuery("SELECT ID From Departments WHERE Name = '" + employeeDepartment + "'");
				if (resultset2.next() == true) {
					System.out.println(Integer.parseInt((resultset2.getString(1))));
					departmentNumber = Integer.parseInt((resultset2.getString(1)));

					statement.executeUpdate("INSERT INTO Employee VALUES('" + employeeName + "','" + employeeEmail
							+ "','" + departmentNumber + "')");
					System.out.println("Yay du må godt :)");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	// TODO skill skal have skillcategory på
	public void createNewSkill(String skill, String skillCategory) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT * FROM Skills WHERE Skill = '" + skill + "'");

			if (resultset.next() == true) {
				System.out.println((resultset.getString(1)));
				System.out.println("skill findes allerede + skill");

			} else {
				resultset2 = statement
						.executeQuery("SELECT ID From SkillCategorys WHERE SKillCategory = '" + skillCategory + "'");
				if (resultset2.next() == true) {
					System.out.println(Integer.parseInt((resultset2.getString(1))));
					skillCategoryNumber = Integer.parseInt((resultset2.getString(1)));

					statement.executeUpdate("INSERT INTO Skills VALUES('" + skill + "','" + skillCategoryNumber + "')");
					System.out.println("Yay du må godt :)");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void createNewSkillCategory(String skillCategory) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement
					.executeQuery("SELECT ID FROM SkillCategorys WHERE SkillCategory = '" + skillCategory + "'");

			if (resultset.next() == true) {

				System.out.println((resultset.getString(1)));
				System.out.println("skillCategory findes allerede + skillCategory");

			} else {

				statement.executeUpdate("INSERT INTO SkillCategorys VALUES('" + skillCategory + "')");
				System.out.println("Yay du må godt :)");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void deleteDepartment(String departmentTitle) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT ID FROM Departments WHERE Name = '" + departmentTitle + "'");

			if (resultset.next() == true) {
				System.out.println((resultset.getString(1)));
				departmentNumber = Integer.parseInt(resultset.getString(1));

			} else {
				System.out.println("Her skal være noget med ingen resultater fundet");
			}
			resultset2 = statement.executeQuery("SELECT * FROM Employee WHERE Department = '" + departmentNumber + "'");

			if (resultset2.next() == true) {

				System.out.println("Her skal laves en advarselspopup :)");
			} else {
				statement.executeUpdate("DELETE FROM Departments WHERE Name ='" + departmentTitle + "'");
				System.out.println("Yay du må godt :)");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

	}

	public void deleteEmployee(String employeeEmail) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT * FROM Employee WHERE Email = '" + employeeEmail + "'");

			if (resultset.next() == true) {
				System.out.println((resultset.getString(1)));
				statement.executeUpdate("DELETE * FROM Employee WHERE Email ='" + employeeEmail + "'");
				System.out.println("Yay du må godt :)");

			} else {
				System.out.println("Her skal være noget med ingen resultater fundet");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void deleteSkill(String skillName) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT * FROM Skills WHERE Skill = '" + skillName + "'");

			if (resultset.next() == true) {
				System.out.println((resultset.getString(1)));
				statement.executeUpdate("DELETE FROM Skills WHERE Skill ='" + skillName + "'");
				System.out.println("Yay du må godt :)");

			} else {
				System.out.println("Her skal være noget med ingen resultater fundet");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void deleteSkillCategory(String skillCategory) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement
					.executeQuery("SELECT ID FROM SkillCategorys WHERE SkillCategory = '" + skillCategory + "'");

			if (resultset.next() == true) {
				System.out.println((resultset.getString(1)));
				skillCategoryNumber = Integer.parseInt(resultset.getString(1));

			} else {
				System.out.println("Her skal være noget med ingen resultater fundet");
			}
			resultset2 = statement
					.executeQuery("SELECT * FROM Skills WHERE SkillCategory = '" + skillCategoryNumber + "'");

			if (resultset2.next() == true) {

				System.out.println("Her skal laves en advarselspopup :)");
			} else {
				statement.executeUpdate("DELETE  FROM SkillCategorys WHERE SkillCategory ='" + skillCategory + "'");
				System.out.println("Yay du må godt :)");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void updateDepartment(String newDepartmentTitle, String oldDepartmentTitle) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT ID FROM Departments WHERE Name = '" + oldDepartmentTitle + "'");

			if (resultset.next() == true) {
				System.out.println((resultset.getString(1)));
				skillCategoryNumber = Integer.parseInt(resultset.getString(1));
			}

			resultset2 = statement.executeQuery("SELECT * FROM Departments WHERE Name = '" + newDepartmentTitle + "'");

			if (resultset2.next() == true) {
				System.out.println("Afdelingsnavn er allerede i brug");
			} else {
				statement.executeUpdate("UPDATE Departments SET Name = '" + newDepartmentTitle + "' WHERE ID = '"
						+ skillCategoryNumber + "'");
				System.out.println("ITS WORKING :D ");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	// TODO Der er problemer med identifikationen når den gamle email = ny
	// email. Bliver sikkert også et problem ved andre updates
	public void updateEmployee(String newEmployeeName, String newEmployeeEmail, String newEmployeeDepartment,
			String oldEmployeeEmail) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			resultset = statement.executeQuery("SELECT * FROM Employee WHERE Email = '" + oldEmployeeEmail + "'");

			if (resultset.next() == true) {
			//	System.out.println((resultset.getString(1)));

				resultset2 = statement.executeQuery("SELECT * FROM Employee WHERE Email = '" + newEmployeeEmail + "'");

				if (resultset2.next() == true) {
				//	System.out.println("Afdelingsnavn er allerede i brug");
				} else {
					statement.executeUpdate("UPDATE Departments SET Name = '" + resultset + "' WHERE ID = '"
							+ skillCategoryNumber + "'");
				//	System.out.println("ITS WORKING :D ");
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void updateSkill(String skill, String skillCategory) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// statement.executeUpdate("INSERT INTO Departments VALUES('"+
			// departmentTitle +"')");

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public void updateSkillCategory(String skillCategory) {
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();

			// statement.executeUpdate("INSERT INTO Departments VALUES('"+
			// departmentTitle +"')");

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}

	public List<Integer> searchEmployeeFromSkills1(String searchString) {
		//TODO brug "LIKE" og ? for at få bedre resultater frem for =.
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			
			resultset = statement.executeQuery("SELECT ID FROM Skills WHERE Skill LIKE '%"+searchString+"%'");
			
			idListe = new ArrayList<>();
			
			while(resultset.next()) {
		//		System.out.println("ID fra skills: "+(resultset.getString(1)));
				skillNumber = Integer.parseInt(resultset.getString(1));
				idListe.add(skillNumber);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return idListe;
		
	}
	public List<String> searchEmployeeFromSkills2(int skillNumber){
		//TODO brug "LIKE" og ? for at få bedre resultater frem for =.
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			resultatListe = new ArrayList<String>();
			
			resultset2 = statement.executeQuery("SELECT Email From SkillEmployeeCombo WHERE ID = '"+ skillNumber +"'");
			
			while(resultset2.next()){
			
				//System.out.println("Hvem har denne skill? (Email): "+resultset2.getString(1));
				resultatListe.add(resultset2.getString(1));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return resultatListe;
		
	}
	public List<String> searchEmployeeFromSkills3(String email){
		//TODO brug "LIKE" og ? for at få bedre resultater frem for =.
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			resultatListe = new ArrayList<String>();
			
			resultset = statement.executeQuery("SELECT Name, Department From Employee WHERE Email = '"+ email +"'");
			
			
			while(resultset.next()) {
				String navn = resultset.getString(1);
				//System.out.println("----------------------");
				//System.out.println("medarbejder navn "+navn);
				
				resultatListe.add(email);
				resultatListe.add(resultset.getString(1));
				resultatListe.add(resultset.getString(2));
				
				//System.out.println("en eller andens email "+email);
				//System.out.println("resultset 1 - Navn " + resultset.getString(1));
			//	System.out.println("resultset 2 - afdelings ID " + resultset.getString(2));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return resultatListe;
		
	}
	public List<String> searchEmployeeFromSkills3b(int departmentNumber){
		//TODO brug "LIKE" og ? for at få bedre resultater frem for =.
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			resultatListe = new ArrayList<String>();
			
			resultset = statement.executeQuery("SELECT Name From Departments WHERE ID = '"+ departmentNumber +"'");
			
			while(resultset.next()) {
				
				resultatListe.add(resultset.getString(1));
				
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return resultatListe;
		
	}

	public List<Integer> gatherEmployeeSkillNumberInList (String employeeEmail) {
		
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			
			resultset = statement.executeQuery("SELECT ID FROM SkillEmployeeCombo WHERE Email = '"+employeeEmail+"'");
			
			idListe = new ArrayList<>();
			
			while(resultset.next()) {
				//System.out.println("ID fra skills: "+(resultset.getString(1)));
				skillNumber = Integer.parseInt(resultset.getString(1));
				
				idListe.add(skillNumber);
				//System.out.println("skill nummer som int "+skillNumber);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		
		
		return idListe;
		
	}
	public List<String> gatherEmployeeSkillNamesInList(int skillIDList) {
		
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			
			resultset = statement.executeQuery("SELECT Skill FROM Skills WHERE ID = '"+skillIDList+"'");
			
			resultatListe = new ArrayList<>();
			
			while(resultset.next()) {
				//System.out.println("Navn på skills: "+(resultset.getString(1)));
				
				resultatListe.add(resultset.getString(1));	
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return resultatListe;
	}
}