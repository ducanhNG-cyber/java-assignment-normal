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
import utils.InputHandle;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentList extends ArrayList<Student> implements IStudent, IProcess {

    private InputHandle inputHandle = new InputHandle();

    public void addStudent(Student student) {

        if (student == null) {
            System.out.println("This student value is null!");
            return;
        }

        this.add(student);
    }

    private Semester semesterInputting() {

        System.out.println("Please only choice in list:");
        display(Semester.values());
        int choice = inputHandle.getUserLimitChoice("Enter choice[Semester]: ", 1, Semester.values().length);
        while (Semester.fromSemester(choice) == null) {
            System.err.println("Please only choice in list: ");
            display(Semester.values());
            choice = inputHandle.getUserLimitChoice("Enter choice[Semester]: ", 1, Semester.values().length);
        }
        return Semester.fromSemester(choice);
    }

    private Course courseInputting() {

        System.out.println("Please only choice in list:");
        display(Course.values());
        int choice = inputHandle.getUserLimitChoice("Enter choice[Course]: ", 1, Course.values().length);
        while (Semester.fromSemester(choice) == null) {
            System.err.println("Please only choice in list: ");
            display(Course.values());
            choice = inputHandle.getUserLimitChoice("Enter choice[Course]: ", 1, Course.values().length);
        }
        return Course.fromCourse(choice);
    }

    @Override
    public Student createStudent() {

        String name = inputHandle.getNameValue("Enter student name: ");
        Semester semester = semesterInputting();
        Course course = courseInputting();

        Student studentCreated = new Student(name, semester, course);

        return studentCreated;
    }

    public void create() {
        Student createdStudent = createStudent();
        this.addStudent(createdStudent);
        System.out.println("Created student succeed!");
    }

    @Override
    public Student findStudent() {

        String studentName = inputHandle.getNameValue("Enter student name: ");
        Student finding = null;
        for (Student s : this) {
            if (s.getStudentName().toLowerCase()
                    .equalsIgnoreCase(studentName.toLowerCase())) {
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

    public void findAndSort() {
        StudentList sorted = sortStudentFinded();
        for (Student s : sorted) {
            System.out.println(s.toString());
        }
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

        int choice = inputHandle.getUserLimitChoice("Choice student number: ", 1, matching.size());
        Student student = matching.get(choice - 1);

        this.remove(student);
        System.out.println("Deleted student succeed!");
    }

    @Override
    public void updateStudent() {

        StudentList matching = new StudentList();
        for (Student s : this) {
            matching.addStudent(s);
        }

        displayMatching(matching);

        int choice = inputHandle.getUserLimitChoice("Choice student number: ", 1, matching.size());
        Student student = matching.get(choice - 1);

        Semester newSemester = semesterInputting();
        Course newCourse = courseInputting();

        student.setSemester(newSemester);
        student.setCourse(newCourse);
        System.out.println("Updated student succeed!");
    }

    private void displayMatching(StudentList matched) {

        int index = 1;
        for (Student s : matched) {
            String key = s.getStudentName() + "|" + s.getSemester() + "|" + s.getCourse();
            System.out.println("%d. %s".formatted(index, key));
            index++;
        }
    }

    private void display(Semester[] semester) {

        int index = 1;
        for (Semester s : semester) {
            System.out.println("%d. %s".formatted(index, s.getTypeString()));
            index++;
        }
    }

    private void display(Course[] course) {

        int index = 1;
        for (Course c : course) {
            System.out.println("%d. %s".formatted(index, c.getTypeString()));
            index++;
        }
    }

    private void display() {

        for (Student s : this) {
            System.out.println(s.toString());
        }
    }
}
