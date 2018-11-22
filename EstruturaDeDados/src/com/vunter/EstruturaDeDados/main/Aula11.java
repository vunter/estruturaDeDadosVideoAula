package com.vunter.EstruturaDeDados.main;

import com.vunter.EstruturaDeDados.VetorGenerico;

public class Aula11 {

	public static void main(String[] args) {
		VetorGenerico<Contato> lista = new VetorGenerico<Contato>(4);
		Contato c1 = new Contato("Eu", "12345", "teste");
		Contato c2 = new Contato("Eu", "12345", "teste");

		Contato c3 = new Contato("Eu", "12345", "teste");

		lista.adiciona(c1);
		lista.adiciona(c2);
		lista.adiciona(c3);
		System.out.println(lista);
	}

}
