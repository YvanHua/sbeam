package sbeam.service.collection;

import sbeam.dao.collection.ICollectionDAO;
import sbeam.po.collection.GameCollection;
import sbeam.po.customer.Customer;
import sbeam.po.evaluate.Evaluate;
import sbeam.po.game.Game;

import java.util.List;

public class CollectionService implements ICollectionService{
    private ICollectionDAO collectionDAO;

    public ICollectionDAO getCollectionDAO() {
        return collectionDAO;
    }

    public void setCollectionDAO(ICollectionDAO collectionDAO) {
        this.collectionDAO = collectionDAO;
    }

    /*淇濆瓨璁㈠崟*/
    public void save(GameCollection collection)
    {

        collectionDAO.save(collection);
    }

    public List mycollection(int cid)
    {
        String hql="from GameCollection where customer.id="+cid+" ";
        return collectionDAO.findByHql(hql);
    }
    public Game findgid(int gid)
    {
        String hql="from Game where id="+gid+" ";
        List t=collectionDAO.findByHql(hql);
        return (Game)(t.get(0));
    }
    public Customer findcid(int cid)
    {
        String hql="from Customer  where id="+cid+" ";
        List t=collectionDAO.findByHql(hql);
        return (Customer)(t.get(0));
    }

    public boolean havacollected(int gid, int cid) {
        String hql="from GameCollection where game.id="+gid+"and customer.id="+cid+" ";
        List t=collectionDAO.findByHql(hql);
        try{if(((GameCollection)t.get(0)).getCustomer().getId()!=cid)return true;}
        catch(Exception e)
        {return true;}
        return false;
    }
   /*删除收藏*/
   public boolean cancelcollection(int gid,int cid)
   {
       String hql="from GameCollection where game.id="+gid+"and customer.id="+cid+" ";
       try
       {
           GameCollection t=(GameCollection)(collectionDAO.findByHql(hql).get(0));
           collectionDAO.delete(t);
           return true;
       }
       catch (Exception e)
       {
           return false;
       }
   }

}
