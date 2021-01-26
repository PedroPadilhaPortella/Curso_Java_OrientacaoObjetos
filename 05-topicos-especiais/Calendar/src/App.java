import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
    
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

        System.out.println(sdf.format(d));

        Calendar cal = Calendar.getInstance(); //Instância de calendario
        cal.setTime(d); //Calendario com uma data instanciada
        int minutes = cal.get(Calendar.MINUTE);
        int month = 1 + cal.get(Calendar.MONTH);
        cal.add(Calendar.HOUR_OF_DAY, 4); //Adicionando 4 horas
        d = cal.getTime(); //retornando o resultado

        System.out.println(sdf.format(d));
        System.out.println("MINUTES: " + minutes);
        System.out.println("MONTH: " + month);
    }
}