package com.ericsson.urm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

public abstract class HttpRequestUtil {
	
	public static enum Method {
		GET, POST;
	}
	
	private static Logger logger = Logger.getLogger(HttpRequestUtil.class);

	/**
	 * Makes a HTTP request to a URL and receive response
	 * @param requestUrl the URL address
	 * @param method Indicates the request method, "POST" or "GET"
	 * @param params a map of parameters send along with the request
	 * @param encoding
	 * @return An array of String containing text lines in response
	 * @throws IOException
	 */
	public static String sendHttpRequest(String requestUrl, Method method,
			Map<String, String> params, String encoding) throws IOException {
		
		ArgumentsCheckerUtil.checkString(requestUrl,"requestUrl");
		URL url = null;
		URLConnection urlConn = null;
		BufferedReader reader = null;
		
		StringBuilder response = new StringBuilder();
		
		if(encoding==null || encoding.trim().length()==0) {
			encoding = "UTF-8";
		}

		StringBuffer requestParams = new StringBuffer();

		if (params != null && params.size() > 0) {
			Iterator<String> paramIterator = params.keySet().iterator();
			while (paramIterator.hasNext()) {
				String key = paramIterator.next();
				String value = params.get(key);
				if(requestParams.length()>0) {
					requestParams.append("&");
				}
				requestParams.append(URLEncoder.encode(key, encoding));
				requestParams.append("=").append(URLEncoder.encode(value, encoding));
			}
		}

		try {
			url = new URL(requestUrl);
			urlConn = url.openConnection();
		} catch (MalformedURLException e) {
			logger.error("--> MalformedURL : "+requestUrl);
			throw e;
		} catch (IOException e) {
			logger.error("--> Open connection failed URL: "+requestUrl+"\nOrigMsg.:"+e.getMessage());
			throw e;
		}
		
		urlConn.setUseCaches(false);

		// the request will return a response
		urlConn.setDoInput(true);

		if (method.equals(Method.POST)) {
			// set request method to POST
			urlConn.setDoOutput(true);
		} else {
			// set request method to GET
			urlConn.setDoOutput(false);
		}

		if (method.equals(Method.POST) && requestParams!=null && requestParams.length() > 0) {
			OutputStreamWriter writer = null;
			try {
				writer = new OutputStreamWriter(urlConn.getOutputStream());
				writer.write(requestParams.toString());
			} catch (Exception e) {
				logger.error("--> MalformedURL : "+requestUrl);
			} 
			finally {
				if(writer!=null) {
					writer.close();
				}
			}
		}

		// reads response into a String
		reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		try {
			reader = new BufferedReader( new InputStreamReader( urlConn.getInputStream() ) );

			String line;
			while ( (line = reader.readLine()) != null ) {
				response.append(line+"\n"); 
			}
		
		} catch (IOException e) {
			logger.error("Received response failed, invoking url:"+requestUrl+"; Orig.Msg:"+e.getMessage());
			throw e;
		}
		finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					logger.error("Error while closing the input stream; "+e.getMessage());
				}
			}
		}
		
		return response.toString();
	}
	
	public static String sendHttpRequest(String requestUrl, Method method, Map<String, String> params) throws IOException {
		
		return sendHttpRequest(requestUrl, method, params, null);
	}
}
