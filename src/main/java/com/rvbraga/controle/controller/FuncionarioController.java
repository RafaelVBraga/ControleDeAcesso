package com.rvbraga.controle.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvbraga.controle.model.Funcionario;
import com.rvbraga.controle.service.FuncionarioService;

@RestController
@CrossOrigin
@RequestMapping("controle/")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service; 
	
	@GetMapping("funcionario/nome/{funcNome}")
	public ResponseEntity<Set<Optional<Funcionario>>> funcionarioByNome(@PathVariable("funcNome")String funcNome) {
		
		Set<Optional<Funcionario>> response = service.findByNome(funcNome);		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@GetMapping("funcionario/id/{funcNome}")
	public ResponseEntity<Funcionario> funcionarioById(@PathVariable("funcNome")UUID id) {
		
		Optional<Funcionario> response = service.findById(id);		
		return ResponseEntity.status(HttpStatus.OK).body(response.isPresent()?response.get(): null);
	}
	@GetMapping("funcionario/cpf/{funcCpf}") 
	public ResponseEntity<Funcionario> funcionarioByCPF(@PathVariable("funcCpf")String cpf){
		
		Optional<Funcionario> response = service.findByCpf(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(response.isPresent()?response.get(): null);
	}
	@GetMapping("funcionario")
	public ResponseEntity<Set<Funcionario>> findAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	@GetMapping("funcionario/empresa/{empresa}")
	public  ResponseEntity<Set<Funcionario>> findByEmpresa(@PathVariable("empresa")String empresa){
		return ResponseEntity.status(HttpStatus.OK).body(service.findByEmpresa(empresa));
	}
	@PostMapping("funcionario")
	public ResponseEntity<Funcionario> saveFuncionario(@RequestBody Funcionario func){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(func)); 
	}
	
	@PutMapping("funcionario")
	public ResponseEntity<Funcionario> updateFuncionario(@RequestBody Funcionario func){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.save(func));  
	}
	@DeleteMapping("funcionario/{id}")
	public ResponseEntity<Object> deleteFuncionario(@PathVariable("id") UUID id){
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build(); 
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString()); 
		}
		
	}
	
}
