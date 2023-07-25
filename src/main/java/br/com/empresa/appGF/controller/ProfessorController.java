package br.com.empresa.appGF.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.empresa.appGF.model.Professor;
import br.com.empresa.appGF.repository.ProfessorRepository;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

  @Autowired
  private ProfessorRepository professorRepository;

  @GetMapping("/list")
  public String list(Model model) {

    List<Professor> professores = professorRepository.findAll();

    model.addAttribute("professores", professores);
    return "professor/list";
  }

  @GetMapping("/formAdd")
  public String formAdd(Professor professor) {

    return "professor/formAdd";
  }

  @PostMapping("/add")
  public String add(@Valid Professor professor, BindingResult result) {

    if (result.hasFieldErrors()) {
      return "redirect:/professor/formAdd";
    }

    professorRepository.save(professor);

    return "redirect:/professor/list";
  }

  @GetMapping("formEdit/{id}")
  public String formEdit(Model model, @PathVariable(name = "id") int id) {

    Professor professor = professorRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));

    model.addAttribute("professor", professor);

    return "professor/formEdit";
  }

  @PostMapping("edit/{id}")
  public String edit(@Valid Professor professor, 
                     BindingResult result, 
                     @PathVariable int id) {

    if (result.hasErrors()) {
      return "redirect:/professor/formEdit";
    }

    professorRepository.save(professor);

    return "redirect:/professor/list";
  }

  @GetMapping("delete/{id}")
  @CacheEvict(value = "funcionarios", allEntries = true)
  public String delete(@PathVariable(name = "id") int id, Model model) {

    Professor funcionario = professorRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id inválido:" + id));

    professorRepository.delete(funcionario);
    return "redirect:/professor/list";
  }
}
