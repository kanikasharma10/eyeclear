package unitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AddRemarkTesting {

    @Test
    public void testAddRemark_ExceedingWordLimit() {
        // Initialize a Prescription object for testing
        Prescription prescription1 = new Prescription(1, "Emily", "Thompson", "456 Oak Avenue, Sydney, NSW 5678, Australia", 
                                                       -2.00f, 2.50f, 30f, new Date(), "Dr. Albert");

        // Attempt to add a remark exceeding the 20-word limit (should fail)
        assertFalse(prescription1.addRemark("This is a long remark that exceeds the twenty-word limit for remarks in the system, so it should not be accepted.", "Optometrist"), 
                    "A remark with more than 20 words should return false.");

        // Create a second Prescription object for testing
        Prescription prescription2 = new Prescription(2, "Tommy", "Nelson", "123 Pine Street, Melbourne, VIC 4321, Australia", 
                                                       0.00f, -3.00f, 60f, new Date(), "Dr. Gregory");

        // Attempt to add a remark with exactly 20 words (should succeed)
        assertTrue(prescription2.addRemark("The optometrist has recommended a new prescription and suggests the client to come for a follow-up session in six months.", "Optometrist"), 
                   "A remark with exactly 20 words should return true.");
    }

    @Test
    public void testAddRemark_RemarkWithUpperLimitWordCount() {
        // Add a valid remark with exactly 20 words
        Prescription prescription = new Prescription(3, "Anna", "Williams", 
                                                     "123 Maple Street, Perth, WA 6000, Australia", 
                                                     0.75f, -2.00f, 90f, new Date(), "Dr. Baker");

        String validRemark = "The client has experienced discomfort with the new prescription and recommended a revision after one month.";
        assertTrue(prescription.addRemark(validRemark, "optometrist"), 
                   "Remark with exactly 20 words should return true.");
    }

    @Test
    public void testAddRemark_RemarkWithTooFewWords() {
        // Remark has less than 6 words (invalid)
        Prescription prescription = new Prescription(4, "Grace", "Harris", 
                                                     "456 Elm Road, Adelaide, SA 5000, Australia", 
                                                     1.50f, -1.75f, 135f, new Date(), "Dr. Samuels");

        assertFalse(prescription.addRemark("This remark is invalid.", "client"), 
                    "Remark with fewer than 6 words should return false.");
    }

    @Test
    public void testAddRemark_RemarkWithTooManyWords() {
        // Remark has more than 20 words (invalid)
        Prescription prescription = new Prescription(5, "George", "Brown", 
                                                     "987 Cedar Street, Brisbane, QLD 4000, Australia", 
                                                     -0.50f, 0.50f, 120f, new Date(), "Dr. Anderson");

        String longRemark = "This remark is much too long and exceeds the limit of twenty words that is allowed by the system for any remark.";
        assertFalse(prescription.addRemark(longRemark, "client"), 
                    "Remark with more than 20 words should return false.");
    }

    @Test
    public void testAddRemark_RemarkWithoutCapitalization() {
        // Remark does not start with a capital letter (invalid)
        Prescription prescription = new Prescription(6, "Michael", "Davis", 
                                                     "654 Pine Street, Canberra, ACT 2601, Australia", 
                                                     2.00f, 1.00f, 150f, new Date(), "Dr. Parker");

        assertFalse(prescription.addRemark("this remark starts with a lowercase letter.", "client"), 
                    "Remark without capitalization should return false.");
    }

    @Test
    public void testAddRemark_InvalidCategory() {
        // Invalid category (neither "client" nor "optometrist")
        Prescription prescription = new Prescription(7, "Olivia", "Martinez", 
                                                     "321 Walnut Avenue, Darwin, NT 0800, Australia", 
                                                     -3.00f, -1.50f, 30f, new Date(), "Dr. Wilson");

        assertFalse(prescription.addRemark("Valid remark but invalid category.", "admin"), 
                    "Remark with an invalid category should return false.");
    }

    @Test
    public void testAddRemark_AddMoreThanTwoRemarks() {
        // Adding more than two remarks (invalid)
        Prescription prescription = new Prescription(8, "Liam", "Jones", 
                                                     "567 Birch Lane, Hobart, TAS 7000, Australia", 
                                                     1.25f, -0.50f, 60f, new Date(), "Dr. Hughes");

        // Add the first valid remark
        assertTrue(prescription.addRemark("This is the first valid remark.", "client"));
        // Add the second valid remark
        assertTrue(prescription.addRemark("This is the second valid remark.", "optometrist"));
        // Attempt to add a third remark (should fail)
        assertFalse(prescription.addRemark("This is a third remark.", "client"), 
                    "Adding more than two remarks should return false.");
    }


    @Test
    public void testAddRemark_BlankRemark() {
        // Blank remark (invalid)
        Prescription prescription = new Prescription(10, "James", "Martinez", 
                                                     "123 Oak Drive, Sydney, NSW 2000, Australia", 
                                                     1.00f, -0.75f, 75f, new Date(), "Dr. White");

        assertFalse(prescription.addRemark("", "client"), 
                    "Blank remark should return false.");
}
}
