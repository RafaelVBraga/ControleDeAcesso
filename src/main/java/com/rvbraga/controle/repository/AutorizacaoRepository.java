package com.rvbraga.controle.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rvbraga.controle.model.Autorizacao;
import com.rvbraga.controle.model.Funcionario;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao,UUID>{
	
@Query("SELECT f FROM Funcionario f WHERE f.autorizacao.id=:id")
public List<Funcionario> findFuncionariosFromAutorizacao(@Param("id")UUID id);

@Query("SELECT a FROM Autorizacao a WHERE LOWER(a.instalacao) LIKE %:inst%")
public List<Optional<Autorizacao>> findByInstalacao(@Param("inst")String instalacao);
	
	

}
