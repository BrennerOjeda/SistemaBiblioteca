package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoUsuario implements Serializable{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column (name = "id_TipUsu")
	private  int idTipUsu;
	@Column (name = "nom_TipUsu")
	private String nomTipUsu;
	
	public TipoUsuario(){
		
	}

	public int getIdTipUsu() {
		return idTipUsu;
	}

	public void setIdTipUsu(int idTipUsu) {
		this.idTipUsu = idTipUsu;
	}

	public String getNomTipUsu() {
		return nomTipUsu;
	}

	public void setNomTipUsu(String nomTipUsu) {
		this.nomTipUsu = nomTipUsu;
	}
	
	

}
