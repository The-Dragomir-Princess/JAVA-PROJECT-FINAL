import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

class basic 
{	
	
		String age,date;
	 	String name;
	 	String a;
		int c=1000;
		int cust_bal,number,amt;
		
			
		
		public void Create_Account()	throws IOException
		{
		
		FileWriter f=new FileWriter("/home/twisha/Desktop/Project/Acount_details.txt",true);
		BufferedWriter f1 = new BufferedWriter(f);
		
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter your name:");
			name=sc.nextLine();
			System.out.println("Enter your age:");
			age=sc.nextLine();
			System.out.println("Enter your address:");
			a=sc.nextLine();
			c++;
			
			f1.write("Customer Details:");
			f1.write("  ");
			f1.write(" ");
			f1.newLine();
			f1.write("Account" + c);
			f1.newLine();
			f1.write(name);
			f1.newLine();
			f1.write(age);
			f1.newLine();
			f1.write(a);
			
			f1.newLine();
			f1.close();
			f.close();
		
		}
		
		public void deposit() throws IOException
       {
       Scanner sc= new Scanner(System.in);
       System.out.println("Enter the date:");
       date=sc.nextLine();
       System.out.println("Enter your account number:");
       number=sc.nextInt();
       System.out.println("Enter the amount to be deposited:");
       amt=sc.nextInt();
       System.out.println("Processing request");
       cust_bal= cust_bal+amt;
       System.out.println("Request processed"+"\n Remaining balance in account:"+cust_bal);
       FileWriter fn=new FileWriter("/home/twisha/Desktop/Project/deposit_log.txt",true);
		BufferedWriter bn = new BufferedWriter(fn);
		bn.write("Account " + number+ "	|");
		bn.write("|		" +date + "		");
		bn.write("|		" +amt + "		");
		bn.write("|		" +cust_bal + "		");
		bn.newLine();
		bn.close();
		fn.close();
       }
       
       public void withdraw() throws IOException
       {
		    Scanner sc= new Scanner(System.in);
		    System.out.println("Enter the date:");
		   date=sc.nextLine();
		   System.out.println("Enter your account number:");
		   number=sc.nextInt();
		   System.out.println("Enter the amount to be withdrawn:");
		   if(amt>cust_bal)
		   		System.out.println("Insufficient funds");
		   else
			   {
			   System.out.println("Processing request");
			   
			   		cust_bal=cust_bal-amt;
			   }
			 FileWriter f2=new FileWriter("/home/twisha/Desktop/Project/Withdraw_log.txt",true);
			BufferedWriter b2 = new BufferedWriter(f2);
			b2.write("Account " + number+ "	|");
			b2.write("|		" +date + "		");
			b2.write("|		" +amt + "		");
			b2.write("|		" +cust_bal + "		");
			b2.newLine();
			b2.close();
			f2.close();
			}
	public void deleteAccount()
		{
			String l;
			Scanner sc=new Scanner(System.in);
		   System.out.println("Enter your account number:");
		   l=sc.nextLine();
		   System.out.println("Account Deleted");

		}
}




class oopj_project
{
	public static void main(String args[]) throws IOException
	{
		int option;
		String line;
		Scanner sc= new Scanner(System.in);
		do
		{
		System.out.println("Which operation do you wish to execute: 1)Create new account  2)Withdraw  3)Deposit	 \n4)Display Withdraw logs  5)Display Deposit logs  6)Delete your Account  7)No further Transaction");
		System.out.println("Enter your option:");
		option=sc.nextInt();
		basic a=new basic();
		
		
			switch(option)
			{
				case 1:
						a.Create_Account();
						break;
				case 2:
						a.withdraw();
						break;
				case 3:
						a.deposit();
						break;
				case 4:
						System.out.println("Enter your account number:");
						String n= sc.nextLine();
						FileReader fr=new FileReader("/home/twisha/Desktop/Project/Withdraw_log.txt");    
          				BufferedReader br=new BufferedReader(fr); 
						while((line=br.readLine())!=null)
							System.out.println(line);
						break;
				case 5:
						System.out.println("Enter your account number:");
						String m= sc.nextLine();
						FileReader fn=new FileReader("/home/twisha/Desktop/Project/deposit_log.txt");    
          				BufferedReader bn=new BufferedReader(fn); 
						while((line=bn.readLine())!=null)
							System.out.println(line);
						break;
				case 6: 
						a.deleteAccount();
						break;
				case 7:
						System.out.println("\nTransaction complete\n");
						break;
				default:
						System.out.println("\nInvalid option\n");
						break;
				}
		}while(option!=7);
		
		System.out.println("\nTHANK YOU\n");
	}
}
