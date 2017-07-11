/**
 * 
 */
package fr.epita.crud.datamodel;

/**
 * @author ganesh
 *
 */
public class identity {
	String displayname;
	String uid;
	String email;
	String  identity_id;
	
	public String getDisplayname() {
		return displayname;
	}
	/**
	 * @param displayname
	 * @param email
	 * @param identity_id
	 */
	public identity(String identity_id, String displayname, String email) {
		super();
		this.displayname = displayname;
		this.email = email;
		this.identity_id = identity_id;
	}
	/**
	 * @param displayname the displayname to set
	 */
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	/**
	 * @return the uid
	 */
	
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the identity_id
	 */
	public String getIdentity_id() {
		return identity_id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
