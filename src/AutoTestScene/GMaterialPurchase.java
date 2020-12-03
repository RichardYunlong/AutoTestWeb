package AutoTestScene;

import java.util.HashMap;
import java.util.Map;

/**
 *  算法定制
 */
public class GMaterialPurchase {
	
	/**
	 *  全局关键参数值
	 */
	public static Map<String, String> FIELD_VALUE = null;
	
	/**
	 *  
	 */
	public GMaterialPurchase(){
		FIELD_VALUE = new HashMap<String, String>();
		
		FIELD_VALUE.put("材料采购计划-单据编号", "");
		FIELD_VALUE.put("材料采购计划-材料明细-本次计划量", "100");
		FIELD_VALUE.put("材料采购计划-材料明细-计划单价", "100");
		FIELD_VALUE.put("材料采购计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料采购计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料采购比价单-单据编号", "");
		FIELD_VALUE.put("材料采购比价单-材料明细-数量", "88");
		FIELD_VALUE.put("材料采购比价单-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料采购比价单-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料采购订单-单据编号", "");
		FIELD_VALUE.put("材料采购订单-供应商", "GAT001-WZGYSML-202009-0001");
		FIELD_VALUE.put("材料采购订单-材料明细-含税单价", "110");
		FIELD_VALUE.put("材料采购订单-材料明细-数量", "100");
		FIELD_VALUE.put("材料采购订单-材料明细-税率(%)", "11");
		FIELD_VALUE.put("材料采购订单-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料采购订单-材料编码", "I110010100027");
		
		FIELD_VALUE.put("运杂费记录单-单据编号", "");
		FIELD_VALUE.put("运杂费记录单-往来单位", "GAT001-WZGYSML-202009-0001");
		FIELD_VALUE.put("运杂费记录单-费用项明细-费用项名称", "运杂费");
		FIELD_VALUE.put("运杂费记录单-费用项明细-含税单价", "110");
		FIELD_VALUE.put("运杂费记录单-费用项明细-数量", "100");
		FIELD_VALUE.put("运杂费记录单-费用项明细-税率(%)", "11");
		
		FIELD_VALUE.put("运杂费结算单-单据编号", "");
		FIELD_VALUE.put("运杂费结算单-结算单位", FIELD_VALUE.get("运杂费记录单-往来单位"));
		FIELD_VALUE.put("运杂费结算单-费用明细-含税结算金额", "110");
		FIELD_VALUE.put("运杂费结算单-其他费用-费用项名称", "运杂费");
		FIELD_VALUE.put("运杂费结算单-其他费用-含税单价", "110");
		FIELD_VALUE.put("运杂费结算单-其他费用-数量", "100");
		FIELD_VALUE.put("运杂费结算单-其他费用-税率(%)", "11");
		
		FIELD_VALUE.put("材料付款申请单-收款单位", "GAT001-WZGYSML-202009-0001");
		
		FIELD_VALUE.put("材料最终结算单-供应商", "00002-WZGYSML-202004-0002");
	}
}
