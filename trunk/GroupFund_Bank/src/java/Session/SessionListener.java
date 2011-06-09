/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author BinhNX
 */
public class SessionListener implements HttpSessionListener {
    private static int totalActiveSessions;
 
  public static int getTotalActiveSession(){
	return totalActiveSessions;
  }
 
  @Override
  public void sessionCreated(HttpSessionEvent arg0) {
	totalActiveSessions++;
	System.out.println("sessionCreated - add one session into counter");
        try {
            SessionsFacadeLocal ssfacade = (SessionsFacadeLocal)(new InitialContext().lookup("java:module/SessionsFacade"));
            Sessions ss = new Sessions();
            ss.setSessionid(arg0.getSession().getId());
            System.out.print(arg0.getSession().getId());
            ssfacade.create(ss);
        } catch (NamingException ex) {
            Logger.getLogger(SessionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex)
        {
            System.out.print("Error");
        }
  }
 
  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
	totalActiveSessions--;
	System.out.println("sessionDestroyed - deduct one session from counter");
  }	
}
