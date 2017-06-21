import com.teamtreehouse.vending.Item;
import com.teamtreehouse.vending.Notifier;
import com.teamtreehouse.vending.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Luiz on 21/06/17.
 */
public class VendingMachineTest {

    VendingMachine mMachine;

    class NotifierImpl implements Notifier{

        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @Before
    public void setUp() throws Exception {
        NotifierImpl notifierStub = new NotifierImpl();
        mMachine = new VendingMachine(notifierStub, 10, 10, 10);
        mMachine.restock("A1", "Toritos", 10, 30, 70);
    }

    @Test
    public void vendingWhenStockReturnItem() throws Exception {
        mMachine.addMoney(100);
        Item a1 = mMachine.vend("A1");
        assertEquals("Toritos", a1.getName());
    }
}