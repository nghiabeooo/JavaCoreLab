
import business.StudentManagement;
import entity.ReportDetails;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Greychan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        inputValidation val = new inputValidation();
        Student s1 = new Student("001", "Nguyen Trong Minh", "Fall2020", "Java");
        Student s2 = new Student("002", "Do Trung Nghia", "Spring2020", "Java");
        Student s3 = new Student("003", "Do Van Cau", "Spring2020", "Java");
        Student s4 = new Student("004", "Do Trong Minh", "Spring2020", "Java");
        Student s5 = new Student("005", "Nguyen Trong Minh", "Spring2020", "Java");
        sm.add(s1);
        sm.add(s2);
        sm.add(s3);
        sm.add(s4);
        sm.add(s5);
        while (true) {
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            System.out.println("    Enter your choice: ");
            int choice = val.inputInIntRange(1, 5);
            switch (choice) {
                case 1:
                    Student s = val.inputStudent();
                    sm.add(s);
                    break;
                case 2:
                    String fName = val.inputString("Enter name to find: ");
                    ArrayList rs = sm.find(fName);
                    val.printStudent(rs);
                    break;
                case 3:
                    String fId = val.inputString("Enter a ID: ");
                    while (true) {
                        String option = val.inputString("Update or Delete? ");
                        if (option.equalsIgnoreCase("D")) {
                            val.succeededOrNot(sm.delete(fId));
                            break;
                        }
                        if (option.equalsIgnoreCase("U")) {
                            Student upS = val.inputUpdateStudent(fId);
                            val.succeededOrNot(sm.update(upS));
                            break;
                        }
                    }
                    break;
                case 4:
                    ArrayList<ReportDetails> reportDetailsList = sm.report();
                    val.printReport(reportDetailsList);
                    break;
                case 5:
                    return;
            }
        }
        // TODO code application logic here
    }

}
