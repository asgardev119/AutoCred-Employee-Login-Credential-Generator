import java.util.Scanner;

public class emailgenerator {

    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail = " contact to technical team";
    private String companySuffix = "email.com";

    public emailgenerator(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // 1st call
    private String setDepartment() {
        System.out.print("Welcome!! " + firstname + "." + " You are Our New Employee."
                + " \nChoose Department Codes\n1 C++\n2 Java\n3 Python\n0 None\nEnter Department Code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "C++";
        } else if (depChoice == 2) {
            return "Java";
        } else if (depChoice == 3) {
            return "Python";
        } else {
            return "";
        }
    }

    // 2nd call
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*^";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // these are more feature --------------->

    // public void setMailboxCapacity(int capacity) {
    // this.mailboxCapacity = capacity;
    // }

    // public void setAlternateEmail(String altEmail) {
    // this.alternateEmail = altEmail;
    // }

    // public void changePassword(String password) {
    // this.password = password;
    // }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display Name: " + firstname + " " + lastname +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your First Name: ");
        String First = sc.nextLine();
        System.out.println("Enter your Last Name: ");
        String Last = sc.nextLine();
        emailgenerator email = new emailgenerator(First, Last);
        System.out.println(email.showInfo());

    }
}
