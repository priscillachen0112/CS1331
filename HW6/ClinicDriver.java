import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class ClinicDriver {

    public static void main(String[] args) {
        Clinic clinic = new Clinic("Patients.csv");
        String dayOneReport = "";
        try {
            dayOneReport = clinic.nextDay("Appointments.csv");
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        String[] dayOneAppointments = dayOneReport.split("\\n");
        File fileOut = new File("PatientsTest.csv");
        for (String appointment : dayOneAppointments) {
            clinic.addToFile(appointment, fileOut);
            if (!clinic.addToFile(appointment, fileOut)) {
                System.out.println("Appointment could not be added to file!");
            }
        }
    }
}
