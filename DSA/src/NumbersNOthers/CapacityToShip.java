package NumbersNOthers;

public class CapacityToShip {

	public static void main(String[] args) {
		CapacityToShip capacityToShip = new CapacityToShip();
		System.out.println(capacityToShip.shipWithinDays(new int[] { 10, 50, 100, 100, 50, 100, 100, 100 }, 5));
	}

	public int shipWithinDays(int[] weights, int D) {
		int totalWt = 0;
		int max = 0;
		for (int i = 0; i < weights.length; i++) {
			totalWt += weights[i];
			max = Math.max(max, weights[i]);
		}
		int eWt = totalWt / D;
		if (totalWt % D > 0) {
			eWt++;
		}
		eWt = Math.max(max, eWt);
		while (true) {
			int cWt = 0;
			int d = 0;
			for (int i = 0; i < weights.length; i++) {
				cWt += weights[i];
				if (cWt > eWt) {
					d++;
					cWt = 0;
					i--;
				}
			}
			if (cWt > 0) {
				d++;
			}
			if (d <= D) {
				break;
			} else {
				eWt = eWt + 1;
			}
		}
		return eWt;

	}

}
