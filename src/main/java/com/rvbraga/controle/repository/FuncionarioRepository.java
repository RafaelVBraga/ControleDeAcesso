package com.rvbraga.controle.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rvbraga.controle.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
	
	@Query("select f from Funcionario f where lower(f.empresa) like %:empresa%")
	List<Funcionario> findByEmpresa(@Param("empresa")String empresa);
	
	@Query("select f from Funcionario f where lower(f.nome) like %:nome% ")
	List<Optional<Funcionario>> findByNome(@Param("nome")String nome);	
	Optional<Funcionario> findByCpf(String cpf);
	
} 
