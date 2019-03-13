package sbeam.dao.game;

import sbeam.po.game.Game;

import java.util.List;

public interface IGameDAO {
    //根据ID获取游戏
    public Game get(Integer id);
    //根据hql语句进行查询
    public List findByHql(String hql);
}
