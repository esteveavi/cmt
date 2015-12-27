package org.jboss.as.quickstarts.cmt.ejb;


import java.io.Serializable;

import org.apache.deltaspike.data.api.EntityManagerDelegate;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

import net.jodah.typetools.TypeResolver;

public abstract class BaseRepository<ENTITY> implements CriteriaSupport<ENTITY>, EntityRepository<ENTITY, Long>, EntityManagerDelegate<ENTITY>, Serializable {

	private static final long serialVersionUID = 3929556202713572238L;
	private Class<ENTITY> entityClass;

	@SuppressWarnings("unchecked")
	protected BaseRepository() {
		Class<?>[] typeArguments = TypeResolver.resolveRawArguments(
				BaseRepository.class, getClass());
		this.entityClass = (Class<ENTITY>) typeArguments[0];
	}





	


}