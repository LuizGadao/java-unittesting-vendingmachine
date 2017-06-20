package test;

import com.teamtreehouse.vending.AbstractChooser;
import com.teamtreehouse.vending.AlphaNumericChooser;
import com.teamtreehouse.vending.InvalidLocationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Luiz on 07/06/17.
 */
public class AlphaNumericChooserTest {


    @Rule
    public ExpectedException mThrow = ExpectedException.none();

    private AlphaNumericChooser mChooser;

    @Before
    public void setUp() throws Exception {
        mChooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception{
        AbstractChooser.Location mLocation = mChooser.locationFromInput("B4");

        assertEquals("proper row" , 1, mLocation.getRow());
        assertEquals("proper column",3, mLocation.getColumn());
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingWrongInputIsNotAllowed() throws Exception{
        mChooser.locationFromInput("wrong");
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargeThanMaxIsNotAllowed() throws Exception {
        mChooser.locationFromInput("B52");
    }

    @Test
    public void constructingLaregerThanAlphabeticNotAllowed() throws Exception {
        mThrow.expect(IllegalArgumentException.class);
        mThrow.expectMessage("Maximum rows supported is 26");
        new AlphaNumericChooser(27, 10);
    }
}