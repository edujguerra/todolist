package br.com.edujguerra.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edujguerra.todolist.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
    
}