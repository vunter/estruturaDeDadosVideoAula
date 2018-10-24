package com.vunter.EstruturaDeDados.main;

import com.vunter.EstruturaDeDados.Vetor;

public class Aula03 {

	public static void main(String[] args) {
		Vetor vetor = new Vetor(2);

		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elemento 2");
		vetor.adiciona("Elemento 3");
		System.out.println(vetor.tamanho());
		System.out.println(vetor);
		System.out.println(vetor.busca(2));
		System.out.println("Elemento na Posi��o: " + vetor.busca("Elemento 2"));

		vetor.adiciona("A", 0);
		vetor.adiciona("B", 4);

		System.out.println(vetor);

		vetor.remove(1);
		System.out.println(vetor);

		vetor.removePorNome("Elemento 3");
		System.out.println(vetor);

	}

}
