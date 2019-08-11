package com.dragon.common.algorithm.dfs;

import com.dragon.common.datastructure.graph.Vertex;
import com.dragon.common.datastructure.graph.VertexColor;
import com.dragon.common.datastructure.graphset.AdjSetList;
import com.dragon.common.datastructure.graphset.GraphSet;
import com.dragon.common.datastructure.graphset.GraphSetUtil;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:深度优先搜索工具类-- Depth First Search--[dfs]
 *
 * @author com.machine
 * @date 2017年12月24日 下午12:31:33
 */
public class DfsUtil {

	/**
	 * @Description: 拓扑排序(有向无环图)
	 * 
	 *               complexity:O(E+V)--V代表顶点的个数,E代表边的个数
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:52:56
	 */
	public List<DfsVertex> getOrderd(GraphSet graph) {
		if (null == graph) {
			return null;
		}

		/* Initialize all of the vertices in the graph */
		AdjSetList adjList = null;
		DfsVertex dfsVertex = null;
		LinkedList<DfsVertex> ordered = null;

		LinkedList<AdjSetList> adjLists = graph.getAdjLists();
		for (Iterator<AdjSetList> iter = adjLists.iterator(); iter.hasNext();) {
			iter.next().getVertex().setVertexColor(VertexColor.white);
		}

		/* Perform depth-first search */
		ordered = new LinkedList<DfsVertex>();
		for (Iterator<AdjSetList> iter = adjLists.iterator(); iter.hasNext();) {
			dfsVertex = (DfsVertex) iter.next().getVertex();
			if (dfsVertex.getVertexColor() == VertexColor.white) {
				adjList = GraphSetUtil.getInstance().getAdjList(graph, dfsVertex);
				if (null == adjList) {
					return null;
				}
				if (!getOrderd(graph, adjList, ordered)) {
					return null;
				}
			}
		}
		return ordered;
	}

	/**
	 * @Description: 搜索函数(递归)
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午7:49:54
	 */
	private boolean getOrderd(GraphSet graph, AdjSetList adjList, LinkedList<DfsVertex> ordered) {
		AdjSetList clrAdjList = null;
		DfsVertex clrVertex = null;
		DfsVertex adjVertex = null;
		/* Color the vertex gray and traverse its adjacency list */
		adjList.getVertex().setVertexColor(VertexColor.gray);
		for (Vertex iter : adjList.getAdjancent()) {
			adjVertex = (DfsVertex) iter;
			clrAdjList = GraphSetUtil.getInstance().getAdjList(graph, adjVertex);
			if (null == clrAdjList) {
				return Boolean.FALSE;
			}
			clrVertex = (DfsVertex) clrAdjList.getVertex();

			/* Move one vertex deeper when the next adjacent vertex is white */
			if (clrVertex.getVertexColor() == VertexColor.white) {
				if (!getOrderd(graph, clrAdjList, ordered)) {
					return Boolean.FALSE;
				}
			}
		}
		/* Color the current vertex black and make it first in the list */
		adjList.getVertex().setVertexColor(VertexColor.black);
		ordered.add((DfsVertex) adjList.getVertex());
		return Boolean.TRUE;
	}

	/**
	 * @Description: 单例模式
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:23:16
	 */
	public static DfsUtil getInstance() {
		if (BfsUtil == null) {
			synchronized (DfsUtil.class) {
				if (BfsUtil == null) {
					BfsUtil = new DfsUtil();
				}
			}
		}
		return BfsUtil;
	}

	private DfsUtil() {
	}

	private volatile static DfsUtil BfsUtil;
}
