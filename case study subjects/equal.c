static int
equal(s1, s2)
     charclass s1;
     charclass s2;
{
  int i;

  for (i = 0; i < CHARCLASS_INTS; ++i)
    if (s1[i] != s2[i])
      return 0;
  return 1;
}