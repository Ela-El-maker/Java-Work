import java.util.ArrayList;
import java.util.Scanner;

public class TableMenu {
	private Scanner scanner;
	private Login login;
	private ArrayList<Table> tables;
	private Customer customer;
	/**
	 * @param scanner
	 * @param login
	 */
	public TableMenu(Scanner scanner, Login login) {
		this.scanner = scanner;
		this.login = login;
		this.tables=new ArrayList<Table>();
		
	}
	/**
	 * @param scanner
	 * @param login
	 * @param tables
	 * @param customer
	 * @param customers
	 */
	
	/**
	 * @param scanner
	 * @param login
	 * @param tables
	 * @param customer
	 * @param customers
	 */
	Table table;
	public void createTable() {
		int numOfTables;
		System.out.println("\n*************Create New Table****************\n");
		
		System.out.println("***********Select Table Type *********** ");
		System.out.println();
		System.out.println("1. Standard Table.");
		System.out.println("2. Custom Table.");
		
		System.out.print("\nEnter your choice : ");
		int tableType=scanner.nextInt();
		
		Table table;
		if(tableType==1) {
			
			System.out.print("\nEnter number of Tables : ");
			numOfTables=scanner.nextInt();
			table=new StandardTable("Pine",0,numOfTables,120,80,0);
		}else if(tableType==2) {
			System.out.println("\n*****************Customize your Table******************\n");
			System.out.print("\nEnter wood type (Mahogany,Oak,Pine) : ");
			String woodType=scanner.next();
			System.out.print("\nEnter number of Drawers : ");
			int numOfDrawers=scanner.nextInt();
			System.out.print("\nEnter Length : ");
			int length=scanner.nextInt();
			System.out.print("\nEnter Width : ");
			int width=scanner.nextInt();
			System.out.print("\nEnter number of Tables : ");
			numOfTables=scanner.nextInt();
			scanner.nextLine();
			
			 if (numOfDrawers < 0 || length < 0 || width < 0) {
			        System.out.println("\nInvalid Choice!!! Try again later");
			        return;
			    }
			 
			table=new CustomTable(woodType,numOfDrawers,numOfTables,length,width,0);
			
		}else {
			System.out.println("\nInvalid Choice!!! Try again later");
			return;
		}
		
		double price=table.calculatePrice();
		
		table.setPrice(price);
		tables.add(table);
		System.out.println("Table Created Successfully!!!");
	}
	public void viewTable() {
		if(tables.size()==0) {
			System.out.println("No tables Available!!!");
			return;
		}
		System.out.println("\n****************View Existing Tables*****************\n");
		for(int i=0;i<tables.size();++i) {
			Table table=tables.get(i);
			System.out.println("Table #"+(i+1)+" : ");
			System.out.println("Type : "+table.getClass().getSimpleName());
			System.out.println("Wood Type : "+table.getWoodType());
			System.out.println("Number of Drawers : "+table.getNumOfDrawers());
			System.out.println("Number of Tables : "+table.getNumOfTables());
			System.out.println("Length : "+table.getLength()+" cm");
			System.out.println("Width : "+table.getWidth()+" cm");
			System.out.println("Area : "+table.getWidth()*table.getLength()+" cm2");
			//System.out.println("Price : "+table.calculatePrice());
		}
	}
	public void updateTable() {
		System.out.println("\n**************Update Tables*******************\n");
		
		if(tables.size()==0) {
			System.out.println("No tables Available to update!!!");
		return;
		}
		for(int i=0;i<tables.size();++i) {
			System.out.println("Table #"+(i+1));
		}
		 //get the table to update
		System.out.print("\nEnter the number of table to update : ");
		int tableNumber=scanner.nextInt()-1;
		if(tableNumber<0|| tableNumber>=tables.size()) {
			System.out.println("Invalid Table number. Please try Again");
			return;
		}
		Table table=tables.get(tableNumber);
		
		//get the section for update
		System.out.println("Select Section to update :");
		System.out.println("1. Wood Type : ");
		System.out.println("2. Number of Drawers : ");
		System.out.println("3. Length of Table : ");
		System.out.println("4. Width of Table : ");
		System.out.println();
		System.out.print("Enter your option : ");
		int choice=scanner.nextInt();
		scanner.nextLine();//consume the new line character
		//update the table
		
		switch(choice) {
		case 1:
		System.out.print("Enter new Wood Type : ");
		String woodType=scanner.next();
		table.setWoodType(woodType);
		System.out.println("Table wood type updated Succesfully!!!");
		break;
		case 2:
			System.out.print("Enter new Number of Drawers : ");
			int numOfDrawers=scanner.nextInt();
			if (numOfDrawers < 0 || numOfDrawers > 6) {
		        System.out.println("Invalid number of drawers.");
		        return;
		    }
			table.setNumOfDrawers(numOfDrawers);
			System.out.println("Table Drawers updated Succesfully!!!");
			break;
		case 3:
			System.out.print("Enter new Length : ");
			int length=scanner.nextInt();
			if (length < 0) {
		        System.out.println("Invalid Length of Table.");
		        return;
		    }
			table.setLength(length);
			System.out.println("Table Length updated Succesfully!!!");
			break;
		case 4:
			System.out.print("Enter new Width : ");
			int width=scanner.nextInt();
			if (width < 0) {
		        System.out.println("Invalid width of Table.");
		        return;
		    }
			table.setWidth(width);
			System.out.println("Table Width updated Succesfully!!!");
			break;
			default:
				System.out.println("\nInvalid Option. Try Again");
				break;
		}
		 
		double price=table.calculatePrice();
		int numOfTables;
		System.out.println("\nEnter number of Tables : ");
		numOfTables=scanner.nextInt();
		
		if (numOfTables > 1) {
	        double totalPrice = price * numOfTables;
	        double discount = totalPrice * 0.05;
	        price = totalPrice - discount;
	    }
		
		table.setPrice(price);
		System.out.println("Table Updated Succesfully!!!");
		
	}
	public void deleteTable() {
		if(tables.size()==0) {
			System.out.println("No tables available to Delete!!!");
			return;
		}
		System.out.println("\n***************Delete Existing Tables*****************\n");
		System.out.println("Select table to delete : ");
		for(int i=0;i<tables.size();++i) {
			System.out.println("Table #"+(i+1));
		}
		System.out.print("Enter table number to delete : ");
		int tableNumber=scanner.nextInt();
		if(tableNumber<=0||tableNumber>tables.size()) {
			System.out.println("Invalid table number!!!");
			return;
			
		}
		tables.remove(tableNumber-1);
		System.out.println("Table deleted Succesfully!!!");
		}
	ArrayList<Customer> customers= new ArrayList<>();
	
	
	public void generateInvoice() {
		if (tables.size() == 0) {
	        System.out.println("No Tables or Customers available to generate invoice for.");
	        return;
	    }
		System.out.println("\n~~~~~~~~~~~~~~~~Generating Invoice Tables~~~~~~~~~~~~~~~~~~~~~\n");
		 // print customer details
	    
		double totalPrice=0;
		//double totalTablesPrice=table.calculatePrice();
		for(int i=0;i<tables.size();++i) {
			Table table=tables.get(i);
			totalPrice+=table.calculatePrice();
			System.out.println();
			System.out.println("Table #"+(i+1)+" : ");
			System.out.println("Type : "+table.getClass().getSimpleName());
			System.out.println("Wood Type : "+table.getWoodType());
			System.out.println("Number of Drawers : "+table.getNumOfDrawers());
			System.out.println("Number of Tables : "+table.getNumOfTables());
			System.out.println("Length : "+table.getLength()+"cm");
			System.out.println("Width : "+table.getWidth()+"cm");
			System.out.println("Area : "+table.getLength()*table.getWidth()+"cm2");
			System.out.println("Discount : 5 %");
			System.out.println("Price : "+table.calculatePrice());
			
			
		}
		
		double discountPrice = totalPrice * 0.05;
        double totalAmount = totalPrice - discountPrice;
        
        System.out.println("Discounted Amount: " + discountPrice);
        System.out.println("Total Amount: " + totalAmount);
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~Invoice Tables~~~~~~~~~~~~~~~~~~~~~\n");
	}
	public void displayTableMenu() {
		System.out.println("\n^^^^^^^^^^^^^^^^^^Welcome to The Antique Furniture Kenya Limited^^^^^^^^^^^^^^^\n");
		
		int choice;
		do {
			System.out.println("\n********Tables Available Options ***********");
			System.out.println();
            System.out.println("1. Create a new table");
            System.out.println("2. View existing tables");
            System.out.println("3. Update existing tables");
            System.out.println("4. Delete existing tables");
            System.out.println("5. Generate Invoice");
            System.out.println("6. Logout");
            System.out.print("\nSelect an option : ");
            choice =scanner.nextInt();
            scanner.nextLine();//consume the newline character left by nextInt()
            System.out.println();
            switch(choice) {
            
            case 1:
            	System.out.println("You selected choice 1");
            	//call create new table
            	createTable();
            	break;
            case 2:
            	System.out.println("You selected choice 2");
            	//call view existing tables
            	viewTable();
            	break;
            case 3:
            	System.out.println("You selected choice 3");
            	//call update existing table
            	updateTable();
            	break;
            case 4:
            	System.out.println("You selected choice 4");
            	//call delete existing table
            	deleteTable();
            	
            	break;
            case 5:
            	System.out.println("You selected choice 5");
				generateInvoice();
            	break;
            case 6:
            	System.out.println("You selected choice 5");
            	System.out.println("You are Logged Out");
            	//Call exit program
            	//proceed to next function
                //Going to the CustomerMenu class
                System.exit(0);
            	break;

            	default:
            		System.out.println("Invalid Choice!!! Try again");
            		return;
            }
            
		}while(choice !=6);
		scanner.close();
	}
	
}
