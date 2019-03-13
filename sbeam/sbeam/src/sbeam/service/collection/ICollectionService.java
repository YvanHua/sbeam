package sbeam.service.collection;

import sbeam.po.collection.GameCollection;
import sbeam.po.customer.Customer;
import sbeam.po.game.Game;

import java.util.List;

public interface ICollectionService {
    void save(GameCollection collection);
    /*查询个人收藏*/
    public List mycollection(int cid);
    public Game findgid(int gid);
    public Customer findcid(int cid);
    public boolean havacollected(int gid, int cid);
    public boolean cancelcollection(int gid, int cid);
}