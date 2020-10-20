
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.Collections;

//import LoopDE.Loop_PathDE.MyCallable;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.util.Set;

//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;

/*Author Semujju Stuart Dereck*/
public class Mosa {
    
	private static  int RUN = 10; // the number of the program runs.
	//private static  double F = 0.5;
	private static final int bias = 10;
	private static final int pop_num = 50; // the number of test cases
	///private static final int fun_num = 1; // the serial number of the target benchmark function.
	private static final int R = 14;
	private static final int NODENUM = 3; // the number of the nodes/vertex in the target benchmark function.
    private static final int col = 0;
	//private static  double Pc = 0.2;
	//private static  double non_simpleid = 99.0; // prefix  given to test case not traversing a path in the group
	//private static  double non_simpleid2 = 100.0;// prefix given to test case traversing a path in the group
	private static  int PATHNUM =  2187; // In this test bench mark there are 16 groups each with 32 paths
	//private static int objective_size = 0; 
	//private static final int TOTAL_PATHNUM = 2187;
	 
	private static int tournamentSize = 10;
	static int cross_counter = 0;

	// ************************************ strings to capture simple loop paths and
	// to capture non-simple loop
	// paths**************************************************//
	static LinkedHashMap<String, Boolean> temporary_path_holder = new LinkedHashMap<String, Boolean>();
	static LinkedHashMap<String, Integer> pathcounter = new LinkedHashMap<String, Integer>();
	static LinkedHashMap<String, Boolean> evaluated_status = new LinkedHashMap<String, Boolean>();
	//public static Map<String, int[][]> dynamic_access = new HashMap<String, int[][]>();


	// ****************************************************************************************************************************************************************//

	static int[][] dynamic16;

	static int que = 1;

	static int[] Cycle = new int[RUN];
	static float[] coverage = new float[RUN];
	static double[] runtime = new double[RUN];
	//static int[] case_num = new int[RUN];
	
	static int[] total_case_num = new int[RUN];

	static File allpaths = new File("C:/Users/scybe/eclipse-workspace/Bench/All.txt");
	static LinkedHashMap<String, Boolean> paths = new LinkedHashMap<String, Boolean>();

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		// TODO Auto-generated method stub

		// System.out.println("what");
		int k = 7;

		char[] set = { 'a', 'b', 'c' };
		char[] str = new char[k];

		enumeratePaths(k, set, str, 0); // call function to generate the paths
		init_Template();// function to create the groups of paths. // using the simple loop path pattern
						// information


		int[] lb = new int[R];// lower bound
		int[] ub = new int[R];// upper bound

		for (int j = 0; j < R; j++) { // the sample range of integers is between 1 and 100
			lb[j] = 1; // lower bound
			ub[j] = 1000; // upper bound

		}

