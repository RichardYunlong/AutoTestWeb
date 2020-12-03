package AutoTestScene;

import java.util.HashMap;
import java.util.Map;

/**
 *  材料采购合同参考材料需用计划数量占位
 */
public class GDemandPlanQuantityOccupancy {
	
	/**
	 *  存储器
	 */
	public static Map<String, String> FIELD_VALUE = null;
	
	/**
	 *  
		登录
		主题切换
		层级切换
		材料需用计划
		材料采购合同1
		材料采购合同2
		材料采购合同3
	 */
	public GDemandPlanQuantityOccupancy(){
		FIELD_VALUE = new HashMap<String, String>();
		
		FIELD_VALUE.put("材料需用计划-单据编号", "");//连接技能1
		FIELD_VALUE.put("材料需用计划-本期计划量", "100");
		FIELD_VALUE.put("材料需用计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料需用计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料采购合同-甲方", "GAT项目部");
		
		FIELD_VALUE.put("材料采购合同-乙方", "GAT001-WZGYSML-202009-0001");
		FIELD_VALUE.put("材料采购合同-单据编号", "");//连接技能2
		FIELD_VALUE.put("材料采购合同-合同名称", "");
		FIELD_VALUE.put("材料采购合同-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料采购合同-材料明细-含税单价", "103");
		FIELD_VALUE.put("材料采购合同-材料明细-数量", "10");
		FIELD_VALUE.put("材料采购合同-材料明细-税率(%)", "3");
	}
}
	

