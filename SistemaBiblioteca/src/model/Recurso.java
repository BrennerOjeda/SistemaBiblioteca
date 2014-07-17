package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Recurso implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int ideRec;
	@Column (name = "tit_Rec")
	private String titRec;
	@Column (name = "edit_Rec")
	private String editRec;
	@Column (name = "anio_EdicRec")
	private int anioEdicRec;
	@Column (name = "dis_PresRec")
	private String disPresRec;
	@Column (name = "est_Rec")
	private String estRec;
	
	//@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) 
	//private Prestamo prestamo;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Autor> autores = new ArrayList<Autor>();
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Categoria codCat;
	
	
	public Recurso(){
		
	}

	public int getIdeRec() {
		return ideRec;
	}

	public void setIdeRec(int ideRec) {
		this.ideRec = ideRec;
	}

	public String getTitRec() {
		return titRec;
	}

	public void setTitRec(String titRec) {
		this.titRec = titRec;
	}

	public String getEditRec() {
		return editRec;
	}

	public void setEditRec(String editRec) {
		this.editRec = editRec;
	}

	public int getAnioEdicRec() {
		return anioEdicRec;
	}

	public void setAnioEdicRec(int anioEdicRec) {
		this.anioEdicRec = anioEdicRec;
	}

	public String getDisPresRec() {
		return disPresRec;
	}

	public void setDisPresRec(String disPresRec) {
		this.disPresRec = disPresRec;
	}

	public String getEstRec() {
		return estRec;
	}

	public void setEstRec(String estRec) {
		this.estRec = estRec;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public Categoria getCodCat() {
		return codCat;
	}

	public void setCodCat(Categoria codCat) {
		this.codCat = codCat;
	}
	
	public void addAutor(Autor autor){
		this.autores.add(autor);
	}
	
	
}
