package sbeam.dao.order;

import org.hibernate.query.Query;
import sbeam.dao.BaseHibernateDAO;
import sbeam.po.order.Order;

import java.util.List;

public class OrderDAO extends BaseHibernateDAO implements IOrderDAO{
    public void save(){}
    public List findAllOrder(int cid)
    {
        String queryString="from Order as o where o.customer.id="+cid+" ";
        try {
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch (Exception e)
       {
        throw e;
       }
    }
    public void buy(Order od){//购买游戏
        try{
            getSession().save(od);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List findByHql(String hql) {
        try {
            String queryString = hql;
            System.out.println(hql);
            Query queryObject=getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public void delet(Order od) { //用户取消订单
        try {
            getSession().delete(od);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public void update(Order od){//更新订单
        try{
            getSession().update(od);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

}
