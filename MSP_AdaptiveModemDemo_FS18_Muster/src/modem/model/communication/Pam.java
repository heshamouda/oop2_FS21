package modem.model.communication;

public class Pam {

	public static long statesc;
	public static long statede;

	public static int scrambler(int bit) {
		bit &= 0x1;

		bit = (int) (bit ^ (((statesc & 0x020000) >> 17) ^ ((statesc & 0x400000) >> 22)));
		statesc = ((statesc << 1) | bit) & 0x7fffff;

		return (int) (statesc & 0x1);
	}

	public static int descrambler(int bit) {
		int res;
		bit &= 0x1;

		res = (int) (bit ^ (((statede & 0x020000) >> 17) ^ ((statede & 0x400000) >> 22)));
		statede = ((statede << 1) | bit) & 0x7fffff;

		return res;
	}

	public static float mapper(int bits) {
		float res = 0.0f;
		// Bildet 2 bit in ein Symbol ab: 10 -> +3, 11 -> +1, 01 -> -1, 00 -> -3
		switch (bits) {
		case 2:
			res = 3.0f;
			break;
		case 3:
			res = 1.0f;
			break;
		case 1:
			res = -1.0f;
			break;
		case 0:
			res = -3.0f;
		}
		return res;
	}

	public static int demapper(float symbol) {
		// Bildet ein Symbol in zwei bit ab: +3 -> 01, +1 -> 11, -1 -> 01, -3 ->
		// 00
		switch ((int) symbol) {
		case 3:
			return 2;
		case 1:
			return 3;
		case -1:
			return 1;
		case -3:
			return 0;
		}
		return 0;
	}

	public static float slicer(float input) {
		// Gibt das zu input naechst gelegene Symbol zurueck.
		if (input > 0.0) {
			if (input > 2.0)
				return 3.0f;
			else
				return 1.0f;
		} else {
			if (input < -2.0)
				return -3.0f;
			else
				return -1.0f;
		}
	}

	private static long statePRNB = 1;
	private static long cntPRBN = 0;

	public static int prbn(int q) {
		long res = 0;

		if (cntPRBN++ == (0x1 << q)) {
			cntPRBN = 1;
			statePRNB = 1;
		}

		switch (q) {
		case 3:
			res = (((statePRNB >> (3 - 1)) ^ (statePRNB >> (2 - 1))) & 0x1);
			break;
		case 4:
			res = (((statePRNB >> (4 - 1)) ^ (statePRNB >> (3 - 1))) & 0x1);
			break;
		case 5:
			res = (((statePRNB >> (5 - 1)) ^ (statePRNB >> (3 - 1))) & 0x1);
			break;
		case 6:
			res = (((statePRNB >> (6 - 1)) ^ (statePRNB >> (5 - 1))) & 0x1);
			break;
		case 7:
			res = (((statePRNB >> (7 - 1)) ^ (statePRNB >> (4 - 1))) & 0x1);
			break;
		case 8:
			res = (((statePRNB >> (8 - 1)) ^ (statePRNB >> (7 - 1)) ^ (statePRNB >> (5 - 1)) ^ (statePRNB >> (3 - 1)))
					& 0x1);
			break;
		case 9:
			res = (((statePRNB >> (9 - 1)) ^ (statePRNB >> (5 - 1))) & 0x1);
			break;
		case 10:
			res = (((statePRNB >> (10 - 1)) ^ (statePRNB >> (7 - 1))) & 0x1);
			break;
		case 11:
			res = (((statePRNB >> (11 - 1)) ^ (statePRNB >> (9 - 1))) & 0x1);
			break;
		case 12:
			res = (((statePRNB >> (12 - 1)) ^ (statePRNB >> (11 - 1)) ^ (statePRNB >> (8 - 1)) ^ (statePRNB >> (6 - 1)))
					& 0x1);
			break;
		case 13:
			res = (((statePRNB >> (13 - 1)) ^ (statePRNB >> (10 - 1)) ^ (statePRNB >> (6 - 1)) ^ (statePRNB >> (4 - 1)))
					& 0x1);
			break;
		case 14:
			res = (((statePRNB >> (14 - 1)) ^ (statePRNB >> (13 - 1)) ^ (statePRNB >> (8 - 1)) ^ (statePRNB >> (4 - 1)))
					& 0x1);
			break;
		case 15:
			res = (((statePRNB >> (15 - 1)) ^ (statePRNB >> (14 - 1))) & 0x1);
			break;
		case 16:
			res = (((statePRNB >> (16 - 1)) ^ (statePRNB >> (14 - 1)) ^ (statePRNB >> (13 - 1))
					^ (statePRNB >> (11 - 1))) & 0x1);
			break;
		case 17:
			res = (((statePRNB >> (17 - 1)) ^ (statePRNB >> (14 - 1))) & 0x1);
			break;
		case 18:
			res = (((statePRNB >> (18 - 1)) ^ (statePRNB >> (11 - 1))) & 0x1);
			break;
		case 19:
			res = (((statePRNB >> (19 - 1)) ^ (statePRNB >> (18 - 1)) ^ (statePRNB >> (17 - 1))
					^ (statePRNB >> (14 - 1))) & 0x1);
			break;
		case 20:
			res = (((statePRNB >> (20 - 1)) ^ (statePRNB >> (17 - 1))) & 0x1);
			break;
		}

		statePRNB = ((statePRNB << 1) | res) & 0xffffff;

		return (int) (statePRNB >> (q - 1)) & 0x1;

	}

	public static void main(String[] args) {
		int q = 10;
		int[] pn = new int[(int) Math.round(Math.pow(2.0f, q) * 3.0)];

		System.out.println("pnj = [");
		for (int i = 0; i < pn.length; i++) {
			pn[i] = prbn(q);
			System.out.println("" + pn[i] + ";");
		}
		System.out.println("];");
	}

}
