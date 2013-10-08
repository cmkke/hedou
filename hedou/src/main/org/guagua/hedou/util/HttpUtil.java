package org.guagua.hedou.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpUtil
{
	private static final int CONNECT_TIMEOUT = 5000;
	private static final int READ_TIMEOUT = 20000;

	public static String get(String url, String charset) throws Exception
	{
		GetMethod m = new GetMethod(url);
		StringBuilder rsp = new StringBuilder();
		HttpClient httpClient = null;
		BufferedReader br = null;
		SimpleHttpConnectionManager simpleHttpConnectionManager;
		try
		{
			m.setRequestHeader("Connection", "close");
			httpClient = new HttpClient();
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(CONNECT_TIMEOUT);

			httpClient.getHttpConnectionManager().getParams().setSoTimeout(READ_TIMEOUT);

			if (httpClient.executeMethod(m) == 200)
			{
				br = new BufferedReader(new InputStreamReader(m.getResponseBodyAsStream(), charset));

				boolean first = true;
				try
				{
					String line;
					while ((line = br.readLine()) != null)
					{
						if (first)
							first = false;
						else
						{
							rsp.append('\n');
						}
						rsp.append(line);
					}
				} catch (Exception e)
				{
					throw e;
				} finally
				{
					try
					{
						br.close();
					} catch (Exception e)
					{
					}
				}
			}
			return rsp.toString();
		} catch (Exception e)
		{
			throw e;
		} finally
		{
			try
			{
				m.releaseConnection();
				simpleHttpConnectionManager = (SimpleHttpConnectionManager) httpClient.getHttpConnectionManager();

				if (simpleHttpConnectionManager != null)
					simpleHttpConnectionManager.shutdown();
			} catch (Exception e)
			{
			}
		}
	}

	public static String get(String url) throws Exception
	{
		return get(url, "UTF-8");
	}
}