package br.com.poc.entity;

import lombok.Data;

@Data
public class Mensagem {

	private String texto;

	public Mensagem(String texto) {
		this.texto = texto;
	}

}
