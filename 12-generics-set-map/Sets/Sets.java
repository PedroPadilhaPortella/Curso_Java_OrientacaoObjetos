import java.util.*;

public class Sets {
    public static void main(String[] args) {
        
        /*
            Set<T>

            * não admite repedição
            * não indexado, ou seja, não dá pra acessar as posições
            * permite acesso, inserção e remoção de elementos
            * oferece operações de conjunto (intersecao, uniao, diferenca)
            * 
                HashSet: mais rápido e não ordenado, busca elementos com base nos valores, e não no index.
                TreeSet: mais lento, ordena os elementos com base no Comparator (compareTo) ou pela referencia.
                LinkedHashSet: os elementos ficam na ordem que foram adicionados, busca elementos pelo valor.
        */

        //HashSet
        Set<String> set = new HashSet<>();
        set.add("TV");
        set.add("Notebook");
        set.add("IPhone");
        set.add("Oven");
        set.remove("Oven");
        set.removeIf(x -> x.charAt(0) == 'T');

        System.out.println("Contém notebook :" + set.contains("Notebook"));

        for (String p : set)
            System.out.print(p + "  ");
        System.out.println();


        //TreeSet
        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        //union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println("Union: " + c);

        //intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println("Intersection: " + d);

        //difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println("Difference: " + e);
    }
}
