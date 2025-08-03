/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public interface IStudent {

    public Student createStudent();

    public Student findStudent();

    public StudentList sortStudentFinded();

    public void report();

    public Student deleteStudent(int index);

    public Student updateStudent(int index);
}
