// Importing required Packages and Modules
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayVersion {
    // Created and Intialized variables globally to access from any method
    private static final Scanner scanner = new Scanner(System.in); // Scanner intializing

    private static int studentCount = 0; // Initializing the student count

    private static String[] allStudentId = new String[100]; // Array for student id

    // --------------- MAIN METHOD -------------
    public static void main(String[] args) {
        // Printing Student Activity Management System
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+               Student Activity Management System                 +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Creating a variable to get the user choice
        int choice;

        // Running a infinite loop until break condition is met
        while (true){

            // Printing the menu to the user
            System.out.println("  1. Check available seats");
            System.out.println("  2. Register student (with ID)");
            System.out.println("  3. Delete student");
            System.out.println("  4. Find student (with student ID)");
            System.out.println("  5. Store student details into a file");
            System.out.println("  6. Load student details from the file to the system");
            System.out.println("  7. View the list of students based on their names");
            System.out.println("  0. Exit\n");

            // Handling the exceptions Ref : https://www.javatpoint.com/exception-handling-in-java
            try {
                // Getting for user choice
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Clearing scanner after INT

            }catch (InputMismatchException e){
                scanner.nextLine();// Clearing scanner after INT

                // Printing Invalid Input and asking user input again
                System.out.println("\n+------------------------------------------------------------------+");
                System.out.println("Invalid Input !!!");
                System.out.println("Enter numbers between 0 - 7 ! ");
                System.out.println("+------------------------------------------------------------------+\n");

                continue; // Re-running the loop

            }

            System.out.println(); // Printing an empty line

            // Handling the required method based on user choice
            switch (choice) {
                case 1: // If user inserted 1
                    checkAvailableSeats(); // Calling for checkAvailableSeats() method
                    break;
                case 2: // If user inserted 2
                    registerStudent(); // Calling for registerStudent() method
                    break;
                case 3: // If user inserted 3
                    deleteStudent(); // Calling for deleteStudent() method
                    break;
                case 4: // If user inserted 4
                    findStudent(); // Calling for findStudent() method
                    break;
                case 5: // If user inserted 5
                    storeStudentDetails(); // Calling for storeStudentDetails() method
                    break;
                case 6: // If user inserted 6
                    loadStudentDetails(); // Calling for loadStudentDetails() method
                    break;
                case 7: // If user inserted 7
                    viewStudentsByName(); // Calling for viewStudentsByName() method
                    break;
                case 0: // If user inserted 0
                    System.exit(0); // Using System exit code to exit from Java Application

                    // If none of the above condtions are met  (User entered something instead of 0 - 10
                default:
                    // Printing Invalid Input and asking user input again
                    System.out.println("\n+------------------------------------------------------------------+");
                    System.out.println("Invalid Input !!!");
                    System.out.println("Enter numbers between 0 - 7 ! ");
                    System.out.println("+------------------------------------------------------------------+\n");

            }
        }
    }

    // PRIVATE keyword is used in methods because we dont need to access outside from class
    // Creating method to check the number of available seats
    private static void checkAvailableSeats(){
        // Printing the Check Available Seats message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                     Check Available Seats                        +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Printing the seat count available
        // Calculated by subtracting the registered students by 100 (Total students)
        System.out.println("Number of Available Seats are : " + (100 - studentCount) + "\n");

        System.out.println("+------------------------------------------------------------------+\n");
    }

    // Creating method to register a new student
    private static void registerStudent(){
        // Printing the Register Students message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                      Register Students                           +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Checking wheather students exceed 100 because maxiumum is 100
        if (studentCount > 100){
            // Printing all seats are full
            System.out.println("Seats are not available all reserved !!! ");
        }

        else{
            // Else ask for student id to register new student
            System.out.print("Enter student ID to Register : "); // Getting the user input
            String id = scanner.nextLine();

            // Running while loop under isValid(id) method returns false
            // Refer to isValid(id) method for Logic
            while(!isValid(id)){
                // Printing to insert correct ID again
                System.out.println("Enter a valid ID like w1234567 again !!! \n");

                // Asking for ID input again from user
                System.out.print("Enter student ID to Register : ");
                id = scanner.nextLine();
            }

            // Access the student id array
            for (int i = 0; i < allStudentId.length; i++) {
                // Check wheather student id exist if exist show it exist and exit out of method
                if (allStudentId[i] != null && allStudentId[i].equals(id)) {
                    System.out.println("Student already exists !!! ");
                    System.out.println("+------------------------------------------------------------------+\n");
                    return; // exit from method
                }
            }

            // Access student id array and add student id to the first empty position
            for (int i = 0; i < allStudentId.length; i++) {
                if (allStudentId[i] == null) {
                    allStudentId[i] = id;
                    break;
                }
            }

            studentCount++; // Increasing student count by one

            // Printing student registered successfully
            System.out.println("Student registered successfully !!! ");

            System.out.println("+------------------------------------------------------------------+\n");
        }


    }

    // Creating method to delete a student
    private static void deleteStudent(){
        // Printing the Delete Students message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                        Delete Students                           +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Running while loop under isValid(id) method returns false
        // Refer to isValid(id) method for Logic
        System.out.print("Enter student ID to Delete : ");
        String id = scanner.nextLine();

        while(!isValid(id)){
            // Printing to insert correct ID again
            System.out.println("Enter a valid ID like w1234567 again !!! \n");

            // Asking for ID input again from user
            System.out.print("Enter student ID to Delete : ");
            id = scanner.nextLine();
        }

        // Creating a variable and assign it to false
        boolean deleted = false;

        // AAccess student id array
        for (int i = 0; i < allStudentId.length; i++) {
            // Check for student id wheather mathches with above student id
            if (allStudentId[i] != null && allStudentId[i].equals(id)){
                allStudentId[i] = null; // Assign the student name and id to null
                studentCount--; // Decrement student count

                // Printing student deleted successfully
                System.out.println("Student deleted successfully ! ");

                deleted = true;
            }
        }

        // If the variable is not true (false)
        if (!deleted){
            // Printing student is not available
            System.out.println("Student not available ! ");
        }

        System.out.println("+------------------------------------------------------------------+\n");
    }

    // Creating method to find the student
    private static void findStudent(){
        // Printing the Find Students message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                        Find Students                             +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Running while loop under isValid(id) method returns false
        // Refer to isValid(id) method for Logic
        System.out.print("Enter student ID to find : ");
        String id = scanner.nextLine();

        while(!isValid(id)){
            // Printing to insert correct ID again
            System.out.println("Enter a valid ID like w1234567 again !!! \n");

            // Asking for ID input again from user
            System.out.print("Enter student ID to find : ");
            id = scanner.nextLine();
        }

        // Creating a variable and assign it to false
        boolean found = false;

        // Accessing student id array
        for (int i = 0; i < allStudentId.length; i++) {
            // Check wheather student id matches with above id
            if (allStudentId[i] != null && allStudentId[i].equals(id)){
                // Print the details
                System.out.println("Student ID : " + allStudentId[i]);
                System.out.println("Seat  : " + (i + 1));

                found = true;
            }
        }

        // If the variable is not true (false)
        if (!found){
            // Printing student is not available
            System.out.println("Student not available ! ");
        }

        System.out.println("+------------------------------------------------------------------+\n");

    }

    // Creating method to store the student details in text file
    private static void storeStudentDetails(){
        // Exception handling
        try {

            // Ref : https://sentry.io/answers/read-file-java/
            // Checking wheather student count is zero
            if (studentCount == 0){
                // Printing no data is there to write
                System.out.println("No data to be written !!! \n");
            }

            else{
                // Opening file writer
                FileWriter fileWriter = new FileWriter("students-details.txt");

                // Accessing student id array
                for (int i = 0; i < allStudentId.length; i++) {
                    if (allStudentId[i] != null) {
                        // Writing the data of student id array to text file
                        fileWriter.write(allStudentId[i] + "\n");
                    }

                }

                // Printing that text file written completed
                System.out.println("Student details stored successfully !!! ");
                System.out.println("Text File Name : students-details.txt\n");

                fileWriter.close(); // Closing file writer

            }


        } catch (IOException e) { // In event of IO Exception Printing unable to write
            System.out.println("An error occurred while writing to the file.\n");
            e.printStackTrace();

        } catch (Exception e){
            System.out.println("An error occurred while writing to the file.\n");
            e.printStackTrace();
        }

        System.out.println("+------------------------------------------------------------------+\n");
    }

    // Creating method to load the student details in text file
    private static void loadStudentDetails(){
        // Opening the file reader
        // Ref : https://www.geeksforgeeks.org/java-program-to-write-into-a-file/
        try (BufferedReader reader = new BufferedReader(new FileReader("students-details.txt"))) {
            String line; // Using variable to capture line by line

            // Re-assign student count to zero
            studentCount = 0;
            allStudentId = new String[100];

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Spliting line to parts array using ,

                // Accessing student id array
                for (int i = 0; i < allStudentId.length; i++) {
                    // Adding the data in text file to first null position of array of students
                    if (allStudentId[i] == null){
                        allStudentId[i] = parts[0];
                        studentCount++; // Increasing student count

                        break; // Exit loop
                    }
                }
            }

            // Printing loaded successfully
            System.out.println("Student details loaded successfully.\n");


        } catch (IOException e) {  // In event of IO Exception Printing unable to read
            System.out.println("Error reading from file !!! ");
        } catch (Exception e){
            System.out.println("Error reading from file !!! ");
        }

        System.out.println("+------------------------------------------------------------------+\n");

    }

    // Creating method to view the student details sorted by name
    private static void viewStudentsByName(){
        // Printing the Sorted Students List message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                  Sorted Students List                            +");
        System.out.println("+------------------------------------------------------------------+\n");

        String[] allStudentIdCopy = new String[100];

        // Copyting the data from original array to Copy array
        for (int i = 0; i < allStudentIdCopy.length; i++) {
            allStudentIdCopy[i] = allStudentId[i];
        }

        // Ref : https://www.geeksforgeeks.org/bubble-sort-algorithm/
        // Bubble sort the data based on student id
        for (int i = 0; i < allStudentIdCopy.length - 1; i++) {
            for (int j = 0; j < allStudentIdCopy.length - 1 - i; j++) {
                if (allStudentIdCopy[j] != null && allStudentIdCopy[j + 1] != null && Integer.parseInt(allStudentIdCopy[j].substring(1)) > Integer.parseInt(allStudentIdCopy[j + 1].substring(1))) {
                    // Swapping the data
                    String temp = allStudentIdCopy[j];
                    allStudentIdCopy[j] = allStudentIdCopy[j + 1];
                    allStudentIdCopy[j + 1] = temp;
                }
            }
        }

        // Printing the sorted student id in new array
        for (int i = 0; i < allStudentIdCopy.length; i++) {
            if (allStudentId[i] != null) {
                System.out.println(" * Student ID : " + allStudentIdCopy[i]);
            }
        }

        System.out.println("+------------------------------------------------------------------+\n");
    }


    // Creating method to check wheather input is valid (Student ID)
    private static boolean isValid(String input) {
        // Check if the input is exactly 8 characters long
        if (input.length() != 8) {
            return false; // Returning false
        }

        // Check if the first character is 'w'
        if (input.charAt(0) != 'w') {
            return false; // Returning false
        }

        // Check if the remaining characters are digits
        for (int i = 1; i < 8; i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9') {
                return false; // Returning false
            }
        }

        // All checks passed, return true
        return true; // Returning true
    }
}
