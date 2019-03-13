package sbeam.service.order;

import com.opensymphony.xwork2.ActionContext;
import sbeam.dao.order.IOrderDAO;
import sbeam.po.customer.Customer;
import sbeam.po.game.Game;
import sbeam.po.order.Order;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderService implements IOrderService{
    /*查询玩家订单*/
    private IOrderDAO orderDAO;
    public List findAllOrder(int cid)
    {
        try{
        return orderDAO.findAllOrder(cid);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public OrderService(){
        System.out.println("create orderService.");
    }
    public void setIorderDAO(IOrderDAO orderDAO) {
        System.out.println("--setIorderDAO--");
        this.orderDAO = orderDAO;
    }
    public void buy(Order od) {//下单
        System.out.println("execute --buy()-- method.");
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        System.out.println("Orderaction buy");
        Customer customer=(Customer) session.get("user");
        od.setCustomer(customer);
        od.setState(0);
        Date date=new Date();
        od.setDate(date);//获取系统时间
        orderDAO.buy(od);
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        session.put("order", od);

    }

    public void update(int oid){
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        System.out.println("Orderaction update");
        //Order od=(Order) session.get("order");
        Order od = getOrder(oid);
        od.setState(2);
        orderDAO.update(od);
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        session.put("order", od);
    }

    public void update1(){
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        System.out.println("Orderaction update1");
        Order od=(Order) session.get("order");
        od.setState(2);
        orderDAO.update(od);
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        session.put("order", od);
    }

    public Game getGame(int gid){
        String hql = "from Game as game where id=" + gid +"";
        List list = orderDAO.findByHql(hql);
        return (Game)list.get(0);
    }

    public Order getOrder(int oid){
        String hql = "from Order as order where id=" + oid +"";
        List list = orderDAO.findByHql(hql);
        return (Order) list.get(0);
    }

    public void pay(int gid) {//所需金额
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        Order od=(Order) session.get("order");
        Game game=getGame(gid);
        od.setPay(game.getMallPrice());
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        session.put("order", od);
    }
    public boolean delet(Order od) {//取消订单
        String hql = "from Order as order where id='" + od.getId()+"'";
        List list = orderDAO.findByHql(hql);
        if (list.isEmpty()) {
            return false;
        }
        else {
            od = (Order) list.get(0);
            orderDAO.delet(od);
            return true;
        }
    }

    public boolean refund(Order od) {//退款
        String hql = "from Order as order where id='" + od.getId()+"'";
        List list = orderDAO.findByHql(hql);
        if (list.isEmpty()) {
            return false;
        }
        else {
            od = (Order) list.get(0);
            Calendar cal = Calendar.getInstance();
            cal.setTime(od.getDate());
            Date date = new Date();//系统时间
            Date d1 = cal.getTime();
            cal.setTime(date);
            Date d2 = cal.getTime();
            long daterange = d2.getTime() - d1.getTime();
            long time = 1000 * 3600 * 24l;
            long day = daterange / time;
            if (day <= 1){//超过一天不得退款
                od.setState(1);
                orderDAO.update(od);
                return true;
            }
            return false;
        }
    }

    public boolean bought(int gid){
        Map<String, Object> session = (Map) ActionContext.getContext().getSession();
        Customer customer=(Customer) session.get("user");
        String hql = "from Order as order where gid='" + gid +"' and  cid='"+customer.getId()+"'";
        List list = orderDAO.findByHql(hql);
        if (list.isEmpty())
            return false;
        else if(((Order)list.get(list.size()-1)).getState()==1 || ((Order)list.get(list.size()-1)).getState()==null) {
            return false;
        }
        else{
            return true;
        }
    }

    public IOrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
