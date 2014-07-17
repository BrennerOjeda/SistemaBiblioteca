package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int codCat;
	@Column (name = "nom_Cat")
	private String nomCat;
	@Column (name = "des_Cat")
	private String desCat;
	
	public Categoria(){
		
	}

	public int getCodCat() {
		return codCat;
	}

	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public String getDesCat() {
		return desCat;
	}

	public void setDesCat(String desCat) {
		this.desCat = desCat;
	}
	
	

}
