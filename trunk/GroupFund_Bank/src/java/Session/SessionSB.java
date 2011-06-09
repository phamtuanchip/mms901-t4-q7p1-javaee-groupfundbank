/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entities.Groups;
import Entities.Users;
import Entities.UsersFacadeLocal;
import Ultilities.Encryption;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author binhnx218
 * Funny class name :)
 */
@Stateless
@LocalBean
public class SessionSB {

    public Entities.Users getUserSessionInfo(HttpSession session) throws Exception
    {
        String loginKey = (String)session.getAttribute("__loginKey");
        String userInfo = (String)session.getAttribute("__userInfo");
        if (loginKey == null || userInfo == null) return null;
        if ( loginKey.isEmpty() || userInfo.isEmpty())
            return null;
        else
        {
            String[] info = userInfo.split("_");
            Encryption enc = new Encryption();
            String[] user = enc.decrypt(info[1], loginKey, info[0]).split("_");         
            Users u = new Users();
            u.setUserid(user[1]);
            u.setPassword(user[2]);
            u.setGroupid(new Groups( Short.parseShort(user[0]) ));
            return u;
        }       
    }
    
    public void setUserSessionInfo(final HttpSession session, Entities.Users user) throws Exception
    {
        String encrypt = user.getGroupid().getGroupid().toString() + "_" 
                + user.getUserid() + "_" +  user.getPassword();
        Ultilities.Encryption enc = new Encryption();
        String loginKey = enc.init();
        String[] result = enc.encrypt(loginKey, encrypt);
        String encrypted = result[0] + "_" + result[1];
        session.setAttribute("__loginKey", loginKey);
        session.setAttribute("__userInfo", encrypted);
    }
    
    public void clearUserSessionInfo(final HttpSession session)
    {
        session.removeAttribute("__loginKey");
        session.removeAttribute("__userInfo");
    }
    
    /*
    public boolean isValidUser(String username, String password) throws NamingException
    {
         UsersFacadeLocal usersFacade = (UsersFacadeLocal) new InitialContext().lookup("java:module/UsersFacade");
         return usersFacade.isValidUser(username, password);
    }
    
    public boolean isValidUser(Users user) throws NamingException
    {
         UsersFacadeLocal usersFacade = (UsersFacadeLocal) new InitialContext().lookup("java:module/UsersFacade");
         return usersFacade.isValidUser(user);
    }
    
    public Users getUserInfo(String username, String password) throws NamingException
    {
        UsersFacadeLocal usersFacade = (UsersFacadeLocal) new InitialContext().lookup("java:module/UsersFacade");
        Users u = usersFacade.getUserInfo(username, password);
        if (u==null) return null;
        else return u;
    }
     * 
     */
}
