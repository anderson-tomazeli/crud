package crud;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Person {

    String name;
    String phoneNumber;
    Date birthDay;
    Date creationDate;
    Date lastUpdateDate;
    String finalCourseGrade;
    String type;

    void CreatePerson(String name, String phoneNumber, Date birthDay, Date creationDate, Date lastUpdateDate, String finalCourseGrade){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.finalCourseGrade = finalCourseGrade;
        if (finalCourseGrade.isEmpty()){
            this.type = "Person";
        } else {
            this.type = "Student";
        }
        //this.type = type;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("%-" + 21 + "s", this.name) + "| " +
               String.format("%-" + 14 + "s", this.phoneNumber) + "| " +
               String.format("%-" + 12 + "s", dateFormat.format(this.birthDay)) + "| " +
               String.format("%-" + 14 + "s", dateFormat.format(this.creationDate)) + "| " +
               String.format("%-" + 17 + "s", dateFormat.format(this.lastUpdateDate)) + "| " +
               String.format("%-" + 19 + "s", this.finalCourseGrade) + "| " +
               this.type;
    }

    public void InputPersonData(String operation, Person pPerson){
        Scanner inputPerson = new Scanner(System.in);
        if (operation.equals("C")) {
            System.out.print("Name: ");
            this.name = inputPerson.nextLine();
            System.out.print("Phone Number: ");
            this.phoneNumber = inputPerson.nextLine();
            System.out.print("Birth day [dd-mon-yyyy]: ");
            String strBirthDay = inputPerson.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date birthDay = Calendar.getInstance().getTime();
            try {
                birthDay = formatter.parse(strBirthDay);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            this.birthDay = birthDay;
            
            this.creationDate = Calendar.getInstance().getTime();
            this.lastUpdateDate = Calendar.getInstance().getTime();
            System.out.print("Final course grade: ");
            this.finalCourseGrade = inputPerson.nextLine();
        } else if (operation.equals("U")) {
            System.out.print("Name: ");
            String name = inputPerson.nextLine();
            if ((!name.isEmpty()) && (!name.equals(pPerson.name))){
                pPerson.name = name;
            }
            
            System.out.print("Phone Number: ");
            String phoneNumber = inputPerson.nextLine();
            if ((!phoneNumber.isEmpty()) && (!phoneNumber.equalsIgnoreCase(pPerson.phoneNumber))){
                pPerson.phoneNumber = phoneNumber;
            }
            
            System.out.print("Birth day [dd-mon-yyyy]: ");
            String strBirthDay = inputPerson.nextLine();
            
            Date birthDay = Calendar.getInstance().getTime();
            if (!strBirthDay.isEmpty()){
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String strThisBirthDay = formatter.format(pPerson.birthDay);
                
                if (!strThisBirthDay.equals(strBirthDay)){
                    try {
                        birthDay = formatter.parse(strBirthDay);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
    
                pPerson.birthDay = birthDay;    
            }
            
            pPerson.creationDate = Calendar.getInstance().getTime();
            pPerson.lastUpdateDate = Calendar.getInstance().getTime();
            
            System.out.print("Final course grade: ");
            String finalCourseGrade = inputPerson.nextLine();
            if (!finalCourseGrade.equals(pPerson.finalCourseGrade)){
                pPerson.finalCourseGrade = finalCourseGrade;
                if (finalCourseGrade.isEmpty()){
                    pPerson.type = "Person";
                } else {
                    pPerson.type = "Student";
                }
            }

        }
        
    }

    public void AddPerson(){
        InputPersonData("C", null);

        Menu.p1.CreatePerson(this.name, this.phoneNumber, this.birthDay, this.creationDate, this.lastUpdateDate, this.finalCourseGrade);
        Menu.personList.add(Menu.p1);
        System.out.println("\nPerson created successfully");
    }

    public void ListPeople(){
        if (Menu.personList.size() > 0) {
            System.out.println("Rec Num| Name                 | Phone         | Birth Day   | Creation Date | Last update date | Final course grade | Type");
            for (int index=0; index < Menu.personList.size(); index++){
                System.out.print(String.format("%-" + 7 + "s", index) + "| ");
                System.out.println(Menu.personList.get(index));
            }
        } else {
            System.out.println("There are no records to be listed");
        }
    }

    public void DeletePerson(){
        if (Menu.personList.size() > 0) {
            ListPeople();
            System.out.print("Rec Num to be deleted: ");
            Scanner inputPerson = new Scanner(System.in);
            int idDelete = inputPerson.nextInt();
            Menu.personList.remove(idDelete);
            System.out.println("Record " + idDelete + " deleted successfully");
        } else {
            System.out.println("There are no records to be deleted");
        }
    }

    public void UpdatePerson(){
        Scanner input = new Scanner(System.in);
        System.out.println("Rec number to be updated: ");
        int index = input.nextInt();
        Person tempPerson = new Person();
        tempPerson = Menu.personList.get(index);
        InputPersonData("U", tempPerson);
        Menu.personList.set(index, tempPerson);
        System.out.println("Record updated successfully");
    }

    // public void ValidateOption(int option){
    //     option--;

    //     if (option >= Menu.personList.size()){
    //         do {
    //             System.out.println("Choose an existing rec number: ");
    //         } while ((ption - 1) > Menu.personList.size());
    //     }
    // }
}