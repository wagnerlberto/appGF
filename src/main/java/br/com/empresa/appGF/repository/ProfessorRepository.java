package br.com.empresa.appGF.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.empresa.appGF.model.Professor;
import br.com.empresa.appGF.model.ProfessorSetor;

public interface ProfessorRepository 
 extends JpaRepository<Professor, Integer> {

  List<Professor> findBySetor(ProfessorSetor professorSetor);
}