package com.vunter.EstruturaDeDados.main;

import com.vunter.EstruturaDeDados.Vetor;

public class Aula03 {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(2);

		Contato c1 = new Contato("Contato1", "11234-1234", "contato1@email");
		Contato c2 = new Contato("Contato2", "12234-1234", "contato2@email");
		Contato c3 = new Contato("Contato3", "12334-1234", "contato3@email");

		Contato c4 = new Contato("Contato1", "11234-1234", "contato1@email");

		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);

		if (vetor.buscaElemento(c4) > -1) {
			System.out.println("Elemento Existe no vetor");
		} else {
			System.out.println("Elemento Não Existe no Vetor");
		}
		System.out.println(vetor);

		/*
		 * vetor.adiciona("Elemento 1"); vetor.adiciona("Elemento 2");
		 * vetor.adiciona("Elemento 3"); System.out.println(vetor.tamanho());
		 * System.out.println(vetor); System.out.println(vetor.buscaPosicao(2));
		 * System.out.println("Elemento na Posição: " +
		 * vetor.buscaElemento("Elemento 2"));
		 * 
		 * vetor.adicionaNaPosicao("A", 0); vetor.adicionaNaPosicao("B", 4);
		 * 
		 * System.out.println(vetor);
		 * 
		 * vetor.remove(1); System.out.println(vetor);
		 * 
		 * vetor.removePorNome("Elemento 3"); System.out.println(vetor);
		 * vetor.adiciona("oi"); System.out.println(vetor);
		 * System.out.println(vetor.buscaElemento("oi"));
		 */
		System.out.println("Tamanho " + vetor.tamanho());
	}

}
