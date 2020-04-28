/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Entity.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Greychan
 */
public class DoctorManagement {

    List<Doctor> dl;

    public DoctorManagement() {
        this.dl = new ArrayList<>();
    }

    public boolean addDoctor(Doctor d) throws Exception {
        for (Doctor doc : dl) {
            if (doc.getCode().equalsIgnoreCase(d.getCode())) {
                return false;
            }
        }
        dl.add(d);
        return true;
    }

    public boolean updateDoctor(Doctor d) throws Exception {
        if (d.getName().length() == 0 || d.getAvailability() < 0 || d.getSpecialization().length() == 0) {
            return false;
        }
        for (Doctor doc : dl) {
            if (doc.getCode().equalsIgnoreCase(d.getCode())) {
                doc.setName(d.getName());
                doc.setAvailability(d.getAvailability());
                doc.setSpecialization(d.getSpecialization());
                return true;
            }
        }
        return false;
    }

    public boolean deleteDoctor(Doctor d) throws Exception {
        String index = null;
        for (int i = 0; i < dl.size(); i++) {
            if (dl.get(i).getCode().equalsIgnoreCase(d.getCode())) {
                index = Integer.toString(i);
            }
        }
        if (index.isEmpty()) {
            return false;
        }
        dl.remove(index);
        return true;
    }

    public ArrayList<Doctor> searchDoctor(String input) throws Exception {
        ArrayList<Doctor> result = new ArrayList<>();
        for (Doctor doc : dl) {
            if (doc.toString() != null && doc.toString().trim().contains(input)) {
                result.add(doc);
            }
        }
        if (result.isEmpty()) {
            return null;
        }
        return result;
    }
}
