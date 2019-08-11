package com.dragon.common.datastructure.graphset;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @Description: 图数据结构
 *
 * @author com.machine
 * @date 2017年12月24日 上午9:44:36
*/
@SuppressWarnings("serial")
public class GraphSet implements Serializable{
	private  int vcount = 0;
	private  int ecount = 0;
	private LinkedList<AdjSetList> adjLists = new LinkedList<AdjSetList>();
	
	public int getVcount() {
		return vcount;
	}

	public void setVcount(int vcount) {
		this.vcount = vcount;
	}

	public int getEcount() {
		return ecount;
	}

	public void setEcount(int ecount) {
		this.ecount = ecount;
	}

	public LinkedList<AdjSetList> getAdjLists() {
		return adjLists;
	}

	public void setAdjLists(LinkedList<AdjSetList> adjLists) {
		this.adjLists = adjLists;
	}

}
