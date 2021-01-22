public class App {
    public static void main(String[] args) throws Exception {
        //Object é o tipo mais primito do Java, pai de todos os tipos numericos, do boleano e char
        //As wrapper classes são as classes equivalentes aos tipos primitivos, e aceitam null e possuem POO.
        int x = 20;
        // Object obj = x;
        Integer obj = x;
        System.out.println(obj);
        // int y = (int) obj;
        int y = obj;
        System.out.println(y);


    }
}
