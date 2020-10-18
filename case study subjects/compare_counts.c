void compare_counts(int *counts, int *check_counts) {
	int i;
	for(i=0; i<ORDER; i++) {
		if (counts[i] != check_counts[i]) {
			fprintf(stderr,"[ERROR] DIFFERENT NUMBERS IN TEST STRUCTURE !!!!!!!!!!!!!!!\n");
			fprintf(stderr,"[ERROR] %d ", i);
			if (counts[i] > check_counts[i]) {
				fprintf(stderr,"IS MISSING\n");
			} else {
				fprintf(stderr,"APPEARED\n");
			}
			assert(0);
		}
	}
}