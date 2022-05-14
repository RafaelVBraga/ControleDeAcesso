package com.rvbraga.controle.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvbraga.controle.model.Autorizacao;
import com.rvbraga.controle.model.Funcionario;
import com.rvbraga.controle.service.AutorizacaoService;
import com.rvbraga.controle.service.FuncionarioService;

@RestController
@CrossOrigin
@RequestMapping("controle/autorizacao")
public class AutorizacaoController {
	
	@Autowired
	private AutorizacaoService autoService;
	
	@GetMapping("")
	public Set<Autorizacao> findAll(){
		return autoService.findAll();		}
	
	@PostMapping("")
	public Autorizacao save(@RequestBody Autorizacao autorizacao) {
		System.out.println("save function!");
		return autoService.saveAutorizacao(autorizacao);
	}
	@GetMapping("/{id}")
	public Optional<Autorizacao> findById(@PathVariable("id")UUID id) {
		return autoService.findById(id);
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}/funcionarios")
	public List<Funcionario> getFuncionarios(@PathVariable("id") UUID id){
		return (List<Funcionario>) autoService.findFuncionarios(id);		
	}
	
	@PutMapping("/{id}/funcionario")
	public Autorizacao addFuncionario(@PathVariable("id")UUID id, @RequestBody Funcionario func) {		
		return autoService.addFuncionario(id, func);
		
	}
	@PutMapping("/{id}/funcionario/delete/{idFunc}")
	public Autorizacao deleteFuncionario(@PathVariable("id")UUID id, @PathVariable("idFunc")UUID idFunc) {			
			return autoService.deleteFuncionario(id, idFunc);
			
	}
	
	@PutMapping("/{id}/status/{status}")
	public Autorizacao setStatus(@PathVariable("id")UUID id,@PathVariable("status") String status) {	
		return autoService.setStatus(id, status);
	}

}
