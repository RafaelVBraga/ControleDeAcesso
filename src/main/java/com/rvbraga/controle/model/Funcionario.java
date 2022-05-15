package com.rvbraga.controle.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String nome;
	private String cpf;
	private String empresa;

	@ManyToMany(mappedBy="funcionarios",cascade = CascadeType.ALL)	
	@JsonIgnore
	private Set<Autorizacao> autorizacoes;
	
	public void addAutorizacao(Autorizacao auto) {
		this.autorizacoes.add(auto);
		auto.getFuncionarios().add(this);
	}
	public void removeAutorizacao(Autorizacao auto) {
		this.autorizacoes.remove(auto);
		auto.getFuncionarios().remove(this);

	}
}
