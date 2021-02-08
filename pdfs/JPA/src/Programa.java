import dominio.Pessoa;

public class Programa {
    public static void main(String[] args) throws Exception {

        Pessoa p1 = new Pessoa(1, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(1, "Marcos Edgar Pereia", "mep@hotmail.com");
        Pessoa p3 = new Pessoa(1, "Josenyr Gonçalves", "jgoncalves@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}