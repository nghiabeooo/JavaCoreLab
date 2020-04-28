/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Entity.Person;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Greychan
 */
public class PersonManagement {

    private ArrayList<Person> personL;

    public PersonManagement() {
        this.personL = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personL;
    }

    public boolean addPerson(Person p) throws Exception {
        try {
            this.personL.add(p);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
//implement Comparable
    public ArrayList<Person> sortBySalary() throws Exception {
        try{
            Collections.sort(personL);
        }catch (Exception e){
            return personL;
        }
        return personL;
    }
}
