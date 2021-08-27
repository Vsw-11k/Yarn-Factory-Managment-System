
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;  
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
interface main{
	Scanner h=new Scanner(System.in);
	String m="manager",s="staff",lab="labour";
	int m1=1000,s1=750,lab1=500;
	ArrayList<String> list =new ArrayList<String>(100);
	ArrayList<String> emp=new ArrayList<String>(100);
	ArrayList<String> avail=new ArrayList<String>(1000);
	
}
class owner implements main {
	public void display() throws IOException {
	
	System.out.println("Welcome to owner portal");
	System.out.println("Select a number ");
	System.out.println("1.Create Sales");
	System.out.println("2.View of Stock ");
	System.out.println("3.list of Employee");
	System.out.println("4.Bill Generation");
	int select=h.nextInt();
	switch(select) {
	case 1:
		sales s=new sales();
		s.sale();
		break;
	case 2:
		stock l=new stock();
		l.list();
		break;
	case 3:
		manager m=new manager();
		m.manpart();
		break;
	case 4:
		bill b=new bill();
		b.billgene();
		break;
	}
	
}
}
class sales extends owner{
	public void sale() throws IOException {
		String path="E:\\java\\available.txt";
		 try {
		    	String  content1 = Files.readString(Paths.get(path));
		    	 String[] num6=content1.split(",");
		    	 List<String> list1 = new ArrayList<String>();
		    		list1 = Arrays.asList(num6);
		    		 emp.addAll(list1);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		System.out.println("1.Create New Sales");
		System.out.println("2.Sales which is done ");
		int po4=h.nextInt();
		if(po4==1) {
			System.out.println("WELCOME TO SALES");
			System.out.println("Enter the Company Name:");
			String name=h.next();
			int po1=name.length();
			if(po1!=0) {
				System.out.println("Enter the GST Number:");
				String gst=h.next();
				int po2=name.length();
				if(po2!=0) {
					System.out.println("Enter the count of Yarn:");
					int count=h.nextInt();
					if(count!=0&&(count>=0&&count<=100)) {
						System.out.println("Enter the Colour of Yarn");
						String color=h.next();
						int po3=color.length();
						if(po3!=0) {
							System.out.println("Enter the Quantity in terms of KG:");
							int quan=h.nextInt();
							if(quan>0) {
								System.out.println("Enter the price of yarn:");
								int price1=h.nextInt();
								if(price1>0) {
									String bill1="COMPANY NAME:"+name+" GST Number:"+gst+" Count of Yarn:"+count+" Colour of Yarn:"+color+" Quantity of "+color+" in terms of Kg "+quan+" Price of "+color+" Yarn per kg:"+price1*quan;
									avail.add(bill1);
									FileWriter f9=new FileWriter("E:\\java\\available.txt");  
				    				 f9.write(""+avail);
				    				 f9.close();
								     System.out.println("Bill details added");
								     
								}
								else {
									System.out.println("Enter the correct size");
								}
							}
							else {
								System.out.println("Enter the quantity properly ");
							}
						}
						else {
							System.out.println("Enter the correct quantity");
						}
						}
					else {
						System.out.println("Enter the correct count");
					}
					
				}
				else {
					System.out.println("Enter the correct gst number ");
				}
			}
			else {
				System.out.println("Enter the correct Company name");
			}		
		}
		else if(po4==2) {
			System.out.println(avail);
		}
		else {
			System.out.println("Enter the correct number");
		}	
	}
}
class manager extends owner{
	
