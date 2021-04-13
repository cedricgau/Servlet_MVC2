package count;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculerEpargne
 */
@WebServlet(urlPatterns="/affepargne")
public class CalculerEpargne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		CountFormBean cfb = new CountFormBean();
		cfb.setDuree(request.getParameter("duree"));
		cfb.setVersement(request.getParameter("versement"));
		cfb.setTaux(request.getParameter("taux"));
			
		HttpSession session = request.getSession(true);
		session.setAttribute("countformbean", cfb);
		
		cfb.validate();
		
		if(cfb.isValid()) {
			request.getRequestDispatcher("/afficherEpargne.jsp").forward(request, response);
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

}
