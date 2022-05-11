package com.rvbraga.controle.controller;

import java.util.List;
import java.util.Optional;
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

@RestController
@CrossOrigin
@RequestMapping("controle/autorizacao/")
public class AutorizacaoController {
	
	@Autowired
	private AutorizacaoService autoService;
	
	@PostMapping("")
	public Autorizacao save(@RequestBody Autorizacao autorizacao) {
		return autoService.saveAutorizacao(autorizacao);
	}
	@GetMapping("{id}")
	public Optional<Autorizacao> findById(@PathVariable("id")UUID id) {
		return autoService.findById(id);
	}
	@GetMapping("{id}/funcionarios")
	public List<Funcionario> getFuncionarios(@PathVariable("id") UUID id){
		return autoService.findFuncionarios(id);		
	}
	
	@PutMapping("{id}/funcionario")
	public Autorizacao addFuncionario(@PathVariable("id")UUID id, @RequestBody Funcionario func) {
		Optional<Autorizacao> autoResp = autoService.findById(id);
		Autorizacao autorizacao = (autoResp.isPresent()?autoResp.get():new Autorizacao());		
		autorizacao.getFuncionarios().add(func);
		return autoService.editAutorizacao(autorizacao);
		
	}

}
