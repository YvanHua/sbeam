package sbeam.dao.collection;

import sbeam.po.collection.GameCollection;

import java.util.List;

public interface ICollectionDAO {
    void save(GameCollection collection);
    public List findByHql(String hql);
    public void delete(GameCollection collection);
}
