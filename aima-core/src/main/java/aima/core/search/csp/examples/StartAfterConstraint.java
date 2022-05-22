package aima.core.search.csp.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

/**
 * Represents a binary constraint which forbids that var1 start before var2 finish his job.
 */
public class StartAfterConstraint implements Constraint<Variable, List<Integer>> {

	private Variable var1;
	private Variable var2;
	private List<Variable> scope;

	public StartAfterConstraint(Variable var1, Variable var2) {
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
		
		if(value1 != null && value2 != null) {
			Collections.sort(value2);
			Integer value2Finish = value2.get(value2.size() - 1);
			

			Collections.sort(value1);
			Integer value1Start = value1.get(0);
			
			if (value1Start < value2Finish) {
				isSatisfied = false;
			}
		}
		
		return isSatisfied;
	}
}
