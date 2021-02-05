import models.Cliente;
import notificador.*;
import services.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Cliente joao = new Cliente("João Casalli", "casalli@gmail.com", "43932144212");
        Cliente max = new Cliente("Maxel Udson", "maxxx@gmail.com", "4566732554");

        AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(new NotificadorEmail());
        ativacaoCliente.ativar(joao);
        ativacaoCliente.ativar(max);
        
        ativacaoCliente = new AtivacaoClienteService(new NotificadorSMS());
        ativacaoCliente.ativar(joao);
        ativacaoCliente.ativar(max);
    }
}
