package notificador;

import models.Cliente;

public class NotificadorEmail implements Notificador {
    
    @Override
    public void notificar(Cliente cliente, String message) {
        System.out.printf("Notificando %s através do email %s: %s\n",
            cliente.getNome(), cliente.getEmail(), message);
    }
}
