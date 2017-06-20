import com.teamtreehouse.vending.Bin;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by Luiz on 20/06/17.
 */
public class BinTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    public Bin mBin;

    @Before
    public void setUp() throws Exception {
        mBin = new Bin(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void restockWithDifferentItemsIsnotAllowed() throws Exception {
        mBin.restock("Cheetos", 1, 100, 50);
        mBin.restock("Doritos", 1, 100, 50);
    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals(0, mBin.getItemPrice());
    }

    @Test
    public void whenEmptyNamsIsNull() throws Exception {
        assertNull(mBin.getItemName());
    }

    @Test
    public void overStockNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");
        mBin.restock("Cheetos", 50, 100, 50);
    }
}