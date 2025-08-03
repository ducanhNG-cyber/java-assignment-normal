/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author NguyenDucAnh
 */
public class ProgramView {

    public void menuView() {
        System.out.println("welcome to student management".toUpperCase());
        String[] menu = {"Create", "Find and sort",
            "Update/Delete", "Report", "Exit"};
        
        int index = 1;
        for(String i : menu){
            System.out.println("%d. %s".formatted(index,i.toString()));
            index++;
        }
        
        String msg = "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).";
        System.out.println(msg.toString());
    }
}
