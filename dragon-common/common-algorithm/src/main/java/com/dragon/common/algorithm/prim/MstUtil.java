package com.dragon.common.algorithm.prim;

import com.dragon.common.datastructure.graph.Vertex;
import com.dragon.common.datastructure.graph.VertexColor;
import com.dragon.common.datastructure.graphmap.AdjMapList;
import com.dragon.common.datastructure.graphmap.GraphMap;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description: 最小生成树工具类
 *
 * @author com.machine
 * @date 2017年12月25日 下午5:42:32
 */
public class MstUtil {

	/**
	 * @Description: 得到最小生成树
	 * 
	 *               complexity:O(EV^2)--V代表顶点的个数,E代表边的个数
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:52:56
	 */
	public List<MstVertex> getSpan(GraphMap graph, MstVertex startVertex) {
		if (null == graph || null == startVertex) {
			return null;
		}

		/* Initialize all of the vertices in the graph */
		AdjMapList adjList = null;
		MstVertex mstVertex = null;
		BigDecimal adjVertexWeight = null;
		boolean found = Boolean.FALSE;

		LinkedList<AdjMapList> adjLists = graph.getAdjLists();

		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			adjList = iter.next();
			mstVertex = (MstVertex) adjList.getVertex();
			if (startVertex.equals(mstVertex)) {
				/* Initialize the start vertex */
				mstVertex.setVertexColor(VertexColor.white);
				mstVertex.setKey(new BigDecimal(0));
				mstVertex.setParent(null);
				found = Boolean.TRUE;
			} else {
				/* Initialize vertices other than the start vertex */
				mstVertex.setVertexColor(VertexColor.white);
				mstVertex.setKey(new BigDecimal(Long.MAX_VALUE));
				mstVertex.setParent(null);
			}
		}

		/* Return if the start vertex was not found */
		if (!found) {
			return null;
		}

		/* Use Prim's algorithm to compute a minimum spanning tree */
		int i = 0;
		BigDecimal minium = null;
		while (i < graph.getVcount()) {
			/* Select the white vertex with the smallest key value */
			minium = new BigDecimal(Long.MAX_VALUE);
			for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
				AdjMapList tempAdjList = iter.next();
				mstVertex = (MstVertex) tempAdjList.getVertex();
				if (mstVertex.getVertexColor() == VertexColor.white && (mstVertex.getKey().compareTo(minium) == -1)) {
					minium = mstVertex.getKey();
					adjList = tempAdjList;
				}
			}

			/* Color the selected vertex black */
			adjList.getVertex().setVertexColor(VertexColor.black);

			/* Traverse each vertex adjacent to the selected vertex */
			for (Map.Entry<Vertex, Object> entry : adjList.getAdjancent().entrySet()) {
				
				adjVertexWeight = (BigDecimal) entry.getValue();
				
				/*
				 * Find the adjacent vertex in the list of adjacency-list
				 * structures
				 */

				for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
					mstVertex = (MstVertex) iter.next().getVertex();
					if (entry.getKey().equals(mstVertex)) {
						/*
						 * Decide whether to change the key value and parent of
						 * the adjacent vertex in the list of adjacency-list
						 * structures
						 */
						if (mstVertex.getVertexColor() == VertexColor.white
								&& (adjVertexWeight.compareTo(mstVertex.getKey()) == -1)) {
							mstVertex.setKey(adjVertexWeight);
							mstVertex.setParent((MstVertex) adjList.getVertex());
						}
						break;
					}
				}
			}
			/* Prepare to select the next vertex */
			i++;
		}

		/* Load the minimum spanning tree into a list */
		List<MstVertex> span = new ArrayList<MstVertex>(graph.getAdjLists().size());
		for (Iterator<AdjMapList> iter = adjLists.iterator(); iter.hasNext();) {
			/*
			 * Load each black vertex from the list of adjacency-list structures
			 */
			mstVertex = (MstVertex) iter.next().getVertex();
			if (mstVertex.getVertexColor() == VertexColor.black) {
				span.add(mstVertex);
			}
		}
		return span;
	}

	/**
	 * @Description: 单例模式
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:23:16
	 */
	public static MstUtil getInstance() {
		if (mstUtil == null) {
			synchronized (MstUtil.class) {
				if (mstUtil == null) {
					mstUtil = new MstUtil();
				}
			}
		}
		return mstUtil;
	}

	private MstUtil() {
	}

	private volatile static MstUtil mstUtil;
}
