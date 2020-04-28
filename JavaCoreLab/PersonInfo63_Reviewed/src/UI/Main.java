/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.PersonManagement;
import Entity.Person;
import java.util.ArrayList;

/**
 *
 * @author Greychan
 */
public class Main {

    public static void main(String[] args) throws Exception {
        PersonManagement m = new PersonManagement();
        InputHandler ih = new InputHandler();
        System.out.println("====Management Person programer====");
        for (int i = 0; i < 3; i++) {
            Person p = ih.inputPersonInfo();
            m.addPerson(p);
        }
        ArrayList<Person> people = m.sortBySalary();
        if (people.isEmpty()) {
            System.out.println("Can't sort person");
        }
        for (Person p : people) {
            ih.displayPersonInfo(p);
        }
    }
}
