package com.vunter.EstruturaDeDados.main;

import com.vunter.EstruturaDeDados.Vetor;

public class Aula03 {

	public static void main(String[] args) {
		Vetor<String> vetor = new Vetor<String>(2);

		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elemento 2");
		vetor.adiciona("Elemento 3");
		System.out.println(vetor.tamanho());
		System.out.println(vetor);
		System.out.println(vetor.buscaPosicao(2));
		System.out.println("Elemento na Posição: " + vetor.buscaElemento("Elemento 2"));

		vetor.adicionaNaPosicao("A", 0);
		vetor.adicionaNaPosicao("B", 4);

		System.out.println(vetor);

		vetor.remove(1);
		System.out.println(vetor);

		vetor.removePorNome("Elemento 3");
		System.out.println(vetor);
		vetor.adiciona(1);
		System.out.println(vetor.mostraElementoNaPosicao(vetor.buscaElemento(1)));

	}

}
