# Loop_Coverage
 As an emerging trend, recasting automated test case generation(ATCG) as a many-objective optimisation problem (MOP) is a promising direction to improve the test case generation process. The new formulation of ATCG as a MOP(See attached file branch_coverage.pdf) has largely been investigated on some coverage criteria such branch, statement, line, strong mutation coverage. However, in the context of path coverage no work has been done. Since path coverage is regarded the most difficult criterion in practice, this work extends the existing research trend to tackle ATCG for path coverage as MOP. Specifically, this  work studies ATCG in programs under test with loops. As discussed in the following abstract. Note that this is an abstract of an article to be submitted to the IEEE Transactions on Software Engineering Journal.   (Unfortunately we cannot share the whole article here due to patent and copyright issues until the article undergoes the review process but only provide the abstract)
 
 
 Path coverage is a structural test adequacy criterion that seeks to maximize the coverage of feasible paths in a program under test. It is noted that this criterion is not always applicable in loops due to the well known path explosion problem. However, in multipath loops with complex interleaving patterns, it is necessary to generate test cases to explore the distinct loop behavior. In this work, we formulate  test case generation for path coverage in a k-bounded loop as a many objective optimisation problem. Due to the considerable number of coverage targets (i.e., loop paths in this context) to optimise, we design a knowledge re-use framework that grows with experience to speed up the optimisation process. Specifically, our technique first organizes similar loop paths into equivalence classes (i.e., groups) and related groups into the same neighbor sets based on the leveraged common subpath prefix information. Then, the search is focused on optimising one group of interest at a time. The key aspect of our approach is its adaptiveness, in the sense that it transfers useful knowledge (i.e., elite candidate solutions) previously covering some paths in a neighbor set to initialize the population for a new target group of interest in the same set. An empirical study was carried out to have evaluate our technique using loops from 27 benchmarks functions including both real-world programs and artificial problems. The study shows that our proposed approach is more efficient and effective in achieving higher loop path coverage scores (+47.61 percent more coverage on average) incase of limited search budget than the state-of-the-art many-objective solver for test case generation, Many-Objective Sorting Algorithm (MOSA). The study also shows that our proposed approach is effective in achieving higher loop path coverage (+68.92 percent more coverage on average) than the state-of-the-art Dynamic Symbolic Execution tools, PathCrawler and KLEE.
 
The file max_MOSA.java is an implementation of the existing algorithm , MOSA in EVOSUITE(http://www.evosuite.org/) . In this work, MOSA is implemented targeting loop path coverage as coverage 
criterion. max is an example of a benchmark function with a loop. (Max simply finds the maximum element in an array).Note that this is only used as an example. The algorithm has been tested on other benchmark fucntions
The uploaded file branch_coverage.pdf is a paper published in 2018 by the IEEE Transactions on Software Engineering Journal. This paper contains the description of MOSA
The file max_LPCF.java is an implemetation of the proposed loop path coverage work in this project. LPCF extend the generic
many objective formulation for test case generation, in (See branch_coverage.pdf) to design an adapative re-use framework capable of attaining
high coverage levels in programs under test loops
The file benchmark.pdf lists the benchmark fucntions from various repositories on which the experiments were conducted
