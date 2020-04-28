/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.MatrixOperator;
import Entity.Matrix;

/**
 *
 * @author Greychan
 */
public class Main {

    public static void main(String[] args) throws Exception {
        MatrixOperator mo = new MatrixOperator();
        Displayer dis = new Displayer();
        Validator val = new Validator();
        Matrix matrix1 = val.inputMatrix();
        Matrix matrix2 = val.inputMatrix();
        while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = val.inputIntInRange(1, 4, "Enter your choice: ");
            switch (choice) {
                case 1:
                    Matrix temp = mo.additionMatrix(matrix1, matrix2);
                    dis.displayMatrix(temp);
                    break;
                case 2:
                    Matrix temp1 = mo.subtractionMatrix(matrix1, matrix2);
                    dis.displayMatrix(temp1);
                    break;
                case 3:
                    Matrix temp2 = mo.multiplicationMatrix(matrix1, matrix2);
                    dis.displayMatrix(temp2);
                    break;
                case 4:
                    return;
            }
        }
    }
}
