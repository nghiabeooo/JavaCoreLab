/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Greychan
 */
public class SearchHelper {

    public int linSearch(int[] a, int key) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
