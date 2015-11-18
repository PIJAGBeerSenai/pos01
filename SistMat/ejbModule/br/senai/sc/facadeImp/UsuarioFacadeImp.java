package br.senai.sc.facadeImp;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.senai.sc.model.Usuario;
import br.senai.sc.Util.JpaUtil;
import br.senai.sc.facade.UsuarioFacade;

@Stateless
public class UsuarioFacadeImp implements UsuarioFacade {


	@PersistenceContext
	private EntityManager em = JpaUtil.getEntityManager();

	public List<Usuario> buscarTodos() {		
		return null;
	}

	@Override
	public Usuario findUsuario(String cpf) {
		Usuario u = new Usuario();
		try{
			u = (Usuario) em.createQuery("SELECT u FROM Usuario u JOIN u.aluno a WHERE a.cpf = :cpf").
					setParameter("cpf", cpf).
					getSingleResult();
		} catch ( NoResultException nre ) {  
			return null;  
		} 
		return u;
	}

	@Override
	public Usuario findColaborador(String login) {
		Usuario u = new Usuario();
		try{
			u = (Usuario) em.createQuery("SELECT u FROM Usuario u JOIN u.perfil p WHERE p.login = :login").
					setParameter("login", login).
					getSingleResult();
		} catch ( NoResultException nre ) {  
			return null;  
		} 
		return u;
	}

}