static char *
find_next_argument (startparen, endparen, ptr, end)
     char startparen;
     char endparen;
     const char *ptr;
     const char *end;
{
  int count = 0;

  for (; ptr < end; ++ptr)
    if (*ptr == startparen)
      ++count;

    else if (*ptr == endparen)
      {
	--count;
	if (count < 0)
	  return NULL;
      }

    else if (*ptr == ',' && !count)
      return (char *)ptr;

  /* We didn't find anything.  */
  return NULL;
}