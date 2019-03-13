package sbeam.service.evaluate;

import com.opensymphony.xwork2.ActionContext;
import sbeam.dao.evaluate.IEvaluateDAO;
import sbeam.po.customer.Customer;
import sbeam.po.evaluate.Evaluate;
import sbeam.po.game.Game;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class EvaluateService implements IEvaluateService{
    ActionContext ctx;
    Map<String, Object> session;
    /*EvaluateDAO注入5*/
    private IEvaluateDAO evaluateDAO;
    public IEvaluateDAO getEvaluateDAO() {
        return evaluateDAO;
    }

    public void setEvaluateDAO(IEvaluateDAO evaluateDAO) {
        this.evaluateDAO = evaluateDAO;
    }
    public void save(Evaluate e)
    {
        evaluateDAO.save(e);
    }
    public void findById(int gid)
    {
        ctx = ActionContext.getContext();
        session = (Map) ctx.get("session");
        try{
            String hql = "from Evaluate as e where gid="+gid+" ";
            List evaluates = evaluateDAO.findByHql(hql);
            session.put("evaluates",evaluates);
        }
        catch (Exception e){
            session.put("evaluates",null);
        }

    }
    /*游戏均分*/
    public double avg(int gid)
    {
        String hql="select avg(star) from Evaluate where game.id="+gid+" ";
        List e=evaluateDAO.findByHql(hql);
        double avemark=Double.parseDouble(e.get(0).toString());
        return avemark;
    }
    public List words(int gid)
    {
        String hql="from Evaluate where game.id="+gid+" ";
        return evaluateDAO.findByHql(hql);
    }
    public boolean evalueated(int gid,int cid)
    {
        String hql="from Evaluate where gid="+gid+"and cid="+cid+" ";
        List t=evaluateDAO.findByHql(hql);
        try{if(t.size()==0)return true;}
        catch(Exception e)
        {return false;}
        return false;
    }
    public Game findgid(int gid)
    {
        String hql="from Game where id="+gid+" ";
        List t=evaluateDAO.findByHql(hql);
        return (Game)(t.get(0));
    }
    public Customer findcid(int cid)
    {
        String hql="from Customer  where id="+cid+" ";
        List t=evaluateDAO.findByHql(hql);
        return (Customer)(t.get(0));
    }

}
