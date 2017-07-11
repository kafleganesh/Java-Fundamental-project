/**
 * 
 */
package fr.epita.crud.launcher;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import fr.epita.crud.datamodel.identity;
import fr.epita.crud.services.Authenticator;
import fr.epita.crud.services.DaoInitializationException;
import fr.epita.crud.services.IdentityJDBCDAO;
/**
 * @author ganesh
 *
 */
public class launcher {
	/**
	 * @param args
	 * @throws DaoInitializationException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws DaoInitializationException, SQLException 
	{
		System.out.println("Welcome to the identity Manupulation system ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your username");
		String username = scanner.nextLine();
		System.out.println("Enter your password");
		String password = scanner.nextLine();
				
// check user name and email for four time				
			for (int i=0; i<=4; i++){
				if(Authenticator.authenticate(username, password)== false){
					System.out.println("incorrect username or password");
					System.out.println("enter your username");
					username = scanner.nextLine();
					System.out.println("enter your password");
					password = scanner.nextLine();
					if( i==2){
						System.out.println("sorry you have forgetten your user name or password");
				}
					}
			else
			{			
				System.out.println(" select the operation you want");
				System.out.println(" 1. Identity creation");
				System.out.println(" 2. List identity");
				System.out.println(" 3. Update identity");
				System.out.println(" 4. Delete identity");
				System.out.println(" 5. Exit");					
				String choice = scanner.nextLine();
				
//Execution takes place according to choice
		switch(choice){		
		case "1" :
			System.out.println("You have selected identy creation");
			System.out.println("Enter the uid of user");
			String identity_id = scanner.nextLine();
			System.out.println("Enter the idenenty disply name");
			String displayname = scanner.nextLine();
			System.out.println("Enter the email of identity");
			String email = scanner.nextLine();
			
			identity ident = new identity(identity_id, displayname,email);
			IdentityJDBCDAO ij = new IdentityJDBCDAO();
			ij.write(ident);			
			break;
			
		case "2":
			System.out.println("you have selected identity list");			
			ListIdentity();						
			break;
			
		case "3":
			System.out.println("you have selected identity update");
			System.out.println("Enter the id you want to update");
			String idtoupdate = scanner.nextLine();
			System.out.println("Enter the name you want to change");
			String nametochange = scanner.nextLine();
			System.out.println("enter the new mail");
			String emailtochange = scanner.nextLine();
			identity identupdate = new identity(idtoupdate ,nametochange,emailtochange);
			IdentityJDBCDAO ijupdate = new IdentityJDBCDAO();
			ijupdate.update(identupdate);
			System.out.println("Successfully updated identities");
			break;
		
		case "4":
			System.out.println("you have selected identity deletion");
			System.out.println("Enter the identity id you want to delete");
			String idtodelete = scanner.nextLine();
			identity identdelete = new identity(idtodelete,null , null);
			IdentityJDBCDAO ijdelete = new IdentityJDBCDAO();
			ijdelete.delete(identdelete);
			System.out.println("You have sucessfully deleted an identity");			
			break;
			
		case "5":
			System.out.println("Thanks for using Identity Management system");
			break;
		case "6":
			//search
			
			System.out.println("enter the id for which you want to search");
			String idtosearch = scanner.nextLine();
			identity identsearch = new identity( null, null, idtosearch);
			IdentityJDBCDAO ijsearch = new IdentityJDBCDAO();
			ijsearch.search(identsearch);
			System.out.println("Details of the searched entity identities");
			
			break;
		default:
			System.out.println("unrecoznized option: seletion is allowed from 1 to 5 only");
			
		}
			}
				}
				}
	
// function body of method that is listed in case2
	public static void ListIdentity() throws SQLException, DaoInitializationException {
		System.out.println("Identity Listing");
		IdentityJDBCDAO identityWriter = new IdentityJDBCDAO();

		List<identity> allIdentities = identityWriter.readAllIdentities();
		//System.out.println(allIdentities);
		for (identity iden : allIdentities) {
		    System.out.println(iden.getIdentity_id()+"--"+iden.getDisplayname()+"--"+ iden.getEmail());
		}

		System.out.println(" Succesfully you have listed the identities");

	}

	}



	

