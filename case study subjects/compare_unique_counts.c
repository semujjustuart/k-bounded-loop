void compare_unique_counts(int *counts, int *check_counts) {
	int i;
	for(i=0; i<ORDER; i++) {
		if (counts[i] == 0) assert(check_counts[i]==0);
		else assert(check_counts[i]==1);
	}
}