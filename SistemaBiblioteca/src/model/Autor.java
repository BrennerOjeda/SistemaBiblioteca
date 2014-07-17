package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int codAut;
	@Column (name = "num_aut")
	private String nomAut;
	@Column (name = "ape_Aut")
	private String apeAut;
	
	public Autor(){
		
	}

	public int getCodAut() {
		return codAut;
	}

	public void setCodAut(int codAut) {
		this.codAut = codAut;
	}

	public String getNomAut() {
		return nomAut;
	}

	public void setNomAut(String nomAut) {
		this.nomAut = nomAut;
	}

	public String getApeAut() {
		return apeAut;
	}

	public void setApeAut(String apeAut) {
		this.apeAut = apeAut;
	}
	
	

}
