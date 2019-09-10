package exercicios;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Calendario {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println(sdf.format(d));
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(d);
		calendario.add(Calendar.HOUR_OF_DAY, 4);
		d  = calendario.getTime();
		
		int minutos = calendario.get(Calendar.MINUTE);
		int mes = 1 +calendario.get(Calendar.MONTH);
		
		System.out.println(sdf.format(d));
		System.out.println("Minutos: "+minutos);
		System.out.println("Mês: "+mes);

	}

}
