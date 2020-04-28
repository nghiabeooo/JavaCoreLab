/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Greychan
 */
public class Student implements Comparable {

    private String id;
    private String name;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-25s%-20s%-20s\n", this.id, this.name, this.semester, this.courseName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Object obj){
        Student s = (Student) obj;
        return s.getName().compareTo(this.getName());
    }

}
