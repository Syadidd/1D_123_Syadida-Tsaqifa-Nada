public class Square extends Rectangle {
    //constructor
    public Square() {
        super();
    }
    //Petunjuk
    public Square(double side) {
        super(side, side); // Call superclass Rectangle(double, double)
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    //get set side
    public double getSide() {
        return getWidth();
    }
    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    //set width length
    @Override
    public void setWidth(double side) {
        setSide(side); // memanggil setSide agar length ikut berubah
    }
    @Override
    public void setLength(double side) {
        setSide(side); // memanggil setSide agar width ikut berubah
    }

    //override toString
    @Override
    public String toString() {
        return "A Square with side= " + getSide()
                + ", which is a subclass of " + super.toString();
    }
}

