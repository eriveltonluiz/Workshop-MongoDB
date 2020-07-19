package com.projeto.application.resources.exceptions;

public class StandardError {

	private Long momento;
	private Integer status;
	private String erro;
	private String mensagem;
	private String pasta;
	
	public StandardError() {
	}

	public StandardError(Long momento, Integer status, String erro, String mensagem, String pasta) {
		this.momento = momento;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.pasta = pasta;
	}

	public Long getMomento() {
		return momento;
	}

	public void setMomento(Long momento) {
		this.momento = momento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPasta() {
		return pasta;
	}

	public void setPasta(String pasta) {
		this.pasta = pasta;
	}

}
