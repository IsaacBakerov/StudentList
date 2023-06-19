import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Max 10 student can be added
        int size = 10;
        Student students[] = new Student[size];

        int i = 0;
        while (true) {
            //Commands
            System.out.println("There are " + size + " places for students to be added");
            System.out.println("""
            Enter command:
                Enter new student: 1
                See all students: 2
                Get starting year of Student: 3
                Exit: 0
            """);
            String command = sc.nextLine();

            //Exit loop and program stops
            if (command.equals("0")) {
                break;
            }
            //See list of students
            else if (command.equals("2")) {
                //No students
                if (i == 0) {
                    System.out.println("No students added yet.");
                    System.out.println();
                }
                //After adding student(s) list can be printed
                else {
                    for (int n = 0; n < i; n++) {
                        System.out.println(String.format("Student %d:", n+1));
                        System.out.println(String.format("""
                        Name: %s
                        Age: %d
                        University: %s
                        Field of study: %s
                        Year in course: %d
                    """, students[n].name, students[n].age, students[n].university, students[n].field, students[n].year));
                    }
                }
            }
            //Inputting student credentials
            else if (command.equals("1")){
                if (size > 0) {
                    System.out.println("Enter name:");
                    String name = sc.nextLine();
                    System.out.println("Enter age:");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter the name of the university:");
                    String university = sc.nextLine();
                    System.out.println("Enter field of study:");
                    String field = sc.nextLine();
                    System.out.println("Enter which year the student is in (ex. \"2\"):");
                    int year = Integer.parseInt(sc.nextLine());

                    //Adds the student object to array
                    students[i] = new Student(name, age, university, field, year);

                    //Decreases places left in array, max is 10
                    size--;
                    System.out.println("New student added.");
                    System.out.println();

                    i++;
                } else {
                    System.out.println("There are no more places to add a student.");
                    System.out.println();
                }
            }
            //Printing starting year of specific student
            else if (command.equals("3")) {
                //"f" variable is used for if there is no specific student in array
                int f = 0;
                //Input name
                System.out.print("Select student by name: ");
                String nameOfStudent = sc.nextLine();
                System.out.println();
                for (int n = 0; n < i; n++) {
                    //Finds specific student object in array with inputted name
                    if (students[n].name.equalsIgnoreCase(nameOfStudent)) {
                        //Object method
                        int startYear = students[n].startingYear();
                        System.out.println(String.format("%s started studying at %s in %d.", students[n].name, students[n].university, startYear));
                        System.out.println();
                        f = 0;
                        break;
                    } else {
                        f++;
                    }
                }

                if (f != 0) {
                    System.out.println("Student not found.");
                    System.out.println();
                }
            }
        }
    }
}
