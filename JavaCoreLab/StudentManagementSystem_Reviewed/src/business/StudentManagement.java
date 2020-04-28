/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.ReportDetails;
import java.util.ArrayList;
import entity.Student;
import java.util.Iterator;

/**
 *
 * @author Greychan
 */
public class StudentManagement {

    private ArrayList sl;

    public StudentManagement() {
        this.sl = new ArrayList();
    }

    public boolean add(Student s) {
        for (int i = 0; i < sl.size(); i++) {
            Student sCheck = (Student) sl.get(i);
            if (s.getId().equalsIgnoreCase(sCheck.getId())) {
                return false;
            }
        }
        sl.add(s);
        return true;
    }

    public ArrayList find(String studName) {
        ArrayList<Student> result = new ArrayList<>();

        for (int i = 0; i < sl.size(); i++) {
            if (sl.get(i).toString().trim().toLowerCase().contains(studName)) {
                result.add((Student) sl.get(i));
            }
        }

        return result;

    }

    public boolean delete(String id) {
        for (int i = 0; i < sl.size(); i++) {
            Student s = (Student) sl.get(i);
            if (s.getId().equalsIgnoreCase(id)) {
                sl.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean update(Student newStudent) {

        for (Iterator it = sl.iterator(); it.hasNext();) {
            Student s = (Student) it.next();
            if (s.getId().equalsIgnoreCase(newStudent.getId())) {
                s.setName(newStudent.getName());
                s.setSemester(newStudent.getSemester());
                s.setCourseName(newStudent.getCourseName());
                return true;
            }
        }
        return false;
    }

    public ArrayList report() {
        ArrayList<ReportDetails> rdl = new ArrayList<>();
        if (sl.isEmpty()) {
            return null;
        }
        for (int i = 0; i < sl.size(); i++) {

            Student s = (Student) sl.get(i);
            ReportDetails rd = new ReportDetails();
            String id = s.getId();
            String courseName = s.getCourseName();
            String name = s.getName();
            int freq = 1;

            for (int j = 0; j < sl.size(); j++) {
                Student sCheck = (Student) sl.get(j);
                if ((!id.equalsIgnoreCase(sCheck.getId()))
                        && name.equalsIgnoreCase(sCheck.getName())
                        && courseName.equalsIgnoreCase(sCheck.getCourseName())) {
                    freq++;
                }
            }
            boolean rdExists = false;
            for (ReportDetails rdCheck : rdl) {
                if (name.equalsIgnoreCase(rdCheck.getName()) && courseName.equalsIgnoreCase(rdCheck.getCourse())) {
                    rdExists = true;
                }
            }
            if (rdExists == false) {
                rd.setName(name);
                rd.setCourse(courseName);
                rd.setCount(freq);
                rdl.add(rd);
            }
        }
        return rdl;
    }

}
