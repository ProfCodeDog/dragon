package com.dragon.common.algorithm.dfs;


import com.dragon.common.datastructure.graph.Vertex;

import java.io.Serializable;

/**
 * @Description:深度优先搜索-- Depth First Search--[dfs]
 * 
 * @author com.machine
 * @date 2017年12月24日 下午12:07:00
 */
@SuppressWarnings("serial")
public class DfsVertex extends Vertex implements Serializable {

	/* 名字 */
	private String name;

	public DfsVertex() {
	}

	public DfsVertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
