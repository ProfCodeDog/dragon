package com.dragon.common.algorithm.dfs;

import com.dragon.common.datastructure.graphset.GraphSet;
import com.dragon.common.datastructure.graphset.GraphSetUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * @Description: 深度优先搜索工具类JUNIT
 *
 * @author com.machine
 * @date 2017年12月24日 下午3:48:19
 */
public class DfsUtilTest {

	/**
	 * @Description: 测试跳拓扑排序(有向无环图)
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:49:03
	 */
	@Test
	public void testGetHops() {

		GraphSet graph = new GraphSet();
		GraphSetUtil graphUtil = GraphSetUtil.getInstance();

		DfsVertex cs100 = new DfsVertex("cs100");
		DfsVertex cs200 = new DfsVertex("cs200");
		DfsVertex cs300 = new DfsVertex("cs300");
		DfsVertex ma100 = new DfsVertex("ma100");
		DfsVertex ma200 = new DfsVertex("ma200");
		DfsVertex ma300 = new DfsVertex("ma300");
		DfsVertex cs150 = new DfsVertex("cs150");

		graphUtil.insVertex(graph, cs100);
		graphUtil.insVertex(graph, cs200);
		graphUtil.insVertex(graph, cs300);
		graphUtil.insVertex(graph, ma100);
		graphUtil.insVertex(graph, ma200);
		graphUtil.insVertex(graph, ma300);
		graphUtil.insVertex(graph, cs150);

		graphUtil.insEdge(graph, cs100, cs200);
		graphUtil.insEdge(graph, cs200, cs300);

		graphUtil.insEdge(graph, cs300, ma300);
		graphUtil.insEdge(graph, ma200, ma300);

		graphUtil.insEdge(graph, ma100, ma200);
		graphUtil.insEdge(graph, ma100, cs300);

		List<DfsVertex> ordered = DfsUtil.getInstance().getOrderd(graph);

		TestCase.assertEquals(ordered.get(0).getName(), "ma300");
	}
}
