/**
     * Escapes special characters.
     * 

     * @param s
     * @return String
     */
    public static String convertSpecialChars( String s )
    {
        char c;
        int len = s.length();
        StringBuilder sb = new StringBuilder( len );

        int i = 0;
        while ( i < len )
        {
            c = s.charAt( i++ );
            if ( c == '\\' )
            {
                c = s.charAt( i++ );
                if ( c == 'n' )
                {
                    c = '\n';
                }
                else if ( c == 'r' )
                {
                    c = '\r';
                }
                else if ( c == 't' )
                {
                    c = '\t';
                }
                else if ( c == 'f' )
                {
                    c = '\f';
                }
                else if ( c == '\b' )
                {
                    c = '\b';
                }
                else if ( c == '\"' )
                {
                    c = '\"';
                }
                else if ( c == '\'' )
                {
                    c = '\'';
                }
                else if ( c == '\\' )
                {
                    c = '\\';
                }
            }
            sb.append( c );
        }
        return sb.toString();
    }