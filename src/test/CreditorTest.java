package test;

import com.teamtreehouse.vending.Creditor;
import com.teamtreehouse.vending.NotEnoughFundsException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Luiz on 07/06/17.
 */
public class CreditorTest {

    private Creditor mCreditor;

    @Before
    public void setUp() throws Exception {
        mCreditor = new Creditor();
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {
        mCreditor.addFunds(25);
        mCreditor.addFunds(25);

        assertEquals(50, mCreditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {
        mCreditor.addFunds(10);

        int refund = mCreditor.refund();

        assertEquals(10, refund);
    }

    @Test
    public void refundingResetsAvailableFundsToZero() throws Exception {
        mCreditor.addFunds(10);

        mCreditor.refund();

        assertEquals(0, mCreditor.getAvailableFunds());
    }

    @Test(expected = NotEnoughFundsException.class)
    public void deductFoundThatIsNotAllowed() throws Exception{
        mCreditor.addFunds(100);
        mCreditor.deduct(1000);
    }

}