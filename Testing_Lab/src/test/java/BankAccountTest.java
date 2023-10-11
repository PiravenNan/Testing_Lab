import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    @Test

    void depositTest(){
        //given
        BankAccount bankAccount = new BankAccount("John","Smith", LocalDate.parse("2000-06-16"));
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
        BankAccount bankAccount = new BankAccount("John","Smith", LocalDate.parse("2000-06-16"));
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
        BankAccount bankAccount = new BankAccount("John","Smith", LocalDate.parse("2000-06-16"));
        bankAccount.deposit(100);
        bankAccount.setAccountType("Current");
        bankAccount.payInterest();
        //when
        int result = bankAccount.getBalance();
        //thengst
        int expected = 150;
        assertThat(result).isEqualTo(expected);
    }
}
