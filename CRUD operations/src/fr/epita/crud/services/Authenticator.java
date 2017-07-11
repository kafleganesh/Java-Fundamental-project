/**
 * 
 */
package fr.epita.crud.services;

/**
 * @author ganesh
 *
 */
public class Authenticator {
	
	/**
	 * This method is checking authentication
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean authenticate(String username, String password){
		
		return "admin".equals(username) && "admin".equals(password);
		
	}

}



