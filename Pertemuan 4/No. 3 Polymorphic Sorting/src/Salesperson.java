// *******************************************************
// Salesperson.java
//
// Represents a sales person who has a first name, last
// name, and total number of sales.
// *******************************************************

public class Salesperson implements Comparable
{
    private String firstName, lastName;
    private int totalSales;

    //------------------------------------------------------
    // Constructor: Sets up the sales person object with
    // the given data.
    //------------------------------------------------------
    public Salesperson (String first, String last, int sales)
    {
        firstName  = first;
        lastName   = last;
        totalSales = sales;
    }

    //-------------------------------------------
    // Returns the sales person as a string.
    //-------------------------------------------
    public String toString()
    {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    //-------------------------------------------
    // Returns true if the sales people have
    // the same name.
    //-------------------------------------------
    public boolean equals (Object other)
    {
        return (lastName.equals (((Salesperson) other).getLastName()) &&
                firstName.equals (((Salesperson) other).getFirstName()));
    }

    //--------------------------------------------------
    // Order is based on total sales (ascending).
    // Name (last, then first) breaks a tie.
    // Returns negative if this < other (less sales)
    // Returns positive if this > other (more sales)
    //--------------------------------------------------
    public int compareTo (Object other)
    {
        Salesperson otherPerson = (Salesperson) other;
        int result;

        // Compare by total sales first
        result = this.totalSales - otherPerson.totalSales;

        // If tied, compare by last name
        if (result == 0)
            result = this.lastName.compareTo (otherPerson.lastName);

        // If still tied, compare by first name
        if (result == 0)
            result = this.firstName.compareTo (otherPerson.firstName);

        return result;
    }

    //-------------------------
    // First name accessor.
    //-------------------------
    public String getFirstName()
    {
        return firstName;
    }

    //-------------------------
    // Last name accessor.
    //-------------------------
    public String getLastName()
    {
        return lastName;
    }

    //-------------------------
    // Total sales accessor.
    //-------------------------
    public int getSales()
    {
        return totalSales;
    }
}
