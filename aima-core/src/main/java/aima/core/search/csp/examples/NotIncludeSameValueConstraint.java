package aima.core.search.csp.examples;

import java.util.ArrayList;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

/**
 * Represents a binary constraint which forbids has the same value in the array.
 */
public class NotIncludeSameValueConstraint implements Constraint<Variable, List<Integer>> {

	private Variable var1;
	private Variable var2;
	private List<Variable> scope;

	public NotIncludeSameValueConstraint(Variable var1, Variable var2) {
		this.var1 = var1;
		this.var2 = var2;

		scope = new ArrayList<Variable>(2);
		scope.add(var1);
		scope.add(var2);
	}

	@Override
	public List<Variable> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<Variable, List<Integer>> assignment) {
		List<Integer> value1 = assignment.getValue(var1);
		List<Integer> value2 = assignment.getValue(var2);
		
		Boolean isSatisfied = true;
		
		for (Integer assignedValue : value1) {
			if (value2.contains(assignedValue)) {
				isSatisfied = false;
				
				break;
			}
		}
		
		return isSatisfied;
	}
}
