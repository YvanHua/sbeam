package sbeam.service.order;

import sbeam.po.game.Game;
import sbeam.po.order.Order;

import java.util.List;

public interface IOrderService {
    public List findAllOrder(int cid);
    public void buy(Order od);
    public void pay(int gid);
    public boolean delet(Order od);
    public Game getGame(int gid);
    public Order getOrder(int oid);
    public boolean refund(Order od);
    public void update(int oid);
    public boolean bought(int gid);
    public void update1();
}
