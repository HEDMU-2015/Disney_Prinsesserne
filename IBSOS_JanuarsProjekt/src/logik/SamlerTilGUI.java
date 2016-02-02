package logik;

import java.util.ArrayList;
import java.util.List;

import data.DataLayer;



public class SamlerTilGUI {
public List<String> samlerListe(String employeeEmail, String employeeName, String employeeDepartment) {
		
		//skal kalde en metode i datalayer med employeeName
		
		List<Integer> skillNumberList = new ArrayList<>();
		List<String> skillNameList = new ArrayList<>();
		List<String> gatheredEmployeeInformation = new ArrayList<>();
		
		DataLayer dl = DataLayer.getInstance();
		skillNumberList = dl.gatherEmployeeSkillNumberInList(employeeEmail);
		
		gatheredEmployeeInformation.add(employeeName);
		gatheredEmployeeInformation.add(employeeEmail);
		gatheredEmployeeInformation.add(employeeDepartment);
		
	/*	for (int i = 0; i < gatheredEmployeeInformation.size(); i++) {
			System.out.println("-->"+employeeName);
			System.out.println("-->"+employeeEmail);
			System.out.println("-->"+employeeDepartment);
		}*/
		
		for (int i = 0; i < skillNumberList.size(); i++) {
			
			skillNameList = dl.gatherEmployeeSkillNamesInList(skillNumberList.get(i));
			
			for (int j = 0; j < skillNameList.size(); j++) {
				String gh = skillNameList.get(j);
				
				gatheredEmployeeInformation.add(gh);
				
			}
		}
		
		//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		for (int i = 0; i < gatheredEmployeeInformation.size(); i++) {
			
		//	System.out.println("informationer på medarbejderen: "+gatheredEmployeeInformation.get(i));
		}
		return gatheredEmployeeInformation;
		
	}
}
