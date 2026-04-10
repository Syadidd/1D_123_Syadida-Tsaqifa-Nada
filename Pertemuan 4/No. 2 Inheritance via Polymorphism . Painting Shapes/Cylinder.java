//********************************************************************
// Cylinder.java
//
// Represents a cylinder shape.
//********************************************************************

public class Cylinder extends Shape {
    private double radius;
    private double height;

    //-----------------------------------------------------------------
    // Constructor: Sets up the cylinder with given radius and height.
    //-----------------------------------------------------------------
    public Cylinder (double radius, double height) {
        super ("Cylinder");
        this.radius = radius;
        this.height = height;
    }

    //-----------------------------------------------------------------
    // Returns the surface area of this cylinder (PI * radius^2 * height).
    //-----------------------------------------------------------------
    @Override
    public double area() {
        return Math.PI * radius * radius * height;
    }

    //-----------------------------------------------------------------
    // Returns the cylinder as a String.
    //-----------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}

