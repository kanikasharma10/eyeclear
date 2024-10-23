package unitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AddPrescriptionTesting {

    @Test
    public void testAddPrescription_ValidInput() {
        // Create a valid Prescription object
        Prescription prescription = new Prescription(1, "Emily", "Thompson", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     -2.00f, 2.50f, 30f, new Date(), "Dr. Albert");
        
        // Test adding a valid prescription (should return true)
        assertTrue(prescription.addPrescription(), "Valid prescription should return true.");
    }

    @Test
    public void testAddPrescription_InvalidFirstName() {
        // First name is less than 4 characters
        Prescription prescription = new Prescription(1, "Tom", "Thompson", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     -2.00f, 2.50f, 30f, new Date(), "Dr. Albert");
        
        // Test adding an invalid prescription (should return false due to first name length)
        assertFalse(prescription.addPrescription(), "Prescription with an invalid first name should return false.");
    }

    @Test
    public void testAddPrescription_InvalidLastName() {
        // Last name is more than 15 characters
        Prescription prescription = new Prescription(1, "Emily", "Thompsonnnnnnnnnn", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     -2.00f, 2.50f, 30f, new Date(), "Dr. Albert");
        
        // Test adding an invalid prescription (should return false due to last name length)
        assertFalse(prescription.addPrescription(), "Prescription with an invalid last name should return false.");
    }

    @Test
    public void testAddPrescription_InvalidAddress() {
        // Address is less than 20 characters
        Prescription prescription = new Prescription(1, "Emily", "Thompson", 
                                                     "Short St, Sydney", 
                                                     -2.00f, 2.50f, 30f, new Date(), "Dr. Albert");
        
        // Test adding an invalid prescription (should return false due to short address)
        assertFalse(prescription.addPrescription(), "Prescription with a short address should return false.");
    }

    @Test
    public void testAddPrescription_InvalidSphereValue() {
        // Sphere value is out of range (-20.00 to +20.00)
        Prescription prescription = new Prescription(1, "Emily", "Thompson", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     -25.00f, 2.50f, 30f, new Date(), "Dr. Albert");
        
        // Test adding an invalid prescription (should return false due to sphere value)
        assertFalse(prescription.addPrescription(), "Prescription with an invalid sphere value should return false.");
    }

    @Test
    public void testAddPrescription_InvalidCylinderValue() {
        // Cylinder value is out of range (-4.00 to +4.00)
        Prescription prescription = new Prescription(1, "Emily", "Thompson", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     -2.00f, 5.00f, 30f, new Date(), "Dr. Albert");
        
        // Test adding an invalid prescription (should return false due to cylinder value)
        assertFalse(prescription.addPrescription(), "Prescription with an invalid cylinder value should return false.");
    }

    @Test
    public void testAddPrescription_InvalidAxisValue() {
        // Axis value is out of range (0 to 180)
        Prescription prescription = new Prescription(1, "Emily", "Thompson", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     -2.00f, 2.50f, 190f, new Date(), "Dr. Albert");
        
        // Test adding an invalid prescription (should return false due to axis value)
        assertFalse(prescription.addPrescription(), "Prescription with an invalid axis value should return false.");
    }

    @Test
    public void testAddPrescription_InvalidOptometristName() {
        // Optometrist name is less than 8 characters
        Prescription prescription = new Prescription(1, "Emily", "Thompson", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     -2.00f, 2.50f, 30f, new Date(), "Dr. Al");
        
        // Test adding an invalid prescription (should return false due to optometrist name length)
        assertFalse(prescription.addPrescription(), "Prescription with an invalid optometrist name should return false.");
    }
    @Test
    public void testAddPrescription_MinimumFirstNameLength() {
        // First name is exactly 4 characters (valid)
        Prescription prescription = new Prescription(1, "John", "Thompson", 
                                                     "123 Elm St, Melbourne, VIC 3000, Australia", 
                                                     -2.00f, 1.50f, 90f, new Date(), "Dr. Gregory");
        // Should return true as the first name is valid
        assertTrue(prescription.addPrescription(), "Prescription with a first name of 4 characters should return true.");
    }

    @Test
    public void testAddPrescription_MaximumFirstNameLength() {
        // First name is exactly 15 characters (valid)
        Prescription prescription = new Prescription(2, "Maximillian", "Smith", 
                                                     "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                     1.00f, -2.50f, 45f, new Date(), "Dr. Elizabeth");
        // Should return true as the first name is valid
        assertTrue(prescription.addPrescription(), "Prescription with a first name of 15 characters should return true.");
    }

    @Test
    public void testAddPrescription_ExactMinimumAddressLength() {
        // Address is exactly 20 characters (valid)
        Prescription prescription = new Prescription(3, "Emily", "Thompson", 
                                                     "12345 Elm St, Suburb", 
                                                     -2.00f, 2.50f, 30f, new Date(), "Dr. Alexander");
        // Should return true as the address is exactly 20 characters
        assertTrue(prescription.addPrescription(), "Prescription with address of 20 characters should return true.");
    }

    @Test
    public void testAddPrescription_MaximumSphereValue() {
        // Sphere value is exactly +20.00 (valid)
        Prescription prescription = new Prescription(4, "Sarah", "Johnson", 
                                                     "789 Birch Street, Brisbane, QLD 4000, Australia", 
                                                     20.00f, 0.00f, 120f, new Date(), "Dr. Anderson");
        // Should return true as the sphere value is valid
        assertTrue(prescription.addPrescription(), "Prescription with maximum sphere value (+20.00) should return true.");
    }

    @Test
    public void testAddPrescription_MinimumSphereValue() {
        // Sphere value is exactly -20.00 (valid)
        Prescription prescription = new Prescription(5, "Michael", "Brown", 
                                                     "12 Pine Road, Canberra, ACT 2601, Australia", 
                                                     -20.00f, -1.50f, 100f, new Date(), "Dr. Carter");
        // Should return true as the sphere value is valid
        assertTrue(prescription.addPrescription(), "Prescription with minimum sphere value (-20.00) should return true.");
    }

    @Test
    public void testAddPrescription_MaximumCylinderValue() {
        // Cylinder value is exactly +4.00 (valid)
        Prescription prescription = new Prescription(6, "Alice", "Williams", 
                                                     "987 Cedar Street, Perth, WA 6000, Australia", 
                                                     1.50f, 4.00f, 90f, new Date(), "Dr. Harrison");
        // Should return true as the cylinder value is valid
        assertTrue(prescription.addPrescription(), "Prescription with maximum cylinder value (+4.00) should return true.");
    }

    @Test
    public void testAddPrescription_MinimumCylinderValue() {
        // Cylinder value is exactly -4.00 (valid)
        Prescription prescription = new Prescription(7, "David", "Taylor", 
                                                     "321 Maple Lane, Hobart, TAS 7000, Australia", 
                                                     -3.50f, -4.00f, 60f, new Date(), "Dr. Robinson");
        // Should return true as the cylinder value is valid
        assertTrue(prescription.addPrescription(), "Prescription with minimum cylinder value (-4.00) should return true.");
    }

    @Test
    public void testAddPrescription_ExactMaximumAxisValue() {
        // Axis value is exactly 180 (valid)
        Prescription prescription = new Prescription(8, "Jessica", "Moore", 
                                                     "654 Walnut Road, Adelaide, SA 5000, Australia", 
                                                     -1.00f, 2.00f, 180f, new Date(), "Dr. Anderson");
        // Should return true as the axis value is valid
        assertTrue(prescription.addPrescription(), "Prescription with maximum axis value (180) should return true.");
    }

    @Test
    public void testAddPrescription_ExactMinimumAxisValue() {
        // Axis value is exactly 0 (valid)
        Prescription prescription = new Prescription(9, "George", "Harris", 
                                                     "123 Oak Street, Darwin, NT 0800, Australia", 
                                                     0.50f, 1.00f, 0f, new Date(), "Dr. Williams");
        // Should return true as the axis value is valid
        assertTrue(prescription.addPrescription(), "Prescription with minimum axis value (0) should return true.");
    }

    @Test
    public void testAddPrescription_ValidOptometristName_ExactMaxLength() {
        // Optometrist name is exactly 25 characters (valid)
        Prescription prescription = new Prescription(10, "Sophia", "Martin", 
                                                     "12 Elm Drive, Newcastle, NSW 2300, Australia", 
                                                     -0.50f, -1.25f, 85f, new Date(), "Dr. Benjamin Richardson");
        // Should return true as the optometrist name is exactly 25 characters
        assertTrue(prescription.addPrescription(), "Prescription with optometrist name of 25 characters should return true.");
    }

}
