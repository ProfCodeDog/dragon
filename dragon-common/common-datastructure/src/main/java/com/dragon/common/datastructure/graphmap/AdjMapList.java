package com.dragon.common.datastructure.graphmap;


import com.dragon.common.datastructure.graph.Vertex;

import java.io.Serializable;
import java.util.HashMap;


/**
 * @Description: 邻接表
 *
 * @author com.machine
 * @date 2017年12月26日 上午11:49:22
*/
@SuppressWarnings("serial")
public class AdjMapList  implements Serializable{
	private Vertex vertex;

	private HashMap<Vertex,Object> adjancent = new HashMap<Vertex,Object>();

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public HashMap<Vertex,Object> getAdjancent() {
		return adjancent;
	}

	public void setAdjanceent(HashMap<Vertex,Object> adjancent) {
		this.adjancent = adjancent;
	}
	
}
