// The aim of this mini project in Hospital Management System in Java is to
// design and develop a comprehensive system that can help Hospital doctors ,
// patients manage various aspects of hospital operations such as patient
// registration, Patient Discharge The system should be user-friendly,
// reliable, secure, and efficient in order to improve the overall quality of
// healthcare services provided to patients


// Program:-
import java.util.*;
import java.time.*;
import java.time.format.*;
class Doctor{
    static ArrayList<Doctor> doctorList = new ArrayList<>();
    String doctorName, specilization , qualification , gender;
    int age;
    long phNo;

    Doctor(){
        // Empty constuctor
    }

    Doctor(String doctorName , int age , String gender , long phNo , String specilization , String qualification){
    this.doctorName = doctorName;
    this.age = age;
    this.gender=gender;
    this.phNo = phNo;
    this.specilization = specilization;
    this.qualification= qualification;
    }
    String getDoctorName() {
    return doctorName;
    }
    int getAge() {
    return age;
    }
    String getGender() {
    return gender;
    }
    long getPhone() {
    return phNo;
    }
    String getSpecilization(){
    return specilization;
    }
    String getQualification(){
    return qualification;
    }   
    static void addOldDoctors() {
        Doctor[] d = new Doctor[4];
        d[0] = new Doctor("Dr.Krishna", 25, "Male", 638061697,"Surgeon", "MBBS");
        d[1] = new Doctor("Dr.Raj", 30, "Male", 987452127,"Therapist", "MBBS,MD");
        d[2] = new Doctor("Dr.Kumar", 33, "Male", 789451233, "Artho","MBBS,MS");
        d[3] = new Doctor("Dr.Vignesh", 30, "Male", 965874211, "ENT","BDM");

        for (int i = 0; i < d.length; i++) {
                doctorList.add(d[i]);
        }
    }
    static void displayDoctors() {
        int i = 1;
        for (Doctor doctor : doctorList) {
        System.out.println("--- Doctor Number " + (i++) + " ---");
        System.out.println("Name : " + doctor.getDoctorName());
        System.out.println("Age : " + doctor.getAge());
        System.out.println("gender : " + doctor.getGender());
        System.out.println("specilization : " + doctor.getSpecilization());
        System.out.println("Qualification : " +
        doctor.getQualification());
        System.out.println("Phone number : " + doctor.getPhone());  
        System.out.println("--------------------------------------------");
        }
    }
    static void addDoctors() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Doctor name : ");
    String name = sc.nextLine();
    System.out.print("Enter Doctor age : ");
    int age = sc.nextInt();
    System.out.print("Enter Doctor Gender : ");
    sc.nextLine();
    String gender = sc.nextLine();
    System.out.print("Enter Doctor specilization : ");
    String spec = sc.nextLine();
    System.out.print("Enter Doctor Qualification : ");
    String qualify = sc.next();
    sc.nextLine();
    System.out.print("Enter Phone no : ");
    long phNo = sc.nextLong();
    Doctor d = new Doctor(name, age, gender, phNo, spec, qualify);
    doctorList.add(d);
    }
}   



