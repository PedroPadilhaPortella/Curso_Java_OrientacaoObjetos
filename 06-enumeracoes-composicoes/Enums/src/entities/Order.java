package entities;

import java.util.Date;

public class Order {
    
    private Integer Id;
    private Date Moment;
    private OrderStatus Status;

    public Order() {}
    public Order(Integer id, Date moment, OrderStatus status) {
        this.Id = id;
        this.Moment = moment;
        this.Status = status;
    }

    public Integer getId() {
        return this.Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }

    public Date getMoment() {
        return this.Moment;
    }
    public void setMoment(Date moment) {

        this.Moment = moment;
    }
    
    public OrderStatus getStatus() {
        return this.Status;
    }
    public void setStatus(OrderStatus status) {
        this.Status= status;
    }

    @Override
    public String toString() {
        return "Id = '" + getId() + "',\nMoment = '" + getMoment() + "'\nStatus = '" + getStatus() + "'";
    }
}
