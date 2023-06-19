import java.time.LocalDate;
import java.time.Year;

//Declaring Student class
public class Student {
    protected String name;
    protected int age;
    protected String university;
    protected String field;
    protected int year;
    //Method for finding starting year of student
    public int startingYear() {
        LocalDate ld = LocalDate.now();
        return ld.getYear() - year;
    }

    public Student(String name, int age, String university, String field, int year) {
        this.name = name;
        this.age = age;
        this.university = university;
        this.field = field;
        this.year = year;
    }

}
