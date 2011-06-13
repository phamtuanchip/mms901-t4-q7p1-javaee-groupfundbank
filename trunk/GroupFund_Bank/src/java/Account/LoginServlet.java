/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import Utilities.Encryption.Hash;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author binhnx218
 */
public class LoginServlet extends HttpServlet {
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String _serverPath;
    String _serverSecurePath;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, Exception {
        /*
        _serverPath = this.getServletContext().getInitParameter("ServerPath");
        _serverSecurePath = this.getServletContext().getInitParameter("ServerSecurePath");
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();
        String returnUrl = (request.getParameter("returnUrl") != null ?
                        request.getParameter("returnUrl") : _serverPath + "/index.jsp");
        SessionSB sessionMng = (SessionSB)new InitialContext().lookup("java:module/SessionSB");
        Entities.Users u = sessionMng.getUserSessionInfo(session);
        if (u != null)
        {
            if (sessionMng.isValidUser(u))
                this.redirect(returnUrl, response, session); 
            else
                this.redirect(_serverPath + "/Error?er=SessionData", response, session);
        }
        else
        {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("<script type='text/javascript' src='Script/jquery-1.6.js'></script>");
            out.println("<script type='text/javascript' src='Script/jquery-plugin.js'></script>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
            out.println("<form action='"+response.encodeURL("LoginAuth" ) + "' method='post'>");
            out.println("<input type='hidden' id='hiddenUrl' name='returnUrl' value='" 
                    + request.getParameter("returnUrl") + "' />");
            out.println("<input type='text' id='username' name='username' value='Username' />");
            out.println("<input type='password' id='password' name='password' value='Password' />");
            out.println("<input type='submit' value='Submit' />");
            out.println("<a href='" + returnUrl +"'>Click here</a>");
            out.println("</form>");
            out.println("<script type='text/javascript'>$.ready($('#username').focus());$('input').toggleValue();</script>");
            out.println("</body>");         
        }
         * 
         */
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            this.redirect(_serverPath + "/Error?er=Server", response, null);
        }
        finally
        {
            PrintWriter out = response.getWriter();
            out.close();
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        try
        {   
            processRequest(request, response);
            String salt = this.getServletContext().getInitParameter("salt");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String returnUrl = (request.getParameter("hiddenUrl") != null ?
                        request.getParameter("hiddenUrl") : _serverPath + "/index.jsp");
            SessionSB sessionMng = (SessionSB)new InitialContext().lookup("java:module/SessionSB");
            if ( !(salt == null || username == null || password == null) )
            {
                if (salt.equals("") || username.equals("") || password.equals(""))
                {
                    return;
                }
                else
                {
                    Hash hash = new Hash();
                    salt = hash.MD5(salt);
                    // Thu cho muoi 2 lan xem man den dau :D
                    password = hash.SHA256(hash.SHA256(salt) + hash.SHA256(salt + hash.MD5( (username + password ))));
                    Entities.Users usr = (sessionMng.getUserInfo(username, password));
                    if (usr != null)        
                    {
                        sessionMng.setUserSessionInfo(request.getSession(), usr);
                        redirect(returnUrl, response,session);
                    }
                    else
                    {
                        out.print("Invalid username or password");
                    }
                }
            }
            else
            {
                redirect(_serverPath + "/Error?er=UserInput", response,session);
            }         
        }
        catch(Exception ex)
        {
            ex.printStackTrace(out);
            //redirect(_serverPath + "/Error?er=Server", response,session);
            return;
        }
        finally
        {
            out.close();
        }
         * 
         */
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void redirect(String returnUrl, final HttpServletResponse response, HttpSession session) 
            throws IOException
    {
        String jsessionId = response.encodeURL("u").equals("u")? "" : ";jsessionid="+session.getId();
        if (returnUrl.equals("")) returnUrl= _serverPath + "/index.jsp";
        if (!returnUrl.startsWith("http")) returnUrl = "http://" + returnUrl;
        returnUrl+=jsessionId;
        if (returnUrl.startsWith(_serverPath) || returnUrl.startsWith(_serverSecurePath))
        {
            response.sendRedirect(returnUrl);
        }
        else 
        {
            response.sendRedirect(_serverPath + "/Error?er=ExternalURL");
        }
    }
    // </editor-fold>
    
}
