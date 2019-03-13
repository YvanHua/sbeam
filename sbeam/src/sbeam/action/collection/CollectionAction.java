package sbeam.action.collection;

import com.opensymphony.xwork2.ActionContext;
import sbeam.po.collection.GameCollection;
import sbeam.po.customer.Customer;
import sbeam.po.game.Game;
import sbeam.service.collection.ICollectionService;

import java.util.Map;
import java.util.List;
public class CollectionAction {
    private Map session;
    private int cid;
    private int gid;
    private GameCollection collection;
    private ICollectionService collectionService;
    /* 保存 */
    private List collectionlist;
    public String save() {
        System.out.println("colletion save");
        session = ActionContext.getContext().getSession();
        int ccid= (int) session.get("userid");
        if (!collectionService.havacollected(gid, ccid)) return "fail";
        else {
            GameCollection tcollection=new GameCollection();
            Game tgame=collectionService.findgid(gid);
            Customer tcustomer=collectionService.findcid(ccid);
            System.out.println(tgame.getId());
            tcollection.setCustomer(tcustomer);
            tcollection.setGame(tgame);
            try {

                collectionService.save(tcollection);
            } catch (Exception e) {
                System.out.println(e);
                return "fail";
                // TODO: handle exception
            }
            return "success";
        }
    }
    public String go()
    {
        System.out.println("go");
        System.out.println(gid);
        return "success";
    }
   public String cancelcollection()
   {
       session = ActionContext.getContext().getSession();
       System.out.println(gid);
       int t=(int)session.get("cid");
       if(collectionService.cancelcollection(gid,t))
           return "success";
       return "fail";
   }
   /*查看我的收藏*/
   public String mycollection()
   {
       session = ActionContext.getContext().getSession();
       int t=(int)session.get("cid");
       collectionlist=collectionService.mycollection(t);
       return "success";
   }



    public ICollectionService getCollectionService() {
        return collectionService;
    }
    public void setCollectionService(ICollectionService collectionService) {
        this.collectionService = collectionService;
    }


    public void setCollection(GameCollection collection) {
        this.collection = collection;
    }
    public GameCollection getCollection()
    {
        return collection;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int cid) {
        this.gid = cid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public List getCollectionlist() {
        return collectionlist;
    }

    public void setCollectionlist(List collectionlist) {
        this.collectionlist = collectionlist;
    }
}
