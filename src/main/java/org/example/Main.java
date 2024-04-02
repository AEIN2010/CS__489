package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        DummyDataGenerator.generateDummyData();

        int choice =24837;
        Scanner in = new Scanner(System.in);

        while(choice != 0){
            choice = in.nextInt();

            if(choice == 1){
                System.out.println(printAll(DummyDataGenerator.employees));
            } else if (choice == 2) {
                getUpcomingEnrolleesReport(DummyDataGenerator.employees).forEach(employee -> System.out.println(employee+"\n"));
            }else if (choice == 0){
                System.out.println("Thank you");
                System.exit(0);
            }
        }

    }

    //An important need for the company’s HR managers, is to be able to view the list
    //of all Employees who are qualified for Pensions Plan enrollment in the next
    //month. They call these the Monthly Upcoming Enrollees report. Any
    //Employee in the system whose period of employment has been at least 5
    //years, on or between the first and the last day of the next month and who
    //have NOT yet been enrolled to a Pension Plan, should have their data
    //presented in the Monthly Upcoming Enrollees report.


    private static List<Employee> getUpcomingEnrolleesReport(List<Employee> employeesList){
        List<Employee> upcomingEnrollees = employeesList
                .stream()
                .filter(employee -> (employee.getPensionPlan() == null)
                                    &&(employee.getEmploymentDate()
                                        .plusYears(5)
                                        .isBefore(LocalDate.now()
                                                    .plusMonths(1)
                                                    .plusDays(LocalDate.now().lengthOfMonth() - LocalDate.now().getDayOfMonth()))))
                                        .toList();
        return upcomingEnrollees;
    }


    private static String printAll(List<Employee> employees){

        StringBuilder jsonBuilder = new StringBuilder("[\n");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            jsonBuilder.append("  {\n");
            jsonBuilder.append("    \"employeeId\": ").append(employee.getEmployeeId()).append(",\n");
            jsonBuilder.append("    \"firstName\": \"").append(employee.getFirstName()).append("\",\n");
            jsonBuilder.append("    \"lastName\": \"").append(employee.getLastName()).append("\",\n");
            jsonBuilder.append("    \"employmentDate\": \"").append(employee.getEmploymentDate()).append("\",\n");
            jsonBuilder.append("    \"yearlySalary\": ").append(employee.getYearlySalary()).append(",\n");
            jsonBuilder.append("    \"pensionPlan\": {\n");
            PensionPlan pensionPlan = employee.getPensionPlan();
            if (pensionPlan != null) {
                jsonBuilder.append("      \"planReferenceNumber\": \"").append(pensionPlan.getPlanReferenceNumber()).append("\",\n");
                jsonBuilder.append("      \"monthlyContribution\": ").append(pensionPlan.getMonthlyContribution()).append("\n");
            } else {
                jsonBuilder.append("      \"planReferenceNumber\": null,\n");
                jsonBuilder.append("      \"monthlyContribution\": null\n");
            }
            jsonBuilder.append("    },\n");
            jsonBuilder.append("    \"enrollmentDate\": \"").append(employee.getEnrollmentDate()).append("\"\n");
            jsonBuilder.append("  }").append(i < employees.size() - 1 ? "," : "").append("\n");
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }


}