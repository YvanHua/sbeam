package sbeam.action.game;

import com.opensymphony.xwork2.ActionContext;
import sbeam.po.customer.Customer;
import sbeam.po.game.Game;
import sbeam.service.game.GameService;
import sbeam.service.game.IGameService;

import java.util.List;
import java.util.Map;

public class GameAction {
    private Map session;
    private List gamelist;
    //依赖项，依赖于service
    private IGameService gameService;
    //注入依赖项
    public void setGameService(IGameService gameService) {
        this.gameService = gameService;
    }

    //私有属性请求者类型
    private Integer type;

    //私有属性的getter与setter方法
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    //获得上传的游戏列表
    public String gamelist(){
        gameService.getgames(type);
        return "gamelist";
    }


    public List getGamelist() {
        return gamelist;
    }

    public void setGamelist(List gamelist) {
        this.gamelist = gamelist;
    }
    /*测试游戏查找*/
    public String findtest()
    {
        try {
            gamelist = gameService.allgames();
            session= ActionContext.getContext().getSession();
            session.put("gamelists",gamelist);
            Customer user = (Customer) session.get("user");
            session.put("userid",user.getId());
        }
        catch (Exception e)
        {
            return "fail";
        }
        return "success";
    }
}
