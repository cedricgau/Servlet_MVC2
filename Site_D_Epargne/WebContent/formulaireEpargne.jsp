<%@page import="count.CountFormBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="count.CountFormBean" scope="request"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Site d'Epargne</title>
</head>
<body>
<p>
<img src="image/logo-HSBC.jpg">
</p>
<h1>Votre Projet d'épargne</h1>

<%if(request.getParameter("duree")==null){%>

	<form action="affepargne" method="get">
	<p>Durée en mois&ensp;<input type=text name="duree" value="12"></p>
	<p>Versement&ensp;&ensp;&ensp;&ensp;<input type=text name="versement" value="10"></p>
	<p>Taux&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;       <input type=text name="taux" value="10"></p>
	<p><input type="submit" value="Calcul investissement"></p>
	</form>
<%}else{ %>

		<% bean = (CountFormBean) (session.getAttribute("countformbean"));%>
		
		<% if(bean.getErrors().get("chiffre")!=null){%><% out.println("<font color=#FF0000>");%><%=bean.getErrors().get("chiffre")%><% out.println("</font>");%><%} %>
		<% out.println("<form action='affepargne' method='get'><p>Durée en mois<input type=text name='duree' value='12'>");%>
		<% if(bean.getErrors().get("duree")!=null){%><% out.println("<font color=#FF0000>");%><%=bean.getErrors().get("duree")%><% out.println("</font>");%><%} %>		
		<% out.println("</p><p>Versement<input type=text name='versement' value='1500'>");%>
		<% if(bean.getErrors().get("versement")!=null){%><% out.println("<font color=#FF0000>");%><%=bean.getErrors().get("versement")%><% out.println("</font>");%><%} %>
		<% out.println("</p><p>Taux<input type=text name='taux' value='2'>");%>
		<% if(bean.getErrors().get("taux")!=null){%><% out.println("<font color=#FF0000>");%><%=bean.getErrors().get("taux")%><% out.println("</font>");%><%} %>
		<% out.println("</p><p><input type='submit' value='Calcul investissement'></p></form>"); %>
<%} %>
</body>
</html>