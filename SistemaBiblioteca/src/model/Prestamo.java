package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prestamo implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idePres;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Recurso> recursos = new ArrayList<Recurso>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	@Column (name = "fec_Ent")
	private Date fecEnt;
	@Column (name = "num_DiaPres")
	private int numDiaPres;
	@Column (name = "fec_Dev")
	private Date fecDev;
	@Column (name = "obs_Rec")
	private String obsRec;
	
	public Prestamo(){
		
	}

	public int getIdePres() {
		return idePres;
	}

	public void setIdePres(int idePres) {
		this.idePres = idePres;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Date getFecEnt() {
		return fecEnt;
	}

	public void setFecEnt(Date fecEnt) {
		this.fecEnt = fecEnt;
	}

	public int getNumDiaPres() {
		return numDiaPres;
	}

	public void setNumDiaPres(int numDiaPres) {
		this.numDiaPres = numDiaPres;
	}

	public Date getFecDev() {
		return fecDev;
	}

	public void setFecDev(Date fecDev) {
		this.fecDev = fecDev;
	}

	public String getObsRec() {
		return obsRec;
	}

	public void setObsRec(String obsRec) {
		this.obsRec = obsRec;
	}
	public void addRecursos(Recurso recurso)
    {
        this.recursos.add(recurso);
    }
	public void addUsuario(Usuario usuario)
    {
        this.usuarios.add(usuario);
    }
	
	
}
