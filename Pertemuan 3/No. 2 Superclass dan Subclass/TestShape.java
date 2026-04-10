public class TestShape {
    public static void main(String[] args) {

        //uji constructor 1
        Shape s1 = new Shape();
        System.out.println(s1);
        //uji contructor 2
        Shape s2 = new Shape("hitam", false);
        System.out.println(s2);

        //uji setter getter
        s1.setColor("biru");
        s1.setFilled(true);
        System.out.println(s1);
    }
}
