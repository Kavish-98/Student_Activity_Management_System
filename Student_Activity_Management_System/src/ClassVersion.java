// Importing required Packages and Modules
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClassVersion {
    // Created and Intialized variables globally to access from any method
    private static final Scanner scanner = new Scanner(System.in); // Scanner intializing

    private static int studentCount = 0; // Initializing the student count

    private static Student[] students = new Student[100]; // Intializing array of students

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
            System.out.println("  8. See more options");
            System.out.println("  0. Exit\n");

            // Handling the exceptions
            // Ref : https://www.javatpoint.com/exception-handling-in-java
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
                System.out.println("Enter numbers between 0 - 8 ! ");
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
                case 8: // If user inserted 8
                    seeMoreOptions(); // Calling for seeMoreOptions() method
                    break;
                case 0: // If user inserted 0
                    System.exit(0); // Using System exit code to exit from Java Application

                    // If none of the above condtions are met  (User entered something instead of 0 - 8
                default:
                    // Printing Invalid Input and asking user input again
                    System.out.println("\n+------------------------------------------------------------------+");
                    System.out.println("Invalid Input !!!");
                    System.out.println("Enter numbers between 0 - 8 ! ");
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

            // Accessing the array of students
            for (int i = 0; i < 100; i++) {
                // Comparing wheather student matches student id user inserted above
                if (students[i] != null && students[i].getId().equals(id)) {
                    System.out.println("Student already exists !!! ");
                    System.out.println("+------------------------------------------------------------------+\n");
                    return;
                }
            }

            // Accessing the array of students
            for (int i = 0; i < 100; i++) {
                // Checking for first null position in array of students and add student details to it
                if (students[i] == null){
                    students[i] = new Student(id);
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

        // Accessing the array of students
        for (int i = 0; i < 100; i++) {
            // Comparing wheather student matches student id user inserted above
            if (students[i] != null && students[i].getId().equals(id)){
                deleted = true; // Assigning the variable to false
                studentCount--; // Decreasing student count by one

                students[i] = null; // Removing the student details from array of students
                // Printing student deleted successfully
                System.out.println("Student deleted successfully ! ");
                break; // Exit loop
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

        // Accessing the array of students
        for (int i = 0; i < 100; i++) {
            // Comparing wheather student matches student id user inserted above
            if (students[i] != null && students[i].getId().equals(id)) {
                students[i].studentDetails(); // Printing the student details using method inside Student class
                System.out.println("Seat  : " + (i + 1));
                found = true; // Assign the variable to true

                break;
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

            // Checking wheather student count is zero
            if (studentCount == 0){
                // Printing no data is there to write
                System.out.println("No data to be written !!! \n");
            }

            else{
                // Opening file writer
                // Ref : https://sentry.io/answers/read-file-java/
                FileWriter fileWriter = new FileWriter("students-details.txt");

                // Accessing array of students
                for (int i = 0; i < studentCount; i++) {
                    if (students[i] != null) {
                        // Writing the data of array of students to text file
                        fileWriter.write(students[i].getId() + "," + students[i].getName() + "," + students[i].getModules()[0].getMark() + "," + students[i].getModules()[1].getMark() + "," + students[i].getModules()[2].getMark() + "\n");
                    }

                }

                // Printing that text file written completed
                System.out.println("Student details stored successfully !!! ");
                System.out.println("Text File Name : students-details.txt\n");

                fileWriter.close(); // Closing file writer

            }


        } catch (IOException e) { // In event of IO Exception Printing unable to write
            System.out.println("An error occurred while writing to the file.\n");


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
            students = new Student[100];

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Spliting line to parts array using ,

                // Accessing array of students
                for (int i = 0; i < 100; i++) {
                    // Adding the data in text file to first null position of array of students
                    if (students[i] == null){
                        students[i] = new Student(parts[0]);
                        students[i].setName(parts[1]);

                        students[i].setModules(Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
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

        // Creating another array of Students
        Student[] students_copy = new Student[100];

        // Copyting the data from original array to Copy array
        for (int i = 0; i < studentCount; i++) {
            students_copy[i] = students[i];

        }

        // Bubble sort the data based on student name
        // Ref : https://www.geeksforgeeks.org/bubble-sort-algorithm/
        for (int i = 0; i < students_copy.length - 1; i++) {
            for (int j = 0; j < students_copy.length - 1 - i; j++) {
                if (students_copy[j] != null && students_copy[j + 1] != null && students_copy[j].getName().length() > students_copy[j + 1].getName().length()) {
                    // Swapping the data
                    Student temp = students_copy[j];
                    students_copy[j] = students_copy[j + 1];
                    students_copy[j + 1] = temp;
                }
            }
        }

        // Accessing the array of students copy
        for (Student student : students_copy){
            if (student != null){ // Printing the data by calling method inside Student class
                student.studentDetails();
                System.out.println();
            }
        }

        System.out.println("+------------------------------------------------------------------+\n");
    }

    private static void seeMoreOptions(){
        // Printing Menu - 2 for user
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                            Menu - 2                              +");
        System.out.println("+------------------------------------------------------------------+\n");

        System.out.println("  A. Add student name");
        System.out.println("  B. Manage module marks");
        System.out.println("  C. Generate a summary of the system");
        System.out.println("  D. Generate complete report with list of students");
        System.out.println("     Any key + enter to proceed to Main Menu \n");

        System.out.print("Enter your choice : ");
        String choice = scanner.nextLine().toLowerCase();

        switch (choice){
            case "a":
                addStudentName();
                break;
            case "b":
                manageModuleMarks();
                break;
            case "c":
                systemSummary();
                break;
            case "d":
                studentsDetails();
                break;
        }
        System.out.println("+------------------------------------------------------------------+\n");
    }

    private static void addStudentName(){
        // Printing the Add Student Name message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                     Add Student Name                             +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Running while loop under isValid(id) method returns false
        // Refer to isValid(id) method for Logic
        System.out.print("Enter student ID to add name : ");
        String id = scanner.nextLine();

        while(!isValid(id)){
            // Printing to insert correct ID again
            System.out.println("Enter a valid ID like w1234567 again !!! \n");

            // Asking for ID input again from user
            System.out.print("Enter student ID to add name : ");
            id = scanner.nextLine();
        }

        // Getting the users name from the user
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase(); // Capitalizing the student name


        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getId().equals(id)){
                students[i].setName(name);
                System.out.println("Student Name added successfully !!! ");
                return;
            }
        }

        System.out.println("Unable to add student name !!! ");
    }

    // Creating method to manage the module marks of students
    private static void manageModuleMarks(){
        // Printing the Manage Module Marks message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                     Manage Module Marks                          +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Running while loop under isValid(id) method returns false
        // Refer to isValid(id) method for Logic
        System.out.print("Enter student ID to manage module marks: ");
        String id = scanner.nextLine();

        while(!isValid(id)){
            // Printing to insert correct ID again
            System.out.println("Enter a valid ID like w1234567 again !!! \n");

            // Asking for ID input again from user
            System.out.print("Enter student ID to manage module marks: ");
            id = scanner.nextLine();
        }

        // Creating a variable and assign it to false
        boolean found = false;

        // Accessing array of students
        for (int i = 0; i < 100; i++) {
            // Checking wheather the student id matches with student id inserted above by user
            if (students[i] != null && students[i].getId().equals(id)) {
                found = true; // Assign variable to true

                try { // Exception handling

                    // Asking for module marks of 3 modules
                    System.out.print("Enter module 1 mark: ");
                    double module1 = scanner.nextInt();

                    System.out.print("Enter module 2 mark: ");
                    double module2 = scanner.nextInt();

                    System.out.print("Enter module 3 mark: ");
                    double module3 = scanner.nextInt();

                    scanner.nextLine();  // Consume newline

                    // Setting the module marks of the student with method inside Student class
                    students[i].setModules(module1, module2, module3);

                    // Printing Module marks updated successfully
                    System.out.println("Module marks updated successfully.");
                    break; // Exit the loop
                }catch (InputMismatchException e){ // In event of exception
                    // Printing to enter module marks again
                    System.out.println("Please enter module marks correctly again !\n");

                }
            }
        }

        // If the variable is not true (false)
        if (!found){
            // Printing student is not available
            System.out.println("Student not available ! ");
        }

        System.out.println("+------------------------------------------------------------------+\n");
    }

    // Creating method to print a summary of the system
    private static void systemSummary() {
        // Printing the System Summary message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                        System Summary                            +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Printing the student count
        System.out.println("The total student registrations : " + studentCount);

        // Creating and initialize variable
        int totalModulesPassed = 0;

        // Accessing array of students
        for (int i = 0; i < studentCount; i++) {

            if (students[i] != null){
                // Creating and initialize variable
                int modulesPassed = 0;

                // Accessing of array of modules inside array of students
                for (int j = 0; j < 3; j++) {

                    if (students[i].getModules()[j].getMark() > 40){ // If mark is above 40 increase counter
                        modulesPassed++;

                    }
                }

                if (modulesPassed == 3){
                    totalModulesPassed++; // If counter is equal to three increase the module pass counter
                }
            }
        }

        // Print the total students passed all modules ( total module pass counter)
        System.out.println("Total no of students who are scored more than 40 marks in Module 1, 2 and 3 : " + totalModulesPassed);
        System.out.println("+------------------------------------------------------------------+\n");

    }

    // Creating method to print all student details
    private static void studentsDetails(){
        // Printing the Student Report message
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+                     Students Report                              +");
        System.out.println("+------------------------------------------------------------------+\n");

        // Creating a array of students new
        Student[] students_copy = new Student[100];

        // Copying the data
        for (int i = 0; i < students.length; i++) {
            students_copy[i] = students[i];
        }

        // Bubble sort the data based on length of the names
        for (int i = 0; i < students_copy.length - 1; i++) {
            for (int j = 0; j < students_copy.length - 1 - i; j++) {
                if (students_copy[j] != null && students_copy[j + 1] != null && students_copy[j].moduleAverage() > students_copy[j + 1].moduleAverage()) {
                    // Swapping the data
                    Student temp = students_copy[j];
                    students_copy[j] = students_copy[j + 1];
                    students_copy[j + 1] = temp;
                }
            }
        }


        // Accessing array of students
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null){
                // Printing student details by method inside Student class
                students[i].studentDetails();

                // Printing module details by method inside Student class
                students[i].printModuleMarks();
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
