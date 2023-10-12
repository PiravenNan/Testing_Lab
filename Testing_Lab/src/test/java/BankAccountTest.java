import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.HashMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    BankAccount bankAccount;


    @BeforeEach

    public void setup(){ //resets variable between each test
        bankAccount = new BankAccount("John","Smith", LocalDate.parse("2000-06-16"));;

    }

    @Test

    void depositTest(){
        //given
        bankAccount.deposit(1001);
        //when
        int result = bankAccount.getBalance();
        //then
        int expected = 1001;
        assertThat(result).isEqualTo(expected);
    }

    @Test

    void withdrawTest(){
        //given
        String resultMessage = bankAccount.withdraw(1001);
        //when
        int result = bankAccount.getBalance();
        //then
        int expected = 0;
        String expectedMessage = "Couldn't withdraw: Account balance would fall below overdraft limit";
        assertThat(result).isEqualTo(expected);
        assertThat(resultMessage).isEqualTo(expectedMessage);
    }

    @Test

    void interestTest(){
        //given
        bankAccount.deposit(100);
        bankAccount.setAccountType("Current");
        HashMap <String, Double> interestHashMap = new HashMap<>();
        interestHashMap.put("Savings",1.05);
        interestHashMap.put("Current",1.5);
        //when
        bankAccount.payInterest(interestHashMap.get(bankAccount.getAccountType()));
        int result = bankAccount.getBalance();
        //then
        int expected = 150;
        assertThat(result).isEqualTo(expected);
    }
}
