package entities;

import java.util.Date;
import java.util.Objects;

public class User {
    
    private String Username;
    private Date Moment;

    public User(String Username, Date Moment) {
        this.Username = Username;
        this.Moment = Moment;
    }
    

    public String getUsername() { return this.Username; }

    public void setUsername(String Username) { this.Username = Username; }

    public Date getMoment() { return this.Moment; }

    public void setMoment(Date Moment) { this.Moment = Moment; }


    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User))  return false;
        if (getClass() != o.getClass())  return false;
        
        User user = (User) o;
        return Objects.equals(Username, user.Username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Username);
    }

    @Override
    public String toString() {
        return "\n[ Username = '" + getUsername() + "', Moment='" + getMoment() + "']";
    }
}