package br.com.edujguerra.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;

@Entity
@Table
public class Tarefa{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private String descricao;
	
	private boolean concluida;
	
	public Tarefa() 
	{
		
	}
	
	public Tarefa(long id,String descricao,boolean concluida) 
	{
		//teste
		this.id = id;
		this.descricao = descricao;
		this.concluida = concluida;
	}	
	
	public long getId() {
		return this.id;
	}	
	public void setId(long Id) {
		this.id = Id;
	}
	
	public String getDescricao() {
		return this.descricao;
	}	
	public void setDescricao(String Descricao) {
		this.descricao = Descricao;
	}
	
	public boolean getConcluida() {
		return this.concluida;
	}	
	public void setConcluida(boolean Concluida) {
		this.concluida = Concluida;
	}
	
	@Override
	public String toString() {
		return "Tarefa [Id=" + this.id +
				", Descricao=" + this.descricao +
				", Concluida=" + this.concluida ;
	}
}