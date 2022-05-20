package aima.core.search.csp.examples;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;

import java.util.ArrayList;
import java.util.List;

public class OfficeSchedulingCSP extends CSP<Variable, List<Integer>> {

	public OfficeSchedulingCSP() {
		addVariable(new Variable("Alice"));
		addVariable(new Variable("Bob"));
		addVariable(new Variable("Charlie"));
		addVariable(new Variable("David"));
		addVariable(new Variable("Eve"));
		
		//Alice
		List<List<Integer>> values_A = new ArrayList<>();
		int horarios_A[] = {4,13,19,21,22};
		values_A = Permuta.permuta(horarios_A, 2);
		Domain<List<Integer>> availability_A = new Domain<>(values_A);
		Variable alice = getVariables().get(0);
		setDomain(alice, availability_A);
		
		//Bob
		List<List<Integer>> values_B = new ArrayList<>();
		int horarios_B[] = {6,9,10,14,15,21};
		values_B = Permuta.permuta(horarios_B, 3);
		Domain<List<Integer>> availability_B = new Domain<>(values_B);
		Variable bob = getVariables().get(1);
		setDomain(bob, availability_B);
		
		//Charlie
		List<List<Integer>> values_C = new ArrayList<>();
		int horarios_C[] = {5,8,10,13,14,21,22,23};
		values_C = Permuta.permuta(horarios_C, 1);
		Domain<List<Integer>> availability_C = new Domain<>(values_C);
		Variable charlie = getVariables().get(2);
		setDomain(charlie, availability_C);
		
		//David
		List<List<Integer>> values_D = new ArrayList<>();
		int horarios_D[] = {1,3,4,5,6,7,19,23};
		values_D = Permuta.permuta(horarios_D, 2);
		Domain<List<Integer>> availability_D = new Domain<>(values_D);
		Variable david = getVariables().get(3);
		setDomain(david, availability_D);
		
		//Eve
		List<List<Integer>> values_E = new ArrayList<>();
		int horarios_E[] = {2,4,7,10,11,13,14,15,18,21};
		values_E = Permuta.permuta(horarios_E, 4);
		Domain<List<Integer>> availability_E = new Domain<>(values_E);
		Variable eve = getVariables().get(4);
		setDomain(eve, availability_E);
		
		for (int i = 0; i < 5; i++) {
			Variable var1 = getVariables().get(i);

			for (int j = i + 1; j < 5; j++) {
				Variable var2 = getVariables().get(j);

				addConstraint(new NotIncludeSameValueConstraint(var1, var2));
			}
		}
	}
}