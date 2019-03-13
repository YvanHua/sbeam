package sbeam.dao.game;

import org.hibernate.query.Query;
import sbeam.dao.BaseHibernateDAO;
import sbeam.po.game.Game;

import java.util.List;

public class GameDAO extends BaseHibernateDAO implements IGameDAO{
    //根据ID获取游戏
    public Game get(Integer id){
        try{
            System.out.println("开始DAO");
            return getSession().get(Game.class,id);
        }
        catch (Exception e){
            throw e;
        }
    }

    //根据hql语句进行查询
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
}
