package models;

import java.math.BigDecimal;

public class Produto {
    
    private String nome;
    private BigDecimal valorTotal;

    public Produto(String nome, BigDecimal valorTotal) {
        this.nome = nome;
        this.valorTotal = valorTotal;
    }

    public String getNome() { return this.nome; }
    public BigDecimal getValorTotal() { return this.valorTotal; }
}
