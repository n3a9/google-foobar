public class Answer {

    public static int[] answer(int[] data, int n)
    {
        int i = 0;
        while (i < data.length)
        {
            if (count(data, data[i]) > n ) //appears more number of times than n
            {
                data = removeValue(data, data[i]);
            } else {
                i++;
            }
        }
        return data;
    }

    //returns the number of times the number appears in the array
    public static int count(int[] data, int number)
    {
        int count = 0;

        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == number)
            {
                count++;
            }
        }
        return count;
    }

    //removes all instances of the value in the array
    public static int[] removeValue(int[] data, int number)
    {
        int newLength = data.length-count(data,number);
        int[] newValues = new int[newLength];
        int track = 0;
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] != number)
            {
                newValues[track] = data[i];
                track++;
            }
        }
        return newValues;
    }

}