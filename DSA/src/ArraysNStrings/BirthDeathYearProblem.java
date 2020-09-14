package ArraysNStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BirthDeathYearProblem {

	public static class Span implements Comparable<Span> {
		int bYear;
		int dYear;

		public Span(int bYear, int dYear) {
			this.bYear = bYear;
			this.dYear = dYear;
		}

		@Override
		public int compareTo(Span o) {
			return this.bYear < o.bYear ? -1 : this.bYear == o.bYear ? 0 : 1;
		}

		@Override
		public String toString() {
			return "Span [bYear=" + bYear + ", dYear=" + dYear + "]";
		}

	}

	public static void main(String[] args) {
		Span span1 = new Span(1920, 1939);
		Span span2 = new Span(1911, 1944);
		Span span3 = new Span(1920, 1955);
		Span span4 = new Span(1938, 1939);
//		Span span5 = new Span(1910, 1920);
//		Span span6 = new Span(1915, 1920);
//		Span span7 = new Span(1919, 1925);

		BirthDeathYearProblem birthDeathYearProblem = new BirthDeathYearProblem();
		List<Span> spans = new ArrayList<BirthDeathYearProblem.Span>();
		spans.add(span1);
		spans.add(span2);
		spans.add(span3);
		spans.add(span4);
//		spans.add(span5);
//		spans.add(span6);
//		spans.add(span7);
		System.out.println(birthDeathYearProblem.getHighestPopulation(spans));
	}

	private Span getHighestPopulation(List<Span> spans) {
		if (spans == null || spans.size() == 0) {
			return null;
		}
		Collections.sort(spans);
		Span maxSpan = spans.get(0);
		Span currSpan = spans.get(0);
		int maxNum = 0;
		int currNum = 0;
		for (int i = 1; i < spans.size(); i++) {
			Span tempSpan = getHighestPopulation(currSpan, spans.get(i));
			if (tempSpan == null) {
				if (currNum > maxNum) {
					maxSpan = currSpan;
					maxNum = currNum;
				}
				currSpan = spans.get(i);
			} else {
				currSpan = tempSpan;
				currNum++;
			}
		}
		if (currNum > maxNum) {
			maxSpan = currSpan;
			maxNum = currNum;
		}
		return maxSpan;
	}

	private Span getHighestPopulation(Span s1, Span s2) {
		Span span = null;
		if (s2.bYear >= s1.bYear && s2.bYear <= s1.dYear) {
			span = new Span(s2.bYear, s1.dYear > s2.dYear ? s2.dYear : s1.dYear);
		}
		return span;
	}

	private boolean isEqualOrMax(Span s1, Span s2) {
		return s1.compareTo(s2) >= 0 ? true : false;
	}

}
