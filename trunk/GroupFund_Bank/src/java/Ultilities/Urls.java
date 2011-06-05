/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net
*/
/*
 * Created on Jun 12, 2005
 */
package Ultilities;


import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

public class Urls {
  private static final Logger logger = Logger.getLogger(Urls.class.getName());
  public static final DateFormat PATTERN_RFC1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);

  static {
    DateFormat df = PATTERN_RFC1123;
    df.setTimeZone(TimeZone.getTimeZone("GMT"));
  }
  
  private Urls() {
    super();
  }

  /** Whether the URL refers to a resource in the local file system. */
  public static boolean isLocal(java.net.URL url) {
    if(isLocalFile(url)) {
      return true;
    }
    String protocol = url.getProtocol();
    if("jar".equalsIgnoreCase(protocol)) {
      String path = url.getPath();
      int emIdx = path.lastIndexOf('!');
      String subUrlString = emIdx == -1 ? path : path.substring(0, emIdx);
      try {
        URL subUrl = new URL(subUrlString);
        return isLocal(subUrl);
      } catch(java.net.MalformedURLException mfu) {
        return false;
      }
    }
    else {
      return false;
    }
  }
  
  /** Whether the URL is a file in the local file system. */
  public static boolean isLocalFile(java.net.URL url) {
    String scheme = url.getProtocol();
    return "file".equalsIgnoreCase(scheme) && !hasHost(url);
  }

  public static boolean hasHost(java.net.URL url) {
    String host = url.getHost();
    return host != null && !"".equals(host);
  }

  /**
   * Creates an absolute URL in a manner equivalent to
   * major browsers. 
   */
  public static URL createURL(URL baseUrl, String relativeUrl) throws java.net.MalformedURLException {
    return new URL(baseUrl, relativeUrl);
  } 
  
  /**
   * Returns the time when the document should be considered expired.
   * The time will be zero if the document always needs to be revalidated.
   * It will be <code>null</code> if no expiration time is specified.
   */
  public static Long getExpiration(URLConnection connection, long baseTime) {
    String cacheControl = connection.getHeaderField("Cache-Control");
    if(cacheControl != null) {
      StringTokenizer tok = new StringTokenizer(cacheControl, ",");
      while(tok.hasMoreTokens()) {
        String token = tok.nextToken().trim().toLowerCase();
        if("must-revalidate".equals(token)) {
          return new Long(0);
        }
        else if(token.startsWith("max-age")) {
          int eqIdx = token.indexOf('=');
          if(eqIdx != -1) {
            String value = token.substring(eqIdx+1).trim();
            int seconds;
            try {
              seconds = Integer.parseInt(value);
              return new Long(baseTime + seconds * 1000);
            } catch(NumberFormatException nfe) {
              logger.log(   Level.WARNING, "getExpiration(): Bad Cache-Control max-age value: {0}", value);
              // ignore
            }
          }
        }
      }
    }
    String expires = connection.getHeaderField("Expires");
    if(expires != null) {
      try {
        synchronized(PATTERN_RFC1123) {
          Date expDate = PATTERN_RFC1123.parse(expires);
          return new Long(expDate.getTime());
        }
      } catch(java.text.ParseException pe) {
        int seconds;
        try {
          seconds = Integer.parseInt(expires);
          return new Long(baseTime + seconds * 1000);
        } catch(NumberFormatException nfe) {
          logger.log(Level.WARNING, "getExpiration(): Bad Expires header value: {0}", expires);
        }
      }
    }
    return null;
  }

  
    private static String getDefaultCharset(URLConnection connection) {
      URL url = connection.getURL();
      if(Urls.isLocalFile(url)) {
        String charset = System.getProperty("file.encoding");
        return charset == null ? "ISO-8859-1" : charset;
      }
      else {
        return "ISO-8859-1";
      }
    }
    
    public static String getNoRefForm(URL url) {
      String host = url.getHost();
      int port = url.getPort();
      String portText = port == -1 ? "" : ":" + port;
      String userInfo = url.getUserInfo();
      String userInfoText = userInfo == null || userInfo.length() == 0 ? "" : userInfo + "@";
      String hostPort = host == null || host.length() == 0 ? "" : "//" + userInfoText + host + portText;
      return url.getProtocol() + ":" + hostPort + url.getFile();
    }


}

   
    