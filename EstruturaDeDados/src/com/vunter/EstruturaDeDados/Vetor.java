package com.vunter.EstruturaDeDados;

import java.util.Arrays;

public class Vetor<T> {
	private Object[] elementos;
	private int tamanho;

	public Vetor(int capacidade) {
		this.elementos = new Object[capacidade];
		this.tamanho = 0;
	}

	public boolean adiciona(Object elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	public boolean adicionaNaPosicao(Object elemento, int posicao) {
		this.aumentaCapacidade();
		if (posicao == tamanho) { // Verifica se a posi��o � pra inserir no ultimo do vetor
			System.out.println("Ultimo item!");
			this.adiciona(elemento);

		} else {
			// Verifica se a posi��o est� entre o tamanho do vetor
			if (!(posicao >= 0 && posicao < tamanho)) {
				throw new IllegalArgumentException("Posi��o Inv�lida!");

			}
			// mover todos os elementos
			for (int i = this.tamanho - 1; i >= posicao; i--) {
				this.elementos[i + 1] = this.elementos[i];
			}
			this.elementos[posicao] = elemento;
			this.tamanho++;
		}
		return true;
	}

	public void remove(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o Inv�lida!");
		}
		for (int i = posicao; i < tamanho - 1; i++) {
			this.elementos[i] = this.elementos[i + 1];
		}
		this.tamanho--;
	}

	public void removePorNome(Object elemento) {
		int posicao = -1;
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				posicao = i;
			}
		}
		if (posicao >= 0) {
			this.remove(posicao);
		} else {
			throw new IllegalArgumentException("Elemento n�o existe!");
		}
	}

	public int tamanho() {
		return this.tamanho;
	}

	private void aumentaCapacidade() {
		if (this.tamanho == this.elementos.length) {
			Object[] elementosNovos = new Object[this.elementos.length * 2];
			for (int i = 0; i < elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}

	public Object buscaPosicao(int posicao) { // Busca por posi��o
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posi��o Inv�lida!");
		}
		return elementos[posicao];
	}

	public int buscaElemento(Object elemento) { // Busca pelo objeto
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	public String mostraElementoNaPosicao(int posicao) {
		String elemento;
		elemento = this.elementos[posicao].toString();
		
		
		return elemento;
	}

	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}
		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);
		}
		s.append("]");
		return s.toString();
	}

}
