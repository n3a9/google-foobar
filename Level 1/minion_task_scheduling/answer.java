/**
 * A brute force solution to the challenge, but considering there are only 100 integers
 * in the array, it works.
 */
public class Answer {
    
    /**
     * Actual method for the challenge.
     *
     * Will take in the array of integers data, and remove all instances of an element
     * that appears more than n times.
     *
     * @param data: the array of integers to check
     * @param n: the maximum number of times that an element can appear in the array
     */
    public static int[] answer(int[] data, int n)
    {
        int i = 0;
        while (i < data.length) //go through entire array (it will change size)
        {
            if (count(data, data[i]) > n ) //element appears in array than n times
            {
                data = removeValue(data, data[i]); //remove all instances of value in array
            }
            else //it appears less than n times, so move to check next element
            {
                i++;
            }
        }
        return data; //return the newly trimmed array
    }
    
    /**
     * Will count the number of times an element (the number) appears in the array.
     *
     * @param data: the array of integers
     * @param number: the number to check how many times it appears in the array
     */
    public static int count(int[] data, int number)
    {
        int count = 0; //track number of times it appears
        
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == number)
            {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Will return a new array with all instances of the given number removed.
     *
     * @param data: the array of integers of which to remove the number
     * @param number: the number to be removed from the array.
     */
    public static int[] removeValue(int[] data, int number)
    {
        //integer holding length of the old array - the number of times
        int newLength = data.length-count(data,number);
        int[] newValues = new int[newLength]; //new array with the length
        int track = 0; //index tracker for the new array
        for (int i = 0; i < data.length; i++) //iterate through the old array
        {
            if (data[i] != number) //if the current element is not the number
            {
                newValues[track] = data[i]; //add it to the new array
                track++; //increase the index tracker for the new array
            }
        }
        return newValues; //return the new array
    }
    
}
