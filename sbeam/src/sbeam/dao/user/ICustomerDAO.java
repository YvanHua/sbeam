package sbeam.dao.user;

import sbeam.po.customer.Customer;

import java.util.List;

public interface ICustomerDAO {
    void save(Customer customer);//��

    void delete(Customer customer);//ɾ

    void update(Customer customer);//��

    List query(String hql);//��

}

