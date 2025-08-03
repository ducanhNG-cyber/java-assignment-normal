/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum Semester {
    SUMMER(1, "Summer"),
    SPRING(2, "Spring"),
    FALL(3, "Fall");

    private int typeSelector;
    private String typeString;

    private Semester(int typeSelector, String typeString) {
        this.typeSelector = typeSelector;
        this.typeString = typeString;
    }

    public int getTypeSelector() {
        return typeSelector;
    }

    public String getTypeString() {
        return typeString;
    }

    public static Semester fromSemester(int type) {
        for (Semester s : Semester.values()) {
            if (s.getTypeSelector() == type) {
                return s;
            }
        }
        return null;
    }
}
