package me.yarot.candyStore;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;

public class InvTest {
   @Test public void can_write()
   {
      var tested_class = new InventoryIO();
      var file = new File("OldTimeCandyTest.txt");
      tested_class.writeFileMethod(file);
   }

   @Test public void can_read()
   {
      var tested_class = new InventoryIO();
      var file = new File("OldTimeCandyTest.txt");
      tested_class.fileReadMethod(file);

      assertNotNull(tested_class.getCandyRecord());
   }
}
