// Max in array
    //--------------------------------------------------------------------
    /**
     * <p>Returns the maximum value in an array.

     * 
     * @param array  an array, must not be null or empty
     * @return the maximum value in the array
     * @throws IllegalArgumentException if <code>array is null
     * @throws IllegalArgumentException if <code>array is empty
     * @since 3.4 Changed signature from max(long[]) to max(long...)
     */
    public static long max(final long... array) {
        // Validates input
        validateArray(array);

        // Finds and returns max
        long max = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }