package com.dragon.common.datastructure.graphmap;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * @Description: 图数据结构
 *
 * @author com.machine
 * @date 2017年12月24日 上午9:44:36
*/
@SuppressWarnings("serial")
public class GraphMap implements Serializable{
	private  int vcount = 0;
	private  int ecount = 0;
	private LinkedList<AdjMapList> adjLists = new LinkedList<AdjMapList>();
	
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

	public LinkedList<AdjMapList> getAdjLists() {
		return adjLists;
	}

	public void setAdjLists(LinkedList<AdjMapList> adjLists) {
		this.adjLists = adjLists;
	}

}
