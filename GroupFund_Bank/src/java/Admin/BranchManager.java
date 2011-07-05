/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Entities.Branch;
import Entities.BranchFacadeLocal;
import Utilities.Html.HtmlHelperLocal;
import Utilities.Validation.RangeValidation;
import Utilities.Validation.Validation;
import Utilities.Validation.ValidationHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "BranchManager", urlPatterns = {"/Admin/Branch"})
public class BranchManager extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static enum Action {
        List, Search, Create, Update, Delete 
    };
    private Action action = Action.Search;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String act = request.getParameter("act") ;
            if (act == null) act="search";
            if ("search".equals(act.toLowerCase()))
            {
                action = Action.Search;
            }
            else if ("create".equals(act.toLowerCase()))
            {
                action = Action.Create;
            }
            else if ("update".equals(act.toLowerCase()) || "edit".equals(act.toLowerCase()))
            {
                action = Action.Update;
            }
            else if ("delete".equals(act.toLowerCase()))
            {
                action = Action.Delete;
            }
            else if ("list".equals(act.toLowerCase()))
            {
                action = Action.List;
            }
            /* TODO output your page here
            
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
        //response.
        processRequest(request, response);
        printLayout(request, response);
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
        processRequest(request, response);
        switch (action)
        {
            case Search:
            {
                //TODO: Search
                break;
            }
            case List:
            {
                printLayout(request, response);
                break;
            }
            case Create:
            {
                PrintWriter pw = response.getWriter();
                pw.println("Test dispatcher");
                       
                String name =  request.getParameter("BranchName");
                String location = request.getParameter("BranchLocation");
                String phone = request.getParameter("BranchPhone");
                System.out.println(name);
                System.out.println(location);
                System.out.println(phone);
                try {
                    BranchFacadeLocal branchFacade = (BranchFacadeLocal) new InitialContext().lookup("java:module/BranchFacade");
                    
                    Branch newBranch = new Branch();
                    //newBranch.setBranchid(2);
                    newBranch.setBranchname(name);
                    newBranch.setBranchlocation(location);
                    newBranch.setBranchphone(phone);
                    //branchFacade.
                    branchFacade.create(newBranch);
                } catch (NamingException ex) {
                    Logger.getLogger(BranchManager.class.getName()).log(Level.SEVERE, null, ex); 
                } catch (EJBException ex)
                {
                    RequestDispatcher rd = request.getRequestDispatcher("Users");
                    
                    rd.forward(request, response);
                    
                }
                break;
            }
            default:
            {
                break;
            }
                
        }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void printLayout(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            switch (action)
            {
                case Search:
                {
                    out.println("<title>Search for branches</title>");
                    out.println("</head>");
                    out.println("<body>");
                    getSearch(request, response);
                    break;
                }
                case List:
                {
                    out.println("<title>Branch List</title>");
                    out.println("</head>");
                    out.println("<body>");
                    list(request, response);
                    break;
                }
                case Update:
                {
                    out.println("<title>Update branch</title>");
                    out.println("</head>");
                    out.println("<body>");
                    getUpdate(request, response);
                    break;
                }
                case Create:
                {
                    out.println("<title>Create branch</title>");
                    out.println("</head>");
                    out.println("<body>");
                    getCreate(request, response);
                    break;
                }
                case Delete:
                {
                    out.println("<title>Delete branch</title>");
                    out.println("</head>");
                    out.println("<body>");
                    getDelete(request, response);
                    break;
                }
                default:
                {
                    out.println("<title>Search for branches</title>");
                    out.println("</head>");
                    out.println("<body>");
                    getSearch(request, response);
                    break;
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception ex)
        {
            System.out.print("error at branch manager");
        }
        finally 
        {
            //out.close();
        }
    }
    private void getCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException
    {
        HtmlHelperLocal HtmlHelper = (HtmlHelperLocal) new InitialContext().lookup("java:module/HtmlHelper");
        PrintWriter out = response.getWriter();
        out.print("<div id='main'>");
        HtmlHelper.BeginForm(request, response, "Create Branch");
        HtmlHelper.EditorFor(out, "BranchName", "Name");
        HtmlHelper.EditorFor(out, "BranchLocation", "Location");
        HtmlHelper.EditorFor(out, "BranchPhone", "Phone");
        HtmlHelper.EndForm(out, "Create");
        out.print("</div>");
    }
    private void getUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException, Exception
    {
        PrintWriter out = response.getWriter();
        int id = 0;
        int error = 0;
        out.print("<div id='main'>");
        InitialContext context = new InitialContext();
        BranchFacadeLocal branchFacade = (BranchFacadeLocal) context.lookup("java:module/BranchFacade");
        HtmlHelperLocal HtmlHelper = (HtmlHelperLocal) context.lookup("java:module/HtmlHelper");
        try
        {
            id = Integer.parseInt(request.getParameter("id"));
        }
        catch (Exception ex)
        {
            HtmlHelper.DisplayError(HtmlHelperLocal.AppError.InputUrlParameter, response, request.getRequestURI(), "Branch Manager home page");
            error = 1;
        }
        if (error == 0)
        {
            Validation rev = new RangeValidation(5, 100);
            ValidationHelper helper = new ValidationHelper();
            helper.add(rev);
            Branch branch = branchFacade.find(id);
            if (branch != null)
            {
            HtmlHelper.BeginForm(request, response, "Update Branch");
            HtmlHelper.EditorFor(out, "BranchName", "Name", branch.getBranchname());
            HtmlHelper.EditorFor(out, "BranchLocation", "Location", branch.getBranchlocation());
            HtmlHelper.EditorFor(out, "BranchPhone", "Phone", branch.getBranchphone());
            HtmlHelper.EndForm(out, "Update");
            out.print(((RangeValidation)helper.getvalidationList().get(0)).getMinValue());
            }
            else
            {
                HtmlHelper.DisplayError(HtmlHelperLocal.AppError.ServerDataMissing, response, request.getRequestURI(), "Branch Manager home page");
            }
        }
        out.print("</div>");
    }
    private void getDelete(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
    }
    private void getSearch(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
    }
    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException
    {
        PrintWriter out = response.getWriter();
        HtmlHelperLocal HtmlHelper = (HtmlHelperLocal) new InitialContext().lookup("java:module/HtmlHelper");
        //HtmlHelper.DisplayError(HtmlHelperLocal.AppError.InputUrlParameter, response, null, null);
    }
}
