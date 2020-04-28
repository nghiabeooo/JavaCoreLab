/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.Matrix;

/**
 *
 * @author Greychan
 */
public class Displayer {

    public void displayMatrix(Matrix matrix) {
        int row = matrix.getRow();
        int col = matrix.getColumn();
        int[][] temp = matrix.getMatrix();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + temp[i][j] + "]");
            }
            System.out.println();
        }
    }
}
