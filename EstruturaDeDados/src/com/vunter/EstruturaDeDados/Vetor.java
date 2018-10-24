package com.vunter.EstruturaDeDados;

import java.util.Arrays;

public class Vetor {
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

	public boolean adiciona(Object elemento, int posicao) {
		this.aumentaCapacidade();
		if (posicao == tamanho) { // Verifica se a posição é pra inserir no ultimo do vetor
			System.out.println("Ultimo item!");
			this.adiciona(elemento);

		} else {
			// Verifica se a posição está entre o tamanho do vetor
			if (!(posicao >= 0 && posicao < tamanho)) {
				throw new IllegalArgumentException("Posição Inválida!");

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
			throw new IllegalArgumentException("Posição Inválida!");
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
			throw new IllegalArgumentException("Elemento não existe!");
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

	public Object busca(int posicao) { // Busca por posição
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida!");
		}
		return elementos[posicao];
	}

	public int busca(Object elemento) { // Busca pelo objeto
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
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
