import java.io.*;
class input1
{
	char getcontent(int y)
	//public static void main(String args[])
 	{
    		File file = new File("file.txt");
    		int ch,i=0,j=0;
    		char c='0';
    		StringBuffer strContent = new StringBuffer("");
    		FileInputStream fin = null;
    		try 
			{
      			fin = new FileInputStream(file);
      			while ((ch = fin.read()) != -1)
        		{
					if(i>=y)
					{
						c=(char)ch;
						System.out.println("::::::"+c+"::::::");
						return(c);
					}
					i++;
             	}
				c='\0';	
      			fin.close();
		}
  		catch (Exception e) 
		{
      			System.out.println(e);
    	}
		System.out.println(strContent.toString());
		return(c);
  	}

}


