import java.util.Date;

public class HourContract
{
    private Date Date;
    private Double ValuePerHour;
    private Integer Hours;
    
    public HourContract(Date Date, Double ValuePerHour, Integer Hours) {
        this.Date = Date;
        this.ValuePerHour = ValuePerHour;
        this.Hours = Hours;
    }
    
    public HourContract() {}

    public Double TotalValue() {
        return this.ValuePerHour * this.Hours;
    }

    public Date getDate() {
        return this.Date;
    }
    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Double getValuePerHour() {
        return this.ValuePerHour;
    }
    public void setValuePerHour(Double ValuePerHour) {
        this.ValuePerHour = ValuePerHour;
    }

    public Integer getHours() {
        return this.Hours;
    }
    public void setHours(Integer Hours) {
        this.Hours = Hours;
    }

}
