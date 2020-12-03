package AutoTestScene;

import java.util.HashMap;
import java.util.Map;

/**
 *  材料采购结算单结算入库单
 *  @author 赵君 2020.11.16 17:13:33
 */
public class GPurchaseSettlementStockIn {
	
	/**
	 *  存储器
	 */
	public static Map<String, String> FIELD_VALUE = null;
	
	/**
	 *  
		登录
		主题切换
		层级切换
		入库单
		材料采购结算单
	 */
	public GPurchaseSettlementStockIn(){
		FIELD_VALUE = new HashMap<String, String>();
		
		FIELD_VALUE.put("供应商单位", "外部单位");
		FIELD_VALUE.put("参考", "参考需用计划");
		
		FIELD_VALUE.put("材料需用计划-单据编号", "");//连接技能1
		FIELD_VALUE.put("材料需用计划-本期计划量", "100");
		FIELD_VALUE.put("材料需用计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料需用计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料入库单-单据编号", "");//连接技能1
		FIELD_VALUE.put("材料入库单-供应商", "GAT001-WZGYSML-202009-0001");
		FIELD_VALUE.put("材料入库单-材料编码", "I110010100027");
		FIELD_VALUE.put("材料入库单-材料明细-含税单价", "100");
		FIELD_VALUE.put("材料入库单-材料明细-数量", "80");
		FIELD_VALUE.put("材料入库单-材料明细-税率(%)", "11");
		
		FIELD_VALUE.put("材料采购结算单-单据编号", "");
		FIELD_VALUE.put("材料采购结算单-供应商", FIELD_VALUE.get("材料入库单-供应商"));//连接技能2
		FIELD_VALUE.put("材料采购结算单-材料编码", FIELD_VALUE.get("材料入库单-材料编码"));
		FIELD_VALUE.put("材料采购结算单-材料明细-含税结算单价", "103");
		FIELD_VALUE.put("材料采购结算单-材料明细-数量", "10");
		FIELD_VALUE.put("材料采购结算单-材料明细-税率(%)", "3");
	}
}
	

