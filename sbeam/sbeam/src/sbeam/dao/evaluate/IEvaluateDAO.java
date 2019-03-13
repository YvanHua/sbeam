package sbeam.dao.evaluate;

import sbeam.po.evaluate.Evaluate;

import java.util.List;

public interface IEvaluateDAO {
    public List findByHql(String hql);
    public void save(Evaluate e);
}
