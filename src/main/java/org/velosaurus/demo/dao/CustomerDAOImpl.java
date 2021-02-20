package org.velosaurus.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.velosaurus.demo.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory;

    // can be injected (is autowired) because bean defined in config class
    @Autowired
    public void CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    /**
     * "@Transactional" is moved to service-layer ("CustomerServiceImpl")
     *
     * @return Customer
     */
    @Override
    public List<Customer> getCustomers() {

        // get current Hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        // get customer list from query by executing it
        @SuppressWarnings("UnnecessaryLocalVariable")
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }


    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, id);
    }


    /**
     * saveOrUpdate identifies if to use "update" or "save", based on existence of id
     */
    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query =
                currentSession.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();
    }

}
