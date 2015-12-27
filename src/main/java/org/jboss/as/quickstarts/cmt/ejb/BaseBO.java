/**
 *
 */
package org.jboss.as.quickstarts.cmt.ejb;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.deltaspike.core.api.literal.ApplicationScopedLiteral;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import net.jodah.typetools.TypeResolver;

/**
 * Base class for all BO Services. Contains the generic CRUD methods for the entities
 * to which they serve.
 *
 * @author upe00196
 */
public abstract class BaseBO<ENTITY> {

    @PersistenceContext
    private EntityManager entityManager;

	private Class<ENTITY> entityClass;

	private Class<?> repositoryClass;
	

	@SuppressWarnings("unchecked")
	protected BaseBO() {
	
			Class<?>[] typeArguments = TypeResolver.resolveRawArguments(
					BaseBO.class, getClass());
			this.entityClass = (Class<ENTITY>) typeArguments[0];
			try {
				repositoryClass = Class.forName(buildRepositoryClassName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	@SuppressWarnings("unchecked")
	protected BaseRepository<ENTITY> getBaseRepository() {
		System.out.println("RespositoyClassName: "+ repositoryClass);
		return (BaseRepository<ENTITY>) BeanProvider.getContextualReference(repositoryClass, false);
	}

	/**
	 * Retrieves an entity by it's identifier.
	 *
	 * @param id
	 * @return
	 */

	public ENTITY retrieveById(final Long id) {
		return getBaseRepository().findBy(id);
	}
	/**
	 * Using ENTITY name + REPOSITORY_SUFIX, gets the name
	 * for Repository Entity Class
	 *
	 * @return
	 */
	private String buildRepositoryClassName() {
		return new StringBuilder
				(entityClass.getName())
				.append("Repository").toString();
	}
	
	public List<ENTITY> findAllEntities() {
		return getBaseRepository().findAll();
	}
	
	public ENTITY save(final ENTITY entity) {
		ENTITY createdEntity = getBaseRepository().save(entity);

		return createdEntity;
	}
	
}
