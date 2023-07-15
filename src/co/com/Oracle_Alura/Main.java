package co.com.Oracle_Alura;

import co.com.Oracle_Alura.modelo.ConversorDeLongitud;
import co.com.Oracle_Alura.modelo.ConversorDeMasa;
import co.com.Oracle_Alura.modelo.ConversorDeMoneda;

public class Main {

	public static void main(String[] args) {
		
		ConversorDeMoneda ejem1 = new ConversorDeMoneda("USD", "COP", 32.9);
		System.out.println(ejem1.conversion());
		
		ConversorDeMoneda ejem2 = new ConversorDeMoneda("COP", "USD", 136908.74);
		System.out.println(ejem2.conversion());
		
		ConversorDeLongitud ejem3 = new ConversorDeLongitud("m", "km", 1000);
		System.out.println(ejem3.conversion());
		
		ConversorDeLongitud ejem4 = new ConversorDeLongitud("km", "m", 2.2);
		System.out.println(ejem4.conversion());
		
		ConversorDeMasa ejem5 = new ConversorDeMasa("kg", "g", 1000);
		System.out.println(ejem5.conversion());
		
		ConversorDeMasa ejem6 = new ConversorDeMasa("t", "kg", 2.2);
		System.out.println(ejem6.conversion());
		
		
	}

}
