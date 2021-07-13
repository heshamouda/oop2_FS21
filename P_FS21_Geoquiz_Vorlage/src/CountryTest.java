import java.io.IOException;

import questions.Country;

public class CountryTest {

	public static void main(String[] args) throws IOException {
		Model model = new Model();
		model.loadCountries();

		for (int i = 0; i < model.countries.length; i++) {
			Country country = model.countries[i];
			System.out.println(country.getName() + "  " + country.getCode() + "  " + country.getPopulation() + "  "
					+ country.getArea());
		}
	}

}
