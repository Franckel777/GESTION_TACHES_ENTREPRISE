package co.kozao.model;

import co.kozao.enums.*;

public class Tache {
	private int id;
	private String titre;
	private String description;
	private String responsable;
	private Statut statut;

	public Tache() {

	}

	public Tache(int id, String titre, String description, String responsable, Statut statut) {
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.responsable = responsable;
		this.statut = statut;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", titre=" + titre + ", description=" + description + ", responsable=" + responsable
				+ ", statut=" + statut + "]";
	}

}
