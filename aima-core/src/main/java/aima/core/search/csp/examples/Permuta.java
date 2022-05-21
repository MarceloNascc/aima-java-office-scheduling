package aima.core.search.csp.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permuta {
	public static List<List<Integer>> permuta (int[] vetor, int qntd) {
		
		int n = vetor.length;
		List<List<Integer>> values = new ArrayList<>();
		
		if (qntd == 1) {
			for(int i = 0 ; i<n ; i++) {
				values.add(new ArrayList<>());

				values.get(i).addAll(Arrays.asList(vetor[i]));
			}
		}
		else if (qntd == 2) {
			int cont = 0;
			for(int i=0 ; i<n ; i++) {
				for(int j = i + 1 ; j<n ; j++) {
					values.add(new ArrayList<>());

					values.get(cont).addAll(Arrays.asList(vetor[i],vetor[j]));
					cont++;
				}
			}
		}
		else if (qntd == 3) {
			int cont = 0;
			for(int i=0 ; i<n ; i++) {
				for(int j=i+1 ; j<n ; j++) {
					for(int k=j+1 ; k<n ; k++) {
						values.add(new ArrayList<>());
						
						values.get(cont).addAll(Arrays.asList(vetor[i],vetor[j],vetor[k]));
						cont++;
					}
				}
			}
		}
		else if (qntd == 4) {
			int cont = 0;
			for(int i=0 ; i<n ; i++) {
				for(int j=i+1 ; j<n ; j++) {
					for(int k=j+1 ; k<n ; k++) {
						for(int l=k+1 ; l<n ; l++) {
							values.add(new ArrayList<>());
							
							values.get(cont).addAll(Arrays.asList(vetor[i],vetor[j],vetor[k],vetor[l]));
							cont++;
						}
					}
				}
			}
		}
		
		return values;
	}
}
