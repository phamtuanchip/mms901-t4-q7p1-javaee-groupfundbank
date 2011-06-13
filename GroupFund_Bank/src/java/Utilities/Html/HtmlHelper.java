/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Html;

import Utilities.Validation.ValidationHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BinhNX
 */
@Stateless
public class HtmlHelper implements HtmlHelperLocal {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void BeginForm(HttpServletRequest request, HttpServletResponse response, String legend) throws IOException
    {
        PrintWriter out = response.getWriter();
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        if (!queryString.isEmpty()) queryString = "?" + queryString;
        out.println("<form action=\"" + requestURI + queryString + "\" method=\"POST\">");
        out.println("<fieldset>");
        out.println("<legend>" + legend + "</legend>");
    }
    @Override
    public void BeginForm(PrintWriter out, String submitForm, String legend) throws IOException
    {
        out.println("<form action=\"" + submitForm + "\" method=\"POST\">");
        out.println("<fieldset>");
        out.println("<legend>" + legend + "</legend>");
    }
    @Override
    public void EndForm(PrintWriter out, String submit)
    {
        out.println("<input type=\"submit\" value=\"" + submit + "\" >");
        out.println("</fieldset>");
        out.println("</form>");
    }
    @Override
    public void DisplayFor(PrintWriter out, String id, String label, Object value)
    {
        out.println("<div class=\"display-label\">");
        out.println("<label for=\"" + id + "\">" + label + "</label>");
        out.println("</div>");
        out.println("<div class=\"display-field\">");
        out.println("<label for=\"" + id + "\">" + value + "</label>");
        out.println("</div>");
        
    }
    @Override
    public void EditorFor(PrintWriter out, String id, String label)
    {
        out.println("<div class=\"editor-label\">");
        out.println("<label for=\"" + id + "\">" + label + "</label>");
        out.println("</div>");
        out.println("<div class=\"editor-field\">");
        out.println("<input id=\""+ id + "\" type=\"text\" />");
        out.println("</div>");      
    }
    @Override
    public void EditorFor(PrintWriter out, String id, String label, Object value)
    {
        out.println("<div class=\"editor-label\">");
        out.println("<label for=\"" + id + "\">" + label + "</label>");
        out.println("</div>");
        out.println("<div class=\"editor-field\">");
        out.println("<div class=\"editor-field\">");
        out.println("<input id=\""+ id + "\""
                + " name=\""+ id + "\""
                + " class=\"text-box single-line\""
                + " type=\"text\" value=\"" + value + "\""
                + " >");
        out.println("</div>");      
    }
    @Override
    public void EditorFor(PrintWriter out, String id, String name, String label, Object value)
    {
        out.println("<div class=\"editor-label\">");
        out.println("<label for=\"" + id + "\">" + label + "</label>");
        out.println("</div>");
        out.println("<div class=\"editor-field\">");
        out.println("<div class=\"editor-field\">");
        out.println("<input id=\""+ id + "\""
                + " name=\""+ name + "\""
                + " class=\"text-box single-line\""
                + " type=\"text\" value=\"" + value + "\""
                + " >");
        out.println("</div>");      
    }
    @Override
    public void EditorFor(PrintWriter out, String id, String name, String label, ValidationHelper validation, Object value)
    {
        out.println("<div class=\"editor-label\">");
        out.println("<label for=\"" + id + "\">" + label + "</label>");
        out.println("</div>");
        out.println("<div class=\"editor-field\">");
        out.println("<input id=\""+ id + "\""
                + " name=\""+ name + "\""
                + " class=\"text-box " + "\""
                + " type=\"text\" value=\"" + value + "\""
                + " validation-msg=\"" + "\" />");
        out.println("<span class=\"field-validation-valid\" data-valmsg-replace=\"true\" data-valmsg-for=\"ProductName\"></span>");
        out.println("</div>");      
    }
    @Override
    public void DisplayError(AppError error, HttpServletResponse response, String Url, String UrlTitle) throws IOException
    {
        PrintWriter out = response.getWriter();
        switch (error)
        {
            case InputUrlParameter:
            {
                out.println("<p>Your request contain invalid parameter</p>");
                out.println("<p>Please double-check the URL</p>");
                out.println("<p>You may want to return <a href=\"" + Url + "\">" + UrlTitle + "</a></p>");
                break;
            }
            case ServerDataMissing:
            {
                out.println("<p>Sorry, but we do not found data for your request</p>");
                out.println("<p>If you reach this page by typing an URL at browser's address bar, please double-check the URL</p>");
                out.println("<p>If you have been successful in accessing this page before, this may be our database error</p>");
                out.println("<p>You may want to return <a href=\"" + Url + "\">" + UrlTitle + "</a></p>");
                break;
            }
        }
    }
    @Override
    public void Redirect(HttpServletResponse response, String Url) throws IOException
    {
        response.sendRedirect(Url);
    }
}
