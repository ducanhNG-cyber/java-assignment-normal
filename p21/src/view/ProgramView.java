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

    public String[] menu = {"Create", "Find and sort",
        "Update/Delete", "Report", "Exit"};

    public void menuView() {

        printPrompt(0, "welcome to student management".toUpperCase());
        int index = 1;
        for (String i : menu) {
            printPrompt(index, i);
            index++;
        }

        String msg = "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).";
        printPrompt(0, msg);
    }

    public void printPrompt(int number, String message) {
        if (number == 0) {
            System.out.println(message);
        } else if (number == -1) {
            System.err.println(message);
        } else {
            System.out.println("%d. %s".formatted(number, message));
        }
    }
}
