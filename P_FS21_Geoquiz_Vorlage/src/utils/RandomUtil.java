package utils;

public class RandomUtil {

	public static int[] randomDistinct(int amount, int minInclusiveValue, int maxExclusiveValue) {

		if (maxExclusiveValue - minInclusiveValue < amount) {
			throw new IllegalArgumentException("Error: maxExclusiveValue - minInclusiveValue < amount");
		}

		int[] results = new int[amount];

		int count = 0;

		while (count < amount) {
			int prop = (int) (minInclusiveValue + Math.random() * (maxExclusiveValue - minInclusiveValue));

			boolean found = false;
			for (int i = 0; i < count; i++) {
				if (results[i] == prop) { // exists already
					found = true;
					break;
				}
			}

			if (found) {
				continue;
			}

			results[count] = prop;
			count++;
		}

		return results;
	}
}