class Patient extends Doctor{
    static ArrayList<Patient> patientList = new ArrayList<>();
    private String patientName, address , dateTime , gender , disease;
    private int age, roomNo;
    private long phNo;
    Patient(){
        System.out.println("");
    }
    Patient(String patientName, int age, String disease,String gender,String address, long phNo, String dateTime, int roomNo) {
        this.patientName = patientName;
        this.age = age;
        this.disease = disease;
        this.gender = gender;
        this.address = address;
        this.phNo = phNo;
        this.dateTime = dateTime;
        this.roomNo = roomNo;
    }
    String getDoctorName() {
        return patientName;
    }
    int getAge() {
        return age;
    }
    int getRoomno() {
        return roomNo;
    }
    String getGender() {
        return gender;
    }
    String getAddress() {
        return address;
    }
    long getPhone() {
        return phNo;
    }
    String getDateTime() {
        return dateTime;
    }
    String getDisease(){
        return disease;
    }
    static void addOldPatient() {
        Patient[] p = new Patient[5];
        p[0] = new Patient("jai", 13, "cancer", "male", "madurai",635214545, "2023-04-13 12:33:45", 96);
        p[1] = new Patient("kabilan", 14, "covid", "male", "melur",935465446, "2023-04-14 04:53:15", 97);
        p[2] = new Patient("abzar", 18, "dengu", "male", "theni",785214545, "2023-04-15 05:39:45", 98);
        p[3] = new Patient("nirmal", 19, "cancer", "male", "madurai",820441454, "2023-04-16 07:23:45", 99);
        p[4] = new Patient("gaja", 20, "maleria", "male", "madurai",96521454, "2023-04-17 06:30:48", 100);
        for (int i = 0; i < 5; i++) {
            patientList.add(p[i]);
        }
    }
    static void addPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patient name : ");
        String patientName = sc.nextLine();
        System.out.print("Enter patient age : ");
        int age = sc.nextInt();
        System.out.print("Enter Disease : ");
        sc.nextLine();
        String disease = sc.nextLine();
        System.out.print("Enter patient gender : ");
        String gender = sc.nextLine();
        System.out.print("Enter patient address : ");
        String address = sc.nextLine();
        System.out.print("Enter Phone no : ");
        long phNo = sc.nextLong();
        System.out.print("Enter Room Number : ");
        int roomNo = sc.nextInt();
//For date and Time 
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = currentDateTime.format(formatter);
// current date and time added
        Patient patient = new Patient(patientName, age, disease, gender,address, phNo, dateTime, roomNo);
        patientList.add(patient);
        System.out.println("---PATIENT ADMITED---");
    }
    static boolean dischargePatient() {
        if(patientList.isEmpty())
        System.out.println("No Patients in the hospital to discharge");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter room number of the Patient : ");
        int no = sc.nextInt();
        for (Patient patient : patientList) {
            if (patient.getRoomno() == no) {
                patientList.remove(patient);
                return true;
            }
        }
        return false;
    }
    static void displayPatientDetails() {
     if(patientList.isEmpty())
     System.out.println("Patients List is empty");
     int i = 1;
    for (Patient patient : patientList) {
        System.out.println("--- Patient Number " + (i++) + " ---");
        disp(patient);
        }   
    }
    static void searchPatient() {
        boolean b = false;
        if(patientList.isEmpty())
            System.out.println("Patients List is empty");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patient name : ");
        String name = sc.nextLine();
        for (Patient patient : patientList) {
            if (name.equalsIgnoreCase(patient.getDoctorName())) {
                b=true;
                disp(patient);
            }
        }
        if(b==false){
            System.out.println("Patient "+name+" is not found");
        }
    }
    static void disp(Patient patient) {
        System.out.println("Room Number : " + patient.getRoomno());
        System.out.println("Name: " + patient.getDoctorName());
        System.out.println("Age: " + patient.getAge());
        System.out.println("Disease : "+patient.getDisease());
        System.out.println("Gender: " + patient.getGender());
        System.out.println("Address: " + patient.getAddress());
        System.out.println("Phone: " + patient.getPhone());
        System.out.println("Admited date and time : " +patient.getDateTime());
        System.out.println("----------------------------------------");
    }
}


public class HospitalManagementSystem extends Patient{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, opt;
        addOldPatient();
        addOldDoctors();
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" ****************** **SIT HOSPITAL****************** ");
        System.out.println("\n-------------------------------------------------------------");
        while (true) {
            System.out.println("1.Doctors");
            System.out.println("2.Patients");
            System.out.println("3.Exit");
            System.out.print("Enter the option : ");
            int opt1 = sc.nextInt();
            switch (opt1) {
            case 1:
                    do {
                        System.out.println("1. Add Doctors");
                        System.out.println("2. Doctors list");
                        System.out.println("3. Exit to Main menu");
                        System.out.print("Enter the option : ");
                        ch = sc.nextInt();
                        switch (ch) {
                        case 1:
                                addDoctors();
                                break;
                        case 2:
                                displayDoctors();
                                break;
                        }
                    } while (ch != 3);
                    break;
            case 2:
                    do {
                        System.out.println("1 . Admit Patient");
                        System.out.println("2 . Discharge patient");
                        System.out.println("3 . Patients Record");
                        System.out.println("4 . Search a Patient By Name");
                        System.out.println("5 . Exit to Main menu");
                        System.out.print("Enter the option : ");
                        opt = sc.nextInt();
                        switch (opt) {
                        case 1:
                                addPatient();
                                break;
                        case 2:
                                if (dischargePatient()) {
                                    System.out.println("Patient dischargedsuccessfully");
                                } 
                                else {
                                    System.out.println("Patient not discharged ,please enter correct details");
                                }
                                break;
                        case 3:
                                displayPatientDetails();
                                break;
                        case 4:
                                searchPatient();
                                break;
                        }
                    } while (opt != 5);
                    break;
            case 3:
                    System.out.print("Thank You !");
                    System.exit(0);
            }
        }
    }
}