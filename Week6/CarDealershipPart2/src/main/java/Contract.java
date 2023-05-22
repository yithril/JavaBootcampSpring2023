import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Contract
{
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;

    public Contract(LocalDate date, String customerName, String customerEmail, Vehicle vehicle)
    {
        this.date = date.format(DateTimeFormatter.ISO_DATE).replace("-","");
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail)
    {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();

    @Override
    public String toString()
    {
        return String.format("%s|%s|%s|%s",date, customerName, customerEmail, vehicle);
    }
}
