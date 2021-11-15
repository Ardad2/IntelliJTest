package cse360.model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User{
    private String insurance;
    private String pharmacy;
    private List<Visit> visitList;
    private String doctorId;
    private String nurseId;




    public Patient(String id, String firstName, String lastName,
                   String DOB, String email, String phoneNumber, String password, String insurance,
                   String pharmacy, String doctorId,
                   String nurseId) {
        super(id, firstName, lastName, DOB, email, phoneNumber, password);
        this.insurance = insurance;
        this.pharmacy = pharmacy;
        this.visitList = new ArrayList<>();
        this.doctorId = doctorId;
        this.nurseId = nurseId;
        this.setType("3");
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(String pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }
}
