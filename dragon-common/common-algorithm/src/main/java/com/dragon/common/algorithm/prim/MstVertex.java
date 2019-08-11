package com.dragon.common.algorithm.prim;

import com.dragon.common.datastructure.graph.Vertex;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description: 最小生成树
 * 
 * @author com.machine
 * @date 2017年12月25日 下午5:40:28
 */
@SuppressWarnings("serial")
public class MstVertex extends Vertex implements Serializable {

	/* 名字 */
	private String name;

	/* 顶点的键值 */
	private BigDecimal key;

	/* 顶点的父节点 */
	private MstVertex parent;

	public MstVertex() {
	}

	public MstVertex(String name) {
		this.name = name;
	}

	public BigDecimal getKey() {
		return key;
	}

	public void setKey(BigDecimal key) {
		this.key = key;
	}

	public MstVertex getParent() {
		return parent;
	}

	public void setParent(MstVertex parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
