package model;

/**
 * Class that represent client attributes
 */
public class Client {
	private int id;
	private String name;
	private String address;
	private String email;
	private int age;

	/**
	 * Constructor
	 * @param id client id
	 * @param name client name
	 * @param address client address
	 * @param email client email
	 * @param age client age
	 */
	public Client(int id, String name, String address, String email, int age) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
	}

	/**
	 * Constructor without parameters
	 */
	public Client() {

	}

	/**
	 * Get client ID
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set client id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get client name
	 * @return  String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get client address
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Get client age
	 * @return int
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Get client email
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set client name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Set client address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Set client email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Set client age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
