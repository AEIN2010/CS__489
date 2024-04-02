package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyDataGenerator {


    private static int counter = 0;
    public static List<Employee> employees = new ArrayList<>();
    public static boolean generateDummyData(){
       if(counter == 0){
           PensionPlan pensionPlan1 = new PensionPlan("PLAN001", 100.00);
           PensionPlan pensionPlan2 = new PensionPlan("PLAN002", 950.00);

           // Creating a list to store Employee objects


           // Adding sample Employee objects to the list
           employees.add(new Employee(1001L, "John", "Doe", LocalDate.of(2018, 1, 17), 105945.50, pensionPlan1, LocalDate.of(2023, 1, 17)));
           employees.add(new Employee(1002L, "Alice", "Smith", LocalDate.of(2018, 10, 20), 90750.00, pensionPlan2, LocalDate.of(2023, 9, 21)));
           employees.add(new Employee(1003L, "Michael", "Johnson", LocalDate.of(2017, 5, 8), 85000.00, null, null));
           employees.add(new Employee(1004L, "Emily", "Brown", LocalDate.of(2019, 3, 12), 75000.00, null, null));
           employees.add(new Employee(1005L, "David", "Wilson", LocalDate.of(2016, 8, 30), 110000.00, pensionPlan1, LocalDate.of(2023, 1, 17)));
           employees.add(new Employee(1006L, "Sarah", "Jones", LocalDate.of(2020, 6, 5), 98000.00, pensionPlan2, LocalDate.of(2023, 9, 21)));
           employees.add(new Employee(1007L, "Matthew", "Taylor", LocalDate.of(2018, 12, 15), 85000.00, pensionPlan1, LocalDate.of(2023, 1, 17)));
           employees.add(new Employee(1008L, "Emma", "Anderson", LocalDate.of(2019, 9, 3), 92000.00, pensionPlan2, LocalDate.of(2023, 9, 21)));
           employees.add(new Employee(1009L, "James", "Martinez", LocalDate.of(2017, 7, 22), 88000.00, null, null));
           employees.add(new Employee(1010L, "Olivia", "Garcia", LocalDate.of(2021, 2, 10), 100000.00, pensionPlan1, LocalDate.of(2023, 1, 17)));
           employees.add(new Employee(1011L, "Daniel", "Rodriguez", LocalDate.of(2019, 6, 1), 95000.00, pensionPlan2, LocalDate.of(2023, 9, 21)));
           employees.add(new Employee(1012L, "Sophia", "Hernandez", LocalDate.of(2019, 6, 18), 87000.00, null, null));
           employees.add(new Employee(1013L, "Benjamin", "Lopez", LocalDate.of(2016, 10, 5), 105000.00, pensionPlan1, LocalDate.of(2023, 1, 17)));
           employees.add(new Employee(1014L, "Mia", "Perez", LocalDate.of(2020, 7, 8), 94000.00, pensionPlan2, LocalDate.of(2023, 9, 21)));
           employees.add(new Employee(1015L, "William", "Lee", LocalDate.of(2017, 8, 12), 89000.00, pensionPlan1, LocalDate.of(2023, 1, 17)));

           counter++;
           System.out.println("DATA GENERATED SUCCESSFULLY!! :)");
           return true;
       }

        System.out.println("DATA ALREADY GENERATED!! :(");
       return false;
    }

}
