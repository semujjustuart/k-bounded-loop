
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Collections;

import java.util.HashMap;
import java.util.Iterator;
//import java.util.HashMap;

import java.util.List;
//import java.util.Map;
import java.util.Map;
import java.util.Random;
//import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

//import LoopDE.Loop_PathDE.MyCallable;
/*import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;*/

import java.util.Set;

//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;

/*Author Semujju Stuart Dereck*/
public class Lpcf {

private static final int RUN = 10; // the number of the program runs. For simple test purpose i set it to one
	private static final double F = 0.5;
	private static final int  bias = 10;
	private static final int pop_num = 50; // the number of test cases
	///private static final int fun_num = 1; // the serial number of the target benchmark function.
	private static final int R = 14;
	private static final int NODENUM = 3; // the number of the nodes/vertex in the target benchmark function.
	// static boolean[][] visit = new boolean[NODENUM][4]; // '2' is for 'Yes'
	// branch and 'No' branch.
	//private static final int MCN = 300000; // the maximum test case number for a template.
	// private static final int MainCN = 1000000000; // test cases to be used in a
	// run
	// private static final int col = 0;
	private static final double Pc = 0.2;
	//private static final double non_simpleid = 99.0; // identifier given to test case not traversing a path in the group
	//private static final double non_simpleid2 = 100.0;// identifier given to test case traversing a path in the group
	private static final int PATHNUM = 27; // In this test bench mark there are 16 groups each with 32 paths
	//private static int case_sum = 0; 
	//private static int objective_size = 0;
	
	
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
	private static int[][] temp_17 = new int[PATHNUM][R];
	private static int[][] temp_18 = new int[PATHNUM][R];
	private static int[][] temp_19 = new int[PATHNUM][R];
	private static int[][] temp_20 = new int[PATHNUM][R];
	private static int[][] temp_21 = new int[PATHNUM][R];
	private static int[][] temp_22 = new int[PATHNUM][R];
	private static int[][] temp_23 = new int[PATHNUM][R];
	private static int[][] temp_24 = new int[PATHNUM][R];
	private static int[][] temp_25 = new int[PATHNUM][R];
	private static int[][] temp_26 = new int[PATHNUM][R];
	private static int[][] temp_27 = new int[PATHNUM][R];
	private static int[][] temp_28 = new int[PATHNUM][R];
	private static int[][] temp_29 = new int[PATHNUM][R];
	private static int[][] temp_30 = new int[PATHNUM][R];
	private static int[][] temp_31 = new int[PATHNUM][R];
	private static int[][] temp_32 = new int[PATHNUM][R];
	private static int[][] temp_33 = new int[PATHNUM][R];
	private static int[][] temp_34 = new int[PATHNUM][R];
	private static int[][] temp_35 = new int[PATHNUM][R];
	private static int[][] temp_36 = new int[PATHNUM][R];
	private static int[][] temp_37 = new int[PATHNUM][R];
	private static int[][] temp_38 = new int[PATHNUM][R];
	private static int[][] temp_39 = new int[PATHNUM][R];
	private static int[][] temp_40 = new int[PATHNUM][R];
	private static int[][] temp_41 = new int[PATHNUM][R];
	private static int[][] temp_42 = new int[PATHNUM][R];
	private static int[][] temp_43 = new int[PATHNUM][R];
	private static int[][] temp_44 = new int[PATHNUM][R];
	private static int[][] temp_45 = new int[PATHNUM][R];
	private static int[][] temp_46 = new int[PATHNUM][R];
	private static int[][] temp_47 = new int[PATHNUM][R];
	private static int[][] temp_48 = new int[PATHNUM][R];
	private static int[][] temp_49 = new int[PATHNUM][R];
	private static int[][] temp_50 = new int[PATHNUM][R];
	private static int[][] temp_51 = new int[PATHNUM][R];
	private static int[][] temp_52 = new int[PATHNUM][R];
	private static int[][] temp_53 = new int[PATHNUM][R];
	private static int[][] temp_54 = new int[PATHNUM][R];
	private static int[][] temp_55 = new int[PATHNUM][R];
	private static int[][] temp_56 = new int[PATHNUM][R];
	private static int[][] temp_57 = new int[PATHNUM][R];
	private static int[][] temp_58 = new int[PATHNUM][R];
	private static int[][] temp_59 = new int[PATHNUM][R];
	private static int[][] temp_60 = new int[PATHNUM][R];
	private static int[][] temp_61 = new int[PATHNUM][R];
	private static int[][] temp_62 = new int[PATHNUM][R];
	private static int[][] temp_63 = new int[PATHNUM][R];
	private static int[][] temp_64 = new int[PATHNUM][R];
	private static int[][] temp_65 = new int[PATHNUM][R];
	private static int[][] temp_66 = new int[PATHNUM][R];
	private static int[][] temp_67 = new int[PATHNUM][R];
	private static int[][] temp_68 = new int[PATHNUM][R];
	private static int[][] temp_69 = new int[PATHNUM][R];
	private static int[][] temp_70 = new int[PATHNUM][R];
	private static int[][] temp_71 = new int[PATHNUM][R];
	private static int[][] temp_72 = new int[PATHNUM][R];
	private static int[][] temp_73 = new int[PATHNUM][R];
	private static int[][] temp_74 = new int[PATHNUM][R];
	private static int[][] temp_75 = new int[PATHNUM][R];
	private static int[][] temp_76 = new int[PATHNUM][R];
	private static int[][] temp_77 = new int[PATHNUM][R];
	private static int[][] temp_78 = new int[PATHNUM][R];
	private static int[][] temp_79 = new int[PATHNUM][R];
	private static int[][] temp_80 = new int[PATHNUM][R];
	private static int[][] temp_81 = new int[PATHNUM][R];
	private static int[][] temp_holder = new int[50][R];
	private static int fitsizex = 0;
	private static final int TOTAL_PATHNUM = 2187;

	// static int[] path_id = new int[PATHNUM];
	// static boolean[] status = new boolean[8];

	static double[][] fitness_matrix = new double[NODENUM][7];
	static int pattern_number = 4; // The simple loop pattern number of this benchmark is set to the first four 4
									// iterations()

	static LinkedHashMap<String, Boolean> temporary_path_holder = new LinkedHashMap<String, Boolean>();
	static LinkedHashMap<String, Integer> pathcounter = new LinkedHashMap<String, Integer>();

	static LinkedHashMap<String, Boolean> evaluated_status = new LinkedHashMap<String, Boolean>();
	public static Map<String, int[][]> dynamic_access = new HashMap<String, int[][]>();

	// These are the identifiers(I.Ds) for each group/template based on the simple
	// loop path pattern
	static String template_1 = "aaaa";
	static String template_2 = "aaab";
	static String template_3 = "aaac";
	static String template_4 = "aaba";
	static String template_5 = "aabb";
	static String template_6 = "aabc";
	static String template_7 = "aaca";
	static String template_8 = "aacb";
	static String template_9 = "aacc";

	static String template_10 = "abaa";
	static String template_11 = "abab";
	static String template_12 = "abac";
	static String template_13 = "abba";
	static String template_14 = "abbb";
	static String template_15 = "abbc";
	static String template_16 = "abca";
	static String template_17 = "abcb";
	static String template_18 = "abcc";

	static String template_19 = "acaa";
	static String template_20 = "acab";
	static String template_21 = "acac";
	static String template_22 = "acba";
	static String template_23 = "acbb";
	static String template_24 = "acbc";
	static String template_25 = "acca";
	static String template_26 = "accb";
	static String template_27 = "accc";

	static String template_28 = "baaa";
	static String template_29 = "baab";
	static String template_30 = "baac";
	static String template_31 = "baba";
	static String template_32 = "babb";
	static String template_33 = "babc";
	static String template_34 = "baca";
	static String template_35 = "bacb";
	static String template_36 = "bacc";

	static String template_37 = "bbaa";
	static String template_38 = "bbab";
	static String template_39 = "bbac";
	static String template_40 = "bbba";
	static String template_41 = "bbbb";
	static String template_42 = "bbbc";
	static String template_43 = "bbca";
	static String template_44 = "bbcb";
	static String template_45 = "bbcc";

	static String template_46 = "bcaa";
	static String template_47 = "bcab";
	static String template_48 = "bcac";
	static String template_49 = "bcba";
	static String template_50 = "bcbb";
	static String template_51 = "bcbc";
	static String template_52 = "bcca";
	static String template_53 = "bccb";
	static String template_54 = "bccc";

	static String template_55 = "caaa";
	static String template_56 = "caab";
	static String template_57 = "caac";
	static String template_58 = "caba";
	static String template_59 = "cabb";
	static String template_60 = "cabc";
	static String template_61 = "caca";
	static String template_62 = "cacb";
	static String template_63 = "cacc";

	static String template_64 = "cbaa";
	static String template_65 = "cbab";
	static String template_66 = "cbac";
	static String template_67 = "cbba";
	static String template_68 = "cbbb";
	static String template_69 = "cbbc";
	static String template_70 = "cbca";
	static String template_71 = "cbcb";
	static String template_72 = "cbcc";

	static String template_73 = "ccaa";
	static String template_74 = "ccab";
	static String template_75 = "ccac";
	static String template_76 = "ccba";
	static String template_77 = "ccbb";
	static String template_78 = "ccbc";
	static String template_79 = "ccca";
	static String template_80 = "cccb";
	static String template_81 = "cccc";

	// ****************************************************************************************************************************************************************//

	// static int[][] dynamic16;

	// static int que = 1;
	// static double start; // the beginning time of the program run(not used in
	// this code)
	// static double finish; // the finish time of the program run(not used in this
	// code)
	//static int[] Cycle = new int[RUN];
	//static float[] coverage = new float[RUN];
	//static double[] runtime = new double[RUN];
	//static int[] case_num = new int[RUN];
	//static int[] total_case_num = new int[RUN];
	// static int[] itr = new int[4];
	static int[][] convergencegraph = new int[9][RUN];

	static String[] dynamo = { template_1, template_2, template_3, template_4, template_5, template_6, template_7,
			template_8, template_9, template_10, template_11, template_12, template_13, template_14, template_15,
			template_16, template_17, template_18, template_19, template_20, template_21, template_22, template_23,
			template_24, template_25, template_26, template_27, template_28, template_29, template_30, template_31,
			template_32, template_33, template_34, template_35, template_36, template_37, template_38, template_39,
			template_40, template_41, template_42, template_43, template_44, template_45, template_46, template_47,
			template_48, template_49, template_50, template_51, template_52, template_53, template_54, template_55,
			template_56, template_57, template_58, template_60, template_61, template_62, template_63, template_64,
			template_65, template_66, template_67, template_68, template_69, template_70, template_71, template_72,
			template_73, template_74, template_75, template_76, template_77, template_78, template_79, template_80,
			template_81 }; // this will be used later, currently not implemented

	static String[] groupss_0 = { template_2, template_3, template_4, template_5, template_6, template_7, template_8,
			template_9, template_10, template_11, template_12, template_13, template_14, template_15, template_16,
			template_17, template_18, template_19, template_20, template_21, template_22, template_23, template_24,
			template_25, template_26, template_27 }; // aaaa //template_1

	static String[] groupss_1 = { template_28, template_29, template_30, template_31, template_32, template_33,
			template_34, template_35, template_36, template_37, template_38, template_39, template_40, template_42,
			template_43, template_44, template_45, template_46, template_47, template_48, template_49, template_50,
			template_51, template_52, template_53, template_54 }; // bbbb template_41

	static String[] groupss_2 = { template_55, template_56, template_57, template_58, template_59, template_60,
			template_61, template_62, template_63, template_64, template_65, template_66, template_67, template_68,
			template_69, template_70, template_71, template_72, template_73, template_74, template_75, template_76,
			template_77, template_78, template_79, template_80 }; // cccc template_81

	// Here we create files(groups) to hold/store the number of similar paths in
	// each separate groupC:\Users\Stuart\eclipse-workspace
	static File allpaths = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/All.txt");
	static File id_1 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaaa.txt");
	static File id_2 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaab.txt");
	static File id_3 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaac.txt");
	static File id_4 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaba.txt");
	static File id_5 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aabb.txt");
	static File id_6 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aabc.txt");
	static File id_7 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaca.txt");
	static File id_8 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aacb.txt");
	static File id_9 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aacc.txt");
	static File id_10 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abaa.txt");
	static File id_11 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abab.txt");
	static File id_12 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abac.txt");
	static File id_13 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abba.txt");
	static File id_14 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abbb.txt");
	static File id_15 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abbc.txt");
	static File id_16 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abca.txt");
	static File id_17 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abcb.txt");
	static File id_18 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abcc.txt");
	static File id_19 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acaa.txt");
	static File id_20 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acab.txt");
	static File id_21 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acac.txt");
	static File id_22 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acba.txt");
	static File id_23 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acbb.txt");
	static File id_24 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acbc.txt");
	static File id_25 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acca.txt");
	static File id_26 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/accb.txt");
	static File id_27 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/accc.txt");
	static File id_28 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baaa.txt");
	static File id_29 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baab.txt");
	static File id_30 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baac.txt");
	static File id_31 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baba.txt");
	static File id_32 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/babb.txt");
	static File id_33 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/babc.txt");
	static File id_34 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baca.txt");
	static File id_35 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bacb.txt");
	static File id_36 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bacc.txt");
	static File id_37 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbaa.txt");
	static File id_38 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbab.txt");
	static File id_39 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbac.txt");
	static File id_40 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbba.txt");
	static File id_41 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbbb.txt");
	static File id_42 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbbc.txt");
	static File id_43 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbca.txt");
	static File id_44 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbcb.txt");
	static File id_45 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbcc.txt");
	static File id_46 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcaa.txt");
	static File id_47 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcab.txt");
	static File id_48 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcac.txt");
	static File id_49 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcba.txt");
	static File id_50 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcbb.txt");
	static File id_51 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcbc.txt");
	static File id_52 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcca.txt");
	static File id_53 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bccb.txt");
	static File id_54 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bccc.txt");
	static File id_55 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caaa.txt");
	static File id_56 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caab.txt");
	static File id_57 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caac.txt");
	static File id_58 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caba.txt");
	static File id_59 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cabb.txt");
	static File id_60 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cabc.txt");
	static File id_61 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caca.txt");
	static File id_62 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cacb.txt");
	static File id_63 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cacc.txt");
	static File id_64 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbaa.txt");
	static File id_65 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbab.txt");
	static File id_66 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbac.txt");
	static File id_67 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbba.txt");
	static File id_68 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbbb.txt");
	static File id_69 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbbc.txt");
	static File id_70 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbca.txt");
	static File id_71 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbcb.txt");
	static File id_72 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbcc.txt");
	static File id_73 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccaa.txt");
	static File id_74 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccab.txt");
	static File id_75 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccac.txt");
	static File id_76 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccba.txt");
	static File id_77 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccbb.txt");
	static File id_78 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccbc.txt");
	static File id_79 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccca.txt");
	static File id_80 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cccb.txt");
	static File id_81 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cccc.txt");

	public static int[][] solution_1 = new int[PATHNUM][R];
	public static int[][] solution_2 = new int[PATHNUM][R];
	public static int[][] solution_3 = new int[PATHNUM][R];
	public static int[][] solution_4 = new int[PATHNUM][R];
	public static int[][] solution_5 = new int[PATHNUM][R];
	public static int[][] solution_6 = new int[PATHNUM][R];
	public static int[][] solution_7 = new int[PATHNUM][R];
	public static int[][] solution_8 = new int[PATHNUM][R];
	public static int[][] solution_9 = new int[PATHNUM][R];
	public static int[][] solution_10 = new int[PATHNUM][R];
	public static int[][] solution_11 = new int[PATHNUM][R];
	public static int[][] solution_12 = new int[PATHNUM][R];
	public static int[][] solution_13 = new int[PATHNUM][R];
	public static int[][] solution_14 = new int[PATHNUM][R];
	public static int[][] solution_15 = new int[PATHNUM][R];
	public static int[][] solution_16 = new int[PATHNUM][R];
	public static int[][] solution_17 = new int[PATHNUM][R];
	public static int[][] solution_18 = new int[PATHNUM][R];
	public static int[][] solution_19 = new int[PATHNUM][R];
	public static int[][] solution_20 = new int[PATHNUM][R];
	public static int[][] solution_21 = new int[PATHNUM][R];
	public static int[][] solution_22 = new int[PATHNUM][R];
	public static int[][] solution_23 = new int[PATHNUM][R];
	public static int[][] solution_24 = new int[PATHNUM][R];
	public static int[][] solution_25 = new int[PATHNUM][R];
	public static int[][] solution_26 = new int[PATHNUM][R];
	public static int[][] solution_27 = new int[PATHNUM][R];
	public static int[][] solution_28 = new int[PATHNUM][R];
	public static int[][] solution_29 = new int[PATHNUM][R];
	public static int[][] solution_30 = new int[PATHNUM][R];
	public static int[][] solution_31 = new int[PATHNUM][R];
	public static int[][] solution_32 = new int[PATHNUM][R];
	public static int[][] solution_33 = new int[PATHNUM][R];
	public static int[][] solution_34 = new int[PATHNUM][R];
	public static int[][] solution_35 = new int[PATHNUM][R];
	public static int[][] solution_36 = new int[PATHNUM][R];
	public static int[][] solution_37 = new int[PATHNUM][R];
	public static int[][] solution_38 = new int[PATHNUM][R];
	public static int[][] solution_39 = new int[PATHNUM][R];
	public static int[][] solution_40 = new int[PATHNUM][R];
	public static int[][] solution_41 = new int[PATHNUM][R];
	public static int[][] solution_42 = new int[PATHNUM][R];
	public static int[][] solution_43 = new int[PATHNUM][R];
	public static int[][] solution_44 = new int[PATHNUM][R];
	public static int[][] solution_45 = new int[PATHNUM][R];
	public static int[][] solution_46 = new int[PATHNUM][R];
	public static int[][] solution_47 = new int[PATHNUM][R];
	public static int[][] solution_48 = new int[PATHNUM][R];
	public static int[][] solution_49 = new int[PATHNUM][R];
	public static int[][] solution_50 = new int[PATHNUM][R];
	public static int[][] solution_51 = new int[PATHNUM][R];
	public static int[][] solution_52 = new int[PATHNUM][R];
	public static int[][] solution_53 = new int[PATHNUM][R];
	public static int[][] solution_54 = new int[PATHNUM][R];
	public static int[][] solution_55 = new int[PATHNUM][R];
	public static int[][] solution_56 = new int[PATHNUM][R];
	public static int[][] solution_57 = new int[PATHNUM][R];
	public static int[][] solution_58 = new int[PATHNUM][R];
	public static int[][] solution_59 = new int[PATHNUM][R];
	public static int[][] solution_60 = new int[PATHNUM][R];
	public static int[][] solution_61 = new int[PATHNUM][R];
	public static int[][] solution_62 = new int[PATHNUM][R];
	public static int[][] solution_63 = new int[PATHNUM][R];
	public static int[][] solution_64 = new int[PATHNUM][R];
	public static int[][] solution_65 = new int[PATHNUM][R];
	public static int[][] solution_66 = new int[PATHNUM][R];
	public static int[][] solution_67 = new int[PATHNUM][R];
	public static int[][] solution_68 = new int[PATHNUM][R];
	public static int[][] solution_69 = new int[PATHNUM][R];
	public static int[][] solution_70 = new int[PATHNUM][R];
	public static int[][] solution_71 = new int[PATHNUM][R];
	public static int[][] solution_72 = new int[PATHNUM][R];
	public static int[][] solution_73 = new int[PATHNUM][R];
	public static int[][] solution_74 = new int[PATHNUM][R];
	public static int[][] solution_75 = new int[PATHNUM][R];
	public static int[][] solution_76 = new int[PATHNUM][R];
	public static int[][] solution_77 = new int[PATHNUM][R];
	public static int[][] solution_78 = new int[PATHNUM][R];
	public static int[][] solution_79 = new int[PATHNUM][R];
	public static int[][] solution_80 = new int[PATHNUM][R];
	public static int[][] solution_81 = new int[PATHNUM][R];

	public static boolean[] statu_1 = new boolean[PATHNUM];
	public static boolean[] statu_2 = new boolean[PATHNUM];
	public static boolean[] statu_3 = new boolean[PATHNUM];
	public static boolean[] statu_4 = new boolean[PATHNUM];
	public static boolean[] statu_5 = new boolean[PATHNUM];
	public static boolean[] statu_6 = new boolean[PATHNUM];
	public static boolean[] statu_7 = new boolean[PATHNUM];
	public static boolean[] statu_8 = new boolean[PATHNUM];
	public static boolean[] statu_9 = new boolean[PATHNUM];
	public static boolean[] statu_10 = new boolean[PATHNUM];
	public static boolean[] statu_11 = new boolean[PATHNUM];
	public static boolean[] statu_12 = new boolean[PATHNUM];
	public static boolean[] statu_13 = new boolean[PATHNUM];
	public static boolean[] statu_14 = new boolean[PATHNUM];
	public static boolean[] statu_15 = new boolean[PATHNUM];
	public static boolean[] statu_16 = new boolean[PATHNUM];
	public static boolean[] statu_17 = new boolean[PATHNUM];
	public static boolean[] statu_18 = new boolean[PATHNUM];
	public static boolean[] statu_19 = new boolean[PATHNUM];
	public static boolean[] statu_20 = new boolean[PATHNUM];
	public static boolean[] statu_21 = new boolean[PATHNUM];
	public static boolean[] statu_22 = new boolean[PATHNUM];
	public static boolean[] statu_23 = new boolean[PATHNUM];
	public static boolean[] statu_24 = new boolean[PATHNUM];
	public static boolean[] statu_25 = new boolean[PATHNUM];
	public static boolean[] statu_26 = new boolean[PATHNUM];
	public static boolean[] statu_27 = new boolean[PATHNUM];
	public static boolean[] statu_28 = new boolean[PATHNUM];
	public static boolean[] statu_29 = new boolean[PATHNUM];
	public static boolean[] statu_30 = new boolean[PATHNUM];
	public static boolean[] statu_31 = new boolean[PATHNUM];
	public static boolean[] statu_32 = new boolean[PATHNUM];
	public static boolean[] statu_33 = new boolean[PATHNUM];
	public static boolean[] statu_34 = new boolean[PATHNUM];
	public static boolean[] statu_35 = new boolean[PATHNUM];
	public static boolean[] statu_36 = new boolean[PATHNUM];
	public static boolean[] statu_37 = new boolean[PATHNUM];
	public static boolean[] statu_38 = new boolean[PATHNUM];
	public static boolean[] statu_39 = new boolean[PATHNUM];
	public static boolean[] statu_40 = new boolean[PATHNUM];
	public static boolean[] statu_41 = new boolean[PATHNUM];
	public static boolean[] statu_42 = new boolean[PATHNUM];
	public static boolean[] statu_43 = new boolean[PATHNUM];
	public static boolean[] statu_44 = new boolean[PATHNUM];
	public static boolean[] statu_45 = new boolean[PATHNUM];
	public static boolean[] statu_46 = new boolean[PATHNUM];
	public static boolean[] statu_47 = new boolean[PATHNUM];
	public static boolean[] statu_48 = new boolean[PATHNUM];
	public static boolean[] statu_49 = new boolean[PATHNUM];
	public static boolean[] statu_50 = new boolean[PATHNUM];
	public static boolean[] statu_51 = new boolean[PATHNUM];
	public static boolean[] statu_52 = new boolean[PATHNUM];
	public static boolean[] statu_53 = new boolean[PATHNUM];
	public static boolean[] statu_54 = new boolean[PATHNUM];
	public static boolean[] statu_55 = new boolean[PATHNUM];
	public static boolean[] statu_56 = new boolean[PATHNUM];
	public static boolean[] statu_57 = new boolean[PATHNUM];
	public static boolean[] statu_58 = new boolean[PATHNUM];
	public static boolean[] statu_59 = new boolean[PATHNUM];
	public static boolean[] statu_60 = new boolean[PATHNUM];
	public static boolean[] statu_61 = new boolean[PATHNUM];
	public static boolean[] statu_62 = new boolean[PATHNUM];
	public static boolean[] statu_63 = new boolean[PATHNUM];
	public static boolean[] statu_64 = new boolean[PATHNUM];

	public static boolean[] statu_65 = new boolean[PATHNUM];
	public static boolean[] statu_66 = new boolean[PATHNUM];
	public static boolean[] statu_67 = new boolean[PATHNUM];
	public static boolean[] statu_68 = new boolean[PATHNUM];
	public static boolean[] statu_69 = new boolean[PATHNUM];
	public static boolean[] statu_70 = new boolean[PATHNUM];
	public static boolean[] statu_71 = new boolean[PATHNUM];
	public static boolean[] statu_72 = new boolean[PATHNUM];
	public static boolean[] statu_73 = new boolean[PATHNUM];
	public static boolean[] statu_74 = new boolean[PATHNUM];
	public static boolean[] statu_75 = new boolean[PATHNUM];
	public static boolean[] statu_76 = new boolean[PATHNUM];
	public static boolean[] statu_77 = new boolean[PATHNUM];
	public static boolean[] statu_78 = new boolean[PATHNUM];
	public static boolean[] statu_79 = new boolean[PATHNUM];
	public static boolean[] statu_80 = new boolean[PATHNUM];
	public static boolean[] statu_81 = new boolean[PATHNUM];

