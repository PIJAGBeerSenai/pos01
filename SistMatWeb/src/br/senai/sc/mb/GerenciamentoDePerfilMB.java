package br.senai.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.senai.sc.facade.AlunoFacade;
import br.senai.sc.facade.PerfilFacade;
import br.senai.sc.model.Aluno;
import br.senai.sc.model.Perfil;

@ViewScoped
@ManagedBean
public class GerenciamentoDePerfilMB {
	
	@EJB
	private AlunoFacade alunoImp;
	private List<Aluno> allAlunos;
	
	@PostConstruct
	public void Inicia(){
		allAlunos = alunoImp.findAll();
		
	}

	//getters e setters
	public List<Aluno> getAllAlunos() {
		return allAlunos;
	}

	public void setAllAlunos(List<Aluno> allAlunos) {
		this.allAlunos = allAlunos;
	}

	public AlunoFacade getAlunoImp() {
		return alunoImp;
	}

	public void setAlunoImp(AlunoFacade alunoImp) {
		this.alunoImp = alunoImp;
	}
}
