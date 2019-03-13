package sbeam.service.evaluate;

import sbeam.po.customer.Customer;
import sbeam.po.evaluate.Evaluate;
import sbeam.po.game.Game;

import java.util.List;

public interface IEvaluateService {
    /*保存评价*/
    public void save(Evaluate e);
    /*按条件获取评价*/
    public void findById(int gid);
    /*游戏综合评分*/
    public double avg(int gid);
    /*留言*/
    public List words(int gid);
    /*是否已经评价*/
    public boolean evalueated(int gid, int cid);
    /*找人*/
    public Game findgid(int gid);
    public Customer findcid(int cid);
}
