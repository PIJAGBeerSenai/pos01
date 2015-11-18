package br.senai.sc.facade;

import java.util.List;

import br.senai.sc.model.Unidade_Curricular;


public interface Unidade_CurricularFacade {

	public abstract void Salvar (Unidade_Curricular unidadeUC);
	
	public abstract void deletar (Unidade_Curricular unidadeUC);
	
	public abstract Unidade_Curricular find (int entityID);
	
	public abstract List findAll();
	
	public abstract List listaRetornaFase(Integer fase);
}
