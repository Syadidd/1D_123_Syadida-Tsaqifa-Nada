//********************************************************************
// Shape.java
//
// Abstract class representing a generic shape.
//********************************************************************

public abstract class Shape {
    private String shapeName;

    //-----------------------------------------------------------------
    // Sets up the shape with the given name.
    //-----------------------------------------------------------------
    public Shape (String name) {
        shapeName = name;
    }

    //-----------------------------------------------------------------
    // Returns the area of this shape (to be defined by subclasses).
    //-----------------------------------------------------------------
    public abstract double area();

    //-----------------------------------------------------------------
    // Returns the name of this shape.
    //-----------------------------------------------------------------
    @Override
    public String toString() {
        return shapeName;
    }
}