	public static int obj_1;
	public static int obj_2;
	public static int obj_3;
	public static int obj_4;
	public static int obj_5;
	public static int obj_6;
	public static int obj_7;
	public static int obj_8;
	public static int obj_9;
	public static int obj_10;
	public static int obj_11;
	public static int obj_12;
	public static int obj_13;
	public static int obj_14;
	public static int obj_15;
	public static int obj_16;

	public static int obj_17;
	public static int obj_18;
	public static int obj_19;
	public static int obj_20;
	public static int obj_21;
	public static int obj_22;
	public static int obj_23;
	public static int obj_24;
	public static int obj_25;
	public static int obj_26;
	public static int obj_27;
	public static int obj_28;
	public static int obj_29;
	public static int obj_30;
	public static int obj_31;
	public static int obj_32;

	public static int obj_33;
	public static int obj_34;
	public static int obj_35;
	public static int obj_36;
	public static int obj_37;
	public static int obj_38;
	public static int obj_39;
	public static int obj_40;
	public static int obj_41;
	public static int obj_42;
	public static int obj_43;
	public static int obj_44;
	public static int obj_45;
	public static int obj_46;
	public static int obj_47;
	public static int obj_48;

	public static int obj_49;
	public static int obj_50;
	public static int obj_51;
	public static int obj_52;
	public static int obj_53;
	public static int obj_54;
	public static int obj_55;
	public static int obj_56;
	public static int obj_57;
	public static int obj_58;
	public static int obj_59;
	public static int obj_60;
	public static int obj_61;
	public static int obj_62;
	public static int obj_63;
	public static int obj_64;

	public static int obj_65;
	public static int obj_66;
	public static int obj_67;
	public static int obj_68;
	public static int obj_69;
	public static int obj_70;
	public static int obj_71;
	public static int obj_72;
	public static int obj_73;
	public static int obj_74;
	public static int obj_75;
	public static int obj_76;
	public static int obj_77;
	public static int obj_78;
	public static int obj_79;
	public static int obj_80;
	public static int obj_81;

	public static int[][] x = new int[pop_num][R];
	public static int[][] v = new int[pop_num][R];

	public static int totalpathcounter;

	// static LinkedHashMap<String, Integer> itr1 = new LinkedHashMap<String,
	// Integer>();

	static LinkedHashMap<String, Boolean> paths = new LinkedHashMap<String, Boolean>();

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

		int k = 7;

		char[] set = { 'a', 'b', 'c' };
		char[] str = new char[k];

		enumeratePaths(k, set, str, 0); // call function to generate the paths
		init_Template();// function to create the groups of paths. // using the simple loop path pattern
						// information

		LinkedHashMap<String, List<String>> group_map = new LinkedHashMap<String, List<String>>();

		List<String> neighbor_0 = new ArrayList<String>();
		List<String> neighbor_1 = new ArrayList<String>();
		List<String> neighbor_2 = new ArrayList<String>();

		for (int gr = 0; gr < groupss_0.length; gr++) {

			neighbor_0.add(groupss_0[gr]);

		} // populate neighbors starting with 0

		for (int gr_1 = 0; gr_1 < groupss_1.length; gr_1++) {

			neighbor_1.add(groupss_1[gr_1]);

		} // populate neighbors starting with 1

		for (int gr = 0; gr < groupss_2.length; gr++) {

			neighbor_2.add(groupss_2[gr]);

		} // populate neighbors starting with 0

		List<String> group_0_list = new ArrayList<String>(); // aa //template_1
		List<String> group_1_list = new ArrayList<String>(); // bb // template_11
		List<String> group_2_list = new ArrayList<String>(); // cc //template_21

		group_0_list.addAll(neighbor_0);

		group_map.put(template_1, group_0_list);

		group_1_list.addAll(neighbor_1);

		group_map.put(template_41, group_1_list);

		group_2_list.addAll(neighbor_2);

		group_map.put(template_81, group_2_list);

		int[] lb = new int[R];// lower bound
		int[] ub = new int[R];// upper bound

			
		for(int i = 0;i < R;i++)
			
		{
				lb[i] = 1;    
				ub[i] = 1000;
		}

		

		for (int run = 0; run < RUN; run++) {
			
			

			int group_counter = 0;

			int point = -1;

			x = new int[pop_num][R];
			v = new int[pop_num][R];

			LinkedHashMap<String, List<Double>> fitnessmaps = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps1 = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps2 = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps3 = new LinkedHashMap<String, List<Double>>();

			LinkedHashMap<String, Integer> setrank1 = new LinkedHashMap<String, Integer>();
			LinkedHashMap<String, Integer> setrank2 = new LinkedHashMap<String, Integer>();

			LinkedHashMap<String, Integer> setrank3 = new LinkedHashMap<String, Integer>();
			LinkedHashMap<String, List<Double>> combined_maps = new LinkedHashMap<String, List<Double>>();
			List<String> updated_population = new ArrayList<String>();

			List<String> offspring_population = new ArrayList<String>();
			List<String> offspring_population2 = new ArrayList<String>();

			List<String> single_population = new ArrayList<String>();

			String traverse_template;

			// the 2d arrays below hold the solutions to each respective group

			solution_1 = new int[PATHNUM][R];
			solution_2 = new int[PATHNUM][R];
			solution_3 = new int[PATHNUM][R];
			solution_4 = new int[PATHNUM][R];
			solution_5 = new int[PATHNUM][R];
			solution_6 = new int[PATHNUM][R];
			solution_7 = new int[PATHNUM][R];
			solution_8 = new int[PATHNUM][R];
			solution_9 = new int[PATHNUM][R];
			solution_10 = new int[PATHNUM][R];
			solution_11 = new int[PATHNUM][R];
			solution_12 = new int[PATHNUM][R];
			solution_13 = new int[PATHNUM][R];
			solution_14 = new int[PATHNUM][R];
			solution_15 = new int[PATHNUM][R];
			solution_16 = new int[PATHNUM][R];
			solution_17 = new int[PATHNUM][R];
			solution_18 = new int[PATHNUM][R];
			solution_19 = new int[PATHNUM][R];
			solution_20 = new int[PATHNUM][R];
			solution_21 = new int[PATHNUM][R];
			solution_22 = new int[PATHNUM][R];
			solution_23 = new int[PATHNUM][R];
			solution_24 = new int[PATHNUM][R];
			solution_25 = new int[PATHNUM][R];
			solution_26 = new int[PATHNUM][R];
			solution_27 = new int[PATHNUM][R];
			solution_28 = new int[PATHNUM][R];
			solution_29 = new int[PATHNUM][R];
			solution_30 = new int[PATHNUM][R];
			solution_31 = new int[PATHNUM][R];
			solution_32 = new int[PATHNUM][R];
			solution_33 = new int[PATHNUM][R];

			solution_34 = new int[PATHNUM][R];
			solution_35 = new int[PATHNUM][R];
			solution_36 = new int[PATHNUM][R];
			solution_37 = new int[PATHNUM][R];
			solution_38 = new int[PATHNUM][R];
			solution_39 = new int[PATHNUM][R];
			solution_40 = new int[PATHNUM][R];
			solution_41 = new int[PATHNUM][R];
			solution_42 = new int[PATHNUM][R];
			solution_43 = new int[PATHNUM][R];
			solution_44 = new int[PATHNUM][R];
			solution_45 = new int[PATHNUM][R];
			solution_46 = new int[PATHNUM][R];
			solution_47 = new int[PATHNUM][R];
			solution_48 = new int[PATHNUM][R];
			solution_49 = new int[PATHNUM][R];
			solution_50 = new int[PATHNUM][R];
			solution_51 = new int[PATHNUM][R];
			solution_52 = new int[PATHNUM][R];
			solution_53 = new int[PATHNUM][R];
			solution_54 = new int[PATHNUM][R];
			solution_55 = new int[PATHNUM][R];
			solution_56 = new int[PATHNUM][R];
			solution_57 = new int[PATHNUM][R];
			solution_58 = new int[PATHNUM][R];
			solution_59 = new int[PATHNUM][R];
			solution_60 = new int[PATHNUM][R];
			solution_61 = new int[PATHNUM][R];
			solution_62 = new int[PATHNUM][R];
			solution_63 = new int[PATHNUM][R];
			solution_64 = new int[PATHNUM][R];
			solution_65 = new int[PATHNUM][R];
			solution_66 = new int[PATHNUM][R];

			solution_67 = new int[PATHNUM][R];
			solution_68 = new int[PATHNUM][R];
			solution_69 = new int[PATHNUM][R];
			solution_70 = new int[PATHNUM][R];
			solution_71 = new int[PATHNUM][R];
			solution_72 = new int[PATHNUM][R];
			solution_73 = new int[PATHNUM][R];
			solution_74 = new int[PATHNUM][R];
			solution_75 = new int[PATHNUM][R];
			solution_76 = new int[PATHNUM][R];
			solution_77 = new int[PATHNUM][R];
			solution_78 = new int[PATHNUM][R];
			solution_79 = new int[PATHNUM][R];
			solution_80 = new int[PATHNUM][R];
			solution_81 = new int[PATHNUM][R];

			statu_1 = new boolean[PATHNUM];
			statu_2 = new boolean[PATHNUM];
			statu_3 = new boolean[PATHNUM];
			statu_4 = new boolean[PATHNUM];
			statu_5 = new boolean[PATHNUM];
			statu_6 = new boolean[PATHNUM];
			statu_7 = new boolean[PATHNUM];
			statu_8 = new boolean[PATHNUM];
			statu_9 = new boolean[PATHNUM];
			statu_10 = new boolean[PATHNUM];
			statu_11 = new boolean[PATHNUM];
			statu_12 = new boolean[PATHNUM];
			statu_13 = new boolean[PATHNUM];
			statu_14 = new boolean[PATHNUM];
			statu_15 = new boolean[PATHNUM];
			statu_16 = new boolean[PATHNUM];
			statu_17 = new boolean[PATHNUM];
			statu_18 = new boolean[PATHNUM];
			statu_19 = new boolean[PATHNUM];
			statu_20 = new boolean[PATHNUM];
			statu_21 = new boolean[PATHNUM];
			statu_22 = new boolean[PATHNUM];
			statu_23 = new boolean[PATHNUM];
			statu_24 = new boolean[PATHNUM];
			statu_25 = new boolean[PATHNUM];
			statu_26 = new boolean[PATHNUM];
			statu_27 = new boolean[PATHNUM];
			statu_28 = new boolean[PATHNUM];
			statu_29 = new boolean[PATHNUM];
			statu_30 = new boolean[PATHNUM];
			statu_31 = new boolean[PATHNUM];
			statu_32 = new boolean[PATHNUM];
			statu_33 = new boolean[PATHNUM];
			statu_34 = new boolean[PATHNUM];
			statu_35 = new boolean[PATHNUM];
			statu_36 = new boolean[PATHNUM];
			statu_37 = new boolean[PATHNUM];
			statu_38 = new boolean[PATHNUM];
			statu_39 = new boolean[PATHNUM];
			statu_40 = new boolean[PATHNUM];
			statu_41 = new boolean[PATHNUM];
			statu_42 = new boolean[PATHNUM];
			statu_43 = new boolean[PATHNUM];
			statu_44 = new boolean[PATHNUM];
			statu_45 = new boolean[PATHNUM];
			statu_46 = new boolean[PATHNUM];
			statu_47 = new boolean[PATHNUM];
			statu_48 = new boolean[PATHNUM];
			statu_49 = new boolean[PATHNUM];
			statu_50 = new boolean[PATHNUM];
			statu_51 = new boolean[PATHNUM];
			statu_52 = new boolean[PATHNUM];
			statu_53 = new boolean[PATHNUM];
			statu_54 = new boolean[PATHNUM];
			statu_55 = new boolean[PATHNUM];
			statu_56 = new boolean[PATHNUM];
			statu_57 = new boolean[PATHNUM];
			statu_58 = new boolean[PATHNUM];
			statu_59 = new boolean[PATHNUM];
			statu_60 = new boolean[PATHNUM];
			statu_61 = new boolean[PATHNUM];
			statu_62 = new boolean[PATHNUM];
			statu_63 = new boolean[PATHNUM];
			statu_64 = new boolean[PATHNUM];

			statu_65 = new boolean[PATHNUM];
			statu_66 = new boolean[PATHNUM];
			statu_67 = new boolean[PATHNUM];
			statu_68 = new boolean[PATHNUM];
			statu_69 = new boolean[PATHNUM];
			statu_70 = new boolean[PATHNUM];
			statu_71 = new boolean[PATHNUM];
			statu_72 = new boolean[PATHNUM];
			statu_73 = new boolean[PATHNUM];
			statu_74 = new boolean[PATHNUM];
			statu_75 = new boolean[PATHNUM];
			statu_76 = new boolean[PATHNUM];
			statu_77 = new boolean[PATHNUM];
			statu_78 = new boolean[PATHNUM];
			statu_79 = new boolean[PATHNUM];
			statu_80 = new boolean[PATHNUM];
			statu_81 = new boolean[PATHNUM];

			obj_1 = 0;
			obj_2 = 0;
			obj_3 = 0;
			obj_4 = 0;
			obj_5 = 0;
			obj_6 = 0;
			obj_7 = 0;
			obj_8 = 0;
			obj_9 = 0;
			obj_10 = 0;
			obj_11 = 0;
			obj_12 = 0;
			obj_13 = 0;
			obj_14 = 0;
			obj_15 = 0;
			obj_16 = 0;
			obj_17 = 0;
			obj_18 = 0;
			obj_19 = 0;
			obj_20 = 0;
			obj_21 = 0;
			obj_22 = 0;
			obj_23 = 0;
			obj_24 = 0;
			obj_25 = 0;
			obj_26 = 0;
			obj_27 = 0;
			obj_28 = 0;
			obj_29 = 0;
			obj_30 = 0;
			obj_31 = 0;
			obj_32 = 0;
			obj_33 = 0;
			obj_34 = 0;
			obj_35 = 0;
			obj_36 = 0;
			obj_37 = 0;
			obj_38 = 0;
			obj_39 = 0;
			obj_40 = 0;
			obj_41 = 0;
			obj_42 = 0;
			obj_43 = 0;
			obj_44 = 0;
			obj_45 = 0;
			obj_46 = 0;
			obj_47 = 0;
			obj_48 = 0;
			obj_49 = 0;
			obj_50 = 0;
			obj_51 = 0;
			obj_52 = 0;
			obj_53 = 0;
			obj_54 = 0;
			obj_55 = 0;
			obj_56 = 0;
			obj_57 = 0;
			obj_58 = 0;
			obj_59 = 0;
			obj_60 = 0;
			obj_61 = 0;
			obj_62 = 0;
			obj_63 = 0;
			obj_64 = 0;
			obj_65 = 0;
			obj_66 = 0;
			obj_67 = 0;
			obj_68 = 0;
			obj_69 = 0;
			obj_70 = 0;
			obj_71 = 0;
			obj_72 = 0;
			obj_73 = 0;
			obj_74 = 0;
			obj_75 = 0;
			obj_76 = 0;
			obj_77 = 0;
			obj_78 = 0;
			obj_79 = 0;
			obj_80 = 0;
			obj_81 = 0;

			temp_1 = new int[PATHNUM][R];
			temp_2 = new int[PATHNUM][R];
			temp_3 = new int[PATHNUM][R];
			temp_4 = new int[PATHNUM][R];
			temp_5 = new int[PATHNUM][R];
			temp_6 = new int[PATHNUM][R];
			temp_7 = new int[PATHNUM][R];
			temp_8 = new int[PATHNUM][R];
			temp_9 = new int[PATHNUM][R];
			temp_10 = new int[PATHNUM][R];
			temp_11 = new int[PATHNUM][R];
			temp_12 = new int[PATHNUM][R];
			temp_13 = new int[PATHNUM][R];
			temp_14 = new int[PATHNUM][R];
			temp_15 = new int[PATHNUM][R];
			temp_16 = new int[PATHNUM][R];
			temp_17 = new int[PATHNUM][R];
			temp_18 = new int[PATHNUM][R];
			temp_19 = new int[PATHNUM][R];
			temp_20 = new int[PATHNUM][R];
			temp_21 = new int[PATHNUM][R];
			temp_22 = new int[PATHNUM][R];
			temp_23 = new int[PATHNUM][R];
			temp_24 = new int[PATHNUM][R];
			temp_25 = new int[PATHNUM][R];
			temp_26 = new int[PATHNUM][R];
			temp_27 = new int[PATHNUM][R];
			temp_28 = new int[PATHNUM][R];
			temp_29 = new int[PATHNUM][R];
			temp_30 = new int[PATHNUM][R];
			temp_31 = new int[PATHNUM][R];
			temp_32 = new int[PATHNUM][R];
			temp_33 = new int[PATHNUM][R];
			temp_34 = new int[PATHNUM][R];
			temp_35 = new int[PATHNUM][R];
			temp_36 = new int[PATHNUM][R];
			temp_37 = new int[PATHNUM][R];
			temp_38 = new int[PATHNUM][R];
			temp_39 = new int[PATHNUM][R];
			temp_40 = new int[PATHNUM][R];
			temp_41 = new int[PATHNUM][R];
			temp_42 = new int[PATHNUM][R];
			temp_43 = new int[PATHNUM][R];
			temp_44 = new int[PATHNUM][R];
			temp_45 = new int[PATHNUM][R];
			temp_46 = new int[PATHNUM][R];
			temp_47 = new int[PATHNUM][R];
			temp_48 = new int[PATHNUM][R];
			temp_49 = new int[PATHNUM][R];
			temp_50 = new int[PATHNUM][R];
			temp_51 = new int[PATHNUM][R];
			temp_52 = new int[PATHNUM][R];
			temp_53 = new int[PATHNUM][R];
			temp_54 = new int[PATHNUM][R];
			temp_55 = new int[PATHNUM][R];
			temp_56 = new int[PATHNUM][R];
			temp_57 = new int[PATHNUM][R];
			temp_58 = new int[PATHNUM][R];
			temp_59 = new int[PATHNUM][R];
			temp_60 = new int[PATHNUM][R];
			temp_61 = new int[PATHNUM][R];
			temp_62 = new int[PATHNUM][R];
			temp_63 = new int[PATHNUM][R];
			temp_64 = new int[PATHNUM][R];
			temp_65 = new int[PATHNUM][R];
			temp_66 = new int[PATHNUM][R];
			temp_67 = new int[PATHNUM][R];
			temp_68 = new int[PATHNUM][R];
			temp_69 = new int[PATHNUM][R];
			temp_70 = new int[PATHNUM][R];
			temp_71 = new int[PATHNUM][R];
			temp_72 = new int[PATHNUM][R];
			temp_73 = new int[PATHNUM][R];
			temp_74 = new int[PATHNUM][R];
			temp_75 = new int[PATHNUM][R];
			temp_76 = new int[PATHNUM][R];
			temp_77 = new int[PATHNUM][R];
			temp_78 = new int[PATHNUM][R];
			temp_79 = new int[PATHNUM][R];
			temp_80 = new int[PATHNUM][R];
			temp_81 = new int[PATHNUM][R];

			totalpathcounter = 0;

			// int obj_total = 0;

			String getfinalpath;
			String final_path_checker;

			if (run > 0) { // in each run reset the number counter of the paths covered in each group

				reset_All();
				updated_population.clear();
				offspring_population.clear();
				offspring_population2.clear();
				single_population.clear();

				setrank1.clear();
				//setrank3.clear();

				fitnessmaps.clear();
				fitnessmaps1.clear();
				fitnessmaps2.clear();
				fitnessmaps3.clear();

			}

			for (int i = 0; i < pop_num; i++) // initialize the population with the dimension of R values/inputs
			{

				for (int j = 0; j < R; j++) {

					x[i][j] = (int) (Math.random() * ((ub[j] - lb[j]) + 1)) + lb[j];
					// x[i][j] =(int)(lb[j] + Math.random() * (ub[j] - lb[j]));
				}

				// case_num[run] = case_num[run] + 1 ; // test case number

			//	total_case_num[run] = total_case_num[run] + 1; // here we start to count the test case

				getfinalpath = pathnum(x[i]); // path traversed by input x is returned

				// System.out.println(" hereeeee " + getfinalpath );

				traverse(getfinalpath, i);

			}

			//Cycle[run] = 1;

			for (int iterator = 0; iterator < 81; iterator++) { // iterator of all templates // checks to perform // is
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

				evaluated_status.put(traverse_template, true);

				try {
					File fstream_temporary = new File(
							"C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/" + traverse_template + ".txt");
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

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_17[a]) {

							for (int j = 0; j < R; j++) {
								temp_17[a][j] = solution_17[a][j];

							}

						}

					}

					dynamic_access.put(template_17, temp_17);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_18[a]) {

							for (int j = 0; j < R; j++) {
								temp_18[a][j] = solution_18[a][j];

							}

						}

					}

					dynamic_access.put(template_18, temp_18);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_19[a]) {

							for (int j = 0; j < R; j++) {
								temp_19[a][j] = solution_19[a][j];

							}

						}

					}

					dynamic_access.put(template_19, temp_19);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_20[a]) {

							for (int j = 0; j < R; j++) {
								temp_20[a][j] = solution_20[a][j];

							}

						}

					}

					dynamic_access.put(template_20, temp_20);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_21[a]) {

							for (int j = 0; j < R; j++) {
								temp_21[a][j] = solution_21[a][j];

							}

						}

					}

					dynamic_access.put(template_21, temp_21);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_22[a]) {

							for (int j = 0; j < R; j++) {
								temp_22[a][j] = solution_22[a][j];

							}

						}

					}

					dynamic_access.put(template_22, temp_22);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_23[a]) {

							for (int j = 0; j < R; j++) {
								temp_23[a][j] = solution_23[a][j];

							}

						}

					}

					dynamic_access.put(template_23, temp_23);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_24[a]) {

							for (int j = 0; j < R; j++) {
								temp_24[a][j] = solution_24[a][j];

							}

						}

					}

					dynamic_access.put(template_24, temp_24);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_25[a]) {

							for (int j = 0; j < R; j++) {
								temp_25[a][j] = solution_25[a][j];

							}

						}

					}

					dynamic_access.put(template_25, temp_25);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_26[a]) {

							for (int j = 0; j < R; j++) {
								temp_26[a][j] = solution_26[a][j];

							}

						}

					}

					dynamic_access.put(template_26, temp_26);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_27[a]) {

							for (int j = 0; j < R; j++) {
								temp_27[a][j] = solution_27[a][j];

							}

						}

					}

					dynamic_access.put(template_27, temp_27);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_28[a]) {

							for (int j = 0; j < R; j++) {
								temp_28[a][j] = solution_28[a][j];

							}

						}

					}

					dynamic_access.put(template_28, temp_28);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_29[a]) {

							for (int j = 0; j < R; j++) {
								temp_29[a][j] = solution_29[a][j];

							}

						}

					}

					dynamic_access.put(template_29, temp_29);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_30[a]) {

							for (int j = 0; j < R; j++) {
								temp_30[a][j] = solution_30[a][j];

							}

						}

					}

					dynamic_access.put(template_30, temp_30);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_31[a]) {

							for (int j = 0; j < R; j++) {
								temp_31[a][j] = solution_31[a][j];

							}

						}

					}

					dynamic_access.put(template_31, temp_31);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_32[a]) {

							for (int j = 0; j < R; j++) {
								temp_32[a][j] = solution_32[a][j];

							}

						}

					}

					dynamic_access.put(template_32, temp_32);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_33[a]) {

							for (int j = 0; j < R; j++) {
								temp_33[a][j] = solution_33[a][j];

							}

						}

					}

					dynamic_access.put(template_33, temp_33);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_34[a]) {

							for (int j = 0; j < R; j++) {
								temp_34[a][j] = solution_34[a][j];

							}

						}

					}

					dynamic_access.put(template_34, temp_34);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_35[a]) {

							for (int j = 0; j < R; j++) {
								temp_35[a][j] = solution_35[a][j];

							}

						}

					}

					dynamic_access.put(template_35, temp_35);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_36[a]) {

							for (int j = 0; j < R; j++) {
								temp_36[a][j] = solution_36[a][j];

							}

						}

					}

					dynamic_access.put(template_36, temp_36);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_37[a]) {

							for (int j = 0; j < R; j++) {
								temp_37[a][j] = solution_37[a][j];

							}

						}

					}

					dynamic_access.put(template_37, temp_37);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_38[a]) {

							for (int j = 0; j < R; j++) {
								temp_38[a][j] = solution_38[a][j];

							}

						}

					}

					dynamic_access.put(template_38, temp_38);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_39[a]) {

							for (int j = 0; j < R; j++) {
								temp_39[a][j] = solution_39[a][j];

							}

						}

					}

					dynamic_access.put(template_39, temp_39);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_40[a]) {

							for (int j = 0; j < R; j++) {
								temp_40[a][j] = solution_40[a][j];

							}

						}

					}

					dynamic_access.put(template_40, temp_40);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_41[a]) {

							for (int j = 0; j < R; j++) {
								temp_41[a][j] = solution_41[a][j];

							}

						}

					}

					dynamic_access.put(template_41, temp_41);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_42[a]) {

							for (int j = 0; j < R; j++) {
								temp_42[a][j] = solution_42[a][j];

							}

						}

					}

					dynamic_access.put(template_42, temp_42);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_43[a]) {

							for (int j = 0; j < R; j++) {
								temp_43[a][j] = solution_43[a][j];

							}

						}

					}

					dynamic_access.put(template_43, temp_43);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_44[a]) {

							for (int j = 0; j < R; j++) {
								temp_44[a][j] = solution_44[a][j];

							}

						}

					}

					dynamic_access.put(template_44, temp_44);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_45[a]) {

							for (int j = 0; j < R; j++) {
								temp_45[a][j] = solution_45[a][j];

							}

						}

					}

					dynamic_access.put(template_45, temp_45);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_46[a]) {

							for (int j = 0; j < R; j++) {
								temp_46[a][j] = solution_46[a][j];

							}

						}

					}

					dynamic_access.put(template_46, temp_46);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_47[a]) {

							for (int j = 0; j < R; j++) {
								temp_47[a][j] = solution_47[a][j];

							}

						}

					}

					dynamic_access.put(template_47, temp_47);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_48[a]) {

							for (int j = 0; j < R; j++) {
								temp_48[a][j] = solution_48[a][j];

							}

						}

					}

					dynamic_access.put(template_48, temp_48);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_49[a]) {

							for (int j = 0; j < R; j++) {
								temp_49[a][j] = solution_49[a][j];

							}

						}

					}

					dynamic_access.put(template_49, temp_49);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_50[a]) {

							for (int j = 0; j < R; j++) {
								temp_50[a][j] = solution_50[a][j];

							}

						}

					}

					dynamic_access.put(template_50, temp_50);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_51[a]) {

							for (int j = 0; j < R; j++) {
								temp_51[a][j] = solution_51[a][j];

							}

						}

					}

					dynamic_access.put(template_51, temp_51);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_52[a]) {

							for (int j = 0; j < R; j++) {
								temp_52[a][j] = solution_52[a][j];

							}

						}

					}

					dynamic_access.put(template_52, temp_52);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_53[a]) {

							for (int j = 0; j < R; j++) {
								temp_53[a][j] = solution_53[a][j];

							}

						}

					}

					dynamic_access.put(template_53, temp_53);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_54[a]) {

							for (int j = 0; j < R; j++) {
								temp_54[a][j] = solution_54[a][j];

							}

						}

					}

					dynamic_access.put(template_54, temp_54);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_55[a]) {

							for (int j = 0; j < R; j++) {
								temp_55[a][j] = solution_55[a][j];

							}

						}

					}

					dynamic_access.put(template_55, temp_55);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_56[a]) {

							for (int j = 0; j < R; j++) {
								temp_56[a][j] = solution_56[a][j];

							}

						}

					}

					dynamic_access.put(template_56, temp_56);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_57[a]) {

							for (int j = 0; j < R; j++) {
								temp_57[a][j] = solution_57[a][j];

							}

						}

					}

					dynamic_access.put(template_57, temp_57);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_58[a]) {

							for (int j = 0; j < R; j++) {
								temp_58[a][j] = solution_58[a][j];

							}

						}

					}

					dynamic_access.put(template_58, temp_58);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_59[a]) {

							for (int j = 0; j < R; j++) {
								temp_59[a][j] = solution_59[a][j];

							}

						}
					}

					dynamic_access.put(template_59, temp_59);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_60[a]) {

							for (int j = 0; j < R; j++) {
								temp_60[a][j] = solution_60[a][j];

							}

						}

					}

					dynamic_access.put(template_60, temp_60);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_61[a]) {

							for (int j = 0; j < R; j++) {
								temp_61[a][j] = solution_61[a][j];

							}

						}

					}

					dynamic_access.put(template_61, temp_61);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_62[a]) {

							for (int j = 0; j < R; j++) {
								temp_62[a][j] = solution_62[a][j];

							}

						}
					}

					dynamic_access.put(template_62, temp_62);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_63[a]) {

							for (int j = 0; j < R; j++) {
								temp_63[a][j] = solution_63[a][j];

							}

						}

					}

					dynamic_access.put(template_63, temp_63);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_64[a]) {

							for (int j = 0; j < R; j++) {
								temp_64[a][j] = solution_64[a][j];

							}

						}
					}

					dynamic_access.put(template_64, temp_64);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_65[a]) {

							for (int j = 0; j < R; j++) {
								temp_65[a][j] = solution_65[a][j];

							}

						}

					}

					dynamic_access.put(template_65, temp_65);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_66[a]) {

							for (int j = 0; j < R; j++) {
								temp_66[a][j] = solution_66[a][j];

							}

						}

					}

					dynamic_access.put(template_66, temp_66);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_67[a]) {

							for (int j = 0; j < R; j++) {
								temp_67[a][j] = solution_67[a][j];

							}

						}

					}

					dynamic_access.put(template_67, temp_67);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_68[a]) {

							for (int j = 0; j < R; j++) {
								temp_68[a][j] = solution_68[a][j];

							}

						}

					}

					dynamic_access.put(template_68, temp_68);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_69[a]) {

							for (int j = 0; j < R; j++) {
								temp_69[a][j] = solution_69[a][j];

							}

						}

					}

					dynamic_access.put(template_69, temp_69);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_70[a]) {

							for (int j = 0; j < R; j++) {
								temp_70[a][j] = solution_70[a][j];

							}

						}

					}

					dynamic_access.put(template_70, temp_70);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_71[a]) {

							for (int j = 0; j < R; j++) {
								temp_71[a][j] = solution_71[a][j];

							}

						}

					}

					dynamic_access.put(template_71, temp_71);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_72[a]) {

							for (int j = 0; j < R; j++) {
								temp_72[a][j] = solution_72[a][j];

							}

						}

					}

					dynamic_access.put(template_72, temp_72);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_73[a]) {

							for (int j = 0; j < R; j++) {
								temp_73[a][j] = solution_73[a][j];

							}

						}

					}

					dynamic_access.put(template_73, temp_73);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_74[a]) {

							for (int j = 0; j < R; j++) {
								temp_74[a][j] = solution_74[a][j];

							}

						}

					}

					dynamic_access.put(template_74, temp_74);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_75[a]) {

							for (int j = 0; j < R; j++) {
								temp_75[a][j] = solution_75[a][j];

							}

						}

					}

					dynamic_access.put(template_75, temp_75);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_76[a]) {

							for (int j = 0; j < R; j++) {
								temp_76[a][j] = solution_76[a][j];

							}

						}

					}

					dynamic_access.put(template_76, temp_76);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_77[a]) {

							for (int j = 0; j < R; j++) {
								temp_77[a][j] = solution_77[a][j];

							}

						}

					}

					dynamic_access.put(template_77, temp_77);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_78[a]) {

							for (int j = 0; j < R; j++) {
								temp_78[a][j] = solution_78[a][j];

							}

						}
					}

					dynamic_access.put(template_78, temp_78);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_79[a]) {

							for (int j = 0; j < R; j++) {
								temp_79[a][j] = solution_79[a][j];

							}

						}
					}

					dynamic_access.put(template_79, temp_79);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_80[a]) {

							for (int j = 0; j < R; j++) {
								temp_80[a][j] = solution_80[a][j];

							}

						}

					}

					dynamic_access.put(template_80, temp_80);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_81[a]) {

							for (int j = 0; j < R; j++) {
								temp_81[a][j] = solution_81[a][j];

							}

						}

					}

					dynamic_access.put(template_81, temp_81);

					for (int temp_x = 0; temp_x < pop_num; temp_x++) {

						for (int rr = 0; rr < R; rr++) {

							temp_holder[temp_x][rr] = (x[temp_x][rr]);

						}

					}

					/*
					 * for (int row = 0; row < pop_num; row++) { for (int col = 0; col < R; col++) {
					 * x[row][col] = 0; } }
					 */

					for (String group_key : group_map.keySet()) {

						if (traverse_template.charAt(0) == group_key.charAt(0)) {

							List<String> neighbor_holder = new ArrayList<String>();

							neighbor_holder = group_map.get(group_key);

							int index_getter = 0;

							for (int holders = 0; holders < neighbor_holder.size(); holders++) {

								if (neighbor_holder.get(holders).equals(traverse_template)) {

									for (int i_1 = 0; i_1 < (dynamic_access.get(traverse_template)).length; i_1++) {

										if (index_getter < pop_num) {

											// for (int dimz = 0; dimz < (dynamic_access
											// .get(traverse_template)[i_1]).length; dimz++) {

											if (dynamic_access.get(traverse_template)[i_1][0] == 0
													&& dynamic_access.get(traverse_template)[i_1][1] == 0
													&& dynamic_access.get(traverse_template)[i_1][2] == 0
													&& dynamic_access.get(traverse_template)[i_1][3] == 0
													&& dynamic_access.get(traverse_template)[i_1][4] == 0
													&& dynamic_access.get(traverse_template)[i_1][5] == 0
													&& dynamic_access.get(traverse_template)[i_1][6] == 0

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

										// index_getter++;

										if (index_getter < pop_num) {

											if (dynamic_access.get(tempo)[i_2][0] == 0
													&& dynamic_access.get(tempo)[i_2][1] == 0
													&& dynamic_access.get(tempo)[i_2][2] == 0
													&& dynamic_access.get(tempo)[i_2][3] == 0
													&& dynamic_access.get(tempo)[i_2][4] == 0
													&& dynamic_access.get(tempo)[i_2][5] == 0
													&& dynamic_access.get(tempo)[i_2][6] == 0

											) {

												continue;
											}

											else {

												for (int dimz = 0; dimz < (dynamic_access
														.get(tempo)[i_2]).length; dimz++) {

													x[index_getter][dimz] = dynamic_access.get(tempo)[i_2][dimz];

												}
											}
										}
										index_getter++;
									}

								}
							}
							/*
							 * if (index_getter < pop_num) {
							 * 
							 * int intg = index_getter;
							 * 
							 * for (int temp_t = 0; temp_t < pop_num; temp_t++) {
							 * 
							 * intg++;
							 * 
							 * if (intg < pop_num) {
							 * 
							 * for (int rr_ = 0; rr_ < R; rr_++) {
							 * 
							 * x[intg][rr_] = temp_holder[temp_t][rr_];
							 * 
							 * } } } }
							 */

							break;
						}

					}

					// }
				}
				

				long start_time = System.currentTimeMillis();
				long wait_time = 18750;
				long end_time = start_time + wait_time;
				group_counter++;

				while (System.currentTimeMillis() < end_time) /// not
				
				{

					for (int i = 0; i < pop_num; i++) // Generate a new test case (crossover&mutation)
					{

						int k1 = (int) Math.floor(Math.random() * pop_num); // must not be same as parent
						// execute this code while K1 = i
						while (k1 == i)

							k1 = (int) Math.floor(Math.random() * pop_num);

						int k2 = (int) Math.floor(Math.random() * pop_num);

						while (k2 == i || k2 == k1) // must not be same as parent

							k2 = (int) Math.floor(Math.random() * pop_num);

						int jrand = (int) (Math.random() * R);

						for (int j = 0; j < R; j++) {

							// v[i][j] = (int) Math.round(Math.abs(x[i][j] + F * (x[k1][j] - x[k2][j]))); //
							// parent
							v[i][j] = (int) ((x[i][j] + F * (x[k1][j] - x[k2][j])));

							if (Math.random() <= Pc && j != jrand)

								v[i][j] = x[i][j];

							if (v[i][j] > ub[j] || v[i][j] < lb[j]) {
								// double r01 = Math.random();

								v[i][j] = (int) (Math.random() * ((ub[j] - lb[j]) + 1)) + lb[j];
							}
							// System.out.println("v[i][j]" + v[i][j]);

						}

						///case_num[run] = case_num[run] + 1;

						///total_case_num[run] = total_case_num[run] + 1;

						getfinalpath = pathnum(v[i]);

						traverse_1(getfinalpath, i);
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

								fitnessx_ = benchmarkfunction(x[i], traverse_template);

								// row_getter.put(offspring_population.get(get_row), row_fitter);
								par_obj = fitnessx_.get(1);
								// offspring_singleobjective

								double obj_par = par_obj;

								List<Double> fitnessv_ = new ArrayList<Double>();

								fitnessv_ = benchmarkfunction(v[i], traverse_template);

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
							//Cycle[run]++;
                            break;
						}

						if ((PATHNUM - (pathcounter.get(traverse_template)) > 1)) {

							for (int i = 0; i < pop_num; i++) {

								List<Double> fitnessx = new ArrayList<Double>();
								// align benchmark function to template to evaluate

								fitnessx = benchmarkfunction(x[i], traverse_template);

								List<Double> fitness_objectives_temporary_x = new ArrayList<Double>();

								for (int cop = 1; cop < fitnessx.size(); cop++) {

									fitness_objectives_temporary_x.add(fitnessx.get(cop));
								}

								List<Double> fitnessv = new ArrayList<Double>();

								fitnessv = benchmarkfunction(v[i],  traverse_template);

								List<Double> fitness_objectives_temporary_v = new ArrayList<Double>();


								for (int cop = 1; cop < fitnessv.size(); cop++) {

									fitness_objectives_temporary_v.add(fitnessv.get(cop));
								}


								int returned_comparison;
						
								// comparator
								returned_comparison = dominace_Comparison(fitness_objectives_temporary_x,
										fitness_objectives_temporary_v);

								if (returned_comparison == -1) { // Solution i dominates child
									offspring_population.add("parent" + " " + i);

									// fitness_nonsimple1.put("parent" + " " + i,
									// fitness_objectives_temporary_x);
									combined_maps.put("parent" + " " + i , fitness_objectives_temporary_x);
								} // if
								else if (returned_comparison == 1) { // child dominates
									offspring_population.add("child" + " " + i);
									combined_maps.put("child" + " " + i , fitness_objectives_temporary_v);
					

								} // else if
								else { // the two solutions are non-dominated


									offspring_population.add("parent" + " " + i);
									offspring_population.add("child" + " " + i);
									combined_maps.put("parent" + " " + i , fitness_objectives_temporary_x);
									combined_maps.put("child" + " " + i , fitness_objectives_temporary_v);
									
								} // else
								
							}	
						     //  offspring_population.add("parent" + " " + i);

								// System.out.println("BLOCK_1");
							
						  // n x m matrix of combined parents and offspring test cases
							           							
						

								int fitts = 0;
								LinkedHashMap<String, Double> row_getter = new LinkedHashMap<String, Double>();


								int cols_ = (PATHNUM - (pathcounter.get(traverse_template)));

								int sizes = (cols_);

								double row_fit;
								int colums = 0;
								String test_case;
								double fit_rowfit;
								//double minval;

								List<String> population_set = new ArrayList<String>();
								
							 //	for ( String key : combined_maps.keySet() ) {
							 		
							 	//	population_set.add(key);
							 	//	
								   // System.out.println( key );
							//	}
								
							 //	List<String> combined_population_set = new ArrayList<String>();
							 	
							// 	combined_population_set.addAll(population_set);
								
								Double[][] offspring_fitness_full = new Double[offspring_population
									           									.size()][sizes]; 
								int updates = 0;
								
								
								while (updates < offspring_population.size()) {

									List<Double> fitness_objectives_updated = new ArrayList<Double>();
									// fitness_objectives_updated.clear();

									fitness_objectives_updated = (combined_maps.get(offspring_population.get(updates)));
									

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

									for (int u = 0; u < ((front.length)); u++) {
										front[u] = new LinkedList<Integer>();
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

					


							updated_population.clear();
							offspring_population.clear();
						//	offspring_population2.clear();
							setrank1.clear();
							//setrank2.clear();
							//setrank3.clear();
							fitnessmaps.clear();
							fitnessmaps1.clear();
							fitnessmaps2.clear();
							fitnessmaps3.clear();
							single_population.clear();
							// fitnessmaps2.clear();

						}
						
						
					else {

						//Cycle[run]++;
						break;

				

					}}

				}
				//9  points , 168.75 seconds ,  groupcounter = 9
				if (group_counter == 9) {

					point += 1;
					if (point < 9) {

						convergencegraph[point][run] = (totalpathcounter * 100 / TOTAL_PATHNUM);
					}

					group_counter = 0;
				}
				
				

			}

		}
		
		for (int a = 0; a < 9; a++) // Output the result
    {

            for (int j = 0; j < RUN; j++)

	                System.out.print(convergencegraph[a][j] + " ");

                     System.out.println();

     }

         int x = 0;

          for (int a = 0; a < 9; a++) // Output the result
              {

               for (int j = 0; j < RUN; j++) {

	                  x += convergencegraph[a][j];
                }

                  System.out.println(x);
                     x = 0;

               }
		
		
		
	}

