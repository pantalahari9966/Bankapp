import java.util.*;
import java.sql.*;
public class Customer {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    System.out.println("Enter Customer Details");
    Bank bc=new Bank();
    while(true)
    {
    	System.out.println("Enter your Choice: \n1.Create Account \n2.Login Account \n3.Transfer Money \n4.View Balance \n5.LogOut");
        System.out.println("Enter your Choice");
    	int ch=sc.nextInt();
    	if(ch==1)
    	{
    		System.out.println("Enter AccountNumber");
    		long accno=sc.nextLong();
    		System.out.println("Enter CustomerName");
    		String cname=sc.next();
    		System.out.println("Enter Balance");
    		double balance=sc.nextDouble();
    		System.out.println("Enter Username");
    		String uname=sc.next();
    		System.out.println("Enter password");
    		String password=sc.next();
    		bc.setAccno(accno);
    		bc.setCname(cname);
    		bc.setBalance(balance);
    		bc.setUsername(uname);
    		bc.setPassword(password);
    		try
    		{
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hari","welcome");
    			PreparedStatement ps=con.prepareStatement("Insert into customer values(?,?,?,?,?)");
    			ps.setLong(1,accno);
    			ps.setString(2, cname);
    			ps.setDouble(3, balance);
    			ps.setString(4, uname);
                ps.setString(5, password);
                int i=ps.executeUpdate();
                System.out.println(i+"one record inserted successfully....!");
                con.close();
    		}
    	  catch(Exception ex)
        	{
    	     System.out.println(ex);	
    	    }
    	}
    
    }
	}
}
