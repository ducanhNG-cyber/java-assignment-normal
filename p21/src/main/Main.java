/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.StudentController;

/**
 *
 * @author NguyenDucAnh
 */
public class Main {

    private StudentController controller = new StudentController();
    
    private void runScript(){
        controller.run();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().runScript();
    }
    
}
