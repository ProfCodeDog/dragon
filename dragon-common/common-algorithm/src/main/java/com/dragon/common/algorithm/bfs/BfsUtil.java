package com.dragon.common.algorithm.bfs;

import com.dragon.common.datastructure.graph.Vertex;
import com.dragon.common.datastructure.graph.VertexColor;
import com.dragon.common.datastructure.graphset.AdjSetList;
import com.dragon.common.datastructure.graphset.GraphSet;
import com.dragon.common.datastructure.graphset.GraphSetUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:广度优先搜索工具类-- Breadth First Search--[bfs]
 *
 * @author com.machine
 * @date 2017年12月24日 下午12:31:33
 */
public class BfsUtil {

	/**
	 * @Description: 一个节点到其节点跳转的次数
	 * 
	 *               complexity:O(E+V)--V代表顶点的个数,E代表边的个数
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:52:56
	 */
	public List<BfsVertex> getHops(GraphSet graph, BfsVertex startVertex) {
		if (null == graph || null == startVertex) {
			return null;
		}
		/* Initialize all of the vertices in the graph */
		AdjSetList adjList = null;
		AdjSetList clrAdjList = null;
		LinkedList<AdjSetList> queue = null;
		BfsVertex clrBfsVertex = null;
		BfsVertex adjBfsVertex = null;

		LinkedList<AdjSetList> adjLists = graph.getAdjLists();

		for (Iterator<AdjSetList> iter = adjLists.iterator(); iter.hasNext();) {
			adjList = iter.next();
			clrBfsVertex = (BfsVertex) adjList.getVertex();
			if (clrBfsVertex.equals(startVertex)) {
				/* Initialize the start vertex */
				clrBfsVertex.setVertexColor(VertexColor.gray);
				clrBfsVertex.setHops(0);
			} else {
				/* Initialize vertices other than the start vertex */
				clrBfsVertex.setVertexColor(VertexColor.white);
				clrBfsVertex.setHops(-1);
			}
		}

		/* Initialize the queue with the adjacency list of the start vertex */
		queue = new LinkedList<AdjSetList>();
		AdjSetList startVertexAdjList = GraphSetUtil.getInstance().getAdjList(graph, startVertex);
		if (null == startVertexAdjList) {
			return null;
		}
		queue.add(startVertexAdjList);

		/* Perform breadth-first search */
 		while (queue.size() > 0) {
			adjList = queue.getFirst();
			/* Traverse each vertex in the current adjacency list */
			for (Vertex vertex : adjList.getAdjancent()) {
				adjBfsVertex = (BfsVertex) vertex;
				/* Determine the color of the next adjacent vertex */
				clrAdjList = GraphSetUtil.getInstance().getAdjList(graph, adjBfsVertex);
				if (null == clrAdjList) {
					return null;
				}
				clrBfsVertex = (BfsVertex) clrAdjList.getVertex();
				/*
				 * Color each white vertex gray and enqueue its adjacency list
				 */
				if (clrBfsVertex.getVertexColor() == VertexColor.white) {
					clrBfsVertex.setVertexColor(VertexColor.gray);
					clrBfsVertex.setHops(((BfsVertex)adjList.getVertex()).getHops() + 1);
					queue.add(clrAdjList);
				}
			}

			/* Dequeue the current adjacency list and color its vertex black */
			queue.removeFirst().getVertex().setVertexColor(VertexColor.black);
		}

		List<BfsVertex> hops = new ArrayList<BfsVertex>(graph.getAdjLists().size());
		for (AdjSetList tempAdjList : graph.getAdjLists()) {
			hops.add((BfsVertex) tempAdjList.getVertex());
		}
		return hops;
	}

	/**
	 * @Description: 单例模式
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:23:16
	 */
	public static BfsUtil getInstance() {
		if (bfsUtil == null) {
			synchronized (BfsUtil.class) {
				if (bfsUtil == null) {
					bfsUtil = new BfsUtil();
				}
			}
		}
		return bfsUtil;
	}

	private BfsUtil() {
	}

	private volatile static BfsUtil bfsUtil;
}
