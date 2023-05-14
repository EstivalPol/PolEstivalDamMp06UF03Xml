package cat.prateducacio.dam.mp06.uf03.xml.model.domain;

import java.io.Serializable;

public class Empresa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cif;
	private String nom;
	

	public Empresa() {
		super();
	}

	public Empresa(String cif, String nom) {
		super();
		this.cif = cif;
		this.nom = nom;
	
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Empresa [cif=" + cif + ", nom=" + nom + "]";
	}

}
