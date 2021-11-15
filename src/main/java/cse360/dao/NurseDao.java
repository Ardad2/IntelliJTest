package cse360.dao;

import cse360.model.Patient;
import cse360.util.MySQLConnectionUtil;
import cse360.util.RandomNumberUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NurseDao {


    public void createPatient(Patient patient, String user_id) throws SQLException, ClassNotFoundException {

        Connection connection = MySQLConnectionUtil.getConnection();
        String insertQuery = "INSERT INTO PATIENT (id,insurance,pharmacy,user_id,doctor_id,nurse_id) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareCall(insertQuery);
        preparedStatement.setString(1, RandomNumberUtil.getRandomNumber());
        preparedStatement.setString(2,patient.getInsurance());
        preparedStatement.setString(3,patient.getPharmacy());
        preparedStatement.setString(4,user_id);
        preparedStatement.setString(5,patient.getDoctorId());
        preparedStatement.setString(6,patient.getNurseId()  );

        long update = preparedStatement.executeLargeUpdate();
        if(update>0){
            System.out.println("Patient Created success fully");
        }
    }
}
