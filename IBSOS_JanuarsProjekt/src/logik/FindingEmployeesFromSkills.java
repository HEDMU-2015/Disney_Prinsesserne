package logik;

import java.util.ArrayList;
import java.util.List;

import data.DataLayer;



public class FindingEmployeesFromSkills {
	DataLayer dl = DataLayer.getInstance();
	Logik_SK sk = new Logik_SK();

	List<List> sendTilGUI = new ArrayList<>();

	List<Integer> skillID = new ArrayList<Integer>();
	List<String> employeeEmail = new ArrayList<String>();
	List<String> employeeEmailSorted = new ArrayList<String>();
	List<String> employeeNameDepartmentFromEmail = new ArrayList<String>();
	List<String> departmentName = new ArrayList<String>();
	List<String> samletListe = new ArrayList<String>();
	List<List> samletListe2 = new ArrayList<>();
	List<List> removeDublicates = new ArrayList<>();
	String departmentID = "";
	String employeeName;

	
	public List<List> findingEmplyeesFromSkills(String searchString) {
		String[] renSøgestreng = sk.kørSøgestrengenIgennemFlereTingForAtÆndreDenTilNogetViKanBrugeISQL(searchString);
		
		System.out.println("Dette skulle gerne være i toppen");
		for (int i = 0; i < renSøgestreng.length; i++){
			skillID = dl.searchEmployeeFromSkills1(renSøgestreng[i]);
			
			//System.out.println("Søgeord " + renSøgestreng[i]);
			System.out.println("For 1");

			for (int j = 0; j < skillID.size(); j++) {
				employeeEmail = dl.searchEmployeeFromSkills2(skillID.get(j));
				// System.out.println(employeeEmail.get(1));
				
				System.out.println("For 2");

				for (int j2 = 0; j2 < employeeEmail.size(); j2++) {
					employeeNameDepartmentFromEmail = dl.searchEmployeeFromSkills3(employeeEmail.get(j2));
					employeeName = employeeNameDepartmentFromEmail.get(1);
					departmentID = employeeNameDepartmentFromEmail.get(2);

					int gh = Integer.parseInt(departmentID);
				//	System.out.println("Afdelings nummer int "+gh);
				//	System.out.println("Navnet på medarbejderen " + employeeName);

					//TODO, Fjernet en ekstra forløkke, da en person kun kan være i en afdeling.
					departmentName = dl.searchEmployeeFromSkills3b(gh);
				//	System.out.println("Afdelings navn "+ departmentName);
						
					System.out.println("For 3");
						//TODO Her ligger vores problem
					//employeeEmail er lagt ud i en String MyEmail så den bliver udskiftet rigtigt
					//Vi skal evt gøre noget ved dubletterne, ellers tror jeg vi kan få problemer i GUI
					
					String MyEmail = employeeEmail.get(j2);
					for (int k2 = 0; k2 < employeeEmail.size(); k2++) {
						//	System.out.println("STEEN " + MyEmail +  employeeName + departmentName.get(0));
							SamlerTilGUI stg = new SamlerTilGUI();
							samletListe = stg.samlerListe(MyEmail, employeeName, departmentName.get(0));
							
							
							for (int k = 0; k < samletListe.size(); k++) {
								
								
								//System.out.println("hdssajkhgæjkhgs "+samletListe.size());
								//System.out.println("****************> "+samletListe.get(k));
							}
						}
						samletListe2.add(samletListe);
						for (int k = 0; k < samletListe2.size(); k++) {
							//System.out.println("Løsning ?????? "+samletListe2.get(k));
						}
					}
				}

			}

			for (int j = 0; j < samletListe2.size(); j++) {
				sendTilGUI.add(samletListe2.get(j));
				//System.out.println("========== "+sendTilGUI.get(j));
			}
			for (int i = 0; i < sendTilGUI.size(); i++) {
				if (sendTilGUI.contains(sendTilGUI.get(i)) && !removeDublicates.contains(sendTilGUI.get(i))) {
					
					removeDublicates.add(sendTilGUI.get(i));
				//	System.out.println("-------------> "+removeDublicates.get(i));
			}
				
			}
		return removeDublicates;
	}
}
