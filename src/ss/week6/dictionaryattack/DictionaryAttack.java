package ss.week6.dictionaryattack;

import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<>();
	private Map<String, String> hashDictionary = new HashMap<>();

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 *
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws IOException
	 */
	public void readPasswords(String filename) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String text;
			while ((text = br.readLine()) != null) {

				String[] list = text.split(":");
				String username = list[0].trim();
				String password = list[1].trim();

				this.passwordMap.put(username, password);
			}
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {

		try {

			byte[] byteText = password.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hashText = md.digest(byteText);
			String hexText = Hex.encodeHexString(hashText);
			return hexText;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * Checks the password for the user in the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {

		if (passwordMap.containsKey(user) && passwordMap.containsValue(getPasswordHash(password))) {
			return true;
		}
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) {

			this.hashDictionary.put("1", "123456");
			this.hashDictionary.put("2", "123456789");
			this.hashDictionary.put("3", "12345");
			this.hashDictionary.put("4", "qwerty");
			this.hashDictionary.put("5", "password");
			this.hashDictionary.put("6", "12345678");
			this.hashDictionary.put("7", "111111");
			this.hashDictionary.put("8", "123123");
			this.hashDictionary.put("9", "1234567890");
			this.hashDictionary.put("10", "1234567");
			this.hashDictionary.put("11", "qwerty123");
			this.hashDictionary.put("12", "000000");
			this.hashDictionary.put("13", "1q2w3e");
			this.hashDictionary.put("14", "aa12345678");
			this.hashDictionary.put("15", "abc123");
			this.hashDictionary.put("16", "password1");
			this.hashDictionary.put("17", "1234");
			this.hashDictionary.put("18", "qwertyuiop");
			this.hashDictionary.put("19", "123321");
			this.hashDictionary.put("20", "password123");
			this.hashDictionary.put("21", "1q2w3e4r5t");
			this.hashDictionary.put("22", "iloveyou");
			this.hashDictionary.put("23", "654321");
			this.hashDictionary.put("24", "666666");
			this.hashDictionary.put("25", "987654321");

			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

				String text;
				while ((text = br.readLine()) != null) {
					String pass = getPasswordHash(text);
					this.hashDictionary.put(text, pass);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		// TODO implement
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// TODO implement
		da.doDictionaryAttack();
	}

}
