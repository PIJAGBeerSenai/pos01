package br.senai.sc.facade;

import java.util.List;



import br.senai.sc.model.Log;


public interface LogFacade {

public abstract void deletar (Log log);
	
	public abstract Log find(int entityID);
	
	public abstract List findAll();
}
