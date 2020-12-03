package AutoTestScene;

import java.util.HashMap;
import java.util.Map;

public class GMaterialPlan {
	/**
	 *  全局关键参数值
	 */
	public static Map<String, String> FIELD_VALUE = null;
	
	/**
	 *  
	 */
	public GMaterialPlan(){
		FIELD_VALUE = new HashMap<String, String>();
		
		
		FIELD_VALUE.put("材料需用计划-单据编号", "");//连接技能1
		FIELD_VALUE.put("材料需用计划-本期计划量", "100");
		FIELD_VALUE.put("材料需用计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料需用计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料总量计划-单据编号", "");
		FIELD_VALUE.put("材料总量计划-计划数量", FIELD_VALUE.get("材料需用计划-本期计划量"));
		FIELD_VALUE.put("材料总量计划-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("材料总量计划-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		
		FIELD_VALUE.put("材料部位计划-单据编号", "");
		FIELD_VALUE.put("材料部位计划-计划数量", FIELD_VALUE.get("材料需用计划-本期计划量"));
		FIELD_VALUE.put("材料部位计划-部位名称", "1号楼");
		FIELD_VALUE.put("材料部位计划-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("材料部位计划-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		
		FIELD_VALUE.put("材料甲供计划-单据编号", "");
		FIELD_VALUE.put("材料甲供计划-本期计划量", FIELD_VALUE.get("材料需用计划-本期计划量"));
		FIELD_VALUE.put("材料甲供计划-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("材料甲供计划-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
	}
}
