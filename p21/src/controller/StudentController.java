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
import utils.InputHandle;
import view.ProgramView;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentController {

    private StudentList studentList = new StudentList();
    private ProgramView view = new ProgramView();
    private InputHandle inputHandle = new InputHandle();

    public void run() {
        addData();
        while (true) {
            getMenu();
            String choices = inputHandle.getUserLimitChoice("Enter choice: ", 1, view.menu.length);
            int choice = Integer.parseInt(choices);
            switch (choice) {
                case 1: // create
                    studentList.create();
                    break;
                case 2: // find and sort
                    studentList.findAndSort();
                    break;
                case 3: // update/delete
                    case3();
                    break;
                case 4: // report
                    studentList.report();
                    break;
                case 5:
                    System.out.println("Exited program!");
                    return;
            }
        }
    }

    private void case3() {
        boolean isChoiced = inputHandle.getBoolChoice("Please choice u for update, d for delete: ");
        if (isChoiced) { // true -> update
            studentList.updateStudent();
        } else { // false -> delete
            studentList.deleteStudent();
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
