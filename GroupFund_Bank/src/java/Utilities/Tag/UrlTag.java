/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.Tag;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author BinhNX
 */
public class UrlTag extends TagSupport {
    private Boolean _secure;
    private String _url;
    
    public void setSecure(Boolean secure)
    {
        _secure = secure;
    }
    
    public void setUrl(String url)
    {
        _url = url;
    }
    
    @Override
    public int doStartTag() throws JspException {

        System.out.print(_url);
        if (_secure == null) _secure = false;
        JspWriter out = pageContext.getOut();
        ServletRequest servletRequest = pageContext.getRequest();
        ServletResponse servletResponse = pageContext.getResponse();
        
        String serverPath = _secure? servletRequest.getServletContext().getInitParameter("ServerSecurePath") :
                servletRequest.getServletContext().getInitParameter("ServerPath");
        String url = ((HttpServletResponse)servletResponse).encodeURL(serverPath
                 + servletRequest.getServletContext().getInitParameter("ContextPath")
                 + _url);
        try {
            out.print(url);
        } catch (IOException ex) {
            Logger.getLogger(UrlTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return super.doStartTag();
    }

    @Override
    public void release() {
            _secure = null;
            _url = "";
    }
    
}
