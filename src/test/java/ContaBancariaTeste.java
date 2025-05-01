import org.junit.Test;
import static org.junit.Assert.*;

public class ContaBancariaTeste {
    @Test
    public void deveInstanciarContaComTitularESaldo() {
        //Act
        ContaBancaria conta = new ContaBancaria("Afranio", 50);

        //Assert
        assertEquals("Afranio", conta.getTitular());
        assertEquals(50, conta.getSaldo());
    }

    @Test
    public void deveRealizarUmaTransferencia() {
        ContaBancaria conta1 = new ContaBancaria("Afranio", 50);
        ContaBancaria conta2 = new ContaBancaria("Greyce", 120);

        conta1.depositar(50);
        conta2.sacar(50);
    }
}
