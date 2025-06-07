public class Student {
    // Creating the private attributes
    // Private is used because cant access from another class
    private String id;
    private String name;
    private Module[] modules;

    // Creating the constructor
    // Public is used to access outside from this class
    public Student(String id) {
        // Assign the values
        this.id = id;
        this.name = "null";
        this.modules = new Module[3];

        // Intialize array of modules
        for (int i = 0; i < 3; i++) {
            modules[i] = new Module(); // Default constructor of array of modules (Created by complier)
        }
    }

    // Getter to return the ID
    public String getId() {
        return id;
    }

    // Setter to set the ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter to return the Name
    public String getName() {
        return name;
    }

    // Setter to set the Name
    public void setName(String name) {
        this.name = name;
    }

    // Method to set data to array of modules
    public void setModules(double module1, double module2, double module3) {
        // Setting the data to array of modules
        modules[0].setMark(module1);
        modules[1].setMark(module2);
        modules[2].setMark(module3);

    }

    // Method to print student details
    public void studentDetails() {
        // Printing the student details
        System.out.println("Student ID\t:" + id);
        System.out.println("Student Name\t:" + name);


    }

    // Getter to return array of modules
    public Module[] getModules() {
        return modules;
    }

    // Method to print module mark information
    public void printModuleMarks(){
        // Printing the mark for each module by loop (array of modules)
        for (int i = 0; i < 3; i++) {
            System.out.println("Module " + (i + 1) + " Mark : " + modules[i].getMark());
        }

        // Calculating total, average, grade with array of modules
        System.out.println("Total : " + (modules[0].getMark() + modules[1].getMark() + modules[2].getMark()));
        System.out.println("Average : " + moduleAverage());
        System.out.println("Grade : " + moduleGrade() + "\n");
    }

    // Method to calculate module average
    public double moduleAverage(){
        return (modules[0].getMark() + modules[1].getMark() + modules[2].getMark()) / 3;
    }

    // Method to calculate module grade
    public String moduleGrade(){   // Tenary operator used
        return moduleAverage() >= 80 ? "Distinction" : moduleAverage() >= 70 ? "Merit" : moduleAverage() >= 40 ? "Pass" : "Fail";
    }
}

