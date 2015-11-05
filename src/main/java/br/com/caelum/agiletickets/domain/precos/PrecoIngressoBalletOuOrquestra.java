package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;

public class PrecoIngressoBalletOuOrquestra implements PrecoIngresso {

	@Override
	public BigDecimal calcula(Sessao sessao) {
		BigDecimal preco = sessao.getPreco();
		if(sessao.getPercentualIngressosDisponiveis() <= 0.50) { 
			preco = sessao.getPrecoComAgio(0.20);
		} 
		if(sessao.getDuracaoEmMinutos() > 60){
			 preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

}
