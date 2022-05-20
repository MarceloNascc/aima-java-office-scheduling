package aima.core.search.csp.examples;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;

import java.util.ArrayList;
import java.util.List;

public class OfficeSchedulingCSP extends CSP<Variable, Integer> {

	public OfficeSchedulingCSP(int size) {
		addVariable(new Variable("Alice"));
		addVariable(new Variable("Bob"));
		addVariable(new Variable("Charlie"));
		addVariable(new Variable("David"));
		addVariable(new Variable("Eve"));
		
		//Alice
		List<Integer> values_A = new ArrayList<>();
		values_A.add(4);
		values_A.add(13);
		values_A.add(19);
		values_A.add(21);
		values_A.add(22);
		Domain<Integer> availability_A = new Domain<>(values_A);
		for (Variable var : getVariables())
			setDomain(var, availability_A);
		
		//Bob
		List<Integer> values_B = new ArrayList<>();
		values_B.add(6);
		values_B.add(9);
		values_B.add(10);
		values_B.add(14);
		values_B.add(15);
		values_B.add(21);
		Domain<Integer> availability_B = new Domain<>(values_B);
		
		for (Variable var : getVariables())
			setDomain(var, availability_B);
		
		//Charlie
		List<Integer> values_C = new ArrayList<>();
		values_C.add(5);
		values_C.add(8);
		values_C.add(10);
		values_C.add(13);
		values_C.add(14);
		values_C.add(21);
		values_C.add(22);
		values_C.add(23);
		Domain<Integer> availability_C = new Domain<>(values_C);
		
		for (Variable var : getVariables())
			setDomain(var, availability_C);
		
		//David
		List<Integer> values_D = new ArrayList<>();
		values_D.add(1);
		values_D.add(3);
		values_D.add(4);
		values_D.add(5);
		values_D.add(6);
		values_D.add(7);
		values_D.add(19);
		values_D.add(23);
		Domain<Integer> availability_D = new Domain<>(values_D);
		
		for (Variable var : getVariables())
			setDomain(var, availability_D);
		
		//Eve
		List<Integer> values_E = new ArrayList<>();
		values_E.add(2);
		values_E.add(4);
		values_E.add(7);
		values_E.add(10);
		values_E.add(11);
		values_E.add(13);
		values_E.add(14);
		values_E.add(15);
		values_E.add(18);
		values_E.add(21);
		Domain<Integer> availability_E = new Domain<>(values_E);
		
		for (Variable var : getVariables())
			setDomain(var, availability_E);

		// arrumar as restrições
//		for (int i = 0; i < size; i++) {
//			Variable var1 = getVariables().get(i);
//			for (int j = i+1; j < size; j++) {
//				Variable var2 = getVariables().get(j);
//				addConstraint(new DiffNotEqualConstraint(var1, var2, 0));
//				addConstraint(new DiffNotEqualConstraint(var1, var2, j-i));
//			}
//		}
	}
}