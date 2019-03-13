package sbeam.action.order;

import sbeam.service.order.IOrderService;

public class Sureaction {
	private IOrderService iorderService;
	private int oid;
	
	public void setIorderService(IOrderService iorderService) {
		this.iorderService = iorderService;
	}
	
	public IOrderService getIorderService() {
		return iorderService;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String sure() {
		iorderService.update1();
		return "buysuccess";
	}
	public String sure1() {
		iorderService.update(oid);
		return "buysuccess";
	}

}
