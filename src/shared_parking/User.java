package shared_parking;

import java.math.*;

public class User
{
	/**
	 * 这个类主要是进行随机生成各种location和time点进行匹配
	 */
	public int longitude;
	public int latitude;
	public int time[] = new int[2];
	
	public User()
	{
		this.longitude = (int)(103601167 + Math.random()*442337);
		this.latitude = (int)(1237810 + Math.random()*233715);
		this.time[0] = (int)(0 + Math.random()*144);
		this.time[1] = (int)(this.time[0] + 1 + Math.random()*(144 - this.time[0]));
		
	}
	
	/**
	 * 这个方法用于把生成的这些个地点和时间数据传输出去
	 * @param args
	 */
	
	public BigInteger get_longitude()
	{
		return Platform.P.Encryption(new BigInteger(String.valueOf(this.longitude)));
		 
	}
	
	public BigInteger get_latitude()
	{
		return Platform.P.Encryption(new BigInteger(String.valueOf(this.latitude)));
		 
	}
	
	public BigInteger get_time_first()
	{
		return Platform.P.Encryption(new BigInteger(String.valueOf(this.time[0])));
		 
	}
	
	public BigInteger get_time_last()
	{
		return Platform.P.Encryption(new BigInteger(String.valueOf(this.time[1])));
		 
	}
	
	
	
	
	
}
