package model;

public class Tache {
	private int id;
	private String titre;
	private String description;
	private String responsable;
	private String statut;

	public Tache(int id, String titre, String description, String responsable, String statut) {
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

}
