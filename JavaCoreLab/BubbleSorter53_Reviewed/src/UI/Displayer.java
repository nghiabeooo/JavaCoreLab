/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Greychan
 */
public class Displayer {

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print("[" + a[i] + "]");
                break;
            }
            System.out.print("[" + a[i] + "] -");
        }
        System.out.println();
    }
}
