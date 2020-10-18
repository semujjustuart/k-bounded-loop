void gcf(double w, double y ){
	
	double a = w;
	double x = y;
	double gold = 0.0;
	double f = 0.0;
	double b1 = 1.0;
	double b0 = 0.0;
	double a0 = 1.0; 
	double a1  = x;
	double E = 3.0e-7;
	double g = 0.0;
	double ana = 0.0;
    int	n = 0;
    double anf = 0.0;
    double an = 0.0;
	
	while(n < 7)
		{
		 an = n;
		 ana = an - a;
		 a0 = (a1 + a0 * ana) * f;
		 b0 = (b1 + b0 * ana) * f;
		 anf = an * f;
		 b1 = x * b0 + anf * b1;
		 a1 = x * a0 + anf * a1;

		if ( a1 != 0.0 ){
				
			 g = b1 * (f = 1.0 / a1);

			 gold = g - gold;

			if ( abs( gold ) < E * abs(g) ){
			      
				  gold = g;
	
            }
		}
		n++;
	}
}