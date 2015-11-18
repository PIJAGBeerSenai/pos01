package br.senai.sc.facade;

import java.util.List;



import br.senai.sc.model.Curso;


public interface CursoFacade {

public abstract void deletar (Curso curso);
	
	public abstract Curso find(int entityID);
	
	public abstract List findAll();
	
}
