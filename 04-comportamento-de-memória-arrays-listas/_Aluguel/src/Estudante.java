public class Estudante {
    private String Nome;
    private String Email;
        
    public Estudante(String nome, String email) {
        Nome = nome;
        Email = email;
    }

    public String toString() {
        return Nome + ", " + Email;
    }

    public String getNome() {
        return this.Nome;
    }
    public void setNome(String nome) {
        this.Nome = nome;
    }
    public String getEmail() {
        return this.Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
}