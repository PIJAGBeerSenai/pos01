package br.senai.sc.facade;

import java.util.List;



import br.senai.sc.model.Horario;


public interface HorarioFacade {

public abstract void deletar (Horario horario);
	
	public abstract Horario find(int entityID);
	
	public abstract List findAll();
}
