package br.senai.sc.facadeImp;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import br.senai.sc.facade.Unidade_CurricularFacade;
import br.senai.sc.model.Aluno;
import br.senai.sc.model.Unidade_Curricular;

@Stateless
public class Unidade_CurricularFacadeImp implements Unidade_CurricularFacade{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void Salvar(Unidade_Curricular unidadeUC) {
		
		
	}

	@Override
	public Unidade_Curricular find(int entityID) {
		
		return null;
	}
	
	@Override
	public List<Unidade_Curricular> listaRetornaFase(Integer fase){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Unidade_Curricular> cq = cb.createQuery(Unidade_Curricular.class);
		Root<Unidade_Curricular> unidade = cq.from(Unidade_Curricular.class);
		ParameterExpression<Integer> p = cb.parameter(Integer.class);
		cq.select(unidade).where(cb.equal(unidade.get("fase"),fase));
		return em.createQuery(cq).getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Unidade_Curricular> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(Unidade_Curricular.class));
		return em.createQuery(cq).getResultList();
	}
	@Override
	public void deletar(Unidade_Curricular unidadeUC) {
		
		
	}

	

}
