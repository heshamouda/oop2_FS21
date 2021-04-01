package tools.dsp;

public class Equalizer {
	double[] delay_0 = new double[636], delay_1 = new double[316], delay_2 = new double[156], delay_3 = new double[76],
			delay_4 = new double[36], delay_5 = new double[16], delay_6 = new double[6];

	int delay_index_0 = 0, delay_index_1 = 0, delay_index_2 = 0, delay_index_3 = 0, delay_index_4 = 0,
			delay_index_5 = 0, delay_index_6 = 0;

	private double af1_out, af2_out, af3_out, af4_out, af5_out, af6_out, af7_out;
	private double rf2_out = 0.0f, rf3_out = 0.0f, rf4_out = 0.0f, rf5_out = 0.0f, rf6_out = 0.0f, rf7_out = 0.0f;
	private double hp7_out = 0.0f;

	double[] gain = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };

	double[] AaRecTPBCoeffs = { 0.02170867296861, 0.07356260713958, 0.13857728322081, 0.16839002710093,
			0.13857728322081, 0.07356260713958, 0.02170867296861 };

	double[] AaRecTPACoeffs = { 1.00000000000000, -1.34432773148570, 1.51064332431635, -0.80327198408008,
			0.32902183506891, -0.06269220693807, 0.00671391687753 };

	double[] EqHPBCoeffs = { 0.10092879243311, -0.66953279951526, 2.05850380221022, -3.81450650554157, 4.64941790144919,
			-3.81450650554155, 2.05850380221021, -0.66953279951526, 0.10092879243311 };

	double[] EqHPACoeffs = { 1.00000000000000, -2.72738342991769, 4.35235949366943, -4.45434150533556, 3.18113730941069,
			-1.57686010004521, 0.52673709929535, -0.10735550402866, 0.01018725914681 };

	DSPFilter hp0 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);
	DSPFilter hp1 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);
	DSPFilter hp2 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);
	DSPFilter hp3 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);
	DSPFilter hp4 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);
	DSPFilter hp5 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);
	DSPFilter hp6 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);
	DSPFilter hp7 = new DSPFilter(EqHPBCoeffs, EqHPACoeffs);

	DSPFilter af1 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter af2 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter af3 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter af4 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter af5 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter af6 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter af7 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);

	DSPFilter rf1 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter rf2 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter rf3 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter rf4 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter rf5 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter rf6 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);
	DSPFilter rf7 = new DSPFilter(AaRecTPBCoeffs, AaRecTPACoeffs);

	public double[] equalizer(double[] inBlock) {
		double[] outBlock = new double[inBlock.length];

		for (int i = 0; i < inBlock.length; i++) {

			delay_0[delay_index_0++] = gain[0] * hp0.filter(inBlock[i]);
			if (delay_index_0 == 636)
				delay_index_0 = 0;
			af1_out = af1.filter(inBlock[i]);

			if ((i & 0x1) == 0x1) {
				delay_1[delay_index_1++] = gain[1] * hp1.filter(af1_out);
				if (delay_index_1 == 316)
					delay_index_1 = 0;
				af2_out = af2.filter(af1_out);

				if ((i & 0x3) == 0x3) {
					delay_2[delay_index_2++] = gain[2] * hp2.filter(af2_out);
					if (delay_index_2 == 156)
						delay_index_2 = 0;
					af3_out = af3.filter(af2_out);

					if ((i & 0x7) == 0x7) {
						delay_3[delay_index_3++] = gain[3] * hp3.filter(af3_out);
						if (delay_index_3 == 76)
							delay_index_3 = 0;
						af4_out = af4.filter(af3_out);

						if ((i & 0xf) == 0xf) {
							delay_4[delay_index_4++] = gain[4] * hp4.filter(af4_out);
							if (delay_index_4 == 36)
								delay_index_4 = 0;
							af5_out = af5.filter(af4_out);

							if ((i & 0x1f) == 0x1f) {
								delay_5[delay_index_5++] = gain[5] * hp5.filter(af5_out);
								if (delay_index_5 == 16)
									delay_index_5 = 0;
								af6_out = af6.filter(af5_out);

								if ((i & 0x3f) == 0x3f) {
									delay_6[delay_index_6++] = gain[6] * hp6.filter(af6_out);
									if (delay_index_6 == 6)
										delay_index_6 = 0;
									af7_out = af7.filter(af6_out);

									if ((i & 0x7f) == 0x7f) {
										hp7_out = gain[7] * hp7.filter(af7_out);
									}

									rf7_out = 2.0f * rf7.filter(hp7_out) + delay_6[delay_index_6];
									hp7_out = 0.0f;
								}

								rf6_out = 2.0f * rf6.filter(rf7_out) + delay_5[delay_index_5];
								rf7_out = 0.0f;
							}

							rf5_out = 2.0f * rf5.filter(rf6_out) + delay_4[delay_index_4];
							rf6_out = 0.0f;
						}

						rf4_out = 2.0f * rf4.filter(rf5_out) + delay_3[delay_index_3];
						rf5_out = 0.0f;
					}

					rf3_out = 2.0f * rf3.filter(rf4_out) + delay_2[delay_index_2];
					rf4_out = 0.0f;
				}

				rf2_out = 2.0f * rf2.filter(rf3_out) + delay_1[delay_index_1];
				rf3_out = 0.0f;
			}

			outBlock[i] = 2.0f * rf1.filter(rf2_out) + delay_0[delay_index_0];
			rf2_out = 0.0f;
		}

		return outBlock;
	}

	public void setGain(double[] gain) {
		this.gain = gain;
	}

	public static void main(String[] args) {

		Equalizer equalizer = new Equalizer();

		double[] in = new double[4096];
		double[] out;

		in[0] = 1.0;
		out = equalizer.equalizer(in);
		for (int j = 0; j < in.length; j++) {
			System.out.println(out[j]);
		}

		// long start = System.currentTimeMillis();
		//
		// in[0] = 0.0;
		// for (int i = 0; i < 16; i++) {
		// equalizer.equalizer(out, in);
		// // for (int j = 0; j < in.length; j++) {
		// // System.out.println(out[j]);
		// // }
		// }
		//
		// long stop = System.currentTimeMillis();
		//
		// System.out.println("Time in mills: " + (stop - start));
		// // Time in mills: 147 für 2048 * 16 Abtastwerte
	}

}
