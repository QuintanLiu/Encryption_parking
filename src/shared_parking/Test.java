package shared_parking;



public class Test
{
	public static void main(String[] args) throws Exception
	{
		long startTime=System.currentTimeMillis();   //获取开始时间  
		Platform.get_result();
		long endTime=System.currentTimeMillis(); //获取结束时间  
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");  
		
		
		
	}
	
	
}
