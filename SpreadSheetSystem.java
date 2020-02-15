


 public class SpreadSheetSystem {
  
    public static String[] myArray = new String[256];
    public static int nextAvailablePos;
    public static int N;
    public static int amountOfSheets;
    public SpreadSheetSystem(){
        myArray [0] = "Sheet1";
        myArray [1] = "Sheet2";
        myArray [2] = "Sheet3";
        N = 4;
        nextAvailablePos = 3;
        amountOfSheets = 3;
    }
    public static boolean add()
    {
        if(nextAvailablePos < myArray.length)
        {
            myArray[nextAvailablePos] = "Sheet" + N;
            nextAvailablePos++;
            amountOfSheets++;
            N++;
            return true;
        } 
        else
        {
            return false;
        }
    }

    
  public static int remove(String sheetName)
    {
        // What this Method Does:
        // passed an element in the array that has to be removed
        // if element not found then nothing happens
        // cant have less than one element in the array
        // if the remove operation is succesful 
        // it will return the index position of where the sheet was removed
        int pos = -1;
        //need to find element in a list to remove (gives me in index of element to remove)
        for(int i = 0; i < amountOfSheets; i++)
        {
            if (myArray[i].equalsIgnoreCase(sheetName))
            {
                pos = i;
            }
        }
        // if the number of sheets in the workbook is greater than one excute block and pos is not equal to -1 do this:
        if ( amountOfSheets > 1 && pos != -1)
        {

            //Removing array element
            for(int h = pos; h < amountOfSheets-1; h++)
            {
                myArray[h] = myArray[h+1];
            } 
            myArray[amountOfSheets - 1] = "null";

            //Sheet has been removed from the list
            amountOfSheets--;
            nextAvailablePos--;
            
            return pos + 1;
        }
        else
        {
            return -1;
        }
  }
    
    
  public static String remove(int index)
    {
        //      This Method Does This:
        // passed index value to be removed from the list 
        // if the index value is not in the range nothing happens 
        // similar to the other remove method the sheet at the specfied index
        // is removed fromt the list and there has to be least one sheet in
        // the workbook at all times 
        // Returns sheet name that has been removed 
        String SheetName = myArray[index - 1];
        if ( amountOfSheets > 1 && index != -1)
        {
            //Removing array element
            for(int h = index - 1; h < amountOfSheets-1; h++)
            {
                myArray[h] = myArray[h+1]; 

            } 
            //Last element in array sheets set to a blank space -  Not correct to do 
            myArray[amountOfSheets - 1] = "null" ;
            //Sheet has been removed from the list
            amountOfSheets--;
            nextAvailablePos--;
            return SheetName;
        }
        else
        {
            return " ";
        } 
  }
    
      public static String move(int from, int to, boolean before){
        if((from > amountOfSheets) || (to > amountOfSheets) || (from < 1) || (to < 1) || (from == to)){
            return null;
        }
        else{
            from--;
            to--;
            String frOm = myArray[from];
            int diff = to - from;
            if(diff > 0){
                if(before == true){
                    diff--;
                    to--;
                }
                for(int i = 0; i < diff; i++){
                    myArray[from] = myArray[from + 1];
                    from++;
                }
                myArray[to] = frOm;
                return frOm;
            }
            else{
                diff = diff * -1;
                if(before == true){
                    diff++;
                    to--;
                }
                for(int i = 0; i < diff; i++){
                    myArray[from] = myArray[from - 1];
                    from--;
                }
                myArray[to] = frOm;
                return frOm;
            }
        }
  } 
  
  public static int move(String from, String to, boolean before)
    {
        int fromIndex = Index(from);
        int toIndex = Index(to);
        if (fromIndex == toIndex)
        {
            return -1;
        }
        move(fromIndex, toIndex, before);
         return Index(from);
        }
    
  public static String moveToEnd(int from)
    {
        if(from != -1 && from < amountOfSheets-1)
        {
            String temp = myArray[from - 1];
            move(from, amountOfSheets, false);            
            return temp;
        } 
        else 
        {
            return null;  
        }
  }

    
  public static int moveToEnd(String from)
    {
        int fromIndex = Index(from);
        fromIndex--;
        if(fromIndex != -1 && fromIndex < amountOfSheets-1)
        {
            move(from, sheetName(amountOfSheets - 1), false);            
            return fromIndex + 1;
        }
        return -1;
  }

    
  public static int rename(String currentName, String newName)
    {
        boolean contains1 = false;
        boolean contains2 = false;
        int i;
        int index;
        for(i = 0; i < amountOfSheets; i++){
            if(currentName.equalsIgnoreCase(myArray[i]) == false){
                continue;
            }
            else{
                contains1 = true;
                break;
            }
        }
        index = i;
        for(i = 0; i < amountOfSheets; i++){
            if(newName.equalsIgnoreCase(myArray[i]) == false){
                continue;
            }
            else{
                contains2 = true;
                break;
            }
        }
        if((contains1 == false) || (contains2 == true)){
            return -1;
        }
        else{
            myArray[index] = newName;
            return index + 1;
        }
  }

    
  public static int Index(String name)
    {  
        boolean contains = false;
        int index;
        int i = 0;
        for(i = 0; i < amountOfSheets; i++){
            if(name.equalsIgnoreCase(myArray[i]) == false){
                continue;
            }
            else{
                contains = true;                
                break;
            }
        }
        if(contains == false){
            return -1;
        }
        else{
            index = i + 1;
            return index;
        }
  }
 
    
  public static String sheetName(int Index)
    {
        if(Index >= 0 && Index < myArray.length)
        {
            return myArray[Index];
        } 
        else 
        {
            return null;
        }
  }

    
  public static void Display()
    {    
    for(int i=0;i<amountOfSheets;i++)
    {  
        System.out.println(myArray[i]);
    } 
  }


  public static int length()
    {
    return amountOfSheets;
  }   
}


