package sbeam.service.user;

import com.opensymphony.xwork2.ActionContext;
import sbeam.dao.user.ICustomerDAO;
import sbeam.po.customer.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService implements IUserService {
    private ICustomerDAO customerDAO;
    private Map<String, Object> session = new HashMap<>();

    /*登录*/
    public boolean login(Customer customer) {
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        if(customer.getId()==null)
            return false;
        String hql = "from Customer as user where id='" + customer.getId() + "' and password='" + customer.getPassword() + "'";
        List list = customerDAO.query(hql);
        if (list.isEmpty()) {
            return false;
        }
        else {
            customer = (Customer) list.get(0);
            ActionContext context = ActionContext.getContext();
            session = context.getSession();
            session.put("user", customer);
            session.put("type",0);
            session.put("cid",customer.getId());
            return true;
        }
    }

    /* 注册 */
    public boolean register(Customer customer) {
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        if(customer.getId()==null||customer.getPassword().isEmpty())
            return false;
        String hql = "from Customer where id=" + customer.getId();
        if (!customerDAO.query(hql).isEmpty()) {
            return false;
        }
        customerDAO.save(customer);
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        session.put("user", customer);
        session.put("type",0);
        session.put("cid",customer.getId());
        return true;
    }

    /* 更新用户信息 */
    public boolean update(Customer customer) {
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        Customer c=(Customer) session.get("user");
        customer.setId(c.getId());
        if(customer.getPassword().isEmpty())
            return false;
        customerDAO.update(customer);
        setSession(customer);
        return true;
    }


    /* tool method */
    private void setSession(Customer customer) {
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        session.put("user", customer);
        session.put("userId", customer.getId());
        session.put("type", 0);

    }

    private Customer getCustomerById(Integer id) {
        String hql = "from Customer where id=" + id;
        return (Customer) customerDAO.query(hql).get(0);
    }


    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


}

