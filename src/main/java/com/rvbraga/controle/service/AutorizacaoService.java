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
import com.rvbraga.controle.repository.FuncionarioRepository;

@Service
public class AutorizacaoService {
	@Autowired
	private AutorizacaoRepository autoRepo; 
	
	@Autowired
	private FuncionarioRepository funcRepo;
	
	
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
	
	public Autorizacao addFuncionario(UUID id, Funcionario func) {
		Autorizacao aut = autoRepo.getById(id);
		aut.addFuncionario(func);
		return autoRepo.saveAndFlush(aut);
		
	}
	
	public Autorizacao deleteFuncionario(UUID id, UUID idFunc) {
		Autorizacao aut = autoRepo.getById(id);
		Funcionario fun = funcRepo.getById(idFunc);
		aut.deleteFuncionario(fun);
		return autoRepo.saveAndFlush(aut);
	}
	
	public Autorizacao setStatus(UUID id, String status) {
		Autorizacao aut = autoRepo.getById(id);
		aut.setStatus(status);
		return autoRepo.saveAndFlush(aut);
	}
	
	
}
