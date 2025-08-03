/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.Course;
import model.Semester;
import model.Student;
import model.StudentList;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentController {

    private StudentList studentList = new StudentList();
    private ProgramView view = new ProgramView();
    private Scanner scanner = new Scanner(System.in);
    
    public void run() {
        addData();
        while (true) {
            getMenu();
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // create
                    break;
                case 2: // find and sort
                    break;
                case 3: // update/delete
                    studentList.deleteStudent();
                    break;
                case 4: // report
                    //studentList.display();
                    studentList.report();
                    break;
                case 5:
                    System.out.println("Exited program!");
                    return;
            }
        }
    }

    private void addData() {
        studentList.addStudent(new Student("Nguyen Van A", Semester.SUMMER, Course.JAVA));
        studentList.addStudent(new Student("Nguyen Van A", Semester.SPRING, Course.PYTHON));
        studentList.addStudent(new Student("Nguyen Van B", Semester.FALL, Course.NET));
        studentList.addStudent(new Student("Nguyen Van B", Semester.SUMMER, Course.JAVA));
    }

    private void getMenu() {
        view.menuView();
    }
}
