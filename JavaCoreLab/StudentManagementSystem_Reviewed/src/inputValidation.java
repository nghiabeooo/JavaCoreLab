
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
public class inputValidation {

    Scanner sc = new Scanner(System.in);

    public void printReport(ArrayList al) {
        if (al.isEmpty()) {
            System.out.println("No result!");
            return;
        }
        System.out.println("\n=======REPORT======\n");
        System.out.printf("%-20s%-15s%-15s\n", "Name", "Course Name", "Total");
        for(int i = 0; i < al.size(); i++){
            ReportDetails rd = (ReportDetails) al.get(i);
            System.out.println(rd.toString());
        }
    }

    public void succeededOrNot(boolean rs) {
        if (rs) {
            System.out.println("Succeeded!");
        } else {
            System.out.println("Failed!");
        }
    }

    public void printStudent(ArrayList al) {
        if (al.isEmpty()) {
            System.out.println("No result!");
            return;
        }
        Collections.sort(al, Collections.reverseOrder());
        System.out.printf("%-15s%-25s%-20s%-20s\n", "Student ID", "Student Name", "Semester", "Course Name");
        for (Iterator it = al.iterator(); it.hasNext();) {
            Student student = (Student) it.next();
            System.out.println(student.toString());
        }
    }

    public Student inputUpdateStudent(String id) {
        String name = this.inputString("Name? :");
        String semester = this.inputString("Semester? :");
        String course = this.inputCourse();

        Student upS = new Student(id, name, semester, course);
        return upS;
    }

    public Student inputStudent() {
        String id = this.inputString("Id? :");
        String name = this.inputString("Name? :");
        String semester = this.inputString("Semester? :");
        String course = this.inputCourse();

        Student s = new Student(id, name, semester, course);

        return s;
    }

    public int inputInIntRange(int a, int b) {
        sc = sc.reset();
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < a || result > b) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("In " + a + " to " + b);
                System.out.println("Enter again: ");
            }
        }
    }

    public String inputString(String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public boolean inputYN() {
        while (true) {
            String result = inputString("Y or N?");
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Only Y or N");
            System.out.println("Enter again: ");
        }
    }

    public String inputCourse() {
        while (true) {
            String result = inputString("Course Name?: ");
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("only java, .net or c/c++");
            System.out.println("Enter again:");
        }
    }
}
