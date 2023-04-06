import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMenu {
	private ArrayList<Customer> customers;
	private Scanner scanner;
	/**
	 * @param customers
	 * @param scanner
	 */
	public CustomerMenu() {
		
		customers=new ArrayList<>();
		scanner=new Scanner(System.in);
	}
	
	public void displayCustomerMenu(){
		System.out.println("\n*************Welcome to The Antique Furniture Company**************\n");
		int choice;
		do {
			System.out.println("\n********Your Available Options ***********");
			System.out.println();
            System.out.println("1. Create a new profile");
            System.out.println("2. View existing profile");
            System.out.println("3. Update existing profile");
            System.out.println("4. Delete existing profile");
            System.out.println("5. Logout");
            
            System.out.print("\nSelect an option : ");
            choice =scanner.nextInt();
            scanner.nextLine();//consume the newline character left by nextInt()
            System.out.println();
            switch(choice) {
            
            case 1:
            	System.out.println("You selected choice 1");
            	//call create new customer
            	createCustomer();
            	break;
            case 2:
            	System.out.println("You selected choice 2");
            	//call view existing customer
            	viewCustomer();
            	break;
            case 3:
            	System.out.println("You selected choice 3");
            	//call update existing customer
            	updateCustomer();
            	break;
            case 4:
            	System.out.println("You selected choice 4");
            	//call delete existing customer
            	deleteCustomer();
            	break;
            case 5:
            	System.out.println("You selected choice 5");
            	//Call exit program
            	System.exit(0);
            	break;
            	default:
            		System.out.println("Invalid Choice!!! Try again");
            		return;
            }
            
		}while(choice !=5);
		scanner.close();
		
	}
	private void createCustomer() {
		System.out.println("\n*********Customer Details*************\n");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter customer name: ");
            name = scanner.nextLine();
        }
        System.out.print("Enter customer contact: ");
        String contact = scanner.nextLine();
        while (contact.isEmpty()) {
            System.out.print("Contact cannot be empty. Enter customer contact: ");
            contact = scanner.nextLine();
        }
        System.out.print("Enter customer email address: ");
        String email = scanner.nextLine();
        while (email.isEmpty()) {
            System.out.print("Email cannot be empty. Enter customer email address: ");
            email = scanner.nextLine();
        }
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        while (address.isEmpty()) {
            System.out.print("Address cannot be empty. Enter customer address: ");
            address = scanner.nextLine();
        }
        customers.add(new Customer(name, contact, email, address));
        System.out.println("Customer added successfully.");
        
        //Going to TableMenu Class
        Login login =new Login();
	    TableMenu tableMenu=new TableMenu(scanner,login);
	    tableMenu.displayTableMenu();
    }
	public void viewCustomer() {
		if(customers.size()==0) {
			System.out.println("\nNo customers added yet!!!\n");
			return;
		}
		System.out.println("\n*********List of Customers********\n");
		System.out.println();
		for(int i=0;i<customers.size();++i) {
			Customer customer =customers.get(i);
			System.out.println("Customer #"+(i+1));
			System.out.println("Name : "+customers.get(i).getName());
			System.out.println("Contact : "+customers.get(i).getPhoneNumber());
			System.out.println("Email : "+customers.get(i).getEmailAddress());
			System.out.println("Address : "+customers.get(i).getAddress());
			System.out.println();
		}
	}
	public void updateCustomer() {
		System.out.println("\n==========Update Customers============\n");
		if(customers.size()==0) {
			System.out.println("\nNo customers added yet!!!\n");
			return;
		}
		
		for(int i=0;i<customers.size();++i) {
			System.out.println("Customer #"+(i+1));
		}
		 //get the customer to update
		System.out.print("\nEnter the number of Customer to update : ");
		int customerNumber=scanner.nextInt()-1;
		if(customerNumber<0|| customerNumber>=customers.size()) {
			System.out.println("Invalid Customer number. Please try Again");
			return;
		}
		Customer customer=customers.get(customerNumber);
		
		//get the section for update
		System.out.println("Select Section to update :");
		System.out.println("1. Customer Name : ");
		System.out.println("2. Contact Information : ");
		System.out.println("3. Email Address : ");
		System.out.println("4. Home Address : ");
		System.out.println();
		System.out.print("Enter your option : ");
		int choice=scanner.nextInt();
		scanner.nextLine();//consume the new line character
		//update the customer
		
		switch(choice) {
		case 1:
		System.out.print("Update Customer Name : ");
		String name=scanner.next();
		customer.setName(name);
		System.out.println("Customer name updated Succesfully!!!");
		break;
		case 2:
			System.out.print("Update phone number : ");
			String phoneNumber=scanner.next();
			
			customer.setPhoneNumber(phoneNumber);
			System.out.println("Customer contacts updated Succesfully!!!");
			break;
		case 3:
			System.out.print("Update email address : ");
			String emailAddress=scanner.next();
			customer.setEmailAddress(emailAddress);

			System.out.println("Customer Email updated Succesfully!!!");
			break;
		case 4:
			System.out.print("Update Home Address : ");
			String address=scanner.next();
			
			customer.setAddress(address);
			System.out.println("Customer Address updated Succesfully!!!");
			break;
			default:
				System.out.println("\nInvalid Option. Try Again");
				break;
		}
		 
		
		System.out.println("Customer Updated Succesfully!!!");
		
	}
	public void deleteCustomer() {
		if(customers.size()==0) {
			System.out.println("No Customers available to Delete!!!");
			return;
		}
		System.out.println("\n===========Delete Existing Customers================\n");
		System.out.println("Select customer to delete : ");
		for(int i=0;i<customers.size();++i) {
			System.out.println("Table #"+(i+1));
		}
		System.out.print("Enter Customer number to delete : ");
		int customerNumber=scanner.nextInt();
		if(customerNumber<=0||customerNumber>customers.size()) {
			System.out.println("Invalid customer number. Try Again!!!");
			return;
			
		}
		customers.remove(customerNumber-1);
		System.out.println("Customer deleted Succesfully!!!");
		}
	
}
