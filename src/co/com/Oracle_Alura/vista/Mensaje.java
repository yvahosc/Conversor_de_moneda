package co.com.Oracle_Alura.vista;

import javax.swing.JOptionPane;

public class Mensaje {
	
	public static String mostrarMensajeConOpciones(String mensaje, String opciones[]) {
		return JOptionPane.showInputDialog(null, mensaje, "Menú", JOptionPane.DEFAULT_OPTION, 
				null, opciones, opciones[0]).toString();
	}
	
	public static void mostrarMensajeResultado(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public static String mostrarMensajeConCampoIngresoDato(String mensaje) {
		return JOptionPane.showInputDialog(mensaje);
	}
	
	public static String validacionRespuestaMensajeConOpciones(String mensaje, String opciones[]) {
		String opcion;
		try {
			opcion = Mensaje.mostrarMensajeConOpciones(mensaje, opciones);
		} catch(Exception e) {
			opcion = "finalizar";
		}
		return opcion;
	}
	
	public static double validacionRespuestaMensajeConCampoIngresoDato(String mensaje) {
		boolean opcionValida = false;
		double valor = 0;
		while(!opcionValida) {
			try {
				valor = Double.valueOf(Mensaje.mostrarMensajeConCampoIngresoDato(mensaje));
				if(valor < 0) {
					throw new ArithmeticException("Ingrese un valor válido. Un número positivo.");
				}
				System.out.println(valor);
				opcionValida = true;
			} catch(NumberFormatException e) {
				Mensaje.mostrarMensajeResultado("Ingrese un valor válido. Un número.");
			} catch(ArithmeticException e) {
				Mensaje.mostrarMensajeResultado(e.getMessage());
			}  catch(NullPointerException e) {
				valor = -1;
				opcionValida = true;
			}
		}
		return valor;
	}
	
	public static int mostrarMensajeSiONo(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje);
	}	
}
