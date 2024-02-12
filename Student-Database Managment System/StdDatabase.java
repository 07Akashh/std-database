import java.util.*;

class Student {
    public String name;
    public int RollNo;
    public int age;
    public int marks;

    // Constructors are the mathods those have same name as class and they do not
    // have return
    public Student(String name, int RollNo, int age, int marks) {
        this.name = name;
        this.RollNo = RollNo;
        this.age = age;
        this.marks = marks;
    }
    public void viewStudent() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + RollNo);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}

public class StdDatabase {
    public static void main(String[] args) {
        try{
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Student> database = new HashMap<Integer, Student>();
        while (true) {
            System.out.println("1.Add Student");
            System.out.println("2.View Student");
            System.out.println("3.Search Students");
            System.out.println("4.Calculate Average Marks");
            System.out.println("5.Exit");
            System.out.println("___________________________");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Your Name:");
                    String name = scan.nextLine();
                    System.out.print("Enter your Roll Number: ");
                    int RollNo = scan.nextInt();
                    System.out.print("Enter your Age: ");
                    int age = scan.nextInt();
                    System.out.print("Enter your Marks: ");
                    int marks = scan.nextInt();
                    Student std = new Student(name, RollNo, age, marks);
                    database.put(RollNo, std);
                    System.out.println("Student Added Successfully!");
                    break;
                case 2:
                    System.out.println("List of Students");
                    for (Student i : database.values()) {
                        i.viewStudent();
                    }
                    break;
                case 3:
                    System.out.print("Enter your Roll Number: ");
                    int rollno = scan.nextInt();
                    Student data=database.get(rollno);
                    if(data!=null){
                        data.viewStudent();
                    }
                    else{
                        System.out.println("Invalid Roll Numberr !!");
                    }
                    System.out.println("****************");
                    break;
                case 4:
                    int totalStudent = database.size();
                    int totalMarks = 0;
                    for (Student j : database.values()) {
                        totalMarks = totalMarks + j.marks;
                    }
                    double average = (double) totalMarks / totalStudent;
                    System.out.println("Average Marks: " + average);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    System.out.print("Enter your choice: ");
                    choice = scan.nextInt();
                    
            }
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
}
}