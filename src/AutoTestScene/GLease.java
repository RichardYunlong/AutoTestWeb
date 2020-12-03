package AutoTestScene;

import java.util.HashMap;
import java.util.Map;

/**
 *  算法定制
 */
public class GLease {
	
	/**
	 *  全局关键参数值
	 */
	public static Map<String, String> FIELD_VALUE = null;
	
	/**
	 *  
	 */
	public GLease(){
		FIELD_VALUE = new HashMap<String, String>();
		
		FIELD_VALUE.put("材料需用计划-单据编号", "");//连接技能1
		FIELD_VALUE.put("材料需用计划-本期计划量", "100");
		FIELD_VALUE.put("材料需用计划-材料类型编码", "I134");
		FIELD_VALUE.put("材料需用计划-材料编码", "I134010100002");
		
		FIELD_VALUE.put("周转材料租赁计划-单据编号", "");
		FIELD_VALUE.put("周转材料租赁计划-计费单价", "100");
		FIELD_VALUE.put("周转材料租赁计划-计划数量", "100");
		FIELD_VALUE.put("周转材料租赁计划-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("周转材料租赁计划-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		
		FIELD_VALUE.put("周转材料租赁合同-单据编号", "");
		FIELD_VALUE.put("周转材料租赁合同-合同名称", "");
		FIELD_VALUE.put("周转材料租赁合同-甲方", "GAT项目部");
		FIELD_VALUE.put("周转材料租赁合同-乙方", "GAT001-WZGYSML-202009-0001");
		FIELD_VALUE.put("周转材料租赁合同-计费方式", "日租");
		FIELD_VALUE.put("周转材料租赁合同-进场日期", "");
		FIELD_VALUE.put("周转材料租赁合同-出场日期", "");
		FIELD_VALUE.put("周转材料租赁合同-租赁天数", "1");
		FIELD_VALUE.put("周转材料租赁合同-含税日租单价", "103");
		FIELD_VALUE.put("周转材料租赁合同-含税停租单价", "100");
		FIELD_VALUE.put("周转材料租赁合同-含税赔偿单价", "100");
		FIELD_VALUE.put("周转材料租赁合同-税率", "3");
		FIELD_VALUE.put("周转材料租赁合同-数量", "100");
		FIELD_VALUE.put("周转材料租赁合同-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("周转材料租赁合同-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		
		FIELD_VALUE.put("租赁周转材料进场单-单据编号", "");
		FIELD_VALUE.put("租赁周转材料进场单-供应商", FIELD_VALUE.get("周转材料租赁合同-乙方"));
		FIELD_VALUE.put("租赁周转材料进场单-使用单位", FIELD_VALUE.get("周转材料租赁合同-甲方"));
		FIELD_VALUE.put("租赁周转材料进场单-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("租赁周转材料进场单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		
		FIELD_VALUE.put("租赁周转材料内部调拨单-单据编号", "");
		FIELD_VALUE.put("租赁周转材料内部调拨单-调入单位", "自动化测试");
		FIELD_VALUE.put("租赁周转材料内部调拨单-调出单位", FIELD_VALUE.get("周转材料租赁合同-甲方"));
		FIELD_VALUE.put("租赁周转材料内部调拨单-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("租赁周转材料内部调拨单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("租赁周转材料内部调拨单-调拨数量", "40");

		FIELD_VALUE.put("租赁周转材料停租单-单据编号", "");
		FIELD_VALUE.put("租赁周转材料停租单-供应商", FIELD_VALUE.get("周转材料租赁合同-乙方"));
		FIELD_VALUE.put("租赁周转材料停租单-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("租赁周转材料停租单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("租赁周转材料停租单-使用单位", FIELD_VALUE.get("周转材料租赁合同-甲方"));
		FIELD_VALUE.put("租赁周转材料停租单-停租单价", "103");
		FIELD_VALUE.put("租赁周转材料停租单-停租数量", "20");
		
		FIELD_VALUE.put("租赁周转材料出场单-单据编号", "");
		FIELD_VALUE.put("租赁周转材料出场单-供应商", FIELD_VALUE.get("周转材料租赁合同-乙方"));
		FIELD_VALUE.put("租赁周转材料出场单-使用单位", FIELD_VALUE.get("周转材料租赁合同-甲方"));
		FIELD_VALUE.put("租赁周转材料出场单-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("租赁周转材料出场单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("租赁周转材料出场单-出场数量", "40");
		
		FIELD_VALUE.put("周转材料租赁结算单-单据编号", "");
		FIELD_VALUE.put("周转材料租赁结算单-供应商", FIELD_VALUE.get("周转材料租赁合同-乙方"));
		FIELD_VALUE.put("周转材料租赁结算单-材料类型编码", FIELD_VALUE.get("材料需用计划-材料类型编码"));
		FIELD_VALUE.put("周转材料租赁结算单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
	}
}
