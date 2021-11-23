# Computer Science Project: Candy Shoppe

The Candy Shoppe project is a high-school-level computer science project.
In this project, we are provided with only the `CandyInventoryTest` class, which contains the main function
and all of its contents and are tasked with producing a working application which conforms to the code in the
main function.

---

## The Main Class

```java
/*************************************************
// File name:  CandyInventoryTest
// Author:  Ms. Forrest
//
// Purpose: This file is to test the ability to read and write information from files and place
them in
//          objects
//
**************************************************/
package me.yarot.candyStore;

import java.io.File;

public class CandyInventoryTest {
  public static void main (String args[]){
    InventoryIO info = new InventoryIO();
    // define the File to open
    File currFile = new File("OldTimeCandy.txt");
    /***********************************************************/
    // open and read the original text file and instantiate
    // the objects for the arrays in the SavePtIO class
    /**********************************************************/
    info.fileReadMethod(currFile);
    // add another record object into the student record array saveRecord[]
    info.setCandyRecord();
    //retrieve the object and set the new values in the record.
    info.getCandyRecord().setProduct("Mars Bar");
    info.getCandyRecord().setSize("55 g");
    info.getCandyRecord().setPackaging("plastic wrap");
    info.getCandyRecord().setNoInStock(24);
    info.getCandyRecord().setCustCost(2.05);
    info.setIncreaseCount(); //counter in InventoryIO class needs to be increased.
    //print out all of the  entries using the toString()
    System.out.println(info);
    /*************************************************************/
    // write the object out as a text file with the new addition
    /*************************************************************/
    File backFile = new File("candyBackup.txt");
    info.writeFileMethod(backFile);
    /************************************************************/
    //read the backupfile and see if you can import it too
    // your total number of record should now be 16 (the whole inventory twice)
    /************************************************************/
    info.fileReadMethod(backFile);
    //print out all of the  entries using the toString()
    System.out.println(info);
    /*************************************************************/
    // export file as an object (class info inclusive)
    /*************************************************************/
    File newFile = new File("candyInfo.dat");
    info.writeObjectMethod(newFile);
    /*************************************************************/
    // import the file as objects (with the class info)
    // to prove you have written the file,  load and then show
    /************************************************************/
    //remember the second array saveObjData was made for this part
    info.objectInputMethod(newFile);
    //Final check of your results. (we use the previous counter to show the records)
    System.out.println("There are "+ info.getCounter() +" candy records saved in the
    array.\n" + "The candy records are: ");
    for(int c=0; c<info.getCounter(); c++){
      System.out.print(c+":\n");
      System.out.print(info.getSaveObjRecord(c));
      System.out.println();
    }
  }
}
```


## Our Config File

Our main config data comes from a text file (values separated by commas):
```text
////////////////////////////////////////////////////////////////////////////////////////////////////////////
The  OldTimeCandy.txt file
///////////////////////////////////////////////////////////////////////////////////////////////////////////
Bottle Caps, 50 g, box, 24, 1.50
Banana Runts, 140g, plastic container, 10, 7.80
Candy Necklaces, 22g, plastic bag, 50, 0.75
Sweet Tarts, 51g, foil wrapped, 45, 1.50
Strawberry Twizzlers, 70g, plastic bag, 20, 2.20
Licorice Pipes, 17g, plastic bag, 30, 1.10
Hubba Bubba Bubble Tape, 56.6g, plastic dispenser, 12, 2.50
```


