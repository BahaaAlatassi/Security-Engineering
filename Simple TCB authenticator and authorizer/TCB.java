import java.util.Scanner;

public class TCB 

{
	Scanner sc = new Scanner(System.in);
	String username, password;
	String[] users = {"user1", "user2"};
	String[] pwd = {"123", "555"};
	int securityLevel = 0;
	
	
	
	public TCB()
	{
		System.out.println("Please enter a user name then password.");
		if (accountCheck())
		{
			secLevel();
			System.out.println("The current security level is: " + securityLevel);
			System.out.println("Please enter the needed operation: C for create, O for open, A for append, Close to close, D to delete.");
			String operation = sc.next();
			if (accRight(operation)) {System.out.println("The " + operation + " permission is granted");}
			else {System.out.println("You dont have the permission to " + operation + " , sorry!" ); }
			
		}
	}
	
	public Boolean accountCheck()

	{
		System.out.println("Username: "); 
		username = sc.next();
		System.out.println("password: ");
		password = sc.next();
		for (int i=0; i<users.length; i++)
		{
			if (username.equals(users[i]) & password.equals(pwd[i])) 
			{
				System.out.println("Username and password are correct"); 
				
				return true;
			}

		}
		
		System.out.println("Username or/and password are incorrect");
		return false;
		
		
		}
	
	public void secLevel()
	{
		System.out.println("Please enter Security key:");
		String key = sc.next();
		if (key.equals("B001")) {securityLevel = 1;}
		else if (key.equals("200D")) {securityLevel = 2;}
		else if (key.equals("300C")) {securityLevel = 3;}
		else System.out.println("Error no such a key, Security level is 0"); 
		
	}
	
	public boolean accRight(String s1)
	{
		if ( (securityLevel == 0) & ( (s1.equals("O")) | (s1.equals("Close") ) )) {return true;}
		else if ( (securityLevel == 1) & ( (s1.equals("O")) | (s1.equals("Close")) | (s1.equals("C")) ) ) {return true;}
		else if ( (securityLevel == 2) & ( (s1.equals("O")) | (s1.equals("Close"))| (s1.equals("C")) | (s1.equals("A"))) ) { return true;}
		else if ( (securityLevel == 3) & ( (s1.equals("O")) | (s1.equals("Close")) | (s1.equals("C")) | (s1.equals("A")) | (s1.equals("D")) )) {return true;}
		else
			return false;
	}
 
	
	
}
