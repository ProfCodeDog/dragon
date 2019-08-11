package com.dragon.common.algorithm.prim;

import com.dragon.common.datastructure.graphmap.GraphMap;
import com.dragon.common.datastructure.graphmap.GraphMapUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 测试最小生成树
 *
 * @author com.machine
 * @date 2017年12月26日 下午2:59:44
 */
public class MstUtilTest {

	/**
	 * @Description: 测试最小生成树
	 *
	 * @author com.machine
	 * @date 2017年12月26日 下午3:01:36
	 */
	@Test
	public void testGetSpan() {

		GraphMap graph = new GraphMap();
		GraphMapUtil graphUtil = GraphMapUtil.getInstance();

		MstVertex a = new MstVertex("a");
		MstVertex b = new MstVertex("b");
		MstVertex c = new MstVertex("c");
		MstVertex d = new MstVertex("d");
		MstVertex e = new MstVertex("e");
		MstVertex f = new MstVertex("f");

		graphUtil.insVertex(graph, a);
		graphUtil.insVertex(graph, b);
		graphUtil.insVertex(graph, c);
		graphUtil.insVertex(graph, d);
		graphUtil.insVertex(graph, e);
		graphUtil.insVertex(graph, f);

		graphUtil.insEdge(graph, a, b, new BigDecimal(7));
		graphUtil.insEdge(graph, b, a, new BigDecimal(7));

		graphUtil.insEdge(graph, a, c, new BigDecimal(4));
		graphUtil.insEdge(graph, c, a, new BigDecimal(4));

		graphUtil.insEdge(graph, b, c, new BigDecimal(6));
		graphUtil.insEdge(graph, c, b, new BigDecimal(6));

		graphUtil.insEdge(graph, b, d, new BigDecimal(2));
		graphUtil.insEdge(graph, d, b, new BigDecimal(2));

		graphUtil.insEdge(graph, b, f, new BigDecimal(4));
		graphUtil.insEdge(graph, f, b, new BigDecimal(4));

		graphUtil.insEdge(graph, d, f, new BigDecimal(7));
		graphUtil.insEdge(graph, f, d, new BigDecimal(7));

		graphUtil.insEdge(graph, c, f, new BigDecimal(8));
		graphUtil.insEdge(graph, f, c, new BigDecimal(8));

		graphUtil.insEdge(graph, c, e, new BigDecimal(9));
		graphUtil.insEdge(graph, e, c, new BigDecimal(9));

		graphUtil.insEdge(graph, f, e, new BigDecimal(1));
		graphUtil.insEdge(graph, e, f, new BigDecimal(1));

		List<MstVertex> span = MstUtil.getInstance().getSpan(graph, a);
		StringBuilder sb = new StringBuilder();
		for (MstVertex vertex : span) {
			if (null != vertex.getParent()) {
				sb.append(vertex.getParent().getName()).append("-");
			} else {
				sb.append("-");
			}
			sb.append(vertex.getName() + " ");
		}
		TestCase.assertEquals(sb.toString(), "-a c-b a-c b-d f-e b-f ");
	}
}
