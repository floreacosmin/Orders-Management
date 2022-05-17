package bll.validators;

import model.Client;

/**
 * Class for validate client age
 */
public class ClientAgeValidator implements Validator<Client> {
	private static final int MIN_AGE = 7;
	private static final int MAX_AGE = 75;

	/**
	 * Method for validate client age
	 * @param t client to be validated
	 */
	public void validate(Client t) {

		if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
			throw new IllegalArgumentException("The Client Age limit is not respected!");
		}

	}

}