		for (int run = 0; run < RUN; run++) {

			int[][] x = new int[pop_num][R];
			int[][] v = new int[pop_num][R];
			
		//	int[][] temporal = new int[pop_num][R];
			
			
			int crossover_count = 0;
            boolean  statusChecker =false;
			LinkedHashMap<String, List<Double>> parent_maps = new LinkedHashMap<String, List<Double>>();
			
			LinkedHashMap<String, List<Double>> offspring_maps = new LinkedHashMap<String, List<Double>>();
			
			//LinkedHashMap<String, List<Double>> parent_maps_init = new LinkedHashMap<String, List<Double>>();
			
			//LinkedHashMap<String, List<Double>> offspring_pop = new LinkedHashMap<String, List<Double>>();
			
			//LinkedHashMap<String, List<Double>> child_maps = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> combined_maps = new LinkedHashMap<String, List<Double>>();
		//	LinkedHashMap<String, List<Double>> fitnessmaps = new LinkedHashMap<String, List<Double>>();

			LinkedHashMap<String, Integer> setrank1 = new LinkedHashMap<String, Integer>();
		//	LinkedHashMap<String, Integer> setrank2 = new LinkedHashMap<String, Integer>();

		//	LinkedHashMap<String, Integer> setrank3 = new LinkedHashMap<String, Integer>();

			List<String> updated_population = new ArrayList<String>();
			
			List<String> combined_population = new ArrayList<String>();
			List<String> offspring_population = new ArrayList<String>();
			//List<String> parent_population = new ArrayList<String>();
			List<String> single_population = new ArrayList<String>();

			List<String> combined_population_list = new ArrayList<String>();
			
			
			
			List<String> parents_population   = new ArrayList<String>();
			
			List<String> parents_population_copy   = new ArrayList<String>();
			
		//	String traverse_template;

			// the 2d arrays below hold the solutions to each respective group
			int [][] solution = new  int[PATHNUM][R];
				
				
			boolean [] statu = new boolean [PATHNUM];
				

			int totalpathcounter = 0;

			int obj_total = 0;

			String getfinalpath = null;
			//String final_path_checker;

			if (run > 0) { // in each run reset the number counter of the paths covered in each group

				reset_All();
				
				updated_population.clear();
				combined_population.clear();
				offspring_population.clear();
				single_population.clear();
				offspring_maps.clear();
				setrank1.clear();
				//setrank2.clear();
				//offspring_maps.clear();
				parents_population_copy.clear();
				combined_maps.clear();
				parent_maps.clear();

			}

			for (int i = 0; i < pop_num; i++) // initialize the population with the dimension of R values/inputs
			{

				for (int j = 0; j < R; j++) {
				
					x[i][j]  = (int)(Math.random()*((ub[j]  - lb[j])+1))+ lb[j];

				}

				 // here we start to count the test case

				// call benchmark function and find out if the path is traversed or not
				// e.g this benchmark as two simple loop paths encoded as 0 and 1.
				// Since there are nine iterations we can have any possible sequence appearing 9
				// times

				getfinalpath = pathnum(x[i]); // get path traversed by input x is returned

              //get path in the uncovered paths list that matches the path traversed by the test case
				
			//	obj_total = 
				
				try {
					File fstream_temporary = new File("C:/Users/scybe/eclipse-workspace/Bench/All.txt");
					FileReader fileReader_ = new FileReader(fstream_temporary);
					BufferedReader br_ = new BufferedReader(fileReader_);
					String strLine_temporary;
					 int counter1 = -1;
					
					while ((strLine_temporary = br_.readLine()) != null) {
						counter1++;
						
						if (strLine_temporary.equals(getfinalpath)) {

							if (paths.get(strLine_temporary)) {
								break;
							}
							else {
								
								paths.put(strLine_temporary, true);
								
								
								if (!statu[counter1]) {
									// array template_1path_id

									for (int s = 0; s < R; s++) {

										solution[counter1][s] = x[i][s];

									}
									statu[counter1] = true; // ���·��Path�Ƿ����ҵ�������������
									 obj_total++;
							
									break;
								}
							}
								
						}
					}
					br_.close();
				} catch (Exception e) {
				}

				
				 parents_population.add("parent" + " " + i);
			}

			parents_population_copy.addAll(parents_population);
			
	
			Cycle[run] = 1;

				long start_time = System.currentTimeMillis();
				long wait_time = 1518750;
				long end_time = start_time + wait_time;
				List<Double> temp_2 = new ArrayList<Double>();
				
				while ((System.currentTimeMillis() < end_time) && obj_total < PATHNUM) // not exceeded the set

				{
				//LinkedHashMap<String, List<Double>> parent_maps_init = new LinkedHashMap<String, List<Double>>();   
				//initial random population tournament selection
			
					//List<Double> temp = new ArrayList<Double>();
					if (crossover_count == 0) {
					Random       random    = new Random();
			
					LinkedHashMap<String, Boolean> changed_status = new LinkedHashMap<String, Boolean>();
					LinkedHashMap<String, Boolean> child_status   = new LinkedHashMap<String, Boolean>();
					
					for (int i = 0; i < 25; i++) {
				
						String randomKey_1 =   parents_population.get( random.nextInt(parents_population.size())) ;
						
						parents_population.remove(randomKey_1);
						
						String randomKey_2 =   parents_population.get( random.nextInt(parents_population.size())) ;
						
						parents_population.remove(randomKey_2);
						//access parent via parent_maps_init
						
						//split the string
						
						String [] parent_1_string = randomKey_1.split(" ");	
						
						
						String par_1;

						int pos_1;
						
						
						par_1 = parent_1_string[0];
						pos_1 = Integer.parseInt(parent_1_string[1]);
						
                     //  String [] parent_2_string = randomKey_2.split(" ");	
						
						
						String par_2;

						int pos_2;
						
						
						par_2 = parent_1_string[0];
						pos_2 = Integer.parseInt(parent_1_string[1]);
						
					
						//crossover nbased on probability
						Random rand = new Random();
						double rdm  = rand.nextDouble();		   
						    
						 if(rdm < 0.75) {
						
							//single-point crossover
						    	
						    	//randomly find a position nad exchange the tails
							 
							int parent_1_random = rand.nextInt(R);
						    	
						    int new_point = parent_1_random; 
						    //exchange elements with parent_2
						    
						    //	int[][] temporal = new int[pop_num][R];
						  
						    for (int j = 0 ; j < R; j++) {
					    		
					    		
						    	v[pos_1][j] =  x[pos_1][j];
						    	v[pos_2][j] =  x[pos_2][j];
					    		
					    	}
					    	
						    for (int g = new_point ; new_point  < R; new_point++) {
					    		
					    		
					    		//switch the tails of parent one and parent two
						    	v[pos_1][g] =   x[pos_2][g];
						    	v[pos_2][g] =   x[pos_1][g];

					    	
					    	}
						    
						    child_status.put("child" + " " + pos_1 , true);
				    		child_status.put("child" + " " + pos_2 , true);
				    		  
							//changed_status.put("parent" + " " + pos_1 , false);
				    	  //  changed_status.put("parent" + " " + pos_2 , false);
						   
						 
				    	    Random mut = new Random();
							double mutate  = mut.nextDouble();
						    
							 if(mutate < (1/R)) {   
								 
								
								    int child_1  = (int) (Math.random() * R);
						        	
						        	int child_2  = (int) (Math.random() * R);
						        	
						        	
						        	v[pos_1][child_1] =   (int)(Math.random()*((ub[child_1]  - lb[child_1])+1))+ lb[child_1];
						        	
						        
						        	
						        	offspring_population.add("child" + " " + pos_1);
						        	
						        	v[pos_2][child_2] =   (int)(Math.random()*((ub[child_2]  - lb[child_2])+1))+ lb[child_2]; 
						        	
						        	offspring_population.add("child" + " " + pos_2);
						        	
						     
							 }
						 
							 else {
								 
								 
								 offspring_population.add("child" + " " + pos_1);
								 
								 offspring_population.add("child" + " " + pos_2);
								 
							 }
						 
						 }
						    
						    
						else {
						    	
					    		for (int j = 0 ; j < R; j++) {
						    		
						    		
						    		v[pos_1][j] =  x[pos_1][j];
						    		v[pos_2][j] =  x[pos_2][j];
						    		
						    	}
					    		
					    		
					    		//mutate
					    		

					    	    Random mut = new Random();
								double mutate  = mut.nextDouble();
							    
								 if(mutate < (1/R)) {   
									 
									
									    int child_1  = (int) (Math.random() * R);
							        	
							        	int child_2  = (int) (Math.random() * R);
							        	
							        	
							        	v[pos_1][child_1] =   (int)(Math.random()*((ub[child_1]  - lb[child_1])+1))+ lb[child_1];
							        	
							        
							        	
							        	offspring_population.add("child" + " " + pos_1);
							        	
							        	v[pos_2][child_2] =   (int)(Math.random()*((ub[child_2]  - lb[child_2])+1))+ lb[child_2]; 
							        	
							        	offspring_population.add("child" + " " + pos_2);
							        	
							     
								 }
							 
								 else {
								
									 
								 }
					    		
						    }
						
						
                           //mutation  (1/size of test case input vector)
	
					}
					//get path traversed by offsprings
				   
					
					for (int i = 0; i <  offspring_population.size(); i++) {// initialize the population with the dimension of R values/inputs
				
				    String [] get_index = offspring_population.get(i).split("");	
						
				    String off_1;

					int index_1;
					
					
					off_1 = get_index[0];
					index_1 = Integer.parseInt(get_index[1]);	
					
					getfinalpath = pathnum(v[index_1]);
					
				    //match the paths traversed
					try {
						File fstream_temporary = new File("C:/Users/scybe/eclipse-workspace/Bench/All.txt");
						FileReader fileReader_ = new FileReader(fstream_temporary);
						BufferedReader br_ = new BufferedReader(fileReader_);
						String strLine_temporary;
						 int counter1 = -1;
						
						while ((strLine_temporary = br_.readLine()) != null) {
							counter1++;
							
							if (strLine_temporary.equals(getfinalpath)) {

								if (paths.get(strLine_temporary)) {
									break;
								}
								else {
									
									paths.put(strLine_temporary, true);
									
									
									if (!statu[counter1]) {
										// array template_1path_id

										for (int s = 0; s < R; s++) {

											solution[counter1][s] = v[index_1][s];

										}
										statu[counter1] = true; // ���·��Path�Ƿ����ҵ�������������
										 obj_total++;
										// pathcounter.put("1101", pathcounter.get("1101") + 1);
										//totalpathcounter++;
										// get other nodes(not part of the simple loop pattern)

										break;
									}
								}
									
								
							//paths.put(strLine_temporary, false);
							}
						}
						br_.close();
					} catch (Exception e) {
					}
					
					
					}
					
					}
			  
					
				else {
					     //updated_population contains the sorted test cases  // run tournament selection in batches of 10
					   
					if ( statusChecker) {  //normal GA
						
						
						Random       random    = new Random();
						
						LinkedHashMap<String, Boolean> changed_status = new LinkedHashMap<String, Boolean>();
						LinkedHashMap<String, Boolean> child_status   = new LinkedHashMap<String, Boolean>();
						
						for (int i = 0; i < 25; i++) {
					
							String randomKey_1 =   parents_population.get( random.nextInt(parents_population.size())) ;
							
							parents_population.remove(randomKey_1);
							
							String randomKey_2 =   parents_population.get( random.nextInt(parents_population.size())) ;
							
							parents_population.remove(randomKey_2);
							//access parent via parent_maps_init
							
							//split the string
							
							String [] parent_1_string = randomKey_1.split(" ");	
							
							
							String par_1;

							int pos_1;
							
							
							par_1 = parent_1_string[0];
							pos_1 = Integer.parseInt(parent_1_string[1]);
							
	                     //  String [] parent_2_string = randomKey_2.split(" ");	
							
							
							String par_2;

							int pos_2;
							
							
							par_2 = parent_1_string[0];
							pos_2 = Integer.parseInt(parent_1_string[1]);
							
						
							//crossover nbased on probability
							Random rand = new Random();
							double rdm  = rand.nextDouble();		   
							    
							 if(rdm < 0.75) {
							
								//single-point crossover
							    	
							    	//randomly find a position nad exchange the tails
								 
								int parent_1_random = rand.nextInt(R);
							    	
							    int new_point = parent_1_random; 
							    //exchange elements with parent_2
							    
							    //	int[][] temporal = new int[pop_num][R];
							  
							    for (int j = 0 ; j < R; j++) {
						    		
						    		
							    	v[pos_1][j] =  x[pos_1][j];
							    	v[pos_2][j] =  x[pos_2][j];
						    		
						    	}
						    	
							    for (int g = new_point ; new_point  < R; new_point++) {
						    		
						    		
						    		//switch the tails of parent one and parent two
							    	v[pos_1][g] =   x[pos_2][g];
							    	v[pos_2][g] =   x[pos_1][g];

						    	
						    	}
							    
							    child_status.put("child" + " " + pos_1 , true);
					    		child_status.put("child" + " " + pos_2 , true);
					    		  
								//changed_status.put("parent" + " " + pos_1 , false);
					    	  //  changed_status.put("parent" + " " + pos_2 , false);
							   
							 
					    	    Random mut = new Random();
								double mutate  = mut.nextDouble();
							    
								 if(mutate < (1/R)) {   
									 
									
									    int child_1  = (int) (Math.random() * R);
							        	
							        	int child_2  = (int) (Math.random() * R);
							        	
							        	
							        	v[pos_1][child_1] =   (int)(Math.random()*((ub[child_1]  - lb[child_1])+1))+ lb[child_1];
							        	
							        
							        	
							        	offspring_population.add("child" + " " + pos_1);
							        	
							        	v[pos_2][child_2] =   (int)(Math.random()*((ub[child_2]  - lb[child_2])+1))+ lb[child_2]; 
							        	
							        	offspring_population.add("child" + " " + pos_2);
							        	
							     
								 }
							 
								 else {
									 
									 
									 offspring_population.add("child" + " " + pos_1);
									 
									 offspring_population.add("child" + " " + pos_2);
									 
								 }
							 
							 }
							    
							    
							else {
							    	
						    		for (int j = 0 ; j < R; j++) {
							    		
							    		
							    		v[pos_1][j] =  x[pos_1][j];
							    		v[pos_2][j] =  x[pos_2][j];
							    		
							    	}
						    		
						    		
						    		//mutate
						    		

						    	    Random mut = new Random();
									double mutate  = mut.nextDouble();
								    
									 if(mutate < (1/R)) {   
										 
										
										    int child_1  = (int) (Math.random() * R);
								        	
								        	int child_2  = (int) (Math.random() * R);
								        	
								        	
								        	v[pos_1][child_1] =   (int)(Math.random()*((ub[child_1]  - lb[child_1])+1))+ lb[child_1];
								        	
								        
								        	
								        	offspring_population.add("child" + " " + pos_1);
								        	
								        	v[pos_2][child_2] =   (int)(Math.random()*((ub[child_2]  - lb[child_2])+1))+ lb[child_2]; 
								        	
								        	offspring_population.add("child" + " " + pos_2);
								        	
								     
									 }
								 
									 else {
									
										 
									 }
						    		
							    }
							
							
	                           //mutation  (1/size of test case input vector)
		
						}
						//get path traversed by offsprings
					   
						
						for (int i = 0; i <  offspring_population.size(); i++) {// initialize the population with the dimension of R values/inputs
					
					    String [] get_index = offspring_population.get(i).split("");	
							
					    String off_1;

						int index_1;
						
						
						off_1 = get_index[0];
						index_1 = Integer.parseInt(get_index[1]);	
						
						getfinalpath = pathnum(v[index_1]);
						
					    //match the paths traversed
						try {
							File fstream_temporary = new File("C:/Users/scybe/eclipse-workspace/Bench/All.txt");
							FileReader fileReader_ = new FileReader(fstream_temporary);
							BufferedReader br_ = new BufferedReader(fileReader_);
							String strLine_temporary;
							 int counter1 = -1;
							
							while ((strLine_temporary = br_.readLine()) != null) {
								counter1++;
								
								if (strLine_temporary.equals(getfinalpath)) {

									if (paths.get(strLine_temporary)) {
										break;
									}
									else {
										
										paths.put(strLine_temporary, true);
										
										
										if (!statu[counter1]) {
											// array template_1path_id

											for (int s = 0; s < R; s++) {

												solution[counter1][s] = v[index_1][s];

											}
											statu[counter1] = true; // ���·��Path�Ƿ����ҵ�������������
											 obj_total++;
											// pathcounter.put("1101", pathcounter.get("1101") + 1);
											//totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
										
									
								//paths.put(strLine_temporary, false);
								}
							}
							br_.close();
						} catch (Exception e) {
						}
						
						
						}
						
						
					}
					
				    else { int d = 0;
					     
					     while  ( d < 5) {
					    //iteratively select ten elements from updated_population
					    	 
					                 List<String> batch_10_picker = new ArrayList<String>(); 
					                 batch_10_picker.addAll(updated_population.subList(0, tournamentSize));
					                 
					                 for (int i = 0; i  <  10 ; i++) {
					                	 
					                	 updated_population.remove(i);
					                	
					                 }
					                 
					                 
					    		     int r = 0;
					                 while  ( r < 5) {
					                 
					         		    List<String> pick_two = new ArrayList<String>();
					         		    
					         		     pick_two.addAll(batch_10_picker.subList(0, 2));  // pick first  two and cross them
					         		    
					         		     String parents_1   =    pick_two.get(0);
					         		     
					         		     String parents_2   =    pick_two.get(1);
					         		     
					         		    for (int i = 0; i <  pick_two.size(); i++) { 
					         		    	
					         		    	 batch_10_picker.remove(parents_1);
					         		    	 batch_10_picker.remove(parents_2);
					         		  
					         		    }
					         		     
					         		     
					         		   String [] parent_1_string = parents_1.split(" ");	
									
										String par_1;

										int pos_1;
										
										par_1 = parent_1_string[0];
										pos_1 = Integer.parseInt(parent_1_string[1]);
				                       String [] parent_2_string = parents_2.split(" ");	
										
										String par_2;

										int pos_2;
										
										par_2 = parent_1_string[0];
										pos_2 = Integer.parseInt(parent_1_string[1]);
                                       //crossover the two parents
					         		    
					         		    
										Random rand = new Random();
										double rdm  = rand.nextDouble();
										
									    Random  random    = new Random();
										
										//LinkedHashMap<String, Boolean> changed_status = new LinkedHashMap<String, Boolean>();
										LinkedHashMap<String, Boolean> child_status   = new LinkedHashMap<String, Boolean>();
										    
										 if(rdm < 0.75) {
										
											//single-point crossover
										    	
										    	//randomly find a position nad exchange the tails
											 
											int parent_1_random = rand.nextInt(R);
										    	
										    int new_point = parent_1_random; 
										    //exchange elements with parent_2
										    
										    //	int[][] temporal = new int[pop_num][R];
										  
										    
											 
										    for (int j = 0 ; j < R; j++) {
									    		
									    		
										    	v[pos_1][j] =  x[pos_1][j];
										    	v[pos_2][j] =  x[pos_2][j];
									    		
									    	}
									    	
										    for (int g = new_point ; new_point  < R; new_point++) {
									    		
									    		
									    		//switch the tails of parent one and parent two
										    	v[pos_1][g] =   x[pos_2][g];
										    	v[pos_2][g] =   x[pos_1][g];

									    	
									    	}
										    
										    child_status.put("child" + " " + pos_1 , true);
								    		child_status.put("child" + " " + pos_2 , true);
								    		  
											//changed_status.put("parent" + " " + pos_1 , false);
								    	  //  changed_status.put("parent" + " " + pos_2 , false);
										   
										 
								    	    Random mut = new Random();
											double mutate  = mut.nextDouble();
										    
											 if(mutate < (1/R)) {   
												 
												
												    int child_1  = (int) (Math.random() * R);
										        	
										        	int child_2  = (int) (Math.random() * R);
										        	
										        	
										        	v[pos_1][child_1] =   (int)(Math.random()*((ub[child_1]  - lb[child_1])+1))+ lb[child_1];
										        	
										        	offspring_population.add("child" + " " + pos_1);
										        	
										        	v[pos_2][child_2] =   (int)(Math.random()*((ub[child_2]  - lb[child_2])+1))+ lb[child_2]; 
										        	
										        	offspring_population.add("child" + " " + pos_2);
										        	
											 }
										 
											 else {
												 
												 
												 offspring_population.add("child" + " " + pos_1);
												 
												 offspring_population.add("child" + " " + pos_2);
												 
											 }
										 
										 
										 
										 }
										    
										    
										else {
										    	
										  
									    		for (int j = 0 ; j < R; j++) {
										    		
										    		
										    		v[pos_1][j] =  x[pos_1][j];
										    		v[pos_2][j] =  x[pos_2][j];
										    		
										    	}
									    		
									    		
									    		//mutate
									    		

									    	    Random mut = new Random();
												double mutate  = mut.nextDouble();
											    
												 if(mutate < (1/R)) {   
													 
													
													    int child_1  = (int) (Math.random() * R);
											        	
											        	int child_2  = (int) (Math.random() * R);
											        	
											        	
											        	v[pos_1][child_1] =   (int)(Math.random()*((ub[child_1]  - lb[child_1])+1))+ lb[child_1];
											        	
											        
											        	
											        	offspring_population.add("child" + " " + pos_1);
											        	
											        	v[pos_2][child_2] =   (int)(Math.random()*((ub[child_2]  - lb[child_2])+1))+ lb[child_2]; 
											        	
											        	offspring_population.add("child" + " " + pos_2);
											        	
											     
												 }
											 
												// else {
												 
													 
												// }
									    		
										    }
										
										
					         		     r++;
					                 }
					                 
					    	 d++;
					     }
				}
					   
						
						for (int i = 0; i <  offspring_population.size(); i++) {// initialize the population with the dimension of R values/inputs
					
					    String [] get_index = offspring_population.get(i).split("");	
							
					    String off_1;

						int index_1;
						
						
						off_1 = get_index[0];
						index_1 = Integer.parseInt(get_index[1]);	
							
					    
					    
						getfinalpath = pathnum(v[index_1]);
						
					    //match the paths traversed
						try {
							File fstream_temporary = new File("C:/Users/scybe/eclipse-workspace/Bench/All.txt");
							FileReader fileReader_ = new FileReader(fstream_temporary);
							BufferedReader br_ = new BufferedReader(fileReader_);
							String strLine_temporary;
							 int counter1 = -1;
							
							while ((strLine_temporary = br_.readLine()) != null) {
								counter1++;
								
								if (strLine_temporary.equals(getfinalpath)) {

									if (paths.get(strLine_temporary)) {
										break;
									}
									else {
										
										paths.put(strLine_temporary, true);
										
										
										if (!statu[counter1]) {
											// array template_1path_id

											for (int s = 0; s < R; s++) {

												solution[counter1][s] = v[index_1][s];

											}
											statu[counter1] = true; // ���·��Path�Ƿ����ҵ�������������
											 obj_total++;
											
											break;
										}
									}
										
									
								//paths.put(strLine_temporary, false);
								}
							}
							br_.close();
						} catch (Exception e) {
						}
						
						
						}
					
				}
					
					crossover_count++;
					combined_population_list.addAll(parents_population_copy);
					
					
					for (int i = 0; i < offspring_population.size(); i++) // initialize the population with the dimension of R values/inputs
					{
			
							combined_population_list.add(offspring_population.get(i));
				    }
						
					List<String> final_combined_population = new ArrayList<String>();

					// temp.clear();

					final_combined_population.addAll(combined_population_list);	
				
				//evaluate parent and child population
					
					for (int i = 0; i < final_combined_population.size(); i++) // initialize the population with the dimension of R values/inputs
					{
					
						
                      String checkString = final_combined_population.get(i);	
                      
                      String [] getType = checkString.split(" ");
                      
						
						String typeName  =   getType[0];

						int typeId  =  Integer.parseInt(getType[1]);
						
						
						List<Double> offspring_fitness = new ArrayList<Double>();
						
						if (typeName.equals("parent")) {

					     	offspring_fitness = benchmarkfunction(x[typeId]);
					     	
					     	
					     	List<Double> offspring_fitness_ = new ArrayList<Double>();
							// fitness_objectives_updated.clear();

							for (int copu = 0; copu < offspring_fitness.size(); copu++) {

								offspring_fitness_.add(offspring_fitness.get(copu));
							}

							//List<Double> temp_2 = new ArrayList<Double>();

							// temp.clear();

							temp_2.addAll(offspring_fitness_);

							
							//offspring_maps.put("child" + " " + i, temp_2);
							
							parent_maps.put(checkString, temp_2);
					     
						}
						
						else {
							
							offspring_fitness = benchmarkfunction(v[typeId]);
							
							
							List<Double> offspring_fitness_ = new ArrayList<Double>();
							// fitness_objectives_updated.clear();

							for (int copu = 0; copu < offspring_fitness.size(); copu++) {

								offspring_fitness_.add(offspring_fitness.get(copu));
							}

							// temp.clear();

							temp_2.addAll(offspring_fitness_);

							
							//offspring_maps.put("child" + " " + i, temp_2);
							
							offspring_maps.put(checkString, temp_2);
							
						}
						
					
					}
					
				
					combined_maps.putAll(parent_maps);
				
					LinkedHashMap<String, List<Double>> tmp = new LinkedHashMap<String, List<Double>>(offspring_maps);
				//	LinkedHashMap tmp = new LinkedHashMap(offspring_maps);
					tmp.keySet().removeAll(combined_maps.keySet());
					combined_maps.putAll(tmp);   // all parents and children in this map alongside with their fitness values
					
				//pairs of test cases --parents are selected using tournamentSize according to their non-dominance ranks .
					
					try {
						if ((obj_total) == PATHNUM) {  // if all paths covered break out of while loop
						
							break;
						}
						
				if ((obj_total) < PATHNUM) { // if not all paths covered perform
							
				  if ((PATHNUM - (obj_total) == 1)) { 
								
								// if only one path is left...standard GA should be followed
					  
					  for ( String key : combined_maps.keySet() ) {
					 		
					 	     updated_population.add(key);
					 		 
						   // System.out.println( key );
						}
							
					     statusChecker = true;
				}//if only one uncovered path
							
					if ((PATHNUM - (obj_total) > 1)) { //if many remaining uncovered paths
						
						
							int cols = temp_2.size();

							int column_size = (cols);
							
							//final_combined_population
							
							List<String> population_set = new ArrayList<String>();
							
						 	for ( String key : combined_maps.keySet() ) {
						 		
						 		population_set.add(key);
						 		
							   // System.out.println( key );
							}
							
						 	List<String> combined_population_set = new ArrayList<String>();
						 	
						 	combined_population_set.addAll(population_set);
						 	

							Double[][] offspring_fitness_full = new Double[combined_population_set
									.size()][column_size];   // n x m matrix of combined parents and offspring test cases
							
							int updates = 0;

							// List<String> traverse_group = new ArrayList<String>();
							
							//List<String> best_column = new ArrayList<String>();
							int fitss = 0;
							
							while (updates < combined_population_set.size()) {

								List<Double> fitness_objectives_updated = new ArrayList<Double>();
								// fitness_objectives_updated.clear();

								fitness_objectives_updated = (combined_maps.get(combined_population_set.get(updates)));
								

								List<Double> temp_3 = new ArrayList<Double>();

								// temp.clear();

								temp_3.addAll(fitness_objectives_updated);

								
								for (int ups = 0; ups < temp_3.size(); ups++) {

									offspring_fitness_full[updates][ups] = fitness_objectives_updated.get(ups);

								}
								fitness_objectives_updated.clear();
								updates++;

							}
							
					
							List<String> best_column = new ArrayList<String>();
				
							int sizes = temp_2.size();

							//double row_fit;
							int colums = 0;
							String test_case;
							double fit_rowfit;
					
							LinkedHashMap<String, Double> row_getter = new LinkedHashMap<String, Double>();
							
							while (colums < sizes) {

								for (int get_row = 0; get_row < (combined_population_set.size()); get_row++) {

									fit_rowfit = (offspring_fitness_full[get_row][colums]);

									double row_fitter = fit_rowfit;

									row_getter.put(combined_population_set.get(get_row), row_fitter);

								}

								Map<String, Double> result = row_getter.entrySet().stream()   //get test case with minimum objective score for each objective
										.sorted(Map.Entry.comparingByValue())
										.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
												(oldValue, newValue) -> oldValue, LinkedHashMap::new));
								// System.out.println("Map yino" +result );

								Iterator<Map.Entry<String, Double>> best_col = result.entrySet().iterator();

								while (best_col.hasNext()) {

									Map.Entry<String, Double> entry = best_col.next();

									test_case = entry.getKey();

									if (!best_column.contains(test_case)) {

										best_column.add(test_case);

										break;
									}

								}

								result.clear();
								row_getter.clear();
								colums++;

							}
                            
							//Go straight to computing crowding distance for Font 0
							
							int distance_zero;

							/************************************************************************************************************************************************************/

							double[][] distance_matrix_zero = new double[best_column.size()][best_column.size()];

							if ((best_column.size()) > 1) {

								for (int best = 0; best < (best_column.size()); best++) {

									List<Double> front_0_1 = new ArrayList<Double>();

									front_0_1 = combined_maps.get(best_column.get(best));

									for (int ind_d = 0; ind_d < best_column.size(); ind_d++) {

										if (!((best_column.get(best).equals(best_column.get(ind_d))))) {

											List<Double> front_0_2 = new ArrayList<Double>();

											front_0_2 = combined_maps.get(best_column.get(ind_d));

											distance_zero = get_count(front_0_1, front_0_2);

											int temp_dis = distance_zero;

											distance_matrix_zero[best][ind_d] = temp_dis;

										}

									}

								}

								LinkedHashMap<String, Double> setdistance_zero_2 = new LinkedHashMap<String, Double>();

								for (int font_ = 0; font_ < best_column.size(); font_++) {

									double zeros = 0.0;

									setdistance_zero_2.put(best_column.get(font_), zeros);

								}

								for (int font_i = 0; font_i < (best_column.size()); font_i++) {

									for (int font_j = 0; font_j < best_column.size(); font_j++) {

										if (!((best_column.get(font_i).equals(best_column.get(font_j))))) {

											if (setdistance_zero_2.get(best_column
													.get(font_i)) < distance_matrix_zero[font_i][font_j]) {

												double dis = (distance_matrix_zero[font_i][font_j]);

												setdistance_zero_2.put(best_column.get(font_i), dis);

											}
										}
									}

								}

								Map<String, Double> result = setdistance_zero_2.entrySet().stream()
										.sorted(Map.Entry.comparingByValue())
										.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
												(oldValue, newValue) -> oldValue, LinkedHashMap::new));
								
								for (Map.Entry<String, Double> entry : result.entrySet()) {

									if (updated_population.size() < pop_num) {
										updated_population.add(entry.getKey());
									}

									else {

										break;
									}

								}

								result.clear();

							}
							
							
							//updated population has best performing test cases sorted in descending order
							
							else { // process the only item in the best set

								if (!best_column.isEmpty()) {

									String item_one = best_column.get(0);

									if (updated_population.size() < pop_num) {

										updated_population.add(item_one);
									}

								}
							}

							//Establish other fonts
							
							List<String> fitness_objectives_comparator = new ArrayList<String>();
							// List<Double> fitness_objectives_p = new ArrayList<Double>();
							// List<Double> fitness_objectives_q= new ArrayList<Double>();

							for (int next_front = 0; next_front < offspring_population.size(); next_front++) {

								if (!best_column.contains(offspring_population.get(next_front))) {

									fitness_objectives_comparator.add(offspring_population.get(next_front));
								}
							}

							if ((fitness_objectives_comparator.size()) > 1) {

								int[] dominateMe = new int[fitness_objectives_comparator.size()];

								// front[i] contains the list of individuals belonging to the front i
								@SuppressWarnings("unchecked")
								List<Integer>[] front = new List[(fitness_objectives_comparator.size() + 1)];

								// iDominate[k] contains the list of solutions dominated by k

								@SuppressWarnings("unchecked")
								List<Integer>[] iDominate = new List[fitness_objectives_comparator.size()];

								int flagDominate;

								for (int i = 0; i < ((front.length)); i++) {
									front[i] = new LinkedList<Integer>();
								}

								for (int p = 0; p < fitness_objectives_comparator.size(); p++) {
									// Initialize the list of individuals that i dominate and the number
									// of individuals that dominate me
									iDominate[p] = new LinkedList<Integer>();
									dominateMe[p] = 0;
								}

								// int secondary_size =0 ;
								int N = fitness_objectives_comparator.size();
								// int[][] dominanceChecks = new int[N][N];

								for (int p = 0; p < (N - 1); p++) {

									List<Double> fitness_temporary_p = new ArrayList<Double>();

									fitness_temporary_p = combined_maps.get((fitness_objectives_comparator.get(p)));

									// secondary_size = fitness_temporary_p.size();

									for (int q = p + 1; q < N; q++) {
										// if (p != q) {
										List<Double> fitness_temporary_q = new ArrayList<Double>();

										fitness_temporary_q = combined_maps
												.get((fitness_objectives_comparator.get(q)));

										flagDominate = frontdominace_Comparison(fitness_temporary_p,
												fitness_temporary_q);

										if (flagDominate == -1) {
											// System.out.println("p---dominates>>>>>" );
											iDominate[p].add(q);
											dominateMe[q]++;

										}

										else if (flagDominate == 1) {
											// System.out.println("q---dominates>>>>>" );
											iDominate[q].add(p);
											dominateMe[p]++;
										}

										else {

											List<Double> fitness_temporary_qq = new ArrayList<Double>();
											List<Double> fitness_temporary_pp = new ArrayList<Double>();

											Collections.sort(fitness_temporary_p);

											fitness_temporary_pp.addAll(fitness_temporary_p);

											Collections.sort(fitness_temporary_q);

											fitness_temporary_qq.addAll(fitness_temporary_q);

											if (fitness_temporary_pp.get(0) < fitness_temporary_qq.get(0)) {
												// System.out.println("p---dominates>>>>>" );
												iDominate[p].add(q);
												dominateMe[q]++;

											}

											else if (fitness_temporary_qq.get(0) < fitness_temporary_pp.get(0)) {
												// System.out.println("q---dominates>>>>>" );
												iDominate[q].add(p);
												dominateMe[p]++;
											}

										}

									}
								}

								for (int p = 0; p < ((fitness_objectives_comparator.size())); p++) {

									if (dominateMe[p] == 0) {
										front[0].add(p);

										// setrank.put(Integer.parseInt(fitness_objectives_comparator.get(p)), 1);
										int val = 0;
										setrank1.put(fitness_objectives_comparator.get(p), val);

									}
								}

/*****************************************************************************************************************************************************************************************/

								int font_s = 0;
								// if((front[font_s].size() != 0)) {

								Iterator<Integer> it1, it2; // Iterators
								while (front[font_s].size() != 0) {
									/// System.out.println("we got here" + front[font_s]);
									font_s++;
									it1 = front[font_s - 1].iterator();
									while (it1.hasNext()) {
										it2 = iDominate[(it1.next())].iterator();
										while (it2.hasNext()) {
											int index = it2.next();
											dominateMe[index]--;
											if (dominateMe[index] == 0) {
												front[font_s].add(index);
												// System.out.println("Block_1: " +front[font_s]);
												setrank1.put(fitness_objectives_comparator.get(index), font_s);
											}
										}

									}

								}

								LinkedHashMap<String, Double> setdistance = new LinkedHashMap<String, Double>();

								LinkedHashMap<String, Double> setdistance_one = new LinkedHashMap<String, Double>();

								Map<Integer, ArrayList<String>> reverseMap = new HashMap<>();

								for (Map.Entry<String, Integer> entry : setrank1.entrySet()) {
									if (!reverseMap.containsKey(entry.getValue())) {
										reverseMap.put(entry.getValue(), new ArrayList<>());
									}
									ArrayList<String> keys = reverseMap.get(entry.getValue());
									keys.add(entry.getKey());
									reverseMap.put(entry.getValue(), keys);
								}

								// process fonts

								int smaller;
								int smaller_one;
							//	int remaining;
								// int smaller_two;

								int fronts = 0;
								// System.out.println("map's size" + reverseMap.size());
								while (fronts < (reverseMap.size())) {

									// if (updated_population.size()== pop_num) {
									// break;
									// }

									if (fronts != (reverseMap.size() - 1)) {

										List<String> front_list = new ArrayList<String>();

										front_list = reverseMap.get(fronts);

										if ((front_list.size()) > 1) {

											double[][] distance_matrix = new double[front_list.size()][front_list
													.size()];

											for (int ind_d = 0; ind_d < (front_list.size()); ind_d++) {

												List<Double> front_getter1 = new ArrayList<Double>();

												front_getter1 = combined_maps.get((front_list.get(ind_d)));

												for (int d = 0; d < front_list.size(); d++) {

													if (!(front_list.get(ind_d).equals(front_list.get(d)))) {

														List<Double> front_getter2 = new ArrayList<Double>();

														front_getter2 = combined_maps.get((front_list.get(d)));

														smaller = get_count(front_getter1, front_getter2);

														int sma = smaller;

														distance_matrix[ind_d][d] = sma;

													}

												}

											}

											for (int font_ = 0; font_ < front_list.size(); font_++) {

												double valz = 0.0;

												setdistance.put(front_list.get(font_), valz);

											}

											// all distances set

											for (int font_i = 0; font_i < (front_list.size()); font_i++) {

												// distance_matrix

												for (int font_j = 0; font_j < front_list.size(); font_j++) {

													if (!(front_list.get(font_i).equals(front_list.get(font_j)))) {

														if (setdistance.get(front_list
																.get(font_i)) < distance_matrix[font_i][font_j]) {

															double dist = (distance_matrix[font_i][font_j]);

															setdistance.put(front_list.get(font_i), dist);

														}
													}
												}

											}

											Map<String, Double> result = setdistance.entrySet().stream()
													.sorted(Map.Entry.comparingByValue())
													.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
															(oldValue, newValue) -> oldValue, LinkedHashMap::new));

											Iterator<Map.Entry<String, Double>> iteration = result.entrySet()
													.iterator();

											while (iteration.hasNext()) {

												Map.Entry<String, Double> entry = iteration.next();

												if (updated_population.size() < pop_num) {
													updated_population.add(entry.getKey());
												}

												else {

													break;
												}

											}

											result.clear();

										}

										else {

											String best_1;

											best_1 = front_list.get(0);

											if (updated_population.size() < (pop_num)) {

												updated_population.add(best_1);

											}

										}
									}

									if (fronts == (reverseMap.size() - 1)) {

										List<String> front_list_one = new ArrayList<String>();

										front_list_one = reverseMap.get(reverseMap.size() - 1);

										// System.out.println("hahahq" +front_list_one);

										double[][] distance_matrix_one = new double[front_list_one
												.size()][front_list_one.size()];

										for (int ind_w = 0; ind_w < (front_list_one.size()); ind_w++) {

											List<Double> front_getter_one = new ArrayList<Double>();

											front_getter_one = combined_maps.get((front_list_one.get(ind_w)));

											for (int dw = 0; dw < front_list_one.size(); dw++) {

												if (!(front_list_one.get(ind_w).equals(front_list_one.get(dw)))) {

													List<Double> front_getter_two = new ArrayList<Double>();

													front_getter_two = combined_maps.get((front_list_one.get(dw)));

													smaller_one = get_count(front_getter_one, front_getter_two);

													int sm = smaller_one;

													distance_matrix_one[ind_w][dw] = sm;

												}

											}
										}
										for (int font_ = 0; font_ < front_list_one.size(); font_++) {

											double dit = 0.0;

											setdistance_one.put(front_list_one.get(font_), dit);

										}

										// all distances set

										for (int font_i = 0; font_i < (front_list_one.size()); font_i++) {

											for (int font_j = 0; font_j < front_list_one.size(); font_j++) {

												if (!(front_list_one.get(font_i)
														.equals(front_list_one.get(font_j)))) {

													if (setdistance_one.get(front_list_one
															.get(font_i)) < distance_matrix_one[font_i][font_j]) {

														double dst = (distance_matrix_one[font_i][font_j]);

														setdistance_one.put(front_list_one.get(font_i), dst);

													}
												}
											}

										}

										int remaining_ = (pop_num - updated_population.size());

										if (setdistance_one.size() <= remaining_) {

											Map<String, Double> result = setdistance_one.entrySet().stream()
													.sorted(Map.Entry.comparingByValue())
													.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
															(oldValue, newValue) -> oldValue, LinkedHashMap::new));

											Iterator<Map.Entry<String, Double>> iteration = result.entrySet()
													.iterator();

											while (iteration.hasNext()) {

												Map.Entry<String, Double> entry = iteration.next();

												if (updated_population.size() < pop_num) {
													updated_population.add(entry.getKey());
												}

												else {
													break;
												}

											}

										}

										// System.out.println( "remaining---" +remaining);
										else {

											Map<String, Double> sortedByValueDesc = setdistance_one.entrySet()
													.stream()
													.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
													.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
															(e1, e2) -> e1, LinkedHashMap::new));

											List<String> front_remove = new ArrayList<String>();

											Set<String> keytest = sortedByValueDesc.keySet();

											int final_size = sortedByValueDesc.size();

											// while(sortedByValueDesc.size() > remaining) {

											for (String keysss : keytest) {

												if (final_size > remaining_) {

													front_remove.add(keysss);
												}

												else {

													break;
												}
												final_size--;
											}

											// System.out.println( "sorted map after---" +sortedByValueDesc.size());
											Set<String> keytests = sortedByValueDesc.keySet();

											for (String key_sss : keytests) {

												if (updated_population.size() < pop_num) {

													if (!front_remove.contains(key_sss)) {

														updated_population.add(key_sss);
													}

												} else {
													break;
												}
											}

										}

									}

									setdistance.clear();
									setdistance_one.clear();

									fronts++;
								}

							} else {

								if (!fitness_objectives_comparator.isEmpty()) {

									if (updated_population.size() < pop_num) {

										String get_item = (fitness_objectives_comparator.get(0));

										updated_population.add(get_item);

									}

								}

							}

							
					}
							
							
							
							
						}
						
					     	
					}

						catch(IndexOutOfBoundsException e) {}

							//updated_population.clear();
							combined_population.clear();
							//combined_population2.clear();
							setrank1.clear();
							//setrank2.clear();
							//setrank3.clear();
							combined_maps.clear();
							//child_maps.clear();

							
					
				//}
	             	Cycle[run]++;
				}

			
			System.out.println("NO. of cycles=" + (Cycle[run] - 1)); // ���Number of Cycle
			coverage[run] = totalpathcounter * 100 / PATHNUM; // percentage of paths covered per run
			System.out.println("Path coverage=" + coverage[run] + "%");
			System.out.println("The optimal solution is");
			System.out.println("template 1(bbbb): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			// one run ends here

		}

		double time_sum = 0, time_average;
		float coverage_sum = 0, coverage_average, cycle_sum = 0, cycle_average, case_average;
		int case_sum = 0;
		for (int run = 0; run < RUN; run++) {
			time_sum = time_sum + runtime[run];
			cycle_sum = cycle_sum + (Cycle[run] - 1);
			case_sum = case_sum + total_case_num[run];
			coverage_sum = coverage_sum + coverage[run];
		  }
		
		time_average = time_sum / RUN;
		cycle_average = cycle_sum / RUN;
		case_average = case_sum / RUN;
		coverage_average = coverage_sum / RUN;

		System.out.println("time_sum = " + time_sum + "ms");
		System.out.println("time_average = " + time_average + "ms");
		System.out.println("cycle_sum = " + cycle_sum);
		System.out.println("cycle_average = " + cycle_average);
		System.out.println("case_sum = " + case_sum);
		System.out.println("case_average = " + case_average);
		System.out.println("coverage_sum = " + coverage_sum + "%");
		System.out.println("coverage_average = " + coverage_average + "%");

	
		
		//test case number statistics
		try 
		{ 
//			WritableWorkbook wbook= 
//			Workbook.createWorkbook(new File("E:/result0106.xls")); 
//			//生成名为“Ramdom”的工作表，参数0表示这是第一页 
//			WritableSheet sheet=wbook.createSheet("DE1",0); 
			
			File file = new java.io.File("C:/Users/scybe/eclipse-workspace/TestData/Test_whole.xls"); 
			Workbook book = Workbook.getWorkbook(file);   
			WritableWorkbook wbook = Workbook.createWorkbook(file, book); 
     	    WritableSheet sheet = wbook.getSheet(0);  // 写入数据 sheet    
			
			for(int run=0 ; run<RUN; run++)
			{
				int q = run;
				jxl.write.Number number = new jxl.write.Number(col, q,total_case_num[run]); 
				
				
				sheet.addCell(number); 
				System.out.println(total_case_num[run]);	
			}
			
			//total_case_num[run]
			
		 	double case_ave = getAverage(total_case_num , RUN);
			jxl.write.Number number1 = new jxl.write.Number(col, 25 ,case_ave); 
			sheet.addCell(number1);
			
			 		
			wbook.write(); 	
			wbook.close();
			 
		}catch(Exception e) 
		{ 
		System.out.println(e); 
		} 
						
		
		//coverage statistics 
		
		//test case number statistics
				
		
		
		try 
			{ 
//					
					File file = new java.io.File("C:/Users/scybe/eclipse-workspace/TestData/Coverage_whole.xls"); 
					Workbook book = Workbook.getWorkbook(file);   
					WritableWorkbook wbook = Workbook.createWorkbook(file, book); 
		     	    WritableSheet sheet = wbook.getSheet(0);  // 写入数据 sheet    
					
					for(int run=0 ; run<RUN; run++)
					{
						int q=run;
						jxl.write.Number number = new jxl.write.Number(col, q,coverage[run]); 
						sheet.addCell(number); 
						
 
						//写入数据并关闭文件 				
					}
					
					//total_case_num[run]
					
					double case_ave = getAverages(coverage , RUN);
					jxl.write.Number number1 = new jxl.write.Number(col,25,case_ave); 
					sheet.addCell(number1);
					
					wbook.write(); 	
					wbook.close();
					 
				}catch(Exception e) 
				{ 
				System.out.println(e); 
				} 
				
		

	}

	
	
	
	public static String pathnum(int[] x) {

		StringBuilder stringBuilder = new StringBuilder();
		// stringBuilder.append("0"); //for max array just store it. it's by default
		// assigned
		String finalpath = " ";

		boolean[][] truth_table_visit = new boolean[NODENUM][R];

	 // maximum array value

			int i1;

			int max;
			int[] a4 = new int[R]; // a4 will hold the values in the individual x

			for (i1 = 0; i1 < R; i1++) {

				a4[i1] = x[i1]; // insert x values into array a4

			}

			max = a4[0]; // set max value to the first element of the array

			for (int j = 1; j < R; j++) {

				if (a4[j] > max) {

					truth_table_visit[0][j] = true; // keep track of the truth node visit at the taken iteration---make
													// it true

					// truth_table_visit[1][j] = false;
					  max = a4[j];
				}

				else {

					// truth_table_visit[0][j] = false;
					truth_table_visit[1][j] = true;
					// max = a4[j];
					// truth_table_visit[1][j] = true;
					// false_count++;
					// false_table_visit[1][j] = true;

				}
				
			}

			for (int j = 1; j < R; j++) { // align the visits to form the correct traversed path

				if ((truth_table_visit[0][j])) {

					stringBuilder.append('a');

				} 
				
		
				if ((truth_table_visit[1][j]))
					stringBuilder.append('b');
			

			}

			finalpath = stringBuilder.toString();
			// return finalpath;

		

		return finalpath; // path traversed by input/test data(x) : capture its id
	}

	public static List<Double> benchmarkfunction(int[] trix)
			throws FileNotFoundException // evaluation_of_fitness_for

	{
		double[][] fitness_matrix = new double[NODENUM][R];
		List<Double> fit = new ArrayList<Double>();
		boolean[][] benchmark_table_visit = new boolean[NODENUM][R];
		// evaluate divergence at the edge of the vertex per iteration ...

			StringBuilder benchmarkBuilder = new StringBuilder();
			String final_vertex_path;
	
			String nonsimple_violation;

			//int pattern_counter;

			//pattern_counter = pattern_number;
			int i2;
			int i3;
			double v1 = 0;

			double v2 = 0;

			double exp = 0;
			double exp_1 = 0;
			double total_1 = 0.0;

			// double matched_percentage = 0.0;
			int max1;
			// double unwinding1 = 0.0;
			// double unwinding2 = 0.0;;
			// double unwinding1 = 0.0;
			// double unwinding2 = 0.0;
			double simple_unwinding = 0.0;

			int max2;
			int[] a5 = new int[R];
			int[] a6 = new int[R];
			fitness_matrix[0][0] = Double.MAX_VALUE;
			fitness_matrix[1][0] = Double.MAX_VALUE;
			// total_violation = 0.0;
			// Unmatched_branch_node_1 = 0;
			// total_1 = 0.0;

			for (i2 = 0; i2 < R; i2++) {

				a5[i2] = trix[i2];

			}

			max1 = a5[0];

			for (int j = 1; j < R; j++) {

				if (a5[j] > max1) {

					v1 = 0.0;
					fitness_matrix[0][j] = v1;
					max1 = a5[j];
				}

				else {
					v1 = (max1 - a5[j]) + bias;

					exp = Math.pow(1.001, -(v1));

					fitness_matrix[0][j] = (1 - exp);
					// truth_table_visit[0][j] = true;
					// truth_count++;

				}

				
			}
			// f[0] = v2 ; // fitness of not taking truth node

			// fitness of not taking else edge
			for (i3 = 0; i3 < R; i3++) {

				a6[i3] = trix[i3];

			}

			max2 = a6[0];

			for (int j = 1; j < R; j++) {

				if (a6[j] <= max2) {

					v2 = 0.0;

					fitness_matrix[1][j] = v2;

				} 
				
				else {

					v2 = (a6[j] - max2) + bias;

					exp_1 = Math.pow(1.001, -(v2)); // normalize_branch_distance

					fitness_matrix[1][j] = (1 - exp_1);
					
					max2 = a6[j];
				}

				

			}

			int i1;
			int max_;

			int[] a4_ = new int[R];

			for (i1 = 0; i1 < R; i1++) {

				a4_[i1] = trix[i1];

			}

			max_ = a4_[0];

			for (int j = 1; j < R; j++) {

				if (a4_[j] > max_) {

					benchmark_table_visit[0][j] = true;
					// truth_count++;
					max_ = a4_[j];
				}

				else {

					// max = a4[j];
					benchmark_table_visit[1][j] = true;
					// false_count++;
					// false_table_visit[1][j] = true;

				}
				
			}
			// construct traversed vertex string

			for (int j = 1; j < R; j++) {

				if ((benchmark_table_visit[0][j])) {

					benchmarkBuilder.append('a');

				}

	
				if ((benchmark_table_visit[1][j])) {
						benchmarkBuilder.append('b');
				
				}
			}

			final_vertex_path = benchmarkBuilder.toString();

			// String temp_path;

			//nonsimple_violation = final_vertex_path.substring(0, Math.min(final_vertex_path.length(), pattern_number));
			// myText.substring(0, Math.min(6, myText.length())

			//if (!nonsimple_violation.equals(template_id)) {

	

			try {
				File fstream_temporary = new File("C:/Users/scybe/eclipse-workspace/Bench/All.txt");
				FileReader fileReader_ = new FileReader(fstream_temporary);
				BufferedReader br_ = new BufferedReader(fileReader_);
				String strLine_non;
				 //int counter1 = -1;
				
				while ((strLine_non = br_.readLine()) != null) {
					
					
					if (!paths.get(strLine_non)) {

						double Unmatched_branch_node_a_ = 0.0;
						double Unmatched_branch_node_b_ = 0.0;
						// traversed_violation = strLine_non.substring(strLine_non.length() - 5);

						int index = 0;
						// double unwinding2 = 0.0;
						for (int i = 0; i < 10; i++) {
							index++;
							if (final_vertex_path.charAt(i) != strLine_non.charAt(i)) {

								if (strLine_non.charAt(i) == 'a') {
									
									
									Unmatched_branch_node_a_ += fitness_matrix[0][index];

								}
								
								
							   if (strLine_non.charAt(i) == 'b') {
									
									
									Unmatched_branch_node_b_ += fitness_matrix[1][index];

								}
								
							}
								
						}
						double nonsimple_unmatched2 = 0.0;
						nonsimple_unmatched2 = Unmatched_branch_node_a_ + Unmatched_branch_node_b_;
						fit.add(nonsimple_unmatched2);
					}
				//	else {
						
						
						//one of the paths is covered--update the parent fitness vectors
						
						
						
				//	}
				//	else {
						
						
					//	fit.add(0.0);
						
				//	}
				
			
				}
				br_.close();
			}
	          catch(Exception e) {

	        }

		return fit;

	}

	static void enumeratePaths(int k, char[] set, char[] str, int index) {
		if (index == k) {
			// System.out.println(new String(str));
			paths.put(new String(str), false); // write all resulting paths to map..

		} else {
			for (int i = 0; i < set.length; i++) {
				str[index] = set[i];
				enumeratePaths(k, set, str, index + 1); // recursive procedure to enumerate the paths.
			}
		}
	}

	public static void init_Template() throws IOException { // read paths from map to files according to template ids..
															// assign identical paths to templates

		FileOutputStream fos_all = new FileOutputStream(allpaths);
		BufferedWriter bw_all = new BufferedWriter(new OutputStreamWriter(fos_all));

		// pathcounter

		Set<String> keyz = paths.keySet();

		for (String key : keyz) {

			bw_all.write(key); // write to file
			bw_all.newLine();

			
		}

		bw_all.close();
	

	}

	public static void reset_All() {
		// clear all the maps for next run and update them
		paths.clear();
		pathcounter.clear();
		evaluated_status.clear();
		//dynamic_access.clear();

		

		// reload the path map with all the paths
		try {
			File fstream_temporary = new File("C:/Users/scybe/eclipse-workspace/Bench/All.txt");
			FileReader fileReader_ = new FileReader(fstream_temporary);
			BufferedReader br_ = new BufferedReader(fileReader_);
			String strLine_temporary;

			while ((strLine_temporary = br_.readLine()) != null) {

				paths.put(strLine_temporary, false);

			}
			br_.close();
		} catch (Exception e) {
		}

	}

	static double getAverage(int[] array, int num) {
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += array[i];
		}
		return (double) (sum / num);
	}

	// ��׼��
	static double getStandardDevition(int[] array, int num) {
		double sum = 0;
		for (int i = 0; i < num; i++) {
			sum += Math.sqrt(((double) array[i] - getAverage(array, num)) * (array[i] - getAverage(array, num)));
		}
		return (sum / (num - 1));
	}

	
	public static int frontdominace_Comparison(List<Double> listxobjectives, List<Double> listvobjectives) {

		int dominat_flagx = 0;
		int dominat_flagv = 0;
		int two_objectivesy_count = 0;
		int two_objectivesx_count = 0;
		int objectivexcount = 0;
		int objectivevcount = 0;
		

		for (int i = 0; i < listxobjectives.size(); i++) {

			if(two_objectivesx_count == 2) {
				
				
				break;
			}
			
			
			if (listxobjectives.get(i) == listvobjectives.get(i)) {

				objectivexcount++;
				two_objectivesx_count++;
			}

			if (listxobjectives.get(i) < listvobjectives.get(i)) {

				dominat_flagx = 1;
				objectivexcount++;
			}

		}

		for (int i = 0; i < listvobjectives.size(); i++) {

		
		   if(two_objectivesy_count == 2) {
				
				
				break;
			}
			
			if (listvobjectives.get(i) == listxobjectives.get(i)) {

				objectivevcount++;
				two_objectivesy_count++;
			}

			if (listvobjectives.get(i) < listxobjectives.get(i)) {
				
				objectivevcount++;
			}

		
		}

		if ((objectivexcount > objectivevcount ) ) {

			return -1; // Testcase1 dominates
		}

		else if ((objectivevcount > objectivexcount) ) {

			return 1; // Testcase2 dominates
		}

		else {
			return 0;
		}
		/// No one dominate the other

	}

	public static int get_count(List<Double> dominatx, List<Double> dominaty) {

		int objectivedominaty = 0;

		for (int i = 0; i < dominatx.size(); i++) {

			if (dominatx.get(i) > dominaty.get(i)) {

				objectivedominaty++;

			}

		}

		return objectivedominaty;
	}

	static float getAverages( float[] array, int num) {
		float sum = 0;
		for (int i = 0; i < num; i++) {
			sum += array[i];
		}
		return (float) (sum / num);
	}	
	

	
}