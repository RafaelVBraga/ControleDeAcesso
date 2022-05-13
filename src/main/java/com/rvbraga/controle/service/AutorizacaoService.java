package com.rvbraga.controle.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.controle.model.Autorizacao;
import com.rvbraga.controle.model.Funcionario;
import com.rvbraga.controle.repository.AutorizacaoRepository;

@Service
public class AutorizacaoService {
	@Autowired
	private AutorizacaoRepository autoRepo; 
	
	
	public Autorizacao saveAutorizacao(Autorizacao autorizacao){
		return autoRepo.save(autorizacao);
	}
	
	public Autorizacao editAutorizacao(Autorizacao autorizacao) {
		return autoRepo.save(autorizacao);
	}
	
	public Optional<Autorizacao> findById(UUID id) {
		return autoRepo.findById(id);
	}
	
	public Set<Optional<Autorizacao>> findByInstalacao(String instalacao){
		Set<Optional<Autorizacao>> set = new HashSet<Optional<Autorizacao>>(autoRepo.findByInstalacao(instalacao));
		return set ;
				
	}
	
	public Set<Autorizacao> findAll(){
		Set<Autorizacao> set = new HashSet<Autorizacao>(autoRepo.findAll());
		return set ;
				
	}
	public Set<Funcionario> findFuncionarios(UUID id){
		Set<Funcionario> set = new HashSet<Funcionario>(autoRepo.findFuncionariosFromAutorizacao(id));
		return set ;
		
	}
}
