package sbeam.action.evaluate;

import com.opensymphony.xwork2.ActionContext;
import sbeam.po.customer.Customer;
import sbeam.po.evaluate.Evaluate;
import sbeam.po.game.Game;
import sbeam.service.evaluate.IEvaluateService;

import java.util.List;
import java.util.Map;

public class EvaluateAction {
    private Map session;
    private int gid;
    private double avgmark;
    private Evaluate evaluate;
    private IEvaluateService evaluateService;
    private List evaluatelist;

    public Evaluate getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Evaluate evaluate) {
        this.evaluate = evaluate;
    }

    public IEvaluateService getEvaluateService() {
        return evaluateService;
    }

    public void setEvaluateService(IEvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }
    public String save()
    {
        session= ActionContext.getContext().getSession();
        int tg=(int)session.get("gameid");
        System.out.println(tg);
        Game tgame=evaluateService.findgid((int)session.get("gameid"));
        Customer tcustomer=evaluateService.findcid((int)session.get("cid"));
        evaluate.setGame(tgame);
        evaluate.setCustomer(tcustomer);
        try
        {
            evaluateService.save(evaluate);
        }
        catch(Exception e)
        {
            return "fail";
        }
        return "success";
    }
    public String showevaluate()
    {
        try {
            avgmark = evaluateService.avg(gid);
            evaluatelist = evaluateService.words(gid);
            return "success";
        }
        catch (Exception e)
        {
            return "fail";
        }
    }
    public String toevaluate()
    {
        session= ActionContext.getContext().getSession();
        int uid=(int)session.get("cid");
        session.put("gameid",gid);
        if(evaluateService.evalueated(gid,uid))
            return "success";
        System.out.println(gid);
        return "fail";
    }
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public double getAvgmark() {
        return avgmark;
    }

    public void setAvgmark(double avgmark) {
        this.avgmark = avgmark;
    }

    public List getEvaluatelist() {
        return evaluatelist;
    }

    public void setEvaluatelist(List evaluatelist) {
        this.evaluatelist = evaluatelist;
    }


}
