package shared_parking;



public class Test
{
	public static void main(String[] args) throws Exception
	{
		long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��  
		Platform.get_result();
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��  
		System.out.println("��������ʱ�䣺 "+(endTime-startTime)+"ms");  
		
		
		
	}
	
	
}
