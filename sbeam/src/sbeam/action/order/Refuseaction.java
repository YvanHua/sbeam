package sbeam.action.order;

import sbeam.po.order.Order;
import sbeam.service.order.IOrderService;

public class Refuseaction {
	private IOrderService iorderService;
	private int oid;
	public void setIorderService(IOrderService iorderService) {
		this.iorderService = iorderService;
	}
	
	public IOrderService getIorderService() {
		return iorderService;
	}

	public String refuse() {//取消订单
		Order od=iorderService.getOrder(oid);
		if(iorderService.delet(od)) {
			System.out.println("buy refuse");
			return "buyfail";
		}
		return "refusefail";
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}
}
