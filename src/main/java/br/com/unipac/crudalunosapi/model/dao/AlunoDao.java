package br.com.unipac.crudalunosapi.model.dao;

import br.com.unipac.crudalunosapi.model.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoDao extends JpaRepository<Aluno, Long> {
}
