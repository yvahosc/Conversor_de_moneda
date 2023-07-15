package co.com.Oracle_Alura.modelo;

import java.util.HashMap;
import java.util.Map;

public class ConversorDeMoneda extends Conversor{

	public ConversorDeMoneda(String unidadAConvertir, String unidadDeConversion, 
			double valorAConvertir) 
	{
		super(unidadAConvertir, unidadDeConversion, valorAConvertir, 
				establecerRelacionesDeConversion());
	}

	public static Map<String, Double> establecerRelacionesDeConversion() {
		Map<String, Double> relacionesDeConversionDeMoneda = new HashMap<String, Double>();
		relacionesDeConversionDeMoneda.put("USD", 4161.36);
		relacionesDeConversionDeMoneda.put("EUR", 4571.25);
		relacionesDeConversionDeMoneda.put("GBP", 5370.48);
		relacionesDeConversionDeMoneda.put("JPY", 29.68);
		relacionesDeConversionDeMoneda.put("KRW", 3.32);
		return relacionesDeConversionDeMoneda;
	}
	
	@Override
	public String conversion() {
		if(super.getUnidadAConvertir().equals("COP")) {
			super.setValorConvertido(super.getValorAConvertir() / super.getRelacionesDeConversion()
					.get(super.getUnidadDeConversion()));
		}else {
			super.setValorConvertido(super.getValorAConvertir() * super.getRelacionesDeConversion()
					.get(super.getUnidadAConvertir()));
		}
		return super.mensajeConversion();
	}
}
