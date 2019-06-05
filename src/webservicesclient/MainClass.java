package webservicesclient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String result = Methods.sendGet("http://localhost:8084/WebServicesRest/api/webservices/getStudentById?studentId=2");
            System.out.println("Result: " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
