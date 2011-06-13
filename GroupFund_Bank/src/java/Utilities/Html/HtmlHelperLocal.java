/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Html;

import Utilities.Validation.ValidationHelper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BinhNX
 */
@Local
public interface HtmlHelperLocal {
    public enum AppError
    {
        InputUrlParameter,
        InputFormParameter,
        ServerDataMissing
    }
    
    public void BeginForm(HttpServletRequest request, HttpServletResponse response, String legend) throws IOException;
    public void BeginForm(PrintWriter out, String submitForm, String legend) throws IOException;
    public void EndForm(PrintWriter out, String submit);
    public void DisplayFor(PrintWriter out, String id, String label, Object value);
    public void EditorFor(PrintWriter out, String id, String label);
    public void EditorFor(PrintWriter out, String id, String label, Object value);
    public void EditorFor(PrintWriter out, String id, String name, String label, Object value);
    public void EditorFor(PrintWriter out, String id, String name, String label, ValidationHelper validation, Object value);
    public void DisplayError(AppError error, HttpServletResponse response, String Url, String UrlTitle) throws IOException;
    public void Redirect(HttpServletResponse response, String Url) throws IOException;
    
}
