package com.dragon.common.datastructure.graphmap;

import com.dragon.common.datastructure.graph.Vertex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Description: 图 工具类
 *
 * @author com.machine
 * @date 2017年12月24日 上午9:30:59
 */
public class GraphMapUtil {

	/**
	 * @Description: 将定点插入graph指定的图中
	 * 
	 *               complexity:O(V)--V代表顶点的个数
	 *
	 * @author com.machine
	 * @date 2017年12月23日 上午11:33:43
	 */
	public boolean insVertex(GraphMap graph, Vertex vertex) {
		if (null == graph || null == vertex) {
			return Boolean.FALSE;
		}
		LinkedList<AdjMapList> adjLists = graph.getAdjLists();
		/* Do not allow the insertion of duplicate vertices */
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			if (vertex.equals(iter.next().getVertex())) {
				return Boolean.TRUE;
			}
		}
		/* Insert the vertex */
		AdjMapList newAdjList = new AdjMapList();
		newAdjList.setVertex(vertex);
		newAdjList.setAdjanceent(new HashMap<Vertex,Object>());
		adjLists.addLast(newAdjList);

		/* Adjust the vertex count to account for the inserted vertex */
		graph.setVcount(graph.getVcount() + 1);
		return Boolean.TRUE;
	}

	/**
	 * @Description: 将定点vertexStart和定点vertexEnd构成的边插入graph指定的图中
	 *               [vertexStart和vertexEnd必须是已经插入图中的顶点]
	 * 
	 *               complexity:O(V)--V代表顶点的个数
	 *
	 * @author com.machine
	 * @date 2017年12月23日 上午11:33:43
	 */
	public boolean insEdge(GraphMap graph, Vertex vertexStart, Vertex vertexEnd,Object edgeObject) {
		if (null == graph || null == vertexStart || null == vertexEnd) {
			return Boolean.FALSE;
		}
		if (vertexStart.equals(vertexEnd)) {
			return Boolean.FALSE;
		}
		LinkedList<AdjMapList> adjLists = graph.getAdjLists();
		/*
		 * Do not allow the insertion of an edge without both its vertices in
		 * the graph
		 */
		boolean isIncludeVertex = Boolean.FALSE;
		AdjMapList startVettexAdjList = null;
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			startVettexAdjList = iter.next();
			if (vertexStart.equals(startVettexAdjList.getVertex())) {
				isIncludeVertex = Boolean.TRUE;
				break;
			}
		}
		if (!isIncludeVertex) {
			return Boolean.FALSE;
		}
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			if (vertexEnd.equals(iter.next().getVertex())) {
				isIncludeVertex = Boolean.TRUE;
				break;
			}
		}
		if (!isIncludeVertex) {
			return Boolean.FALSE;
		}

		/*
		 * Insert the second vertex into the adjacency list of the first vertex
		 */
		startVettexAdjList.getAdjancent().put(vertexEnd, edgeObject);
		return Boolean.TRUE;
	}

	/**
	 * @Description: 从graph指定的图中移除与vertex相匹配的顶点 [调用该方法之前,所有与该顶点相关的边必须移除]
	 * 
	 *               complexity:O(V+E)--V代表顶点的个数,E代表边的个数
	 *
	 * @author com.machine
	 * @date 2017年12月23日 上午11:33:43
	 */
	public boolean remVertex(GraphMap graph, Vertex vertex) {
		if (null == graph || null == vertex) {
			return Boolean.FALSE;
		}
		LinkedList<AdjMapList> adjLists = graph.getAdjLists();
		/* Traverse each adjacency list and the vertices it contains */
		boolean found = Boolean.FALSE;
		AdjMapList vertexAdjList = null;
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			vertexAdjList = iter.next();
			/*
			 * Do not allow removal of the vertex if it is in an adjacency list
			 */
			if (vertexAdjList.getAdjancent().containsKey((vertex))) {
				return Boolean.FALSE;
			}

			/* Keep a pointer to the vertex to be removed */
			if (vertex.equals(vertexAdjList.getVertex())) {
				found = Boolean.TRUE;
				break;
			}
		}

		/* Return if the vertex was found */
		if (!found) {
			return Boolean.FALSE;
		}
		/*
		 * Do not allow removal of the vertex if its adjacency list is not empty
		 */
		if (vertexAdjList.getAdjancent().size() > 0) {
			return Boolean.FALSE;
		}

		/* Remove the vertex */
		boolean isRemoved = adjLists.remove(vertexAdjList);
		if (!isRemoved) {
			return Boolean.FALSE;
		}
		graph.setVcount(graph.getVcount() - 1);
		return Boolean.TRUE;
	}

	/**
	 * @Description: 从graph指定的图中移除与vertexStart到vertexEnd指定的边
	 * 
	 *               complexity:O(V)--V代表顶点的个数
	 *
	 * @author com.machine
	 * @date 2017年12月23日 上午11:33:43
	 */
	public boolean remEdge(GraphMap graph, Vertex vertexStart, Vertex vertexEnd) {
		if (null == graph || null == vertexStart || null == vertexEnd) {
			return Boolean.FALSE;
		}
		if (vertexStart.equals(vertexEnd)) {
			return Boolean.FALSE;
		}
		LinkedList<AdjMapList> adjLists = graph.getAdjLists();
		/* Locate the adjacency list of the first vertex */

		AdjMapList startVertexAdjList = null;
		boolean isIncludeStartVertex = Boolean.FALSE;
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			startVertexAdjList = iter.next();
			if (vertexStart.equals(startVertexAdjList.getVertex())) {
				isIncludeStartVertex = Boolean.TRUE;
				break;
			}
		}
		/* Return if the vertex was not found */
		if (!isIncludeStartVertex) {
			return Boolean.FALSE;
		}

		/*
		 * Remove the Second vertex from the adjacency list of the first vertex
		 */
		if (!startVertexAdjList.getAdjancent().containsKey(vertexEnd)) {
			return Boolean.TRUE;
		}
		Object  vertexEndValue = startVertexAdjList.getAdjancent().remove(vertexEnd);
		if (null == vertexEndValue) {
			return Boolean.FALSE;
		}
		graph.setEcount(graph.getEcount() - 1);
		return Boolean.TRUE;
	}

	/**
	 * @Description: 取出graph中由vertex所指定顶点的邻接表 [取出的结构体包含与vertex相匹配
	 *               的顶点,以及其他与其邻接的顶点]
	 * 
	 * @return [邻接表]
	 * 
	 *         complexity:O(V)--V代表顶点的个数
	 *
	 * @author com.machine
	 * @date 2017年12月23日 上午11:33:43
	 */
	public AdjMapList getAdjList(GraphMap graph, Vertex vertex) {
		if (null == graph || vertex == null) {
			return null;
		}
		LinkedList<AdjMapList> adjLists = graph.getAdjLists();
		/* Locate the adjacency list for the vertex */
		AdjMapList vertexAdjList = null;
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			vertexAdjList = iter.next();
			if (vertex.equals(vertexAdjList.getVertex())) {
				return vertexAdjList;
			}
		}
		return null;
	}

	/**
	 * @Description: 判断vertexStart和vertexEnd是否邻接
	 *
	 * @author com.machine
	 * @date 2017年12月24日 上午9:27:45
	 */
	public boolean isAdjacent(GraphMap graph, Vertex vertexStart, Vertex vertexEnd) {

		if (null == graph || null == vertexStart || null == vertexEnd) {
			return Boolean.FALSE;
		}
		if (vertexStart.equals(vertexEnd)) {
			return Boolean.FALSE;
		}
		LinkedList<AdjMapList> adjLists = graph.getAdjLists();
		/* Locate the adjacency list of the first vertex */

		AdjMapList startVertexAdjList = null;
		boolean isIncludeStartVertex = Boolean.FALSE;
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			startVertexAdjList = iter.next();
			if (vertexStart.equals(startVertexAdjList.getVertex())) {
				isIncludeStartVertex = Boolean.TRUE;
				break;
			}
		}
		/* Return if the first vertex was not found */
		if (!isIncludeStartVertex) {
			return Boolean.FALSE;
		}
		/*
		 * Return whether the second vertex is in the adjacency list of the
		 * first
		 */
		return startVertexAdjList.getAdjancent().containsKey(vertexEnd);
	}

	/**
	 * @Description: 单例模式
	 *
	 * @author com.machine
	 * @date 2017年12月20日 上午9:06:15
	 */
	public static GraphMapUtil getInstance() {
		if (graphUtil == null) {
			synchronized (GraphMapUtil.class) {
				if (graphUtil == null) {
					graphUtil = new GraphMapUtil();
				}
			}
		}
		return graphUtil;
	}

	private GraphMapUtil() {
	}

	private volatile static GraphMapUtil graphUtil;

}
