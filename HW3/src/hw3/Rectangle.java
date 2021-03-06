/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.Scanner;

/**
 * overides Shapes getArea, getParim calculates area, parimeter and validates if
 * arguments passed can be the shape
 *
 * @author kamonson17
 */
public class Rectangle extends Shapes {

    private int width;
    private int height;

    Rectangle() {
        width = 0;
        height = 0;
    }

    Rectangle(int width, int height) {
        if ((width == 0) || (height == 0)) {
            throw new IllegalArgumentException();
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;

    }

    @Override
    public double getParim() {
        return (width * 2) + (height * 2);
    }
}
