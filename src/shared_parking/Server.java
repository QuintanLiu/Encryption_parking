package shared_parking;

import java.math.BigInteger;
import java.util.*;

public class Server
{
	/**
	 * 服务器类主要是用平台给出的公钥对各类数据进行加密
	 */
	public static final BigInteger x = new BigInteger(String.valueOf((int) (Math.random()*100)));
	
	public static final BigInteger y = new BigInteger(128,new Random());
	
	private static User user = new User();
	
	
	
	public static BigInteger get_xy_encrption(BigInteger big)
	{
		BigInteger E_axy = big.pow(Server.x.intValue()).multiply(Platform.P.Encryption(Server.y));
		
		return E_axy;
	}
	
	public static BigInteger get_user_longitude()
	{
		
		return Server.get_xy_encrption(user.get_longitude());
	}
	
	public static BigInteger get_user_latitude()
	{
		return Server.get_xy_encrption(user.get_latitude());
	}
	
	public static BigInteger get_user_time_first()
	{
		return Server.get_xy_encrption(user.get_time_first());
	}
	
	public static BigInteger get_user_time_last()
	{
		return Server.get_xy_encrption(user.get_time_last());
	}
	
	
	//返回分块信息
	public static ArrayList<BigInteger> get_list_longitude()
	{
		BigInteger start = new BigInteger("103601167");
		BigInteger dot = new BigInteger("63191");
		ArrayList<BigInteger> list_longitude = new ArrayList<BigInteger>();
		for(int i = 0;i<8;i++)
		{
			BigInteger encrp = start.add(dot.multiply(new BigInteger(String.valueOf(i))));
			
			list_longitude.add(Server.get_xy_encrption(Platform.P.Encryption(encrp)));
		}
		return list_longitude;
	}
	
	//返回分块信息
	public static ArrayList<BigInteger> get_list_latitude()
	{
		BigInteger start = new BigInteger("1237810");
		BigInteger dot = new BigInteger("46743");
		ArrayList<BigInteger> list_latitude = new ArrayList<BigInteger>();
		for(int i = 0;i<6;i++)
		{
			BigInteger encrp = start.add(dot.multiply(new BigInteger(String.valueOf(i))));
			list_latitude.add(Server.get_xy_encrption(Platform.P.Encryption(encrp)));
		}
		return list_latitude;
	}
	
	/**
	 * 对于块里面的内容进行xy加密(纬度信息)
	 * @throws Exception 
	 */
	public static ArrayList<BigInteger> get_provider_longitude() throws Exception
	{
		System.out.println("在哪个块："+Platform.get_block());
		ArrayList<BigInteger> list_longitude = Provider.get_longitude("locationTime"+Platform.get_block()+".txt");
		ArrayList<BigInteger> list_longitude_xy = new ArrayList<BigInteger>();
		for(int i = 0;i<list_longitude.size();i++)
		{
			list_longitude_xy.add(Server.get_xy_encrption(list_longitude.get(i)));
		}
		return list_longitude_xy;
		
	}
	/**
	 *经度信息进行xy加密
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<BigInteger> get_provider_latitude() throws Exception
	{
		System.out.println("在哪个块："+Platform.get_block());
		ArrayList<BigInteger> list_latitude = Provider.get_latitude("locationTime"+Platform.get_block()+".txt");
		ArrayList<BigInteger> list_latitude_xy = new ArrayList<BigInteger>();
		for(int i = 0;i<list_latitude.size();i++)
		{
			list_latitude_xy.add(Server.get_xy_encrption(list_latitude.get(i)));
		}
		return list_latitude_xy;
		
	}
	/**
	 * @throws Exception 
	 * 时间上线加密
	 */
	public static ArrayList<BigInteger> get_provider_time_first() throws Exception
	{
		ArrayList<BigInteger> list_time_first = Provider.get_time_first("locationTime"+Platform.get_block()+".txt");
		ArrayList<BigInteger> list_time_first_xy = new ArrayList<BigInteger>();
		for(int i = 0;i<list_time_first.size();i++)
		{
			list_time_first_xy.add(Server.get_xy_encrption(list_time_first.get(i)));
		}
		return list_time_first_xy;
		
	}
	
	/**
	 * @throws Exception 
	 * 时间下线加密
	 */
	public static ArrayList<BigInteger> get_provider_time_last() throws Exception
	{
		ArrayList<BigInteger> list_time_last = Provider.get_time_last("locationTime"+Platform.get_block()+".txt");
		ArrayList<BigInteger> list_time_last_xy = new ArrayList<BigInteger>();
		for(int i = 0;i<list_time_last.size();i++)
		{
			list_time_last_xy.add(Server.get_xy_encrption(list_time_last.get(i)));
		}
		return list_time_last_xy;
		
	}
	
	
	
	/**
	 * 画一个梯形
	 */
	public static BigInteger[] get_trapezoid()
	{
		BigInteger[] trapezoid = new BigInteger[4];
		trapezoid[0] = Server.get_xy_encrption(user.get_longitude().multiply(Platform.P.Encryption(new BigInteger("4500"))));
		trapezoid[1] = Server.get_xy_encrption(user.get_longitude().multiply(Platform.P.Encryption(new BigInteger("-4500"))));
		trapezoid[2] = Server.get_xy_encrption(user.get_latitude().multiply(Platform.P.Encryption(new BigInteger("4500"))));
		trapezoid[3] = Server.get_xy_encrption(user.get_latitude().multiply(Platform.P.Encryption(new BigInteger("-4500"))));
		return trapezoid;
	}
	
}
