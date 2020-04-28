/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.Matrix;
import java.util.Scanner;

/**
 *
 * @author Greychan
 */
public class Validator {

    Scanner sc = new Scanner(System.in);

    public int inputInt(String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            Integer result = Integer.parseInt(sc.nextLine().trim());
            if (result < 0) {
                System.err.println("Bigger or equal 0");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public int inputIntInRange(int a, int b, String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
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

    public Matrix inputMatrix() {
        int row = this.inputInt("Enter the number of row: ");
        int col = this.inputInt("Enter the number of column: ");
        Matrix m = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                String question = "Enter Matrix Element[" + i + "]" + "[" + j + "]:";
                m.setMatrixElemet(this.inputInt(question), i, j);
            }
        }
        return m;
    }

}
