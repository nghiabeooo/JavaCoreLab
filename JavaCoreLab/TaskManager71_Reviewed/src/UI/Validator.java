/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Greychan
 */
public class Validator {

    Scanner in = new Scanner(System.in);
    String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public boolean findTaskExist(ArrayList<Task> lt, int id) {
        if (lt.isEmpty()) {
            System.err.println("List empty");
            return false;
        }
        for (int i = 0; i < lt.size(); i++) {
            Task t = lt.get(i);
            if(t.getId() == id){
                return true;
            }
        }
        System.out.println("Not found.");
        return false;
    }

    public Task inputTask(int id) {
        System.out.print("Enter Requirement Name: ");
        String requirementName = checkInputString();
        System.out.print("Enter Task Type: ");
        String taskTypeId = checkInputTaskTypeId();
        System.out.print("Enter Date: ");
        String date = checkInputDate();
        System.out.print("Enter From: ");
        String planFrom = checkInputPlan();
        System.out.print("Enter To: ");
        String planTo = checkInputPlan();
        System.out.print("Enter Assignee: ");
        String assign = checkInputString();
        System.out.print("Enter Reviewer: ");
        String reviewer = checkInputString();
        Task t = new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer);

        return t;
    }

    public int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                }
            } catch (NumberFormatException | ParseException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public String checkInputTaskTypeId() {
        while (true) {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }

    public String checkInputPlan() {
        while (true) {
            String result = checkInputString();
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
                return result;
            } else {
                System.err.println("Re-input.");
            }
        }
    }
}
