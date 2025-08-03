/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author NguyenDucAnh
 */
public class StudentList extends ArrayList<Student>{
    
    public void addStudent(Student student){
        
        if(student == null){
            System.out.println("This student value is null!");
            return;
        }
        
        this.add(student);
    }
    
    public void report(){
        
    }
}
