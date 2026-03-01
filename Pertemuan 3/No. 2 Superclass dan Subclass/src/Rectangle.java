public class Rectangle extends Shape {
    //variabel
    private double width;
    private double length;

    //getter setter
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    //constructor 1
    public Rectangle() {
        width = 1.0;
        length = 1.0;
    }
    //constructor 2
    public Rectangle(double w, double l) {
        width = w;
        length = l;
    }
    //constructor 3
    public Rectangle(double w, double l, String c, boolean f) {
        super(c, f);
        width = w;
        length = l;
    }
    //metode getArea()
    public double getArea() {
        return width * length;
    }
    //metode getPerimeter()
    public double getPerimeter() {
        return width * 2 + length * 2;
    }
    //metode toString()
    @Override
    public String toString() {
        return "A Rectangle with width= " + width
                + " and length= " + length
                + ", which is a subclass of " + super.toString();
    }
}
