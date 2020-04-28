/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Entity.Matrix;

/**
 *
 * @author Greychan
 */
public class MatrixOperator {

    Matrix fMatrix;

    public Matrix additionMatrix(Matrix matrix1, Matrix matrix2) throws Exception{
        if(matrix1.getRow() != matrix2.getRow() && matrix1.getColumn() != matrix2.getColumn()){
            throw new Exception("Cant do that!");
        }
        int row = matrix1.getRow();
        int col = matrix1.getColumn();
        
        fMatrix = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                fMatrix.setMatrixElemet((matrix1.getMatrixElement(i, j) + matrix2.getMatrixElement(i, j)), i, j);
            }
        }
        return fMatrix;
    }

    public Matrix subtractionMatrix(Matrix matrix1, Matrix matrix2) {
        int row = matrix1.getRow();
        int col = matrix1.getColumn();
        fMatrix = new Matrix(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                fMatrix.setMatrixElemet((matrix1.getMatrixElement(i, j) - matrix2.getMatrixElement(i, j)), i, j);
            }
        }
        return fMatrix;
    }

    public Matrix multiplicationMatrix(Matrix matrix1, Matrix matrix2) {
        int row1 = matrix1.getRow();
        int col1 = matrix1.getColumn();
        int row2 = matrix2.getRow();
        int col2 = matrix2.getColumn();
        fMatrix = new Matrix(row1, col2);
        int[][] temp = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                temp[i][j] = 0;
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    temp[i][j] += matrix1.getMatrixElement(i, k) * matrix2.getMatrixElement(k, j);
                }
            }
        }
        fMatrix.setMatrix(temp);
        return fMatrix;
    }
}
