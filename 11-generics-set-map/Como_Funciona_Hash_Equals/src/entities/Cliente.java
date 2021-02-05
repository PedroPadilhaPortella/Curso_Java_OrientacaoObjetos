package entities;

import java.util.Objects;

public class Cliente {
    
    private String Name;
    private String Email;


    public Cliente(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }

    public String getName() { return this.Name; }
    public void setName(String Name) { this.Name = Name; }

    public String getEmail() { return this.Email; }
    public void setEmail(String Email) { this.Email = Email; }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        
        if (!(o instanceof Cliente))
            return false;

        Cliente cliente = (Cliente) o;
        return Objects.equals(Name, cliente.Name) && Objects.equals(Email, cliente.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Email);
    }
}