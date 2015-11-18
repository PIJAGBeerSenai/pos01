package br.senai.sc.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import br.senai.sc.facade.AlunoFacade;
import br.senai.sc.facade.Unidade_CurricularFacade;
import br.senai.sc.model.Aluno;
import br.senai.sc.model.Unidade_Curricular;

@ViewScoped
@ManagedBean
public class AlunoMB {
	
	@EJB
	private AlunoFacade alunoImp;
	@EJB
	private Unidade_CurricularFacade unidadeCurricularImp;
	private List<Aluno> alunoLista;
	private Aluno aluno;
	
	private List<Aluno> listaAlunoExiste;
	private List<Unidade_Curricular> unidadeCurricularLista;
		
	
	@PostConstruct
	public void inicial(){		
		unidadeCurricularLista = new ArrayList<Unidade_Curricular>();
		aluno = new Aluno();
		alunoLista = new ArrayList<Aluno>();

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);		
		Integer idUsuario =  (Integer) session.getAttribute("idUsuario");
		if(idUsuario !=-1){
			aluno = alunoImp.validaExistenciaAluno(idUsuario);
			alunoLista.add(aluno);
		}
	}
	
	private void criaAluno(){
		aluno = new Aluno();
		
	}
	
	public String salvar(){
		List<Unidade_Curricular> listaParaSalvar = new ArrayList<Unidade_Curricular>();
		for (Unidade_Curricular uc : unidadeCurricularLista) {
			if (uc.getSelecionado()) {
				listaParaSalvar.add(uc);
			}
		}
		if (listaParaSalvar.size() > 0)
			aluno.setUnidade_Curricular(listaParaSalvar);
		
		alunoImp.salvar(aluno);
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);		
		Integer idUsuario =  (Integer) session.getAttribute("idUsuario");
		if(idUsuario !=-1){
	    aluno = alunoImp.validaExistenciaAluno(idUsuario);
	    }
		alunoLista = alunoImp.listaRetornaAlunoID(aluno.getId());
		criaAluno();
		return "";
	}
	
	
	public void fasechanged(ValueChangeEvent e){
		if(e != null){
			if(e.getNewValue() != null){
				String newvalue = (String) e.getNewValue();
				if(newvalue != null && !newvalue.isEmpty()){
					Integer fase = Integer.parseInt(newvalue);
					List<Unidade_Curricular> retornoFase  = unidadeCurricularImp.listaRetornaFase(fase);
					unidadeCurricularLista = new ArrayList<Unidade_Curricular>();
					unidadeCurricularLista.addAll(retornoFase);
				}
			}
		}
	}
	
	
	
	// getters e setters
	public AlunoFacade getAlunoImp() {
		return alunoImp;
	}

	public List<Aluno> getListaAlunoExiste() {
		return listaAlunoExiste;
	}

	public void setListaAlunoExiste(List<Aluno> listaAlunoExiste) {
		this.listaAlunoExiste = listaAlunoExiste;
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

	public void setAlunoImp(AlunoFacade alunoImp) {
		this.alunoImp = alunoImp;
	}

	public List<Aluno> getAlunoLista() {
		return alunoLista;
	}

	public void setAlunoLista(List<Aluno> alunoLista) {
		this.alunoLista = alunoLista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	
	
}
