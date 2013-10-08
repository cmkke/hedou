package org.guagua.hedou.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Sequence
{
	private static AtomicInteger seq = new AtomicInteger(0);

	public static String getNowDateTimeString(String type)
	{
		Date date = new Date();
		SimpleDateFormat formattxt = new SimpleDateFormat(type);
		return formattxt.format(date);
	}

	/**
	 * 10+时间+序列号+uid
	 * @param uid
	 * @return
	 */
	public static String getOrdersId(String uid)
	{
		StringBuffer sbstr = new StringBuffer();
		seq.compareAndSet(999, 0);
		sbstr.append("10");
		sbstr.append(getNowDateTimeString("yyyyMMddHHmmssSS"));
		sbstr.append(Integer.toString(seq.getAndAdd(1)));
		sbstr.append(uid);
		return sbstr.toString();
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			String str = getOrdersId("81029203");
			System.out.println(str);
			System.out.println(str.length());
		}

		System.out.println(getNowDateTimeString("yyyy-MM-dd HH:mm:ss"));
	}
}