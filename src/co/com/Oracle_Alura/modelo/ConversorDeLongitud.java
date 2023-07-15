package co.com.Oracle_Alura.modelo;

import java.util.HashMap;
import java.util.Map;

public class ConversorDeLongitud extends Conversor{
	
	public ConversorDeLongitud(String unidadAConvertir, String unidadDeConversion, 
			double valorAConvertir) 
	{
		super(unidadAConvertir, unidadDeConversion, valorAConvertir, 
				establecerRelacionesDeConversion());
	}
	
	public static Map<String, Double> establecerRelacionesDeConversion() {
		Map<String, Double> relacionesDeConversionDeMoneda = new HashMap<String, Double>();
		relacionesDeConversionDeMoneda.put("mm", 0.001);
		relacionesDeConversionDeMoneda.put("cm", 0.01);
		relacionesDeConversionDeMoneda.put("km", 1000.0);
		return relacionesDeConversionDeMoneda;
	}

	@Override
	public String conversion() {
		if(super.getUnidadAConvertir().equals("m")) {
			super.setValorConvertido(super.getValorAConvertir() / super.getRelacionesDeConversion()
					.get(super.getUnidadDeConversion()));
		}else {
			super.setValorConvertido(super.getValorAConvertir() * super.getRelacionesDeConversion()
					.get(super.getUnidadAConvertir()));
		}
		return super.mensajeConversion();
	}
}
