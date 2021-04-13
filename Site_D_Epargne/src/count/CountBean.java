package count;

public class CountBean {
	private int duree=0;
	private int versement=0;
	private float taux= 0;
	
	public CountBean() {
		// TODO Auto-generated constructor stub
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getVersement() {
		return versement;
	}

	public void setVersement(int versement) {
		this.versement = versement;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}
	
	public int getMontant() {
		
		int montantepargne=0;
		for(int i =0; i<duree ; i++) {
			montantepargne += montantepargne*(taux/1200)+versement;
		}
		return montantepargne;
	}
	
	

}
