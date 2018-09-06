package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1);
		conta.setTitular("Danilo");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("123");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		conta = em.find(Conta.class, 1);
		em.remove(conta);
		
		conta.setBanco("Bradesco");
		
		em.getTransaction().commit();
		em.close();

		/*
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		conta.setTitular("Leonardo");
		em2.merge(conta);
		
				
		em2.getTransaction().commit();
		em2.close();
		*/
	}
}
