<%@page import="count.CountFormBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="count.CountFormBean" scope="session"  />
<jsp:useBean id="bean2" class="count.CountBean" scope="session"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage de l'Epargne</title>
</head>
<body>
<p>
<img src="image/logo-HSBC.jpg">
</p>

<h1>Votre Projet d'épargne</h1>

<% bean = (CountFormBean) (session.getAttribute("countformbean"));%>

<%bean2.setDuree(Integer.parseInt(bean.getDuree()));%>
<%bean2.setVersement(Integer.parseInt(bean.getVersement()));%>
<%bean2.setTaux(Float.parseFloat(bean.getTaux()));%>		

<p>Vous versez <%=bean.getVersement() %>€ tous les mois pendant <%=bean.getDuree() %> mois.</p>
<p>Notre compte rémunéré à <%=bean.getTaux()%>% vous permet de bénéficier d'un montant de <jsp:getProperty property="montant" name="bean2"/> €.
<p><a href="formulaireEpargne.jsp">Autre simulation</a>

<p>Pour prendre un rendez-vous avec votre conseillé, remplissez le formulaire plus bas</p>
<form action="rdv" method="get">
<p> nom &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<input type="text" name="nom" value="gautier"> </p>
<p> prénom &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;<input type="text" name="prenom" value="cedric"> </p>
<p> Votre numéro de compte <input type="text" name="compte" value="025545896610100"> </p>
<p> <input type="hidden" name="montant" value='<jsp:getProperty property="montant" name="bean2"/>'>
<p><input type="submit" value="Prendre un rendez-vous"></p>
</form>
</body>
</html>