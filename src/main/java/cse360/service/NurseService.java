package cse360.service;

import cse360.dao.UserDao;
import cse360.dao.NurseDao;
import cse360.model.Patient;

import java.sql.SQLException;

public class NurseService {

    private UserDao userDao;
    private NurseDao nurseDao;

    public NurseService(UserDao userDao, NurseDao nurseDao){
        this.userDao = userDao;
        this.nurseDao = nurseDao;
    }
    public void addPatientService(Patient patient) throws SQLException, ClassNotFoundException {
        //search user by email id
        //if user is not null than user already exists
        String user_id;
        if(userDao.getUserByEmailId(patient.getEmail()) != null){
            System.out.println("User already exists");
        }
        else{
            userDao.createUser(patient);
            user_id = userDao.getUserByEmailId(patient.getEmail()).getId();
            nurseDao.createPatient(patient, user_id);
        }

    }
}
