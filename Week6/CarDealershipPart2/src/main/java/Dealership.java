import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;

        this.inventory = new ArrayList<>();
    }

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getByPrice(double min, double max)
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();

        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max)
            {
                searchResults.add(vehicle);
            }
        }

        return searchResults;
    }

    public ArrayList<Vehicle> getByMakeModel(String make, String model)
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        make = make.strip().toLowerCase();
        model = model.strip().toLowerCase();

        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getMake().toLowerCase().contains(make) &&
                    vehicle.getModel().toLowerCase().contains(model))
            {
                searchResults.add(vehicle);
            }
        }

        return searchResults;
    }

    public ArrayList<Vehicle> getByYear(int min, int max)
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();

        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getYear() >= min && vehicle.getYear() <= max)
            {
                searchResults.add(vehicle);
            }
        }

        return searchResults;
    }

    public ArrayList<Vehicle> getByColor(String color)
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();

        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getColor().equalsIgnoreCase(color.strip()))
            {
                searchResults.add(vehicle);
            }
        }

        return searchResults;
    }

    public ArrayList<Vehicle> getByMileage(int min, int max)
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();

        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getOdometer() >= min && vehicle.getOdometer() <= max)
            {
                searchResults.add(vehicle);
            }
        }

        return searchResults;
    }

    public ArrayList<Vehicle> getByType(String type)
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();

        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getType().equalsIgnoreCase(type.strip()))
            {
                searchResults.add(vehicle);
            }
        }

        return searchResults;
    }

    public ArrayList<Vehicle> getAllVehicles()
    {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle)
    {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle)
    {
        inventory.remove(vehicle);
    }

    public Vehicle findByVin(String vin)
    {
        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getVin().equalsIgnoreCase(vin))
            {
                return vehicle;
            }
        }

        return null;
    }
}
