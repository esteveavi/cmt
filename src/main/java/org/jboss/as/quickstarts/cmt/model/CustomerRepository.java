package org.jboss.as.quickstarts.cmt.model;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.data.api.Repository;
import org.jboss.as.quickstarts.cmt.ejb.BaseRepository;



@Repository
@ApplicationScoped
public abstract class CustomerRepository extends BaseRepository<Customer> {
	

	private static final long serialVersionUID = 5916817348675869573L;


}
