package br.senai.sc.facade;



import javax.ejb.EJB;

import br.senai.sc.model.Usuario;


public interface UsuarioFacade {

	 Usuario findUsuario(String cpf);
	 
	 Usuario findColaborador (String login);
}
