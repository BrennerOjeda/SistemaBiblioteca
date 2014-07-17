package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Usuario implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (name = "doc_IdeUsu")
	private int docIdeUsu;
	@Column (name = "nom_Usu")
	private String nomUsu;
	@Column (name = "ape_Usu")
	private String apeUsu;
	@Column (name = "tel_Usu")
	private int telUsu;
	@Column (name = "dir_Usu")
	private String dirUsu;
	@Column (name = "ema_Usu")
	private String emaUsu;
	@Column (name = "pass_Usu")
	private String passUsu;
	@Column (name = "est_Usu")
	private String estUsu;
	
	//@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) 
	//private Prestamo prestamo;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private TipoUsuario ideTipUsu;
	
	public Usuario(){
		
	}

	public int getDocIdeUsu() {
		return docIdeUsu;
	}

	public void setDocIdeUsu(int docIdeUsu) {
		this.docIdeUsu = docIdeUsu;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getApeUsu() {
		return apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public int getTelUsu() {
		return telUsu;
	}

	public void setTelUsu(int telUsu) {
		this.telUsu = telUsu;
	}

	public String getDirUsu() {
		return dirUsu;
	}

	public void setDirUsu(String dirUsu) {
		this.dirUsu = dirUsu;
	}

	public String getEmaUsu() {
		return emaUsu;
	}

	public void setEmaUsu(String emaUsu) {
		this.emaUsu = emaUsu;
	}

	public String getPassUsu() {
		return passUsu;
	}

	public void setPassUsu(String passUsu) {
		this.passUsu = passUsu;
	}

	public String getEstUsu() {
		return estUsu;
	}

	public void setEstUsu(String estUsu) {
		this.estUsu = estUsu;
	}

	public TipoUsuario getIdeTipUsu() {
		return ideTipUsu;
	}

	public void setIdeTipUsu(TipoUsuario ideTipUsu) {
		this.ideTipUsu = ideTipUsu;
	}
	
	

}
