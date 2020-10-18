static char *
make_printable_str (const unsigned char *s, size_t len)
{
  /* Worst case is that every character expands to a backslash
     followed by a 3-character octal escape sequence.  */
  char *printable_buf = xmalloc (4 * len + 1);
  char *p = printable_buf;
  size_t i;

  for (i = 0; i < len; i++)
    {
      char buf[5];
      char *tmp = NULL;

      switch (s[i])
	{
	case '\\':
	  tmp = "\\";
	  break;
	case '\007':
	  tmp = "\\a";
	  break;
	case '\b':
	  tmp = "\\b";
	  break;
	case '\f':
	  tmp = "\\f";
	  break;
	case '\n':
	  tmp = "\\n";
	  break;
	case '\r':
	  tmp = "\\r";
	  break;
	case '\t':
	  tmp = "\\t";
	  break;
	case '\v':
	  tmp = "\\v";
	  break;
	default:
	  if (ISPRINT (s[i]))
	    {
	      buf[0] = s[i];
	      buf[1] = '\0';
	    }
	  else
	    sprintf (buf, "\\%03o", s[i]);
	  tmp = buf;
	  break;
	}
      p = stpcpy (p, tmp);
    }
  return printable_buf;
}