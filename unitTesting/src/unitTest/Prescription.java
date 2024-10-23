package unitTest;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String optometrist;
    //private String[] 
   //remarkTypes = { "Client", "Optometrist" };
    private ArrayList<String> postRemarks = new ArrayList<>();
    
    // Constructor
    public Prescription(int prescID, String firstName, String lastName, String address, float sphere, float cylinder, float axis, Date examinationDate, String optometrist) {
        this.prescID = prescID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    // Add Prescription to a file
    public boolean addPrescription() {
        // Condition 1: First Name and Last Name length
        if (firstName.length() < 4 || firstName.length() > 15 || lastName.length() < 4 || lastName.length() > 15) {
            return false;
        }

        // Condition 2: Address length
        if (address.length() < 20) {
            return false;
        }

        // Condition 3: Sphere, Cylinder, Axis validation
        if (sphere < -20.00 || sphere > 20.00 || cylinder < -4.00 || cylinder > 4.00 || axis < 0 || axis > 180) {
            return false;
        }

        // Condition 4: Validate date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        String examDateStr = sdf.format(examinationDate);

        // Condition 5: Optometrist name length
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            return false;
        }

        // Save the prescription details to a TXT file
        try (FileWriter writer = new FileWriter("presc.txt", true)) {
            writer.write(prescID + ", " + firstName + " " + lastName + ", " + address + ", " + sphere + ", " + cylinder + ", " + axis + ", " + examDateStr + ", " + optometrist + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

    // Add Remark to a file
    public boolean addRemark(String remark, String category) {
        // Condition 1: Validate remark length (6 to 20 words) and capitalization of first word
        String[] words = remark.split(" ");
        if (words.length < 6 || words.length > 20 || !Character.isUpperCase(words[0].charAt(0))) {
            return false;
        }

        // Condition 2: Validate category and number of remarks
        if (!category.equalsIgnoreCase("client") && !category.equalsIgnoreCase("optometrist")) {
            return false;
        }
        if (postRemarks.size() >= 2) {
            return false;
        }

        // Save the remark to the file and add it to the list of remarks
        try (FileWriter writer = new FileWriter("remark.txt", true)) {
            writer.write("Prescription ID: " + prescID + ", Category: " + category + ", Remark: " + remark + "\n");
            postRemarks.add(remark);  // Track the added remark
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }
}