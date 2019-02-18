package shared_parking;

import java.math.*;
import java.util.*;

public class Comparer
{
	public static int compare(int first,int second)
	{
		long startTime=System.currentTimeMillis();   //获取开始时间  
		 
		
		// Bob
		BigInteger b = new BigInteger(String.valueOf(first));
		
		BigInteger x = new BigInteger(String.valueOf((int) (Math.random()*100)));
		
		BigInteger y = new BigInteger(128,new Random());
		
		System.out.println(x.intValue());
		
		//Alice
		BigInteger a = new BigInteger(String.valueOf(second));
		
		Paillier p = new Paillier();
		BigInteger E_a = p.Encryption(a);
		System.out.println("Alice E_a:" + E_a);
		
		//Bob
		BigInteger E_bxy = p.Encryption(b.multiply(x).add(y));
		BigInteger E_axy = E_a.pow(x.intValue()).multiply(p.Encryption(y));
		
		//Ailce
		BigInteger bxy = p.Decryption(E_bxy);
		BigInteger axy = p.Decryption(E_axy);
		
		
		System.out.println(bxy);
		System.out.println(axy);
		System.out.println(bxy.compareTo(axy));
		
		long endTime=System.currentTimeMillis(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");  
		
		return bxy.compareTo(axy);
		
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(compare(1,2));
	}
	
}
