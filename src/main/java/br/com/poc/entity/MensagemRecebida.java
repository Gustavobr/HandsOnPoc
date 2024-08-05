package br.com.poc.entity;

import lombok.Data;

@Data
public class MensagemRecebida {

	public MensagemRecebida() {

	}

	private String texto;

	private String origem;

}
