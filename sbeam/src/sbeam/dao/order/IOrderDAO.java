package sbeam.dao.order;

import sbeam.po.order.Order;

import java.util.List;

public interface IOrderDAO {
    /*存储订单*/
    public void save();
    /*查看用户所有订单*/
    public List findAllOrder(int cid);
    public void buy(Order od);
    public List findByHql(String hql);
    public void delet(Order od);
    public void update(Order od);

}
