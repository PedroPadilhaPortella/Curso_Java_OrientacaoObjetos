public class Employee 
{
    private String Name;
    private Integer Hours;
    private Double ValuePerHour;

    public Employee() {}


    public Employee(String name, Integer hours, Double valuePerHour) {
        this.Name = name;
        this.Hours = hours;
        this.ValuePerHour = valuePerHour;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getHours() {
        return this.Hours;
    }

    public void setHours(Integer Hours) {
        this.Hours = Hours;
    }

    public Double getValuePerHour() {
        return this.ValuePerHour;
    }

    public void setValuePerHour(Double ValuePerHour) {
        this.ValuePerHour = ValuePerHour;
    }

    public double payment() {
        return this.Hours * this.ValuePerHour;
    }
}
