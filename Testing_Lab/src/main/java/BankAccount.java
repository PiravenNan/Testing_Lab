import java.time.LocalDate;
import java.util.HashMap;

public class BankAccount {

    //constructor

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private int balance;
    private String accountType;
    private int overdraft;
    HashMap<String, Double> interestHashMap;// = new HashMap<>();

    //interestHashMap.put("Savers",1.05);

    //constructor
    public BankAccount(String firstName, String lastName, LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = 0;
        this.balance = 0;
        this.accountType = "Savings";
        this.overdraft = 0;
        this.interestHashMap = new HashMap<>();
        this.interestHashMap.put("Savings",1.05);
        this.interestHashMap.put("Current",1.5);
    }

    public void deposit (int amount) {
        this.balance += amount;
    }

    public String withdraw(int amount){
        if(this.balance - amount >= overdraft){
            this.balance -= amount;
            return "Withdraw successful";
        }
        return "Couldn't withdraw: Account balance would fall below overdraft limit";
    }

    public void payInterest(){
        this.balance *= this.interestHashMap.get(this.accountType);
    }

    //getters
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public int getBalance(){
        return balance;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getOverdraft() {
        return overdraft;
    }

    //setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }


}
