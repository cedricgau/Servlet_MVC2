package count;
import java.util.HashMap;
import java.util.Map;

public class CountFormBean {
	private String duree="";
	private String versement="";
	private String taux= "";
	private Map<String,String> errors = new HashMap<>();
	
	public CountFormBean() {
		
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		
		this.duree = duree;
	}

	public String getVersement() {
		
		return versement;
	}

	public void setVersement(String versement) {
		
		this.versement = versement;
	}

	public String getTaux() {
		return taux;
	}

	public void setTaux(String taux) {
		
		this.taux = taux;
	}
	
	
	public Map getErrors() {
		return errors;
	}
	
	public void validate() {
		if(this.getDuree().isEmpty()) errors.put("duree", "  le champs nom ne doit pas être vide et exprimé en nombre de mois");
		if(this.getVersement().isEmpty()) errors.put("versement", "  le champs nom ne doit pas être vide et correspond au versement annuel en euro");
		if(this.getTaux().isEmpty()) errors.put("taux", "  le champs nom ne doit pas être vide et correspond au taux d'intérêt annuel");
		boolean b=true;
        try {
            Float f = Float.parseFloat(this.getDuree());
            Float g = Float.parseFloat(this.getVersement());
            Float h = Float.parseFloat(this.getTaux());
        } catch (NumberFormatException e) {
            b = false;
        }
		if(b==false) errors.put("chiffre", "  Tous les champs doivent comporter uniquement des chiffres !!!");
		
	}
	
	public boolean isValid() {		
		if (errors==null || errors.size()==0) return true;
		return false;
	}
	

}
