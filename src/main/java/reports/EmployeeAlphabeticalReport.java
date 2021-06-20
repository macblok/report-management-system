package reports;

import reportManagement.App;
import reportManagement.Menu;
import reportManagement.ProjectTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeAlphabeticalReport  {

    private static ArrayList<ProjectTask> projectTasks = Menu.getProjectTasks();
    public static void printReport(int year){

        Map<String, Integer> map = new HashMap<>();
        for (ProjectTask p: projectTasks) {

            if (p.getDate().getYear() == year) {

                int hours;
                if (map.get(p.getEmployeeName()) == null) {
                    hours = 0;
                } else {
                    hours = map.get(p.getEmployeeName());
                }
                map.put(p.getEmployeeName(), hours + p.getHours());
            }
        }
        Map<String, Integer> result = new TreeMap<String, Integer>(map);

        System.out.println("Wyświetlenie raportu godzin pracownikow w danym roku:");

        for (String key: result.keySet()) {

            System.out.printf("\n%30s %15s", key, result.get(key));

        }
    }


}
