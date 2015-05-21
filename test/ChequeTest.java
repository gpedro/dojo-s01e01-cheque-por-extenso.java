import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChequeTest {

    @Test
    public void umReal() {
        Cheque umReal = new Cheque(1);
        assertEquals("um real", umReal.humanize());
    }

    @Test
    public void doisReais() {
        Cheque doisReais = new Cheque(2);
        assertEquals("dois reais", doisReais.humanize());
    }

    @Test
    public void cincoCentavos() {
        Cheque cincoCentavos = new Cheque(0.05);
        assertEquals("cinco centavos", cincoCentavos.humanize());
    }

    @Test
    public void centoVinteDoisReais() {
        Cheque centoVinteDoisReais = new Cheque(122);
        assertEquals("cento e vinte e dois reais",
                centoVinteDoisReais.humanize());
    }

    @Test
    public void centoQuinzeReais() {
        Cheque centoQuinzeReais = new Cheque(115);
        assertEquals("cento e quinze reais", centoQuinzeReais.humanize());
    }

    @Test
    public void centoUmReais() {
        Cheque centoUmReais = new Cheque(101);
        assertEquals("cento e um reais", centoUmReais.humanize());
    }

    @Test
    public void milReais() {
        Cheque milReais = new Cheque(1000);
        assertEquals("mil reais", milReais.humanize());
    }
}
