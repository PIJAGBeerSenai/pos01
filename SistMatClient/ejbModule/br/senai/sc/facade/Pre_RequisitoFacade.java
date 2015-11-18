package br.senai.sc.facade;

import java.util.List;



import br.senai.sc.model.Pre_Requisito;


public interface Pre_RequisitoFacade {

public abstract void deletar (Pre_Requisito preRqeuisito);
	
	public abstract Pre_Requisito find(int entityID);
	
	public abstract List findAll();
}
