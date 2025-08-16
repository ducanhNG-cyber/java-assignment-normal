/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author NguyenDucAnh
 */
public class InputHandle {
    
    private Scanner scanner = new Scanner(System.in);
    
    private static final String NAME_REGEX = "^[a-zA-Z ]+$";
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String UPDATE_REGEX = "u";
    private static final String DELETE_REGEX = "d";
    
    private void printPrompt(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Prompt message cannot be EMPTY!");
        }
        printPrompt(0,message);
    }
    
    private boolean isValidName(String valueInputed) {
        return valueInputed != null
                && !valueInputed.isEmpty()
                && valueInputed.matches(NAME_REGEX);
    }
    
    public String promptForName(String message) {
        String value;
        do {
            printPrompt(message);
            value = scanner.nextLine().trim();
            if (!isValidName(value)) {
                printPrompt(-1, "Invalid input! Name must contain only letters and spaces.");
            }
        } while (!isValidName(value));
        return value;
    }
    
    private boolean isValidNumber(String valueInputed, int min, int max) {
        return valueInputed != null
                && !valueInputed.isEmpty()
                && valueInputed.matches(NUMBER_REGEX)
                && isBetween(valueInputed, min, max);
    }
    
    private boolean isBetween(String valueInputed, int min, int max) {
        int number = Integer.parseInt(valueInputed);
        return number >= min && number <= max;
    }
    
    public String getUserLimitChoice(String message, int min, int max) {
        String value;
        do {
            printPrompt(message);
            value = scanner.nextLine().trim();
            if (!isValidNumber(value, min, max)) {
                printPrompt(-1, "Invalid input! Number must between %d and %d".formatted(min, max));
            }
        } while (!isValidNumber(value, min, max));
        return value;
    }
    
    private boolean isBoolChoiceProcess(String valueInputed) {
        return valueInputed.toLowerCase().equals(UPDATE_REGEX)
                || valueInputed.toLowerCase().equals(DELETE_REGEX);
    }
    
    public boolean getBoolChoice(String message) {
        String value;
        boolean setBool = false;
        do {
            printPrompt(message);
            value = scanner.nextLine().trim();
            if (!isBoolChoiceProcess(value)) {
                printPrompt(-1, "Invalid input! Value must 'u[U]' or d[D]!");
            }
            
            if (value.toLowerCase().equals(UPDATE_REGEX)) {
                setBool = true;
            }
            
            if (value.toLowerCase().equals(DELETE_REGEX)) {
                setBool = false;
            }
            
        } while (!isBoolChoiceProcess(value));
        return setBool;
    }
    
    private void printPrompt(int number, String message) {
        if (number == 0) {
            System.out.println(message);
        } else if (number == -1) {
            System.err.println(message);
        } else {
            System.out.println("%d. %s".formatted(number, message));
        }
    }
}
