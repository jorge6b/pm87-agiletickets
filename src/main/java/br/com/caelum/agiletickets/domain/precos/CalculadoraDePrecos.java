package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {
	private static Map<TipoDeEspetaculo, PrecoIngresso> MAP_CALCULATORS = new  HashMap<TipoDeEspetaculo, PrecoIngresso>();
	static{
		MAP_CALCULATORS.put(TipoDeEspetaculo.CINEMA, new PrecoIngressoCinemaOuShow());
		MAP_CALCULATORS.put(TipoDeEspetaculo.SHOW, new PrecoIngressoCinemaOuShow());
		MAP_CALCULATORS.put(TipoDeEspetaculo.BALLET, new PrecoIngressoBalletOuOrquestra());
		MAP_CALCULATORS.put(TipoDeEspetaculo.ORQUESTRA, new PrecoIngressoBalletOuOrquestra());
	}

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco = sessao.getPreco();
		
		PrecoIngresso pi = MAP_CALCULATORS.get(sessao.getEspetaculo().getTipo());
		if (pi != null) {
			preco = pi.calcula(sessao);
		} 
		
		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

}