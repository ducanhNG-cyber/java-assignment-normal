/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {

    private Scanner scanner = new Scanner(System.in);

    public String getNameValue(String message) {
        while (true) {
            System.out.print(message);
            String regex = "^[a-zA-Z ]+$";
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be empty!");
                continue;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(value);

            if (matcher.matches()) {
                return value;
            } else {
                System.err.println("Invalid format!(etc. Nguyen Van A)");
            }
        }
    }

    public int getUserLimitChoice(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }

            try {
                int number = Integer.parseInt(value);
                if (number <= 0) {
                    System.err.println("This number must > 0!");
                    continue;
                }

                if (number < min || number > max) {
                    System.err.println("please input value in [%d, %d]".formatted(min, max));
                    continue;
                }

                return number;
            } catch (NumberFormatException e) {
                System.err.println("This value must integer number!");
            }
        }
    }

    public boolean checkUD(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.err.println("This value cannot be EMPTY!");
                continue;
            }
            
            if(value.equalsIgnoreCase("u")){
                return true;
            }
            
            if(value.equalsIgnoreCase("d")){
                return false;
            }
            
            System.err.println("Invalid value! please input update[U] or delete[D]:");
        }
    }
    

}
