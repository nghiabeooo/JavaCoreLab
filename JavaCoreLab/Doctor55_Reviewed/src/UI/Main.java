/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.DoctorManagement;
import Entity.Doctor;
import java.util.ArrayList;

/**
 *
 * @author Greychan
 */
public class Main {

    public static void main(String[] args) throws Exception {
        InputHandler ih = new InputHandler();
        DoctorManagement m = new DoctorManagement();

        while (true) {
            ih.displayMenu();
            int choice = ih.inputIntInRange(1, 5, "Enter your choice: ");
            switch (choice) {
                case 1:
                    if (m.addDoctor(ih.inputDoc())){
                        System.out.println("Successfully");
                        break;
                    }
                    System.out.println("Something went wrong");
                    break;
                case 2:
                    String code = ih.inputString("Code? ");
                    if (m.updateDoctor(ih.inputDocInfo(code))){
                        System.out.println("Successfully");
                        break;
                    }
                    System.out.println("Something went wrong");
                    break;
                case 3:
                    if(m.deleteDoctor(ih.inputDocInfo(ih.inputString("Code? ")))){
                        System.out.println("Successfully");
                        break;
                    }
                    System.out.println("Something went wrong");
                    break;
                case 4:
                    ArrayList<Doctor> result = m.searchDoctor(ih.inputString("Code? "));
                    for(Doctor doc: result){
                        System.out.printf("\n%-20s%-20s%-20s%-20d", doc.getCode(), doc.getName(), doc.getSpecialization(), doc.getAvailability());
                    }
                    break;
                case 5:
                    return;
            }
        }
    }
}
