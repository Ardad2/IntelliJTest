package cse360.model;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User{
    private List<Patient> patientList;

    public Doctor(String id, String firstName, String lastName, String DOB, String email, String phoneNumber, String password) {
        super(id, firstName, lastName, DOB, email, phoneNumber, password);
        this.patientList = new ArrayList<>();
        this.setType("1");
    }
}
