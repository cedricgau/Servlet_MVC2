package count;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ICommand {
	String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;

}
