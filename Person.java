import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    String phoneNumber;
    String birthDay;
    String creationDate;
    String lastUpdateDate;
    double finalCourseGrade;

    List<Person> people = new ArrayList<>();

    void createPerson(String name, String phoneNumber, String birthDay, String creationDate, String lastUpdateDate, double finalCourseGrade){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.finalCourseGrade = finalCourseGrade;
    }

    void addPerson(Person person){
        this.people.add(person);
    }

    Person listPerson(){

        for(Person people: this.people){
            return this;
        }
        return null;
    }
}
