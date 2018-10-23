package com.vunter.EstruturaDeDados;

import java.util.Arrays;

public class Vetor {
	private Object[] elementos;
	private int tamanho;

	public Vetor(int capacidade) {
		this.elementos = new Object[capacidade];
		this.tamanho = 0;
	}
	/*
	 * public void adiciona(String elemento) { for (int i = 0; i <
	 * this.elementos.length; i++) { if (this.elementos[i] == null) {
	 * this.elementos[i] = elemento; break; }
	 * 
	 * }
	 * 
	 * Método acima funciona, mas não é tão eficiente.
	 */

	public boolean adiciona(Object elemento) {
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	public boolean adiciona(Object elemento, int posicao) {
		if (posicao == tamanho) { //Verifica se a posição é pra inserir no ultimo do vetor
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

	public int tamanho() {
		return this.tamanho;
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
