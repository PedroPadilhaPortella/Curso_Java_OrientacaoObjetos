package services;

import models.Produto;
import notificador.*;
import models.Cliente;

public class EmissaoNotaFiscalService {

    private Notificador notificador;

    public EmissaoNotaFiscalService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void emitir(Cliente cliente, Produto produto) {
        notificador.notificar(cliente, "Nota fiscal do produto" + produto.getNome() + " foi emitida");
    }
}