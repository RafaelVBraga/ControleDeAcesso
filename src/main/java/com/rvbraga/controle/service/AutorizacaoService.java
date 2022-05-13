package com.rvbraga.controle.service;

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
		return autoRepo.findByInstalacao(instalacao);
	}
	
	@SuppressWarnings("unchecked")
	public Set<Autorizacao> findAll(){
		return (Set<Autorizacao>) autoRepo.findAll();
				
	}
	public Set<Funcionario> findFuncionarios(UUID id){
		return autoRepo.findFuncionariosFromAutorizacao(id);
	}
}
