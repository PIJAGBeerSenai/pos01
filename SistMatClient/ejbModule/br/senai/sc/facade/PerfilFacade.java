package br.senai.sc.facade;

import java.util.List;



import br.senai.sc.model.Perfil;


public interface PerfilFacade {

public abstract void deletar (Perfil perfil);
	
	public abstract Perfil find(int entityID);
	
	public abstract List findAll();
}
