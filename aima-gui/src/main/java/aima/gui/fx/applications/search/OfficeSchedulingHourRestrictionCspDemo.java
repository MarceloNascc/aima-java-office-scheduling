package aima.gui.fx.applications.search;

import aima.core.search.csp.*;
import aima.core.search.csp.examples.OfficeSchedulingHourRestrictionCSP;
import aima.core.search.csp.solver.CspListener;
import aima.core.search.csp.solver.CspSolver;
import aima.core.search.csp.solver.FlexibleBacktrackingSolver;
import aima.core.search.csp.solver.MinConflictsSolver;

import java.util.List;
import java.util.Optional;

public class OfficeSchedulingHourRestrictionCspDemo {

	public static void main(String[] args) {
		CSP<Variable, List<Integer>> csp = new OfficeSchedulingHourRestrictionCSP(5 , 19);
		CspListener.StepCounter<Variable, List<Integer>> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, List<Integer>> solver;
		Optional<Assignment<Variable, List<Integer>>> solution;
		
		System.out.println("The Office scheduling problem | Hour Restriction - (Min-Conflicts)");
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
		
		System.out.println("The Office scheduling problem | Hour Restriction - (Backtracking + MRV & DEG + LCV + AC3)");
		csp = new OfficeSchedulingHourRestrictionCSP(6 , 18);
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

		System.out.println("The Office scheduling problem | Hour Restriction - (Backtracking)");
		csp = new OfficeSchedulingHourRestrictionCSP(6 , 18);
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
