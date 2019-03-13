package sbeam.dao.evaluate;

import org.hibernate.query.Query;
import sbeam.dao.BaseHibernateDAO;
import sbeam.po.evaluate.Evaluate;

import java.util.List;

public class EvaluateDAO extends BaseHibernateDAO implements  IEvaluateDAO{
    /*游戏名查询*/
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
    public void save(Evaluate e)
    {
        getSession().save(e);
    }


}
