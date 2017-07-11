/**
 * 
 */
package fr.epita.crud.services;

import java.util.List;

import fr.epita.crud.datamodel.identity;

/**
 * @author ganesh
 *
 */
public interface IdentityDAO {
	public void save(identity identity);
	public void update(identity identity);
	public void delete(identity identity);
	public List<identity> search(identity identity);
}
