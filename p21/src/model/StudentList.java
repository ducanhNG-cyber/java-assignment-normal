/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentList extends ArrayList<Student> implements IStudent, IProcess {

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
        HashMap<String, Integer> countCourse = new HashMap<>();
        for (Student s : this) {
            String key = s.getKey();
            countCourse.put(key, countCourse.getOrDefault(key, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(countCourse.entrySet());
        sortedList.sort(Map.Entry.comparingByKey());

        for (Map.Entry<String, Integer> e : sortedList) {
            System.out.println(e.getKey() + "|" + e.getValue());
        }
    }

    @Override
    public void deleteStudent() {

        StudentList matching = new StudentList();
        for (Student s : this) {
            matching.addStudent(s);
        }

        displayMatching(matching);

        int choice = 2;
        Student student = matching.get(choice - 1);

        this.remove(student);
    }

    @Override
    public void updateStudent() {

    }

    private void displayMatching(StudentList matched) {
        int index = 1;
        for (Student s : matched) {
            System.out.println("%d. %s".formatted(index, s.getKey()));
            index++;
        }
    }

    public void display() {
        for (Student s : this) {
            System.out.println(s.toString());
        }
    }
}
