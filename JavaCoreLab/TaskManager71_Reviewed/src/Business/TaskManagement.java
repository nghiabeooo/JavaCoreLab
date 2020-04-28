/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Entity.Task;
import java.util.ArrayList;

/**
 *
 * @author Greychan
 */
public class TaskManagement {

    private ArrayList<Task> lt;

    public TaskManagement() {
        this.lt = new ArrayList<>();
    }

    public ArrayList<Task> getLt() {
        return lt;
    }

    public void addTask(Task t, int id) {
        lt.add(t);
    }

    public void deleteTask(int id) {
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                lt.remove(i);
            }
        }
    }

}
