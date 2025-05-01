import org.junit.Test;
import static org.junit.Assert.*;

public class ContaBancariaTeste {
    @Test
    public void deveInstanciarContaComTitularESaldo() {
        //Act
        ContaBancaria conta = new ContaBancaria("Afranio", 50.0);

        //Assert
        assertEquals("Afranio", conta.getTitular());
        assertEquals(50.0, conta.getSaldo(), 0.000001);
    }

    @Test
    public void deveRealizarUmSaque() {
        //Arrange
        ContaBancaria conta1 = new ContaBancaria("Afranio", 80.0);
        ContaBancaria conta2 = new ContaBancaria("Greyce", 120.0);

        //Act
        conta1.sacar(50);
        conta2.sacar(80);

        //Assert
        assertEquals(29.9, conta1.getSaldo(), 0.000001);
        assertEquals(39.84, conta2.getSaldo(), 0.000001);
    }

    @Test
    public void deveRealizarUmDeposito() {
        //Arrange
        ContaBancaria conta = new ContaBancaria("Afranio", 80.0);

        //Act
        conta.depositar(50);

        //Assert
        assertEquals(129.75, conta.getSaldo(), 0.000001);
    }

    @Test
    public void deveRetornarErroSaldoInsufuciente() throws Exception{
        //Arrange
        ContaBancaria conta = new ContaBancaria("Afranio", 50.00);

        RuntimeException erro = assertThrows(RuntimeException.class, () -> conta.sacar(75.0));

        //Assert
        assertEquals("Saldo Insuficiente!", erro.getMessage());
    }

    @Test
    public void deveRetornarErroSaqueValorZerado() {
        //Arrange
        ContaBancaria conta = new ContaBancaria("Afranio", 50.00);

        RuntimeException erro = assertThrows(RuntimeException.class, () -> conta.sacar(0.0));

        //Assert
        assertEquals("Retire um valor maior que 0!", erro.getMessage());
    }

    @Test
    public void deveRetornarErroDepositoValorZerado() {
        //Arrange
        ContaBancaria conta = new ContaBancaria("Afranio", 50.00);

        RuntimeException erro = assertThrows(IllegalArgumentException.class, () -> conta.depositar(0.0));

        //Assert
        assertEquals("Deposite um valor maior que 0!", erro.getMessage());
    }

    @Test
    public void deveRetornarErroLimiteSaque() {
        //Arrange
        ContaBancaria conta = new ContaBancaria("Greyce", 5000.00);

        RuntimeException erro = assertThrows(RuntimeException.class, () -> conta.sacar(3500.00));

        //Assert
        assertEquals("O saque não pode ser superior á R$3000.00", erro.getMessage());
    }

    @Test
    public void deveRealizarTransferencia() {
        //Arrange
        ContaBancaria conta1 = new ContaBancaria("Greyce", 5000.00);
        ContaBancaria conta2 = new ContaBancaria("Afranio", 2000.00);

        //Act
        conta1.transferir(conta2, 150);

        //Assert
        assertEquals(4850.00, conta1.getSaldo(), 0.00001);
        assertEquals(2150.00, conta2.getSaldo(), 0.00001);
    }
}
