package sbeam.service.game;

import com.opensymphony.xwork2.ActionContext;
import sbeam.dao.game.GameDAO;
import sbeam.dao.game.IGameDAO;
import sbeam.po.developer.individual.IndividualDeveloper;
import sbeam.po.developer.team.TeamDeveloper;
import sbeam.po.evaluate.Evaluate;
import sbeam.po.game.Game;
import sbeam.po.game.GameType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameService implements IGameService {
    //私有成员依赖项
    private IGameDAO gameDAO;

    //注入私有成员依赖项
    public void setGameDAO(IGameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    //session作用域
    ActionContext ctx;
    Map<String, Object> session;

    //获取上传的游戏
    public void getgames(Integer type){
        ctx = ActionContext.getContext();
        session = (Map) ctx.get("session");
        Integer temid;
        if(type==1){
            temid=((IndividualDeveloper)session.get("indiDeve")).getId();
        }
        else{
            temid=((TeamDeveloper)session.get("teamDeve")).getId();
        }
        String hql = "from Game as game where developerId='"+temid+"' and type='"+(type-1)+"'";
        List games = gameDAO.findByHql(hql);
        session.put("games",games);
    }
    //查找所有游戏
    public List allgames()
    {
        String hql="from Game as game where check ='"+1+"' and ground='"+1+"'";
        return gameDAO.findByHql(hql);
    }
}
