import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<String> lista = new ArrayList<String>();

        //Addicionar e Adicionar em posição especifica
        lista.add("Pedro");
        lista.add("Daniel");
        lista.add("Edwin");
        lista.add("Bunhak");
        
        lista.add(2, "Casalli");
        lista.add(3, "Vinicius");
        lista.add(5, "Matheus");
        lista.add(6, "Calebe");

        //Remover, remover em posição especifica e remover de acordo com uma expressão
        lista.remove("Bunhak");
        lista.remove(3);
        lista.removeIf(x -> x.charAt(0) == 'M');

        
        for(String pessoa : lista) {
            System.out.print(pessoa + ", ");
        }

        System.out.println("\nTamanho da Lista: " + lista.size());
        System.out.println("Index of Pedro: " + lista.indexOf("Pedro"));
        System.out.println("Index of Matheus: "+ lista.indexOf("Matheus") +", (não existe)\n------------");

        //Usando filtro, stream e conversão de tipo com collectors
        List<String> startsC = lista.stream().filter(x -> x.charAt(0) == 'C').collect(Collectors.toList());
        
        System.out.print("Starts with C: ");
        for (String string : startsC) {
            System.out.print(string + ", ");
        }

        //encontrar o primeiro elemento que atende a uma condição
        String name = lista.stream().filter(x -> x.charAt(0) == 'D').findFirst().orElse(null);
        System.out.println("Primeiro elemento que começa com D: " + name);
        name = lista.stream().filter(x -> x.charAt(0) == 'L').findFirst().orElse("(não encontrado)");
        System.out.println("Primeiro elemento que começa com L: " + name);
    }
}
