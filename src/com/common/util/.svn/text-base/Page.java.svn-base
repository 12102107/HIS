package com.common.util;

import java.util.ArrayList;
import java.util.List;




@SuppressWarnings("serial")
public class Page implements java.io.Serializable {
	public static final int PAGE_SIZE=25;

	private int pageSize = PAGE_SIZE;
   
    private int start;
   
    @SuppressWarnings("unused")
	private int avaCount;
  
    private int totalCount;
   
    private List data;
    

   
    public Page() {
        this(0, 0, 0, PAGE_SIZE, new ArrayList());
    }

 
    public Page(int start, int avaCount, int totalSize, int pageSize, List data) {
    	this.pageSize = pageSize;
        this.start = start;
        this.totalCount = totalSize;
        this.data = data;
    }

   

    public int getTotalCount() {
        return this.totalCount;
    }

  
    public int getTotalPageCount() {
        if (totalCount % pageSize == 0)
            return totalCount / pageSize;
        else
            return totalCount / pageSize + 1;
    }

    public int getPageSize() {
        return pageSize;
    }

   
//    public Object getResult() {
//        return data;
//    }

   
    public int getCurrentPageNo() {
        return (start / pageSize) + 1;
    }

   
    public boolean hasNextPage() {
        return (this.getCurrentPageNo() < this.getTotalPageCount() - 1);
    }

   
    public boolean hasPreviousPage() {
        return (this.getCurrentPageNo() > 1);
    }

    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, PAGE_SIZE);
    }

    
    protected static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
    
   
    public static int getStartOfAnyPage(int pageNo, int pageSize) {
        int startIndex = (pageNo - 1) * pageSize + 1;
        if (startIndex < 1) startIndex = 1;
        return startIndex;
    }
   
    
    public boolean getFirstPage()
    {
    	 return (this.getCurrentPageNo() ==1);
    }
    
    public boolean getPreviousPage()
    {
    	return (this.getCurrentPageNo() > 1);
    }
    
    public boolean getNextPage()
    {
    	return (this.getCurrentPageNo() < this.getTotalPageCount());
    }
    
    public boolean getLastPage()
    {
    	 return (this.getCurrentPageNo() == this.getTotalPageCount());
    }

	public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }


    public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}
	
}

