package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class PrecoIngressoCinemaOuShow implements PrecoIngresso {

	@Override
	public BigDecimal calcula(Sessao sessao) {
		BigDecimal preco = sessao.getPreco();
		if(sessao.getPercentualIngressosDisponiveis() <= 0.05) { 
			preco = sessao.getPrecoComAgio(0.10);
		} 
		return preco;
	}

	

}
