package co.com.Oracle_Alura.modelo;

import java.util.HashMap;
import java.util.Map;

public class ConversorDeMasa extends Conversor{
	
	public ConversorDeMasa(String unidadAConvertir, String unidadDeConversion, 
			double valorAConvertir) 
	{
		super(unidadAConvertir, unidadDeConversion, valorAConvertir, 
				establecerRelacionesDeConversion());
	}
	
	public static Map<String, Double> establecerRelacionesDeConversion() {
		Map<String, Double> relacionesDeConversionDeMoneda = new HashMap<String, Double>();
		relacionesDeConversionDeMoneda.put("mg", 0.000001);
		relacionesDeConversionDeMoneda.put("g", 0.001);
		relacionesDeConversionDeMoneda.put("t", 1000.0);
		return relacionesDeConversionDeMoneda;
	}
	
	@Override
	public String conversion() {
		if(super.getUnidadAConvertir().equals("kg")) {
			super.setValorConvertido(super.getValorAConvertir() / super.getRelacionesDeConversion()
					.get(super.getUnidadDeConversion()));
		}else {
			super.setValorConvertido(super.getValorAConvertir() * super.getRelacionesDeConversion()
					.get(super.getUnidadAConvertir()));
		}
		return super.mensajeConversion();
	}

}
