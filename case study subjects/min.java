/**
     * <p>Returns the minimum value in an array.

     * 
     * @param array  an array, must not be null or empty
     * @return the minimum value in the array
     * @throws IllegalArgumentException if <code>array is null
     * @throws IllegalArgumentException if <code>array is empty
     * @since 3.4 Changed signature from min(int[]) to min(int...)
     */
    public static int min(final int... array) {
        // Validates input
        validateArray(array);
    
        // Finds and returns min
        int min = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
    
        return min;
    }
