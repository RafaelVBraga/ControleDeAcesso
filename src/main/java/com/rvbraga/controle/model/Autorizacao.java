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
import javax.persistence.ManyToMany;

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
	@ManyToMany(mappedBy = "autorizacoes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
