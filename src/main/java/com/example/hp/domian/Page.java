package com.example.hp.domian;

public class Page {
	private int totalAmount;
	private int size;
	private int crrentPage;
	private int pageAmount;
	private int start;
	public Page(int totalAmount, int size, int crrentPage) {
		this.totalAmount = totalAmount;
		this.size = size;
		this.crrentPage = crrentPage;
	}
	public Page() {
		super();
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCrrentPage() {
		return crrentPage;
	}
	public void setCrrentPage(int crrentPage) {
		this.crrentPage = crrentPage;
	}
	public int getPageAmount() {
		return totalAmount%size==0?totalAmount/size:totalAmount/size+1;
	}
	public void setPageAmount(int pageAmount) {
		this.pageAmount = pageAmount;
	}
	public int getStart() {
		return (crrentPage-1)*size;
	}
	public void setStart(int start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "Page [totalAmount=" + totalAmount + ", size=" + size + ", crrentPage=" + crrentPage + ", pageAmount="
				+ pageAmount + ", start=" + start + "]";
	}
    
	
	
}
