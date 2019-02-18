package shared_parking;

import java.math.*;

public class User
{
	/**
	 * �������Ҫ�ǽ���������ɸ���location��time�����ƥ��
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
	 * ����������ڰ����ɵ���Щ���ص��ʱ�����ݴ����ȥ
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
