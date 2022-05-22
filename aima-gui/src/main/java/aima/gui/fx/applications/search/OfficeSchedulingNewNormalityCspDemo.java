package aima.gui.fx.applications.search;

import aima.core.search.csp.*;
import aima.core.search.csp.examples.OfficeSchedulingNewNormalityCSP;
import aima.core.search.csp.solver.CspListener;
import aima.core.search.csp.solver.CspSolver;
import aima.core.search.csp.solver.FlexibleBacktrackingSolver;
import aima.core.search.csp.solver.MinConflictsSolver;

import java.util.List;
import java.util.Optional;

public class OfficeSchedulingNewNormalityCspDemo {

	public static void main(String[] args) {
		CSP<Variable, List<Integer>> csp = new OfficeSchedulingNewNormalityCSP();
		CspListener.StepCounter<Variable, List<Integer>> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, List<Integer>> solver;
		Optional<Assignment<Variable, List<Integer>>> solution;
		
		System.out.println("The Office scheduling problem | New Normality - (Min-Conflicts)");
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp);
		if (solution.isPresent()) {
			System.out.println("Problem solution\n");
			PrintOfficeSchedulingCspSolution.printSolution(solution.get());
		}else {
			System.out.println("This problem has not a solution");
		}
		System.out.println(stepCounter.getResults() + "\n");
		
		System.out.println("The Office scheduling problem | New Normality - (Backtracking + MRV & DEG + LCV + AC3)");
		csp = new OfficeSchedulingNewNormalityCSP();
		solver = new FlexibleBacktrackingSolver<Variable, List<Integer>>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp);
		if (solution.isPresent()) {
			System.out.println("Problem solution\n");
			PrintOfficeSchedulingCspSolution.printSolution(solution.get());
		}else {
			System.out.println("This problem has not a solution");
		}
		System.out.println(stepCounter.getResults() + "\n");

		System.out.println("The Office scheduling problem | New Normality - (Backtracking)");
		csp = new OfficeSchedulingNewNormalityCSP();
		solver = new FlexibleBacktrackingSolver<Variable, List<Integer>>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp);
		if (solution.isPresent()) {
			System.out.println("Problem solution\n");
			PrintOfficeSchedulingCspSolution.printSolution(solution.get());
		}else {
			System.out.println("This problem has not a solution");
		}
		System.out.println(stepCounter.getResults() + "\n");
	}
}
