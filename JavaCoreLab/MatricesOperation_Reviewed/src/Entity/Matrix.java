/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Greychan
 */
public class Matrix {

    private int row;
    private int column;
    private int[][] matrix;

    public Matrix() {
    }

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.matrix = new int[row][column];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getMatrixElement(int row, int column) {
        return this.matrix[row][column];
    }

    public void setMatrixElemet(int x, int row, int column) {
        this.matrix[row][column] = x;
    }

}
