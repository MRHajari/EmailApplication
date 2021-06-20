package M.R.Hajari;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class EmailGenerate extends Password{
    private String alternateEmail;
    private String companySuffix = "company.com";
    private String department;
    private String email;
    private String firstName;
    private String lastName;
    private int mailboxCapacity;

    Scanner input = new Scanner(System.in);

    //constructor
    public EmailGenerate(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);

        //method --> asking for the department - return --> the dipartment
        this.department = setDepartment();

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" +
                department + "." + companySuffix;
    }


    // seters methode for name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    //  Ask for the department
    private String setDepartment() {
        System.out.print("Please Enter yor department\n1 for Sales\n" +
                "2 for Development\n3 for Accounting and 0 for other: ");
        String depChoice = "";
        boolean flagSetDepartment = true;

        while (flagSetDepartment == true) {
            depChoice = input.nextLine();

            if(depChoice.length() == 1) {
                if ( depChoice.equals("0") || depChoice.equals("1") ||
                        depChoice.equals("2") || depChoice.equals("3")  == true) {
                    flagSetDepartment = false;
                } else {
                    System.out.println("Oops! That was no valid value. Try again...");
                }
            }else{
                System.out.println("Oops! That was no valid value. Try again...");
            }
        }

        Dictionary<String, String> department0 = new Hashtable<>();
        department0.put("0", "other");
        department0.put("1", "sales");
        department0.put("2", "dev");
        department0.put("3", "acct");

        return department0.get(depChoice);
    }


    // Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        boolean flagCapacity = true;
        while (flagCapacity == true) {
            if (mailboxCapacity >= 1 && mailboxCapacity <= 10) {
                flagCapacity = false;
            } else {
            }
        }
        this.mailboxCapacity = mailboxCapacity;
    }


    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        boolean falagAlternateEmail = false;

        while (falagAlternateEmail == false) {
            if (alternateEmail.indexOf("@") != -1 &&
                    alternateEmail.indexOf(".") != -1) {
                this.alternateEmail = alternateEmail;
                falagAlternateEmail = true;
            } else {
                System.out.println("Oops! That was no valid value. Try again...");
            }
        }
    }


    // getters methode
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }


    public void showInfo() {
        System.out.println("----------------------------------------------");
        System.out.println("fullname:         " + getFirstName() +" "+ getLastName() +
                "\ncompany email:    " + email +
                "\nmailbox capacity: " + getMailboxCapacity() + " GB" +
                "\nalternate email:  " + getAlternateEmail() +
                "\npasswoard:        " + getPassword());
    }
}
