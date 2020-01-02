
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

//import LoopDE.Loop_PathDE.MyCallable;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.util.Set;

//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;

/*Author Semujju Stuart Dereck*/
public class max_LPCF {

	private static  int RUN = 1; // the number of the program runs.
	private static  double F = 0.55;
	private static  int K = 10;
	private static  int pop_num = 50; // the number of test cases
	private static  int fun_num = 1; // the serial number of the target benchmark function.
	private static  int R = 11;
	private static  int NODENUM = 2; // the number of the nodes/vertex in the target benchmark function.
//	static boolean[][] visit = new boolean[NODENUM][4]; // '2' is for 'Yes' branch and 'No' branch.
	private static  int MCN = 4000; // the maximum test case number for a template.
//	private static final int MainCN = 1000000000; // test cases to be used in a run
//	private static final int col = 0;
	private static  double Pc = 0.2;
	private static  double non_simpleid = 99.0; // prefix  given to test case not traversing a path in the group
	private static  double non_simpleid2 = 100.0;// prefix given to test case traversing a path in the group
	private static  int PATHNUM = 64; // In this test bench mark there are 16 groups each with 32 paths
	private static int case_sum = 0; 
	
	private static int[][] temp_1 = new int[PATHNUM][R];
    private static int[][] temp_2 = new int[PATHNUM][R];
	private static int[][] temp_3 = new int[PATHNUM][R];
	private static int[][] temp_4 = new int[PATHNUM][R];
	private static int[][] temp_5 = new int[PATHNUM][R];
	private static int[][] temp_6 = new int[PATHNUM][R];
	private static int[][] temp_7 = new int[PATHNUM][R];
	private static int[][] temp_8 = new int[PATHNUM][R];
	private static int[][] temp_9 = new int[PATHNUM][R];
	private static int[][] temp_10 = new int[PATHNUM][R];
	private static int[][] temp_11 = new int[PATHNUM][R];
	private static int[][] temp_12 = new int[PATHNUM][R];
	private static int[][] temp_13 = new int[PATHNUM][R];
	private static int[][] temp_14 = new int[PATHNUM][R];
	private static int[][] temp_15 = new int[PATHNUM][R];
	private static int[][] temp_16 = new int[PATHNUM][R];
	
	private static int[][] temp_holder = new int[50][R];

	private static int fitsizex = 0;

	// This bench mark takes 9 iterations and has two simple loop paths 2^9 = 512
	// paths. The unique simple loop patterns
	// are 16, therefore resulting into 32 paths in each group. Every group has 32
	// paths

	private static final int TOTAL_PATHNUM = 1024;

	//static int[] path_id = new int[PATHNUM];
	//static boolean[] status = new boolean[8];

	static double[][] fitness_matrix = new double[NODENUM][R];

	static int pattern_number = 4; // The simple loop pattern number of this benchmark is set to the first four 4
									// iterations()

	// ************************************ strings to capture simple loop paths and
	// to capture non-simple loop
	// paths**************************************************//
	static LinkedHashMap<String, Boolean> temporary_path_holder = new LinkedHashMap<String, Boolean>();
	static LinkedHashMap<String, Integer> pathcounter = new LinkedHashMap<String, Integer>();
	// static LinkedHashMap<String, int[][]> dynamic_access = new
	// LinkedHashMap<String, int[][]>();
	static LinkedHashMap<String, Boolean> evaluated_status = new LinkedHashMap<String, Boolean>();
	public static Map<String, int[][]> dynamic_access = new HashMap<String, int[][]>();

	// These are the identifiers(I.Ds) for each group/template based on the simple
	// loop path pattern
	static String template_1 = "bbbb";
	static String template_2 = "bbba";
	static String template_3 = "bbab";
	static String template_4 = "bbaa";
	static String template_5 = "babb";
	static String template_6 = "baba";
	static String template_7 = "baab";
	static String template_8 = "baaa";
	static String template_9 = "abbb";
	static String template_10 = "abba";
	static String template_11 = "abab";
	static String template_12 = "abaa";
	static String template_13 = "aabb";
	static String template_14 = "aaba";
	static String template_15 = "aaab";
	static String template_16 = "aaaa";

	// ****************************************************************************************************************************************************************//

	static int[][] dynamic16;

	static int que = 1;

	static int[] Cycle = new int[RUN];
	static float[] coverage = new float[RUN];
	static double[] runtime = new double[RUN];
	//static int[] case_num = new int[RUN];
	
	static int[] total_case_num = new int[RUN];
	//static int[] itr = new int[4];

	static String[] dynamo = { template_1, template_2, template_3, template_4, template_5, template_6, template_7,
			template_8, template_9, template_10, template_11, template_12, template_13, template_14, template_15,
			template_16 }; // this will be used later, currently not implemented

	static String[] groupss_1 = { template_2, template_3, template_4, template_5, template_6, template_7, template_8,
			template_9 };

	static String[] groupss_0 = {template_10, template_11, template_12, template_13,
			template_14, template_15 };

	// Here we create files(groups) to hold/store the number of similar paths in
	// each separate group
	static File allpaths = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/All.txt");

	static File id_1 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaaa.txt");
	static File id_2 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaab.txt");
	static File id_3 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaba.txt");
	static File id_4 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aabb.txt");
	static File id_5 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abaa.txt");
	static File id_6 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abab.txt");
	static File id_7 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abba.txt");
	static File id_8 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abbb.txt");
	static File id_9 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baaa.txt");
	static File id_10 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baab.txt");
	static File id_11 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baba.txt");
	static File id_12 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/babb.txt");
	static File id_13 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbaa.txt");
	static File id_14 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbab.txt");
	static File id_15 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbba.txt");
	static File id_16 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbbb.txt");
	// static File id_1 = new File("C:/Users/LilongHuang/Desktop/00000.txt");

	// Here we also create maps to keep track of the status of each path in a group,
	// to know whether it was covered or not

	//static LinkedHashMap<String, Integer> itr1 = new LinkedHashMap<String, Integer>();

	static LinkedHashMap<String, Boolean> paths = new LinkedHashMap<String, Boolean>();

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		// TODO Auto-generated method stub

		// System.out.println("what");
		int k = 10; // number of iterations. In this bench mark (called find maximum element in an
					// array)
		// the iteration , k is determined by the array size.

		char[] set = { 'a', 'b' }; // number of nodes/simple loop paths in the Unit under test

		// these will appear 9 times in a loop path.
		char[] str = new char[k];

		enumeratePaths(k, set, str, 0); // call function to generate the paths
		init_Template();// function to create the groups of paths. // using the simple loop path pattern
						// information

		LinkedHashMap<String, List<String>> group_map = new LinkedHashMap<String, List<String>>();

		// LinkedHashMap<String, List<String>> group_0_map = new LinkedHashMap<String,
		// List<String>>();

		List<String> neighbor_1 = new ArrayList<String>();

		List<String> neighbor_0 = new ArrayList<String>();

		for (int gr = 0; gr < groupss_0.length; gr++) {

			neighbor_0.add(groupss_0[gr]);

		} // populate neighbors starting with 0

		for (int gr_1 = 0; gr_1 < groupss_1.length; gr_1++) {

			neighbor_1.add(groupss_1[gr_1]);

		} // populate neighbors starting with 1

		List<String> group_1_list = new ArrayList<String>();
		List<String> group_0_list = new ArrayList<String>();

		group_0_list.addAll(neighbor_0);

		group_map.put(template_16, group_0_list);

		group_1_list.addAll(neighbor_1);

		group_map.put(template_1, group_1_list);

		int[] lb = new int[R];// lower bound
		int[] ub = new int[R];// upper bound

		for (int j = 0; j < R; j++) { // the sample range of integers is between 1 and 100
			lb[j] = 1; // lower bound
			ub[j] = 100; // upper bound

		}

