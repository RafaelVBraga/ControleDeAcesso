package com.rvbraga.controle.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rvbraga.controle.model.Autorizacao;
import com.rvbraga.controle.model.Funcionario;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao,UUID>{
	
@Query("SELECT f FROM Funcionario f join fetch f.autorizacoes a where a.id =:id")
public Set<Funcionario> findFuncionariosFromAutorizacao(@Param("id")UUID id);

@Query("SELECT a FROM Autorizacao a WHERE LOWER(a.instalacao) LIKE %:inst%")
public Set<Optional<Autorizacao>> findByInstalacao(@Param("inst")String instalacao);
	
	

}
