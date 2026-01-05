import java.io.*;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

//================================================

class Student implements Serializable {
    public String name;
    public String surname;
    public int mark1, mark2, mark3;

    public Student(String name, String surname, int mark1, int mark2, int mark3) {
        this.name = name;
        this.surname = surname;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public void print(int numurs) {
        out.printf("\n%-4d%-15s%-15s%-12d%-12d%-12d", numurs, name, surname, mark1, mark2, mark3);
    }
}

//================================================

public class Main {

    static Scanner sc = new Scanner(in);

    static String filename = "Students.dat";

    public static void main(String[] args) {
        int choise;
        String choiseStr;

        loop:
        while (true) {

            out.println("\n1) Create");
            out.println("2) Calculate");
            out.println("3) View");
            out.println("4) About");
            out.println("5) Exit");
            out.print("\nInput number from 1 till 5: ");

            choiseStr = sc.nextLine();

            try {
                choise = Integer.parseInt(choiseStr);
                if (choise < 1 || choise > 5) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                out.println("Error, please, input number from 1 till 5");
                continue;
            }


            switch (choise) {
                case 1:
                    create();
                    break;
                case 2:
                    calculate();
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    about();
                    break;
                case 5:
                    break loop;
            }
        }

        sc.close();
    }

    public static void create() {
        Student student;

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));

            student = new Student("Andris", "Kokins", 5, 4, 3);
            out.writeObject(student);

            student = new Student("Maris", "Lauva", 9, 9, 9);
            out.writeObject(student);

            student = new Student("Edvards", "Ozols", 8, 7, 8);
            out.writeObject(student);

            student = new Student("Mara", "Liepa", 4, 2, 9);
            out.writeObject(student);

            student = new Student("Inga", "Lapsa", 7, 7, 7);
            out.writeObject(student);

            out.close();

            System.out.println("\nFile " + filename + " succesfully created");
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
    }

    public static void calculate() {
        // TODO develop this method
        File f = new File(filename);
        int Number;
        Student s;
        int constant = 1;
        boolean StudentIs = false;

        try {
            Number = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            out.println("Invalid input");
            return;
        }
        while (true) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));

                s = (Student) in.readObject();
                if (constant == Number) {
                    System.out.println("New first mark:");
                    s.mark1 = Integer.parseInt(sc.nextLine());
                    System.out.println("New second mark:");
                    s.mark2 = Integer.parseInt(sc.nextLine());
                    System.out.println("New third mark:");
                    s.mark3 = Integer.parseInt(sc.nextLine());
                    StudentIs = true;
                }

                out.writeObject(s);
                constant++;

            } catch (Exception e) {
                break;
            }
        }

        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.close();

        if (!StudentIs || Number < 1 || Number >= constant) {
            out.println("no such student");
        } else {
            new File(filename).delete();
            new File("temp.dat").renameTo(new File(filename));

        }
    }
    public static void view() {
        File f = new File (filename);
        if (!f.exists()) {
            out.println("The file does not exist, please use command \"Create\"");
            return;
        }

        out.println("\n-----------------------------------------------------------------------");
        out.printf("#   %-15s%-15s%-12s%-12s%-12s", "Name", "Surname", "Math", "Sport", "Programming");
        out.print("\n-----------------------------------------------------------------------");

        int numurs = 1;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));

            Student s;
            boolean EOF = false;

            while (!EOF) {
                try {
                    s = (Student) in.readObject();
                    s.print(numurs++);
                }
                catch (EOFException e) {
                    EOF = true;
                }
            }

            in.close();
        }
        catch (Exception ex) {
            out.println(ex.getMessage());
        }

        out.println("\n-----------------------------------------------------------------------");
    }

    public static void about() {
        // TODO insert information about authors
        out.println("241RDB316, Vladislav Ebert, 7.gruppa");
    }
}

//================================================
