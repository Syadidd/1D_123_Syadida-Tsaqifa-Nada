//********************************************************************
// Rectangle.java
//
// Represents a rectangle shape.
//********************************************************************

public class Rectangle extends Shape {
    private double length;
    private double width;

    //-----------------------------------------------------------------
    // Constructor: Sets up the rectangle with given length and width.
    //-----------------------------------------------------------------
    public Rectangle (double length, double width) {
        super ("Rectangle");
        this.length = length;
        this.width  = width;
    }

    //-----------------------------------------------------------------
    // Returns the area of this rectangle (length x width).
    //-----------------------------------------------------------------
    @Override
    public double area() {
        return length * width;
    }

    //-----------------------------------------------------------------
    // Returns the rectangle as a String.
    //-----------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}
