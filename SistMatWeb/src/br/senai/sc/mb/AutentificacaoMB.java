package br.senai.sc.mb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.senai.sc.facade.UsuarioFacade;
import br.senai.sc.model.Usuario;

@ManagedBean
@RequestScoped
public class AutentificacaoMB {
	
	@EJB
	private UsuarioFacade usuarioImp;
	
	private String cpf;
	private String senha;
	private String login;
	private Usuario u;
	private Integer valor;
	
	@PostConstruct
	public void inicia(){
		valor = 1;
	}
	
	public String logar(){
		 u = new Usuario();
		 u = usuarioImp.findUsuario(cpf);
		 u = usuarioImp.findColaborador(login);
		 FacesContext fc = FacesContext.getCurrentInstance();

	if(valor == 1){
		if(u!=null && !u.getAluno().getCpf().isEmpty() && u.getAluno().getCpf() != null && u.getAluno().getCpf().equals(cpf) 
				   && !u.getSenha().isEmpty() && u.getSenha() != null && u.getSenha().equals(senha)){
			
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("idUsuario", u.getId());	
			return "aluno.jsf";
		
		}else if(u == null){
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("idUsuario", -1);	
			return "aluno.jsf";
		}else{
			System.out.println("CPF ou Senha invalidos");
			return "login.jsf";
      	
		     }
	}else if(valor == 2){
			if(u!=null && !u.getPerfil().getLogin().isEmpty() && u.getPerfil().getLogin() != null && !u.getPerfil().getLogin().equals(login) 
				   && !u.getSenha().isEmpty() && u.getSenha() != null && u.getSenha().equals(senha)){
				
				
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
				session.setAttribute("idUsuario", u.getId());
				return  "pageSecretaria.jsf";
			}else{
				System.out.println("Login ou Senha invalidos");
				return "login.jsf";
			}
		}
	
				return "";
	}



	
	//getters e setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public UsuarioFacade getUsuarioImp() {
		return usuarioImp;
	}


	public void setUsuarioImp(UsuarioFacade usuarioImp) {
		this.usuarioImp = usuarioImp;
	}


	public Usuario getU() {
		return u;
	}


	public void setU(Usuario u) {
		this.u = u;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

}
