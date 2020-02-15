
public class Driver
{
    // Authors: 
// Patrick Barsoum     19240058
// Micheal Hogan       15172856
// Kevin McCarthy      19237219
// Patrick McCarthy    19237405
    public static void main (String[] args)
 {
       SpreadSheetSystem anInstance = new SpreadSheetSystem();
       anInstance.Display();
       
       System.out.println("Adding Sheet4:");
       anInstance.add();
       anInstance.Display();
       
       System.out.println("Remove Sheet2:");
       anInstance.remove("Sheet2");
       anInstance.Display();
       
       System.out.println("Remove the third item");
       anInstance.remove(3);
       anInstance.Display();
       
       System.out.println("Creating a new instance");
       SpreadSheetSystem anotherInstance = new SpreadSheetSystem();
       anotherInstance.Display();
       
       System.out.println("Adding a few more sheets");
       anotherInstance.add();
       anotherInstance.add();
       anotherInstance.add();
       anotherInstance.Display();
       
       System.out.println("Move the first item to after the third item");
       anotherInstance.move(1,3,false);
       anotherInstance.Display();
       
       System.out.println("Move Sheet3 to before Sheet6");
       anotherInstance.move("Sheet3","Sheet6",true);
       anotherInstance.Display();
       
       System.out.println("Move the first item to the end");
       anotherInstance.moveToEnd(1);
       anotherInstance.Display();
       
       System.out.println("Move Sheet1 to the end");
       anotherInstance.moveToEnd("Sheet1");
       anotherInstance.Display();
       
       System.out.println("Rename Sheet1 to MySheet");
       anotherInstance.rename("Sheet1","MySheet");
       anotherInstance.Display();
       
       System.out.println(anotherInstance.Index("Sheet6") + " is the index of Sheet6");
       
       System.out.println("There are " + anotherInstance.length() + " sheets in the list");
       
    }
}