	public void manpart() throws IOException {
		
		int ch7;
		String path="E:\\java\\employee.txt";
	    
	    try {
	    	String  content1 = Files.readString(Paths.get(path));
	    	 String[] num6=content1.split(",");
	    	 List<String> list1 = new ArrayList<String>();
	    		list1 = Arrays.asList(num6);
	    		 emp.addAll(list1);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		do {
			System.out.println("Enter the choice:");
			System.out.println("1.Display Employee details");
			System.out.println("2.generate Salary");
			int ch=h.nextInt();
			if(ch==1) {
				System.out.println("Select an option below:");
				System.out.println("1.Add new Employee");
				System.out.println("2.Remove an Employee");
				System.out.println("3.List Employees");
				System.out.println("4.Update Employee Details");
				System.out.println("5.To clear the Staff details");
				int c5=h.nextInt();
				if(c5==1) {
					System.out.println("Enter the name of staff:");
					String name=h.next();
					int n1=name.length();
				    if(n1!=0) {
				    	System.out.println("Enter the Address: ");
				    	String add=h.next();
				    	int a1=add.length();
				    	if(a1!=0) {
				    		System.out.println("Enter the type of work:");
				    		String twork=h.next();
				    		if(twork.equals(m)||twork.equals(s)||twork.equals(lab)) {
				    			System.out.println("Do you want change salary amount of person: 1.continue 2.exit");
				    			int k=h.nextInt();
				    			if(k==1) {
				    				System.out.println("Enter the salary for that person"+name+":");
				    				int sspl=h.nextInt();
				    				 String emp1="Name of Staff:"+name+" Address of employee:"+add+" Type of work to employee:"+twork+" Salary:"+sspl+"\n";
				    				 emp.add(emp1);
								     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
				    				 f5.write(""+emp);
				    				 f5.close();
								     System.out.println("Staff details added");
								     
				    			}
				    			else if(k==2){
				    				
				    				if(twork.equals(m)){
					    				 
					    				 String emp1="Name of Staff: "+name+" Address of employee: "+add+" Type of work to employee: "+twork+" Salary: "+m1+"\n";
					    				 emp.add(emp1);
									     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
					    				 f5.write(""+emp);
					    				 f5.close();
									     System.out.println("Staff details added");
									    
					    			}
				    				else if(twork.equals(s)){
					    				
					    				 String emp1="Name of Staff:"+name+" Address of employee:"+add+" Type of work to employee:"+twork+" Salary:"+s1+"\n";
					    				 emp.add(emp1);
									     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
					    				 f5.write(""+emp);
					    				 f5.close();
									     System.out.println("Staff details added");
									     
					    			}
				    				else if(twork.equals(lab)){
					    				
					    				 String emp1=" Name of Staff:"+name+" Address of employee:"+add+" Type of work to employee:"+twork+" Salary:"+lab1+"\n";
					    				 emp.add(emp1);
									     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
									     f5.write(""+emp);
					    				 f5.close();
									     System.out.println("Staff details added");
									    
					    			}
					    			else {
					    				System.out.println("Enter the correct amount of salary");
					    			}
				    			}
				    			else {
				    				System.out.println("Enter the correct amount");
				    			}
				    		}
				    		else {
				    			System.out.println("Please enter the type of work");
				    		}
				    		
				    	}
				    	else {
				    		System.out.println("Please enter the address properly");
				    	}
				    	}
				    
				    else {
				    	System.out.println("please Enter the name properly");
				    }
				}
				else if(c5==2) {
					System.out.println("Enter the stock to be removed starting from 0:");
					System.out.println(emp);
					int remove1=h.nextInt();
					
					Iterator<String> iter1 = emp.iterator();
					
					while(iter1.hasNext()) {
						//String str =iter1.next();
						if(remove1>=0&&remove1<=100) {
							iter1.remove();
							System.out.println("STOCK AFTER REMOVING:");
							FileWriter fwrite=new FileWriter("E:\\java\\employee.txt");  
							  fwrite.write("\n"+emp);
							  fwrite.close();
							  System.out.println("Stocks updated");
							  break;
		                    
						}
					}
					System.out.println(""+emp);
					
				}
				else if(c5==3) {
					System.out.println(""+avail);
					
				}
				else if(c5==4) {
					System.out.println("Enter the staff to be updated in terms of number starting from 0 :");
					System.out.println(emp);
					
					int r3=h.nextInt();
					System.out.println("Enter the name of staff:");
					String name=h.next();
					int n1=name.length();
				    if(n1!=0) {
				    	System.out.println("Enter the Address: ");
				    	String add=h.next();
				    	int a1=add.length();
				    	if(a1!=0) {
				    		System.out.println("Enter the type of work:");
				    		String twork=h.next();
				    		if(twork.equals(m)||twork.equals(s)||twork.equals(lab)) {
				    			System.out.println("Do you want change salary amount of person: 1.continue 2.exit");
				    			int k=h.nextInt();
				    			if(k==1) {
				    				System.out.println("Enter the salary for that person"+name+":");
				    				int sspl=h.nextInt();
				    				 String emp1="Name of Staff:"+name+" Address of employee:"+add+" Type of work to employee:"+twork+" Salary:"+sspl+"\n";
				    				 emp.set(r3,""+emp1);
				    				 
								     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
				    				 f5.write(""+emp);
				    				 f5.close();
								     System.out.println("Staff details added");
								     
				    			}
				    			else if(k==2){
				    				
				    				if(twork.equals(m)){
					    				 
					    				 String emp1="Name of Staff: "+name+" Address of employee: "+add+" Type of work to employee: "+twork+" Salary: "+m1+"\n";
					    				 emp.set(r3,""+emp1);
									     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
					    				 f5.write(""+emp);
					    				 f5.close();
									     System.out.println("Staff details added");
									    
					    			}
				    				else if(twork.equals(s)){
					    				
					    				 String emp1="Name of Staff:"+name+" Address of employee:"+add+" Type of work to employee:"+twork+" Salary:"+s1+"\n";
					    				 emp.set(r3,""+emp1);
									     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
					    				 f5.write(""+emp);
					    				 f5.close();
									     System.out.println("Staff details added");
									     
					    			}
				    				else if(twork.equals(lab)){
					    				
					    				 String emp1=" Name of Staff:"+name+" Address of employee:"+add+" Type of work to employee:"+twork+" Salary:"+lab1+"\n";
					    				 emp.set(r3,""+emp1);
									     FileWriter f5=new FileWriter("E:\\java\\employee.txt");  
									     f5.write(""+emp);
					    				 f5.close();
									     System.out.println("Staff details added");
									    
					    			}
					    			else {
					    				System.out.println("Enter the correct amount of salary");
					    			}
				    			}
				    			else {
				    				System.out.println("Enter the correct amount");
				    			}
				    		}
				    		else {
				    			System.out.println("Please enter the correct type of work");
				    		}
				    		
				    	}
				    	else {
				    		System.out.println("Please enter the address properly");
				    	}
				    	}
				    
				    else {
				    	System.out.println("please Enter the name properly");
				    }
					
				}
				
				else if(c5==5) {
					emp.clear();
					System.out.println("Staff list cleared");
				}
				else {
					System.out.println("Enter the valid choice");
				}
				}
			else if(ch==2) {
				
				System.out.println("SALARY GENERATION");
				System.out.println("Enter the Name of Employee:");
				String name=h.next();
				System.out.println("Enter the Mode of work:");
				String mode=h.next();
				System.out.println("Enter the number of working days:");
				int days=h.nextInt();
				if(mode.equals(m)) {
					System.out.println("Your Name:"+name);
					System.out.println("Your Mode of Work:"+mode);
					System.out.println("Number of days you worked:"+days);
					System.out.println("Your Salary is:"+(days*m1));
				}
				else if(mode.equals(s)) {
					System.out.println("Your Name:"+name);
					System.out.println("Your Mode of Work:"+mode);
					System.out.println("Number of days you worked:"+days);
					System.out.println("Your Salary is:"+(days*s1));
				}
				else if(mode.equals(lab)) {
					System.out.println("Your Name:"+name);
					System.out.println("Your Mode of Work:"+mode);
					System.out.println("Number of days you worked:"+days);
					System.out.println("Your Salary is:"+(days*lab1));
				}
				else {
					System.out.println("Please Enter the valid choice");
				}
			}
			else {
				System.out.println();
			}
			System.out.println("Enter your choice 1.Continue 2.Exit");
			ch7=h.nextInt();
		}
		while(ch7==1);
		
	}
}
class stock extends owner{
	
	
    int count,total;
	String colour;
	int quantity,c1,c3;
	
