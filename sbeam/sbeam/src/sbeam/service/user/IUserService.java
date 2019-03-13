package sbeam.service.user;

import sbeam.po.customer.Customer;

public interface IUserService {
    boolean login(Customer customer);

    boolean register(Customer customer);

    boolean update(Customer customer);

}

