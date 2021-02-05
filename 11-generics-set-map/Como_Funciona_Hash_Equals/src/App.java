import entities.Cliente;

public class App {
    public static void main(String[] args) throws Exception {
    
        /*
        hashCode e Equals
        São operacoes da classe Object usadas para comparar se um obejto é igual a outro.
        Equals, lento mas 100%, hashCode, rápido, mas pode não ser 100%.
        Os tipos primitivos(String, Date, Integer, Double, etc.) já possuem implementação dessas operações,
        mas quando criamos nossas próprias classes, precisamos implementar o metodo de acordo com a necessidade.
        */

        String a = "Maria";
        String b = "Maria";
        String c = "Jose";

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        Cliente c1 = new Cliente("Maria", "maria@gmail.com");
        Cliente c2 = new Cliente("Maria", "maria@gmail.com");
        Cliente c3 = new Cliente("Jose", "jose@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1 == c2); //dá false porque a referencia deles são diferentes;
    }
}
