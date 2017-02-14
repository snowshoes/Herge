package com.asnow.controllers;

import com.asnow.dao.BuyerDao;
import com.asnow.models.Buyer;
import com.sun.tools.classfile.ConstantPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A class to test interactions with the MySQL database using the BuyerDao class.
 *
 * @author Shaokun
 */
@Controller
public class BuyerController {


    // ------------------------
    // PRIVATE FIELDS
    // ------------------------
    @Autowired
    private BuyerDao buyerDao;


    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * /create  --> Create a new buyer and save it in the database.
     *
     * @param firstname A buyer's firstname
     * @param lastname A buyer's lastname
     * @return A string describing if the buyer is succesfully created or not.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String firstname, String lastname) {
        Buyer buyer = null;
        Buyer savedBuyer = null;
        try {
            buyer = new Buyer(firstname, lastname);
            savedBuyer = buyerDao.save(buyer);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error Creating " + Buyer.class.getSimpleName() + ": " + e.toString();
        }

        return Buyer.class.getSimpleName() + " Entity " + savedBuyer.getId() +" has been successfully created";


    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            Buyer buyer = new Buyer(id);
            buyerDao.delete(buyer);
        } catch (Exception e) {
            return "Error deleting the user: " + e.toString();
        }
        return "Delete Buyer "+ id +" Successfully";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String getByFirstname(String firstname) {
        String userId = null;

        try {
            Buyer buyer = buyerDao.findByFirstname(firstname);
            userId = String.valueOf(buyer.getId());
        } catch (Exception e) {
            return "Error query Buyer by firstname: " + e.toString();
        }

        return "The Buyer Id is " + userId;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(long id, String firstname, String lastname) {
        try {
            Buyer buyer = buyerDao.findOne(id);
            buyer.setFirstname(firstname);
            buyer.setLastname(lastname);
            buyerDao.save(buyer);
        } catch (Exception e) {
            return "Error while Updating Buyer" + e.toString();
        }
        return "update Buyer successfully";
    }
}
