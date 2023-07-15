package co.com.Oracle_Alura.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Conversor {
	
	private String unidadAConvertir;
	private String unidadDeConversion;
	private double valorConvertido;
	private double valorAConvertir;
	private Map<String, Double> relacionesDeConversion = new HashMap<String, Double>();
	
	public Conversor(String unidadAConvertir, String unidadDeConversion, double valorAConvertir,
			Map<String, Double> relacionesDeConversion) {
		this.unidadAConvertir = unidadAConvertir;
		this.unidadDeConversion = unidadDeConversion;
		this.valorAConvertir = valorAConvertir;
		this.relacionesDeConversion = relacionesDeConversion;
	}

	public String getUnidadAConvertir() {
		return unidadAConvertir;
	}

	public void setUnidadAConvertir(String unidadAConvertir) {
		this.unidadAConvertir = unidadAConvertir;
	}

	public String getUnidadDeConversion() {
		return unidadDeConversion;
	}

	public void setUnidadDeConversion(String unidadDeConversion) {
		this.unidadDeConversion = unidadDeConversion;
	}

	public double getValorConvertido() {
		return valorConvertido;
	}

	public void setValorConvertido(double valorConvertido) {
		this.valorConvertido = valorConvertido;
	}

	public double getValorAConvertir() {
		return valorAConvertir;
	}

	public void setValorAConvertir(double valorAConvertir) {
		this.valorAConvertir = valorAConvertir;
	}

	public Map<String, Double> getRelacionesDeConversion() {
		return relacionesDeConversion;
	}

	public void setRelacionesDeConversion(Map<String, Double> relacionesDeConversion) {
		this.relacionesDeConversion = relacionesDeConversion;
	}
	
	public String mensajeConversion() {
		return this.valorAConvertir + " " + this.unidadAConvertir + " equivalen a: " + 
				this.valorConvertido + " " + this.unidadDeConversion;
	}
	
	public abstract String conversion();
}
