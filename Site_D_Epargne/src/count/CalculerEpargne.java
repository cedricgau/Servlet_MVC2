package count;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculerEpargne
 */
@WebServlet(urlPatterns={"/affepargne","/rdv"})
public class CalculerEpargne extends HttpServlet implements ICommand {
	private static final long serialVersionUID = 1L;
	// 1. Déclarer le LOGGER. Toujours utiliser le nom de la classe, ainsi vous pouvez faire refactoring
		private final static Logger logger = Logger.getLogger(CalculerEpargne.class.getName());
		
	private Map<String,Object> fbv = new HashMap<>();
	private Map<String,Object> trt = new HashMap<>();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculerEpargne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("whom").equalsIgnoreCase("formulaireEpargne")) {
			CountFormBean cfb = new CountFormBean();
			cfb.setDuree(request.getParameter("duree"));
			cfb.setVersement(request.getParameter("versement"));
			cfb.setTaux(request.getParameter("taux"));
			
			fbv.put("countformbean", cfb);
				
			HttpSession session = request.getSession(true);
			session.setAttribute("countformbean", cfb);
			
			cfb.validate();
			
			if(cfb.isValid()) {
				request.getRequestDispatcher("/afficherEpargne.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/formulaireEpargne.jsp").forward(request, response);
			}
		}else if (request.getParameter("whom").equalsIgnoreCase("formulaireRdv")){
			RdvFormBean rfb = new RdvFormBean();
			rfb.setDateDemande(new Date());
			rfb.setNom(request.getParameter("nom"));
			rfb.setPrenom(request.getParameter("prenom"));
			rfb.setNumcompte(request.getParameter("compte"));
			rfb.setMontant(request.getParameter("montant"));
			
			fbv.put("rdvformbean", rfb);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("rdvformbean", rfb);
			
			
			// 2. Ecrire Logs grace au Logger
			logger.setLevel(Level.SEVERE);
			logger.severe(rfb.getDateDemande().toString());
			logger.warning(rfb.getNom());
			logger.warning(rfb.getPrenom());
			logger.warning(" numéro de compte : "+rfb.getNumcompte()+" , souhaite prendre un rendez-vous avec un conseillé");
			logger.info("Info log");
			logger.finest("Pas du tout important");
			
			// 3. ou utiliser le log d'Apache
			CountFormBean cfb = new CountFormBean();
			cfb = (CountFormBean) session.getAttribute("countformbean");
			String msg = "\n\n\n\n\n\nNous sommes le : "+rfb.getDateDemande().toString()+" , "+rfb.getNom()+" "+rfb.getPrenom()+" , numéro de compte : "+rfb.getNumcompte()+" , souhaite prendre un rendez-vous avec un conseillé.\n Sa dernière simulation : \n versement mensuel : "+cfb.getVersement()+" ; durée d'épargne : "+cfb.getDuree()+" ; rémunération : "+cfb.getTaux()+"% par an; épargne finale : "+rfb.getMontant();
			this.log(msg);
			request.getRequestDispatcher("/afficherConfirmRdv.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/formulaireEpargne.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
