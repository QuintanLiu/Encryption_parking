package shared_parking;

import java.io.*;
import java.math.*;
import java.util.ArrayList;

public class Provider
{
	/**
	 * 这个类的主要作用就是跟存储的数据进行交互，取出数据
	 * @return 
	 * @throws IOException 
	 * 
	 */
	
	
	
	//这个方法用来获取存储的信息的
	public static ArrayList<String> get_file(String s) throws Exception
	{
		// TODO 自动生成的方法存根
		
				//File file=new File("locationTime.txt");
				BufferedReader in = new BufferedReader(new FileReader("file/" + s));
	            String str;
	            ArrayList<String> al = new ArrayList<String>();
	            while ((str = in.readLine()) != null) {
//	                System.out.println(str);
	            	
	                al.add(str);
	            }
	            
	            in.close();
	            return al;
	}
	//返回一个维度信息的列表
	public static ArrayList<BigInteger> get_longitude(String s) throws Exception
	{
		ArrayList<String> al = get_file(s);
		ArrayList<BigInteger> list_longitude = new ArrayList<BigInteger>();
		for(int i = 0;i<al.size();i++)
		{
			String a = al.get(i).split(",")[0];
			list_longitude.add(Platform.P.Encryption(new BigInteger(a)));
			
		}
		
		
		return list_longitude;
		
	}
	
	public static ArrayList<BigInteger> get_latitude(String s) throws Exception
	{
		ArrayList<String> al = get_file(s);
		ArrayList<BigInteger> list_latitude = new ArrayList<BigInteger>();
		for(int i = 0;i<al.size();i++)
		{
			String a = al.get(i).split(",")[1];
			list_latitude.add(Platform.P.Encryption(new BigInteger(a)));
		}
		
		
		return list_latitude;
		
	}
	
	public static ArrayList<BigInteger> get_time_first(String s) throws Exception
	{
		ArrayList<String> al = get_file(s);
		ArrayList<BigInteger> list_time_first = new ArrayList<BigInteger>();
		for(int i = 0;i<al.size();i++)
		{
			String a = al.get(i).split(",")[2];
			list_time_first.add(Platform.P.Encryption(new BigInteger(a)));
		}
		
		
		return list_time_first;
		
	}
	
	
	public static ArrayList<BigInteger> get_time_last(String s) throws Exception
	{
		ArrayList<String> al = get_file(s);
		ArrayList<BigInteger> list_time_last = new ArrayList<BigInteger>();
		for(int i = 0;i<al.size();i++)
		{
			String a = al.get(i).split(",")[3];
			list_time_last.add(Platform.P.Encryption(new BigInteger(a)));
		}
		
		
		return list_time_last;
		
	}
	
	
}
