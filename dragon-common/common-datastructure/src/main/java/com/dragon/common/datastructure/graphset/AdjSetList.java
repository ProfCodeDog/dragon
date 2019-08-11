package com.dragon.common.datastructure.graphset;


import com.dragon.common.datastructure.graph.Vertex;

import java.io.Serializable;
import java.util.HashSet;

/**
 * @Description: 邻接表
 *
 * @author com.machine
 * @date 2017年12月26日 上午11:45:30
*/
@SuppressWarnings("serial")
public class AdjSetList  implements Serializable{
	private Vertex vertex;

	private HashSet<Vertex> adjancent = new HashSet<Vertex>();

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public HashSet<Vertex> getAdjancent() {
		return adjancent;
	}

	public void setAdjanceent(HashSet<Vertex> adjancent) {
		this.adjancent = adjancent;
	}
	
}
