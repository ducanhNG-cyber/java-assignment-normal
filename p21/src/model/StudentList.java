/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentList extends ArrayList<Student> implements IStudent {

    public void addStudent(Student student) {

        if (student == null) {
            System.out.println("This student value is null!");
            return;
        }

        this.add(student);
    }

    @Override
    public Student createStudent() {

        String name = "";
        Semester semester = null;
        Course course = null;

        // create value for student object
        Student studentCreated = new Student(name, semester, course);

        return studentCreated;
    }

    @Override
    public Student findStudent() {

        String studentName = "";
        Student finding = null;
        for (Student s : this) {
            if (s.getStudentName().equalsIgnoreCase(studentName)) {
                finding = s;
            }
        }

        return finding;
    }

    @Override
    public StudentList sortStudentFinded() {
        
        Student target = findStudent();
        if (target == null) {
            System.out.println("Student name is not existed!");
            return new StudentList();
        }

        StudentList matching = new StudentList();
        for (Student s : this) {
            if (s.getStudentName().equalsIgnoreCase(target.getStudentName())) {
                matching.addStudent(s);
            }
        }

        matching.sort(Comparator.comparing(Student::getStudentName));
        return matching;
    }

    @Override
    public void report() {

    }

    @Override
    public Student deleteStudent(int index) {
        return null;
    }

    @Override
    public Student updateStudent(int index) {
        return null;
    }
}