		for (int run = 0; run < RUN; run++) {

			int[][] x = new int[pop_num][R];
			int[][] v = new int[pop_num][R];

			LinkedHashMap<String, List<Double>> fitnessmaps = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps1 = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps2 = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps3 = new LinkedHashMap<String, List<Double>>();

			LinkedHashMap<String, Integer> setrank1 = new LinkedHashMap<String, Integer>();
			LinkedHashMap<String, Integer> setrank2 = new LinkedHashMap<String, Integer>();

			LinkedHashMap<String, Integer> setrank3 = new LinkedHashMap<String, Integer>();

			List<String> updated_population = new ArrayList<String>();

			List<String> offspring_population = new ArrayList<String>();
			List<String> offspring_population2 = new ArrayList<String>();

			List<String> single_population = new ArrayList<String>();

			String traverse_template;

			// the 2d arrays below hold the solutions to each respective group

			int[][] solution_1 = new int[PATHNUM][R];
			int[][] solution_2 = new int[PATHNUM][R];
			int[][] solution_3 = new int[PATHNUM][R];
			int[][] solution_4 = new int[PATHNUM][R];
			int[][] solution_5 = new int[PATHNUM][R];
			int[][] solution_6 = new int[PATHNUM][R];
			int[][] solution_7 = new int[PATHNUM][R];
			int[][] solution_8 = new int[PATHNUM][R];
			int[][] solution_9 = new int[PATHNUM][R];
			int[][] solution_10 = new int[PATHNUM][R];
			int[][] solution_11 = new int[PATHNUM][R];
			int[][] solution_12 = new int[PATHNUM][R];
			int[][] solution_13 = new int[PATHNUM][R];
			int[][] solution_14 = new int[PATHNUM][R];
			int[][] solution_15 = new int[PATHNUM][R];
			int[][] solution_16 = new int[PATHNUM][R];

			boolean[] statu_1 = new boolean[PATHNUM];
			boolean[] statu_2 = new boolean[PATHNUM];
			boolean[] statu_3 = new boolean[PATHNUM];
			boolean[] statu_4 = new boolean[PATHNUM];
			boolean[] statu_5 = new boolean[PATHNUM];
			boolean[] statu_6 = new boolean[PATHNUM];
			boolean[] statu_7 = new boolean[PATHNUM];
			boolean[] statu_8 = new boolean[PATHNUM];
			boolean[] statu_9 = new boolean[PATHNUM];
			boolean[] statu_10 = new boolean[PATHNUM];
			boolean[] statu_11 = new boolean[PATHNUM];
			boolean[] statu_12 = new boolean[PATHNUM];
			boolean[] statu_13 = new boolean[PATHNUM];
			boolean[] statu_14 = new boolean[PATHNUM];
			boolean[] statu_15 = new boolean[PATHNUM];
			boolean[] statu_16 = new boolean[PATHNUM];

			// these will count the number of paths covered in each group
			int obj_1 = 0;
			int obj_2 = 0;
			int obj_3 = 0;
			int obj_4 = 0;
			int obj_5 = 0;
			int obj_6 = 0;
			int obj_7 = 0;
			int obj_8 = 0;
			int obj_9 = 0;
			int obj_10 = 0;
			int obj_11 = 0;
			int obj_12 = 0;
			int obj_13 = 0;
			int obj_14 = 0;
			int obj_15 = 0;
			int obj_16 = 0;
			int totalpathcounter = 0;

			int obj_total = 0;

			String getfinalpath;
			String final_path_checker;

			if (run > 0) { // in each run reset the number counter of the paths covered in each group

				reset_All();
				
				updated_population.clear();
				offspring_population.clear();
				offspring_population2.clear();
				single_population.clear();
				
				setrank1.clear();
				setrank2.clear();
				setrank3.clear();
				
				fitnessmaps.clear();
				fitnessmaps1.clear();
				fitnessmaps2.clear();
				fitnessmaps3.clear();

			}

			for (int i = 0; i < pop_num; i++) // initialize the population with the dimension of R values/inputs
			{

				for (int j = 0; j < R; j++) {
					// double r0 = Math.random();

					// x[i][j] = (int) Math.round(lb[j] + r0 * (ub[j] - lb[j])); // RANDOMLY
					// ASSIGNED DIMENSIONAL VALUES
					// (VECTOR) (load the population with
					// values)
					// x[i][j] = (int) Math.round(lb[j] + r0 * (ub[j] - lb[j]));

					//x[i][j] = (int) (lb[j] + Math.random() * (ub[j] - lb[j]));
					
					x[i][j]  = (int)(Math.random()*((ub[j]  - lb[j])+1))+ lb[j];

				}

				// case_num[run] = case_num[run] + 1 ; // test case number

				 // here we start to count the test case

				// call benchmark function and find out if the path is traversed or not
				// e.g this benchmark as two simple loop paths encoded as 0 and 1.
				// Since there are nine iterations we can have any possible sequence appearing 9
				// times

				getfinalpath = pathnum(x[i]); // path traversed by input x is returned

				final_path_checker = getfinalpath.substring(0, Math.min(getfinalpath.length(), pattern_number));

				if (final_path_checker.equals(template_1)) { // if the traversed path_id is equal to "the template id"

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_1 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbbb.txt");
						FileReader fileReader_1 = new FileReader(file_1);
						BufferedReader br_1 = new BufferedReader(fileReader_1);

						String strLine_1;

						int counter1 = -1;
						while ((strLine_1 = br_1.readLine()) != null) {
							// Print the paths in this group to the console
							// System.out.println (strLine);
							counter1++;

							if (strLine_1.equals(getfinalpath)) {

								if (paths.get(strLine_1)) {
									
									break;
								} 
								else {
									paths.put(strLine_1, true);

									int va_31 = pathcounter.get(template_1);

									int fin_31 = va_31 + 1;

									pathcounter.put(template_1, fin_31);

								    if (!statu_1[counter1]) { // this status array keeps track of the index of the path in
															// the file..o
									// to establish if it's covered or not

									for (int s = 0; s < R; s++) {

										solution_1[counter1][s] = x[i][s];
										// capture solution for main file
										// old_1[counter1][s]= x[i][s];
										// check if map contains this with false visit it contains

									}
									statu_1[counter1] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_1++;

									totalpathcounter++;

									break;
								}
								
							}
							}

						}
						fileReader_1.close(); // Close the input stream

					} 
					catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_2)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_2 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbba.txt");
						FileReader fileReader_2 = new FileReader(file_2);
						BufferedReader br_2 = new BufferedReader(fileReader_2);

						String strLine_2;
						// Read File Line By Line
						// int counter1 = -1;
						int counter2 = -1;
						while ((strLine_2 = br_2.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter2++;
							if (strLine_2.equals(getfinalpath)) {

								if (paths.get(strLine_2)) {
									break;
								}
								
								
								else {
									paths.put(strLine_2, true);
									int va_32 = 0;

									va_32 = pathcounter.get(template_2);

									int fin_32 = 0;
									
								    fin_32 = va_32 + 1;

									pathcounter.put(template_2, fin_32);


								if (!statu_2[counter2]) {
									// array template_1path_id

									for (int s = 0; s < R; s++) {

										solution_2[counter2][s] = x[i][s];

									}
									statu_2[counter2] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_2++;
									// pathcounter.put("1110", pathcounter.get("1110") + 1);
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_2.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_3)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_3 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbab.txt");
						FileReader fileReader_3 = new FileReader(file_3);
						BufferedReader br_3 = new BufferedReader(fileReader_3);

						String strLine_3;
						// Read File Line By Line
						// int counter1 = -1;
						int counter3 = -1;
						while ((strLine_3 = br_3.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter3++;
							if (strLine_3.equals(getfinalpath)) {

								if (paths.get(strLine_3)) {
									break;
								}
								
								else {
									paths.put(strLine_3, true);

									 int valz = 0;
									 valz = pathcounter.get(template_3);

									int fin = valz + 1;

									pathcounter.put(template_3, fin);

						

							 // call path status .. assign truth flag... along that path...

							   if (!statu_3[counter3]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_3[counter3][s] = x[i][s];

								}
								statu_3[counter3] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_3++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
							
					}
						fileReader_3.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_4)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_4 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbaa.txt");
						FileReader fileReader_4 = new FileReader(file_4);
						BufferedReader br_4 = new BufferedReader(fileReader_4);

						String strLine_4;
						// Read File Line By Line
						// int counter1 = -1;
						int counter4 = -1;
						while ((strLine_4 = br_4.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter4++;
							if (strLine_4.equals(getfinalpath)) {

								if (paths.get(strLine_4)) {
									break;
								} else {
									paths.put(strLine_4, true);

									int va_34 = pathcounter.get(template_4);

								
									int fin_34 = va_34 + 1;

									pathcounter.put(template_4, fin_34);

								if (!statu_4[counter4]) {
									// array template_1path_id

									for (int s = 0; s < R; s++) {

										solution_4[counter4][s] = x[i][s];

									}
									statu_4[counter4] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_4++;
									// pathcounter.put("1100", pathcounter.get("1100") + 1);
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_4.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
				// out of the loop
				// break ;
				// }

				else if (final_path_checker.equals(template_5)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_5 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/babb.txt");
						FileReader fileReader_5 = new FileReader(file_5);
						BufferedReader br_5 = new BufferedReader(fileReader_5);

						String strLine_5;
						// Read File Line By Line
						// int counter1 = -1;
						int counter5 = -1;
						while ((strLine_5 = br_5.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter5++;
							if (strLine_5.equals(getfinalpath)) {
								if (paths.get(strLine_5)) {
									break;
								} 
								
								else {
									paths.put(strLine_5, true);

									
									int va_35 = pathcounter.get(template_5);

									
									int fin_35 = va_35 + 1;

									pathcounter.put(template_5, fin_35);

							    	if (!statu_5[counter5]) {
									// array template_1path_id

									// pathcounter.put("1011", pathcounter.get("1011") + 1);

									for (int s = 0; s < R; s++) {

										solution_5[counter5][s] = x[i][s];

									}
									statu_5[counter5] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_5++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_5.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
				// out of the loop
				// break ;
				// }

				else if (final_path_checker.equals(template_6)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_6 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baba.txt");
						FileReader fileReader_6 = new FileReader(file_6);
						BufferedReader br_6 = new BufferedReader(fileReader_6);

						String strLine_6;
						// Read File Line By Line
						// int counter1 = -1;
						int counter6 = -1;
						while ((strLine_6 = br_6.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter6++;
							if (strLine_6.equals(getfinalpath)) {

								if (paths.get(strLine_6)) {
									break;
								} 
								
								else {
									paths.put(strLine_6, true);

									int g_36 = 0;
									int va_36 = pathcounter.get(template_6);

									g_36++;
									int fin_36 = va_36 + g_36;

									pathcounter.put(template_6, fin_36);

								if (!statu_6[counter6]) {

									for (int s = 0; s < R; s++) {

										solution_6[counter6][s] = x[i][s];

									}
									statu_6[counter6] = true; //
									obj_6++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
						}
						}
						fileReader_6.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_7)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_7 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baab.txt");
						FileReader fileReader_7 = new FileReader(file_7);
						BufferedReader br_7 = new BufferedReader(fileReader_7);

						String strLine_7;
						// Read File Line By Line
						// int counter1 = -1;
						int counter7 = -1;
						while ((strLine_7 = br_7.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter7++;
							if (strLine_7.equals(getfinalpath)) {
							
								if (paths.get(strLine_7)) {
									break;
								}
								
								
								else {
									paths.put(strLine_7, true);

									int g_37 = 0;
									int va_37 = pathcounter.get(template_7);

									g_37++;
									int fin_37 = va_37 + g_37;

									pathcounter.put(template_7, fin_37);

								
								if (!statu_7[counter7]) {

									for (int s = 0; s < R; s++) {

										solution_7[counter7][s] = x[i][s];

									}
									statu_7[counter7] = true; //
									obj_7++;
									totalpathcounter++;

									break;
								}
							}
							}
						}
						fileReader_7.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_8)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_8 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baaa.txt");
						FileReader fileReader_8 = new FileReader(file_8);
						BufferedReader br_8 = new BufferedReader(fileReader_8);

						String strLine_8;
						// Read File Line By Line
						// int counter1 = -1;
						int counter8 = -1;
						while ((strLine_8 = br_8.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter8++;
							if (strLine_8.equals(getfinalpath)) {
								
								if (paths.get(strLine_8)) {
									break;
								} 
								
								
								else {
									paths.put(strLine_8, true);

									int g_38 = 0;
									int va_38 = pathcounter.get(template_8);

									g_38++;
									int fin_38 = va_38 + g_38;

									pathcounter.put(template_8, fin_38);

								if (!statu_8[counter8]) {

									for (int s = 0; s < R; s++) {

										solution_8[counter8][s] = x[i][s];

									}
									statu_8[counter8] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_8++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
						}
						}
						fileReader_8.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_9)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_9 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abbb.txt");
						FileReader fileReader_9 = new FileReader(file_9);
						BufferedReader br_9 = new BufferedReader(fileReader_9);

						String strLine_9;
						// Read File Line By Line
						// int counter1 = -1;
						int counter9 = -1;
						while ((strLine_9 = br_9.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter9++;
							if (strLine_9.equals(getfinalpath)) {
								if (paths.get(strLine_9)) {
									break;
								}
								
								else {
									paths.put(strLine_9, true);

									int g_39 = 0;
									int va_39 = pathcounter.get(template_9);

									g_39++;
									int fin_39 = va_39 + g_39;

									pathcounter.put(template_9, fin_39);

								if (!statu_9[counter9]) {

									for (int s = 0; s < R; s++) {

										solution_9[counter9][s] = x[i][s];

									}
									statu_9[counter9] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_9++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_9.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_10)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_10 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abba.txt");
						FileReader fileReader_10 = new FileReader(file_10);
						BufferedReader br_10 = new BufferedReader(fileReader_10);

						String strLine_10;
						// Read File Line By Line
						// int counter1 = -1;
						int counter10 = -1;
						while ((strLine_10 = br_10.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter10++;
							if (strLine_10.equals(getfinalpath)) {
								if (paths.get(strLine_10)) {
									break;
								} 
								
								else {
									paths.put(strLine_10, true);
									int g_40 = 0;
									int va_40 = pathcounter.get(template_10);

									g_40++;
									int fin_40 = va_40 + g_40;

									pathcounter.put(template_10, fin_40);
								

								if (!statu_10[counter10]) {

									for (int s = 0; s < R; s++) {

										solution_10[counter10][s] = x[i][s];

									}
									statu_10[counter10] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_10++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_10.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_11)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//

					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_11 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abab.txt");
						FileReader fileReader_11 = new FileReader(file_11);
						BufferedReader br_11 = new BufferedReader(fileReader_11);

						String strLine_11;
						// Read File Line By Line
						// int counter1 = -1;
						int counter11 = -1;
						while ((strLine_11 = br_11.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter11++;
							if (strLine_11.equals(getfinalpath)) {
							
								if (paths.get(strLine_11)) {
									break;
								}
								
								
						     else {
									paths.put(strLine_11, true);

									int g_41 = 0;
									int va_41 = pathcounter.get(template_11);

									g_41++;
									int fin_41 = va_41 + g_41;

									pathcounter.put(template_11, fin_41);

								if (!statu_11[counter11]) {

									for (int s = 0; s < R; s++) {

										solution_11[counter11][s] = x[i][s];

									}
									statu_11[counter11] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_11++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
						}
						}
						fileReader_11.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
				// of the loop
				// break ;
				// }

				else if (final_path_checker.equals(template_12)) { // if the traversed path_id is equal to "the template
																	// id"
																	// ******
					// **************************************************************************//
					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_12 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abaa.txt");
						FileReader fileReader_12 = new FileReader(file_12);
						BufferedReader br_12 = new BufferedReader(fileReader_12);

						String strLine_12;
						// Read File Line By Line
						// int counter1 = -1;
						int counter12 = -1;
						while ((strLine_12 = br_12.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter12++;
							if (strLine_12.equals(getfinalpath)) {

								if (paths.get(strLine_12)) {
									break;
								} 
								else {
									paths.put(strLine_12, true);

									int g_42 = 0;
									int va_42 = pathcounter.get(template_12);

									g_42++;
									int fin_42 = va_42 + g_42;

									pathcounter.put(template_12, fin_42);

						
								if (!statu_12[counter12]) {

									for (int s = 0; s < R; s++) {

										solution_12[counter12][s] = x[i][s];

									}
									statu_12[counter12] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_12++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_12.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_13)) { // if the traversed path_id is equal to "the template
																	// id"
					// **************************************************************************//
					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_13 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aabb.txt");
						FileReader fileReader_13 = new FileReader(file_13);
						BufferedReader br_13 = new BufferedReader(fileReader_13);

						String strLine_13;
						// Read File Line By Line
						// int counter1 = -1;
						int counter13 = -1;
						while ((strLine_13 = br_13.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter13++;
							if (strLine_13.equals(getfinalpath)) {
							
								if (paths.get(strLine_13)) {
									break;
								}
								
								
								else {
									paths.put(strLine_13, true);

									int g_43 = 0;
									int va_43 = pathcounter.get(template_13);

									g_43++;
									int fin_43 = va_43 + g_43;

									pathcounter.put(template_13, fin_43);

							
								if (!statu_13[counter13]) {

									for (int s = 0; s < R; s++) {

										solution_13[counter13][s] = x[i][s];

									}
									statu_13[counter13] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_13++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
						}
						}
						fileReader_13.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
				// of the loop
				// break ;
				// }

				else if (final_path_checker.equals(template_14)) { // if the traversed path_id is equal to "the template
																	// id"

					// ******
					// **************************************************************************//
					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_14 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaba.txt");
						FileReader fileReader_14 = new FileReader(file_14);
						BufferedReader br_14 = new BufferedReader(fileReader_14);

						String strLine_14;
						// Read File Line By Line
						// int counter1 = -1;
						int counter14 = -1;
						while ((strLine_14 = br_14.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter14++;
							if (strLine_14.equals(getfinalpath)) {
							
								if (paths.get(strLine_14)) {
									break;
								} 
								
								
								else {
									paths.put(strLine_14, true);

									int g_44 = 0;
									int va_44 = pathcounter.get(template_14);

									g_44++;
									int fin_44 = va_44 + g_44;

									pathcounter.put(template_14, fin_44);

							

								if (!statu_14[counter14]) {

									for (int s = 0; s < R; s++) {

										solution_14[counter14][s] = x[i][s];

									}
									statu_14[counter14] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_14++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_14.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
				// of the loop
				// break ;
				// }

				else if (final_path_checker.equals(template_15)) { // if the traversed path_id is equal to "the template
																	// id"
					// ******
					// **************************************************************************//
					try {
						// Open the file/template with that id that is the first
						// command line parameter
						File file_15 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaab.txt");
						FileReader fileReader_15 = new FileReader(file_15);
						BufferedReader br_15 = new BufferedReader(fileReader_15);

						String strLine_15;
						// Read File Line By Line
						// int counter1 = -1;
						int counter15 = -1;
						while ((strLine_15 = br_15.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter15++;
							if (strLine_15.equals(getfinalpath)) {
								
								if (paths.get(strLine_15)) {
									break;
								} 
								
								else {
									paths.put(strLine_15, true);

									int g_45 = 0;
									int va_45 = pathcounter.get(template_15);

									g_45++;
									int fin_45 = va_45 + g_45;

									pathcounter.put(template_15, fin_45);

							
								if (!statu_15[counter15]) {

									for (int s = 0; s < R; s++) {

										solution_15[counter15][s] = x[i][s]; // only for this template

										// solution of the main file of maps

									}
									statu_15[counter15] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_15++;
									totalpathcounter++;

									break;
								}
							}
							}
						}
						fileReader_15.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}

				else if (final_path_checker.equals(template_16)) { // if the traversed path_id is equal to "the template
																	// id"
																	// ******

					// **************************************************************************//
					try {
						// Open the file/template with that id that is the first
						// command line parameter

						File file_16 = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaaa.txt");
						FileReader fileReader_16 = new FileReader(file_16);
						BufferedReader br_16 = new BufferedReader(fileReader_16);

						String strLine_16;

						int counter16 = -1;
						while ((strLine_16 = br_16.readLine()) != null) {
							// Print the content on the console
							// System.out.println (strLine);
							counter16++;
							if (strLine_16.equals(getfinalpath)) {

								if (paths.get(strLine_16)) {
									break;
								}
								
								
								else {
									paths.put(strLine_16, true);

									int g_46 = 0;
									int va_46 = pathcounter.get(template_16);

									g_46++;
									int fin_46 = va_46 + g_46;

									pathcounter.put(template_16, fin_46);

							

								if (!statu_16[counter16]) {

									for (int s = 0; s < R; s++) {

										solution_16[counter16][s] = x[i][s];

									}
									statu_16[counter16] = true; // ���·��Path�Ƿ����ҵ�������������
									obj_16++;
									totalpathcounter++;
									// get other nodes(not part of the simple loop pattern)

									break;
								}
							}
							}
						}
						fileReader_16.close(); // Close the input stream

					} catch (Exception e) {
					}
					// }

				}
				
				total_case_num[run] = total_case_num[run] + 1;
				//case_sum++;
			}

			Cycle[run] = 1;

			///// Above was the initial population check

			// Next we need to get the initial set of offspring and the do the crossover
			// /mutation/ and select which
			// candidates to survive....To do the selction we use the non-dominated sorting
			// approach using a modified GDE3

			// The following code snippet is to select the group/template to traverse at a
			// time
			for (int iterator = 0; iterator < 16; iterator++) { // iterator of all templates // checks to perform // is
				// maximum id the group number. Here I take only one group for test purposes
				// only // it already evaluated
				temporary_path_holder.clear();
				dynamic_access.clear();
				int infeasible_path = 0;

				// selection of the group is based on the group with least number of remaining
				// paths among all the other groups
				// (in comparison of all the other paths)
				int value;
				String minKey = " ";

				int minValue = 0;

				int count = 0;

				Iterator<Map.Entry<String, Boolean>> iter = evaluated_status.entrySet().iterator();

				while (iter.hasNext()) {

					Map.Entry<String, Boolean> entry = iter.next();

					if (entry.getValue() == true) {

						iter.remove();

					}

				}

				for (String key : evaluated_status.keySet()) {
					count++;

					if (count == 1) {

						minKey = key;
						minValue = (pathcounter.get(key));

						break;
					}
				}

				int counters = 0;
				for (String key6 : evaluated_status.keySet()) {
					counters++;

					if (counters == 1) {

						continue;
					}

					else {

						value = pathcounter.get(key6);

						if (value < minValue) {
							value = minValue;
							minKey = key6;

						}
					}
					
					
				}

				traverse_template = minKey;
				// traverse_template = "1001"; //for test purposes i am using this group only ..
				// not all of them
				// obj = (pathcounter.get(traverse_template));
				evaluated_status.put(traverse_template, true);
				// System.out.println(traverse_template);

				// dynamic_access map hold the archived solution set

				// disable pareto ranking

				try {
					File fstream_temporary = new File(
							"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/" + traverse_template + ".txt");
					FileReader fileReader_ = new FileReader(fstream_temporary);
					BufferedReader br_ = new BufferedReader(fileReader_);
					String strLine_temporary;

					while ((strLine_temporary = br_.readLine()) != null) {

						// read files into map

						if (!paths.get(strLine_temporary)) {

							temporary_path_holder.put(strLine_temporary, false);
						}
					}
					br_.close();
				} catch (Exception e) {
				}

				if (iterator > 0) {

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_1[a]) {

							for (int j = 0; j < R; j++) {
								temp_1[a][j] = solution_1[a][j];

							}
						}

					}

					dynamic_access.put(template_1, temp_1);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_2[a]) {

							for (int j = 0; j < R; j++) {
								temp_2[a][j] = solution_2[a][j];

							}
						}

					}

					dynamic_access.put(template_2, temp_2);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_3[a]) {

							for (int j = 0; j < R; j++) {
								temp_3[a][j] = solution_3[a][j];

							}
						}

					}

					dynamic_access.put(template_3, temp_3);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_4[a]) {

							for (int j = 0; j < R; j++) {
								temp_4[a][j] = solution_4[a][j];

							}
						}

					}

					dynamic_access.put(template_4, temp_4);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_5[a]) {

							for (int j = 0; j < R; j++) {
								temp_5[a][j] = solution_5[a][j];

							}
						}

					}

					dynamic_access.put(template_5, temp_5);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_6[a]) {

							for (int j = 0; j < R; j++) {
								temp_6[a][j] = solution_6[a][j];

							}
						}

					}

					dynamic_access.put(template_6, temp_6);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_7[a]) {

							for (int j = 0; j < R; j++) {
								temp_7[a][j] = solution_7[a][j];

							}
						}

					}

					dynamic_access.put(template_7, temp_7);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_8[a]) {

							for (int j = 0; j < R; j++) {
								temp_8[a][j] = solution_8[a][j];

							}
						}

					}

					dynamic_access.put(template_8, temp_8);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_9[a]) {

							for (int j = 0; j < R; j++) {
								temp_9[a][j] = solution_9[a][j];

							}
						}

					}

					dynamic_access.put(template_9, temp_9);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_10[a]) {

							for (int j = 0; j < R; j++) {
								temp_10[a][j] = solution_10[a][j];

							}
						}

					}

					dynamic_access.put(template_10, temp_10);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_11[a]) {

							for (int j = 0; j < R; j++) {
								temp_11[a][j] = solution_11[a][j];

							}
						}

					}

					dynamic_access.put(template_11, temp_11);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_12[a]) {

							for (int j = 0; j < R; j++) {
								temp_12[a][j] = solution_12[a][j];

							}
						}

					}

					dynamic_access.put(template_12, temp_12);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_13[a]) {

							for (int j = 0; j < R; j++) {
								temp_13[a][j] = solution_13[a][j];

							}
						}

					}

					dynamic_access.put(template_13, temp_13);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_14[a]) {

							for (int j = 0; j < R; j++) {
								temp_14[a][j] = solution_14[a][j];

							}
						}

					}

					dynamic_access.put(template_14, temp_14);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_15[a]) {

							for (int j = 0; j < R; j++) {
								temp_15[a][j] = solution_15[a][j];

							}
						}

					}

					dynamic_access.put(template_15, temp_15);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_16[a]) {

							for (int j = 0; j < R; j++) {
								temp_16[a][j] = solution_16[a][j];

							}
						}

					}

					dynamic_access.put(template_16, temp_16);
					
					

					for (int temp_x = 0; temp_x < pop_num; temp_x++) {

						for (int rr = 0; rr < R; rr++) {

							temp_holder[temp_x][rr] = (x[temp_x][rr]);

						}

					}

					/*for (int row = 0; row < pop_num; row++) {
						for (int col = 0; col < R; col++) {
							x[row][col] = 0;
						}
					}*/

					for (String group_key : group_map.keySet()) {

						if (traverse_template.charAt(0) == group_key.charAt(0)) {

							List<String> neighbor_holder = new ArrayList<String>();

							neighbor_holder = group_map.get(group_key);

							int index_getter = 0;

							for (int holders = 0; holders < neighbor_holder.size(); holders++) {

								if (neighbor_holder.get(holders).equals(traverse_template)) {

									for (int i_1 = 0; i_1 < (dynamic_access.get(traverse_template)).length; i_1++) {

										if (index_getter < pop_num) {
											
										//	for (int dimz = 0; dimz < (dynamic_access
													//.get(traverse_template)[i_1]).length; dimz++) {

												if (       dynamic_access.get(traverse_template)[i_1][0] == 0
														&& dynamic_access.get(traverse_template)[i_1][ 1] == 0
														&& dynamic_access.get(traverse_template)[i_1][ 2] == 0
													    && dynamic_access.get(traverse_template)[i_1][ 3] == 0
													    && dynamic_access.get(traverse_template)[i_1][ 4] == 0
													    && dynamic_access.get(traverse_template)[i_1][ 5] == 0
													    && dynamic_access.get(traverse_template)[i_1][ 6] == 0
													    && dynamic_access.get(traverse_template)[i_1][ 7] == 0
													    && dynamic_access.get(traverse_template)[i_1][ 8] == 0
													    && dynamic_access.get(traverse_template)[i_1][ 9] == 0
														) {

													continue;
												}

												else {

													for (int dimz = 0; dimz < (dynamic_access
															.get(traverse_template)[i_1]).length; dimz++) {
													
													x[index_getter][dimz] = dynamic_access
															.get(traverse_template)[i_1][dimz];

												}
											}

										}

										index_getter++;
									}

									break;
								}

							}

							for (int holder = 0; holder < neighbor_holder.size(); holder++) {

								if (!(neighbor_holder.get(holder).equals(traverse_template))) {

									String tempo = (neighbor_holder.get(holder));

									for (int i_2 = 0; i_2 < (dynamic_access.get(tempo)).length; i_2++) {

										//index_getter++;

										if (index_getter < pop_num) {

											if (       dynamic_access.get(tempo)[i_2][0] == 0
													&& dynamic_access.get(tempo)[i_2][ 1] == 0
													&& dynamic_access.get(tempo)[i_2][ 2] == 0
												    && dynamic_access.get(tempo)[i_2][ 3] == 0
												    && dynamic_access.get(tempo)[i_2][ 4] == 0
												    && dynamic_access.get(tempo)[i_2][ 5] == 0
												    && dynamic_access.get(tempo)[i_2][ 6] == 0
												    && dynamic_access.get(tempo)[i_2][ 7] == 0
												    && dynamic_access.get(tempo)[i_2][ 8] == 0
												    && dynamic_access.get(tempo)[i_2][ 9] == 0
													) {

												continue;
											}

											else {

												for (int dimz = 0; dimz < (dynamic_access
														.get(tempo)[i_2]).length; dimz++) {
												
												x[index_getter][dimz] = dynamic_access
														.get(tempo)[i_2][dimz];

											}
										  }
										}
										index_getter++;
									}
									
								
								}
							}

							
							/*if (index_getter < pop_num) {

								int intg = index_getter;

								for (int temp_t = 0; temp_t < pop_num; temp_t++) {

									if (intg < pop_num) {

										for (int rr_ = 0; rr_ < R; rr_++) {

											x[intg][rr_] = temp_holder[temp_t][rr_];

										}
									}
									
									intg++;
								}
							}*/

							break;
						}

					}

					// }
				}
			//	case_ = 0; // reset test case number assigned to each template
				case_sum = 0;
				// iterator
				while (case_sum <= MCN && pathcounter.get(traverse_template) < PATHNUM) // not exceeded the set

				{

					if (infeasible_path > 3) {

						break;
					}
					// PATHNUM of current tier/obj_1
					// if (iterator == 0) {
					for (int i = 0; i < pop_num; i++) // Generate a new test case (crossover&mutation)
					{
						int k1 = (int) Math.floor(Math.random() * 50); // must not be same as parent
						// execute this code while K1 = i
						while (k1 == i)

							k1 = (int) Math.floor(Math.random() * 50);

						int k2 = (int) Math.floor(Math.random() * 50);

						while (k2 == i || k2 == k1) // must not be same as parent

							k2 = (int) Math.floor(Math.random() * 50);

						int jrand = (int) (Math.random() * R);

						for (int j = 0; j < R; j++) {

							// v[i][j] = (int) Math.round(Math.abs(x[i][j] + F * (x[k1][j] - x[k2][j]))); //
							// parent
							v[i][j] = (int) ((x[i][j] + F * (x[k1][j] - x[k2][j])));

							if (Math.random() <= Pc && j != jrand)

								v[i][j] = x[i][j];

							if (v[i][j] > ub[j] || v[i][j] < lb[j]) {
								double r01 = Math.random();

								//v[i][j] = (int) Math.round(lb[j] + r01 * (ub[j] - lb[j]));
								
								v[i][j] = (int)(Math.random()*((ub[j]  - lb[j])+1))+ lb[j];
							}
							// System.out.println("v[i][j]" + v[i][j]);

						}

						
						getfinalpath = pathnum(v[i]);

						if (getfinalpath.startsWith(template_1)) { // if the traversed path_id is equal to "the template

							int[][] temp_1;

							// id"
							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_1 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbbb.txt");
								FileReader fileReader_1 = new FileReader(file_1);
								BufferedReader br_1 = new BufferedReader(fileReader_1);

								String strLine_1;
								// Read File Line By Line
								// int counter1 = -1;
								int counter1 = -1;
								while ((strLine_1 = br_1.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter1++;
									if (strLine_1.equals(getfinalpath)) {

										if (paths.get(strLine_1)) {
											break;
										}
										
										else {
											paths.put(strLine_1, true);

											int g_22 = 0;
											int va_22 = pathcounter.get(template_1);

											g_22++;
											int fin_22 = va_22 + g_22;

											pathcounter.put(template_1, fin_22);

										

										if (!statu_1[counter1]) {

											for (int s = 0; s < R; s++) {

												solution_1[counter1][s] = v[i][s];

											}
											statu_1[counter1] = true; //
											obj_1++;
											totalpathcounter++;
											// local correctly found paths

											break;
										}
									}
									}
								}
								fileReader_1.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_2)) { // if the traversed path_id is equal to "the
																		// template

							int[][] temp_2;
							// id"
							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_2 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbba.txt");
								FileReader fileReader_2 = new FileReader(file_2);
								BufferedReader br_2 = new BufferedReader(fileReader_2);

								String strLine_2;
								// Read File Line By Line
								// int counter1 = -1;
								int counter2 = -1;
								while ((strLine_2 = br_2.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter2++;
									if (strLine_2.equals(getfinalpath)) {

										if (paths.get(strLine_2)) {
											break;
										}
										
										else {
											paths.put(strLine_2, true);

											int g_21 = 0;
											int va_21 = pathcounter.get(template_2);

											g_21++;
											int fin_21 = va_21 + g_21;

											pathcounter.put(template_2, fin_21);

									
										if (!statu_2[counter2]) {
											// array template_1path_id

											for (int s = 0; s < R; s++) {

												solution_2[counter2][s] = v[i][s];

											}
											statu_2[counter2] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_2++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_2.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_3)) { // if the traversed path_id is equal to "the
																		// template

							int[][] temp_3;
							// id"
							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter

								File file_3 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbab.txt");
								FileReader fileReader_3 = new FileReader(file_3);
								BufferedReader br_3 = new BufferedReader(fileReader_3);

								String strLine_3;
								// Read File Line By Line
								// int counter1 = -1;
								int counter3 = -1;
								while ((strLine_3 = br_3.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter3++;
									if (strLine_3.equals(getfinalpath)) {

										if (paths.get(strLine_3)) {
											break;
										} 
										
										else {
											paths.put(strLine_3, true);

											int xxi = 0;
											int valz = pathcounter.get(template_3);

											xxi++;
											int fin = valz + xxi;

											pathcounter.put(template_3, fin);

									
										if (!statu_3[counter3]) {

											for (int s = 0; s < R; s++) {

												solution_3[counter3][s] = v[i][s];

											}
											statu_3[counter3] = true; //
											obj_3++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_3.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_4)) { // if the traversed path_id is equal to "the
																		// template
							// id"

							int[][] temp_4;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_4 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/bbaa.txt");
								FileReader fileReader_4 = new FileReader(file_4);
								BufferedReader br_4 = new BufferedReader(fileReader_4);

								String strLine_4;
								// Read File Line By Line
								// int counter1 = -1;
								int counter4 = -1;
								while ((strLine_4 = br_4.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter4++;
									if (strLine_4.equals(getfinalpath)) {

										if (paths.get(strLine_4)) {
											break;
										} 
										
										else {
											paths.put(strLine_4, true);

											int g_19 = 0;
											int va_19 = pathcounter.get(template_4);

											g_19++;
											int fin_19 = va_19 + g_19;

											pathcounter.put(template_4, fin_19);

										
										if (!statu_4[counter4]) {

											for (int s = 0; s < R; s++) {

												solution_4[counter4][s] = v[i][s];

											}
											statu_4[counter4] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_4++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_4.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_5)) { // if the traversed path_id is equal to "the
																		// template
							// id"

							int[][] temp_5;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_5 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/babb.txt");
								FileReader fileReader_5 = new FileReader(file_5);
								BufferedReader br_5 = new BufferedReader(fileReader_5);

								String strLine_5;
								// Read File Line By Line
								// int counter1 = -1;
								int counter5 = -1;
								while ((strLine_5 = br_5.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter5++;
									if (strLine_5.equals(getfinalpath)) {

										if (paths.get(strLine_5)) {
											break;
										} 
										
										else {
											paths.put(strLine_5, true);

											int g_18 = 0;
											int va_18 = pathcounter.get(template_5);

											g_18++;
											int fin_18 = va_18 + g_18;

											pathcounter.put(template_5, fin_18);

									
										if (!statu_5[counter5]) {

											for (int s = 0; s < R; s++) {

												solution_5[counter5][s] = v[i][s];

											}
											statu_5[counter5] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_5++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_5.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_6)) { // if the traversed path_id is equal to "the
																		// template

							int[][] temp_6;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_6 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baba.txt");
								FileReader fileReader_6 = new FileReader(file_6);
								BufferedReader br_6 = new BufferedReader(fileReader_6);

								String strLine_6;
								// Read File Line By Line
								// int counter1 = -1;
								int counter6 = -1;
								while ((strLine_6 = br_6.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter6++;
									if (strLine_6.equals(getfinalpath)) {

										if (paths.get(strLine_6)) {
											break;
										}
										
										else {
											paths.put(strLine_6, true);

											int g_16 = 0;
											int va_16 = pathcounter.get(template_6);

											g_16++;
											int fin_16 = va_16 + g_16;

											pathcounter.put(template_6, fin_16);

									
										if (!statu_6[counter6]) {

											for (int s = 0; s < R; s++) {

												solution_6[counter6][s] = v[i][s];

											}
											statu_6[counter6] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_6++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_6.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_7)) { // if the traversed path_id is equal to "the
																		// template
							// id"

							int[][] temp_7;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_7 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baab.txt");
								FileReader fileReader_7 = new FileReader(file_7);
								BufferedReader br_7 = new BufferedReader(fileReader_7);

								String strLine_7;
								// Read File Line By Line
								// int counter1 = -1;

								int counter7 = -1;
								while ((strLine_7 = br_7.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter7++;
									if (strLine_7.equals(getfinalpath)) {
										if (paths.get(strLine_7)) {
											break;
										} 
										
										else {
											paths.put(strLine_7, true);

											int g_17 = 0;
											int va_17 = pathcounter.get(template_7);

											g_17++;
											int fin_17 = va_17 + g_17;

											pathcounter.put(template_7, fin_17);

									
										if (!statu_7[counter7]) {
											// array template_1path_id

											for (int s = 0; s < R; s++) {

												solution_7[counter7][s] = v[i][s];

											}
											statu_7[counter7] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_7++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_7.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_8)) { // if the traversed path_id is equal to "the
																		// template
							// id"

							int[][] temp_8;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_8 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/baaa.txt");
								FileReader fileReader_8 = new FileReader(file_8);
								BufferedReader br_8 = new BufferedReader(fileReader_8);

								String strLine_8;
								// Read File Line By Line
								// int counter1 = -1;
								int counter8 = -1;
								while ((strLine_8 = br_8.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter8++;
									if (strLine_8.equals(getfinalpath)) {
										if (paths.get(strLine_8)) {
											break;
										}
										
										
										else {
											paths.put(strLine_8, true);

											int g_7 = 0;
											int va_7 = pathcounter.get(template_8);

											g_7++;
											int fin_7 = va_7 + g_7;

											pathcounter.put(template_8, fin_7);

										if (!statu_8[counter8]) {

											for (int s = 0; s < R; s++) {

												solution_8[counter8][s] = v[i][s];

											}
											statu_8[counter8] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_8++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_8.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_9)) { // if the traversed path_id is equal to "the
																		// template
							// id"

							int[][] temp_9;
							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_9 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abbb.txt");
								FileReader fileReader_9 = new FileReader(file_9);
								BufferedReader br_9 = new BufferedReader(fileReader_9);

								String strLine_9;
								// Read File Line By Line
								// int counter1 = -1;

								int counter9 = -1;
								while ((strLine_9 = br_9.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter9++;
									if (strLine_9.equals(getfinalpath)) {

										if (paths.get(strLine_9)) {
											break;
										} 
										
										else {
											paths.put(strLine_9, true);

											int g_5 = 0;
											int va_5 = pathcounter.get(template_9);

											g_5++;
											int fin_5 = va_5 + g_5;

											pathcounter.put(template_9, fin_5);

										if (!statu_9[counter9]) {

											for (int s = 0; s < R; s++) {

												solution_9[counter9][s] = v[i][s];

											}
											statu_9[counter9] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_9++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_9.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_10)) { // if the traversed path_id is equal to "the
																			// template
							// id"

							int[][] temp_10;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_10 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abba.txt");
								FileReader fileReader_10 = new FileReader(file_10);
								BufferedReader br_10 = new BufferedReader(fileReader_10);

								String strLine_10;
								// Read File Line By Line
								// int counter1 = -1;

								int counter10 = -1;
								while ((strLine_10 = br_10.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter10++;
									if (strLine_10.equals(getfinalpath)) {

										if (paths.get(strLine_10)) {
											break;
										} 
										
										else {
											paths.put(strLine_10, true);

											int g_4 = 0;
											int va_4 = pathcounter.get(template_10);

											g_4++;
											int fin_4 = va_4 + g_4;

											pathcounter.put(template_10, fin_4);

										if (!statu_10[counter10]) {

											for (int s = 0; s < R; s++) {

												solution_10[counter10][s] = v[i][s];

											}
											statu_10[counter10] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_10++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_10.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_11)) { // if the traversed path_id is equal to "the
																			// template
							// id"

							int[][] temp_11;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_11 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abab.txt");
								FileReader fileReader_11 = new FileReader(file_11);
								BufferedReader br_11 = new BufferedReader(fileReader_11);

								String strLine_11;
								// Read File Line By Line
								// int counter1 = -1;

								int counter11 = -1;
								while ((strLine_11 = br_11.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter11++;
									if (strLine_11.equals(getfinalpath)) {

										if (paths.get(strLine_11)) {
											break;
										}
										
										
										else {
											paths.put(strLine_11, true);

											int g_3 = 0;
											int va_gg = pathcounter.get(template_11);

											g_3++;
											int fin_3 = va_gg + g_3;

											pathcounter.put(template_11, fin_3);

										if (!statu_11[counter11]) {

											for (int s = 0; s < R; s++) {

												solution_11[counter11][s] = v[i][s];

											}
											statu_11[counter11] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_11++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_11.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_12)) { // if the traversed path_id is equal to "the
																			// template
							// id"

							int[][] temp_12;
							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_12 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/abaa.txt");
								FileReader fileReader_12 = new FileReader(file_12);
								BufferedReader br_12 = new BufferedReader(fileReader_12);

								String strLine_12;
								// Read File Line By Line
								// int counter1 = -1;

								int counter12 = -1;
								while ((strLine_12 = br_12.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter12++;
									if (strLine_12.equals(getfinalpath)) {

										if (paths.get(strLine_12)) {
											break;
										} 
										
										else {
											paths.put(strLine_12, true);

											int g_2 = 0;
											int val_gg = pathcounter.get(template_12);

											g_2++;
											int fin_1 = val_gg + g_2;

											pathcounter.put(template_12, fin_1);

									
										if (!statu_12[counter12]) {

											for (int s = 0; s < R; s++) {

												solution_12[counter12][s] = v[i][s];

											}
											statu_12[counter12] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_12++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_12.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_13)) { // if the traversed path_id is equal to "the
																			// template
							// id"

							int[][] temp_13;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_13 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aabb.txt");
								FileReader fileReader_13 = new FileReader(file_13);
								BufferedReader br_13 = new BufferedReader(fileReader_13);

								String strLine_13;

								// Read File Line By Line
								// int counter1 = -1;

								int counter13 = -1;
								while ((strLine_13 = br_13.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter13++;
									if (strLine_13.equals(getfinalpath)) {

										if (paths.get(strLine_13)) {
											break;
										} 
										
										
										else {
											paths.put(strLine_13, true);

											int g_1 = 0;
											int val_g = pathcounter.get(template_13);

											g_1++;
											int fin_ss = val_g + g_1;

											pathcounter.put(template_13, fin_ss);

										if (!statu_13[counter13]) {

											for (int s = 0; s < R; s++) {

												solution_13[counter13][s] = v[i][s];

											}
											statu_13[counter13] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_13++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_13.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_14)) { // if the traversed path_id is equal to "the
																			// template
							// id"

							int[][] temp_14;
							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_14 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaba.txt");
								FileReader fileReader_14 = new FileReader(file_14);
								BufferedReader br_14 = new BufferedReader(fileReader_14);

								String strLine_14;
								// Read File Line By Line
								// int counter1 = -1;

								int counter14 = -1;
								while ((strLine_14 = br_14.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter14++;
									if (strLine_14.equals(getfinalpath)) {

										if (paths.get(strLine_14)) {
											break;
										} 
										else {
											paths.put(strLine_14, true);

											int g = 0;
											int valg = pathcounter.get(template_14);

											g++;
											int finss = valg + g;

											pathcounter.put(template_14, finss);

										if (!statu_14[counter14]) {

											for (int s = 0; s < R; s++) {

												solution_14[counter14][s] = v[i][s];

											}
											statu_14[counter14] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_14++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_14.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_15)) { // if the traversed path_id is equal to "the
																			// template
							// id"

							int[][] temp_15;

							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_15 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaab.txt");
								FileReader fileReader_15 = new FileReader(file_15);
								BufferedReader br_15 = new BufferedReader(fileReader_15);
								String strLine_15;
								// Read File Line By Line
								// int counter1 = -1;

								int counter15 = -1;
								while ((strLine_15 = br_15.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter15++;
									if (strLine_15.equals(getfinalpath)) {
										if (paths.get(strLine_15)) {
											break;
										}
										
										else {
											paths.put(strLine_15, true);

											int xxx = 0;
											int valzz = pathcounter.get(template_15);

											xxx++;
											int fins = valzz + xxx;

											pathcounter.put(template_15, fins);

										if (!statu_15[counter15]) {
											// array template_1path_id

											for (int s = 0; s < R; s++) {

												solution_15[counter15][s] = v[i][s];

											}
											statu_15[counter15] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_15++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_15.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						else if (getfinalpath.startsWith(template_16)) { // if the traversed path_id is equal to "the
																			// template

							int[][] temp_16;
							// id"
							// ******
							// **************************************************************************//
							try {
								// Open the file/template with that id that is the first
								// command line parameter
								File file_16 = new File(
										"C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/aaaa.txt");
								FileReader fileReader_16 = new FileReader(file_16);
								BufferedReader br_16 = new BufferedReader(fileReader_16);

								String strLine_16;

								int counter16 = -1;
								while ((strLine_16 = br_16.readLine()) != null) {
									// Print the content on the console
									// System.out.println (strLine);
									counter16++;
									if (strLine_16.equals(getfinalpath)) {

										if (paths.get(strLine_16)) {
											break;
										}
										
										else {
											paths.put(strLine_16, true);

											int xx = 0;
											int valz = pathcounter.get(template_16);

											xx++;
											int fin = valz + xx;

											pathcounter.put(template_16, fin);

										if (!statu_16[counter16]) {
											// array template_1path_id

											for (int s = 0; s < R; s++) {

												solution_16[counter16][s] = v[i][s];

											}
											statu_16[counter16] = true; // ���·��Path�Ƿ����ҵ�������������
											obj_16++;
											totalpathcounter++;
											// get other nodes(not part of the simple loop pattern)

											break;
										}
									}
									}
								}
								fileReader_16.close(); // Close the input stream

							} catch (Exception e) {
							}
							// }

						}

						case_sum++;
						total_case_num[run] = total_case_num[run] + 1;

					} //

					if (pathcounter.get(traverse_template) < PATHNUM) {

						if ((PATHNUM - (pathcounter.get(traverse_template)) == 1)) { //if only one uncovered path

							// break;

							infeasible_path++;

							LinkedHashMap<String, Double> single_objective = new LinkedHashMap<String, Double>();
							// System.out.println("only one uncovered>>>>");
							double par_obj;

							double child_obj;

							for (int i = 0; i < pop_num; i++) {

								List<Double> fitnessx_ = new ArrayList<Double>();
								// align benchmark function to template to evaluate

								fitnessx_ = benchmarkfunction(x[i], fun_num, traverse_template);

								// row_getter.put(offspring_population.get(get_row), row_fitter);
								par_obj = fitnessx_.get(1);
								// offspring_singleobjective

								double obj_par = par_obj;

								List<Double> fitnessv_ = new ArrayList<Double>();

								fitnessv_ = benchmarkfunction(v[i], fun_num, traverse_template);

								child_obj = fitnessv_.get(1);

								double obj_ch = child_obj;

								if (obj_ch < obj_par) {

									single_objective.put(("child" + " " + i), obj_ch);

								}

							    if (obj_par < obj_ch) {

									single_objective.put(("parent" + " " + i), obj_par);

								}

							    if (obj_par == obj_ch) {

									single_objective.put(("parent" + " " + i), obj_par);
									single_objective.put(("child" + " " + i), obj_ch);

								}

							}

							// double row_fitter = row_fit;

							Map<String, Double> result_ = single_objective.entrySet().stream()
									.sorted(Map.Entry.comparingByValue()).collect(toMap(Map.Entry::getKey,
											Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

							Iterator<Map.Entry<String, Double>> iteration_ = result_.entrySet().iterator();

							while (iteration_.hasNext()) {

								Map.Entry<String, Double> entry = iteration_.next();

								if (single_population.size() < pop_num) {
									single_population.add(entry.getKey());
								}

							}

							String updated_id;

							int updated_val;

							// int rem;

							for (int pop = 0; pop < single_population.size(); pop++) {

								if (pop == 50) {
									break;
								}

								String[] updated_pop = (single_population.get(pop).split(" "));

								updated_id = updated_pop[0];
								updated_val = Integer.parseInt(updated_pop[1]);

								if (updated_id.equals("parent")) {
									for (int update_parent = 0; update_parent < R; update_parent++) {
										// x[i][j] = v[i][j] ;

										x[pop][update_parent] = x[updated_val][update_parent];
									}
								} 
								
							   if (updated_id.equals("child")) {
									for (int update_child = 0; update_child < R; update_child++) {
										// x[i][j] = v[i][j] ;

										x[pop][update_child] = v[updated_val][update_child];
									}
								}

							}

							single_population.clear();
							Cycle[run]++;
                            break;
						}

						if ((PATHNUM - (pathcounter.get(traverse_template)) > 1)) {

							for (int i = 0; i < pop_num; i++) {

								List<Double> fitnessx = new ArrayList<Double>();
								// align benchmark function to template to evaluate

								fitnessx = benchmarkfunction(x[i], fun_num, traverse_template);

								List<Double> fitness_objectives_temporary_x = new ArrayList<Double>();

								for (int cop = 1; cop < fitnessx.size(); cop++) {

									fitness_objectives_temporary_x.add(fitnessx.get(cop));
								}

								List<Double> fitnessv = new ArrayList<Double>();

								fitnessv = benchmarkfunction(v[i], fun_num, traverse_template);

								List<Double> fitness_objectives_temporary_v = new ArrayList<Double>();


								for (int cop = 1; cop < fitnessv.size(); cop++) {

									fitness_objectives_temporary_v.add(fitnessv.get(cop));
								}

								double non_simplexx;
								double non_simplevv;

								int returned_comparison;
								int returned_comparison_par;

								non_simplexx = (fitnessx.get(0));

								non_simplevv = (fitnessv.get(0));

								/*fitsizex = fitnessv.size();

								if (fitsizex == 1) {
									System.out.println(" only  one path left" + fitnessv);

								}*/

								/**********************
								 * properties of test cases not traversing loop path pattern of group
								 ********************************************/

								if (non_simplexx == non_simplevv) {

									if (non_simplexx == non_simpleid && non_simplevv == non_simpleid) { // both don't
																										// traverse the
																										// group simple
																										// loop

										// comparator
										returned_comparison = dominace_Comparison(fitness_objectives_temporary_x,
												fitness_objectives_temporary_v);

										if (returned_comparison == -1) { // Solution i dominates child
											offspring_population2.add("parent" + " " + i);

											// fitness_nonsimple1.put("parent" + " " + i,
											// fitness_objectives_temporary_x);

										} // if
										else if (returned_comparison == 1) { // child dominates
											offspring_population2.add("child" + " " + i);

											// fitness_nonsimple1.put("child" + " " + i,
											// fitness_objectives_temporary_v);

										} // else if
										else { // the two solutions are non-dominated

											// fitness_nonsimple1.put("child" + " " + i,
											// fitness_objectives_temporary_v);

											offspring_population2.add("parent" + " " + i);
											offspring_population2.add("child" + " " + i);

											// fitness_nonsimple1.put("parent" + " " + i,
											// fitness_objectives_temporary_x);

										} // else
											// for

									}

									else if (non_simplexx == non_simpleid2 && non_simplevv == non_simpleid2) {// the
																												// test
																												// cases
																												// match
																												// the
																												// simple
																												// loop
																												// path
																												// pattern
																												// of a
																												// group---->
																												// use
																												// dominance
										// comparator

										//
										//

										returned_comparison_par = dominace_Comparison(fitness_objectives_temporary_x,
												fitness_objectives_temporary_v);

										if (returned_comparison_par == -1) { // Solution i dominates child
											offspring_population.add("parent" + " " + i);

											// fitness_nonsimple2.put("parent" + " " + i,
											// fitness_objectives_temporary_x);

										} // if
										else if (returned_comparison_par == 1) { // child dominates
											offspring_population.add("child" + " " + i);

											// fitness_nonsimple2.put("child" + " " + i,
											// fitness_objectives_temporary_v);

										} // else if
										else { // the two solutions are non-dominated

											// fitness_nonsimple2.put("child" + " " + i,
											// fitness_objectives_temporary_v);

											offspring_population.add("parent" + " " + i);
											offspring_population.add("child" + " " + i);
											// fitness_nonsimple2.put("parent" + " " + i,
											// fitness_objectives_temporary_x);

										} // else

									}

								}

								else { // not the same ids// by default take candidate traversing the simple loop path
										// pattern /as dominant one

									if ((non_simplexx == non_simpleid2) && (non_simplevv == non_simpleid)) {

										offspring_population.add("parent" + " " + i);

										// fitness_nonsimple2.put("parent" + " " + i, fitness_objectives_temporary_x);

										//
									}

									else if (non_simplexx == non_simpleid && non_simplevv == non_simpleid2) {

										offspring_population.add("child" + " " + i);

										// fitness_nonsimple2.put("child" + " " + i, fitness_objectives_temporary_v);
									}

								}

							}

							// We have two sets : offspring_population2 and offspring_population

							// offspring_population contains the test cases/ candidate solutions that
							// traverse the simple loop path
							// pattern of the group.. or they could have covered a path in the group being
							// covered

							// offspring_population2 contains the test cases/ candidate solutions that do
							// not traverse the simple loop path
							// pattern of the group.. i.e they did not cover a path in the group under
							// covered

							// if (pathcounter.get(traverse_template) != PATHNUM) {

							// pathcounter.get(traverse_template)

							if ((!offspring_population.isEmpty()) && (offspring_population2.isEmpty())) {

								// System.out.println("BLOCK_1");

								int[][] updated_offspring = new int[offspring_population.size()][R];

								String status;
								int status_index;
								// populate the array accordingly
								for (int update = 0; update < offspring_population.size(); update++) {

									String[] split_offspring = offspring_population.get(update).split(" ");

									status = (split_offspring[0]);
									status_index = Integer.parseInt(split_offspring[1]);

									// System.out.println( status + " " +status_index);

									if (status.equals("parent")) {
										for (int parent = 0; parent < R; parent++) {
											// x[i][j] = v[i][j] ;

											updated_offspring[update][parent] = x[status_index][parent];
										}
									}

									if (status.equals("child")) {
										for (int child = 0; child < R; child++) {

											updated_offspring[update][child] = v[status_index][child];
										}
									}

								}

								int fitts = 0;
								LinkedHashMap<String, Double> row_getter = new LinkedHashMap<String, Double>();

								int cols = (PATHNUM - (pathcounter.get(traverse_template)));

								int column_size = (cols);

								Double[][] offspring_fitness_full = new Double[offspring_population
										.size()][column_size];

								// String[] fit_obj;
								int updates = 0;

								// List<String> traverse_group = new ArrayList<String>();
								List<String> best_column = new ArrayList<String>();
								
								int fitss = 0;
								
								while (updates < offspring_population.size()) {

									List<Double> updatedfitness = new ArrayList<Double>();

									updatedfitness = benchmarkfunction(updated_offspring[updates], fun_num,
											traverse_template);

								//	fitss = updatedfitness.size();

									List<Double> fitness_objectives_updated = new ArrayList<Double>();
									// fitness_objectives_updated.clear();

									for (int copu = 1; copu < updatedfitness.size(); copu++) {

										fitness_objectives_updated.add(updatedfitness.get(copu));
									}

									List<Double> temp = new ArrayList<Double>();

									// temp.clear();

									temp.addAll(fitness_objectives_updated);

									fitnessmaps.put(offspring_population.get(updates), temp);

									// System.out.println("fitness objectives>>>>" +
									// fitness_objectives_updated.size() );
									for (int ups = 0; ups < fitness_objectives_updated.size(); ups++) {

										offspring_fitness_full[updates][ups] = fitness_objectives_updated.get(ups);

									}

									updates++;

								}

								int cols_ = (PATHNUM - (pathcounter.get(traverse_template)));

								int sizes = (cols_);

								double row_fit;
								int colums = 0;
								String test_case;
								double fit_rowfit;
								//double minval;

								while (colums < sizes) {

									for (int get_row = 0; get_row < (offspring_population.size()); get_row++) {

										fit_rowfit = (offspring_fitness_full[get_row][colums]);

										row_fit = fit_rowfit;

										double row_fitter = row_fit;

										row_getter.put(offspring_population.get(get_row), row_fitter);

									}

									Map<String, Double> result = row_getter.entrySet().stream()
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

								int distance_zero;

								/************************************************************************************************************************************************************/

								double[][] distance_matrix_zero = new double[best_column.size()][best_column.size()];

								if ((best_column.size()) > 1) {

									for (int best = 0; best < (best_column.size()); best++) {

										List<Double> front_0_1 = new ArrayList<Double>();

										front_0_1 = fitnessmaps.get(best_column.get(best));

										for (int ind_d = 0; ind_d < best_column.size(); ind_d++) {

											if (!((best_column.get(best).equals(best_column.get(ind_d))))) {

												List<Double> front_0_2 = new ArrayList<Double>();

												front_0_2 = fitnessmaps.get(best_column.get(ind_d));

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

								else { // process the only item in the best set

									if (!best_column.isEmpty()) {

										String item_one = best_column.get(0);

										if (updated_population.size() < pop_num) {

											updated_population.add(item_one);
										}

									}
								}

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

										fitness_temporary_p = fitnessmaps.get((fitness_objectives_comparator.get(p)));

										// secondary_size = fitness_temporary_p.size();

										for (int q = p + 1; q < N; q++) {
											// if (p != q) {
											List<Double> fitness_temporary_q = new ArrayList<Double>();

											fitness_temporary_q = fitnessmaps
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
									int remaining;
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

													front_getter1 = fitnessmaps.get((front_list.get(ind_d)));

													for (int d = 0; d < front_list.size(); d++) {

														if (!(front_list.get(ind_d).equals(front_list.get(d)))) {

															List<Double> front_getter2 = new ArrayList<Double>();

															front_getter2 = fitnessmaps.get((front_list.get(d)));

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

												front_getter_one = fitnessmaps.get((front_list_one.get(ind_w)));

												for (int dw = 0; dw < front_list_one.size(); dw++) {

													if (!(front_list_one.get(ind_w).equals(front_list_one.get(dw)))) {

														List<Double> front_getter_two = new ArrayList<Double>();

														front_getter_two = fitnessmaps.get((front_list_one.get(dw)));

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

								// System.out.println("WE ARE IN BLOCK 1 ");

								// System.out.println("block-1"+updated_population.size());

								String updated_id;

								int updated_val;

								// int rem;

								for (int pop = 0; pop < updated_population.size(); pop++) {

									if (pop == 50) {
										break;
									}

									String[] updated_pop = (updated_population.get(pop).split(" "));
									updated_id = updated_pop[0];
									updated_val = Integer.parseInt(updated_pop[1]);

									if (updated_id.equals("parent")) {
										for (int update_parent = 0; update_parent < R; update_parent++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_parent] = x[updated_val][update_parent];
										}
									}
									if (updated_id.equals("child")) {
										for (int update_child = 0; update_child < R; update_child++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_child] = v[updated_val][update_child];
										}
									}

								}

							}

							if (!offspring_population.isEmpty() && (!offspring_population2.isEmpty())) {// trouble

								// System.out.println("BLOCK_2");

								int[][] updated_offspring = new int[offspring_population.size()][R];

								String[] split_offspring;
								String status;
								int status_index;
								// populate the array accordingly

								for (int update = 0; update < offspring_population.size(); update++) {

									split_offspring = offspring_population.get(update).split(" ");

									status = split_offspring[0];
									status_index = Integer.parseInt(split_offspring[1]);

									// System.out.println( status + " " +status_index);

									if (status.equals("parent")) {
										for (int parent = 0; parent < R; parent++) {
											// x[i][j] = v[i][j] ;

											updated_offspring[update][parent] = x[status_index][parent];
										}
									}

									else if (status.equals("child")) {
										for (int child = 0; child < R; child++) {
											// x[i][j] = v[i][j] ;

											updated_offspring[update][child] = v[status_index][child];
										}
									}

								}

								LinkedHashMap<String, Double> row_getter = new LinkedHashMap<String, Double>();

								int cols_1 = (PATHNUM - (pathcounter.get(traverse_template)));

								int column_size = (cols_1);

								Double[][] offspring_fitness_full = new Double[offspring_population
										.size()][column_size];
								// LinkedHashMap<String, List<String>> fitnessmaps = new LinkedHashMap<String,
								// List<String>>();

								// String[] fit_obj;
								int updates = 0;
								int sizexx = 0;

								List<String> best_column = new ArrayList<String>();

								while (updates < offspring_population.size()) {

									List<Double> updatedfitness = new ArrayList<Double>();

									updatedfitness = benchmarkfunction(updated_offspring[updates], fun_num,
											traverse_template);

									// System.out.println("Array_lsi" +updatedfitness.size() );

									List<Double> fitness_objectives_updated = new ArrayList<Double>();

									for (int copu = 1; copu < updatedfitness.size(); copu++) {

										fitness_objectives_updated.add(updatedfitness.get(copu));
									}

									List<Double> temp_child_3 = new ArrayList<Double>();

									temp_child_3.addAll(fitness_objectives_updated);

									fitnessmaps1.put(offspring_population.get(updates), temp_child_3);

									for (int ups = 0; ups < fitness_objectives_updated.size(); ups++) {

										offspring_fitness_full[updates][ups] = fitness_objectives_updated.get(ups);

									}

									updates++;

								}

								int cols_2 = (PATHNUM - (pathcounter.get(traverse_template)));

								int sizes = (cols_2);

								double row_fit;
								int colums = 0;
								String test_case;
								double fit_rowfit;
								double minval;

								while (colums < sizes) {

									for (int get_row = 0; get_row < offspring_population.size(); get_row++) {

										fit_rowfit = (offspring_fitness_full[get_row][colums]);

										row_fit = fit_rowfit;

										double rofit = row_fit;

										row_getter.put(offspring_population.get(get_row), rofit);

									}

									Map<String, Double> result_ = row_getter.entrySet().stream()
											.sorted(Map.Entry.comparingByValue())
											.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));

									Iterator<Map.Entry<String, Double>> best_col = result_.entrySet().iterator();

									while (best_col.hasNext()) {

										Map.Entry<String, Double> entry = best_col.next();

										test_case = entry.getKey();

										if (!best_column.contains(test_case)) {

											best_column.add(test_case);

											break;
										}

									}

									result_.clear();
									row_getter.clear();
									colums++;

								}

								List<String> fitness_objectives_comparator = new ArrayList<String>();

								for (int next_front = 0; next_front < offspring_population.size(); next_front++) {

									if (!best_column.contains(offspring_population.get(next_front))) {

										fitness_objectives_comparator.add(offspring_population.get(next_front));
									}
								}

								int distance_zero;

								/************************************************************************************************************************************************************/

								List<Double> front_0_1 = new ArrayList<Double>();

								List<Double> front_0_2 = new ArrayList<Double>();
								// child_map_3

								double[][] distance_matrix_zero = new double[best_column.size()][best_column.size()];

								if ((best_column.size()) > 1) {

									int best;

									for (best = 0; best < (best_column.size()); best++) {

										front_0_1 = fitnessmaps1.get(best_column.get(best));

										for (int ind_d = 0; ind_d < best_column.size(); ind_d++) {

											if (!(best_column.get(best).equals(best_column.get(ind_d)))) {

												front_0_2 = fitnessmaps1.get(best_column.get(ind_d));

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

											if (!(best_column.get(font_i).equals(best_column.get(font_j)))) {

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
									// if (updated_population.size() == pop_num) {

									// break;
									// }
									result.clear();

								}

								else { // process the only item in the best set

									if (!best_column.isEmpty()) {

										String item_one = best_column.get(0);

										if (updated_population.size() < pop_num) {

											updated_population.add(item_one);
										}

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

									// int minimum_sorter1;

									// -> Fast non dominated sorting algorithm

									for (int i = 0; i < ((front.length)); i++) {
										front[i] = new LinkedList<Integer>();
									}

									for (int p = 0; p < fitness_objectives_comparator.size(); p++) {
										// Initialize the list of individuals that i dominate and the number
										// of individuals that dominate me
										iDominate[p] = new LinkedList<Integer>();
										dominateMe[p] = 0;
									}

									int N = fitness_objectives_comparator.size();
									// int[][] dominanceChecks = new int[N][N];

									for (int p = 0; p < N - 1; p++) {

										List<Double> fitness_temporary_p = new ArrayList<Double>();
										fitness_temporary_p = fitnessmaps1.get((fitness_objectives_comparator.get(p)));

										for (int q = p + 1; q < N; q++) {
											// if (p != q) {

											List<Double> fitness_temporary_q = new ArrayList<Double>();

											fitness_temporary_q = fitnessmaps1
													.get((fitness_objectives_comparator.get(q)));

											flagDominate = frontdominace_Comparison(fitness_temporary_p,
													fitness_temporary_q);

											if (flagDominate == -1) {

												iDominate[p].add(q);
												dominateMe[q]++;

											}

											else if (flagDominate == 1) {

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

											setrank1.put(fitness_objectives_comparator.get(p), 0);

										}
									}

									// System.out.println("front_listing : 1 :" +front[1]);
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
													// System.out.println("front_listing" +front[font_s]);
													setrank1.put(fitness_objectives_comparator.get(index), font_s);
												}
											}

										}

									}

									LinkedHashMap<String, Double> setdistance = new LinkedHashMap<String, Double>();

									LinkedHashMap<String, Double> setdistance_one = new LinkedHashMap<String, Double>();

									List<Double> front_getter1 = new ArrayList<Double>();
									List<Double> front_getter2 = new ArrayList<Double>();

									List<String> front_list_one = new ArrayList<String>();

									List<Double> front_getter_one = new ArrayList<Double>();
									List<Double> front_getter_two = new ArrayList<Double>();

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
									int remaining;
									// int smaller_two;

									int fronts = 0;
									// System.out.println("map's size" + reverseMap.size());
									while (fronts < (reverseMap.size())) {

										if (updated_population.size() > pop_num) {

											break;
										}

										if (fronts != (reverseMap.size() - 1)) {

											List<String> front_list = new ArrayList<String>();
											// get all the individuals at fronts
											front_list = reverseMap.get(fronts);
											// System.out.println(front_list);

											if ((front_list.size()) > 1) {

												double[][] distance_matrix = new double[front_list.size()][front_list
														.size()];

												for (int ind_d = 0; ind_d < (front_list.size()); ind_d++) {

													front_getter1 = fitnessmaps1.get((front_list.get(ind_d)));

													for (int d = 0; d < front_list.size(); d++) {

														if (!(front_list.get(ind_d).equals(front_list.get(d)))) {

															front_getter2 = fitnessmaps1.get((front_list.get(d)));

															smaller = get_count(front_getter1, front_getter2);

															int sml = smaller;

															distance_matrix[ind_d][d] = sml;

														}

													}

												}

												for (int font_ = 0; font_ < front_list.size(); font_++) {

													double dd = 0.0;

													setdistance.put(front_list.get(font_), dd);

												}

												// all distances set

												for (int font_i = 0; font_i < (front_list.size()); font_i++) {

													// distance_matrix

													for (int font_j = 0; font_j < front_list.size(); font_j++) {

														if (!(front_list.get(font_i).equals(front_list.get(font_j)))) {

															if (setdistance.get(front_list
																	.get(font_i)) < distance_matrix[font_i][font_j]) {

																double dst = (distance_matrix[font_i][font_j]);

																setdistance.put(front_list.get(font_i), dst);

															}
														}
													}

												}

												Map<String, Double> result = setdistance.entrySet().stream()
														.sorted(Map.Entry.comparingByValue())
														.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
																(oldValue, newValue) -> oldValue, LinkedHashMap::new));

												// result hold the sorted map

												Iterator<Map.Entry<String, Double>> iteration = result.entrySet()
														.iterator();

												while (iteration.hasNext()) {

													Map.Entry<String, Double> entry = iteration.next();

													if (updated_population.size() < pop_num) {
														updated_population.add(entry.getKey());
													}

												}

												result.clear();

											} else {

												// process the only item in the best set

												if (!front_list.isEmpty()) {

													String item_one_ = front_list.get(0);

													if (updated_population.size() < pop_num) {

														updated_population.add(item_one_);
													}

												}

											}

										}

										// remaining = (pop_num - updated_population.size());

										if (fronts == (reverseMap.size() - 1)) {
											// System.out.println("fronts" + " " + fronts );
											// get all the individuals at fronts
											front_list_one = reverseMap.get(reverseMap.size() - 1);

											// System.out.println("hahahq" +front_list_one);

											if ((front_list_one.size()) > 1) {

												double[][] distance_matrix_one = new double[front_list_one
														.size()][front_list_one.size()];

												for (int ind_w = 0; ind_w < (front_list_one.size()); ind_w++) {

													front_getter_one = fitnessmaps1.get((front_list_one.get(ind_w)));

													for (int dw = 0; dw < front_list_one.size(); dw++) {

														if (!(front_list_one.get(ind_w)
																.equals(front_list_one.get(dw)))) {

															front_getter_two = fitnessmaps1
																	.get((front_list_one.get(dw)));

															smaller_one = get_count(front_getter_one, front_getter_two);

															distance_matrix_one[ind_w][dw] = smaller_one;

														}

													}

												}

												for (int font_ = 0; font_ < front_list_one.size(); font_++) {

													setdistance_one.put(front_list_one.get(font_), 0.0);

												}

												// all distances set

												for (int font_i = 0; font_i < (front_list_one.size()); font_i++) {

													// distance_matrix

													for (int font_j = 0; font_j < front_list_one.size(); font_j++) {

														if (!(front_list_one.get(font_i)
																.equals(front_list_one.get(font_j)))) {

															if (setdistance_one.get(front_list_one.get(
																	font_i)) < distance_matrix_one[font_i][font_j]) {

																double ret = (distance_matrix_one[font_i][font_j]);

																setdistance_one.put(front_list_one.get(font_i), ret);

															}
														}
													}

												}

												int remaining_ = (pop_num - updated_population.size());

												// check size before adding idf remaing is

												if (setdistance_one.size() <= remaining_) {

													Map<String, Double> result = setdistance_one.entrySet().stream()
															.sorted(Map.Entry.comparingByValue())
															.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
																	(oldValue, newValue) -> oldValue,
																	LinkedHashMap::new));

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
															.sorted(Map.Entry.<String, Double>comparingByValue()
																	.reversed())
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

													// System.out.println( "sorted map after---"
													// +sortedByValueDesc.size());
													Set<String> keytests = sortedByValueDesc.keySet();

													for (String key_sss : keytests) {

														if (updated_population.size() < pop_num) {

															if (!front_remove.contains(key_sss)) {

																updated_population.add(key_sss);
															}
														}
													}
												}

											}

											else {

												// process the only item in the best set

												if (!front_list_one.isEmpty()) {

													String item_one_1 = front_list_one.get(0);

													if (updated_population.size() < pop_num) {

														updated_population.add(item_one_1);
													}
												}

											}

										}

										setdistance.clear();
										setdistance_one.clear();
										fronts++;
									}
									// System.out.println("updatyed size" +updated_population.size());

								}

								else {
									if (!fitness_objectives_comparator.isEmpty()) {

										if (updated_population.size() < pop_num) {

											String comp = (fitness_objectives_comparator.get(0));

											updated_population.add(comp);
										}

									}

								}

								// if population is less add these items from the test cases that don't traverse
								// the group[

								int[][] updated_offspring2 = new int[offspring_population2.size()][R];

								String status2;
								int status_index2;

								for (int update2 = 0; update2 < offspring_population2.size(); update2++) {

									String[] split_offspring2 = offspring_population2.get(update2).split(" ");

									status2 = split_offspring2[0];
									status_index2 = Integer.parseInt(split_offspring2[1]);

									// System.out.println( status + " " +status_index);

									if (status2.equals("parent")) {
										for (int parent = 0; parent < R; parent++) {
											// x[i][j] = v[i][j] ;

											updated_offspring2[update2][parent] = x[status_index2][parent];
										}
									}

									else if (status2.equals("child")) {
										for (int child = 0; child < R; child++) {
											// x[i][j] = v[i][j] ;

											updated_offspring2[update2][child] = v[status_index2][child];
										}
									}

								}

								LinkedHashMap<String, Double> row_getter7 = new LinkedHashMap<String, Double>();

								int cols_7 = (PATHNUM - (pathcounter.get(traverse_template)));

								int column_size7 = (cols_7);

								Double[][] offspring_fitness_full2 = new Double[offspring_population2
										.size()][column_size7];

								int updates2 = 0;

								List<String> best_column2 = new ArrayList<String>();

								while (updates2 < offspring_population2.size()) {

									List<Double> updatedfitness2 = new ArrayList<Double>();

									updatedfitness2 = benchmarkfunction(updated_offspring2[updates2], fun_num,
											traverse_template);

									List<Double> fitness_objectives_updated2 = new ArrayList<Double>();

									for (int copu = 1; copu < updatedfitness2.size(); copu++) {

										fitness_objectives_updated2.add(updatedfitness2.get(copu));
									}

									List<Double> temp_child_4 = new ArrayList<Double>();

									temp_child_4.addAll(fitness_objectives_updated2);

									fitnessmaps2.put(offspring_population2.get(updates2), temp_child_4);

									for (int ups = 0; ups < fitness_objectives_updated2.size(); ups++) {

										offspring_fitness_full2[updates2][ups] = fitness_objectives_updated2.get(ups);

									}

									updates2++;

								}

								int cols_8 = (PATHNUM - (pathcounter.get(traverse_template)));

								int sizes2 = (cols_8);

								double row_fit2;
								int colums2 = 0;
								String test_case2;
								double fit_rowfit_2;
								double minval2;

								while (colums2 < sizes2) {
									for (int get_row = 0; get_row < offspring_population2.size(); get_row++) {

										fit_rowfit_2 = (offspring_fitness_full2[get_row][colums2]);
										row_fit2 = fit_rowfit_2;

										double fitz = row_fit2;

										row_getter7.put(offspring_population2.get(get_row), fitz);

									}

									Map<String, Double> result_ = row_getter7.entrySet().stream()
											.sorted(Map.Entry.comparingByValue())
											.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));

									Iterator<Map.Entry<String, Double>> best_col = result_.entrySet().iterator();

									while (best_col.hasNext()) {

										Map.Entry<String, Double> entry = best_col.next();

										test_case2 = entry.getKey();

										if (!best_column2.contains(test_case2)) {

											best_column2.add(test_case2);

											break;
										}

									}

									result_.clear();
									row_getter7.clear();
									colums2++;

								}

								List<String> fitness_objectives_comparator2 = new ArrayList<String>();
								// List<Double> fitness_objectives_p = new ArrayList<Double>();
								// List<Double> fitness_objectives_q= new ArrayList<Double>();

								for (int next_front = 0; next_front < offspring_population2.size(); next_front++) {

									if (!best_column2.contains(offspring_population2.get(next_front))) {

										fitness_objectives_comparator2.add(offspring_population2.get(next_front));
									}
								}
								// System.out.println("other items" +fitness_objectives_comparator2.size());

								int distance_zero2;

								// front_getter1 = fitnessmaps.get((front_list.get(ind_d)));
								// process the best test cases here

								/************************************************************************************************************************************************************/
								List<Double> front_0_1_1 = new ArrayList<Double>();

								List<Double> front_0_2_1 = new ArrayList<Double>();
								// child_map_3

								double[][] distance_matrix_zero2 = new double[best_column2.size()][best_column2.size()];

								if ((best_column2.size()) > 1) {

									int best;
									for (best = 0; best < (best_column2.size()); best++) {

										front_0_1_1 = fitnessmaps2.get(best_column2.get(best));

										for (int ind_d = 0; ind_d < best_column2.size(); ind_d++) {

											if (!(best_column2.get(best).equals(best_column2.get(ind_d)))) {

												front_0_2_1 = fitnessmaps2.get(best_column2.get(ind_d));

												distance_zero2 = get_count(front_0_1_1, front_0_2_1);

												int temp_dis_ = distance_zero2;

												distance_matrix_zero2[best][ind_d] = temp_dis_;

											}

										}

									}

									LinkedHashMap<String, Double> setdistance_zero_2 = new LinkedHashMap<String, Double>();

									for (int font_ = 0; font_ < best_column2.size(); font_++) {

										double zeros = 0.0;

										setdistance_zero_2.put(best_column2.get(font_), zeros);

									}

									for (int font_i = 0; font_i < (best_column2.size()); font_i++) {

										for (int font_j = 0; font_j < best_column2.size(); font_j++) {

											if (!(best_column2.get(font_i).equals(best_column2.get(font_j)))) {

												if (setdistance_zero_2.get(best_column2
														.get(font_i)) < distance_matrix_zero2[font_i][font_j]) {

													double dis2 = (distance_matrix_zero2[font_i][font_j]);

													setdistance_zero_2.put(best_column2.get(font_i), dis2);

												}
											}
										}

									}

									// System.out.print("hohoho"+setdistance_zero_2);

									Map<String, Double> result = setdistance_zero_2.entrySet().stream()
											.sorted(Map.Entry.comparingByValue())
											.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));

									// error with the sorting
									// System.out.print("hohoho"+result);

									for (Map.Entry<String, Double> entry : result.entrySet()) {

										if (updated_population.size() < pop_num) {
											updated_population.add(entry.getKey());
										}

										else {

											break;
										}

									}
									// if (updated_population.size() == pop_num) {

									// break;
									// }
									result.clear();

								}

								else { // process the only item in the best set

									if (!best_column2.isEmpty()) {

										String item_one = best_column2.get(0);

										if (updated_population.size() < pop_num) {

											updated_population.add(item_one);
										}

									}
								}

								if ((fitness_objectives_comparator2.size()) > 1) {

									int[] dominateMe2 = new int[fitness_objectives_comparator2.size()];

									// front[i] contains the list of individuals belonging to the front i
									@SuppressWarnings("unchecked")
									List<Integer>[] front2 = new List[(fitness_objectives_comparator2.size() + 1)];

									// iDominate[k] contains the list of solutions dominated by k

									@SuppressWarnings("unchecked")
									List<Integer>[] iDominate2 = new List[fitness_objectives_comparator2.size()];

									int flagDominate2;

									// int remain = pop_num;

									// int fit_size;
									// -> Fast non dominated sorting algorithm

									for (int i = 0; i < ((front2.length)); i++) {

										front2[i] = new LinkedList<Integer>();
									}

									for (int p = 0; p < fitness_objectives_comparator2.size(); p++) {
										// Initialize the list of individuals that i dominate and the number
										// of individuals that dominate me
										iDominate2[p] = new LinkedList<Integer>();
										dominateMe2[p] = 0;
									}

									int G = fitness_objectives_comparator2.size();
									// int[][] dominanceChecks2 = new int[G][G];

									for (int p = 0; p < (G - 1); p++) {

										List<Double> fitness_temporary_p2 = new ArrayList<Double>();

										fitness_temporary_p2 = fitnessmaps2
												.get((fitness_objectives_comparator2.get(p)));

										for (int q = p + 1; q < G; q++) {
											// if (p != q) {

											List<Double> fitness_temporary_q2 = new ArrayList<Double>();

											fitness_temporary_q2 = fitnessmaps2
													.get((fitness_objectives_comparator2.get(q)));

											flagDominate2 = frontdominace_Comparison(fitness_temporary_p2,
													fitness_temporary_q2);

											if (flagDominate2 == -1) {

												iDominate2[p].add(q);
												dominateMe2[q]++;

											}

											else if (flagDominate2 == 1) {

												iDominate2[q].add(p);
												dominateMe2[p]++;
											}

											else {

												List<Double> fitness_temporary_qq = new ArrayList<Double>();
												List<Double> fitness_temporary_pp = new ArrayList<Double>();

												Collections.sort(fitness_temporary_p2);

												fitness_temporary_pp.addAll(fitness_temporary_p2);

												Collections.sort(fitness_temporary_q2);

												fitness_temporary_qq.addAll(fitness_temporary_q2);

												if (fitness_temporary_pp.get(0) < fitness_temporary_qq.get(0)) {
													// System.out.println("p---dominates>>>>>" );
													iDominate2[p].add(q);
													dominateMe2[q]++;

												}

												else if (fitness_temporary_qq.get(0) < fitness_temporary_pp.get(0)) {
													// System.out.println("q---dominates>>>>>" );
													iDominate2[q].add(p);
													dominateMe2[p]++;
												}

											}

										}
									}

									for (int p = 0; p < ((fitness_objectives_comparator2.size())); p++) {

										if (dominateMe2[p] == 0) {
											front2[0].add(p);

											// setrank.put(Integer.parseInt(fitness_objectives_comparator.get(p)), 1);

											int valzz = 0;

											setrank2.put(fitness_objectives_comparator2.get(p), valzz);

											// offspring_population.get(p).setRank(0);
											// can use a map
										}
									}
									// System.out.println("front_listing_@2: " +front2[1]);
									int font_s1 = 0;
									// if((front2[font_s1].size() != 0)) {

									Iterator<Integer> it1_, it2_; // Iterators
									while (front2[font_s1].size() != 0) {
										/// System.out.println("we got here" + front[font_s]);
										font_s1++;
										it1_ = front2[font_s1 - 1].iterator();
										while (it1_.hasNext()) {
											it2_ = iDominate2[(it1_.next())].iterator();
											while (it2_.hasNext()) {
												int index = it2_.next();
												dominateMe2[index]--;
												if (dominateMe2[index] == 0) {
													front2[font_s1].add(index);
													// offspring_population.get(index).setRank(i);
													setrank2.put(fitness_objectives_comparator2.get(index), font_s1);
												}
											}

										}

									}

									// }

									LinkedHashMap<String, Double> setdistance_two_2 = new LinkedHashMap<String, Double>();

									LinkedHashMap<String, Double> setdistance_one_2 = new LinkedHashMap<String, Double>();

									List<String> front_list_one_2 = new ArrayList<String>();

									Map<Integer, ArrayList<String>> reverseMap_2 = new HashMap<>();

									for (Map.Entry<String, Integer> entry : setrank2.entrySet()) {
										if (!reverseMap_2.containsKey(entry.getValue())) {
											reverseMap_2.put(entry.getValue(), new ArrayList<>());
										}
										ArrayList<String> keys = reverseMap_2.get(entry.getValue());
										keys.add(entry.getKey());
										reverseMap_2.put(entry.getValue(), keys);
									}

									int smaller_2;
									int smaller_ones_;

									int fronts_2 = 0;

									while (fronts_2 < (reverseMap_2.size())) {

										if (updated_population.size() > pop_num) {

											break;
										}

										if (fronts_2 != (reverseMap_2.size() - 1)) {

											List<String> front_list_2 = new ArrayList<String>();
											// get all the individuals at fronts
											front_list_2 = reverseMap_2.get(fronts_2);
											// System.out.println(front_list);
											if (front_list_2.size() > 1) {

												double[][] distance_matrix = new double[front_list_2
														.size()][front_list_2.size()];

												for (int ind_d = 0; ind_d < (front_list_2.size()); ind_d++) {

													List<Double> front_getter_2 = new ArrayList<Double>();

													front_getter_2 = fitnessmaps2.get((front_list_2.get(ind_d)));

													for (int d = 0; d < front_list_2.size(); d++) {

														if (!(front_list_2.get(ind_d).equals(front_list_2.get(d)))) {

															List<Double> front_getter_7 = new ArrayList<Double>();

															front_getter_7 = fitnessmaps2.get((front_list_2.get(d)));

															smaller_2 = get_count(front_getter_2, front_getter_7);

															int dss = smaller_2;

															distance_matrix[ind_d][d] = dss;

														}

													}

												}

												for (int font_ = 0; font_ < front_list_2.size(); font_++) {

													double c = 0.0;

													setdistance_one_2.put(front_list_2.get(font_), c);

												}

												// all distances set

												for (int font_i = 0; font_i < front_list_2.size(); font_i++) {

													// distance_matrix

													for (int font_j = 0; font_j < front_list_2.size(); font_j++) {

														if (!(front_list_2.get(font_i)
																.equals(front_list_2.get(font_j)))) {

															if (setdistance_one_2.get(front_list_2
																	.get(font_i)) < distance_matrix[font_i][font_j]) {

																double dist2 = (distance_matrix[font_i][font_j]);

																setdistance_one_2.put(front_list_2.get(font_i), dist2);

															}
														}
													}

												}

												Map<String, Double> result_2 = setdistance_one_2.entrySet().stream()
														.sorted(Map.Entry.comparingByValue())
														.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
																(oldValue, newValue) -> oldValue, LinkedHashMap::new));

												// result hold the sorted map

												Iterator<Map.Entry<String, Double>> iteration_2 = result_2.entrySet()
														.iterator();

												while (iteration_2.hasNext()) {

													Map.Entry<String, Double> entry = iteration_2.next();

													if (updated_population.size() < pop_num) {
														updated_population.add(entry.getKey());
													}

													else {

														break;
													}

												}

												result_2.clear();

											}

											else { // process the only item in the best set

												if (!front_list_2.isEmpty()) {

													String item_one2 = front_list_2.get(0);

													if (front_list_2.size() < pop_num) {

														updated_population.add(item_one2);
													}

												}

											}

										}

										if (fronts_2 == (reverseMap_2.size() - 1)) {

											front_list_one_2 = reverseMap_2.get(reverseMap_2.size() - 1);

											// System.out.println("hahahq" +front_list_one);

											double[][] distance_matrix_one = new double[front_list_one_2
													.size()][front_list_one_2.size()];

											for (int ind_w = 0; ind_w < (front_list_one_2.size()); ind_w++) {

												List<Double> front_getter_2_ = new ArrayList<Double>();

												front_getter_2_ = fitnessmaps2.get((front_list_one_2.get(ind_w)));

												for (int dw = 0; dw < front_list_one_2.size(); dw++) {

													if (!(front_list_one_2.get(ind_w)
															.equals(front_list_one_2.get(dw)))) {

														List<Double> front_getter_7_ = new ArrayList<Double>();

														front_getter_7_ = fitnessmaps2.get((front_list_one_2.get(dw)));

														smaller_ones_ = get_count(front_getter_2_, front_getter_7_);

														distance_matrix_one[ind_w][dw] = smaller_ones_;

													}

												}

											}

											for (int font_ = 0; font_ < front_list_one_2.size(); font_++) {

												double dist4 = 0.0;

												setdistance_two_2.put(front_list_one_2.get(font_), dist4);

											}

											// all distances set

											for (int font_i = 0; font_i < (front_list_one_2.size()); font_i++) {

												// distance_matrix

												for (int font_j = 0; font_j < front_list_one_2.size(); font_j++) {

													if (!(front_list_one_2.get(font_i)
															.equals(front_list_one_2.get(font_j)))) {

														if (setdistance_two_2.get(front_list_one_2
																.get(font_i)) < distance_matrix_one[font_i][font_j]) {

															double bist = (distance_matrix_one[font_i][font_j]);

															setdistance_two_2.put(front_list_one_2.get(font_i), bist);

														}
													}
												}

											}

											int remaining2 = (pop_num - updated_population.size());

											if (setdistance_two_2.size() <= remaining2) {

												Map<String, Double> result = setdistance_two_2.entrySet().stream()
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

											else {

												// System.out.println( "remaining---" +remaining);

												Map<String, Double> sortedByValueDesc = setdistance_two_2.entrySet()
														.stream()
														.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
														.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
																(e1, e2) -> e1, LinkedHashMap::new));

												List<String> front_remove = new ArrayList<String>();

												Set<String> keytest2 = sortedByValueDesc.keySet();

												int final_size = sortedByValueDesc.size();

												for (String keysss : keytest2) {

													if (final_size > remaining2) {

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
													}
												}

											}

										}

										setdistance_two_2.clear();
										setdistance_one_2.clear();
										fronts_2++;
									}

								}

								else {

									if (!fitness_objectives_comparator2.isEmpty()) {

										if (updated_population.size() < pop_num) {

											String comparator2 = fitness_objectives_comparator2.get(0);

											updated_population.add(comparator2);
										}

									}

								}

								/****************************************************************************************************************************/
								// System.out.println("block-2"+updated_population.size());

								String updated_id;

								int updated_val;

								// int rem;

								for (int pop = 0; pop < updated_population.size(); pop++) {

									if (pop == 50) {

										break;

									}

									String[] updated_pop = (updated_population.get(pop).split(" "));
									updated_id = updated_pop[0];
									updated_val = Integer.parseInt(updated_pop[1]);

									if (updated_id.equals("parent")) {
										for (int update_parent = 0; update_parent < R; update_parent++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_parent] = x[updated_val][update_parent];
										}
									}
									if (updated_id.equals("child")) {
										for (int update_child = 0; update_child < R; update_child++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_child] = v[updated_val][update_child];
										}
									}

								}

							}

							if (offspring_population.isEmpty() && (!offspring_population2.isEmpty())) {

								int[][] updated_offspring = new int[offspring_population2.size()][R];

								String status;
								int status_index;
								// populate the array accordingly
								for (int update = 0; update < offspring_population2.size(); update++) {

									String[] split_offspring = offspring_population2.get(update).split(" ");

									status = split_offspring[0];
									status_index = Integer.parseInt(split_offspring[1]);

									// System.out.println( status + " " +status_index);

									if (status.equals("parent")) {
										for (int parent = 0; parent < R; parent++) {
											// x[i][j] = v[i][j] ;

											updated_offspring[update][parent] = x[status_index][parent];
										}
									}

									else if (status.equals("child")) {
										for (int child = 0; child < R; child++) {
											// x[i][j] = v[i][j] ;

											updated_offspring[update][child] = v[status_index][child];
										}
									}

								}

								// }
								LinkedHashMap<String, Double> row_getter = new LinkedHashMap<String, Double>();
								// map to hold each column value.
								double priority;
								int newsize = 0;

								int temp_ = (PATHNUM - pathcounter.get(traverse_template));

								int column_size = ((temp_));

								Double[][] offspring_fitness_full = new Double[offspring_population2
										.size()][column_size];

								// String[] fit_obj;
								int updates = 0;

								// List<String> traverse_group = new ArrayList<String>();
								List<String> best_column3 = new ArrayList<String>();

								while (updates < offspring_population2.size()) {

									List<Double> updatedfitness = new ArrayList<Double>();

									updatedfitness = benchmarkfunction(updated_offspring[updates], fun_num,
											traverse_template);

									List<Double> fitness_objectives_updated = new ArrayList<Double>();

									for (int copu = 1; copu < updatedfitness.size(); copu++) {

										fitness_objectives_updated.add(updatedfitness.get(copu));
									}

									List<Double> temp_child_5 = new ArrayList<Double>();

									temp_child_5.addAll(fitness_objectives_updated);

									fitnessmaps3.put(offspring_population2.get(updates), temp_child_5);

									for (int ups = 0; ups < fitness_objectives_updated.size(); ups++) {

										offspring_fitness_full[updates][ups] = fitness_objectives_updated.get(ups);

									}

									updates++;

								}

								int temp_1 = (PATHNUM - (pathcounter.get(traverse_template)));

								int sizes = ((temp_1));

								double row_fit;
								int colums = 0;
								String test_case;
								double fit_rowfit;
								double minval;

								while (colums < sizes) {
									for (int get_row = 0; get_row < offspring_population2.size(); get_row++) {

										fit_rowfit = (offspring_fitness_full[get_row][colums]);
										row_fit = fit_rowfit;

										double fitz = row_fit;

										row_getter.put(offspring_population2.get(get_row), fitz);

									}

									Map<String, Double> result_ = row_getter.entrySet().stream()
											.sorted(Map.Entry.comparingByValue())
											.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
													(oldValue, newValue) -> oldValue, LinkedHashMap::new));

									Iterator<Map.Entry<String, Double>> best_col = result_.entrySet().iterator();

									while (best_col.hasNext()) {

										Map.Entry<String, Double> entry = best_col.next();

										test_case = entry.getKey();

										if (!best_column3.contains(test_case)) {

											best_column3.add(test_case);

											break;
										}

									}
									result_.clear();
									row_getter.clear();
									colums++;

								}

								List<String> fitness_objectives_comparator = new ArrayList<String>();

								for (int next_front = 0; next_front < offspring_population2.size(); next_front++) {

									if (!best_column3.contains(offspring_population2.get(next_front))) {

										fitness_objectives_comparator.add(offspring_population2.get(next_front));
									}
								}

								int distance_zero3;

								// front_getter1 = fitnessmaps.get((front_list.get(ind_d)));
								// process the best test cases here

								/************************************************************************************************************************************************************/
								List<Double> front_0_1_3 = new ArrayList<Double>();

								List<Double> front_0_2_3 = new ArrayList<Double>();
								// child_map_3

								double[][] distance_matrix_zero3 = new double[best_column3.size()][best_column3.size()];

								if (best_column3.size() > 1) {

									int best;
									for (best = 0; best < (best_column3.size()); best++) {

										front_0_1_3 = fitnessmaps3.get(best_column3.get(best));

										// front_getter1 = fitnessmaps.get((front_list.get(ind_d)));

										for (int ind_d = 0; ind_d < best_column3.size(); ind_d++) {

											if (!(best_column3.get(best).equals(best_column3.get(ind_d)))) {

												front_0_2_3 = fitnessmaps3.get(best_column3.get(ind_d));

												distance_zero3 = get_count(front_0_1_3, front_0_2_3);

												int temp_dis_3 = distance_zero3;

												distance_matrix_zero3[best][ind_d] = temp_dis_3;

											}

										}

									}

									LinkedHashMap<String, Double> setdistance_zero_3 = new LinkedHashMap<String, Double>();

									for (int font_ = 0; font_ < best_column3.size(); font_++) {

										double zeros = 0.0;

										setdistance_zero_3.put(best_column3.get(font_), zeros);

									}

									for (int font_i = 0; font_i < (best_column3.size()); font_i++) {

										for (int font_j = 0; font_j < best_column3.size(); font_j++) {

											if (!(best_column3.get(font_i).equals(best_column3.get(font_j)))) {

												if (setdistance_zero_3.get(best_column3
														.get(font_i)) < distance_matrix_zero3[font_i][font_j]) {

													double dis3 = (distance_matrix_zero3[font_i][font_j]);

													setdistance_zero_3.put(best_column3.get(font_i), dis3);

												}
											}
										}

									}

									Map<String, Double> result = setdistance_zero_3.entrySet().stream()
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

								else { // process the only item in the best set

									if (!best_column3.isEmpty()) {

										String item_one = best_column3.get(0);

										if (updated_population.size() < pop_num) {

											updated_population.add(item_one);
										}

									}

								}

								int[] dominateMe = new int[fitness_objectives_comparator.size()];

								// front[i] contains the list of individuals belonging to the front i
								@SuppressWarnings("unchecked")
								List<Integer>[] front = new List[fitness_objectives_comparator.size() + 1];

								// iDominate[k] contains the list of solutions dominated by k

								@SuppressWarnings("unchecked")
								List<Integer>[] iDominate = new List[fitness_objectives_comparator.size()];

								int flagDominate;
								int minimum_sorter3;
								// int fit_size;
								// -> Fast non dominated sorting algorithm

								for (int i = 0; i < ((front.length)); i++) {
									front[i] = new LinkedList<Integer>();
								}

								for (int p = 0; p < fitness_objectives_comparator.size(); p++) {
									// Initialize the list of individuals that i dominate and the number
									// of individuals that dominate me
									iDominate[p] = new LinkedList<Integer>();
									dominateMe[p] = 0;
								}

								int N = fitness_objectives_comparator.size();
								// int[][] dominanceChecks = new int[N][N];

								for (int p = 0; p < N - 1; p++) {

									List<Double> fitness_temporary_p = new ArrayList<Double>();

									fitness_temporary_p = fitnessmaps3.get((fitness_objectives_comparator.get(p)));

									for (int q = p + 1; q < N; q++) {
										// if (p != q) {
										List<Double> fitness_temporary_q = new ArrayList<Double>();

										// fitness_temporary_q.clear();

										fitness_temporary_q = fitnessmaps3.get((fitness_objectives_comparator.get(q)));

										flagDominate = frontdominace_Comparison(fitness_temporary_p,
												fitness_temporary_q);

										if (flagDominate == -1) {

											iDominate[p].add(q);
											dominateMe[q]++;

										}

										else if (flagDominate == 1) {

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

										int lav = 0;

										setrank3.put(fitness_objectives_comparator.get(p), lav);

										// offspring_population.get(p).setRank(0);
										// can use a map
									}
								}

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
												// offspring_population.get(index).setRank(i);
												setrank3.put(fitness_objectives_comparator.get(index), font_s);
											}
										}

									}

								}

								// }

								LinkedHashMap<String, Double> setdistance3 = new LinkedHashMap<String, Double>();
								// LinkedHashMap<String, Double> sorted_map3 = new LinkedHashMap<String,
								// Double>();

								// LinkedHashMap<String, Double> setdistance_two3 = new LinkedHashMap<String,
								// Double>();

								LinkedHashMap<String, Double> setdistance_one3 = new LinkedHashMap<String, Double>();
								// LinkedHashMap<String, Double> sorted_map_one3 = new LinkedHashMap<String,
								// Double>();

								// LinkedHashMap<Integer, Integer> final_sorted_map = new LinkedHashMap<Integer,
								// Integer>();
								List<Double> front_getter41 = new ArrayList<Double>();
								List<Double> front_getter42 = new ArrayList<Double>();

								List<String> front_list4 = new ArrayList<String>();

								// List<String> front_list_two4 = new ArrayList<String>();

								List<String> front_list_one4 = new ArrayList<String>();

								List<Double> front_getter_one4 = new ArrayList<Double>();
								List<Double> front_getter_two4 = new ArrayList<Double>();

								Map<Integer, ArrayList<String>> reverseMap4 = new HashMap<>();

								for (Map.Entry<String, Integer> entry : setrank3.entrySet()) {
									if (!reverseMap4.containsKey(entry.getValue())) {
										reverseMap4.put(entry.getValue(), new ArrayList<>());
									}
									ArrayList<String> keys = reverseMap4.get(entry.getValue());
									keys.add(entry.getKey());
									reverseMap4.put(entry.getValue(), keys);
								}

								// process fonts

								int smaller4;
								int smaller_one4;

								int fronts = 0;
								// System.out.println("map's size" + reverseMap.size());
								while (fronts < (reverseMap4.size())) {

									if (updated_population.size() > pop_num) {

										break;
									}

									if (fronts != (reverseMap4.size() - 1)) {

										// get all the individuals at fronts
										front_list4 = reverseMap4.get(fronts);
										// System.out.println(front_list);

										if (front_list4.size() > 1) {
											double[][] distance_matrix = new double[front_list4.size()][front_list4
													.size()];

											for (int ind_d = 0; ind_d < front_list4.size(); ind_d++) {

												front_getter41 = fitnessmaps3.get((front_list4.get(ind_d)));

												for (int d = 0; d < front_list4.size(); d++) {

													front_getter42 = fitnessmaps3.get((front_list4.get(d)));

													if (!(front_list4.get(ind_d).equals(front_list4.get(d)))) {

														smaller4 = get_count(front_getter41, front_getter42);

														distance_matrix[ind_d][d] = smaller4;

													}

												}

											}

											for (int font_ = 0; font_ < front_list4.size(); font_++) {

												setdistance3.put(front_list4.get(font_), 0.0);

											}

											// all distances set

											for (int font_i = 0; font_i < front_list4.size(); font_i++) {

												// distance_matrix

												for (int font_j = 0; font_j < front_list4.size(); font_j++) {

													if (!(front_list4.get(font_i).equals(front_list4.get(font_j)))) {

														if (setdistance3.get(front_list4
																.get(font_i)) < distance_matrix[font_i][font_j]) {

															double dist4 = distance_matrix[font_i][font_j];

															setdistance3.put(front_list4.get(font_i), dist4);

														}
													}
												}

											}

											Map<String, Double> result = setdistance3.entrySet().stream()
													.sorted(Map.Entry.comparingByValue())
													.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
															(oldValue, newValue) -> oldValue, LinkedHashMap::new));

											// result hold the sorted map

											Iterator<Map.Entry<String, Double>> iteration = result.entrySet()
													.iterator();

											while (iteration.hasNext()) {

												Map.Entry<String, Double> entry = iteration.next();

												if (updated_population.size() < pop_num) {
													updated_population.add(entry.getKey());
												}

											}

											// result.clear();

										}

										else { // process the only item in the best set

											String item_on = front_list4.get(0);

											if (updated_population.size() < pop_num) {

												updated_population.add(item_on);
											}

										}

									}
									if (fronts == (reverseMap4.size() - 1)) {
										// System.out.println("fronts" + " " + fronts );
										// get all the individuals at fronts
										front_list_one4 = reverseMap4.get(reverseMap4.size() - 1);

										// System.out.println("hahahq" +front_list_one);
										if (front_list_one4.size() > 1) {
											double[][] distance_matrix_one = new double[front_list_one4
													.size()][front_list_one4.size()];

											for (int ind_w = 0; ind_w < front_list_one4.size(); ind_w++) {

												front_getter_one4 = fitnessmaps3.get((front_list_one4.get(ind_w)));

												for (int dw = 0; dw < front_list_one4.size(); dw++) {

													front_getter_two4 = fitnessmaps3.get((front_list_one4.get(dw)));

													if (!(front_list_one4.get(ind_w).equals(front_list_one4.get(dw)))) {

														smaller_one4 = get_count(front_getter_one4, front_getter_two4);

														int sm4 = smaller_one4;

														distance_matrix_one[ind_w][dw] = sm4;

													}

												}

											}

											for (int font_ = 0; font_ < front_list_one4.size(); font_++) {

												setdistance_one3.put(front_list_one4.get(font_), 0.0);

											}

											// all distances set

											for (int font_i = 0; font_i < front_list_one4.size(); font_i++) {

												// distance_matrix

												for (int font_j = 0; font_j < front_list_one4.size(); font_j++) {

													if (!(front_list_one4.get(font_i)
															.equals(front_list_one4.get(font_j)))) {

														if (setdistance_one3.get(front_list_one4
																.get(font_i)) < distance_matrix_one[font_i][font_j]) {

															double diss4 = distance_matrix_one[font_i][font_j];

															setdistance_one3.put(front_list_one4.get(font_i), diss4);

														}
													}
												}

											}

											int remaining_4;
											remaining_4 = (pop_num - updated_population.size());

											if (setdistance_one3.size() <= remaining_4) {

												Map<String, Double> result = setdistance_one3.entrySet().stream()
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
												Map<String, Double> sortedByValueDesc = setdistance_one3.entrySet()
														.stream()
														.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
														.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
																(e1, e2) -> e1, LinkedHashMap::new));

												List<String> front_remove = new ArrayList<String>();

												Set<String> keytest = sortedByValueDesc.keySet();

												int final_size = sortedByValueDesc.size();

												// while(sortedByValueDesc.size() > remaining) {

												for (String keysss : keytest) {

													if (final_size > remaining_4) {

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
													}
												}

											}

										}

										else { // process the only item in the best set

											if (!front_list_one4.isEmpty()) {

												String item_on = front_list_one4.get(0);

												if (updated_population.size() < pop_num) {

													updated_population.add(item_on);
												}

											}
										}

									}

									setdistance3.clear();
									setdistance_one3.clear();

									fronts++;
								}

								String updated_id;

								int updated_val;

								for (int pop = 0; pop < updated_population.size(); pop++) {

									if (pop == 50) {

										break;
									}

									String[] updated_pop = (updated_population.get(pop).split(" "));
									updated_id = updated_pop[0];
									updated_val = Integer.parseInt(updated_pop[1]);

									if (updated_id.equals("parent")) {
										for (int update_parent = 0; update_parent < R; update_parent++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_parent] = x[updated_val][update_parent];
										}
									}
									if (updated_id.equals("child")) {
										for (int update_child = 0; update_child < R; update_child++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_child] = v[updated_val][update_child];
										}
									}

								}

							}

							updated_population.clear();
							offspring_population.clear();
							offspring_population2.clear();
							setrank1.clear();
							setrank2.clear();
							setrank3.clear();
							fitnessmaps.clear();
							fitnessmaps1.clear();
							fitnessmaps2.clear();
							fitnessmaps3.clear();
							single_population.clear();
							// fitnessmaps2.clear();

							Cycle[run]++;
						}
					} 
					
					else {

						Cycle[run]++;
						break;

					}

				}

			}

			System.out.println("NO. of cycles=" + (Cycle[run] - 1)); // ���Number of Cycle
			coverage[run] = totalpathcounter * 100 / TOTAL_PATHNUM; // percentage of paths covered per run
			System.out.println("Path coverage=" + coverage[run] + "%");
			System.out.println("The optimal solution is");
			System.out.println("template 1(bbbb): ");
			for (

					int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_1[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_1[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 2(bbba): ");

			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_2[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_2[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 3(bbab): ");

			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_3[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_3[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 4(bbaa): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_4[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_4[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 5(babb): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_5[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_5[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 6(baba): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_6[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_6[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 7(baab): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_7[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_7[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 8(baaa): ");

			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_8[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_8[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 9(abbb): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_9[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_9[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 10(abba): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_10[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_10[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 11(abab): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_11[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_11[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 12(abaa): ");

			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_12[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_12[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 13(aabb): ");

			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_13[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_13[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 14(aaba): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_14[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_14[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 15(aaab): ");
			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_15[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_15[a][j] + " ");
					System.out.println();
				} else
					System.out.println("path" + a + "Not covered.");
			}

			System.out.println("template 16(aaaa): ");

			for (int a = 0; a < PATHNUM; a++) // Output the result
			{
				if (statu_16[a]) {
					System.out.print("path" + a + ":");
					for (int j = 0; j < R; j++)
						System.out.print(solution_16[a][j] + " ");
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

		int[] a = new int[RUN];
		for (int run = 0; run < RUN; run++)
			a[run] = total_case_num[run];
		for (int run = 0; run < RUN; run++) {
			int min = run;
			for (int b = run + 1; b < RUN; b++)
				if (a[min] > a[b])
					min = b;
			if (run != min) {
				int tmp = a[min];
				a[min] = a[run];
				a[run] = tmp;
			}
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

	public static List<Double> benchmarkfunction(int[] trix, int func_num, String template_id)
			throws FileNotFoundException // evaluation_of_fitness_for

	{
		double[][] fitness_matrix = new double[NODENUM][R];
		List<Double> fit = new ArrayList<Double>();
		boolean[][] benchmark_table_visit = new boolean[NODENUM][R];
		if (func_num == 1) {// evaluate divergence at the edge of the vertex per iteration ...

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
					v1 = (max1 - a5[j]) + K;

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

					v2 = (a6[j] - max2) + K;

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

			nonsimple_violation = final_vertex_path.substring(0, Math.min(final_vertex_path.length(), pattern_number));
			// myText.substring(0, Math.min(6, myText.length())

			//if (!nonsimple_violation.equals(template_id)) {

			
			if (!final_vertex_path.startsWith(template_id)) {
				
				
				String strLine_non_simple;
				fit.add(non_simpleid);

				Iterator<Map.Entry<String, Boolean>> iter_simple = temporary_path_holder.entrySet().iterator();

				while (iter_simple.hasNext()) {

					Map.Entry<String, Boolean> entry = iter_simple.next();

					strLine_non_simple = entry.getKey();

					if (!paths.get(strLine_non_simple)) {

						double Unmatched_branch_node_a = 0.0;
						double Unmatched_branch_node_b = 0.0;
						// traversed_violation = strLine_non.substring(strLine_non.length() - 5);

						int index = 0;
						// double unwinding2 = 0.0;
						for (int i = 0; i < 10; i++) {
							index++;
							if (final_vertex_path.charAt(i) != strLine_non_simple.charAt(i)) {

								if (strLine_non_simple.charAt(i) == 'a') {
									
									
									Unmatched_branch_node_a += fitness_matrix[0][index];

								}
								
								
							    if (strLine_non_simple.charAt(i) == 'b') {
									
									
									Unmatched_branch_node_b += fitness_matrix[1][index];

								}
								
							}
								
						}
						double nonsimple_unmatched2 = 0.0;
						nonsimple_unmatched2 = Unmatched_branch_node_a + Unmatched_branch_node_b;
						fit.add(nonsimple_unmatched2);
					}
					
				}

			}

			if (final_vertex_path.startsWith(template_id)) {

				String strLine_non;
				fit.add(non_simpleid2);

				Iterator<Map.Entry<String, Boolean>> iter_simple_ = temporary_path_holder.entrySet().iterator();

				while (iter_simple_.hasNext()) {

					Map.Entry<String, Boolean> entry = iter_simple_.next();

					strLine_non = entry.getKey();

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
					// else {

					// System.out.println("covered already" +strLine_non);

					// }
					// end try close file
				}
			}

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

		FileOutputStream fos_1 = new FileOutputStream(id_1);
		BufferedWriter bw_1 = new BufferedWriter(new OutputStreamWriter(fos_1));
		FileOutputStream fos_2 = new FileOutputStream(id_2);
		BufferedWriter bw_2 = new BufferedWriter(new OutputStreamWriter(fos_2));
		FileOutputStream fos_3 = new FileOutputStream(id_3);
		BufferedWriter bw_3 = new BufferedWriter(new OutputStreamWriter(fos_3));
		FileOutputStream fos_4 = new FileOutputStream(id_4);
		BufferedWriter bw_4 = new BufferedWriter(new OutputStreamWriter(fos_4));
		FileOutputStream fos_5 = new FileOutputStream(id_5);
		BufferedWriter bw_5 = new BufferedWriter(new OutputStreamWriter(fos_5));
		FileOutputStream fos_6 = new FileOutputStream(id_6);
		BufferedWriter bw_6 = new BufferedWriter(new OutputStreamWriter(fos_6));
		FileOutputStream fos_7 = new FileOutputStream(id_7);
		BufferedWriter bw_7 = new BufferedWriter(new OutputStreamWriter(fos_7));
		FileOutputStream fos_8 = new FileOutputStream(id_8);
		BufferedWriter bw_8 = new BufferedWriter(new OutputStreamWriter(fos_8));
		FileOutputStream fos_9 = new FileOutputStream(id_9);
		BufferedWriter bw_9 = new BufferedWriter(new OutputStreamWriter(fos_9));
		FileOutputStream fos_10 = new FileOutputStream(id_10);
		BufferedWriter bw_10 = new BufferedWriter(new OutputStreamWriter(fos_10));
		FileOutputStream fos_11 = new FileOutputStream(id_11);
		BufferedWriter bw_11 = new BufferedWriter(new OutputStreamWriter(fos_11));
		FileOutputStream fos_12 = new FileOutputStream(id_12);
		BufferedWriter bw_12 = new BufferedWriter(new OutputStreamWriter(fos_12));
		FileOutputStream fos_13 = new FileOutputStream(id_13);
		BufferedWriter bw_13 = new BufferedWriter(new OutputStreamWriter(fos_13));
		FileOutputStream fos_14 = new FileOutputStream(id_14);
		BufferedWriter bw_14 = new BufferedWriter(new OutputStreamWriter(fos_14));
		FileOutputStream fos_15 = new FileOutputStream(id_15);
		BufferedWriter bw_15 = new BufferedWriter(new OutputStreamWriter(fos_15));
		FileOutputStream fos_16 = new FileOutputStream(id_16);
		BufferedWriter bw_16 = new BufferedWriter(new OutputStreamWriter(fos_16));

		// pathcounter

		Set<String> keyz = paths.keySet();

		for (String key : keyz) {

			bw_all.write(key); // write to file
			bw_all.newLine();

			if (key.startsWith("aaab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_2.write(key); // write to file
				bw_2.newLine();

				// group2.put(key, false);

				if (!pathcounter.containsKey("aaab")) {

					pathcounter.put("aaab", 0);
					evaluated_status.put("aaab", false);
				}

			}

			if (key.startsWith("aaba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_3.write(key); // write to file
				bw_3.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("aaba")) {

					pathcounter.put("aaba", 0);
					evaluated_status.put("aaba", false);
				}

			}

			if (key.startsWith("aabb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_4.write(key); // write to file
				bw_4.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("aabb")) {

					pathcounter.put("aabb", 0);
					evaluated_status.put("aabb", false);
				}

			}

			if (key.startsWith("abaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_5.write(key); // write to file
				bw_5.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("abaa")) {

					pathcounter.put("abaa", 0);
					evaluated_status.put("abaa", false);
				}

			}

			if (key.startsWith("abab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_6.write(key); // write to file
				bw_6.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("abab")) {

					pathcounter.put("abab", 0);
					evaluated_status.put("abab", false);
				}

			}

			if (key.startsWith("abba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_7.write(key); // write to file
				bw_7.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("abba")) {

					pathcounter.put("abba", 0);
					evaluated_status.put("abba", false);
				}

			}

			if (key.startsWith("abbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_8.write(key); // write to file
				bw_8.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("abbb")) {

					pathcounter.put("abbb", 0);
					evaluated_status.put("abbb", false);
				}

			}

			if (key.startsWith("baaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_9.write(key); // write to file
				bw_9.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("baaa")) {

					pathcounter.put("baaa", 0);
					evaluated_status.put("baaa", false);
				}

			}

			if (key.startsWith("baab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_10.write(key); // write to file
				bw_10.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("baab")) {

					pathcounter.put("baab", 0);
					evaluated_status.put("baab", false);
				}

			}

			if (key.startsWith("baba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_11.write(key); // write to file
				bw_11.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("baba")) {

					pathcounter.put("baba", 0);
					evaluated_status.put("baba", false);
				}

			}

			if (key.startsWith("babb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_12.write(key); // write to file
				bw_12.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("babb")) {

					pathcounter.put("babb", 0);
					evaluated_status.put("babb", false);
				}
			}

			if (key.startsWith("bbaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_13.write(key); // write to file
				bw_13.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("bbaa")) {

					pathcounter.put("bbaa", 0);
					evaluated_status.put("bbaa", false);
				}

			}

			if (key.startsWith("bbab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_14.write(key); // write to file
				bw_14.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("bbab")) {

					pathcounter.put("bbab", 0);
					evaluated_status.put("bbab", false);
				}

			}

			if (key.startsWith("bbba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_15.write(key); // write to file
				bw_15.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("bbba")) {

					pathcounter.put("bbba", 0);
					evaluated_status.put("bbba", false);

				}

			}

			if (key.startsWith("bbbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_16.write(key); // write to file
				bw_16.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("bbbb")) {

					pathcounter.put("bbbb", 0);
					evaluated_status.put("bbbb", false);

				}

			}

			if (key.startsWith("aaaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_1.write(key); // write to file
				bw_1.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("aaaa")) {

					pathcounter.put("aaaa", 0);
					evaluated_status.put("aaaa", false);
				}

			}

			continue;
		}

		bw_all.close();
		bw_1.close();
		bw_2.close();
		bw_3.close();
		bw_4.close();
		bw_5.close();
		bw_6.close();
		bw_7.close();
		bw_8.close();
		bw_9.close();
		bw_10.close();
		bw_11.close();
		bw_12.close();
		bw_13.close();
		bw_14.close();
		bw_15.close();
		bw_16.close();

	}

	public static void reset_All() {
		// clear all the maps for next run and update them
		paths.clear();
		pathcounter.clear();
		evaluated_status.clear();
		dynamic_access.clear();

		pathcounter.put(template_1, 0);
		pathcounter.put(template_2, 0);
		pathcounter.put(template_3, 0);
		pathcounter.put(template_4, 0);
		pathcounter.put(template_5, 0);
		pathcounter.put(template_6, 0);
		pathcounter.put(template_7, 0);
		pathcounter.put(template_8, 0);
		pathcounter.put(template_9, 0);
		pathcounter.put(template_10, 0);
		pathcounter.put(template_11, 0);
		pathcounter.put(template_12, 0);
		pathcounter.put(template_13, 0);
		pathcounter.put(template_14, 0);
		pathcounter.put(template_15, 0);
		pathcounter.put(template_16, 0);

		evaluated_status.put(template_1, false);
		evaluated_status.put(template_2, false);
		evaluated_status.put(template_3, false);
		evaluated_status.put(template_4, false);
		evaluated_status.put(template_5, false);
		evaluated_status.put(template_6, false);
		evaluated_status.put(template_7, false);
		evaluated_status.put(template_8, false);
		evaluated_status.put(template_9, false);
		evaluated_status.put(template_10, false);
		evaluated_status.put(template_11, false);
		evaluated_status.put(template_12, false);
		evaluated_status.put(template_13, false);
		evaluated_status.put(template_14, false);
		evaluated_status.put(template_15, false);
		evaluated_status.put(template_16, false);

		// reload the path map with all the paths
		try {
			File fstream_temporary = new File("C:/Users/LilongHuang/eclipse-workspace/Loop_MOA/Bench/All.txt");
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

	public static int dominace_Comparison(List<Double> listxobjectives, List<Double> listvobjectives) {

		// LinkedHashMap<String, Integer> counter = new LinkedHashMap<String,
		// Integer>();
		int dominatex = 0; // dominate1 indicates if some objective of solution1
		// dominates the same objective in solution2. dominate2
		int dominatev = 0;
		int dominat_flagx = 0;
		int dominat_flagv = 0;
		// dominatex = 0;
		// dominatev = 0;
		int flag;

		int count_on3x = 0;
		int count_on3y = 0;
		int objectivexcount = 0;
		int objectivevcount = 0;
		int objectivexfalsecount = 0;
		int objectivevfalsecount = 0;

		// if (listxobjectives.size() != listvobjectives.size()) {
		// return -1;
		// }

		for (int i = 0; i < listxobjectives.size(); i++) {

			if (listxobjectives.get(i) == listvobjectives.get(i)) {

				objectivexcount++;

			}

			if (listxobjectives.get(i) < listvobjectives.get(i)) {

				dominat_flagx = 1;
				objectivexcount++;
			}

			if (listxobjectives.get(i) > listvobjectives.get(i)) {

				objectivexfalsecount = 1;

			}

		}

		for (int i = 0; i < listvobjectives.size(); i++) {

			if (listvobjectives.get(i) == listxobjectives.get(i)) {

				objectivevcount++;

			}

			if (listvobjectives.get(i) < listxobjectives.get(i)) {

				dominat_flagv = 1;
				objectivevcount++;
			}

			if (listvobjectives.get(i) > listxobjectives.get(i)) {

				objectivevfalsecount = 1;

				// if any value is greater
			}
		}

		if (objectivexcount == listxobjectives.size() && objectivexfalsecount == 0 && dominat_flagx == 1) {

			return -1; // Testcase1 dominates
		}

		else if (objectivevcount == listvobjectives.size() && objectivevfalsecount == 0 && dominat_flagv == 1) {

			return 1; // Testcase2 dominates
		}

		else {
			return 0;
		}
		/// No one dominate the other

	}

	public static int frontdominace_Comparison(List<Double> listxobjectives, List<Double> listvobjectives) {

		int dominat_flagx = 0;
		int dominat_flagv = 0;

		int objectivexcount = 0;
		int objectivevcount = 0;
		int objectivexfalsecount = 0;
		int objectivevfalsecount = 0;

		for (int i = 0; i < listxobjectives.size(); i++) {

			if (listxobjectives.get(i) == listvobjectives.get(i)) {

				objectivexcount++;

			}

			if (listxobjectives.get(i) < listvobjectives.get(i)) {

				dominat_flagx = 1;
				objectivexcount++;
			}

			if (listxobjectives.get(i) > listvobjectives.get(i)) {

				objectivexfalsecount = 1;

			}

		}

		for (int i = 0; i < listvobjectives.size(); i++) {

			if (listvobjectives.get(i) == listxobjectives.get(i)) {

				objectivevcount++;

			}

			if (listvobjectives.get(i) < listxobjectives.get(i)) {

				dominat_flagv = 1;
				objectivevcount++;
			}

			if (listvobjectives.get(i) > listxobjectives.get(i)) {

				objectivevfalsecount = 1;

			}
		}

		if ((objectivexcount == listxobjectives.size() && objectivexfalsecount == 0) && dominat_flagx == 1) {

			return -1; // Testcase1 dominates
		}

		else if ((objectivevcount == listvobjectives.size() && objectivevfalsecount == 0) && dominat_flagv == 1) {

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

}