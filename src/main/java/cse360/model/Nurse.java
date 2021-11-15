package cse360.model;

import java.util.ArrayList;
import java.util.List;

public class Nurse extends User{

    private List<Patient> patientList;

    public Nurse(String id, String firstName, String lastName, String DOB, String email, String phoneNumber, String password) {
        super(id, firstName, lastName, DOB, email, phoneNumber, password);
        this.patientList = new ArrayList<>();
        this.setType("2");
    }
}
