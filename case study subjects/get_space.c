static int
get_space (register int c)
{
  for (;;)
    {
      if (c == ' ')
	in_column++;
      else if (c == '\t')
	in_column = (in_column / TABWIDTH + 1) * TABWIDTH;
      else
	return c;
      c = GETC();
    }
}