import java.sql.*;
import java.util.*;
public class database
{	
	List<viruscop> viruses=new ArrayList<viruscop>();
	void connect()
	{
  		//System.out.println("MySQL Connect Example.");
  		Connection conn = null;
  		String url = "jdbc:mysql://localhost:3306/";
  		String dbName = "cop2";
  		String driver = "com.mysql.jdbc.Driver";
  		String userName = "root"; 
  		String password = "";
  		try 
		{
  			Class.forName(driver).newInstance();
  			conn = DriverManager.getConnection(url+dbName,userName,password);
  			//System.out.println("Connected to the database");
			//List<viruscop> viruses=new ArrayList<viruscop>();
			ResultSet rst1=null;
			Statement stmt1=null;
			stmt1=conn.createStatement();
			String check="select * from virus";
			rst1=stmt1.executeQuery(check);
			while(rst1.next())
			{
				viruscop v1=new viruscop();
				v1.serialnumber=rst1.getString("slno");
				v1.virusname=rst1.getString("name");
				v1.virussignature=rst1.getString("signature");
				viruses.add(v1);
			}
			for(int i=0;i<2;i++)
			{
				viruscop v2; 
				v2=viruses.get(i);
				//System.out.println(v2.virussignature);
			}
			//System.out.println(viruses.size());
			rst1.close();
			stmt1.close();
  			conn.close();
  			//System.out.println("Disconnected from database");
  		} catch (Exception e) 
		{
  			e.printStackTrace();
  		}
  	}
}