    	public void list() throws IOException {
    		String path="E:\\java\\stocks.txt";
    	    
    	    try {
    	    	String  content = Files.readString(Paths.get(path));
    	    	 String[] num=content.split(",");
    	    	 List<String> list1 = new ArrayList<String>();
    	    		list1 = Arrays.asList(num);
    	    		
                    list.addAll(list1);
                    
                  System.out.println(emp);
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }    		
		do {
	    	System.out.println("Stocks Available:");
	    	int index=0;
	    	System.out.println("Enter the choice");
			System.out.println("1.Add stocks");
			System.out.println("2.Remove Stocks");
			System.out.println("3.Update the stocks");
			System.out.println("4.View Stocks");
			System.out.println("5.Clear all Stocks");
			int c=h.nextInt();
			if(c==1) {

					System.out.println("Enter the count of yarn ");
					int count=h.nextInt();
					if(count>=0&&count<=100) {
						System.out.println("Please Start writing colour with capital letter!");
						System.out.println("Enter the colour of yarn(Colours Availabe :Red,Yellow,Green,Black,Blue,White,Rose,Dark Blue,Melanche):");
						String color=h.next();
						if(color.equals("Red")||color.equals("Yellow")||color.equals("Green")||color.equals("Black")||color.equals("Blue")||color.equals("White")||color.equals("Rose")||color.equals("Dark Blue")||color.equals("Melanche")) {
							System.out.println("Enter the Price of the yarn:");
							double price=h.nextDouble();
							if(price>=0) {
								System.out.println("Enter the quantity of "+color+" In KG:");
								int quantity=h.nextInt();
								String l1="Count of yarn:"+count+" Colour of yarn:"+color+" Price of Yarn:"+price+" Quantity of Yarn:"+quantity+"\n";
								 list.add(l1);
								 FileWriter fwrite=new FileWriter("E:\\java\\stocks.txt");  
								 fwrite.write(""+list);
							     fwrite.close();
							  System.out.println("Stocks Added");
							}
							else {
								System.out.println("Please enter the correct quantity");
							}
							
						}
						else {
							System.out.println("Please enter the correct colour");
						}
					}
					else {
						System.out.println("Please enter the count colour ");
					}
					
					
		}	
	    else if(c==2) {
			System.out.println("Enter the stock to be removed starting from 0:");
			
    		for(String s : list)
    		    System.out.println((index++)+": "+s);
			
			int remove=h.nextInt();
			
			Iterator<String> iter = list.iterator();
			
			while(iter.hasNext()) {
				//String str =iter.next();
				if(remove>=0&&remove<=100) {
					iter.remove();
					System.out.println("STOCK AFTER REMOVING:");
					FileWriter fwrite=new FileWriter("E:\\java\\stocks.txt");  
					  fwrite.write("\n"+list);
					  fwrite.close();
					  System.out.println("Stocks updated");
					  break;
                   
                    
				}
			}
			System.out.println(""+list);
		}
		else if(c==3) {
			System.out.println("Enter the stock to be updated starting from 0:");
    		for(String s : list)
    		    System.out.println((index++)+": "+s);
			
			int r2=h.nextInt();
			int h5=list.size();
			if(h5>=0&&h5<=h5) {
				for(String f1:list) {
					
					System.out.println("Enter the count of yarn ");
					int count=h.nextInt();
					if(count>=0&&count<=100) {
						System.out.println("Enter the colour of yarn:");
						String color=h.next();
						if(color.equals("Red")||color.equals("Yellow")||color.equals("Green")||color.equals("Black")||color.equals("Blue")||color.equals("White")||color.equals("Rose")||color.equals("Dark Blue")||color.equals("Melanche")) {
							System.out.println("Enter the Price of the yarn:");
							double price=h.nextDouble();
							if(price>=0) {
								System.out.println("Enter the quantity of "+color+" In KG:");
								int quantity=h.nextInt();
								String l1="Count of yarn:"+count+" Colour of yarn:"+color+" Price of Yarn:"+price+" Quantity of Yarn:"+quantity+"\n";
								
									
								list.set(r2,""+l1);
								index=0;
								for(String s : list)
					    		    System.out.println((index++)+": "+s);
							  FileWriter fwrite=new FileWriter("E:\\java\\stocks.txt");  
							  fwrite.write("\n"+list);
							  fwrite.close();
							  System.out.println("Stocks updated");
							  break;
							}
							else {
								System.out.println("Please enter the correct quantity");
							}
							
						}
						else {
							System.out.println("Please enter the correct colour");
						}
					}
					else {
						System.out.println("Please enter the count colour ");
					}

					System.out.println(list);
					
				  break;
				}
			}
			else {
				System.out.println("Enter the correct choice");
			}
		
			
		}
		
		else if(c==4) {
			
			int go=list.size();
			if(go<0) {
				System.out.println("No stocks Available Add Stocks");
			}
			else if(go>=0&&go<100) {
				System.out.println(list);
			}
			else {
				System.out.println("Enter the correct size");
			}
		
			
		}
		else if(c==5) {
			int go1=list.size();
			if(go1<0) {
				System.out.println("Enter the correct value");
			}
			else if(go1>=0&&go1<=100) {
				list.clear();
				System.out.println("Stocks Cleared");
			}
			else {
				System.out.println("Enter the correct value");
			}
	        
		}
		else {
			System.out.println("Please enter the correct choice");
		}
	    	System.out.println("Do you wish to continue Enter 1.continue 2.exit");
	    	 c3=h.nextInt();
	    }while(c3==1);	    	
}	
}

class bill extends owner{	
	public void billgene(){
		
		System.out.println("Welcome to bill portal");
		System.out.println("Enter the count of yarn:");
		int count=h.nextInt();
		if(count>=0&&count<=100) {
			System.out.println("Enter the colour of Yarn:");
			String color =h.next();
			int bh1=color.length();
			if(bh1>0) {

				System.out.println("Enter the Weight in terms of KG :");
				int kg=h.nextInt();
				if(kg>=0) {
					System.out.println("Enter the Company name:");
					String comp=h.next();
					int bh2 =comp.length();
					if(bh2>0){
						System.out.println("Enter the GST Number:");
						String gst=h.next();
						int bh3=gst.length();
						if(bh3>0) {
							System.out.println("Enter th price of yarn per kg:");
							double price=h.nextInt();
							if(price>0) {
								System.out.println("Enter the Datein(DD/MM/YYYY):");
								String date=h.next();
								double total= kg*price;
								try {  
									FileWriter fwrite = new FileWriter("E:\\java\\bill.txt");
							        fwrite.write("Company Name :"+comp) ;
							        fwrite.write("\nBill dated on:"+date);   
							        fwrite.write("\nGst Number:"+gst);
							        fwrite.write("\nCount of Yarn Purchased:"+count);
							        fwrite.write("\nColour of Yarn Purchased:"+color);
							        fwrite.write("\nQuantity of Yarn Purchased:"+kg);
							        fwrite.write("\ntotal :"+total);
							        fwrite.close();   
							        System.out.println("Content is successfully wrote to the file.");  
							    } catch (IOException e) {  
							        System.out.println("Unexpected error occurred");  
							        e.printStackTrace();  
							        }  		
							}
							else {
								System.out.println("Enter the correct price");
							}
						}
						else {
							System.out.println("Enter the correct gst number ");
						}
					}
					else {
						System.out.println("Enter the correct company name");
					}
				}
				else {
					System.out.println("Enter the correct weight");
				}
			}
			else {
				System.out.println("Enter the correct colour");
			}
			
		}
		else {
			System.out.println("Enter the correct count");
		}
}
} 
class Mainclass
{
	
public static void main(String args[]) throws IOException
      { 
	  int c4;
	  owner l=new owner();
	  manager h1=new manager();
      Scanner h=new Scanner(System.in);
	do {
		
    	System.out.println("Welcome");
	  	System.out.println("1.Admin");
	  	System.out.println("2.Manager");
	  	System.out.println("Enter the choice:");
	  	int choice=h.nextInt();
	    if(choice ==1) {
	    	System.out.println("enter  your pin");
	    	int pin=h.nextInt();
	    	if(pin ==1) {
		  		l.display();	
		  	}
	    	else {
	    		System.out.println("Please Enter the Valid pin");
	    	}
	    	
	    }
	    else if(choice ==2) {
	    	System.out.println("enter  your pin");
	    	int pin=h.nextInt();
				if( pin==4) {
	    		System.out.println("welcome to manager portal");
	    	    h1.manpart();
		  		}
				else {
		    		System.out.println("Please Enter the Valid pin");
		    	}
	    }
	    else {
	    	System.out.println("Reenter the valid Choice");
	    }
		
	    System.out.println("Do you wish to continue to main portal Enter choice 1.Continue 2.Exit");
		c4=h.nextInt(); 
		
	}while(c4==1);
	    	h.close();
	    	System.out.println("thank you visit again");
      }
}
 

