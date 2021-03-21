package notificador;

import models.Cliente;

public interface Notificador {
    
    void notificar(Cliente cliente, String message);
}
