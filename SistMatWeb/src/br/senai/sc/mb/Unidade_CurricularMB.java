package br.senai.sc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import br.senai.sc.facade.Unidade_CurricularFacade;
import br.senai.sc.model.Aluno;
import br.senai.sc.model.Unidade_Curricular;

@ViewScoped
@ManagedBean
public class Unidade_CurricularMB {

	@EJB
	private Unidade_CurricularFacade unidadeCurricularImp;
	private List<Unidade_Curricular> unidadeCurricularLista;
		
	
	@PostConstruct
	public void inicial(){
		unidadeCurricularLista = new ArrayList<Unidade_Curricular>();
		unidadeCurricularLista = unidadeCurricularImp.findAll();
      }
	
	
	
	
	

	public Unidade_CurricularFacade getUnidadeCurricularImp() {
		return unidadeCurricularImp;
	}

	public void setUnidadeCurricularImp(
			Unidade_CurricularFacade unidadeCurricularImp) {
		this.unidadeCurricularImp = unidadeCurricularImp;
	}

	public List<Unidade_Curricular> getUnidadeCurricularLista() {
		return unidadeCurricularLista;
	}

	public void setUnidadeCurricularLista(
			List<Unidade_Curricular> unidadeCurricularLista) {
		this.unidadeCurricularLista = unidadeCurricularLista;
	}

	
}
