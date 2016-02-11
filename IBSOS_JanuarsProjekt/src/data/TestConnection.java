package data;

import java.util.ArrayList;
import java.util.List;

import logik.FindingEmployeesFromSkills;
import logik.Logik_SK;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SamlerTilGUI stg = new SamlerTilGUI();
		//stg.samlerListe("Simons Email", "Simon", "Sverige");
		
		List<List> print = new ArrayList<>();
		
		FindingEmployeesFromSkills fs = new FindingEmployeesFromSkills();
		
		//fs.getSkillsID("Udvikling, fokus");
		print = fs.findingEmplyeesFromSkills("Udvikling, macro");
		System.out.println("*****************************************");

		for (int i = 0; i < print.size(); i++) {
			System.out.println(print.get(i));
		}
		
		/*Datalayer dl = Datalayer.getInstance();
		SøgestrengsKlargøring sk = new SøgestrengsKlargøring();
		
		String[] renSøgestreng = sk.kørSøgestrengenIgennemFlereTingForAtÆndreDenTilNogetViKanBrugeISQL("Udvikling kg");
		
		List<Integer> skillID = new ArrayList<Integer>();
		List<String> employeeEmail = new ArrayList<String>();
		List<String> employeeNameDepartmentFromEmail = new ArrayList<String>();
		List<String> departmentName = new ArrayList<String>();
		//List<String> departmentID = new ArrayList<String>();
		String departmentID = "";
		
		for (int i = 0; i < renSøgestreng.length; i++) {
			skillID = dl.searchEmployeeFromSkills1(renSøgestreng[i]);
			System.out.println(renSøgestreng[i]);
			System.out.println("For 1");
			
			for (int j = 0; j < skillID.size()-1; j++) {
				employeeEmail = dl.searchEmployeeFromSkills2(skillID.get(j));
				System.out.println(employeeEmail.get(1));
				System.out.println("For 2");
				
				for (int j2 = 0; j2 < employeeEmail.size(); j2++) {
					employeeNameDepartmentFromEmail = dl.searchEmployeeFromSkills3(employeeEmail.get(j2));
					departmentID = employeeNameDepartmentFromEmail.get(2);
					
					int gh = Integer.parseInt(departmentID);
					System.out.println(gh);
					
					System.out.println(employeeNameDepartmentFromEmail.get(1));
					System.out.println(employeeNameDepartmentFromEmail.get(2));
					System.out.println("For 3");
					
					for (int k = 0; k < 1; k++) {
						departmentName = dl.searchEmployeeFromSkills3b(gh);
						System.out.println(departmentName);
						System.out.println("For 4");
					}
				}
				
			}
			
		}*/	
		
}}