public static String pathnum(int[] x) {

		StringBuilder stringBuilder = new StringBuilder();
		// stringBuilder.append("0"); //for max array just store it. it's by default
		// assigned
		String finalpath = " ";

		boolean[][] truth_table_visit = new boolean[NODENUM][7];

		int i1;
		int i_1;
		int max;
		int[] a4 = new int[7]; // a4 will hold the values in the individual x
		int[] a5_ = new int[7];
		for (i1 = 0; i1 < 7; i1++) {

			a4[i1] = x[i1]; // insert x values into array a4

		}

		a5_[0] = x[7];
		a5_[1] = x[8];
		a5_[2] = x[9];
		a5_[3] = x[10];
		a5_[4] = x[11];
		a5_[5] = x[12];
		a5_[6] = x[13];

		int i;
		for (i = 0; i < 7; i++) {

			if (a4[i] != a5_[i]) {

				if (a4[i] > a5_[i]) {

					truth_table_visit[0][i] = true;
					;
				}

				else {
					truth_table_visit[1][i] = true;
					;
				}

			}

			else {

				truth_table_visit[2][i] = true;

			}
		}

		for (int j = 0; j < 7; j++) { // align the visits to form the correct traversed path

			if ((truth_table_visit[0][j])) {

				stringBuilder.append('a');

			}

			if ((truth_table_visit[1][j])) {

				stringBuilder.append('b');

			}

			if ((truth_table_visit[2][j])) {

				stringBuilder.append('c');

			}

		}

		finalpath = stringBuilder.toString();

		return finalpath; // path traversed by input/test data(x) : capture its id
	}

	public static List<Double> benchmarkfunction(int[] x, String template_id) throws FileNotFoundException // evaluation_of_fitness_for

	{

		/**/

		double[][] fitness_matrix = new double[NODENUM][7];
		List<Double> fit = new ArrayList<Double>();
		// fit.clear();
		boolean[][] benchmark_table_visit = new boolean[NODENUM][7];

		// evaluate divergence at the edge of the vertex per iteration ...

		// if (template_id.equals(traverse_template)) {

		double pattern_violation;

		StringBuilder benchmarkBuilder = new StringBuilder();
		String traversed_pattern;
		String final_vertex_path;
		// String simple_violation = null;
		// String traversed_violation = null;
		// String nonsimple_check = null;
		String nonsimple_violation;

		int pattern_counter;

	//	pattern_counter = pattern_number;
		int i2;
		int i3;

		double exp, exp_1, exp_2, exp_3, exp_4, exp_5, exp_6, exp_7, exp_8, exp_9, exp_10;

		double total_1 = 0.0;

		double fit_1, fit_2, fit_3, fit_4, fit_5, fit_6, fit_7, fit_8, fit_9, fit_10;

		double v1, v2, v3, v4, v5, v6, v7;

		// fitness calculation;

		int r;
		int i_2;
		int max;
		int[] a6 = new int[7]; // a4 will hold the values in the individual x
		int[] a7 = new int[7];

		// int[] a4 = new int[7]; // a4 will hold the values in the individual x
		// int[] a5 = new int[7];
		int i_1;
		for (i_1 = 0; i_1 < 7; i_1++) {

			a6[i_1] = x[i_1]; // insert x values into array a4

		}

		a7[0] = x[7];
		a7[1] = x[8];
		a7[2] = x[9];
		a7[3] = x[10];
		a7[4] = x[11];
		a7[5] = x[12];
		a7[6] = x[13];

		for (r = 0; r < 7; r++) {

			if (a6[r] != a7[r]) {

				if (a6[r] > a7[r]) {

					v1 = 0.0;

					fitness_matrix[0][r] = v1;

				}

				else {

					fit_1 = (a7[r] - a6[r]) +  bias;

					exp_1 = Math.pow(1.001, -(fit_1));

					v2 = (1 - exp_1);

					fitness_matrix[0][r] = v2;
				}
			}
			
			else {
				
				fit_8 = bias;

				exp_4 = Math.pow(1.001, -(fit_8));

				v6 = (1 - exp_4);

				fitness_matrix[0][r] = v6;
				
			}
		}

		for (i_2 = 0; i_2 < 7; i_2++) {

			if (a6[i_2] != a7[i_2]) {

				if (a6[i_2] <= a7[i_2]) {

					v3 = 0.0;

					fitness_matrix[1][i_2] = v3;

				}

				else {

					fit_1 = (a6[i_2] - a7[i_2]) +  bias;

					exp_1 = Math.pow(1.001, -(fit_1));

					v3 = (1 - exp_1);

					fitness_matrix[1][i_2] = v3;
				}
			}
			
			
			else {
				
					fit_8 =   bias;

					exp_4 = Math.pow(1.001, -(fit_8));

					v6 = (1 - exp_4);

					fitness_matrix[1][i_2] = v6;
			
			}
		}

		int i_3;

		for (i_3 = 0; i_3 < 7; i_3++) {

			if (a6[i_3] != a7[i_3]) {

				v5 = Math.abs(a6[i_3] - a7[i_3]) +  bias ;

				exp_1 = Math.pow(1.001, -(v5));

				v4 = (1 - exp_1);

				fitness_matrix[2][i_3] = v4;

			} else {

				v4 = 0.0;

				fitness_matrix[2][i_3] = v4;

			}

		}

		int i1;

		int[] a4 = new int[7]; // a4 will hold the values in the individual x
		int[] a5 = new int[7];
		for (i1 = 0; i1 < 7; i1++) {

			a4[i1] = x[i1]; // insert x values into array a4

		}

		a5[0] = x[7];
		a5[1] = x[8];
		a5[2] = x[9];
		a5[3] = x[10];
		a5[4] = x[11];
		a5[5] = x[12];
		a5[6] = x[13];

		int i;
		for (i = 0; i < 7; i++) {

			if (a4[i] != a5[i]) {

				if (a4[i] > a5[i]) {

					benchmark_table_visit[0][i] = true;
					
				}

				else {

					benchmark_table_visit[1][i] = true;
					
				}

			}

			else {

				benchmark_table_visit[2][i] = true;

			}
		}

		for (int j = 0; j < 7; j++) { // align the visits to form the correct traversed path

			if ((benchmark_table_visit[0][j])) {

				benchmarkBuilder.append('a');

			}

			if ((benchmark_table_visit[1][j])) {

				benchmarkBuilder.append('b');

			}

			if ((benchmark_table_visit[2][j])) {

				benchmarkBuilder.append('c');

			}

		}

		final_vertex_path = benchmarkBuilder.toString();

		// String temp_path;

		// nonsimple_violation = final_vertex_path.substring(0,
		// Math.min(final_vertex_path.length(), pattern_number));
		// myText.substring(0, Math.min(6, myText.length())


			String strLine_non;
			//fit.add(non_simpleid2);

			Iterator<Map.Entry<String, Boolean>> iter_simple_ = temporary_path_holder.entrySet().iterator();

			while (iter_simple_.hasNext()) {

				Map.Entry<String, Boolean> entry = iter_simple_.next();

				strLine_non = entry.getKey();

				if (!paths.get(strLine_non)) {

					double Unmatched_branch_node_a_ = 0;
					double Unmatched_branch_node_b_ = 0;
					double Unmatched_branch_node_c_ = 0;

					for (int p = 0; p < 7; p++) {

						if (final_vertex_path.charAt(p) != strLine_non.charAt(p)) {

							if (strLine_non.charAt(p) == 'a') {

								Unmatched_branch_node_a_ += fitness_matrix[0][p];

							}

							if (strLine_non.charAt(p) == 'b') {

								Unmatched_branch_node_b_ += fitness_matrix[1][p];

							}

							if (strLine_non.charAt(p) == 'c') {

								Unmatched_branch_node_c_ += fitness_matrix[2][p];

							}

						}

					}
					double nonsimple_unmatched2 = 0.0;
					nonsimple_unmatched2 = Unmatched_branch_node_a_ + Unmatched_branch_node_b_
							+ Unmatched_branch_node_c_;

					fit.add(nonsimple_unmatched2);
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

		FileOutputStream fos_17 = new FileOutputStream(id_17);
		BufferedWriter bw_17 = new BufferedWriter(new OutputStreamWriter(fos_17));

		FileOutputStream fos_18 = new FileOutputStream(id_18);
		BufferedWriter bw_18 = new BufferedWriter(new OutputStreamWriter(fos_18));

		FileOutputStream fos_19 = new FileOutputStream(id_19);
		BufferedWriter bw_19 = new BufferedWriter(new OutputStreamWriter(fos_19));

		FileOutputStream fos_20 = new FileOutputStream(id_20);
		BufferedWriter bw_20 = new BufferedWriter(new OutputStreamWriter(fos_20));

		FileOutputStream fos_21 = new FileOutputStream(id_21);
		BufferedWriter bw_21 = new BufferedWriter(new OutputStreamWriter(fos_21));

		FileOutputStream fos_22 = new FileOutputStream(id_22);
		BufferedWriter bw_22 = new BufferedWriter(new OutputStreamWriter(fos_22));

		FileOutputStream fos_23 = new FileOutputStream(id_23);
		BufferedWriter bw_23 = new BufferedWriter(new OutputStreamWriter(fos_23));

		FileOutputStream fos_24 = new FileOutputStream(id_24);
		BufferedWriter bw_24 = new BufferedWriter(new OutputStreamWriter(fos_24));

		FileOutputStream fos_25 = new FileOutputStream(id_25);
		BufferedWriter bw_25 = new BufferedWriter(new OutputStreamWriter(fos_25));

		FileOutputStream fos_26 = new FileOutputStream(id_26);
		BufferedWriter bw_26 = new BufferedWriter(new OutputStreamWriter(fos_26));

		FileOutputStream fos_27 = new FileOutputStream(id_27);
		BufferedWriter bw_27 = new BufferedWriter(new OutputStreamWriter(fos_27));

		FileOutputStream fos_28 = new FileOutputStream(id_28);
		BufferedWriter bw_28 = new BufferedWriter(new OutputStreamWriter(fos_28));

		FileOutputStream fos_29 = new FileOutputStream(id_29);
		BufferedWriter bw_29 = new BufferedWriter(new OutputStreamWriter(fos_29));

		FileOutputStream fos_30 = new FileOutputStream(id_30);
		BufferedWriter bw_30 = new BufferedWriter(new OutputStreamWriter(fos_30));

		FileOutputStream fos_31 = new FileOutputStream(id_31);
		BufferedWriter bw_31 = new BufferedWriter(new OutputStreamWriter(fos_31));

		FileOutputStream fos_32 = new FileOutputStream(id_32);
		BufferedWriter bw_32 = new BufferedWriter(new OutputStreamWriter(fos_32));

		FileOutputStream fos_33 = new FileOutputStream(id_33);
		BufferedWriter bw_33 = new BufferedWriter(new OutputStreamWriter(fos_33));

		FileOutputStream fos_34 = new FileOutputStream(id_34);
		BufferedWriter bw_34 = new BufferedWriter(new OutputStreamWriter(fos_34));

		FileOutputStream fos_35 = new FileOutputStream(id_35);
		BufferedWriter bw_35 = new BufferedWriter(new OutputStreamWriter(fos_35));

		FileOutputStream fos_36 = new FileOutputStream(id_36);
		BufferedWriter bw_36 = new BufferedWriter(new OutputStreamWriter(fos_36));

		FileOutputStream fos_37 = new FileOutputStream(id_37);
		BufferedWriter bw_37 = new BufferedWriter(new OutputStreamWriter(fos_37));

		FileOutputStream fos_38 = new FileOutputStream(id_38);
		BufferedWriter bw_38 = new BufferedWriter(new OutputStreamWriter(fos_38));

		FileOutputStream fos_39 = new FileOutputStream(id_39);
		BufferedWriter bw_39 = new BufferedWriter(new OutputStreamWriter(fos_39));

		FileOutputStream fos_40 = new FileOutputStream(id_40);
		BufferedWriter bw_40 = new BufferedWriter(new OutputStreamWriter(fos_40));

		FileOutputStream fos_41 = new FileOutputStream(id_41);
		BufferedWriter bw_41 = new BufferedWriter(new OutputStreamWriter(fos_41));

		FileOutputStream fos_42 = new FileOutputStream(id_42);
		BufferedWriter bw_42 = new BufferedWriter(new OutputStreamWriter(fos_42));

		FileOutputStream fos_43 = new FileOutputStream(id_43);
		BufferedWriter bw_43 = new BufferedWriter(new OutputStreamWriter(fos_43));

		FileOutputStream fos_44 = new FileOutputStream(id_44);
		BufferedWriter bw_44 = new BufferedWriter(new OutputStreamWriter(fos_44));

		FileOutputStream fos_45 = new FileOutputStream(id_45);
		BufferedWriter bw_45 = new BufferedWriter(new OutputStreamWriter(fos_45));

		FileOutputStream fos_46 = new FileOutputStream(id_46);
		BufferedWriter bw_46 = new BufferedWriter(new OutputStreamWriter(fos_46));

		FileOutputStream fos_47 = new FileOutputStream(id_47);
		BufferedWriter bw_47 = new BufferedWriter(new OutputStreamWriter(fos_47));

		FileOutputStream fos_48 = new FileOutputStream(id_48);
		BufferedWriter bw_48 = new BufferedWriter(new OutputStreamWriter(fos_48));

		FileOutputStream fos_49 = new FileOutputStream(id_49);
		BufferedWriter bw_49 = new BufferedWriter(new OutputStreamWriter(fos_49));

		FileOutputStream fos_50 = new FileOutputStream(id_50);
		BufferedWriter bw_50 = new BufferedWriter(new OutputStreamWriter(fos_50));

		FileOutputStream fos_51 = new FileOutputStream(id_51);
		BufferedWriter bw_51 = new BufferedWriter(new OutputStreamWriter(fos_51));

		FileOutputStream fos_52 = new FileOutputStream(id_52);
		BufferedWriter bw_52 = new BufferedWriter(new OutputStreamWriter(fos_52));

		FileOutputStream fos_53 = new FileOutputStream(id_53);
		BufferedWriter bw_53 = new BufferedWriter(new OutputStreamWriter(fos_53));

		FileOutputStream fos_54 = new FileOutputStream(id_54);
		BufferedWriter bw_54 = new BufferedWriter(new OutputStreamWriter(fos_54));

		FileOutputStream fos_55 = new FileOutputStream(id_55);
		BufferedWriter bw_55 = new BufferedWriter(new OutputStreamWriter(fos_55));

		FileOutputStream fos_56 = new FileOutputStream(id_56);
		BufferedWriter bw_56 = new BufferedWriter(new OutputStreamWriter(fos_56));

		FileOutputStream fos_57 = new FileOutputStream(id_57);
		BufferedWriter bw_57 = new BufferedWriter(new OutputStreamWriter(fos_57));

		FileOutputStream fos_58 = new FileOutputStream(id_58);
		BufferedWriter bw_58 = new BufferedWriter(new OutputStreamWriter(fos_58));

		FileOutputStream fos_59 = new FileOutputStream(id_59);
		BufferedWriter bw_59 = new BufferedWriter(new OutputStreamWriter(fos_59));

		FileOutputStream fos_60 = new FileOutputStream(id_60);
		BufferedWriter bw_60 = new BufferedWriter(new OutputStreamWriter(fos_60));

		FileOutputStream fos_61 = new FileOutputStream(id_61);
		BufferedWriter bw_61 = new BufferedWriter(new OutputStreamWriter(fos_61));

		FileOutputStream fos_62 = new FileOutputStream(id_62);
		BufferedWriter bw_62 = new BufferedWriter(new OutputStreamWriter(fos_62));

		FileOutputStream fos_63 = new FileOutputStream(id_63);
		BufferedWriter bw_63 = new BufferedWriter(new OutputStreamWriter(fos_63));

		FileOutputStream fos_64 = new FileOutputStream(id_64);
		BufferedWriter bw_64 = new BufferedWriter(new OutputStreamWriter(fos_64));

		FileOutputStream fos_65 = new FileOutputStream(id_65);
		BufferedWriter bw_65 = new BufferedWriter(new OutputStreamWriter(fos_65));

		FileOutputStream fos_66 = new FileOutputStream(id_66);
		BufferedWriter bw_66 = new BufferedWriter(new OutputStreamWriter(fos_66));

		FileOutputStream fos_67 = new FileOutputStream(id_67);
		BufferedWriter bw_67 = new BufferedWriter(new OutputStreamWriter(fos_67));

		FileOutputStream fos_68 = new FileOutputStream(id_68);
		BufferedWriter bw_68 = new BufferedWriter(new OutputStreamWriter(fos_68));

		FileOutputStream fos_69 = new FileOutputStream(id_69);
		BufferedWriter bw_69 = new BufferedWriter(new OutputStreamWriter(fos_69));

		FileOutputStream fos_70 = new FileOutputStream(id_70);
		BufferedWriter bw_70 = new BufferedWriter(new OutputStreamWriter(fos_70));

		FileOutputStream fos_71 = new FileOutputStream(id_71);
		BufferedWriter bw_71 = new BufferedWriter(new OutputStreamWriter(fos_71));

		FileOutputStream fos_72 = new FileOutputStream(id_72);
		BufferedWriter bw_72 = new BufferedWriter(new OutputStreamWriter(fos_72));

		FileOutputStream fos_73 = new FileOutputStream(id_73);
		BufferedWriter bw_73 = new BufferedWriter(new OutputStreamWriter(fos_73));

		FileOutputStream fos_74 = new FileOutputStream(id_74);
		BufferedWriter bw_74 = new BufferedWriter(new OutputStreamWriter(fos_74));

		FileOutputStream fos_75 = new FileOutputStream(id_75);
		BufferedWriter bw_75 = new BufferedWriter(new OutputStreamWriter(fos_75));

		FileOutputStream fos_76 = new FileOutputStream(id_76);
		BufferedWriter bw_76 = new BufferedWriter(new OutputStreamWriter(fos_76));

		FileOutputStream fos_77 = new FileOutputStream(id_77);
		BufferedWriter bw_77 = new BufferedWriter(new OutputStreamWriter(fos_77));

		FileOutputStream fos_78 = new FileOutputStream(id_78);
		BufferedWriter bw_78 = new BufferedWriter(new OutputStreamWriter(fos_78));

		FileOutputStream fos_79 = new FileOutputStream(id_79);
		BufferedWriter bw_79 = new BufferedWriter(new OutputStreamWriter(fos_79));

		FileOutputStream fos_80 = new FileOutputStream(id_80);
		BufferedWriter bw_80 = new BufferedWriter(new OutputStreamWriter(fos_80));

		FileOutputStream fos_81 = new FileOutputStream(id_81);
		BufferedWriter bw_81 = new BufferedWriter(new OutputStreamWriter(fos_81));

		Set<String> keyz = paths.keySet();

		for (String key : keyz) {

			bw_all.write(key); // write to file
			bw_all.newLine();

			if (key.startsWith("aaaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_1.write(key); // write to file
				bw_1.newLine();

				// group2.put(key, false);

				if (!pathcounter.containsKey("aaaa")) {

					pathcounter.put("aaaa", 0);
					evaluated_status.put("aaaa", false);
				}

			}

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

			if (key.startsWith("aaac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_3.write(key); // write to file
				bw_3.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("aaac")) {

					pathcounter.put("aaac", 0);
					evaluated_status.put("aaac", false);
				}

			}

			if (key.startsWith("aaba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_4.write(key); // write to file
				bw_4.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("aaba")) {

					pathcounter.put("aaba", 0);
					evaluated_status.put("aaba", false);
				}

			}

			if (key.startsWith("aabb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_5.write(key); // write to file
				bw_5.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("aabb")) {

					pathcounter.put("aabb", 0);
					evaluated_status.put("aabb", false);
				}

			}

			if (key.startsWith("aabc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_6.write(key); // write to file
				bw_6.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("aabc")) {

					pathcounter.put("aabc", 0);
					evaluated_status.put("aabc", false);
				}

			}

			if (key.startsWith("aaca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_7.write(key); // write to file
				bw_7.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("aaca")) {

					pathcounter.put("aaca", 0);
					evaluated_status.put("aaca", false);
				}

			}

			if (key.startsWith("aacb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_8.write(key); // write to file
				bw_8.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("aacb")) {

					pathcounter.put("aacb", 0);
					evaluated_status.put("aacb", false);
				}

			}

			if (key.startsWith("aacc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_9.write(key); // write to file
				bw_9.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("aacc")) {

					pathcounter.put("aacc", 0);
					evaluated_status.put("aacc", false);
				}

			}

			if (key.startsWith("abaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_10.write(key); // write to file
				bw_10.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("abaa")) {

					pathcounter.put("abaa", 0);
					evaluated_status.put("abaa", false);
				}

			}

			if (key.startsWith("abab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_11.write(key); // write to file
				bw_11.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("abab")) {

					pathcounter.put("abab", 0);
					evaluated_status.put("abab", false);
				}

			}

			if (key.startsWith("abac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_12.write(key); // write to file
				bw_12.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("abac")) {

					pathcounter.put("abac", 0);
					evaluated_status.put("abac", false);
				}
			}

			if (key.startsWith("abba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_13.write(key); // write to file
				bw_13.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("abba")) {

					pathcounter.put("abba", 0);
					evaluated_status.put("abba", false);
				}

			}

			if (key.startsWith("abbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_14.write(key); // write to file
				bw_14.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("abbb")) {

					pathcounter.put("abbb", 0);
					evaluated_status.put("abbb", false);
				}

			}

			if (key.startsWith("abbc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_15.write(key); // write to file
				bw_15.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("abbc")) {

					pathcounter.put("abbc", 0);
					evaluated_status.put("abbc", false);

				}

			}

			if (key.startsWith("abca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_16.write(key); // write to file
				bw_16.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("abca")) {

					pathcounter.put("abca", 0);
					evaluated_status.put("abca", false);

				}

			}

			if (key.startsWith("abcb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_17.write(key); // write to file
				bw_17.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("abcb")) {

					pathcounter.put("abcb", 0);
					evaluated_status.put("abcb", false);
				}

			}

			/*******************************************************************************************************/

			if (key.startsWith("abcc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_18.write(key); // write to file
				bw_18.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("abcc")) {

					pathcounter.put("abcc", 0);
					evaluated_status.put("abcc", false);
				}

			}

			if (key.startsWith("acaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_19.write(key); // write to file
				bw_19.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("acaa")) {

					pathcounter.put("acaa", 0);
					evaluated_status.put("acaa", false);
				}

			}

			if (key.startsWith("acab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_20.write(key); // write to file
				bw_20.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("acab")) {

					pathcounter.put("acab", 0);
					evaluated_status.put("acab", false);
				}

			}

			if (key.startsWith("acac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_21.write(key); // write to file
				bw_21.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("acac")) {

					pathcounter.put("acac", 0);
					evaluated_status.put("acac", false);
				}

			}

			if (key.startsWith("acba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_22.write(key); // write to file
				bw_22.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("acba")) {

					pathcounter.put("acba", 0);
					evaluated_status.put("acba", false);
				}

			}

			if (key.startsWith("acbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_23.write(key); // write to file
				bw_23.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("acbb")) {

					pathcounter.put("acbb", 0);
					evaluated_status.put("acbb", false);
				}

			}

			if (key.startsWith("acbc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_24.write(key); // write to file
				bw_24.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("acbc")) {

					pathcounter.put("acbc", 0);
					evaluated_status.put("acbc", false);
				}

			}

			if (key.startsWith("acca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_25.write(key); // write to file
				bw_25.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("acca")) {

					pathcounter.put("acca", 0);
					evaluated_status.put("acca", false);
				}

			}

			if (key.startsWith("accb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_26.write(key); // write to file
				bw_26.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("accb")) {

					pathcounter.put("accb", 0);
					evaluated_status.put("accb", false);
				}

			}

			if (key.startsWith("accc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_27.write(key); // write to file
				bw_27.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("accc")) {

					pathcounter.put("accc", 0);
					evaluated_status.put("accc", false);
				}
			}

			if (key.startsWith("baaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_28.write(key); // write to file
				bw_28.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("baaa")) {

					pathcounter.put("baaa", 0);
					evaluated_status.put("baaa", false);
				}

			}

			if (key.startsWith("baab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_29.write(key); // write to file
				bw_29.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("baab")) {

					pathcounter.put("baab", 0);
					evaluated_status.put("baab", false);
				}

			}

			if (key.startsWith("baac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_30.write(key); // write to file
				bw_30.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("baac")) {

					pathcounter.put("baac", 0);
					evaluated_status.put("baac", false);

				}

			}

			if (key.startsWith("baba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_31.write(key); // write to file
				bw_31.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("baba")) {

					pathcounter.put("baba", 0);
					evaluated_status.put("baba", false);

				}

			}

			if (key.startsWith("babb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_32.write(key); // write to file
				bw_32.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("babb")) {

					pathcounter.put("babb", 0);
					evaluated_status.put("babb", false);
				}

			}

			/***********************************************************************************************************/

			if (key.startsWith("babc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_33.write(key); // write to file
				bw_33.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("babc")) {

					pathcounter.put("babc", 0);
					evaluated_status.put("babc", false);
				}

			}

			if (key.startsWith("baca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_34.write(key); // write to file
				bw_34.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("baca")) {

					pathcounter.put("baca", 0);
					evaluated_status.put("baca", false);
				}

			}

			if (key.startsWith("bacb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_35.write(key); // write to file
				bw_35.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("bacb")) {

					pathcounter.put("bacb", 0);
					evaluated_status.put("bacb", false);
				}

			}

			if (key.startsWith("bacc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_36.write(key); // write to file
				bw_36.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("bacc")) {

					pathcounter.put("bacc", 0);
					evaluated_status.put("bacc", false);
				}

			}

			if (key.startsWith("bbaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_37.write(key); // write to file
				bw_37.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("bbaa")) {

					pathcounter.put("bbaa", 0);
					evaluated_status.put("bbaa", false);
				}

			}

			if (key.startsWith("bbab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_38.write(key); // write to file
				bw_38.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("bbab")) {

					pathcounter.put("bbab", 0);
					evaluated_status.put("bbab", false);
				}

			}

			if (key.startsWith("bbac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_39.write(key); // write to file
				bw_39.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("bbac")) {

					pathcounter.put("bbac", 0);
					evaluated_status.put("bbac", false);
				}

			}

			if (key.startsWith("bbba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_40.write(key); // write to file
				bw_40.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("bbba")) {

					pathcounter.put("bbba", 0);
					evaluated_status.put("bbba", false);
				}

			}

			if (key.startsWith("bbbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_41.write(key); // write to file
				bw_41.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("bbbb")) {

					pathcounter.put("bbbb", 0);
					evaluated_status.put("bbbb", false);
				}

			}

			if (key.startsWith("bbbc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_42.write(key); // write to file
				bw_42.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("bbbc")) {

					pathcounter.put("bbbc", 0);
					evaluated_status.put("bbbc", false);
				}
			}

			if (key.startsWith("bbca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_43.write(key); // write to file
				bw_43.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("bbca")) {

					pathcounter.put("bbca", 0);
					evaluated_status.put("bbca", false);
				}

			}

			if (key.startsWith("bbcb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_44.write(key); // write to file
				bw_44.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("bbcb")) {

					pathcounter.put("bbcb", 0);
					evaluated_status.put("bbcb", false);
				}

			}

			if (key.startsWith("bbcc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_45.write(key); // write to file
				bw_45.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("bbcc")) {

					pathcounter.put("bbcc", 0);
					evaluated_status.put("bbcc", false);

				}

			}

			if (key.startsWith("bcaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_46.write(key); // write to file
				bw_46.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("bcaa")) {

					pathcounter.put("bcaa", 0);
					evaluated_status.put("bcaa", false);

				}

			}

			if (key.startsWith("bcab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_47.write(key); // write to file
				bw_47.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("bcab")) {

					pathcounter.put("bcab", 0);
					evaluated_status.put("bcab", false);
				}

			}

			/********************************************************************************************************/

			if (key.startsWith("bcac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_48.write(key); // write to file
				bw_48.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("bcac")) {

					pathcounter.put("bcac", 0);
					evaluated_status.put("bcac", false);
				}

			}

			if (key.startsWith("bcba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_49.write(key); // write to file
				bw_49.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("bcba")) {

					pathcounter.put("bcba", 0);
					evaluated_status.put("bcba", false);
				}

			}

			if (key.startsWith("bcbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_50.write(key); // write to file
				bw_50.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("bcbb")) {

					pathcounter.put("bcbb", 0);
					evaluated_status.put("bcbb", false);
				}

			}

			if (key.startsWith("bcbc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_51.write(key); // write to file
				bw_51.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("bcbc")) {

					pathcounter.put("bcbc", 0);
					evaluated_status.put("bcbc", false);
				}

			}

			if (key.startsWith("bcca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_52.write(key); // write to file
				bw_52.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("bcca")) {

					pathcounter.put("bcca", 0);
					evaluated_status.put("bcca", false);
				}

			}

			if (key.startsWith("bccb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_53.write(key); // write to file
				bw_53.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("bccb")) {

					pathcounter.put("bccb", 0);
					evaluated_status.put("bccb", false);
				}

			}

			if (key.startsWith("bccc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_54.write(key); // write to file
				bw_54.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("bccc")) {

					pathcounter.put("bccc", 0);
					evaluated_status.put("bccc", false);
				}

			}

			if (key.startsWith("caaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_55.write(key); // write to file
				bw_55.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("caaa")) {

					pathcounter.put("caaa", 0);
					evaluated_status.put("caaa", false);
				}

			}

			if (key.startsWith("caab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_56.write(key); // write to file
				bw_56.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("caab")) {

					pathcounter.put("caab", 0);
					evaluated_status.put("caab", false);
				}

			}

			if (key.startsWith("caac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_57.write(key); // write to file
				bw_57.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("caac")) {

					pathcounter.put("caac", 0);
					evaluated_status.put("caac", false);
				}
			}

			if (key.startsWith("caba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_58.write(key); // write to file
				bw_58.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("caba")) {

					pathcounter.put("caba", 0);
					evaluated_status.put("caba", false);
				}

			}

			if (key.startsWith("cabb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_59.write(key); // write to file
				bw_59.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("cabb")) {

					pathcounter.put("cabb", 0);
					evaluated_status.put("cabb", false);
				}

			}

			if (key.startsWith("cabc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_60.write(key); // write to file
				bw_60.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("cabc")) {

					pathcounter.put("cabc", 0);
					evaluated_status.put("cabc", false);

				}

			}

			if (key.startsWith("caca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_61.write(key); // write to file
				bw_61.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("caca")) {

					pathcounter.put("caca", 0);
					evaluated_status.put("caca", false);

				}

			}

			if (key.startsWith("cacb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_62.write(key); // write to file
				bw_62.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("cacb")) {

					pathcounter.put("cacb", 0);
					evaluated_status.put("cacb", false);
				}

			}

			/**************************************************************************************************************/

			if (key.startsWith("cacc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_63.write(key); // write to file
				bw_63.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("cacc")) {

					pathcounter.put("cacc", 0);
					evaluated_status.put("cacc", false);
				}

			}

			if (key.startsWith("cbaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_64.write(key); // write to file
				bw_64.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("cbaa")) {

					pathcounter.put("cbaa", 0);
					evaluated_status.put("cbaa", false);
				}

			}

			if (key.startsWith("cbab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_65.write(key); // write to file
				bw_65.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("cbab")) {

					pathcounter.put("cbab", 0);
					evaluated_status.put("cbab", false);
				}

			}

			if (key.startsWith("cbac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_66.write(key); // write to file
				bw_66.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("cbac")) {

					pathcounter.put("cbac", 0);
					evaluated_status.put("cbac", false);
				}

			}

			if (key.startsWith("cbba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_67.write(key); // write to file
				bw_67.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("cbba")) {

					pathcounter.put("cbba", 0);
					evaluated_status.put("cbba", false);
				}

			}

			if (key.startsWith("cbbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_68.write(key); // write to file
				bw_68.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("cbbb")) {

					pathcounter.put("cbbb", 0);
					evaluated_status.put("cbbb", false);
				}

			}

			if (key.startsWith("cbbc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_69.write(key); // write to file
				bw_69.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("cbbc")) {

					pathcounter.put("cbbc", 0);
					evaluated_status.put("cbbc", false);
				}

			}

			if (key.startsWith("cbca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_70.write(key); // write to file
				bw_70.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("cbca")) {

					pathcounter.put("cbca", 0);
					evaluated_status.put("cbca", false);
				}

			}

			if (key.startsWith("cbcb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_71.write(key); // write to file
				bw_71.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("cbcb")) {

					pathcounter.put("cbcb", 0);
					evaluated_status.put("cbcb", false);
				}

			}

			if (key.startsWith("cbcc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_72.write(key); // write to file
				bw_72.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("cbcc")) {

					pathcounter.put("cbcc", 0);
					evaluated_status.put("cbcc", false);
				}
			}

			if (key.startsWith("ccaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_73.write(key); // write to file
				bw_73.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("ccaa")) {

					pathcounter.put("ccaa", 0);
					evaluated_status.put("ccaa", false);
				}

			}

			if (key.startsWith("ccab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_74.write(key); // write to file
				bw_74.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("ccab")) {

					pathcounter.put("ccab", 0);
					evaluated_status.put("ccab", false);
				}

			}

			if (key.startsWith("ccac")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_75.write(key); // write to file
				bw_75.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("ccac")) {

					pathcounter.put("ccac", 0);
					evaluated_status.put("ccac", false);

				}

			}

			if (key.startsWith("ccba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_76.write(key); // write to file
				bw_76.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("ccba")) {

					pathcounter.put("ccba", 0);
					evaluated_status.put("ccba", false);

				}

			}

			if (key.startsWith("ccbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_77.write(key); // write to file
				bw_77.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("ccbb")) {

					pathcounter.put("ccbb", 0);
					evaluated_status.put("ccbb", false);
				}

			}

			/***************************************************************************************************************/

			if (key.startsWith("ccbc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_78.write(key); // write to file
				bw_78.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("ccbc")) {

					pathcounter.put("ccbc", 0);
					evaluated_status.put("ccbc", false);
				}

			}

			if (key.startsWith("ccca")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_79.write(key); // write to file
				bw_79.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("ccca")) {

					pathcounter.put("ccca", 0);
					evaluated_status.put("ccca", false);
				}

			}

			if (key.startsWith("cccb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_80.write(key); // write to file
				bw_80.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("cccb")) {

					pathcounter.put("cccb", 0);
					evaluated_status.put("cccb", false);
				}

			}

			if (key.startsWith("cccc")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_81.write(key); // write to file
				bw_81.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("cccc")) {

					pathcounter.put("cccc", 0);
					evaluated_status.put("cccc", false);
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
		bw_17.close();
		bw_18.close();
		bw_19.close();
		bw_20.close();
		bw_21.close();
		bw_22.close();
		bw_23.close();
		bw_24.close();
		bw_25.close();
		bw_26.close();
		bw_27.close();
		bw_28.close();
		bw_29.close();
		bw_30.close();
		bw_31.close();
		bw_32.close();
		bw_33.close();
		bw_34.close();
		bw_35.close();
		bw_36.close();
		bw_37.close();
		bw_38.close();
		bw_39.close();
		bw_40.close();
		bw_41.close();
		bw_42.close();
		bw_43.close();
		bw_44.close();
		bw_45.close();
		bw_46.close();
		bw_47.close();
		bw_48.close();
		bw_49.close();
		bw_50.close();
		bw_51.close();
		bw_52.close();
		bw_53.close();
		bw_54.close();
		bw_55.close();
		bw_56.close();
		bw_57.close();
		bw_58.close();
		bw_59.close();
		bw_60.close();
		bw_61.close();
		bw_62.close();
		bw_63.close();
		bw_64.close();
		bw_65.close();
		bw_66.close();
		bw_67.close();
		bw_68.close();
		bw_69.close();
		bw_70.close();
		bw_71.close();
		bw_72.close();
		bw_73.close();
		bw_74.close();
		bw_75.close();
		bw_76.close();
		bw_77.close();
		bw_78.close();
		bw_79.close();
		bw_80.close();
		bw_81.close();

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
		pathcounter.put(template_17, 0);
		pathcounter.put(template_18, 0);
		pathcounter.put(template_19, 0);
		pathcounter.put(template_20, 0);
		pathcounter.put(template_21, 0);
		pathcounter.put(template_22, 0);
		pathcounter.put(template_23, 0);
		pathcounter.put(template_24, 0);
		pathcounter.put(template_25, 0);
		pathcounter.put(template_26, 0);
		pathcounter.put(template_27, 0);
		pathcounter.put(template_28, 0);
		pathcounter.put(template_29, 0);
		pathcounter.put(template_30, 0);
		pathcounter.put(template_31, 0);
		pathcounter.put(template_32, 0);
		pathcounter.put(template_33, 0);
		pathcounter.put(template_34, 0);
		pathcounter.put(template_35, 0);
		pathcounter.put(template_36, 0);
		pathcounter.put(template_37, 0);
		pathcounter.put(template_38, 0);
		pathcounter.put(template_39, 0);
		pathcounter.put(template_40, 0);
		pathcounter.put(template_41, 0);
		pathcounter.put(template_42, 0);
		pathcounter.put(template_43, 0);
		pathcounter.put(template_44, 0);
		pathcounter.put(template_45, 0);
		pathcounter.put(template_46, 0);
		pathcounter.put(template_47, 0);
		pathcounter.put(template_48, 0);
		pathcounter.put(template_49, 0);
		pathcounter.put(template_50, 0);
		pathcounter.put(template_51, 0);
		pathcounter.put(template_52, 0);
		pathcounter.put(template_53, 0);
		pathcounter.put(template_54, 0);
		pathcounter.put(template_55, 0);
		pathcounter.put(template_56, 0);
		pathcounter.put(template_57, 0);
		pathcounter.put(template_58, 0);
		pathcounter.put(template_59, 0);
		pathcounter.put(template_60, 0);
		pathcounter.put(template_61, 0);
		pathcounter.put(template_62, 0);
		pathcounter.put(template_63, 0);
		pathcounter.put(template_64, 0);
		pathcounter.put(template_65, 0);
		pathcounter.put(template_66, 0);
		pathcounter.put(template_67, 0);
		pathcounter.put(template_68, 0);
		pathcounter.put(template_69, 0);
		pathcounter.put(template_70, 0);
		pathcounter.put(template_71, 0);
		pathcounter.put(template_72, 0);
		pathcounter.put(template_73, 0);
		pathcounter.put(template_74, 0);
		pathcounter.put(template_75, 0);
		pathcounter.put(template_76, 0);
		pathcounter.put(template_77, 0);
		pathcounter.put(template_78, 0);
		pathcounter.put(template_79, 0);
		pathcounter.put(template_80, 0);
		pathcounter.put(template_81, 0);

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
		evaluated_status.put(template_17, false);
		evaluated_status.put(template_18, false);
		evaluated_status.put(template_19, false);
		evaluated_status.put(template_20, false);
		evaluated_status.put(template_21, false);
		evaluated_status.put(template_22, false);
		evaluated_status.put(template_23, false);
		evaluated_status.put(template_24, false);
		evaluated_status.put(template_25, false);
		evaluated_status.put(template_26, false);
		evaluated_status.put(template_27, false);
		evaluated_status.put(template_28, false);
		evaluated_status.put(template_29, false);
		evaluated_status.put(template_30, false);
		evaluated_status.put(template_31, false);
		evaluated_status.put(template_32, false);
		evaluated_status.put(template_33, false);
		evaluated_status.put(template_34, false);
		evaluated_status.put(template_35, false);
		evaluated_status.put(template_36, false);
		evaluated_status.put(template_37, false);
		evaluated_status.put(template_38, false);
		evaluated_status.put(template_39, false);
		evaluated_status.put(template_40, false);
		evaluated_status.put(template_41, false);
		evaluated_status.put(template_42, false);
		evaluated_status.put(template_43, false);
		evaluated_status.put(template_44, false);
		evaluated_status.put(template_45, false);
		evaluated_status.put(template_46, false);
		evaluated_status.put(template_47, false);
		evaluated_status.put(template_48, false);
		evaluated_status.put(template_49, false);
		evaluated_status.put(template_50, false);
		evaluated_status.put(template_51, false);
		evaluated_status.put(template_52, false);
		evaluated_status.put(template_53, false);
		evaluated_status.put(template_54, false);
		evaluated_status.put(template_55, false);
		evaluated_status.put(template_56, false);
		evaluated_status.put(template_57, false);
		evaluated_status.put(template_58, false);
		evaluated_status.put(template_59, false);
		evaluated_status.put(template_60, false);
		evaluated_status.put(template_61, false);
		evaluated_status.put(template_62, false);
		evaluated_status.put(template_63, false);
		evaluated_status.put(template_64, false);
		evaluated_status.put(template_65, false);
		evaluated_status.put(template_66, false);
		evaluated_status.put(template_67, false);
		evaluated_status.put(template_68, false);
		evaluated_status.put(template_69, false);
		evaluated_status.put(template_70, false);
		evaluated_status.put(template_71, false);
		evaluated_status.put(template_72, false);
		evaluated_status.put(template_73, false);
		evaluated_status.put(template_74, false);
		evaluated_status.put(template_75, false);
		evaluated_status.put(template_76, false);
		evaluated_status.put(template_77, false);
		evaluated_status.put(template_78, false);
		evaluated_status.put(template_79, false);
		evaluated_status.put(template_80, false);
		evaluated_status.put(template_81, false);

		// reload the path map with all the paths
		try {
			File fstream_temporary = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/All.txt");
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

	public static void traverse(String getfinalpath, int i) {

		String final_path_checker = getfinalpath;

		if (final_path_checker.startsWith(template_1)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_1 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaaa.txt");
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

							int g_31 = 0;
							int va_31 = pathcounter.get(template_1);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_1, fin_31);

							if (!statu_1[counter1]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_1[counter1][s] = x[i][s];

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

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_2)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_2 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaab.txt");
				FileReader fileReader_2 = new FileReader(file_2);
				BufferedReader br_2 = new BufferedReader(fileReader_2);

				String strLine_2;
				// Read File Line By Line

				int counter2 = -1;
				while ((strLine_2 = br_2.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter2++;
					if (strLine_2.equals(getfinalpath)) {

						if (paths.get(strLine_2)) {
							break;
						} else {
							paths.put(strLine_2, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_2);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_2, fin_32);

							// break;

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

		else if (final_path_checker.startsWith(template_3)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_3 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaac.txt");
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

		else if (final_path_checker.startsWith(template_4)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_4 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaba.txt");
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

							int g_34 = 0;
							int va_34 = pathcounter.get(template_4);

							g_34++;
							int fin_34 = va_34 + g_34;

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

		else if (final_path_checker.startsWith(template_5)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_5 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aabb.txt");
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

							int g_35 = 0;
							int va_35 = pathcounter.get(template_5);

							g_35++;
							int fin_35 = va_35 + g_35;

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

		else if (final_path_checker.startsWith(template_6)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_6 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aabc.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_7)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_7 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaca.txt");
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

		else if (final_path_checker.startsWith(template_8)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_8 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aacb.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_9)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_9 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aacc.txt");
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

		else if (final_path_checker.startsWith(template_10)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_10 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abaa.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_11)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_11 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abab.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_12)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_12 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abac.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_13)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_13 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abba.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_14)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_14 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abbb.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_15)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_15 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abbc.txt");
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
						} else {
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

		else if (final_path_checker.startsWith(template_16)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_16 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abca.txt");
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

		else if (final_path_checker.startsWith(template_17)) { // if the traversed path_id is equal to "the template
																// id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_17 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abcb.txt");
				FileReader fileReader_17 = new FileReader(file_17);
				BufferedReader br_17 = new BufferedReader(fileReader_17);

				String strLine_17;

				int counter17 = -1;
				while ((strLine_17 = br_17.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter17++;

					if (strLine_17.equals(getfinalpath)) {

						if (paths.get(strLine_17)) {
							break;
						}

						else {
							paths.put(strLine_17, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_17);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_17, fin_31);

							if (!statu_17[counter17]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_17[counter17][s] = x[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_17[counter17] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_17++;

								totalpathcounter++;

								break;
							}
						}
					}

				}
				fileReader_17.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_18)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_18 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abcc.txt");
				FileReader fileReader_18 = new FileReader(file_18);
				BufferedReader br_18 = new BufferedReader(fileReader_18);

				String strLine_18;
				// Read File Line By Line
				// int counter1 = -1;
				int counter18 = -1;
				while ((strLine_18 = br_18.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter18++;
					if (strLine_18.equals(getfinalpath)) {

						if (paths.get(strLine_18)) {
							break;
						} else {
							paths.put(strLine_18, true);

							int xxi = 0;
							int valz = pathcounter.get(template_18);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_18, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_18[counter18]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_18[counter18][s] = x[i][s];

								}
								statu_18[counter18] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_18++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_18.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_19)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_19 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acaa.txt");
				FileReader fileReader_19 = new FileReader(file_19);
				BufferedReader br_19 = new BufferedReader(fileReader_19);

				String strLine_19;
				// Read File Line By Line
				// int counter1 = -1;
				int counter19 = -1;
				while ((strLine_19 = br_19.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter19++;
					if (strLine_19.equals(getfinalpath)) {

						if (paths.get(strLine_19)) {
							break;
						} else {
							paths.put(strLine_19, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_19);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_19, fin_34);

							if (!statu_19[counter19]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_19[counter19][s] = x[i][s];

								}
								statu_19[counter19] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_19++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_19.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_20)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_20 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acab.txt");
				FileReader fileReader_20 = new FileReader(file_20);
				BufferedReader br_20 = new BufferedReader(fileReader_20);

				String strLine_20;
				// Read File Line By Line
				// int counter1 = -1;
				int counter20 = -1;
				while ((strLine_20 = br_20.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter20++;
					if (strLine_20.equals(getfinalpath)) {
						if (paths.get(strLine_20)) {
							break;
						}

						else {
							paths.put(strLine_20, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_20);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_20, fin_35);

							if (!statu_20[counter20]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_20[counter20][s] = x[i][s];

								}
								statu_20[counter20] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_20++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_20.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_21)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_21 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acac.txt");
				FileReader fileReader_21 = new FileReader(file_21);
				BufferedReader br_21 = new BufferedReader(fileReader_21);

				String strLine_21;
				// Read File Line By Line
				// int counter1 = -1;
				int counter21 = -1;
				while ((strLine_21 = br_21.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter21++;
					if (strLine_21.equals(getfinalpath)) {

						if (paths.get(strLine_21)) {
							break;
						} else {
							paths.put(strLine_21, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_21);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_21, fin_36);

							if (!statu_21[counter21]) {

								for (int s = 0; s < R; s++) {

									solution_21[counter21][s] = x[i][s];

								}
								statu_21[counter21] = true; //
								obj_21++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_21.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_22)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_22 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acba.txt");
				FileReader fileReader_22 = new FileReader(file_22);
				BufferedReader br_22 = new BufferedReader(fileReader_22);

				String strLine_22;
				// Read File Line By Line
				// int counter1 = -1;
				int counter22 = -1;
				while ((strLine_22 = br_22.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter22++;
					if (strLine_22.equals(getfinalpath)) {
						if (paths.get(strLine_22)) {
							break;
						}

						else {
							paths.put(strLine_22, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_22);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_22, fin_37);

							if (!statu_22[counter22]) {

								for (int s = 0; s < R; s++) {

									solution_22[counter22][s] = x[i][s];

								}
								statu_22[counter22] = true; //
								obj_22++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_22.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_23)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_23 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acbb.txt");
				FileReader fileReader_23 = new FileReader(file_23);
				BufferedReader br_23 = new BufferedReader(fileReader_23);

				String strLine_23;
				// Read File Line By Line
				// int counter1 = -1;
				int counter23 = -1;
				while ((strLine_23 = br_23.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter23++;
					if (strLine_23.equals(getfinalpath)) {
						if (paths.get(strLine_23)) {
							break;
						}

						else {
							paths.put(strLine_23, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_23);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_23, fin_38);

							if (!statu_23[counter23]) {

								for (int s = 0; s < R; s++) {

									solution_23[counter23][s] = x[i][s];

								}
								statu_23[counter23] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_23++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_23.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_24)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_24 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acbc.txt");
				FileReader fileReader_24 = new FileReader(file_24);
				BufferedReader br_24 = new BufferedReader(fileReader_24);

				String strLine_24;
				// Read File Line By Line
				// int counter1 = -1;
				int counter24 = -1;
				while ((strLine_24 = br_24.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter24++;
					if (strLine_24.equals(getfinalpath)) {
						if (paths.get(strLine_24)) {
							break;
						} else {
							paths.put(strLine_24, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_24);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_24, fin_39);

							if (!statu_24[counter24]) {

								for (int s = 0; s < R; s++) {

									solution_24[counter24][s] = x[i][s];

								}
								statu_24[counter24] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_24++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_24.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_25)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_25 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acca.txt");
				FileReader fileReader_25 = new FileReader(file_25);
				BufferedReader br_25 = new BufferedReader(fileReader_25);

				String strLine_25;
				// Read File Line By Line
				// int counter1 = -1;
				int counter25 = -1;
				while ((strLine_25 = br_25.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter25++;
					if (strLine_25.equals(getfinalpath)) {
						if (paths.get(strLine_25)) {
							break;
						} else {
							paths.put(strLine_25, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_25);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_25, fin_40);

							if (!statu_25[counter25]) {

								for (int s = 0; s < R; s++) {

									solution_25[counter25][s] = x[i][s];

								}
								statu_25[counter25] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_25++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_25.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_26)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_26 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/accb.txt");
				FileReader fileReader_26 = new FileReader(file_26);
				BufferedReader br_26 = new BufferedReader(fileReader_26);

				String strLine_26;
				// Read File Line By Line
				// int counter1 = -1;
				int counter26 = -1;
				while ((strLine_26 = br_26.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter26++;
					if (strLine_26.equals(getfinalpath)) {
						if (paths.get(strLine_26)) {
							break;
						}

						else {
							paths.put(strLine_26, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_26);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_11, fin_41);

							if (!statu_26[counter26]) {

								for (int s = 0; s < R; s++) {

									solution_26[counter26][s] = x[i][s];

								}
								statu_26[counter26] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_26++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_26.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_27)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_27 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/accc.txt");
				FileReader fileReader_27 = new FileReader(file_27);
				BufferedReader br_27 = new BufferedReader(fileReader_27);

				String strLine_27;
				// Read File Line By Line
				// int counter1 = -1;
				int counter27 = -1;
				while ((strLine_27 = br_27.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter27++;
					if (strLine_27.equals(getfinalpath)) {

						if (paths.get(strLine_27)) {
							break;
						} else {
							paths.put(strLine_27, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_27);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_27, fin_42);

							if (!statu_27[counter27]) {

								for (int s = 0; s < R; s++) {

									solution_27[counter27][s] = x[i][s];

								}
								statu_27[counter27] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_27++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_27.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_28)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_28 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baaa.txt");
				FileReader fileReader_28 = new FileReader(file_28);
				BufferedReader br_28 = new BufferedReader(fileReader_28);

				String strLine_28;
				// Read File Line By Line
				// int counter1 = -1;
				int counter28 = -1;
				while ((strLine_28 = br_28.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter28++;
					if (strLine_28.equals(getfinalpath)) {
						if (paths.get(strLine_28)) {
							break;
						} else {
							paths.put(strLine_28, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_28);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_28, fin_43);

							if (!statu_28[counter28]) {

								for (int s = 0; s < R; s++) {

									solution_28[counter28][s] = x[i][s];

								}
								statu_28[counter28] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_28++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_28.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_29)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_29 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baab.txt");
				FileReader fileReader_29 = new FileReader(file_29);
				BufferedReader br_29 = new BufferedReader(fileReader_29);

				String strLine_29;
				// Read File Line By Line
				// int counter1 = -1;
				int counter29 = -1;
				while ((strLine_29 = br_29.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter29++;
					if (strLine_29.equals(getfinalpath)) {
						if (paths.get(strLine_29)) {
							break;
						} else {
							paths.put(strLine_29, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_29);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_29, fin_44);

							if (!statu_29[counter29]) {

								for (int s = 0; s < R; s++) {

									solution_29[counter29][s] = x[i][s];

								}
								statu_29[counter29] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_29++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_29.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_30)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_30 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baac.txt");
				FileReader fileReader_30 = new FileReader(file_30);
				BufferedReader br_30 = new BufferedReader(fileReader_30);

				String strLine_30;
				// Read File Line By Line
				// int counter1 = -1;
				int counter30 = -1;
				while ((strLine_30 = br_30.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter30++;
					if (strLine_30.equals(getfinalpath)) {
						if (paths.get(strLine_30)) {
							break;
						}

						else {
							paths.put(strLine_30, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_30);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_30, fin_45);

							if (!statu_30[counter30]) {

								for (int s = 0; s < R; s++) {

									solution_30[counter30][s] = x[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_30[counter30] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_30++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_30.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_31)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_31 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baba.txt");
				FileReader fileReader_31 = new FileReader(file_31);
				BufferedReader br_31 = new BufferedReader(fileReader_31);

				String strLine_31;

				int counter31 = -1;
				while ((strLine_31 = br_31.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter31++;
					if (strLine_31.equals(getfinalpath)) {

						if (paths.get(strLine_31)) {
							break;
						}

						else {
							paths.put(strLine_31, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_31);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_31, fin_46);

							if (!statu_31[counter31]) {

								for (int s = 0; s < R; s++) {

									solution_31[counter31][s] = x[i][s];

								}
								statu_31[counter31] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_31++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_31.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_32)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_32 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/babb.txt");
				FileReader fileReader_32 = new FileReader(file_32);
				BufferedReader br_32 = new BufferedReader(fileReader_32);

				String strLine_32;

				int counter32 = -1;
				while ((strLine_32 = br_32.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter32++;

					if (strLine_32.equals(getfinalpath)) {

						if (paths.get(strLine_32)) {
							break;
						} else {
							paths.put(strLine_32, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_32);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_32, fin_31);

							if (!statu_32[counter32]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_32[counter32][s] = x[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_32[counter32] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_32++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_32.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_33)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_33 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/babc.txt");
				FileReader fileReader_33 = new FileReader(file_33);
				BufferedReader br_33 = new BufferedReader(fileReader_33);

				String strLine_33;
				// Read File Line By Line
				// int counter1 = -1;
				int counter33 = -1;
				while ((strLine_33 = br_33.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter33++;
					if (strLine_33.equals(getfinalpath)) {

						if (paths.get(strLine_33)) {
							break;
						} else {
							paths.put(strLine_33, true);

							int xxi = 0;
							int valz = pathcounter.get(template_33);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_33, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_33[counter33]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_33[counter33][s] = x[i][s];

								}
								statu_33[counter33] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_33++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_33.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_34)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_34 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baca.txt");
				FileReader fileReader_34 = new FileReader(file_34);
				BufferedReader br_34 = new BufferedReader(fileReader_34);

				String strLine_34;
				// Read File Line By Line
				// int counter1 = -1;
				int counter34 = -1;
				while ((strLine_34 = br_34.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter34++;
					if (strLine_34.equals(getfinalpath)) {

						if (paths.get(strLine_34)) {
							break;
						} else {
							paths.put(strLine_34, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_34);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_34, fin_34);

							if (!statu_34[counter34]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_34[counter34][s] = x[i][s];

								}
								statu_34[counter34] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_34++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_34.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_35)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_35 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bacb.txt");
				FileReader fileReader_35 = new FileReader(file_35);
				BufferedReader br_35 = new BufferedReader(fileReader_35);

				String strLine_35;
				// Read File Line By Line
				// int counter1 = -1;
				int counter35 = -1;
				while ((strLine_35 = br_35.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter35++;
					if (strLine_35.equals(getfinalpath)) {
						if (paths.get(strLine_35)) {
							break;
						}

						else {
							paths.put(strLine_35, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_35);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_5, fin_35);

							if (!statu_35[counter35]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_35[counter35][s] = x[i][s];

								}
								statu_35[counter35] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_35++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_35.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_36)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_36 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bacc.txt");
				FileReader fileReader_36 = new FileReader(file_36);
				BufferedReader br_36 = new BufferedReader(fileReader_36);

				String strLine_36;
				// Read File Line By Line
				// int counter1 = -1;
				int counter36 = -1;
				while ((strLine_36 = br_36.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter36++;
					if (strLine_36.equals(getfinalpath)) {

						if (paths.get(strLine_36)) {
							break;
						}

						else {
							paths.put(strLine_36, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_36);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_36, fin_36);

							if (!statu_36[counter36]) {

								for (int s = 0; s < R; s++) {

									solution_36[counter36][s] = x[i][s];

								}
								statu_36[counter36] = true; //
								obj_6++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_36.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_37)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_37 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbaa.txt");
				FileReader fileReader_37 = new FileReader(file_37);
				BufferedReader br_37 = new BufferedReader(fileReader_37);

				String strLine_37;
				// Read File Line By Line
				// int counter1 = -1;
				int counter37 = -1;
				while ((strLine_37 = br_37.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter37++;
					if (strLine_37.equals(getfinalpath)) {
						if (paths.get(strLine_37)) {
							break;
						}

						else {
							paths.put(strLine_37, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_37);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_37, fin_37);

							if (!statu_37[counter37]) {

								for (int s = 0; s < R; s++) {

									solution_37[counter37][s] = x[i][s];

								}
								statu_37[counter37] = true; //
								obj_37++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_37.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_38)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_38 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbab.txt");
				FileReader fileReader_38 = new FileReader(file_38);
				BufferedReader br_38 = new BufferedReader(fileReader_38);

				String strLine_38;
				// Read File Line By Line
				// int counter1 = -1;
				int counter38 = -1;
				while ((strLine_38 = br_38.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter38++;
					if (strLine_38.equals(getfinalpath)) {
						if (paths.get(strLine_38)) {
							break;
						} else {
							paths.put(strLine_38, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_38);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_38, fin_38);

							if (!statu_38[counter38]) {

								for (int s = 0; s < R; s++) {

									solution_38[counter38][s] = x[i][s];

								}
								statu_38[counter38] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_38++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_38.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_39)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_39 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbac.txt");
				FileReader fileReader_39 = new FileReader(file_39);
				BufferedReader br_39 = new BufferedReader(fileReader_39);

				String strLine_39;
				// Read File Line By Line
				// int counter1 = -1;
				int counter39 = -1;
				while ((strLine_39 = br_39.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter39++;
					if (strLine_39.equals(getfinalpath)) {
						if (paths.get(strLine_39)) {
							break;
						}

						else {
							paths.put(strLine_39, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_39);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_39, fin_39);

							if (!statu_39[counter39]) {

								for (int s = 0; s < R; s++) {

									solution_39[counter39][s] = x[i][s];

								}
								statu_39[counter39] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_39++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_39.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_40)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_40 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbba.txt");
				FileReader fileReader_40 = new FileReader(file_40);
				BufferedReader br_40 = new BufferedReader(fileReader_40);

				String strLine_40;
				// Read File Line By Line
				// int counter1 = -1;
				int counter40 = -1;
				while ((strLine_40 = br_40.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter40++;
					if (strLine_40.equals(getfinalpath)) {
						if (paths.get(strLine_40)) {
							break;
						}

						else {
							paths.put(strLine_40, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_40);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_40, fin_40);

							if (!statu_40[counter40]) {

								for (int s = 0; s < R; s++) {

									solution_40[counter40][s] = x[i][s];

								}
								statu_40[counter40] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_40++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_40.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_41)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_41 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbbb.txt");
				FileReader fileReader_41 = new FileReader(file_41);
				BufferedReader br_41 = new BufferedReader(fileReader_41);

				String strLine_41;
				// Read File Line By Line
				// int counter1 = -1;
				int counter41 = -1;
				while ((strLine_41 = br_41.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter41++;
					if (strLine_41.equals(getfinalpath)) {
						if (paths.get(strLine_41)) {
							break;
						}

						else {
							paths.put(strLine_41, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_41);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_41, fin_41);

							if (!statu_41[counter41]) {

								for (int s = 0; s < R; s++) {

									solution_41[counter41][s] = x[i][s];

								}
								statu_41[counter41] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_41++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_41.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_42)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_42 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbbc.txt");
				FileReader fileReader_42 = new FileReader(file_42);
				BufferedReader br_42 = new BufferedReader(fileReader_42);

				String strLine_42;
				// Read File Line By Line
				// int counter1 = -1;
				int counter42 = -1;
				while ((strLine_42 = br_42.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter42++;
					if (strLine_42.equals(getfinalpath)) {

						if (paths.get(strLine_42)) {
							break;
						} else {
							paths.put(strLine_42, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_42);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_42, fin_42);

							if (!statu_42[counter42]) {

								for (int s = 0; s < R; s++) {

									solution_42[counter42][s] = x[i][s];

								}
								statu_42[counter42] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_42++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_42.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_43)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_43 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbca.txt");
				FileReader fileReader_43 = new FileReader(file_43);
				BufferedReader br_43 = new BufferedReader(fileReader_43);

				String strLine_43;
				// Read File Line By Line
				// int counter1 = -1;
				int counter43 = -1;
				while ((strLine_43 = br_43.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter43++;
					if (strLine_43.equals(getfinalpath)) {
						if (paths.get(strLine_43)) {
							break;
						}

						else {
							paths.put(strLine_43, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_43);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_43, fin_43);

							if (!statu_43[counter43]) {

								for (int s = 0; s < R; s++) {

									solution_43[counter43][s] = x[i][s];

								}
								statu_43[counter43] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_43++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_43.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_44)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_44 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbcb.txt");
				FileReader fileReader_44 = new FileReader(file_44);
				BufferedReader br_44 = new BufferedReader(fileReader_44);

				String strLine_44;
				// Read File Line By Line
				// int counter1 = -1;
				int counter44 = -1;
				while ((strLine_44 = br_44.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter44++;
					if (strLine_44.equals(getfinalpath)) {
						if (paths.get(strLine_44)) {
							break;
						}

						else {
							paths.put(strLine_44, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_44);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_44, fin_44);

							if (!statu_44[counter44]) {

								for (int s = 0; s < R; s++) {

									solution_44[counter44][s] = x[i][s];

								}
								statu_44[counter44] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_44++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_44.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_45)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_45 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbcc.txt");
				FileReader fileReader_45 = new FileReader(file_45);
				BufferedReader br_45 = new BufferedReader(fileReader_45);

				String strLine_45;
				// Read File Line By Line
				// int counter1 = -1;
				int counter45 = -1;
				while ((strLine_45 = br_45.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter45++;
					if (strLine_45.equals(getfinalpath)) {
						if (paths.get(strLine_45)) {
							break;
						}

						else {
							paths.put(strLine_45, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_45);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_45, fin_45);

							if (!statu_45[counter45]) {

								for (int s = 0; s < R; s++) {

									solution_45[counter45][s] = x[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_45[counter45] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_45++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_45.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_46)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_46 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcaa.txt");
				FileReader fileReader_46 = new FileReader(file_46);
				BufferedReader br_46 = new BufferedReader(fileReader_46);

				String strLine_46;

				int counter46 = -1;
				while ((strLine_46 = br_46.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter46++;
					if (strLine_46.equals(getfinalpath)) {

						if (paths.get(strLine_46)) {
							break;
						} else {
							paths.put(strLine_46, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_46);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_16, fin_46);

							if (!statu_46[counter46]) {

								for (int s = 0; s < R; s++) {

									solution_46[counter46][s] = x[i][s];

								}
								statu_46[counter46] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_46++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_46.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_47)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_47 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcab.txt");
				FileReader fileReader_47 = new FileReader(file_47);
				BufferedReader br_47 = new BufferedReader(fileReader_47);

				String strLine_47;

				int counter47 = -1;
				while ((strLine_47 = br_47.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter47++;

					if (strLine_47.equals(getfinalpath)) {

						if (paths.get(strLine_47)) {
							break;
						} else {
							paths.put(strLine_47, true);

							int g_47 = 0;
							int va_47 = pathcounter.get(template_1);

							g_47++;
							int fin_47 = va_47 + g_47;

							pathcounter.put(template_47, fin_47);

							if (!statu_47[counter47]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_47[counter47][s] = x[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_47[counter47] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_47++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_47.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_48)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_48 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcac.txt");
				FileReader fileReader_48 = new FileReader(file_48);
				BufferedReader br_48 = new BufferedReader(fileReader_48);

				String strLine_48;
				// Read File Line By Line
				// int counter1 = -1;
				int counter48 = -1;
				while ((strLine_48 = br_48.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter48++;
					if (strLine_48.equals(getfinalpath)) {

						if (paths.get(strLine_48)) {
							break;
						}

						else {
							paths.put(strLine_48, true);

							int g_48 = 0;
							int va_48 = pathcounter.get(template_48);

							g_48++;
							int fin_32 = va_48 + g_48;

							pathcounter.put(template_48, fin_32);

							// break;

							if (!statu_48[counter48]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_48[counter48][s] = x[i][s];

								}
								statu_48[counter48] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_48++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_48.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_49)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_49 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcba.txt");
				FileReader fileReader_49 = new FileReader(file_49);
				BufferedReader br_49 = new BufferedReader(fileReader_49);

				String strLine_49;
				// Read File Line By Line
				// int counter1 = -1;
				int counter49 = -1;
				while ((strLine_49 = br_49.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter49++;
					if (strLine_49.equals(getfinalpath)) {

						if (paths.get(strLine_49)) {
							break;
						} else {
							paths.put(strLine_49, true);

							int xxi = 0;
							int valz = pathcounter.get(template_49);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_49, fin);

							// call path status .. assign truth flag... along that path...

							if (!statu_49[counter49]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_49[counter49][s] = x[i][s];

								}
								statu_49[counter49] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_49++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_49.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_50)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_50 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcbb.txt");
				FileReader fileReader_50 = new FileReader(file_50);
				BufferedReader br_50 = new BufferedReader(fileReader_50);

				String strLine_50;
				// Read File Line By Line
				// int counter1 = -1;
				int counter50 = -1;
				while ((strLine_50 = br_50.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter50++;
					if (strLine_50.equals(getfinalpath)) {

						if (paths.get(strLine_50)) {
							break;
						}

						else {
							paths.put(strLine_50, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_50);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_50, fin_34);

							if (!statu_50[counter50]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_50[counter50][s] = x[i][s];

								}
								statu_50[counter50] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_50++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_50.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_51)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_51 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcbc.txt");
				FileReader fileReader_51 = new FileReader(file_51);
				BufferedReader br_51 = new BufferedReader(fileReader_51);

				String strLine_51;
				// Read File Line By Line
				// int counter1 = -1;
				int counter51 = -1;
				while ((strLine_51 = br_51.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter51++;
					if (strLine_51.equals(getfinalpath)) {
						if (paths.get(strLine_51)) {
							break;
						}

						else {
							paths.put(strLine_51, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_51);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_51, fin_35);

							if (!statu_51[counter51]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_51[counter51][s] = x[i][s];

								}
								statu_51[counter51] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_51++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_51.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_52)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_52 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcca.txt");
				FileReader fileReader_52 = new FileReader(file_52);
				BufferedReader br_52 = new BufferedReader(fileReader_52);

				String strLine_52;
				// Read File Line By Line
				// int counter1 = -1;
				int counter52 = -1;
				while ((strLine_52 = br_52.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter52++;
					if (strLine_52.equals(getfinalpath)) {

						if (paths.get(strLine_52)) {
							break;
						}

						else {
							paths.put(strLine_52, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_52);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_52, fin_36);

							if (!statu_52[counter52]) {

								for (int s = 0; s < R; s++) {

									solution_52[counter52][s] = x[i][s];

								}
								statu_52[counter52] = true; //
								obj_52++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_52.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_53)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_53 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bccb.txt");
				FileReader fileReader_53 = new FileReader(file_53);
				BufferedReader br_53 = new BufferedReader(fileReader_53);

				String strLine_53;
				// Read File Line By Line
				// int counter1 = -1;
				int counter53 = -1;
				while ((strLine_53 = br_53.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter53++;
					if (strLine_53.equals(getfinalpath)) {
						if (paths.get(strLine_53)) {
							break;
						} else {
							paths.put(strLine_53, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_53);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_53, fin_37);

							if (!statu_53[counter53]) {

								for (int s = 0; s < R; s++) {

									solution_53[counter53][s] = x[i][s];

								}
								statu_53[counter53] = true; //
								obj_53++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_53.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_54)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_54 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bccc.txt");
				FileReader fileReader_54 = new FileReader(file_54);
				BufferedReader br_54 = new BufferedReader(fileReader_54);

				String strLine_54;
				// Read File Line By Line
				// int counter1 = -1;
				int counter54 = -1;
				while ((strLine_54 = br_54.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter54++;
					if (strLine_54.equals(getfinalpath)) {

						if (paths.get(strLine_54)) {
							break;
						}

						else {
							paths.put(strLine_54, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_54);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_54, fin_38);

							if (!statu_54[counter54]) {

								for (int s = 0; s < R; s++) {

									solution_54[counter54][s] = x[i][s];

								}
								statu_54[counter54] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_54++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_54.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_55)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_55 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caaa.txt");
				FileReader fileReader_55 = new FileReader(file_55);
				BufferedReader br_55 = new BufferedReader(fileReader_55);

				String strLine_55;
				// Read File Line By Line
				// int counter1 = -1;
				int counter55 = -1;
				while ((strLine_55 = br_55.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter55++;
					if (strLine_55.equals(getfinalpath)) {
						if (paths.get(strLine_55)) {
							break;
						}

						else {
							paths.put(strLine_55, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_55);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_55, fin_39);

							if (!statu_55[counter55]) {

								for (int s = 0; s < R; s++) {

									solution_55[counter55][s] = x[i][s];

								}
								statu_55[counter55] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_55++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_55.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_56)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_56 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caab.txt");
				FileReader fileReader_56 = new FileReader(file_56);
				BufferedReader br_56 = new BufferedReader(fileReader_56);

				String strLine_56;
				// Read File Line By Line
				// int counter1 = -1;
				int counter56 = -1;
				while ((strLine_56 = br_56.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter56++;
					if (strLine_56.equals(getfinalpath)) {
						if (paths.get(strLine_56)) {
							break;
						}

						else {
							paths.put(strLine_56, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_56);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_56, fin_40);

							if (!statu_56[counter56]) {

								for (int s = 0; s < R; s++) {

									solution_56[counter56][s] = x[i][s];

								}
								statu_56[counter56] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_56++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_56.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_57)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_57 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caac.txt");
				FileReader fileReader_57 = new FileReader(file_57);
				BufferedReader br_57 = new BufferedReader(fileReader_57);

				String strLine_57;
				// Read File Line By Line
				// int counter1 = -1;
				int counter57 = -1;
				while ((strLine_57 = br_57.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter57++;
					if (strLine_57.equals(getfinalpath)) {
						if (paths.get(strLine_57)) {
							break;
						}

						else {
							paths.put(strLine_57, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_57);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_57, fin_41);

							if (!statu_57[counter57]) {

								for (int s = 0; s < R; s++) {

									solution_57[counter57][s] = x[i][s];

								}
								statu_57[counter57] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_57++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_57.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_58)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_58 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caba.txt");
				FileReader fileReader_58 = new FileReader(file_58);
				BufferedReader br_58 = new BufferedReader(fileReader_58);

				String strLine_58;
				// Read File Line By Line
				// int counter1 = -1;
				int counter58 = -1;
				while ((strLine_58 = br_58.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter58++;
					if (strLine_58.equals(getfinalpath)) {

						if (paths.get(strLine_58)) {
							break;
						} else {
							paths.put(strLine_58, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_58);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_58, fin_42);

							if (!statu_58[counter58]) {

								for (int s = 0; s < R; s++) {

									solution_58[counter58][s] = x[i][s];

								}
								statu_58[counter58] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_58++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_58.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_59)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_59 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cabb.txt");
				FileReader fileReader_59 = new FileReader(file_59);
				BufferedReader br_59 = new BufferedReader(fileReader_59);

				String strLine_59;
				// Read File Line By Line
				// int counter1 = -1;
				int counter59 = -1;
				while ((strLine_59 = br_59.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter59++;
					if (strLine_59.equals(getfinalpath)) {
						if (paths.get(strLine_59)) {
							break;
						}

						else {
							paths.put(strLine_59, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_59);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_59, fin_43);

							if (!statu_59[counter59]) {

								for (int s = 0; s < R; s++) {

									solution_59[counter59][s] = x[i][s];

								}
								statu_59[counter59] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_59++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_59.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_60)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_60 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cabc.txt");
				FileReader fileReader_60 = new FileReader(file_60);
				BufferedReader br_60 = new BufferedReader(fileReader_60);

				String strLine_60;
				// Read File Line By Line
				// int counter1 = -1;
				int counter60 = -1;
				while ((strLine_60 = br_60.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter60++;
					if (strLine_60.equals(getfinalpath)) {
						if (paths.get(strLine_60)) {
							break;
						} else {
							paths.put(strLine_60, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_60);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_60, fin_44);

							if (!statu_60[counter60]) {

								for (int s = 0; s < R; s++) {

									solution_60[counter60][s] = x[i][s];

								}
								statu_60[counter60] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_60++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_60.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_61)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_61 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caca.txt");
				FileReader fileReader_61 = new FileReader(file_61);
				BufferedReader br_61 = new BufferedReader(fileReader_61);

				String strLine_61;
				// Read File Line By Line
				// int counter1 = -1;
				int counter61 = -1;
				while ((strLine_61 = br_61.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter61++;
					if (strLine_61.equals(getfinalpath)) {
						if (paths.get(strLine_61)) {
							break;
						} else {
							paths.put(strLine_61, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_61);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_61, fin_45);

							if (!statu_61[counter61]) {

								for (int s = 0; s < R; s++) {

									solution_61[counter61][s] = x[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_61[counter61] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_61++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_61.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_62)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_62 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cacb.txt");
				FileReader fileReader_62 = new FileReader(file_62);
				BufferedReader br_62 = new BufferedReader(fileReader_62);

				String strLine_62;

				int counter62 = -1;
				while ((strLine_62 = br_62.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter62++;
					if (strLine_62.equals(getfinalpath)) {

						if (paths.get(strLine_62)) {
							break;
						}

						else {
							paths.put(strLine_62, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_62);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_62, fin_46);

							if (!statu_62[counter62]) {

								for (int s = 0; s < R; s++) {

									solution_62[counter62][s] = x[i][s];

								}
								statu_62[counter62] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_62++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_62.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_63)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_63 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cacc.txt");
				FileReader fileReader_63 = new FileReader(file_63);
				BufferedReader br_63 = new BufferedReader(fileReader_63);

				String strLine_63;

				int counter63 = -1;
				while ((strLine_63 = br_63.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter63++;

					if (strLine_63.equals(getfinalpath)) {

						if (paths.get(strLine_63)) {
							break;
						}

						else {
							paths.put(strLine_63, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_63);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_63, fin_31);

							if (!statu_63[counter63]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_63[counter63][s] = x[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_63[counter63] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_63++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_63.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_64)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_64 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbaa.txt");
				FileReader fileReader_64 = new FileReader(file_64);
				BufferedReader br_64 = new BufferedReader(fileReader_64);

				String strLine_64;
				// Read File Line By Line
				// int counter1 = -1;
				int counter64 = -1;
				while ((strLine_64 = br_64.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter64++;
					if (strLine_64.equals(getfinalpath)) {

						if (paths.get(strLine_64)) {
							break;
						}

						else {
							paths.put(strLine_64, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_64);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_64, fin_32);

							// break;

							if (!statu_64[counter64]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_64[counter64][s] = x[i][s];

								}
								statu_64[counter64] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_64++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_64.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_65)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_65 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbab.txt");
				FileReader fileReader_65 = new FileReader(file_65);
				BufferedReader br_65 = new BufferedReader(fileReader_65);

				String strLine_65;
				// Read File Line By Line
				// int counter1 = -1;
				int counter65 = -1;
				while ((strLine_65 = br_65.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter65++;
					if (strLine_65.equals(getfinalpath)) {

						if (paths.get(strLine_65)) {
							break;
						} else {
							paths.put(strLine_65, true);

							int xxi = 0;
							int valz = pathcounter.get(template_65);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_65, fin);

							// call path status .. assign truth flag... along that path...

							if (!statu_65[counter65]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_65[counter65][s] = x[i][s];

								}
								statu_65[counter65] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_65++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_65.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_66)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_66 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbac.txt");
				FileReader fileReader_66 = new FileReader(file_66);
				BufferedReader br_66 = new BufferedReader(fileReader_66);

				String strLine_66;
				// Read File Line By Line
				// int counter1 = -1;
				int counter66 = -1;
				while ((strLine_66 = br_66.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter66++;
					if (strLine_66.equals(getfinalpath)) {

						if (paths.get(strLine_66)) {
							break;
						} else {
							paths.put(strLine_66, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_66);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_66, fin_34);

							if (!statu_66[counter66]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_66[counter66][s] = x[i][s];

								}
								statu_66[counter66] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_66++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_66.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_67)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_67 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbba.txt");
				FileReader fileReader_67 = new FileReader(file_67);
				BufferedReader br_67 = new BufferedReader(fileReader_67);

				String strLine_67;
				// Read File Line By Line
				// int counter1 = -1;
				int counter67 = -1;
				while ((strLine_67 = br_67.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter67++;
					if (strLine_67.equals(getfinalpath)) {
						if (paths.get(strLine_67)) {
							break;
						} else {
							paths.put(strLine_67, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_67);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_67, fin_35);

							if (!statu_67[counter67]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_67[counter67][s] = x[i][s];

								}
								statu_67[counter67] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_67++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_67.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_68)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_68 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbbb.txt");
				FileReader fileReader_68 = new FileReader(file_68);
				BufferedReader br_68 = new BufferedReader(fileReader_68);

				String strLine_68;
				// Read File Line By Line
				// int counter1 = -1;
				int counter68 = -1;
				while ((strLine_68 = br_68.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter68++;
					if (strLine_68.equals(getfinalpath)) {

						if (paths.get(strLine_68)) {
							break;
						} else {
							paths.put(strLine_68, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_68);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_68, fin_36);

							if (!statu_68[counter68]) {

								for (int s = 0; s < R; s++) {

									solution_68[counter68][s] = x[i][s];

								}
								statu_68[counter68] = true; //
								obj_68++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_68.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_69)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_69 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbbc.txt");
				FileReader fileReader_69 = new FileReader(file_69);
				BufferedReader br_69 = new BufferedReader(fileReader_69);

				String strLine_69;
				// Read File Line By Line
				// int counter1 = -1;
				int counter69 = -1;
				while ((strLine_69 = br_69.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter69++;
					if (strLine_69.equals(getfinalpath)) {
						if (paths.get(strLine_69)) {
							break;
						}

						else {
							paths.put(strLine_69, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_69);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_69, fin_37);

							if (!statu_69[counter69]) {

								for (int s = 0; s < R; s++) {

									solution_69[counter69][s] = x[i][s];

								}
								statu_69[counter69] = true; //
								obj_69++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_69.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_70)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_70 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbca.txt");
				FileReader fileReader_70 = new FileReader(file_70);
				BufferedReader br_70 = new BufferedReader(fileReader_70);

				String strLine_70;
				// Read File Line By Line
				// int counter1 = -1;
				int counter70 = -1;
				while ((strLine_70 = br_70.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter70++;
					if (strLine_70.equals(getfinalpath)) {
						if (paths.get(strLine_70)) {
							break;
						}

						else {
							paths.put(strLine_70, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_70);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_70, fin_38);

							if (!statu_70[counter70]) {

								for (int s = 0; s < R; s++) {

									solution_70[counter70][s] = x[i][s];

								}
								statu_70[counter70] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_70++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_70.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_71)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_71 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbcb.txt");
				FileReader fileReader_71 = new FileReader(file_71);
				BufferedReader br_71 = new BufferedReader(fileReader_71);

				String strLine_71;
				// Read File Line By Line
				// int counter1 = -1;
				int counter71 = -1;
				while ((strLine_71 = br_71.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter71++;
					if (strLine_71.equals(getfinalpath)) {
						if (paths.get(strLine_71)) {
							break;
						} else {
							paths.put(strLine_71, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_71);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_71, fin_39);

							if (!statu_71[counter71]) {

								for (int s = 0; s < R; s++) {

									solution_71[counter71][s] = x[i][s];

								}
								statu_71[counter71] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_71++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_71.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_72)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_72 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbcc.txt");
				FileReader fileReader_72 = new FileReader(file_72);
				BufferedReader br_72 = new BufferedReader(fileReader_72);

				String strLine_72;
				// Read File Line By Line
				// int counter1 = -1;
				int counter72 = -1;
				while ((strLine_72 = br_72.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter72++;
					if (strLine_72.equals(getfinalpath)) {
						if (paths.get(strLine_72)) {
							break;
						}

						else {
							paths.put(strLine_72, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_72);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_72, fin_40);

							if (!statu_72[counter72]) {

								for (int s = 0; s < R; s++) {

									solution_72[counter72][s] = x[i][s];

								}
								statu_72[counter72] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_72++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_72.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_73)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_73 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccaa.txt");
				FileReader fileReader_73 = new FileReader(file_73);
				BufferedReader br_73 = new BufferedReader(fileReader_73);

				String strLine_73;
				// Read File Line By Line
				// int counter1 = -1;
				int counter73 = -1;
				while ((strLine_73 = br_73.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter73++;
					if (strLine_73.equals(getfinalpath)) {
						if (paths.get(strLine_73)) {
							break;
						}

						else {
							paths.put(strLine_73, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_73);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_73, fin_41);

							if (!statu_73[counter73]) {

								for (int s = 0; s < R; s++) {

									solution_73[counter73][s] = x[i][s];

								}
								statu_73[counter73] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_73++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_73.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_74)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_74 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccab.txt");
				FileReader fileReader_74 = new FileReader(file_74);
				BufferedReader br_74 = new BufferedReader(fileReader_74);

				String strLine_74;
				// Read File Line By Line
				// int counter1 = -1;
				int counter74 = -1;
				while ((strLine_74 = br_74.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter74++;
					if (strLine_74.equals(getfinalpath)) {

						if (paths.get(strLine_74)) {
							break;
						} else {
							paths.put(strLine_74, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_74);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_74, fin_42);

							if (!statu_74[counter74]) {

								for (int s = 0; s < R; s++) {

									solution_74[counter74][s] = x[i][s];

								}
								statu_74[counter74] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_74++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_74.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_75)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_75 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccac.txt");
				FileReader fileReader_75 = new FileReader(file_75);
				BufferedReader br_75 = new BufferedReader(fileReader_75);

				String strLine_75;
				// Read File Line By Line
				// int counter1 = -1;
				int counter75 = -1;
				while ((strLine_75 = br_75.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter75++;
					if (strLine_75.equals(getfinalpath)) {
						if (paths.get(strLine_75)) {
							break;
						}

						else {
							paths.put(strLine_75, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_75);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_75, fin_43);

							if (!statu_75[counter75]) {

								for (int s = 0; s < R; s++) {

									solution_75[counter75][s] = x[i][s];

								}
								statu_75[counter75] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_75++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_75.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_76)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_76 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccba.txt");
				FileReader fileReader_76 = new FileReader(file_76);
				BufferedReader br_76 = new BufferedReader(fileReader_76);

				String strLine_76;
				// Read File Line By Line
				// int counter1 = -1;
				int counter76 = -1;
				while ((strLine_76 = br_76.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter76++;
					if (strLine_76.equals(getfinalpath)) {
						if (paths.get(strLine_76)) {
							break;
						} else {
							paths.put(strLine_76, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_76);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_76, fin_44);

							if (!statu_76[counter76]) {

								for (int s = 0; s < R; s++) {

									solution_76[counter76][s] = x[i][s];

								}
								statu_76[counter76] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_76++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_76.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_77)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_77 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccbb.txt");
				FileReader fileReader_77 = new FileReader(file_77);
				BufferedReader br_77 = new BufferedReader(fileReader_77);

				String strLine_77;
				// Read File Line By Line
				// int counter1 = -1;
				int counter77 = -1;
				while ((strLine_77 = br_77.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter77++;
					if (strLine_77.equals(getfinalpath)) {
						if (paths.get(strLine_77)) {
							break;
						}

						else {
							paths.put(strLine_77, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_77);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_77, fin_45);

							if (!statu_77[counter77]) {

								for (int s = 0; s < R; s++) {

									solution_77[counter77][s] = x[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_77[counter77] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_77++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_77.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_78)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_78 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccbc.txt");
				FileReader fileReader_78 = new FileReader(file_78);
				BufferedReader br_78 = new BufferedReader(fileReader_78);

				String strLine_78;

				int counter78 = -1;
				while ((strLine_78 = br_78.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter78++;
					if (strLine_78.equals(getfinalpath)) {

						if (paths.get(strLine_78)) {
							break;
						}

						else {
							paths.put(strLine_78, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_78);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_78, fin_46);

							if (!statu_78[counter78]) {

								for (int s = 0; s < R; s++) {

									solution_78[counter78][s] = x[i][s];

								}
								statu_78[counter78] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_78++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_78.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_79)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_79 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccca.txt");
				FileReader fileReader_79 = new FileReader(file_79);
				BufferedReader br_79 = new BufferedReader(fileReader_79);

				String strLine_79;

				int counter79 = -1;
				while ((strLine_79 = br_79.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter79++;

					if (strLine_79.equals(getfinalpath)) {

						if (paths.get(strLine_79)) {
							break;
						}

						else {
							paths.put(strLine_79, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_79);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_79, fin_31);

							if (!statu_79[counter79]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_79[counter79][s] = x[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_79[counter79] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_79++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_79.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_80)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_80 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cccb.txt");
				FileReader fileReader_80 = new FileReader(file_80);
				BufferedReader br_80 = new BufferedReader(fileReader_80);

				String strLine_80;
				// Read File Line By Line
				// int counter1 = -1;
				int counter80 = -1;
				while ((strLine_80 = br_80.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter80++;
					if (strLine_80.equals(getfinalpath)) {

						if (paths.get(strLine_80)) {
							break;
						}

						else {
							paths.put(strLine_80, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_80);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_80, fin_32);

							// break;

							if (!statu_80[counter80]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_80[counter80][s] = x[i][s];

								}
								statu_80[counter80] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_80++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_80.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_81)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_81 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cccc.txt");
				FileReader fileReader_81 = new FileReader(file_81);
				BufferedReader br_81 = new BufferedReader(fileReader_81);

				String strLine_81;
				// Read File Line By Line
				// int counter1 = -1;
				int counter81 = -1;
				while ((strLine_81 = br_81.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter81++;
					if (strLine_81.equals(getfinalpath)) {

						if (paths.get(strLine_81)) {
							break;
						}

						else {
							paths.put(strLine_81, true);

							int xxi = 0;
							int valz = pathcounter.get(template_81);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_81, fin);

							// call path status .. assign truth flag... along that path...

							if (!statu_81[counter81]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_81[counter81][s] = x[i][s];

								}
								statu_81[counter81] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_81++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_81.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

	}

	public static void traverse_1(String getfinalpath, int i) {

		String final_path_checker = getfinalpath;

		if (final_path_checker.startsWith(template_1)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_1 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaaa.txt");
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

							int g_31 = 0;
							int va_31 = pathcounter.get(template_1);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_1, fin_31);

							if (!statu_1[counter1]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_1[counter1][s] = v[i][s];

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

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_2)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_2 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaab.txt");
				FileReader fileReader_2 = new FileReader(file_2);
				BufferedReader br_2 = new BufferedReader(fileReader_2);

				String strLine_2;
				// Read File Line By Line

				int counter2 = -1;
				while ((strLine_2 = br_2.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter2++;
					if (strLine_2.equals(getfinalpath)) {

						if (paths.get(strLine_2)) {
							break;
						} else {
							paths.put(strLine_2, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_2);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_2, fin_32);

							// break;

							if (!statu_2[counter2]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_2[counter2][s] = v[i][s];

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

		else if (final_path_checker.startsWith(template_3)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_3 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaac.txt");
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
							// call path status .. assign truth flag... along that path...

							if (!statu_3[counter3]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_3[counter3][s] = v[i][s];

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

		else if (final_path_checker.startsWith(template_4)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_4 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaba.txt");
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

							int g_34 = 0;
							int va_34 = pathcounter.get(template_4);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_4, fin_34);

							if (!statu_4[counter4]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_4[counter4][s] = v[i][s];

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

		else if (final_path_checker.startsWith(template_5)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_5 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aabb.txt");
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

							int g_35 = 0;
							int va_35 = pathcounter.get(template_5);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_5, fin_35);

							if (!statu_5[counter5]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

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

		else if (final_path_checker.startsWith(template_6)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_6 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aabc.txt");
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
						} else {
							paths.put(strLine_6, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_6);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_6, fin_36);

							if (!statu_6[counter6]) {

								for (int s = 0; s < R; s++) {

									solution_6[counter6][s] = v[i][s];

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

		else if (final_path_checker.startsWith(template_7)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_7 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aaca.txt");
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

									solution_7[counter7][s] = v[i][s];

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

		else if (final_path_checker.startsWith(template_8)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_8 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aacb.txt");
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
						} else {
							paths.put(strLine_8, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_8);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_8, fin_38);

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

		else if (final_path_checker.startsWith(template_9)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_9 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/aacc.txt");
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

		else if (final_path_checker.startsWith(template_10)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_10 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abaa.txt");
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
						} else {
							paths.put(strLine_10, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_10);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_10, fin_40);

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

		else if (final_path_checker.startsWith(template_11)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_11 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abab.txt");
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
						} else {
							paths.put(strLine_11, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_11);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_11, fin_41);

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

		else if (final_path_checker.startsWith(template_12)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_12 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abac.txt");
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
						} else {
							paths.put(strLine_12, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_12);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_12, fin_42);

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

		else if (final_path_checker.startsWith(template_13)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_13 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abba.txt");
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
						} else {
							paths.put(strLine_13, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_13);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_13, fin_43);

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

		else if (final_path_checker.startsWith(template_14)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_14 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abbb.txt");
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
						} else {
							paths.put(strLine_14, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_14);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_14, fin_44);

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

		else if (final_path_checker.startsWith(template_15)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_15 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abbc.txt");
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
						} else {
							paths.put(strLine_15, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_15);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_15, fin_45);

							if (!statu_15[counter15]) {

								for (int s = 0; s < R; s++) {

									solution_15[counter15][s] = v[i][s]; // only for this template

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

		else if (final_path_checker.startsWith(template_16)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_16 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abca.txt");
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

		else if (final_path_checker.startsWith(template_17)) { // if the traversed path_id is equal to "the template
																// id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_17 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abcb.txt");
				FileReader fileReader_17 = new FileReader(file_17);
				BufferedReader br_17 = new BufferedReader(fileReader_17);

				String strLine_17;

				int counter17 = -1;
				while ((strLine_17 = br_17.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter17++;

					if (strLine_17.equals(getfinalpath)) {

						if (paths.get(strLine_17)) {
							break;
						}

						else {
							paths.put(strLine_17, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_17);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_17, fin_31);

							if (!statu_17[counter17]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_17[counter17][s] = v[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_17[counter17] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_17++;

								totalpathcounter++;

								break;
							}
						}
					}

				}
				fileReader_17.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_18)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_18 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/abcc.txt");
				FileReader fileReader_18 = new FileReader(file_18);
				BufferedReader br_18 = new BufferedReader(fileReader_18);

				String strLine_18;
				// Read File Line By Line
				// int counter1 = -1;
				int counter18 = -1;
				while ((strLine_18 = br_18.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter18++;
					if (strLine_18.equals(getfinalpath)) {

						if (paths.get(strLine_18)) {
							break;
						} else {
							paths.put(strLine_18, true);

							int xxi = 0;
							int valz = pathcounter.get(template_18);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_18, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_18[counter18]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_18[counter18][s] = v[i][s];

								}
								statu_18[counter18] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_18++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_18.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_19)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_19 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acaa.txt");
				FileReader fileReader_19 = new FileReader(file_19);
				BufferedReader br_19 = new BufferedReader(fileReader_19);

				String strLine_19;
				// Read File Line By Line
				// int counter1 = -1;
				int counter19 = -1;
				while ((strLine_19 = br_19.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter19++;
					if (strLine_19.equals(getfinalpath)) {

						if (paths.get(strLine_19)) {
							break;
						} else {
							paths.put(strLine_19, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_19);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_19, fin_34);

							if (!statu_19[counter19]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_19[counter19][s] = v[i][s];

								}
								statu_19[counter19] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_19++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_19.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_20)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_20 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acab.txt");
				FileReader fileReader_20 = new FileReader(file_20);
				BufferedReader br_20 = new BufferedReader(fileReader_20);

				String strLine_20;
				// Read File Line By Line
				// int counter1 = -1;
				int counter20 = -1;
				while ((strLine_20 = br_20.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter20++;
					if (strLine_20.equals(getfinalpath)) {
						if (paths.get(strLine_20)) {
							break;
						}

						else {
							paths.put(strLine_20, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_20);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_20, fin_35);

							if (!statu_20[counter20]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_20[counter20][s] = v[i][s];

								}
								statu_20[counter20] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_20++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_20.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_21)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_21 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acac.txt");
				FileReader fileReader_21 = new FileReader(file_21);
				BufferedReader br_21 = new BufferedReader(fileReader_21);

				String strLine_21;
				// Read File Line By Line
				// int counter1 = -1;
				int counter21 = -1;
				while ((strLine_21 = br_21.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter21++;
					if (strLine_21.equals(getfinalpath)) {

						if (paths.get(strLine_21)) {
							break;
						} else {
							paths.put(strLine_21, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_21);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_21, fin_36);

							if (!statu_21[counter21]) {

								for (int s = 0; s < R; s++) {

									solution_21[counter21][s] = v[i][s];

								}
								statu_21[counter21] = true; //
								obj_21++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_21.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_22)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_22 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acba.txt");
				FileReader fileReader_22 = new FileReader(file_22);
				BufferedReader br_22 = new BufferedReader(fileReader_22);

				String strLine_22;
				// Read File Line By Line
				// int counter1 = -1;
				int counter22 = -1;
				while ((strLine_22 = br_22.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter22++;
					if (strLine_22.equals(getfinalpath)) {
						if (paths.get(strLine_22)) {
							break;
						}

						else {
							paths.put(strLine_22, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_22);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_22, fin_37);

							if (!statu_22[counter22]) {

								for (int s = 0; s < R; s++) {

									solution_22[counter22][s] = v[i][s];

								}
								statu_22[counter22] = true; //
								obj_22++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_22.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_23)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_23 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acbb.txt");
				FileReader fileReader_23 = new FileReader(file_23);
				BufferedReader br_23 = new BufferedReader(fileReader_23);

				String strLine_23;
				// Read File Line By Line
				// int counter1 = -1;
				int counter23 = -1;
				while ((strLine_23 = br_23.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter23++;
					if (strLine_23.equals(getfinalpath)) {
						if (paths.get(strLine_23)) {
							break;
						}

						else {
							paths.put(strLine_23, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_23);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_23, fin_38);

							if (!statu_23[counter23]) {

								for (int s = 0; s < R; s++) {

									solution_23[counter23][s] = v[i][s];

								}
								statu_23[counter23] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_23++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_23.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_24)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_24 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acbc.txt");
				FileReader fileReader_24 = new FileReader(file_24);
				BufferedReader br_24 = new BufferedReader(fileReader_24);

				String strLine_24;
				// Read File Line By Line
				// int counter1 = -1;
				int counter24 = -1;
				while ((strLine_24 = br_24.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter24++;
					if (strLine_24.equals(getfinalpath)) {
						if (paths.get(strLine_24)) {
							break;
						} else {
							paths.put(strLine_24, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_24);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_24, fin_39);

							if (!statu_24[counter24]) {

								for (int s = 0; s < R; s++) {

									solution_24[counter24][s] = v[i][s];

								}
								statu_24[counter24] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_24++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_24.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_25)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_25 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/acca.txt");
				FileReader fileReader_25 = new FileReader(file_25);
				BufferedReader br_25 = new BufferedReader(fileReader_25);

				String strLine_25;
				// Read File Line By Line
				// int counter1 = -1;
				int counter25 = -1;
				while ((strLine_25 = br_25.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter25++;
					if (strLine_25.equals(getfinalpath)) {
						if (paths.get(strLine_25)) {
							break;
						} else {
							paths.put(strLine_25, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_25);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_25, fin_40);

							if (!statu_25[counter25]) {

								for (int s = 0; s < R; s++) {

									solution_25[counter25][s] = v[i][s];

								}
								statu_25[counter25] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_25++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_25.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_26)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_26 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/accb.txt");
				FileReader fileReader_26 = new FileReader(file_26);
				BufferedReader br_26 = new BufferedReader(fileReader_26);

				String strLine_26;
				// Read File Line By Line
				// int counter1 = -1;
				int counter26 = -1;
				while ((strLine_26 = br_26.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter26++;
					if (strLine_26.equals(getfinalpath)) {
						if (paths.get(strLine_26)) {
							break;
						}

						else {
							paths.put(strLine_26, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_26);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_11, fin_41);

							if (!statu_26[counter26]) {

								for (int s = 0; s < R; s++) {

									solution_26[counter26][s] = v[i][s];

								}
								statu_26[counter26] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_26++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_26.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_27)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_27 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/accc.txt");
				FileReader fileReader_27 = new FileReader(file_27);
				BufferedReader br_27 = new BufferedReader(fileReader_27);

				String strLine_27;
				// Read File Line By Line
				// int counter1 = -1;
				int counter27 = -1;
				while ((strLine_27 = br_27.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter27++;
					if (strLine_27.equals(getfinalpath)) {

						if (paths.get(strLine_27)) {
							break;
						} else {
							paths.put(strLine_27, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_27);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_27, fin_42);

							if (!statu_27[counter27]) {

								for (int s = 0; s < R; s++) {

									solution_27[counter27][s] = v[i][s];

								}
								statu_27[counter27] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_27++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_27.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_28)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_28 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baaa.txt");
				FileReader fileReader_28 = new FileReader(file_28);
				BufferedReader br_28 = new BufferedReader(fileReader_28);

				String strLine_28;
				// Read File Line By Line
				// int counter1 = -1;
				int counter28 = -1;
				while ((strLine_28 = br_28.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter28++;
					if (strLine_28.equals(getfinalpath)) {
						if (paths.get(strLine_28)) {
							break;
						} else {
							paths.put(strLine_28, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_28);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_28, fin_43);

							if (!statu_28[counter28]) {

								for (int s = 0; s < R; s++) {

									solution_28[counter28][s] = v[i][s];

								}
								statu_28[counter28] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_28++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_28.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_29)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_29 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baab.txt");
				FileReader fileReader_29 = new FileReader(file_29);
				BufferedReader br_29 = new BufferedReader(fileReader_29);

				String strLine_29;
				// Read File Line By Line
				// int counter1 = -1;
				int counter29 = -1;
				while ((strLine_29 = br_29.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter29++;
					if (strLine_29.equals(getfinalpath)) {
						if (paths.get(strLine_29)) {
							break;
						} else {
							paths.put(strLine_29, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_29);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_29, fin_44);

							if (!statu_29[counter29]) {

								for (int s = 0; s < R; s++) {

									solution_29[counter29][s] = v[i][s];

								}
								statu_29[counter29] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_29++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_29.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_30)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_30 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baac.txt");
				FileReader fileReader_30 = new FileReader(file_30);
				BufferedReader br_30 = new BufferedReader(fileReader_30);

				String strLine_30;
				// Read File Line By Line
				// int counter1 = -1;
				int counter30 = -1;
				while ((strLine_30 = br_30.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter30++;
					if (strLine_30.equals(getfinalpath)) {
						if (paths.get(strLine_30)) {
							break;
						}

						else {
							paths.put(strLine_30, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_30);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_30, fin_45);

							if (!statu_30[counter30]) {

								for (int s = 0; s < R; s++) {

									solution_30[counter30][s] = v[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_30[counter30] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_30++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_30.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_31)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_31 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baba.txt");
				FileReader fileReader_31 = new FileReader(file_31);
				BufferedReader br_31 = new BufferedReader(fileReader_31);

				String strLine_31;

				int counter31 = -1;
				while ((strLine_31 = br_31.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter31++;
					if (strLine_31.equals(getfinalpath)) {

						if (paths.get(strLine_31)) {
							break;
						}

						else {
							paths.put(strLine_31, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_31);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_31, fin_46);

							if (!statu_31[counter31]) {

								for (int s = 0; s < R; s++) {

									solution_31[counter31][s] = v[i][s];

								}
								statu_31[counter31] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_31++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_31.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_32)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_32 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/babb.txt");
				FileReader fileReader_32 = new FileReader(file_32);
				BufferedReader br_32 = new BufferedReader(fileReader_32);

				String strLine_32;

				int counter32 = -1;
				while ((strLine_32 = br_32.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter32++;

					if (strLine_32.equals(getfinalpath)) {

						if (paths.get(strLine_32)) {
							break;
						} else {
							paths.put(strLine_32, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_32);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_32, fin_31);

							if (!statu_32[counter32]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_32[counter32][s] = v[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_32[counter32] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_32++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_32.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_33)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_33 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/babc.txt");
				FileReader fileReader_33 = new FileReader(file_33);
				BufferedReader br_33 = new BufferedReader(fileReader_33);

				String strLine_33;
				// Read File Line By Line
				// int counter1 = -1;
				int counter33 = -1;
				while ((strLine_33 = br_33.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter33++;
					if (strLine_33.equals(getfinalpath)) {

						if (paths.get(strLine_33)) {
							break;
						} else {
							paths.put(strLine_33, true);

							int xxi = 0;
							int valz = pathcounter.get(template_33);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_33, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_33[counter33]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_33[counter33][s] = v[i][s];

								}
								statu_33[counter33] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_33++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_33.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_34)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_34 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/baca.txt");
				FileReader fileReader_34 = new FileReader(file_34);
				BufferedReader br_34 = new BufferedReader(fileReader_34);

				String strLine_34;
				// Read File Line By Line
				// int counter1 = -1;
				int counter34 = -1;
				while ((strLine_34 = br_34.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter34++;
					if (strLine_34.equals(getfinalpath)) {

						if (paths.get(strLine_34)) {
							break;
						} else {
							paths.put(strLine_34, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_34);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_34, fin_34);

							if (!statu_34[counter34]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_34[counter34][s] = v[i][s];

								}
								statu_34[counter34] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_34++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_34.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_35)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_35 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bacb.txt");
				FileReader fileReader_35 = new FileReader(file_35);
				BufferedReader br_35 = new BufferedReader(fileReader_35);

				String strLine_35;
				// Read File Line By Line
				// int counter1 = -1;
				int counter35 = -1;
				while ((strLine_35 = br_35.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter35++;
					if (strLine_35.equals(getfinalpath)) {
						if (paths.get(strLine_35)) {
							break;
						}

						else {
							paths.put(strLine_35, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_35);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_5, fin_35);

							if (!statu_35[counter35]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_35[counter35][s] = v[i][s];

								}
								statu_35[counter35] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_35++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_35.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_36)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_36 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bacc.txt");
				FileReader fileReader_36 = new FileReader(file_36);
				BufferedReader br_36 = new BufferedReader(fileReader_36);

				String strLine_36;
				// Read File Line By Line
				// int counter1 = -1;
				int counter36 = -1;
				while ((strLine_36 = br_36.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter36++;
					if (strLine_36.equals(getfinalpath)) {

						if (paths.get(strLine_36)) {
							break;
						}

						else {
							paths.put(strLine_36, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_36);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_36, fin_36);

							if (!statu_36[counter36]) {

								for (int s = 0; s < R; s++) {

									solution_36[counter36][s] = v[i][s];

								}
								statu_36[counter36] = true; //
								obj_6++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_36.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_37)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_37 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbaa.txt");
				FileReader fileReader_37 = new FileReader(file_37);
				BufferedReader br_37 = new BufferedReader(fileReader_37);

				String strLine_37;
				// Read File Line By Line
				// int counter1 = -1;
				int counter37 = -1;
				while ((strLine_37 = br_37.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter37++;
					if (strLine_37.equals(getfinalpath)) {
						if (paths.get(strLine_37)) {
							break;
						}

						else {
							paths.put(strLine_37, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_37);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_37, fin_37);

							if (!statu_37[counter37]) {

								for (int s = 0; s < R; s++) {

									solution_37[counter37][s] = v[i][s];

								}
								statu_37[counter37] = true; //
								obj_37++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_37.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_38)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_38 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbab.txt");
				FileReader fileReader_38 = new FileReader(file_38);
				BufferedReader br_38 = new BufferedReader(fileReader_38);

				String strLine_38;
				// Read File Line By Line
				// int counter1 = -1;
				int counter38 = -1;
				while ((strLine_38 = br_38.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter38++;
					if (strLine_38.equals(getfinalpath)) {
						if (paths.get(strLine_38)) {
							break;
						} else {
							paths.put(strLine_38, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_38);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_38, fin_38);

							if (!statu_38[counter38]) {

								for (int s = 0; s < R; s++) {

									solution_38[counter38][s] = v[i][s];

								}
								statu_38[counter38] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_38++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_38.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_39)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_39 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbac.txt");
				FileReader fileReader_39 = new FileReader(file_39);
				BufferedReader br_39 = new BufferedReader(fileReader_39);

				String strLine_39;
				// Read File Line By Line
				// int counter1 = -1;
				int counter39 = -1;
				while ((strLine_39 = br_39.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter39++;
					if (strLine_39.equals(getfinalpath)) {
						if (paths.get(strLine_39)) {
							break;
						}

						else {
							paths.put(strLine_39, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_39);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_39, fin_39);

							if (!statu_39[counter39]) {

								for (int s = 0; s < R; s++) {

									solution_39[counter39][s] = v[i][s];

								}
								statu_39[counter39] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_39++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_39.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_40)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_40 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbba.txt");
				FileReader fileReader_40 = new FileReader(file_40);
				BufferedReader br_40 = new BufferedReader(fileReader_40);

				String strLine_40;
				// Read File Line By Line
				// int counter1 = -1;
				int counter40 = -1;
				while ((strLine_40 = br_40.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter40++;
					if (strLine_40.equals(getfinalpath)) {
						if (paths.get(strLine_40)) {
							break;
						}

						else {
							paths.put(strLine_40, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_40);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_40, fin_40);

							if (!statu_40[counter40]) {

								for (int s = 0; s < R; s++) {

									solution_40[counter40][s] = v[i][s];

								}
								statu_40[counter40] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_40++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_40.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_41)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_41 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbbb.txt");
				FileReader fileReader_41 = new FileReader(file_41);
				BufferedReader br_41 = new BufferedReader(fileReader_41);

				String strLine_41;
				// Read File Line By Line
				// int counter1 = -1;
				int counter41 = -1;
				while ((strLine_41 = br_41.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter41++;
					if (strLine_41.equals(getfinalpath)) {
						if (paths.get(strLine_41)) {
							break;
						}

						else {
							paths.put(strLine_41, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_41);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_41, fin_41);

							if (!statu_41[counter41]) {

								for (int s = 0; s < R; s++) {

									solution_41[counter41][s] = v[i][s];

								}
								statu_41[counter41] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_41++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_41.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_42)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_42 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbbc.txt");
				FileReader fileReader_42 = new FileReader(file_42);
				BufferedReader br_42 = new BufferedReader(fileReader_42);

				String strLine_42;
				// Read File Line By Line
				// int counter1 = -1;
				int counter42 = -1;
				while ((strLine_42 = br_42.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter42++;
					if (strLine_42.equals(getfinalpath)) {

						if (paths.get(strLine_42)) {
							break;
						} else {
							paths.put(strLine_42, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_42);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_42, fin_42);

							if (!statu_42[counter42]) {

								for (int s = 0; s < R; s++) {

									solution_42[counter42][s] = v[i][s];

								}
								statu_42[counter42] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_42++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_42.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_43)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_43 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbca.txt");
				FileReader fileReader_43 = new FileReader(file_43);
				BufferedReader br_43 = new BufferedReader(fileReader_43);

				String strLine_43;
				// Read File Line By Line
				// int counter1 = -1;
				int counter43 = -1;
				while ((strLine_43 = br_43.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter43++;
					if (strLine_43.equals(getfinalpath)) {
						if (paths.get(strLine_43)) {
							break;
						}

						else {
							paths.put(strLine_43, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_43);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_43, fin_43);

							if (!statu_43[counter43]) {

								for (int s = 0; s < R; s++) {

									solution_43[counter43][s] = v[i][s];

								}
								statu_43[counter43] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_43++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_43.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_44)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_44 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbcb.txt");
				FileReader fileReader_44 = new FileReader(file_44);
				BufferedReader br_44 = new BufferedReader(fileReader_44);

				String strLine_44;
				// Read File Line By Line
				// int counter1 = -1;
				int counter44 = -1;
				while ((strLine_44 = br_44.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter44++;
					if (strLine_44.equals(getfinalpath)) {
						if (paths.get(strLine_44)) {
							break;
						}

						else {
							paths.put(strLine_44, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_44);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_44, fin_44);

							if (!statu_44[counter44]) {

								for (int s = 0; s < R; s++) {

									solution_44[counter44][s] = v[i][s];

								}
								statu_44[counter44] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_44++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_44.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_45)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_45 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bbcc.txt");
				FileReader fileReader_45 = new FileReader(file_45);
				BufferedReader br_45 = new BufferedReader(fileReader_45);

				String strLine_45;
				// Read File Line By Line
				// int counter1 = -1;
				int counter45 = -1;
				while ((strLine_45 = br_45.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter45++;
					if (strLine_45.equals(getfinalpath)) {
						if (paths.get(strLine_45)) {
							break;
						}

						else {
							paths.put(strLine_45, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_45);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_45, fin_45);

							if (!statu_45[counter45]) {

								for (int s = 0; s < R; s++) {

									solution_45[counter45][s] = v[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_45[counter45] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_45++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_45.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_46)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_46 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcaa.txt");
				FileReader fileReader_46 = new FileReader(file_46);
				BufferedReader br_46 = new BufferedReader(fileReader_46);

				String strLine_46;

				int counter46 = -1;
				while ((strLine_46 = br_46.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter46++;
					if (strLine_46.equals(getfinalpath)) {

						if (paths.get(strLine_46)) {
							break;
						} else {
							paths.put(strLine_46, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_46);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_16, fin_46);

							if (!statu_46[counter46]) {

								for (int s = 0; s < R; s++) {

									solution_46[counter46][s] = v[i][s];

								}
								statu_46[counter46] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_46++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_46.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_47)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_47 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcab.txt");
				FileReader fileReader_47 = new FileReader(file_47);
				BufferedReader br_47 = new BufferedReader(fileReader_47);

				String strLine_47;

				int counter47 = -1;
				while ((strLine_47 = br_47.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter47++;

					if (strLine_47.equals(getfinalpath)) {

						if (paths.get(strLine_47)) {
							break;
						} else {
							paths.put(strLine_47, true);

							int g_47 = 0;
							int va_47 = pathcounter.get(template_1);

							g_47++;
							int fin_47 = va_47 + g_47;

							pathcounter.put(template_47, fin_47);

							if (!statu_47[counter47]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_47[counter47][s] = v[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_47[counter47] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_47++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_47.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_48)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_48 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcac.txt");
				FileReader fileReader_48 = new FileReader(file_48);
				BufferedReader br_48 = new BufferedReader(fileReader_48);

				String strLine_48;
				// Read File Line By Line
				// int counter1 = -1;
				int counter48 = -1;
				while ((strLine_48 = br_48.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter48++;
					if (strLine_48.equals(getfinalpath)) {

						if (paths.get(strLine_48)) {
							break;
						}

						else {
							paths.put(strLine_48, true);

							int g_48 = 0;
							int va_48 = pathcounter.get(template_48);

							g_48++;
							int fin_32 = va_48 + g_48;

							pathcounter.put(template_48, fin_32);

							// break;

							if (!statu_48[counter48]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_48[counter48][s] = v[i][s];

								}
								statu_48[counter48] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_48++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_48.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_49)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_49 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcba.txt");
				FileReader fileReader_49 = new FileReader(file_49);
				BufferedReader br_49 = new BufferedReader(fileReader_49);

				String strLine_49;
				// Read File Line By Line
				// int counter1 = -1;
				int counter49 = -1;
				while ((strLine_49 = br_49.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter49++;
					if (strLine_49.equals(getfinalpath)) {

						if (paths.get(strLine_49)) {
							break;
						} else {
							paths.put(strLine_49, true);

							int xxi = 0;
							int valz = pathcounter.get(template_49);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_49, fin);

							// call path status .. assign truth flag... along that path...

							if (!statu_49[counter49]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_49[counter49][s] = v[i][s];

								}
								statu_49[counter49] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_49++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_49.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_50)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_50 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcbb.txt");
				FileReader fileReader_50 = new FileReader(file_50);
				BufferedReader br_50 = new BufferedReader(fileReader_50);

				String strLine_50;
				// Read File Line By Line
				// int counter1 = -1;
				int counter50 = -1;
				while ((strLine_50 = br_50.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter50++;
					if (strLine_50.equals(getfinalpath)) {

						if (paths.get(strLine_50)) {
							break;
						}

						else {
							paths.put(strLine_50, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_50);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_50, fin_34);

							if (!statu_50[counter50]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_50[counter50][s] = v[i][s];

								}
								statu_50[counter50] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_50++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_50.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_51)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_51 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcbc.txt");
				FileReader fileReader_51 = new FileReader(file_51);
				BufferedReader br_51 = new BufferedReader(fileReader_51);

				String strLine_51;
				// Read File Line By Line
				// int counter1 = -1;
				int counter51 = -1;
				while ((strLine_51 = br_51.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter51++;
					if (strLine_51.equals(getfinalpath)) {
						if (paths.get(strLine_51)) {
							break;
						}

						else {
							paths.put(strLine_51, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_51);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_51, fin_35);

							if (!statu_51[counter51]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_51[counter51][s] = v[i][s];

								}
								statu_51[counter51] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_51++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_51.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_52)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_52 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bcca.txt");
				FileReader fileReader_52 = new FileReader(file_52);
				BufferedReader br_52 = new BufferedReader(fileReader_52);

				String strLine_52;
				// Read File Line By Line
				// int counter1 = -1;
				int counter52 = -1;
				while ((strLine_52 = br_52.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter52++;
					if (strLine_52.equals(getfinalpath)) {

						if (paths.get(strLine_52)) {
							break;
						}

						else {
							paths.put(strLine_52, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_52);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_52, fin_36);

							if (!statu_52[counter52]) {

								for (int s = 0; s < R; s++) {

									solution_52[counter52][s] = v[i][s];

								}
								statu_52[counter52] = true; //
								obj_52++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_52.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_53)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_53 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bccb.txt");
				FileReader fileReader_53 = new FileReader(file_53);
				BufferedReader br_53 = new BufferedReader(fileReader_53);

				String strLine_53;
				// Read File Line By Line
				// int counter1 = -1;
				int counter53 = -1;
				while ((strLine_53 = br_53.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter53++;
					if (strLine_53.equals(getfinalpath)) {
						if (paths.get(strLine_53)) {
							break;
						} else {
							paths.put(strLine_53, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_53);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_53, fin_37);

							if (!statu_53[counter53]) {

								for (int s = 0; s < R; s++) {

									solution_53[counter53][s] = v[i][s];

								}
								statu_53[counter53] = true; //
								obj_53++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_53.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_54)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_54 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/bccc.txt");
				FileReader fileReader_54 = new FileReader(file_54);
				BufferedReader br_54 = new BufferedReader(fileReader_54);

				String strLine_54;
				// Read File Line By Line
				// int counter1 = -1;
				int counter54 = -1;
				while ((strLine_54 = br_54.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter54++;
					if (strLine_54.equals(getfinalpath)) {

						if (paths.get(strLine_54)) {
							break;
						}

						else {
							paths.put(strLine_54, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_54);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_54, fin_38);

							if (!statu_54[counter54]) {

								for (int s = 0; s < R; s++) {

									solution_54[counter54][s] = v[i][s];

								}
								statu_54[counter54] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_54++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_54.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_55)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_55 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caaa.txt");
				FileReader fileReader_55 = new FileReader(file_55);
				BufferedReader br_55 = new BufferedReader(fileReader_55);

				String strLine_55;
				// Read File Line By Line
				// int counter1 = -1;
				int counter55 = -1;
				while ((strLine_55 = br_55.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter55++;
					if (strLine_55.equals(getfinalpath)) {
						if (paths.get(strLine_55)) {
							break;
						}

						else {
							paths.put(strLine_55, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_55);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_55, fin_39);

							if (!statu_55[counter55]) {

								for (int s = 0; s < R; s++) {

									solution_55[counter55][s] = v[i][s];

								}
								statu_55[counter55] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_55++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_55.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_56)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_56 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caab.txt");
				FileReader fileReader_56 = new FileReader(file_56);
				BufferedReader br_56 = new BufferedReader(fileReader_56);

				String strLine_56;
				// Read File Line By Line
				// int counter1 = -1;
				int counter56 = -1;
				while ((strLine_56 = br_56.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter56++;
					if (strLine_56.equals(getfinalpath)) {
						if (paths.get(strLine_56)) {
							break;
						}

						else {
							paths.put(strLine_56, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_56);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_56, fin_40);

							if (!statu_56[counter56]) {

								for (int s = 0; s < R; s++) {

									solution_56[counter56][s] = v[i][s];

								}
								statu_56[counter56] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_56++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_56.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_57)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_57 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caac.txt");
				FileReader fileReader_57 = new FileReader(file_57);
				BufferedReader br_57 = new BufferedReader(fileReader_57);

				String strLine_57;
				// Read File Line By Line
				// int counter1 = -1;
				int counter57 = -1;
				while ((strLine_57 = br_57.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter57++;
					if (strLine_57.equals(getfinalpath)) {
						if (paths.get(strLine_57)) {
							break;
						}

						else {
							paths.put(strLine_57, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_57);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_57, fin_41);

							if (!statu_57[counter57]) {

								for (int s = 0; s < R; s++) {

									solution_57[counter57][s] = v[i][s];

								}
								statu_57[counter57] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_57++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_57.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_58)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_58 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caba.txt");
				FileReader fileReader_58 = new FileReader(file_58);
				BufferedReader br_58 = new BufferedReader(fileReader_58);

				String strLine_58;
				// Read File Line By Line
				// int counter1 = -1;
				int counter58 = -1;
				while ((strLine_58 = br_58.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter58++;
					if (strLine_58.equals(getfinalpath)) {

						if (paths.get(strLine_58)) {
							break;
						} else {
							paths.put(strLine_58, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_58);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_58, fin_42);

							if (!statu_58[counter58]) {

								for (int s = 0; s < R; s++) {

									solution_58[counter58][s] = v[i][s];

								}
								statu_58[counter58] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_58++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_58.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_59)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_59 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cabb.txt");
				FileReader fileReader_59 = new FileReader(file_59);
				BufferedReader br_59 = new BufferedReader(fileReader_59);

				String strLine_59;
				// Read File Line By Line
				// int counter1 = -1;
				int counter59 = -1;
				while ((strLine_59 = br_59.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter59++;
					if (strLine_59.equals(getfinalpath)) {
						if (paths.get(strLine_59)) {
							break;
						}

						else {
							paths.put(strLine_59, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_59);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_59, fin_43);

							if (!statu_59[counter59]) {

								for (int s = 0; s < R; s++) {

									solution_59[counter59][s] = v[i][s];

								}
								statu_59[counter59] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_59++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_59.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_60)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_60 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cabc.txt");
				FileReader fileReader_60 = new FileReader(file_60);
				BufferedReader br_60 = new BufferedReader(fileReader_60);

				String strLine_60;
				// Read File Line By Line
				// int counter1 = -1;
				int counter60 = -1;
				while ((strLine_60 = br_60.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter60++;
					if (strLine_60.equals(getfinalpath)) {
						if (paths.get(strLine_60)) {
							break;
						} else {
							paths.put(strLine_60, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_60);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_60, fin_44);

							if (!statu_60[counter60]) {

								for (int s = 0; s < R; s++) {

									solution_60[counter60][s] = v[i][s];

								}
								statu_60[counter60] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_60++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_60.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_61)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_61 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/caca.txt");
				FileReader fileReader_61 = new FileReader(file_61);
				BufferedReader br_61 = new BufferedReader(fileReader_61);

				String strLine_61;
				// Read File Line By Line
				// int counter1 = -1;
				int counter61 = -1;
				while ((strLine_61 = br_61.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter61++;
					if (strLine_61.equals(getfinalpath)) {
						if (paths.get(strLine_61)) {
							break;
						} else {
							paths.put(strLine_61, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_61);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_61, fin_45);

							if (!statu_61[counter61]) {

								for (int s = 0; s < R; s++) {

									solution_61[counter61][s] = v[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_61[counter61] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_61++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_61.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_62)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_62 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cacb.txt");
				FileReader fileReader_62 = new FileReader(file_62);
				BufferedReader br_62 = new BufferedReader(fileReader_62);

				String strLine_62;

				int counter62 = -1;
				while ((strLine_62 = br_62.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter62++;
					if (strLine_62.equals(getfinalpath)) {

						if (paths.get(strLine_62)) {
							break;
						}

						else {
							paths.put(strLine_62, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_62);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_62, fin_46);

							if (!statu_62[counter62]) {

								for (int s = 0; s < R; s++) {

									solution_62[counter62][s] = v[i][s];

								}
								statu_62[counter62] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_62++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_62.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_63)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_63 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cacc.txt");
				FileReader fileReader_63 = new FileReader(file_63);
				BufferedReader br_63 = new BufferedReader(fileReader_63);

				String strLine_63;

				int counter63 = -1;
				while ((strLine_63 = br_63.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter63++;

					if (strLine_63.equals(getfinalpath)) {

						if (paths.get(strLine_63)) {
							break;
						}

						else {
							paths.put(strLine_63, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_63);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_63, fin_31);

							if (!statu_63[counter63]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_63[counter63][s] = v[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_63[counter63] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_63++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_63.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_64)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_64 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbaa.txt");
				FileReader fileReader_64 = new FileReader(file_64);
				BufferedReader br_64 = new BufferedReader(fileReader_64);

				String strLine_64;
				// Read File Line By Line
				// int counter1 = -1;
				int counter64 = -1;
				while ((strLine_64 = br_64.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter64++;
					if (strLine_64.equals(getfinalpath)) {

						if (paths.get(strLine_64)) {
							break;
						}

						else {
							paths.put(strLine_64, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_64);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_64, fin_32);

							// break;

							if (!statu_64[counter64]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_64[counter64][s] = v[i][s];

								}
								statu_64[counter64] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_64++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_64.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_65)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_65 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbab.txt");
				FileReader fileReader_65 = new FileReader(file_65);
				BufferedReader br_65 = new BufferedReader(fileReader_65);

				String strLine_65;
				// Read File Line By Line
				// int counter1 = -1;
				int counter65 = -1;
				while ((strLine_65 = br_65.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter65++;
					if (strLine_65.equals(getfinalpath)) {

						if (paths.get(strLine_65)) {
							break;
						} else {
							paths.put(strLine_65, true);

							int xxi = 0;
							int valz = pathcounter.get(template_65);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_65, fin);

							// call path status .. assign truth flag... along that path...

							if (!statu_65[counter65]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_65[counter65][s] = v[i][s];

								}
								statu_65[counter65] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_65++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_65.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_66)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_66 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbac.txt");
				FileReader fileReader_66 = new FileReader(file_66);
				BufferedReader br_66 = new BufferedReader(fileReader_66);

				String strLine_66;
				// Read File Line By Line
				// int counter1 = -1;
				int counter66 = -1;
				while ((strLine_66 = br_66.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter66++;
					if (strLine_66.equals(getfinalpath)) {

						if (paths.get(strLine_66)) {
							break;
						} else {
							paths.put(strLine_66, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_66);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_66, fin_34);

							if (!statu_66[counter66]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_66[counter66][s] = v[i][s];

								}
								statu_66[counter66] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_66++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_66.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_67)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_67 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbba.txt");
				FileReader fileReader_67 = new FileReader(file_67);
				BufferedReader br_67 = new BufferedReader(fileReader_67);

				String strLine_67;
				// Read File Line By Line
				// int counter1 = -1;
				int counter67 = -1;
				while ((strLine_67 = br_67.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter67++;
					if (strLine_67.equals(getfinalpath)) {
						if (paths.get(strLine_67)) {
							break;
						} else {
							paths.put(strLine_67, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_67);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_67, fin_35);

							if (!statu_67[counter67]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_67[counter67][s] = v[i][s];

								}
								statu_67[counter67] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_67++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_67.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_68)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_68 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbbb.txt");
				FileReader fileReader_68 = new FileReader(file_68);
				BufferedReader br_68 = new BufferedReader(fileReader_68);

				String strLine_68;
				// Read File Line By Line
				// int counter1 = -1;
				int counter68 = -1;
				while ((strLine_68 = br_68.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter68++;
					if (strLine_68.equals(getfinalpath)) {

						if (paths.get(strLine_68)) {
							break;
						} else {
							paths.put(strLine_68, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_68);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_68, fin_36);

							if (!statu_68[counter68]) {

								for (int s = 0; s < R; s++) {

									solution_68[counter68][s] = v[i][s];

								}
								statu_68[counter68] = true; //
								obj_68++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_68.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_69)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_69 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbbc.txt");
				FileReader fileReader_69 = new FileReader(file_69);
				BufferedReader br_69 = new BufferedReader(fileReader_69);

				String strLine_69;
				// Read File Line By Line
				// int counter1 = -1;
				int counter69 = -1;
				while ((strLine_69 = br_69.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter69++;
					if (strLine_69.equals(getfinalpath)) {
						if (paths.get(strLine_69)) {
							break;
						}

						else {
							paths.put(strLine_69, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_69);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_69, fin_37);

							if (!statu_69[counter69]) {

								for (int s = 0; s < R; s++) {

									solution_69[counter69][s] = v[i][s];

								}
								statu_69[counter69] = true; //
								obj_69++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_69.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_70)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_70 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbca.txt");
				FileReader fileReader_70 = new FileReader(file_70);
				BufferedReader br_70 = new BufferedReader(fileReader_70);

				String strLine_70;
				// Read File Line By Line
				// int counter1 = -1;
				int counter70 = -1;
				while ((strLine_70 = br_70.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter70++;
					if (strLine_70.equals(getfinalpath)) {
						if (paths.get(strLine_70)) {
							break;
						}

						else {
							paths.put(strLine_70, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_70);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_70, fin_38);

							if (!statu_70[counter70]) {

								for (int s = 0; s < R; s++) {

									solution_70[counter70][s] = v[i][s];

								}
								statu_70[counter70] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_70++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_70.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_71)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_71 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbcb.txt");
				FileReader fileReader_71 = new FileReader(file_71);
				BufferedReader br_71 = new BufferedReader(fileReader_71);

				String strLine_71;
				// Read File Line By Line
				// int counter1 = -1;
				int counter71 = -1;
				while ((strLine_71 = br_71.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter71++;
					if (strLine_71.equals(getfinalpath)) {
						if (paths.get(strLine_71)) {
							break;
						} else {
							paths.put(strLine_71, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_71);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_71, fin_39);

							if (!statu_71[counter71]) {

								for (int s = 0; s < R; s++) {

									solution_71[counter71][s] = v[i][s];

								}
								statu_71[counter71] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_71++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_71.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_72)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_72 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cbcc.txt");
				FileReader fileReader_72 = new FileReader(file_72);
				BufferedReader br_72 = new BufferedReader(fileReader_72);

				String strLine_72;
				// Read File Line By Line
				// int counter1 = -1;
				int counter72 = -1;
				while ((strLine_72 = br_72.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter72++;
					if (strLine_72.equals(getfinalpath)) {
						if (paths.get(strLine_72)) {
							break;
						}

						else {
							paths.put(strLine_72, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_72);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_72, fin_40);

							if (!statu_72[counter72]) {

								for (int s = 0; s < R; s++) {

									solution_72[counter72][s] = v[i][s];

								}
								statu_72[counter72] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_72++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_72.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_73)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_73 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccaa.txt");
				FileReader fileReader_73 = new FileReader(file_73);
				BufferedReader br_73 = new BufferedReader(fileReader_73);

				String strLine_73;
				// Read File Line By Line
				// int counter1 = -1;
				int counter73 = -1;
				while ((strLine_73 = br_73.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter73++;
					if (strLine_73.equals(getfinalpath)) {
						if (paths.get(strLine_73)) {
							break;
						}

						else {
							paths.put(strLine_73, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_73);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_73, fin_41);

							if (!statu_73[counter73]) {

								for (int s = 0; s < R; s++) {

									solution_73[counter73][s] = v[i][s];

								}
								statu_73[counter73] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_73++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_73.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_74)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_74 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccab.txt");
				FileReader fileReader_74 = new FileReader(file_74);
				BufferedReader br_74 = new BufferedReader(fileReader_74);

				String strLine_74;
				// Read File Line By Line
				// int counter1 = -1;
				int counter74 = -1;
				while ((strLine_74 = br_74.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter74++;
					if (strLine_74.equals(getfinalpath)) {

						if (paths.get(strLine_74)) {
							break;
						} else {
							paths.put(strLine_74, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_74);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_74, fin_42);

							if (!statu_74[counter74]) {

								for (int s = 0; s < R; s++) {

									solution_74[counter74][s] = v[i][s];

								}
								statu_74[counter74] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_74++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_74.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_75)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_75 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccac.txt");
				FileReader fileReader_75 = new FileReader(file_75);
				BufferedReader br_75 = new BufferedReader(fileReader_75);

				String strLine_75;
				// Read File Line By Line
				// int counter1 = -1;
				int counter75 = -1;
				while ((strLine_75 = br_75.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter75++;
					if (strLine_75.equals(getfinalpath)) {
						if (paths.get(strLine_75)) {
							break;
						}

						else {
							paths.put(strLine_75, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_75);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_75, fin_43);

							if (!statu_75[counter75]) {

								for (int s = 0; s < R; s++) {

									solution_75[counter75][s] = v[i][s];

								}
								statu_75[counter75] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_75++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_75.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_76)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_76 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccba.txt");
				FileReader fileReader_76 = new FileReader(file_76);
				BufferedReader br_76 = new BufferedReader(fileReader_76);

				String strLine_76;
				// Read File Line By Line
				// int counter1 = -1;
				int counter76 = -1;
				while ((strLine_76 = br_76.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter76++;
					if (strLine_76.equals(getfinalpath)) {
						if (paths.get(strLine_76)) {
							break;
						} else {
							paths.put(strLine_76, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_76);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_76, fin_44);

							if (!statu_76[counter76]) {

								for (int s = 0; s < R; s++) {

									solution_76[counter76][s] = v[i][s];

								}
								statu_76[counter76] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_76++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_76.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_77)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_77 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccbb.txt");
				FileReader fileReader_77 = new FileReader(file_77);
				BufferedReader br_77 = new BufferedReader(fileReader_77);

				String strLine_77;
				// Read File Line By Line
				// int counter1 = -1;
				int counter77 = -1;
				while ((strLine_77 = br_77.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter77++;
					if (strLine_77.equals(getfinalpath)) {
						if (paths.get(strLine_77)) {
							break;
						}

						else {
							paths.put(strLine_77, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_77);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_77, fin_45);

							if (!statu_77[counter77]) {

								for (int s = 0; s < R; s++) {

									solution_77[counter77][s] = v[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_77[counter77] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_77++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_77.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_78)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_78 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccbc.txt");
				FileReader fileReader_78 = new FileReader(file_78);
				BufferedReader br_78 = new BufferedReader(fileReader_78);

				String strLine_78;

				int counter78 = -1;
				while ((strLine_78 = br_78.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter78++;
					if (strLine_78.equals(getfinalpath)) {

						if (paths.get(strLine_78)) {
							break;
						}

						else {
							paths.put(strLine_78, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_78);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_78, fin_46);

							if (!statu_78[counter78]) {

								for (int s = 0; s < R; s++) {

									solution_78[counter78][s] = v[i][s];

								}
								statu_78[counter78] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_78++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_78.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_79)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_79 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/ccca.txt");
				FileReader fileReader_79 = new FileReader(file_79);
				BufferedReader br_79 = new BufferedReader(fileReader_79);

				String strLine_79;

				int counter79 = -1;
				while ((strLine_79 = br_79.readLine()) != null) {
					// Print the paths in this group to the console
					// System.out.println (strLine);
					counter79++;

					if (strLine_79.equals(getfinalpath)) {

						if (paths.get(strLine_79)) {
							break;
						}

						else {
							paths.put(strLine_79, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_79);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_79, fin_31);

							if (!statu_79[counter79]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_79[counter79][s] = v[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_79[counter79] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_79++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_79.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_80)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_80 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cccb.txt");
				FileReader fileReader_80 = new FileReader(file_80);
				BufferedReader br_80 = new BufferedReader(fileReader_80);

				String strLine_80;
				// Read File Line By Line
				// int counter1 = -1;
				int counter80 = -1;
				while ((strLine_80 = br_80.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter80++;
					if (strLine_80.equals(getfinalpath)) {

						if (paths.get(strLine_80)) {
							break;
						}

						else {
							paths.put(strLine_80, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_80);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_80, fin_32);

							// break;

							if (!statu_80[counter80]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_80[counter80][s] = v[i][s];

								}
								statu_80[counter80] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_80++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_80.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_81)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_81 = new File("C:/Users/Stuart/eclipse-workspace/MOLPC/Bench/cccc.txt");
				FileReader fileReader_81 = new FileReader(file_81);
				BufferedReader br_81 = new BufferedReader(fileReader_81);

				String strLine_81;
				// Read File Line By Line
				// int counter1 = -1;
				int counter81 = -1;
				while ((strLine_81 = br_81.readLine()) != null) {
					// Print the content on the console
					// System.out.println (strLine);
					counter81++;
					if (strLine_81.equals(getfinalpath)) {

						if (paths.get(strLine_81)) {
							break;
						}

						else {
							paths.put(strLine_81, true);

							int xxi = 0;
							int valz = pathcounter.get(template_81);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_81, fin);

							// call path status .. assign truth flag... along that path...

							if (!statu_81[counter81]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_81[counter81][s] = v[i][s];

								}
								statu_81[counter81] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_81++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_81.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

	}
}
