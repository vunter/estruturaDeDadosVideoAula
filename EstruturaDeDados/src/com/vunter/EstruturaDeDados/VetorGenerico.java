package com.vunter.EstruturaDeDados;

import java.util.Arrays;

public class VetorGenerico<T> {
	private T[] elementos;
	private int tamanho;

	public VetorGenerico(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}

	public boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = (T) elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	public boolean adicionaNaPosicao(T elemento, int posicao) {
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
			this.elementos[posicao] = (T) elemento;
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

	public void removePorNome(T elemento) {
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
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
			for (int i = 0; i < elementos.length; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = (T[]) elementosNovos;
		}
	}

	public T buscaPosicao(int posicao) { // Busca por posição
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posição Inválida!");
		}
		return elementos[posicao];
	}

	public int buscaElemento(T elemento) { // Busca pelo objeto
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


		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.elementos[i]);
			s.append(" \n \n");
		}
		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);
		}

		return s.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(elementos);
		result = prime * result + tamanho;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VetorGenerico<T> other = (VetorGenerico<T>) obj;
		if (!Arrays.deepEquals(elementos, other.elementos))
			return false;
		if (tamanho != other.tamanho)
			return false;
		return true;
	}

}
