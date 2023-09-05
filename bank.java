import java.util.Scanner;
import static java.lang.System.out;

public class bank {
    public static String fullname = "NULL";
    public static String password;
    public static Double balance = 0.0;

    
    
    public static boolean logStatus;
    public static boolean exit = false;
    public static Scanner input = new Scanner(System.in);
    

    
    
    public static void main(String[] args) {
        while (exit == false){
            startMsg();
            switcher((input.next().charAt(0)));
        }
    }

    public static void switcher(char choice){
        
        switch (choice){
            case 'a':
                createAcc();
                break;
            case 'b':
                while (logStatus == false){
                    accLogin();
                }
                deposit();
                break;   
            case 'c':
                while (logStatus == false){
                    accLogin();
                }
                withdraw();
                break;
            case 'd':
                while (logStatus == false){
                    accLogin();
                }
                balCheck();
                break;    
            case 'e':
                exit = true;
                break;  
            default:
                out.println("Please select a, b, c or d");
        }
    }

    public static void startMsg(){
    out.println("Welcome to _____ banking.");
    out.println("What would you like to do today?");
    out.println("________________________________");
    out.println("a. Create Account");
    out.println("b. Deposit");
    out.println("c. Withdraw");
    out.println("d. Check Balance");
    out.println("e. Exit");
    out.println("________________________________");
    }

    public static void accLogin(){
    String accName; 
    String pass;
    
    if (fullname == "NULL"){
        out.println("Please make a new account first!");
        createAcc();
    }
    else{
        out.println("Please enter your account name and password.");
        out.print("Account name: ");
        accName = input.next();
        out.print("Password: ");
        pass = input.next();

        if (accName.equals(fullname) && pass.equals(password)){
            logStatus = true;
            out.println("logged in");
        }
        else{
            out.println("Account name or password is incorrect.");
        }
    }
    }
    
    public static void createAcc(){
    double initBalance = 200;
    
        out.println("Create Account");
        out.println("To create an account, please provide an account name and Password.");
        
        while(fullname == "NULL"){
            out.print("Account Name: ");
            fullname = input.next();
            if (fullname == "NULL"){
                out.println("Account name cannot be \"NULL\"");
            }
        }

        out.print("Password: ");   
        password = input.next();

    if (balance == 0)
        balance = initBalance;
        out.println("Account successfully created.");
    }

    public static void deposit(){
        double depositAmount = 0;
        boolean depAgain = true;
        while (depAgain == true){
            out.println("Deposit");
            out.println("How much would you like to deposit?");

            depositAmount = input.nextDouble();
            balance += depositAmount;

            out.println("Deposit of " + depositAmount + " was successful.");
            out.println("Would you like to do another transaction?");
            out.println("y/n");

            String YN = " ";

            while ((!YN.equalsIgnoreCase("y")) && (!YN.equalsIgnoreCase("n"))){
                out.println("Please enter y or n.");
                YN = input.next();
                
            }
            
            if (YN.equalsIgnoreCase("n")){
                depAgain = false;
            }
        }
    }

    public static void withdraw(){
        double withdrawAmount = 0;
        boolean withdrawAgain = true;
        while (withdrawAgain == true){
            out.println("Withdraw");
            out.println("How much would you like to withdraw?");

            withdrawAmount = input.nextDouble();
            if (withdrawAmount > balance){
                out.println("You do not have enough balance to do this withdrawal.");
            }

            else{
            balance -= withdrawAmount;
            out.println("Withdrawal of " + withdrawAmount + " was successful.");
            }
            
            out.println("Would you like to do another transaction?");
            out.println("y/n");

            String YN = " ";

            while ((!YN.equalsIgnoreCase("y")) && (!YN.equalsIgnoreCase("n"))){
                out.println("Please enter y or n.");
                YN = input.next();
                
            }
            
            if (YN.equalsIgnoreCase("n")){
                withdrawAgain = false;
            }
        }
    }

    public static void balCheck(){
        out.println("Check Balance");
        out.println("You have " + balance + " in your account");
    }
}
