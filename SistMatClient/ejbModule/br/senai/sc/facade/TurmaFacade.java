package br.senai.sc.facade;

import java.util.List;



import br.senai.sc.model.Turma;


public interface TurmaFacade {

	public abstract void salvar (Turma turma);
	
	public abstract void deletar (Turma turma);
	
	public abstract Turma find(int entityID);
	
	public abstract List findAll();
}
