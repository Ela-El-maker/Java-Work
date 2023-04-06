import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private ArrayList<Users> usersList;

    public Login() {
        this.usersList = new ArrayList<>();
        this.usersList.add(new Users("user1", "password1"));
        this.usersList.add(new Users("user2", "password2"));
        this.usersList.add(new Users("user3", "password3"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===============Antique Company=============\n");
        System.out.println("Please enter Username and Password ");
        System.out.println();
        int attempts = 3;
        Login login = new Login();
        boolean isLoggedIn = false;
        while (attempts > 0 && !isLoggedIn) {
            System.out.print("Username : ");
            String username = scanner.nextLine();

            System.out.print("Password : ");
            String password = scanner.nextLine();
            System.out.println();
            for (Users user : login.usersList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    System.out.println("Login Successful!!!");
                    isLoggedIn = true;
                    //proceed to next function
                    //Going to the CustomerMenu class
                    CustomerMenu customerMenu=new CustomerMenu();
                    customerMenu.displayCustomerMenu();
                    //Going to the TableMenu class
                    TableMenu tableMenu=new TableMenu(scanner,login);
                    tableMenu.displayTableMenu();
                    break;
                } 
            }
            if(!isLoggedIn){
                    attempts--;
                    System.out.println("Incorrect username or password");
                    System.out.println("\n");
                    if(attempts>0) {
                    	System.out.println("You have "+attempts+" left!!!");
                }
            }
        }
        System.out.println();
        if (attempts == 0) {
            System.out.println("Trials Over. Please try again later.");
            //Function to exit program
            System.exit(0);
        }

    }
}
