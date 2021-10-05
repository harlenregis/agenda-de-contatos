package br.com.ap1dac.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.ap1dac.dao.ContatoDAO;
import br.com.ap1dac.domain.Contato;

@ManagedBean
public class ContatoBean {
	
private Contato contato = new Contato();
	
	private List<Contato> contatos;
	
	public String salvar() {
		try {
			ContatoDAO.salvar(contato);
			contato = new Contato();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Contato Salvo com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao salvar contato"));
		}
		return null;
	}
	
	public String editar() {
		try {
			ContatoDAO.editar(contato);
			contato = new Contato();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Contato Editado com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao editar contato"));
		}
		return null;
	}
	
	public String excluir() {
		try {
			ContatoDAO.excluir(contato);
			contatos.remove(contato);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Contato Excluido com sucesso"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Erro ao excluir contato"));
		}
		return null;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		if (contatos == null) {
			contatos = ContatoDAO.listar();
		}
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
}
