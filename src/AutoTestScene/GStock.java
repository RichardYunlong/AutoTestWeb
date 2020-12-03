package AutoTestScene;

import java.util.HashMap;
import java.util.Map;

/**
 *  算法定制
 */
public class GStock {
	
	/**
	 *  全局关键参数值
	 */
	public static Map<String, String> FIELD_VALUE = null;
	
	/**
	 *  
	 */
	public GStock(){
		FIELD_VALUE = new HashMap<String, String>();
		
		
		FIELD_VALUE.put("机构层级", "项目部");
	    FIELD_VALUE.put("供应商单位", "外部单位");
	    FIELD_VALUE.put("参考", "参考需用计划");
	    FIELD_VALUE.put("参考单据编号", "");
		
		FIELD_VALUE.put("材料需用计划-单据编号", "");//连接技能1
		FIELD_VALUE.put("材料需用计划-本期计划量", "100");
		FIELD_VALUE.put("材料需用计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料需用计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料总量计划-单据编号", "");
		FIELD_VALUE.put("材料总量计划-计划数量", "100");
		FIELD_VALUE.put("材料总量计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料总量计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料部位计划-单据编号", "");
		FIELD_VALUE.put("材料部位计划-计划数量", "100");
		FIELD_VALUE.put("材料部位计划-部位名称", "1号楼");
		FIELD_VALUE.put("材料部位计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料部位计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料甲供计划-单据编号", "");
		FIELD_VALUE.put("材料甲供计划-本期计划量", "100");
		FIELD_VALUE.put("材料甲供计划-材料类型编码", "I1100101");
		FIELD_VALUE.put("材料甲供计划-材料编码", "I110010100027");
		
		FIELD_VALUE.put("材料采购合同-单据编号", "");//连接技能2
		FIELD_VALUE.put("材料采购合同-合同名称", "");
		FIELD_VALUE.put("材料采购合同-甲方", "GAT项目部");
		FIELD_VALUE.put("材料采购合同-乙方", "GAT001-WZGYSML-202009-0001");
		FIELD_VALUE.put("材料采购合同-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料采购合同-材料明细-含税单价", "103");
		FIELD_VALUE.put("材料采购合同-材料明细-数量", "100");
		FIELD_VALUE.put("材料采购合同-材料明细-税率(%)", "3");
		
	    FIELD_VALUE.put("商品混凝土供应合同-单据编号", "");//商品混凝土供应合同
  	    FIELD_VALUE.put("商品混凝土供应合同-合同名称", "");
  	    FIELD_VALUE.put("商品混凝土供应合同-甲方", "GAT项目部");
  	    FIELD_VALUE.put("商品混凝土供应合同-乙方", "GAT001-WZGYSML-202009-0001");
  	    FIELD_VALUE.put("商品混凝土供应合同-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
  	    FIELD_VALUE.put("商品混凝土供应合同-商砼明细-含税单价", "103");
  	    FIELD_VALUE.put("商品混凝土供应合同-商砼明细-数量", "100");
  	    FIELD_VALUE.put("商品混凝土供应合同-商砼明细-税率(%)", "3");
  	    
  	    FIELD_VALUE.put("商品混凝土小票-单据编号", "");//商品混凝土小票
        FIELD_VALUE.put("商品混凝土小票-类型", "自耗");//默认自耗
        FIELD_VALUE.put("商品混凝土小票-供应商", FIELD_VALUE.get("商品混凝土供应合同-乙方"));
        FIELD_VALUE.put("商品混凝土小票-使用单位", "外部单位");
        FIELD_VALUE.put("商品混凝土小票-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
        FIELD_VALUE.put("商品混凝土小票-商砼信息-数量", "30");//基本信息页签中商砼信息里的数量
        
        FIELD_VALUE.put("商品混凝土对账单-单据编号", "");//商品混凝土对账单
        
        FIELD_VALUE.put("商品混凝土结算单-单据编号", "");//商品混凝土结算单
        
        FIELD_VALUE.put("商品混凝土调拨结算单-单据编号", "");//商品混凝土调拨结算单
        FIELD_VALUE.put("商品混凝土调拨结算单-收料单位", "内部单位");
        
		FIELD_VALUE.put("材料到货点验单-单据编号", "");//连接技能2-1
		FIELD_VALUE.put("材料到货点验单-合同名称", FIELD_VALUE.get("材料采购合同-合同名称"));
		FIELD_VALUE.put("材料到货点验单-到货材料", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料到货点验单-到货材料-单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		FIELD_VALUE.put("材料到货点验单-到货材料-到货量", FIELD_VALUE.get("材料采购合同-材料明细-数量"));
		
		FIELD_VALUE.put("材料直入直出单-单据编号", "");//连接技能3
		FIELD_VALUE.put("材料直入直出单-供应商", FIELD_VALUE.get("材料采购合同-乙方"));
		FIELD_VALUE.put("材料直入直出单-领料单位", FIELD_VALUE.get("材料采购合同-甲方"));
		FIELD_VALUE.put("材料直入直出单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料直入直出单-材料明细-含税单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		FIELD_VALUE.put("材料直入直出单-材料明细-数量", "10");
		FIELD_VALUE.put("材料直入直出单-材料明细-税率(%)", FIELD_VALUE.get("材料采购合同-材料明细-税率(%)"));
		
		FIELD_VALUE.put("材料入库单-单据编号", "");//连接技能4
		FIELD_VALUE.put("供应类型", "自采");//默认自采
		FIELD_VALUE.put("材料入库单-供应商", FIELD_VALUE.get("材料采购合同-乙方"));
		FIELD_VALUE.put("材料入库单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料入库单-材料明细-含税单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		FIELD_VALUE.put("材料入库单-材料明细-数量", "50");
		FIELD_VALUE.put("材料入库单-材料明细-税率(%)", FIELD_VALUE.get("材料采购合同-材料明细-税率(%)"));
		
		FIELD_VALUE.put("材料退货单-单据编号", "");//连接技能5
		FIELD_VALUE.put("材料退货单-供应商", FIELD_VALUE.get("材料采购合同-乙方"));
		FIELD_VALUE.put("材料退货单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料退货单-材料明细-含税单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		FIELD_VALUE.put("材料退货单-材料明细-数量", "10");
		FIELD_VALUE.put("材料退货单-材料明细-税率(%)", FIELD_VALUE.get("材料采购合同-材料明细-税率(%)"));
		
		FIELD_VALUE.put("材料出库单-单据编号", "");//连接技能6
		FIELD_VALUE.put("材料出库单-供应商", FIELD_VALUE.get("材料采购合同-乙方"));
		FIELD_VALUE.put("材料出库单-领料单位", FIELD_VALUE.get("材料采购合同-甲方"));
		FIELD_VALUE.put("材料出库单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料出库单-材料明细-数量", "20");
		
		FIELD_VALUE.put("材料退库单-单据编号", "");//连接技能7
		FIELD_VALUE.put("材料退库单-供应商", FIELD_VALUE.get("材料采购合同-乙方"));
		FIELD_VALUE.put("材料退库单-退料单位", FIELD_VALUE.get("材料采购合同-甲方"));
		FIELD_VALUE.put("材料退库单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料退库单-材料明细-退库单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		FIELD_VALUE.put("材料退库单-材料明细-退库数量", "10");
		
		FIELD_VALUE.put("材料库房调拨单-单据编号", "");//连接技能8
		FIELD_VALUE.put("材料库房调拨单-收料单位", "自动化测试");
		FIELD_VALUE.put("材料库房调拨单-在库材料", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料库房调拨单-在库材料-调拨单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		FIELD_VALUE.put("材料库房调拨单-在库材料-调拨数量", "10");
		
		FIELD_VALUE.put("材料调拨结算单-单据编号", "");//连接技能9
		FIELD_VALUE.put("材料调拨结算单-收料单位", "自动化测试");
		FIELD_VALUE.put("材料调拨结算单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料调拨结算单-调拨材料-结算单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		
		FIELD_VALUE.put("材料库房报损单-单据编号", "");//连接技能10
		FIELD_VALUE.put("材料库房报损单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料库房报损单-在库材料-报损单价", "100");
		FIELD_VALUE.put("材料库房报损单-在库材料-报损数量", "5");
		
		FIELD_VALUE.put("材料库房盘点单-单据编号", "");//连接技能11
		FIELD_VALUE.put("材料库房盘点单-材料编码", FIELD_VALUE.get("材料需用计划-材料编码"));
		FIELD_VALUE.put("材料库房盘点单-在库材料-实际单价", FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
		FIELD_VALUE.put("材料库房盘点单-在库材料-实际数量", "15");
		
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
	}

}
