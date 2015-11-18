package br.senai.sc.facade;

import java.util.List;



import br.senai.sc.model.Professor;


public interface ProfessorFacade {

public abstract void salvar ();
	
	public abstract void deletar (Professor professor);
	
	public abstract Professor find(int entityID);
	
	public abstract List findAll();
}
