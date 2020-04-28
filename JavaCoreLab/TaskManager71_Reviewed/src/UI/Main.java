/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.TaskManagement;
import Entity.Task;
import java.util.ArrayList;
import static sun.misc.Version.print;

/**
 *
 * @author Greychan
 */
public class Main {

    public static void main(String[] args) {
        int id = 1;
        Displayer dis = new Displayer();
        Validator val = new Validator();
        TaskManagement m = new TaskManagement();
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = val.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    Task t = val.inputTask(id);
                    m.addTask(t, id);
                    id++;
                    break;
                case 2:
                    System.out.println("ID? ");
                    int delId = val.checkInputInt();
                    ArrayList<Task> lt = m.getLt();
                    if (val.findTaskExist(lt, delId)) {
                        m.deleteTask(delId);
                    }
                    break;
                case 3:
                    ArrayList<Task> lt3 = m.getLt();
                    dis.print(lt3);
                    break;
                case 4:
                    return;

            }
        }
    }
}
