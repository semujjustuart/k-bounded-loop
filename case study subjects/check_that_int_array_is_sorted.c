void check_that_int_array_is_sorted(int *a, int max) {
  int i;
  for(i=0; i<max-1; i++) {
	if (a[i]>a[i+1]) {
	  fprintf(stderr,"[ERROR] ARRAY UNSORTED AT INDEX %d !!!!!!!!!!!!!!!\n", i);
	  assert(0);
	}
  }
  return;
}