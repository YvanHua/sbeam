package sbeam.dao.collection;

import org.hibernate.query.Query;
import sbeam.dao.BaseHibernateDAO;
import sbeam.po.collection.GameCollection;

import java.util.List;

public class CollectionDAO extends BaseHibernateDAO implements ICollectionDAO {
    public void save(GameCollection collection)
    {
        System.out.println("333");
        getSession().save(collection);
        System.out.println("444");
    }
    public List findByHql(String hql){
        try {
            String queryString = hql;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
    public void delete(GameCollection collection)
    {
        getSession().delete(collection);
    }


}