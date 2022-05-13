package com.rvbraga.controle.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvbraga.controle.model.Funcionario;
import com.rvbraga.controle.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcRepo;
	
	@SuppressWarnings("unchecked")
	public Set<Optional<Funcionario>> findByNome(String nome){
		return (Set<Optional<Funcionario>>) funcRepo.findByNome(nome);
	}
	public Optional<Funcionario> findByCpf(String cpf){
		return funcRepo.findByCpf(cpf);
	}
	
	public Optional<Funcionario> findById(UUID id) {
		
		return funcRepo.findById(id);
	}
	@SuppressWarnings("unchecked")
	public Set<Funcionario> findAll(){
		Set<Funcionario> set = new HashSet<Funcionario>(funcRepo.findAll());
		return set;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Funcionario> findByEmpresa(String Empresa){
		 return (Set<Funcionario>) funcRepo.findByEmpresa(Empresa);
	}
	 
	
	public Funcionario save(Funcionario func) {
		return funcRepo.save(func);
	}
	
	public Funcionario edit(Funcionario func) {
		return funcRepo.saveAndFlush(func);
	}
	
	@SuppressWarnings("unchecked")
	public Set<Funcionario> saveAll(List<Funcionario> funcs){
		return (Set<Funcionario>) funcRepo.saveAll(funcs);
	}
	
	public void delete(UUID id) {
		funcRepo.deleteById(id);
	}

}
