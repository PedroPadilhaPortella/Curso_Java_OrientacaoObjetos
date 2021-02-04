import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
    
        Object obj;
        Integer x = 10;
        obj = x;
        System.out.println(obj);

        //Tipos Coringa (Wildcars type), que representa um método genérico de qualquer tipo;

        List<?> myObjs = new ArrayList<Object>();
        List<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(3);
        myObjs = myNumbers;
        System.out.println(myObjs);

        //Podemos usar este tipo para casos em que não sabemos o tipo de dado que será passado ou instanciado.

        List<Integer> myInts = Arrays.asList(5, 2, 10);
        printList(myInts);

        List<String> myStrs = Arrays.asList("Maria", "Alex", "Bob");
        printList(myStrs);

        //Porém listas de qualquer tipo não podem adicionar dados, pois eles não tem nenhum tipo definido;
    }

    
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + "  ");
        }
    }
}
