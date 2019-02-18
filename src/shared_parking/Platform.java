package shared_parking;

import java.math.*;
import java.util.*;

public class Platform
{
	/**
	 * 1、生成密钥
	 * 2、计算
	 */
	public static final Paillier P = new Paillier();
	
	/**
	 * 告诉服务器平台需要哪个块的信息
	 * @return
	 */
	public static String get_block()
	{
		BigInteger user_longitude_xy = Platform.P.Decryption(Server.get_user_longitude());
		BigInteger user_latitude_xy = Platform.P.Decryption(Server.get_user_latitude());
		ArrayList<BigInteger> list_longitude = Server.get_list_longitude();
		ArrayList<BigInteger> list_latitude = Server.get_list_latitude();
		int i = 0;
		int j = 0;
		
		for(;i<list_longitude.size();i++)
		{
			if(user_longitude_xy.compareTo(Platform.P.Decryption(list_longitude.get(i))) == -1)
			{
				break;
			}
			
			
		}
		
		for(;j<list_latitude.size();j++)
		{
			if(user_latitude_xy.compareTo(Platform.P.Decryption(list_latitude.get(j))) == -1)
			{
				break;
			}
			
		}
		
		return String.valueOf(i-1)+String.valueOf(j-1);
	}
	
	/**
	 * 
	 * 计算结果
	 * @throws Exception 
	 * 
	 */
	public static void get_result() throws Exception
	{
		BigInteger[] trapezoid = Server.get_trapezoid();
		ArrayList<BigInteger> list_longitude_xy = Server.get_provider_longitude();
		ArrayList<BigInteger> list_latitude_xy = Server.get_provider_latitude();
		ArrayList<BigInteger> list_time_first_xy = Server.get_provider_time_first();
		ArrayList<BigInteger> list_time_last_xy = Server.get_provider_time_first();
		for(int i = 0;i<list_longitude_xy.size();i++)
		{
			if(Platform.P.Decryption(list_longitude_xy.get(i)).compareTo(Platform.P.Decryption(trapezoid[0]))==-1&&Platform.P.Decryption(list_longitude_xy.get(i)).compareTo(Platform.P.Decryption(trapezoid[1]))>=0)
			{
				if(Platform.P.Decryption(list_latitude_xy.get(i)).compareTo(Platform.P.Decryption(trapezoid[2]))==-1&&Platform.P.Decryption(list_latitude_xy.get(i)).compareTo(Platform.P.Decryption(trapezoid[3]))>=0)
				{
					//if(Platform.P.Decryption(list_time_first_xy.get(i)).compareTo(Platform.P.Decryption(Server.get_user_time_first()))<=0 && Platform.P.Decryption(list_time_last_xy.get(i)).compareTo(Platform.P.Decryption(Server.get_user_time_last()))>=0)
					{
						System.out.println(i);
					}
				}
			}
		}
		
		
	}
	
}
