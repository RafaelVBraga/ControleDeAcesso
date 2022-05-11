package com.rvbraga.controle.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.controle.model.Funcionario;
import com.rvbraga.controle.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcRepo;
	
	public List<Optional<Funcionario>> findByNome(String nome){
		return funcRepo.findByNome(nome);
	}
	public Optional<Funcionario> findByCpf(String cpf){
		return funcRepo.findByCpf(cpf);
	}
	
	public Optional<Funcionario> findById(UUID id) {
		
		return funcRepo.findById(id);
	}
	public List<Funcionario> findAll(){
		 return funcRepo.findAll();
	}
	
	public List<Funcionario> findByEmpresa(String Empresa){
		 return funcRepo.findByEmpresa(Empresa);
	}
	 
	public List<Funcionario> findByAutorizacao(String autorizacao){
		 return funcRepo.findByAutorizacao(autorizacao);
	}
	
	public Funcionario save(Funcionario func) {
		return funcRepo.save(func);
	}
	
	public Funcionario edit(Funcionario func) {
		return funcRepo.saveAndFlush(func);
	}
	
	public List<Funcionario> saveAll(List<Funcionario> funcs){
		return funcRepo.saveAll(funcs);
	}
	
	public void delete(UUID id) {
		funcRepo.deleteById(id);
	}

}
