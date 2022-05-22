package aima.gui.fx.applications.search;

import aima.core.search.csp.*;
import aima.core.search.csp.examples.OfficeSchedulingCSP;
import aima.core.search.csp.solver.CspListener;
import aima.core.search.csp.solver.CspSolver;
import aima.core.search.csp.solver.FlexibleBacktrackingSolver;
import aima.core.search.csp.solver.MinConflictsSolver;

import java.util.List;
import java.util.Optional;

public class OfficeSchedulingCspDemo {
	private static void printSolution(Assignment<Variable, List<Integer>> solution) {
		List<Variable> variables = solution.getVariables();
		System.out.println("            01AM | 02AM | 03AM | 04AM | 05AM | 06AM | 07AM | 08AM | 09AM | 10AM | 11AM | 12AM");
		System.out.println("            01PM | 02PM | 03PM | 04PM | 05PM | 06PM | 07PM | 08PM | 09PM | 10PM | 11PM | 12PM");
		System.out.println("            ---------------------------------------------------------------------------------");
		
		for (Variable variable : variables) {
			List<Integer> value = solution.getValue(variable);
			String name = variable.getName();
			Integer nameLength = name.length();
			
			System.out.print((name + ":") + (" ".repeat(12 - (nameLength + 2))) + "|");
			
			for (int i = 0; i < 12; i++) {
				Boolean morning = value.contains(i + 1);
				Boolean afternoon = value.contains(i + 13);
				
				if(morning && afternoon) {
					System.out.print("AMPM | ");
				}else if(morning) {
					System.out.print("AM   | ");
				}else if(afternoon) {
					System.out.print("  PM | ");
				}else {
					System.out.print("     | ");
				}
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		CSP<Variable, List<Integer>> csp = new OfficeSchedulingCSP();
		CspListener.StepCounter<Variable, List<Integer>> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, List<Integer>> solver;
		Optional<Assignment<Variable, List<Integer>>> solution;
		
		System.out.println("The Office scheduling problem - (Min-Conflicts)");
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp);
		if (solution.isPresent()) {
			System.out.println("Problem solution\n");
			printSolution(solution.get());
		}else {
			System.out.println("This problem has not a solution");
		}
		System.out.println(stepCounter.getResults() + "\n");
		
		System.out.println("The Office scheduling problem - (Backtracking + MRV & DEG + LCV + AC3)");
		csp = new OfficeSchedulingCSP();
		solver = new FlexibleBacktrackingSolver<Variable, List<Integer>>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp);
		if (solution.isPresent()) {
			System.out.println("Problem solution\n");
			printSolution(solution.get());
		}else {
			System.out.println("This problem has not a solution");
		}
		System.out.println(stepCounter.getResults() + "\n");

		System.out.println("The Office scheduling problem - (Backtracking)");
		csp = new OfficeSchedulingCSP();
		solver = new FlexibleBacktrackingSolver<Variable, List<Integer>>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp);
		if (solution.isPresent()) {
			System.out.println("Problem solution\n");
			printSolution(solution.get());
		}else {
			System.out.println("This problem has not a solution");
		}
		System.out.println(stepCounter.getResults() + "\n");
	}
}
