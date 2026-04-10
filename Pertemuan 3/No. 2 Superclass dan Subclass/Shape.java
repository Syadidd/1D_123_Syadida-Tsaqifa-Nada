public class Shape {
    //variabel
    private String color;
    private boolean filled;

    //getter setter
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    //constructor 1
    public Shape() {
        color = "green";
        filled = true;
    }
    //constructor 2
    public Shape(String c, boolean f) {
        color = c;
        filled = f;
    }

    //metode toString()
    public String toString() {
        return "A Shape with color of " + color
                + "and filled:" + filled;
    }
}
