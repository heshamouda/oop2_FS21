public class Geist extends AnimObjekt {
	protected int[][] labyrinth;
	private static int count = 0;

	public Geist(int spalte, int zeile, int groesse, int[][] labyrinth) {
		super(zeile, spalte, groesse, labyrinth, "geist_" + count % 4 + ".png");
		count++;
		this.labyrinth = labyrinth;
	}

	public void update() {
		super.update();
		if (ueberFeld()) {
			if (vx > 0.0 || vx == 0 && vy == 0) {
				int[] v = zufall(labyrinth[zeile - 1][spalte], labyrinth[zeile][spalte + 1],
						labyrinth[zeile + 1][spalte]);
				vx = v[0];
				vy = v[1];
				return;
			}
			if (vx < 0.0) {
				int[] v = zufall(labyrinth[zeile + 1][spalte], labyrinth[zeile][spalte - 1],
						labyrinth[zeile - 1][spalte]);
				vx = -v[0];
				vy = -v[1];
				return;
			}
			if (vy < 0.0) {
				int[] v = zufall(labyrinth[zeile][spalte - 1], labyrinth[zeile - 1][spalte],
						labyrinth[zeile][spalte + 1]);
				vy = -v[0];
				vx = v[1];
				return;
			}
			if (vy > 0.0) {
				int[] v = zufall(labyrinth[zeile][spalte + 1], labyrinth[zeile + 1][spalte],
						labyrinth[zeile][spalte - 1]);
				vy = v[0];
				vx = -v[1];
				return;
			}
		}
	}

	public int[] zufall(int zelleLinks, int zelleVorne, int zelleRechts) {
		// 10

		if (zelleVorne != 0 && zelleRechts != 0 && zelleLinks != 0) {
			return new int[] { -v, 0 };
		}

		while (true) {
			int z = (int) (Math.random() * 2.5);
			if (z == 0 && zelleLinks == 0) {
				return new int[] { 0, -v };
			}
			if (z == 1 && zelleRechts == 0) {
				return new int[] { 0, v };
			}
			if (z == 2 && zelleVorne == 0) {
				return new int[] { v, 0 };
			}
		}
	}
}
