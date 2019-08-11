package com.dragon.common.datastructure.graph;

import java.io.Serializable;

/**
 * @Description: 点
 *
 * @author com.machine
 * @date 2017年12月24日 下午12:02:37
 */
@SuppressWarnings("serial")
public abstract class Vertex implements Serializable {
	private VertexColor vertexColor;

	public VertexColor getVertexColor() {
		return vertexColor;
	}

	public void setVertexColor(VertexColor vertexColor) {
		this.vertexColor = vertexColor;
	}
}
