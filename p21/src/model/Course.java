/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author NguyenDucAnh
 */
public enum Course {
    JAVA(1, "Java"),
    PYTHON(2, "Python"),
    NET(3, ".Net");

    private int typeSelector;
    private String typeString;

    private Course(int typeSelector, String typeString) {
        this.typeSelector = typeSelector;
        this.typeString = typeString;
    }

    public int getTypeSelector() {
        return typeSelector;
    }

    public String getTypeString() {
        return typeString;
    }

    public static Course fromCourse(int type) {
        for (Course c : Course.values()) {
            if (c.getTypeSelector() == type) {
                return c;
            }
        }
        return null;
    }
}
