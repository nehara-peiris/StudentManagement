import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String[][] user = {{"admin"}, {"1234"}};
    static String[][] student = new String[0][6];

    static String[][] subjects = new String[0][2];
    static String[][] marks = new String[0][];

    public static void main(String[] args) {
        viewStudent();
    }

    public static void welcomeScreen() {
        System.out.println("\n+-------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t\tLOGIN PAGE\t\t\t\t\t\t|");
        System.out.println("+-------------------------------------------------------+");
        username();
    }

    public static void username() {
        System.out.print("User Name : ");
        String name = scanner.nextLine();
        if (name.equals(user[0][0])) {
            System.out.println();
            password();
        } else {
            System.out.println("User name is invalid. please try again");
            System.out.println();
            username();
        }
    }

    public static void password() {
        System.out.print("Password : ");
        String passcode = scanner.nextLine();
        if (passcode.equals(user[1][0])) {
            homePage();
        } else {
            System.out.println("Password is incorrect. please try again\n");
            password();
        }
    }

    public static void homePage() {
        System.out.println("\n+-------------------------------------------------------+");
        System.out.println("|\t\tWELCOME TO IJSE STUDENT MANAGEMENT SYSTEM \t\t|");
        System.out.println("+-------------------------------------------------------+\n");

        System.out.println("[1] Manage Student \t [2] Manage Subject Marks \n[3] Exit the system \n");
        System.out.print("Enter your option to continue > ");
        int opt = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (opt) {
            case 1:
                manageStudent();
                break;
            case 2:
                manageMarks();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid option");
                homePage();
        }
    }

    private static void logout() {
        System.out.println("Logging out...");
        System.exit(0);
    }

    private static void manageStudent() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|\t\t\t\t STUDENT MANAGE \t\t\t\t|");
        System.out.println("+-----------------------------------------------+\n");

        System.out.println("[1] Add student \t [2] Update student  \n[3] Delete student \t [4] View student \n[5] Home Page \t\t [6] Exit the System \n");
        System.out.print("Enter your option to continue > ");
        int opt = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (opt) {
            case 1:
                addStudent();
                break;
            case 2:
                updateStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                viewStudent();
                break;
            case 5:
                homePage();
                break;
            case 6:
                logout();
                break;
            default:
                System.out.println("Invalid option");
                manageStudent();
        }
    }

    private static void viewStudent() {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t VIEW STUDENT  \t\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");


        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "STUDENT ID", "STUDENT NAME", "AGE", "CONTACT", "ADDRESS", "RANK");
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+");

        for (int i = 0; i < student.length; i++) {
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n",
                    student[i][0],
                    student[i][1],
                    student[i][2],
                    student[i][3],
                    student[i][4],
                    student[i][5]);
        }
        System.out.println("+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+");

        System.out.print("Do you want to go to home page(Y/N)? ");
        String res = new Scanner(System.in).nextLine();

        if (res.equals("Y") || res.equals("y")){
            homePage();
        }else {
            manageStudent();
        }
    }

    private static void deleteStudent() {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\t DELETE STUDENT  \t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");

        System.out.print("Student ID \t: ");
        String res = new Scanner(System.in).nextLine();

        int count = 0;
        for (int i = 0; i < student.length; i++){

            if (res.equals(student[i][0])){
                student[i][0] = "null";
                student[i][1] = "null";
                student[i][2] = "null";
                student[i][3] = "null";
                student[i][4] = "null";
                System.out.print("Deleted successfully! Do you want to delete another? (Y/N) ");
                String ans = new Scanner(System.in).nextLine();
                if (ans.equals("Y") || ans.equals("y")){
                    deleteStudent();
                }else{
                    manageStudent();
                }
            }else{
                count++;
            }
        }
        if (count == student[0].length){
            System.out.println("Can't find supplier id. try again");
            deleteStudent();
        }

    }

    private static void updateStudent() {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t UPDATE STUDENTS  \t\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------+\n");

        System.out.print("Supplier ID         : ");
        String id = new Scanner(System.in).nextLine();

        int count = 0;

        for (int i = 0; i < student.length; i++){
            if (id.equals(student[i][0])){
                System.out.println("Student name : " + student[i][1]);
                System.out.println("Student age : " + student[i][2]);
                System.out.println("Student contact : " + student[i][3]);
                System.out.println("Student address : " + student[i][4]);

                System.out.print("\nEnter the new Student name : ");
                student[i][1] = new Scanner(System.in).next();

                System.out.print("\nEnter the new Student age : ");
                student[i][2] = new Scanner(System.in).next();

                System.out.print("\nEnter the new Student contact : ");
                student[i][3] = new Scanner(System.in).next();

                System.out.print("\nEnter the new Student address : ");
                student[i][4] = new Scanner(System.in).next();

                System.out.print("Updated successfully! Do you want to update another Student? (Y/N) : ");
                String res = new Scanner(System.in).next();

                if (res.equals("y") || res.equals("Y")){
                    updateStudent();
                }else{
                    manageStudent();
                }
            }else{
                count++;
            }
        }
        if (count == student.length){
            System.out.println("Can't find Student id. try again!");
            updateStudent();
        }
    }

    private static void addStudent() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t ADD STUDENT  \t\t\t\t\t|");
        System.out.println("+-------------------------------------------------------+\n");


        student = grow(student);

        String stuID = generateStudentID();
        System.out.println("Student ID : " + stuID);
        student[student.length-1][0] = stuID;

        System.out.print("Enter Student Name: ");
        student[student.length-1][1] = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        student[student.length-1][2] = scanner.nextLine();

        System.out.print("Enter Student Contact: ");
        student[student.length-1][3] = scanner.nextLine();

        System.out.print("Enter Student Address: ");
        student[student.length-1][4] = scanner.nextLine();

        System.out.println("Student added successfully!");

        System.out.print("Do you want to add another student? (y/n): ");
        String res = scanner.nextLine();
        if (res.equalsIgnoreCase("y")) {
            addStudent();
        } else {
            manageStudent();
        }
    }

    private static String generateStudentID() {
        if (student.length == 0 || student[0][0] == null) {
            return "S001";
        }

        int maxID = 0;
        for (String[] row : student) {
            String id = row[0];
            if (id != null && id.startsWith("S")) {
                int currentID = Integer.parseInt(id.substring(1));
                if (currentID > maxID) {
                    maxID = currentID;
                }
            }
        }
        return String.format("S%03d", maxID + 1);
    }

    public static String[][] grow(String[][] old) {
        if (old.length == 0 || old[0].length == 0) {
            return new String[1][6];
        }

        String[][] newArray = new String[old.length+1][old[0].length];

        for (int i = 0; i < old.length; i++) {
            System.arraycopy(old[i], 0, newArray[i], 0, old[i].length);
        }
        return newArray;
    }

    private static void manageMarks() {
        System.out.println("+-----------------------------------------------+");
        System.out.println("|\t\t\t\t STUDENT MANAGE \t\t\t\t|");
        System.out.println("+-----------------------------------------------+\n");

        System.out.println("[1] Add new Subject \t [2] Add marks  \n[3] Update marks \t [4] View subject marks \n[5] Home Page \t\t [6] Exit the System \n");
        System.out.print("Enter your option to continue > ");
        int opt = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (opt) {
            case 1:
                addNewSub();
                break;
            case 2:
                addMarks();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                viewStudent();
                break;
            case 5:
                homePage();
                break;
            case 6:
                logout();
                break;
            default:
                System.out.println("Invalid option");
                manageStudent();
        }
    }

    private static void addMarks() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t ADD STUDENT  \t\t\t\t\t|");
        System.out.println("+-------------------------------------------------------+\n");


        marks = grow(marks);

        System.out.println("Student ID : ");
        String stId = scanner.next();
        marks[marks.length-1][0] = stId;

        for (int i = 0; i < student.length; i++) {
            if (stId.equals(student[i][0])) {
                System.out.println("Student name : " + student[i][1]);
                marks[marks.length-1][1] = student[i][1];
            }
        }

        System.out.println("Subject ID : ");
        String sbId = scanner.next();
        marks[marks.length-1][2] = sbId;

        for (int i = 0; i < subjects.length; i++) {
            if (sbId.equals(subjects[i][0])) {
                System.out.println("Subject name : " + subjects[i][1]);
                marks[marks.length-1][3] = subjects[i][1];
            }
        }

        System.out.print("Enter marks: ");
        String mark = scanner.next();
        marks[marks.length-1][0] = mark;

        System.out.println("Student added successfully!");

        System.out.print("Do you want to add another student? (y/n): ");
        String res = scanner.nextLine();
        if (res.equalsIgnoreCase("y")) {
            addStudent();
        } else {
            manageStudent();
        }
    }

    private static void addNewSub() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|\t\t\t\t ADD NEW SUBJECT  \t\t\t\t|");
        System.out.println("+-------------------------------------------------------+\n");

        subjects = grow(subjects);

        String subID = generateSubjectID();
        System.out.println("Subject ID : " + subID);
        subjects[subjects.length-1][0] = subID;

        System.out.print("Enter subject Name: ");
        subjects[subjects.length-1][1] = scanner.nextLine();

        System.out.println("Subject added successfully!");

        System.out.print("Do you want to add another subject? (y/n): ");
        String res = scanner.nextLine();
        if (res.equalsIgnoreCase("y")) {
            addNewSub();
        } else {
            manageMarks();
        }
    }

    private static String generateSubjectID() {
        if (student.length == 0 || student[0][0] == null) {
            return "SB001";
        }

        int maxID = 0;
        for (String[] row : student) {
            String id = row[0];
            if (id != null && id.startsWith("SB")) {
                int currentID = Integer.parseInt(id.substring(1));
                if (currentID > maxID) {
                    maxID = currentID;
                }
            }
        }
        return String.format("SB%03d", maxID + 1);
    }

    public static String[] grow(String[] oldArray) {
        String[] newArray = new String [oldArray.length + 1];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }
}
