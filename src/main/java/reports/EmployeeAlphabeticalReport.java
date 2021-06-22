package reports;

import reportManagement.App;
import reportManagement.Menu;
import reportManagement.ProjectTask;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeAlphabeticalReport  {

    private static ArrayList<ProjectTask> projectTasks = Menu.getProjectTasks();
    
    public static void printReport(int year){

        Map<String, Float> map = new HashMap<>();
        for (ProjectTask p: projectTasks) {
        	
        	Calendar calendar = Calendar.getInstance();
        	
        	calendar.setTime(p.getDate());
        	
        	int result = calendar.get(Calendar.YEAR);
        	
            if (result == year) {

                float hours;
                if (map.get(p.getEmployeeName()) == null) {
                    hours = 0;
                } else {
                    hours = map.get(p.getEmployeeName());
                }
                map.put(p.getEmployeeName(), hours + p.getHours());
            }
        }
        Map<String, Float> result = new TreeMap<String, Float>(map);

        System.out.println("Wyświetlenie raportu godzin pracownikow w roku: " + year);
		System.out.println("______________________________________________________________");
		System.out.printf("| %-40s | %-10s|\n", "Nazwisko i imię", "h/rok");
        
        for (String key: result.keySet()) {


    		System.out.println("--------------------------------------------------------------");
    		System.out.printf("| %-40s | %-10s|\n", key, result.get(key));

        }
    }


}
