package co.com.Oracle_Alura.controlador;

import javax.swing.JOptionPane;
import co.com.Oracle_Alura.modelo.Conversor;
import co.com.Oracle_Alura.modelo.ConversorDeLongitud;
import co.com.Oracle_Alura.modelo.ConversorDeMasa;
import co.com.Oracle_Alura.modelo.ConversorDeMoneda;
import co.com.Oracle_Alura.vista.Mensaje;

public class EjecucionConversor {
	
	public static void ejecutarConversor() {
		
		boolean appEncendida = true;
		String opcionMenuPpal = "";
		String[] opcionesMenuPrincipal = {"Moneda", "Longitud", "Masa"};
		String[] opcionesConversionMonedas = {"COP a USD", "COP a EUR", "COP a GBP", "COP a JPY", "COP a KRW", 
				"USD a COP", "EUR a COP", "GBP a COP", "JPY a COP", "KRW a COP"};
		String[] opcionesConversionLongitudes = {"m  a  mm", "m  a  cm", "m  a  km", "mm  a  m", "cm  a  m", "km  a  m"};
		String[] opcionesConversionMasas = {"kg  a  mg", "kg  a  g", "kg  a  t", "mg  a  kg", "g  a  kg", "t  a  kg"};
		
		while(appEncendida) {
			
			opcionMenuPpal = Mensaje.validacionRespuestaMensajeConOpciones("Elije el tipo de conversor a utilizar:", 
					opcionesMenuPrincipal);

			switch(opcionMenuPpal) {
				case "Moneda":
					EjecucionConversor.conversion(opcionesConversionMonedas, opcionMenuPpal);
				break;
					
				case "Longitud":
					EjecucionConversor.conversion(opcionesConversionLongitudes, opcionMenuPpal);
					break;
				
				case "Masa":
					EjecucionConversor.conversion(opcionesConversionMasas, opcionMenuPpal);
					break;
					
				case "finalizar":
					preguntarSobreFinalizarPrograma();
			}
		}	
	}
	
	public static void conversion(String[] opcionesConversion, String tipoConversion) {
		
		String opcionConversion = "";
		boolean conversionEnProceso = true;
		boolean peticionValorAConvertirEnProceso = true;
		
		while(conversionEnProceso) {
			
			opcionConversion = Mensaje.validacionRespuestaMensajeConOpciones("Elije la conversion a realizar:",
					opcionesConversion);

			switch(opcionConversion) {
			
				case "finalizar":
					preguntarSobreFinalizarPrograma();
				break;
					
				default:
					
					String unidadAConvertir = opcionConversion.substring(0, 3).trim();
					String unidadDeConversion = opcionConversion.substring(opcionConversion.length() - 4, 
							opcionConversion.length()).trim();
					
					while(peticionValorAConvertirEnProceso) {
						
						double valorAConvertir = Mensaje.validacionRespuestaMensajeConCampoIngresoDato(
								"Ingrese los " + unidadAConvertir + " que desea convertir a " + unidadDeConversion);
						
						if(valorAConvertir != -1) {
							System.out.println(unidadAConvertir);
							System.out.println(unidadDeConversion);
							System.out.println(valorAConvertir);
							
							Conversor conversion = null;
							
							switch(tipoConversion) {
							
								case "Moneda":
									conversion = new ConversorDeMoneda(unidadAConvertir, unidadDeConversion, valorAConvertir);
								break;
								
								case "Longitud":
									conversion = new ConversorDeLongitud(unidadAConvertir, unidadDeConversion, valorAConvertir);
								break;
								
								case "Masa":
									conversion = new ConversorDeMasa(unidadAConvertir, unidadDeConversion, valorAConvertir);
								break;
							}
							 
							Mensaje.mostrarMensajeResultado(conversion.conversion());
							
							int retornar = volverMenuPrograma();
							
							switch(retornar) {
							
								case JOptionPane.YES_OPTION:
									peticionValorAConvertirEnProceso = false;
									conversionEnProceso = false;
								break;
								
								case JOptionPane.NO_OPTION:
									finalizarPrograma();
								break;
								
								default:
									preguntarSobreFinalizarPrograma();
							}
							
						}else {
							preguntarSobreFinalizarPrograma();
						}
					}
				break;
			}
		}
	}
	
	public static void preguntarSobreFinalizarPrograma() {
		
		int respuesta = Mensaje.mostrarMensajeSiONo("¿Desea finalizar el programa?");
		
		if (respuesta == JOptionPane.YES_OPTION) {
			Mensaje.mostrarMensajeResultado("Finalizando programa.");
			Mensaje.mostrarMensajeResultado("Programa Finalizado.");
			System.exit(0);
		}
	}
	
	public static void finalizarPrograma() {
		
		Mensaje.mostrarMensajeResultado("Finalizando programa.");
		
		Mensaje.mostrarMensajeResultado("Programa Finalizado.");
		
		System.exit(0);
	}
	
	public static int volverMenuPrograma() {
		
		int respuesta = Mensaje.mostrarMensajeSiONo("¿Desea volver al menú inicial?");
		
		return respuesta;
	}
}
