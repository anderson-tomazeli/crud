import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    int id;
    String name;
    String phoneNumber;
    Date birthDay;
    Date creationDate;
    Date lastUpdateDate;
    String finalCourseGrade;
    String type;

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return  //String.format("%-" + 7 + "s", this.id) + "| " +
                String.format("%-" + 21 + "s", this.name) + "| " +
                String.format("%-" + 14 + "s", this.phoneNumber) + "| " +
                String.format("%-" + 12 + "s", dateFormat.format(this.birthDay)) + "| " +
                String.format("%-" + 14 + "s", dateFormat.format(this.creationDate)) + "| " +
                String.format("%-" + 17 + "s", dateFormat.format(this.lastUpdateDate)) + "| " +
                String.format("%-" + 19 + "s", this.finalCourseGrade) + "| " +
                this.type;
    }

    void createPerson(int id, String name, String phoneNumber, Date birthDay, Date creationDate, Date lastUpdateDate, String finalCourseGrade){
        this.id = id; //getId();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.finalCourseGrade = finalCourseGrade;
        if (this.finalCourseGrade.isBlank()){
            this.type = "Person";
        } else {
            this.type = "Student";
        }
    }

}
