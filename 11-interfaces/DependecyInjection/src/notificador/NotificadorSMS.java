package notificador;

import models.Cliente;

public class NotificadorSMS implements Notificador {
    
    @Override
    public void notificar(Cliente cliente, String message) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n", 
            cliente.getNome(), cliente.getTelefone(), message);
    }
}
