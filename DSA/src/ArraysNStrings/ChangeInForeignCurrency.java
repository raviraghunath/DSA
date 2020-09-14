package ArraysNStrings;

public class ChangeInForeignCurrency {

	public static void main(String[] args) {
		ChangeInForeignCurrency changeInForeignCurrency = new ChangeInForeignCurrency();
		System.out.println(changeInForeignCurrency.canGetExactChange(75, new int[] { 4, 17, 29 }));
	}

	private boolean canGetExactChange(int targetMoney, int[] denominations) {
		return canGetExactChange(targetMoney, denominations, 0);
	}

	private boolean canGetExactChange(int targetMoney, int[] denominations, int pos) {
		if (targetMoney == 0) {
			return true;
		}
		if (targetMoney < 0 || pos == denominations.length) {
			return false;
		}
		for (int i = 0; i <= targetMoney / denominations[pos]; i++) {
			boolean currRes = canGetExactChange(targetMoney - (denominations[pos] * i), denominations, pos + 1);
			if (currRes) {
				return true;
			}
		}
		return false;
	}

}
