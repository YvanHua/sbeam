package sbeam.action.order;

import com.opensymphony.xwork2.ActionContext;
import sbeam.po.game.Game;
import sbeam.po.order.Order;
import sbeam.service.order.IOrderService;

import java.util.List;
import java.util.Map;

public class OrderAction {
    private List orderlist;
    private int cid;
    private IOrderService orderService;
    private Game game=new Game();
    private Order od=new Order();
    private  int gid;
    private Map session;

    public OrderAction() {
    }

    public IOrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
    /*查找用户订单*/
    public String findByCid()
    {
        try{
            session = ActionContext.getContext().getSession();
            int t=(int)session.get("cid");
            orderlist=orderService.findAllOrder(t);
            return "success";
        }
        catch (Exception e)
        {
            return "fail";
        }
    }

    public String buy() {
        if(orderService.bought(gid)){
            return "bought";
        }
        od.setGame(orderService.getGame(gid));
        orderService.buy(od);
        System.out.println("gid"+gid);
        orderService.pay(gid);
        System.out.println("buy success");
        return "buySuccess";
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public List getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List orderlist) {
        this.orderlist = orderlist;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Order getOd() {
        return od;
    }

    public void setOd(Order od) {
        this.od = od;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }
}
