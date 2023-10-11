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
        bankAccount.withdraw(1001);
        //when
        int result = bankAccount.getBalance();
        //then
        int expected = -1001;
        assertThat(result).isEqualTo(expected);
    }

    @Test

    void interestTest(){
        //given
        BankAccount bankAccount = new BankAccount("John","Smith", LocalDate.parse("2000-06-16"));
        bankAccount.deposit(100);
        bankAccount.payInterest();
        //when
        int result = bankAccount.getBalance();
        //then
        int expected = 105;
        assertThat(result).isEqualTo(expected);
    }
}
