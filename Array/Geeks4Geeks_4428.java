/*
 * Class representing a pair of long values.
 */
class Pair  
{  
    long first; // First value of the pair
    long second; // Second value of the pair
    
    // Constructor to initialize the pair with specified first and second values
    public Pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
} 

/*
 * Class containing a method to find the minimum and maximum elements in an array.
 */
class Solution 
{
    /*
     * Method to find the minimum and maximum elements in an array.
     * Returns the result as a Pair object.
     */
    static Pair getMinMax(long a[], long n)  
    {
        // Initialize variables to store the minimum and maximum values
        long min = Long.MAX_VALUE; // Initialize min to the maximum possible long value
        long max = Long.MIN_VALUE; // Initialize max to the minimum possible long value
        
        // Iterate through the array to find the minimum and maximum values
        for(int i=0; i<a.length; i++){
            min = Math.min(min, a[i]); // Update min if current element is smaller
            max = Math.max(max, a[i]); // Update max if current element is larger
        }
        
        // Create a new Pair object with the minimum and maximum values and return it
        Pair pair = new Pair(min, max);
        return pair;
    }
}
