import java.io.*;
import java.util.*;

public class DriverClass {
    // LinkedList to hold Student Objects.
    private static LinkedList<Student> studentList = new LinkedList<Student>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String args[]) throws FileNotFoundException {
        PrintStream outToFile = new PrintStream(new File("StudentList.txt"));

        //Displays prompts for user:
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Would you like to add a student to the list?");
            switch (yesNo()) {
            case "Yes":
                inputStudentData();
                break;
            case "No":
                System.out.println(studentList);
                // Output to file:
                for (Student entry : studentList) {
                    outToFile.println(entry);
                }
                continueLoop = false;
                break;
            }// end switch-case
        } // End of While-loop
    }// End of main

    // Gets user input, creates Student Object, and adds it to the studentList
    // LinkedList.
    private static void inputStudentData() {
        int attempts = 0, maxAttempts = 3;// Sets Max attempts.

        boolean continueLoop = true;
        while (continueLoop) {

            try {
                System.out.println("Enter Name: ");
                String name = in.nextLine();

                System.out.println("Enter Their Address: ");
                String address = in.nextLine();

                System.out.println("Enter Current GPA");
                double GPA = in.nextDouble();
                in.nextLine();// Clears rest of line.

                // Validates GPA input:
                if (GPA > 4.0 || GPA < 0.0)
                    throw new Exception("Invalid GPA");

                // Adds new student to studentList
                studentList.add(new Student(name, address, GPA));
                studentList.sort(new NameComparator());
                // Ends loop:
                continueLoop = false;

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Try inputting their info again.");
                in.nextLine();
                // Logic to stop loop:
                if (attempts > maxAttempts) {
                    continueLoop = false;
                } else {
                    attempts++;
                }
            } // end Try-Catch
        } // while-loop
    }// end of inputStudentData

    // Asks user Yes no question, and return appropriate string;
    private static String yesNo() {
        int attempts = 0, maxAttempts = 3;
        System.out.println("Yes or No?");

        boolean continueLoop = true;
        while (continueLoop) {
            try {
                String choose = in.next();
                if (choose.equalsIgnoreCase("no") || choose.equalsIgnoreCase("n")) {
                    in.nextLine();
                    return "No";
                } else if (choose.equalsIgnoreCase("yes") || choose.equalsIgnoreCase("y")) {
                    in.nextLine();
                    return "Yes";
                } else {
                    throw new Exception("Only input Yes or No");
                }
            } catch (Exception e) {
                System.out.println(e);
                in.nextLine();

                //Logic to stop loop:
                if (attempts < maxAttempts) {
                    attempts++;
                } else {
                    continueLoop = false;
                }
            } // End Try-catch
        }
        return null;

    }// End yesNo
}// End of DriverClass
