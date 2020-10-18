 /**
     * Check that all entries of the input array are strictly positive.
     *
     * @param in Array to be tested
     * @throws NotStrictlyPositiveException if any entries of the array are not
     * strictly positive.
     * @since 3.1
     */
    public static void checkPositive(final double[] in)
        throws NotStrictlyPositiveException {
        for (int i = 0; i < in.length; i++) {
            if (in[i] <= 0) {
                throw new NotStrictlyPositiveException(in[i]);
            }
        }
    }