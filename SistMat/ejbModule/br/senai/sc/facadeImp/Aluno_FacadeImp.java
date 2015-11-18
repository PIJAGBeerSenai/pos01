package br.senai.sc.facadeImp;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.senai.sc.facade.AlunoFacade;
import br.senai.sc.model.Aluno;

@Stateless
public class Aluno_FacadeImp implements AlunoFacade {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void deletar(Aluno aluno) {
		// a deleção será lógica
	}

	@Override
	public Aluno find(int entityID) {
		return null;
	}

	@Override
	public List<Aluno> findAll() {
		/*
		 * CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		 * cq.select(cq.from(Aluno.class)); return
		 * em.createQuery(cq).getResultList();
		 */
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listaRetornaAlunoID(Integer id) {
		return em.createQuery("select a from Aluno a where a.id = :id ")
				.setParameter("id", id).getResultList();
	}

	@Override
	public Aluno validaExistenciaAluno(Integer id) {
		return (Aluno) em
				.createQuery(
						"SELECT a FROM Usuario u JOIN u.aluno a WHERE u.id = :id")
				.setParameter("id", id).getSingleResult();

	}

	@Override
	public void salvar(Aluno aluno) {
		try {
			if (aluno.getId() != null) {
				em.merge(aluno);
			} else {
				em.persist(aluno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
