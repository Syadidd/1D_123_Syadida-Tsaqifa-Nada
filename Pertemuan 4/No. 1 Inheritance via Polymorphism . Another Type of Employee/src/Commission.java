public class Commission extends Hourly
{
    private double totalSales;
    private double commissionRate; // decimal form (e.g., 0.20 = 20%)

    //-----------------------------------------------------------------
    //  Sets up a commission employee using the specified information.
    //-----------------------------------------------------------------
    public Commission(String eName, String eAddress, String ePhone,
                      String socSecNumber, double rate,
                      double commissionRate)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        this.totalSales = 0.0;
    }

    //-----------------------------------------------------------------
    //  Adds the specified sales amount to this employee's total sales.
    //-----------------------------------------------------------------
    public void addSales(double sales)
    {
        totalSales += sales;
    }

    //-----------------------------------------------------------------
    //  Computes and returns the pay for this commission employee.
    //  Hourly pay + commission. Sales reset after payment.
    //-----------------------------------------------------------------
    @Override
    public double pay()
    {
        double payment = super.pay() + (totalSales * commissionRate);
        totalSales = 0.0;
        return payment;
    }

    //-----------------------------------------------------------------
    //  Returns information about this commission employee.
    //-----------------------------------------------------------------
    @Override
    public String toString()
    {
        return super.toString() +
                "\nTotal Sales: " + totalSales +
                "\nCommission Rate: " + commissionRate;
    }
}
