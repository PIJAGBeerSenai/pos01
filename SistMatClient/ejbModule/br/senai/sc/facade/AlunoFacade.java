package br.senai.sc.facade;


import java.util.List;

import br.senai.sc.model.Aluno;

@SuppressWarnings(value="all")
public interface AlunoFacade {

	void deletar (Aluno aluno);
	
	Aluno find(int entityID);
	
	List findAll();
	
	List<Aluno> listaRetornaAlunoID(Integer id);
	
	Aluno validaExistenciaAluno(Integer id);

	void salvar(Aluno aluno);

	
}
