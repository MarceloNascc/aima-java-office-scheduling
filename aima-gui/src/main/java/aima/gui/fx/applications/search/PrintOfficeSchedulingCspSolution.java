package aima.gui.fx.applications.search;

import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Variable;

public class PrintOfficeSchedulingCspSolution {
	public static void printSolution(Assignment<Variable, List<Integer>> solution) {
		List<Variable> variables = solution.getVariables();
		System.out.println("                        01AM | 02AM | 03AM | 04AM | 05AM | 06AM | 07AM | 08AM | 09AM | 10AM | 11AM | 12AM");
		System.out.println("                        01PM | 02PM | 03PM | 04PM | 05PM | 06PM | 07PM | 08PM | 09PM | 10PM | 11PM | 12PM");
		System.out.println("                        ---------------------------------------------------------------------------------");
		
		for (Variable variable : variables) {
			List<Integer> value = solution.getValue(variable);
			String name = variable.getName();
			Integer nameLength = name.length();
			
			System.out.print((name + ":") + (" ".repeat(24 - (nameLength + 2))) + "|");
			
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
}
