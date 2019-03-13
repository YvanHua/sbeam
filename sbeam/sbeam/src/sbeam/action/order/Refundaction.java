package sbeam.action.order;

import sbeam.po.order.Order;
import sbeam.service.order.IOrderService;

public class Refundaction {
    private IOrderService iorderService;
    private Order od=new Order();
    private int oid;
    public void setIorderService(IOrderService iorderService) {
        this.iorderService = iorderService;
    }

    public IOrderService getIorderService() {
        return iorderService;
    }
    public  String refund(){
     od=iorderService.getOrder(oid);
     if(iorderService.refund(od))
     return "refundSuccess";
     return "refundFail";
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getOid() {
        return oid;
    }

}
