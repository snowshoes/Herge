package com.asnow.dao;

import com.asnow.models.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A DAO for the entity User is simply created by extending the CrudRepository
 * interface provided by spring. The following methods are some of the ones
 * available from such interface: save, delete, deleteAll, findOne and findAll.
 * The magic is that such methods must not be implemented, and moreover it is
 * possible create new query methods working only by defining their signature!
 *
 * @author Shaokun
 */
@Transactional
public interface BuyerDao extends CrudRepository<Buyer, Long> {
    /**
     * Return the buyer having the firstname or null if no buyer is found.
     *
     * @param firstname buyer's firstname
     */
    public Buyer findByFirstname(String firstname);
}
