import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Client Client;
    private Date Moment;
    private OrderStatus Status;
    private List<OrderItem> items = new ArrayList<>();


    public Order(Client Client, Date Moment, OrderStatus Status) {
        this.Client = Client;
        this.Moment = Moment;
        this.Status = Status;
    }

    public Order() {}


    public Client getClient() {
        return this.Client;
    }

    public void setClient(Client Client) {
        this.Client = Client;
    }

    public Date getMoment() {
        return this.Moment;
    }

    public void setMoment(Date Moment) {
        this.Moment = Moment;
    }

    public OrderStatus getStatus() {
        return this.Status;
    }

    public void setStatus(OrderStatus Status) {
        this.Status = Status;
    }

    public List<OrderItem> getItems() {
        return this.items;
    }

    public void AddItem(OrderItem item) {
        items.add(item);
    }

    public void RemoveItem(OrderItem item) {
        items.remove(item);
    }

    public Double Total() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.SubTotal();
        }

        return total;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
		sb.append("Order moment: ");
		sb.append(sdf.format(this.Moment) + "\n");
		sb.append("Order status: ");
		sb.append(this.Status + "\n");
		sb.append("Client: ");
		sb.append(this.Client + "\n");
        sb.append("Order items:\n");
        
		for (OrderItem item : items) {
			sb.append(item + "\n");
        }
        
		sb.append("Total price: $");
        sb.append(String.format("%.2f", this.Total()));
        
		return sb.toString();
	}
}
