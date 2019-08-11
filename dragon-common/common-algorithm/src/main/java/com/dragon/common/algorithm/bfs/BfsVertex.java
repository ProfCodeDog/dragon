package com.dragon.common.algorithm.bfs;

import com.dragon.common.datastructure.graph.Vertex;

import java.io.Serializable;

/**
 * @Description:广度优先搜索-- Breadth First Search--[bfs]
 * 
 * @author com.machine
 * @date 2017年12月24日 下午12:07:00
 */
@SuppressWarnings("serial")
public class BfsVertex extends Vertex implements Serializable {

	/* 名字 */
	private String name;

	/* 从开始结点到顶点的跳数统计 */
	private Integer hops = 0;

	public BfsVertex() {
	}

	public BfsVertex(String name) {
		this.name = name;
	}

	public Integer getHops() {
		return hops;
	}

	public void setHops(Integer hops) {
		this.hops = hops;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
