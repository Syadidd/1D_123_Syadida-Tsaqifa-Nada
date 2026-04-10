public class Circle extends Shape {
    //variabel
    private double radius;

    //getter setter
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //constructor 1
    public Circle() {
        radius = 1.0;
    }
    //constructor 2
    public Circle(double r) {
        radius = r;
    }
    //constructor 3
    public Circle(double r, String c, boolean f) {
        super(c, f);
        radius = r;
    }
    //metode getArea()
    public double getArea() {
        return Math.PI * radius * radius;
    }
    //metode double getPerimeter()
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }
    //metode timpa toString()
    @Override
    public String toString() {
        return "A Circle with radius= " + radius
                + ", which is a subclass of " + super.toString();
    }
}
