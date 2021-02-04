package entities;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    
    private List<T> lista = new ArrayList<>();

    public void addValue(T value) {
        lista.add(value);
    }

    public T first() {
        if(lista.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return lista.get(0);
    }

    public void print() {
        System.out.print("[");

        if(!lista.isEmpty())
            System.out.print(lista.get(0));

        for (int i = 1; i < lista.size(); i++)
            System.out.print(", " + lista.get(i));

        System.out.println("]");
    }
}
