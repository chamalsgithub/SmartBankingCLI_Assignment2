import java.util.Arrays;
import java.util.Scanner;

public class Assignment2{
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        final String DASHBOARD = "\u25B6 \u25B9 Welcome to Smart Banking \u25B9 \u25B6    ";
        final String CREATE_ACC = "➕ Create New Account \u25B9 \u25B6 ";
        final String DEPOSITS = " ⏬ Deposit \u25B9 \u25B6 ";
        final String WITHDRAWALS = "⏫ Withdraw \u25B9 \u25B6 ";
        final String TRANSFER = "🔁 Trasfer \u25B9 \u25B6 ";
        final String PRINT_STATEMENT = "🖨 Bank Statement \u25B9 \u25B6 ";
        final String DELETE_ACC = " ␡ Delete Account \u25B9 \u25B6 ";
        
        /* String[] accId = new String[0];
        String[] accHolders = new String[0];
        double[] accBal = new double[0];
        
        
 */     ////////////// Create 2D Array ////////////////////////
        String [][] accounts = new String[0][3];

         ////////////// Create 2D Array ////////////////////////
        
        String screen = DASHBOARD;
        int idLast=0;
       
        do {

            final String APP_TITLE = String.format("%s%s%s",
                                COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
           
            System.out.println("\t" + APP_TITLE + "\n");
            
            switch(screen){
                //Dashboard View
                case DASHBOARD:
                    System.out.println("\t[1]. Create New Account");
                    System.out.println("\t[2]. Deposits");
                    System.out.println("\t[3]. Withdrawals");
                    System.out.println("\t[4]. Transfer");
                    System.out.println("\t[5]. Print Statement");
                    System.out.println("\t[6]. Delete Account");
                    System.out.println("\t[7]. Exit\n");

                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){ 
                        
                        case 1: screen = CREATE_ACC; break;
                        case 2: screen = DEPOSITS; break;
                        case 3: screen = WITHDRAWALS; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = PRINT_STATEMENT; break;
                        case 6: screen = DELETE_ACC; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;}
                        break;
                
                //Create Account        
                case CREATE_ACC :
                    boolean valid = true;
                    String id;
                    String name;
                    double balance=0; 
                    
                      
            
                    
                    loop1: 
                    do{

                        // Generate auto ID & store in temp var.
                        id = String.format("SDB-%05d", (idLast + 1));
                        System.out.print("\tID :"+id+ "\n");

                        // Get name and store in temp var.
                        valid = true;
                        System.out.print("\tName: ");
                        name = SCANNER.nextLine().strip();

                        
                        

                       if (name.isBlank()){  //Check whether the name is empty
                            System.out.printf(ERROR_MSG, "Name can't be empty");
                            valid = false;
                            continue loop1;
                        } 

                        for (int i = 0; i < name.length(); i++) { // check A-Z a-z spaces invalidity
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf(ERROR_MSG, "Invalid Name");
                                valid = false;
                                continue loop1;
                            }

                        }
                        
                       
                         balance = checkMin(5000, "\tInitial Deposit : ", "Insufficient initial deposit");

                    /* ///// Save acc holder id from temp var. to accId Array
                    String[] newAccId= new String[accId.length + 1];
                    for (int i = 0; i < accId.length; i++) {
                        newAccId[i] = accId[i];
                    }
                    newAccId[newAccId.length -1] = id;
                    accId = newAccId;

                    ///// Save acc holder name from temp var. to accHolders Array
                    String[] newAccHolders = new String[accHolders.length + 1];
                    for (int i = 0; i < accHolders.length; i++) {
                        newAccHolders[i] = accHolders[i];
                    }
                    newAccHolders[newAccHolders.length -1] = name;
                    accHolders = newAccHolders;

                    ///// Save acc holder's initial deposit amount from temp var. to accBal Array
                    double [] newAccBal = new double[accBal.length + 1];
                    for (int i = 0; i < accBal.length; i++) {
                        newAccBal[i] = accBal[i];
                    }
                    newAccBal[newAccBal.length -1] = balance;
                    accBal = newAccBal; */

                    /////////////////////////Stored in 2D ARRAY//////////////////////////////////////////////

                     // new array (old+1 member)

                    String [][] newAccounts = new String[accounts.length+1][3];
                    
                    //copy from old array to new array
                    for (int i = 0; i < accounts.length; i++) {
                        
                        newAccounts[i]=accounts[i];
                    }
                     //store new data inputs to new array
                    newAccounts[newAccounts.length-1][0]=id;
                    newAccounts[newAccounts.length-1][1]=name;
                    newAccounts[newAccounts.length-1][2]=balance+"";

                    //Assign new Array adress to "accounts" 
                    accounts=newAccounts;

                    //System.out.println(Arrays.toString(accounts[0]));

                    /////////////////////////Stored in 2D ARRAY//////////////////////////////////////////////

                    idLast++;
                    //Re-enter or Return to the dashboard
                    System.out.println();
                    System.out.printf("\tID: %s %s has been created successfully.\n\tDo you want to add another (Y/n)? ", id,name);
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                        
                                                
                    }while(!valid);
                    
                    break;
                
                //Deposit        
                case DEPOSITS :

                //Withdrawals       
                case WITHDRAWALS :

                //Transfer       
                case TRANSFER :

                //Print Statement      
                case PRINT_STATEMENT :

                //Delete Account        
                case DELETE_ACC :

                                       

            }


        } while (true);

       


    }

      public static double checkMin(double amountBoundary, String inputText, String ERROR_MSG){
            double amount ;
            boolean validity = false;

            do{
            System.out.printf(inputText);
             amount = SCANNER.nextInt();
            SCANNER.nextLine();

                if (amount<amountBoundary){  
                    System.out.printf(ERROR_MSG+"\n");
                    validity=true;
                }
               
            }while(validity) ;  
            
            return amount;
        }
    }
