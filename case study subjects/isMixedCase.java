7397    /**
7398     * <p>Checks if the CharSequence contains mixed casing of both uppercase and lowercase characters.</p>
7399     *
7400     * <p>{@code null} will return {@code false}. An empty CharSequence ({@code length()=0}) will return
7401     * {@code false}.</p>
7402     *
7403     * <pre>
    * StringUtils.isMixedCase(null)    = false
     * StringUtils.isMixedCase("")      = false
     * StringUtils.isMixedCase("ABC")   = false
     * StringUtils.isMixedCase("abc")   = false
     * StringUtils.isMixedCase("aBc")   = true
     * StringUtils.isMixedCase("A c")   = true
    * StringUtils.isMixedCase("A1c")   = true
     * StringUtils.isMixedCase("a/C")   = true
     * StringUtils.isMixedCase("aC\t")  = true
     * </pre>
    *
    * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence contains both uppercase and lowercase characters
     * @since 3.5
     */
   public static boolean isMixedCase(final CharSequence cs) {
        if (isEmpty(cs) || cs.length() == 1) {
            return false;
        }
        boolean containsUppercase = false;
        boolean containsLowercase = false;
        final int sz = cs.length();
        for (int i = 0; i < sz; i++) {
            if (containsUppercase && containsLowercase) {
                return true;
            } 
               else if (Character.isUpperCase(cs.charAt(i))) {
                containsUppercase = true;
           } else if (Character.isLowerCase(cs.charAt(i))) {
               containsLowercase = true;            }
       }
        return containsUppercase && containsLowercase;
   }
