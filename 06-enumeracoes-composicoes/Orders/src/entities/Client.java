import java.text.SimpleDateFormat;
import java.util.Date;

public class Client
{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private String Name;
    private String Email;
    private Date BirthDate;

    public Client(String Name, String Email, Date BirthDate) {
        this.Name = Name;
        this.Email = Email;
        this.BirthDate = BirthDate;
    }

    public Client() {}


    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getBirthDate() {
        return this.BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    @Override
	public String toString() {
		return Name + " (" + sdf.format(BirthDate) + ") - " + Email;
 	}
}
