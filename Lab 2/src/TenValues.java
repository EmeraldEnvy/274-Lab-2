/**
*Alexander Pham
*September 9, 2019
*Program that allows the user to create an array and allows them to edit and view the contents
*/
import java.util.Scanner;

public class TenValues {
    public static void main( String[] args ){
        Scanner input = new Scanner( System.in );
        //Prompts the user to create the array
        int[] userArray = populateArray();
        //Loops the code
        while (true){
            printMenu();
            System.out.print( "What would you like to do? : " );
            int userNumber = CheckInput.getInt();
            //Limits the user to enter a number in the range of the menu
            while ( userNumber<1 || userNumber>8 ){
                System.out.print( "Invalid, try again: " );
                userNumber = CheckInput.getInt();
            }
            //Display Array
            if ( userNumber == 1 ){
                displayValues( userArray );
            }
            //Display array in reverse
            if ( userNumber == 2 ) {
                displayReversed( userArray );
            }
            //Sum of all numbers in array
            if ( userNumber == 3 ){
                int sum = computeSum( userArray );
                System.out.println( "The sum of the array is " + sum );
            }
            //Search for largest value
            if ( userNumber == 4 ){
                int maxNumber = maxValue( userArray );
                System.out.println( "The largest value is " + maxNumber );
            }
            //Search for a value
            if ( userNumber == 5 ) {
                System.out.print( "Which number would you like to look for? : " );
                int userGuess = CheckInput.getInt();
                int indexValue = findValue( userArray, userGuess );
                if (indexValue == -1){ //Turns -1 into an understandable message
                    System.out.println( "Your value was not found" );
                }
                else {
                    System.out.println( "Your value is at location " + indexValue );
                }
            }
            //Insert new value
            if ( userNumber == 6 ){
                System.out.print( "What number would you like to add in? : " );
                int newNumber = CheckInput.getInt();
                System.out.print( "Where would you like to place this number? : " );
                int numberLocation = CheckInput.getInt();
                //Limits the user to enter a number in the range of the array
                while ( numberLocation<1 || numberLocation>10 ) {
                    System.out.print( "Invalid, try again: " );
                    numberLocation = CheckInput.getInt();
                }
                //Passes the array, new number, and the location that is to be replaced
                userArray = insertValue( userArray, newNumber, numberLocation );
            }
            //Reset Values
            if ( userNumber == 7 ){
                userArray = populateArray();
            }
            if ( userNumber == 8 ){
                System.out.print( "Later loser ♥" );
                break;
            }
        }
    }

    /**
     * Populates the array with 10 numbers given by the user
     * @return array
     */
    public static int[] populateArray(){
        int [] array = new int[10];
        //User is asked to enter 10 numbers while also being checked to make sure that the input is an integer
        for ( int i = 0; i < array.length; i++ ){
            System.out.print( "Enter in number " + (i+1) + " : " );
            int userInput = CheckInput.getInt();
            array[i] = userInput;
        }
        return array;
    }

    /**
     * Display values in array separated by commas
     * @param array - user made array
     */
    public static void displayValues( int[] array ){
        for (int i = 0; i < array.length; i++ ){
            if ( i < 9 ){
                System.out.print( array[i] + ", " ); //Prints the first 9 numbers with a , after
            }
            else {
                System.out.println( array[i] ); //Prints the last number without a , after
            }
        }
    }

    /**
     * Displays values in array in reversed order separated by commas
     * @param array - user made array
     */
    public static void displayReversed( int[] array ){
        //starts at index 9 rather than index 0
        for ( int i = 9; i >= 0; i--){
            if ( i > 0 ){
                System.out.print( array[i] + ", " ); //Prints the first 9 numbers with a , after
            }
            else {
                System.out.println( array[i] ); //Prints the last number without a , after
            }
        }
    }

    /**
     * Finds the location of a value and returns the location (1-based) if found and returns -1 if not in the array
     * @param array - user made array
     * @param userNumber - the value that the user wants to look for in the array
     * @return location of number or -1 if not in array
     */
    public static int findValue( int[] array, int userNumber ){
        for ( int i = 0; i < array.length; i++){
            if ( userNumber == array[i] ){
                return i+1; //If the number is in the array
            }
        }
        return -1; //If the number is not in the array
    }

    /**
     * Replaces a number in a location (1-based) with another number
     * @param array - user made array
     * @param newNumber - the number that the user wants to add to the array
     * @param numberLocation - the location that the user wants to put the new value into
     * @return array - new array
     */
    public static int[] insertValue( int[] array, int newNumber, int numberLocation ){
        //Turn numberLocation from 1-based to 0-based
        numberLocation = numberLocation - 1;
        array[numberLocation] = newNumber;
        return array;
    }

    /**
     * Finds the largest value in the array
     * @param array - user made array
     * @return maxNumber - the largest number in the array
     */
    public static int maxValue( int[] array ){
        int maxNumber = 0;
        for ( int i = 0; i < array.length; i++ ){
            if ( array[i] > maxNumber ){
                maxNumber = array[i]; //Replaces the previously largest number if the current one is larger
            }
        }
        return maxNumber;
    }

    /**
     * Computes the sum of the array
     * @param array - - user made array
     * @return sum - the sum of all the numbers in the array
     */
    public static int computeSum( int[] array ){
        int sum = 0;
        for ( int i = 0; i < array.length; i++ ){
            sum += array[i]; //Add each index to the sum one at a time
        }
        return sum;
    }

    /**
     * Prints the menu
     */
    public static void printMenu(){
        System.out.println( "--------------------MENU--------------------" ); //For aesthetic purposes
        System.out.println( "1. Display Values" );
        System.out.println( "2. Display Reversed" );
        System.out.println( "3. Display Sum" );
        System.out.println( "4. Display Maximum" );
        System.out.println( "5. Search for a value" );
        System.out.println( "6. Insert new value" );
        System.out.println( "7. Reset values" );
        System.out.println( "8. Quit" );
    }
}