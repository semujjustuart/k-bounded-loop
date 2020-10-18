void SelectionSort ( int a[]  , int size ){
	int i , j ;
	for ( i =0; i < size -1; i ++){
		int min=i;
		for ( j = i +1; j < size ; j ++) {
			if ( a [ j ] < a [ min ]){
				min = j ;
		}
                           }
                                int tem = a [ i ];
		a[ i ] = a [ min ];
		a[ min ] = tem ;
	} 
}