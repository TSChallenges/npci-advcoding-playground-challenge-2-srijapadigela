import java.util.Queue;
import java.util.LinkedList;   // LinkedList also implements Queue
import java.util.Set;
import java.util.HashSet;

class Clinic {

    private Queue<Patient> patientQueue;
    private Set<Patient> admittedPatients;
    private int dayCount;

    // Constructor to initialize the clinic with a queue and a set of admitted patients
    public Clinic() {
        this.patientQueue = new LinkedList<>();       // no patient in queue yet
        this.admittedPatients = new HashSet<>();      // no patient admitted yet
        this.dayCount = 1;    // Start with Day 1
    }

    // Admit a patient to the clinic
    public void admitPatient(Patient patient) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Patient " + patient.getName() + " is already admitted.");
        } else {
            patientQueue.add(patient);
            System.out.println("Patient " + patient.getName() + " admitted.");
        }
    }

    // Schedule appointments (maximum 3 patients per day)
    public void getSchedule() {
        int patientsScheduled = 0;
        while (!patientQueue.isEmpty() && patientsScheduled < 3) {
            Patient patient = patientQueue.poll();
            patient.setAppointmentDay(dayCount);
            admittedPatients.add(patient);
            System.out.println("Scheduled " + patient.getName() + " on Day " + dayCount);
            patientsScheduled++;
        }
        if (patientsScheduled == 3) {
            dayCount++;
        }
    }

    // Provide treatment or prescription for a patient after their appointment
    public void providedTreatment(Patient patient, String treatment) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Treatment provided to " + patient.getName() + ": " + treatment);
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    // Get the details of a patient
    public void getPatientDetails(Patient patient) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Patient Details: " + patient);
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    // Get the appointment details of a patient
    public void getAppointmentDetails(Patient patient) {
        if (admittedPatients.contains(patient)) {
            System.out.println("Appointment Details: " + patient.getName() + " is scheduled on Day " + patient.getAppointmentDay());
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }

    // Discharge a patient from the clinic
    public void dischargePatient(Patient patient) {
        if (admittedPatients.remove(patient)) {
            System.out.println("Patient " + patient.getName() + " discharged.");
        } else {
            System.out.println("Patient not found in the admitted list.");
        }
    }
}
