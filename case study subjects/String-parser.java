int  Parser(int A[5]) {       
	
		    bool cascade;  bool inValue ;
			int i;
	        cascade = false;
			inValue = false;
		    i = 0;
			for (i = 0; i < 5; i++) {

				if ((A[i] == 92) && !cascade )
					
					cascade = !cascade;
				
				else if ((A[i] == 34) && !cascade)

				
				else if (A[i] == 44) 

				else 
				
				cascade = false;
	
			}
}