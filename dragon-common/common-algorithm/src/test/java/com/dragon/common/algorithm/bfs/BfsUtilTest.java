package com.dragon.common.algorithm.bfs;

import com.dragon.common.datastructure.graphset.GraphSet;
import com.dragon.common.datastructure.graphset.GraphSetUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * @Description: :广度优先搜索工具类JUNIT
 *
 * @author com.machine
 * @date 2017年12月24日 下午3:48:19
 */
public class BfsUtilTest {

	/**
	 * @Description: 测试跳转数
	 *
	 * @author com.machine
	 * @date 2017年12月24日 下午3:49:03
	 */
	@Test
	public void testGetHops() {

		GraphSet graph = new GraphSet();
		GraphSetUtil graphUtil = GraphSetUtil.getInstance();

		BfsVertex bfsVertex01 = new BfsVertex("bfsVertex01");
		BfsVertex bfsVertex02 = new BfsVertex("bfsVertex02");
		BfsVertex bfsVertex03 = new BfsVertex("bfsVertex03");
		BfsVertex bfsVertex04 = new BfsVertex("bfsVertex04");
		BfsVertex bfsVertex05 = new BfsVertex("bfsVertex05");
		BfsVertex bfsVertex06 = new BfsVertex("bfsVertex06");

		graphUtil.insVertex(graph, bfsVertex01);
		graphUtil.insVertex(graph, bfsVertex02);
		graphUtil.insVertex(graph, bfsVertex03);
		graphUtil.insVertex(graph, bfsVertex04);
		graphUtil.insVertex(graph, bfsVertex05);
		graphUtil.insVertex(graph, bfsVertex06);

		graphUtil.insEdge(graph, bfsVertex01, bfsVertex02);
		graphUtil.insEdge(graph, bfsVertex02, bfsVertex01);

		graphUtil.insEdge(graph, bfsVertex01, bfsVertex03);
		graphUtil.insEdge(graph, bfsVertex03, bfsVertex01);

		graphUtil.insEdge(graph, bfsVertex02, bfsVertex03);
		graphUtil.insEdge(graph, bfsVertex03, bfsVertex02);

		graphUtil.insEdge(graph, bfsVertex02, bfsVertex04);
		graphUtil.insEdge(graph, bfsVertex04, bfsVertex02);

		graphUtil.insEdge(graph, bfsVertex03, bfsVertex05);
		graphUtil.insEdge(graph, bfsVertex05, bfsVertex03);

		graphUtil.insEdge(graph, bfsVertex04, bfsVertex05);
		graphUtil.insEdge(graph, bfsVertex05, bfsVertex04);

		graphUtil.insEdge(graph, bfsVertex05, bfsVertex06);
		graphUtil.insEdge(graph, bfsVertex06, bfsVertex05);

		List<BfsVertex> hops = BfsUtil.getInstance().getHops(graph, bfsVertex01);
		StringBuilder sb = new StringBuilder();
		for (BfsVertex v : hops) {
			sb.append(v.getHops()).append("");
		}
		TestCase.assertEquals(sb.toString(), "011223");
	}
}
