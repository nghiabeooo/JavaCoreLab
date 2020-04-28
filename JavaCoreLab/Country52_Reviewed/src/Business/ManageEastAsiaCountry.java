/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Entity.EastAsiaCountry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Greychan
 */
public class ManageEastAsiaCountry {

    private List<EastAsiaCountry> lc;

    public ManageEastAsiaCountry() {
        this.lc = new ArrayList<>();
    }

    public List<EastAsiaCountry> getLc() {
        return lc;
    }

    public boolean addCountryInformation(EastAsiaCountry newC) throws Exception {
        for (EastAsiaCountry c : lc) {
            if (c.getCountryCode().equalsIgnoreCase(newC.getCountryCode())) {
                return false;
            }
        }
        lc.add(newC);
        return true;
    }

    public EastAsiaCountry getRecentlyEnteredInformation() throws Exception {
        int index = lc.size() - 1;
        return lc.get(index);
    }

    public EastAsiaCountry[] searchInformationByName(String name) throws Exception {
        EastAsiaCountry[] l;
        int count = 0;
        for (EastAsiaCountry c : lc) {
            if (c.getCountryName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        System.out.println(Integer.toString(count));
        if (count == 0) {
            return null;
        }
        l = new EastAsiaCountry[count];
        int index = 0;
        for (EastAsiaCountry c : lc) {
            if (c.getCountryName().equalsIgnoreCase(name)) {
                l[index] = c;
                index++;
            }
        }
        return l;
    }

    public EastAsiaCountry[] sortInformationByAscendingOrder() throws Exception {
        ArrayList<EastAsiaCountry> cloneLc = new ArrayList<>();
        for(int i = 0; i < lc.size(); i++){
            cloneLc.add(lc.get(i));
        }
        EastAsiaCountry[] l = new EastAsiaCountry[cloneLc.size()];

        Collections.sort(cloneLc, Collections.reverseOrder());
        cloneLc.toArray(l);
        return l;
    }
}
