import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Covariancia_Contravariancia {
    public static void main(String[] args) throws Exception {

        /*
        * Covariância:
		 * Classes que herdam de Number:
		 * byte - short - int - long - float - double
         * 
         * Listas destes tipos podem ser copiadas para a variável que possui o coringa
         * estendendo a classe Number.
         * 
         * Em covariancia, o coringa pode copiar itens de uma classe X, ou de uma classe
         * que estende X.
         * 
         * Em covariancia, somente podemos utilizar getters na lista com o coringa. Não
         * podemos adicionar itens.
         * 
         * Pois, o compilador não sabe se o item que, hipoteticamente, poderia ser
         * inserido na lista coringa, seria compatível(por causa da especificação).
         * 
		 */
        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        intList.add(63);
 
        // Covariancia:
        List<? extends Number> list = intList;
		Number x = list.get(0);
		System.out.println(x);
		// list.add(20); -> Não podem ocorrer setters em covariancias.
 
		// ------------------------------------------------------------------------------
        
		/*
        * Contravariância:
        * Super classe de Number:
        * Object
        * 
        * Em contravariância, podemos copiar os dados de uma lista X para um coringa
        * que, ou é do tipo X, ou é de alguma super classe de X.
        * 
        * Podemos adicionar itens na lista do coringa.
        * 
        * Não podemos utilizar getters e guardar o retorno em alguma variável. 
        */
        
		List<Object> myObjcts = new ArrayList<>();
		myObjcts.add("Maria");
		myObjcts.add("Henrique");

		List<? super Number> myNums = myObjcts;
		myNums.add(0);
		myNums.add(20);
		
        //Retorno para uma variavel do tipo Object.
		//Number y = myNums.get(0);
		Object z = myNums.get(3);
		System.out.println(z);

        /*
        
        */

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) 
    {
        for (Number number : source) {
            destiny.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object object : list) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}
