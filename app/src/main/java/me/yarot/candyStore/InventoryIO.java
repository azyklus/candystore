package me.yarot.candyStore;

import java.io.*;

public class InventoryIO
{
   private CandyStoreItem[] saveObjRecord;
   private CandyStoreItem[] saveRecord;
   private int counter;

   public InventoryIO()
   {
      counter = 0;
      saveObjRecord = new CandyStoreItem[20];
      saveRecord = new CandyStoreItem[20];
   }

   // Read from the specified file into our `saveRecord`.
   public void fileReadMethod(File currFile)
   {
      var st = new String();
      var sb = new StringBuilder();

      try (var fr = new FileReader(currFile)) {
         try (var br = new BufferedReader(fr)) {
            var ln = br.readLine();

            while (ln != null) {
               sb.append(ln);
               sb.append(System.lineSeparator());
               ln = br.readLine();

               st = sb.toString();

               var sort = st.split(",");
               this.saveRecord[this.counter] = new CandyStoreItem(sort[0], sort[1], sort[2], sort[3], sort[4]);
               this.counter++;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   // Write our altered `saveRecord` array to a file.
   public void writeFileMethod(File backFile)
   {
      // A blank storage variable.
      String store = "BLANK";

      // Create our `FileWriter`, catching any exceptions we run into.
      try (var fw = new FileWriter(backFile)) {
         // Create our buffered reader, and perform our writes.
         try (var bw = new BufferedWriter(fw)) {
            int i = 1;

            while (this.saveRecord != null) {
               store = this.saveRecord[i].getProduct();
               bw.write(store);

               i++;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   // Write our `saveRecord` to a file using `ObjectOutputStream`.
   public void writeObjectMethod(File newFile)
   {
      try (var fos = new FileOutputStream(newFile)) {
         try (var oos = new ObjectOutputStream(fos)) {
            oos.writeChars(this.toString());
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   // Read our `saveObjRecord` from a file using `ObjectInputStream`.
   public void objectInputMethod(File newFile)
   {
      try (var fis = new FileInputStream(newFile)) {
         try (var ois = new ObjectInputStream(fis)) {
            var ln = ois.readLine();
            var sb = new StringBuilder();
            var st = new String();

            while (ln != null) {
               sb.append(ln);
               sb.append(System.lineSeparator());
               ln = ois.readLine();

               st = sb.toString();

               var sort = st.split(",");
               this.saveObjRecord[this.counter] = new CandyStoreItem(sort[0], sort[1], sort[2], sort[3], sort[4]);
               this.counter++;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /////////////////////////////////////////////

   public void setCandyRecord()
   {
      this.saveRecord[this.counter] = new CandyStoreItem();
   }

   /////////

   public CandyStoreItem getCandyRecord()
   {
      return this.saveRecord[this.counter];
   }

   public void setIncreaseCount()
   {
      this.counter++;
   }

   public int getCounter()
   {
      return this.counter;
   }

   public CandyStoreItem getSaveObjRecord(int c)
   {
      return this.saveObjRecord[c];
   }

   @Override public String toString()
   {
      String[] store = new String[5];
      for (int i = 0; i < 5; i++) {
         store[0] = this.saveRecord[i].getProduct();
         store[1] = this.saveRecord[i].getSize();
         store[2] = this.saveRecord[i].getPackaging();
         store[3] = Integer.toString(saveRecord[i].getNoInStock());
         store[4] = Double.toString(saveRecord[i].getCustCost());
      }

      return store[0] + store[1] + store[2] + store[3] + store[4];
   }
}
