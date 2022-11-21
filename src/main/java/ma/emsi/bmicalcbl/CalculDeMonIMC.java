package ma.emsi.bmicalcbl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class CalculDeMonIMC extends HttpServlet {
    private Imc imc;

    // Initialisation du servlet
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // Création d'un objet Imc
        imc = new Imc(0, 0);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        // Récupération des paramètres
        imc.setPoids(Double.parseDouble(request.getParameter("poids")));
        imc.setTaille(Double.parseDouble(request.getParameter("taille")));

        // Affichage du résultat
        out.println("Taille : " + imc.getTaille());
        out.println("Poids : " + imc.getPoids());
        out.println("Votre IMC est de " + imc.calculerIMC());
    }
}
