package sbeam.dao.user;

import sbeam.dao.BaseHibernateDAO;
import sbeam.po.customer.Customer;

import java.util.List;

public class CustomerDAO extends BaseHibernateDAO
        implements ICustomerDAO {

    public void save(Customer customer) {
        getSession().save(customer);
    }

    public void delete(Customer customer) {
        getSession().delete(customer);
    }

    public void update(Customer customer) {
        getSession().update(customer);
    }
    public List query(String hql) {
        return getSession().createQuery(hql).list();
    }
}

