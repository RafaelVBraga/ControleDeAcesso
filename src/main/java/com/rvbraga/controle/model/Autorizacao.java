package com.rvbraga.controle.model;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Autorizacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String instalacao;
	private String data;
	private String hora;
	private String status;	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)	
	@JoinTable(name = "AUTORIZACAO_FUNCIONARIO", joinColumns = {
			@JoinColumn(name = "Autorizacao_ID") }, inverseJoinColumns = { @JoinColumn(name = "Funcionario_ID") })
	private Set<Funcionario> funcionarios;  
	
	public void addFuncionario(Funcionario func) {
		this.funcionarios.add(func);
		func.getAutorizacoes().add(this);
	}
	public void deleteFuncionario(final Funcionario func) {
		this.funcionarios.remove(func);
		func.getAutorizacoes().remove(this);
		
		}
		
		
	

	

}
