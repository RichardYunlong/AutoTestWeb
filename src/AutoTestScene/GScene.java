package AutoTestScene;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GSys;

/**
 *  场景加载器
 */
public class GScene {
	
	/**
	 *  当前场景名称
	 */
	public static String gSceneName = "";
	
	/**
	 *  全局关键动态参数值
	 */
	public static Map<String, String> DYNAMIC_DATA = null;
	
	/**
	 *  
	 */
	public GScene() {
		long startTime = 0L;
		
		//加载材料计划管理场景
		startTime = System.currentTimeMillis();
		new GMaterialPlan();
		GLog.logDoReady(startTime, "GMaterialPlan");
		GSys.PROGRESS_CUR++;
		
		//加载材料采购管理场景
		startTime = System.currentTimeMillis();
		new GMaterialPurchase();
		GLog.logDoReady(startTime, "GMaterialPurchase");
		GSys.PROGRESS_CUR++;
		
		//加载库房管理单据参考需用计划场景
		startTime = System.currentTimeMillis();
		new GStock();
		GLog.logDoReady(startTime, "GStock");
		GSys.PROGRESS_CUR++;
		
		//加载材料采购合同参考材料需用计划数量占位场景
		startTime = System.currentTimeMillis();
		new GDemandPlanQuantityOccupancy();
		GLog.logDoReady(startTime, "GDemandPlanQuantityOccupancy");
		GSys.PROGRESS_CUR++;
		
		//加载供应商管理场景
        startTime = System.currentTimeMillis();
        new GSupplier();
        GLog.logDoReady(startTime, "GSupplier");
        GSys.PROGRESS_CUR++;
        
		//加载周转租赁材料管理场景
        startTime = System.currentTimeMillis();
        new GLease();
        GLog.logDoReady(startTime, "GLease");
        GSys.PROGRESS_CUR++;
        
        //加载材料采购结算入库单场景
        startTime = System.currentTimeMillis();
        new GPurchaseSettlementStockIn();
      	GLog.logDoReady(startTime, "GPurchaseSettlementStockIn");
      	GSys.PROGRESS_CUR++;
	}

	/**
	 *  设置当前场景动态参数
	 *  
	 *  @param sceneName 场景名称
	 */
	public static void GSceneDynamicData(String sceneName) {
		gSceneName = sceneName;
		
		DYNAMIC_DATA = new HashMap<String, String>();

		switch(sceneName) {
			case "GConcrete":
			case "GStock":{
			    DYNAMIC_DATA.put("机构层级", GStock.FIELD_VALUE.get("机构层级"));
			    DYNAMIC_DATA.put("供应类型", GStock.FIELD_VALUE.get("供应类型"));
	            DYNAMIC_DATA.put("供应商单位", GStock.FIELD_VALUE.get("供应商单位"));
	            DYNAMIC_DATA.put("参考", GStock.FIELD_VALUE.get("参考"));
	            DYNAMIC_DATA.put("参考单据编号", GStock.FIELD_VALUE.get("参考单据编号"));
				DYNAMIC_DATA.put("材料需用计划-单据编号", "");
				DYNAMIC_DATA.put("材料需用计划-材料类型编码", GStock.FIELD_VALUE.get("材料需用计划-材料类型编码"));
				DYNAMIC_DATA.put("材料需用计划-材料编码", GStock.FIELD_VALUE.get("材料需用计划-材料编码"));
				DYNAMIC_DATA.put("材料需用计划-本期计划量", GStock.FIELD_VALUE.get("材料需用计划-本期计划量"));
				
				DYNAMIC_DATA.put("材料总量计划-单据编号", "");
				DYNAMIC_DATA.put("材料总量计划-材料类型编码", GStock.FIELD_VALUE.get("材料总量计划-材料类型编码"));
				DYNAMIC_DATA.put("材料总量计划-材料编码", GStock.FIELD_VALUE.get("材料总量计划-材料编码"));
				DYNAMIC_DATA.put("材料总量计划-计划数量", GStock.FIELD_VALUE.get("材料总量计划-计划数量"));
				
				DYNAMIC_DATA.put("材料部位计划-单据编号", "");
				DYNAMIC_DATA.put("材料部位计划-材料类型编码", GStock.FIELD_VALUE.get("材料部位计划-材料类型编码"));
				DYNAMIC_DATA.put("材料部位计划-材料编码", GStock.FIELD_VALUE.get("材料部位计划-材料编码"));
				DYNAMIC_DATA.put("材料部位计划-部位名称", GStock.FIELD_VALUE.get("材料部位计划-部位名称"));
				DYNAMIC_DATA.put("材料部位计划-计划数量", GStock.FIELD_VALUE.get("材料部位计划-计划数量"));
				
				DYNAMIC_DATA.put("材料甲供计划-单据编号", "");
				DYNAMIC_DATA.put("材料甲供计划-材料类型编码", GStock.FIELD_VALUE.get("材料甲供计划-材料类型编码"));
				DYNAMIC_DATA.put("材料甲供计划-材料编码", GStock.FIELD_VALUE.get("材料甲供计划-材料编码"));
				DYNAMIC_DATA.put("材料甲供计划-本期计划量", GStock.FIELD_VALUE.get("材料甲供计划-本期计划量"));
				
				DYNAMIC_DATA.put("材料采购合同-单据编号", "");
				DYNAMIC_DATA.put("材料采购合同-合同名称", "");
				DYNAMIC_DATA.put("材料采购合同-甲方", GStock.FIELD_VALUE.get("材料采购合同-甲方"));
				DYNAMIC_DATA.put("材料采购合同-乙方", GStock.FIELD_VALUE.get("材料采购合同-乙方"));
				DYNAMIC_DATA.put("材料采购合同-材料编码", GStock.FIELD_VALUE.get("材料采购合同-材料编码"));
				DYNAMIC_DATA.put("材料采购合同-材料明细-含税单价", GStock.FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料采购合同-材料明细-数量", GStock.FIELD_VALUE.get("材料采购合同-材料明细-数量"));
				DYNAMIC_DATA.put("材料采购合同-材料明细-税率(%)", GStock.FIELD_VALUE.get("材料采购合同-材料明细-税率(%)"));
				
                DYNAMIC_DATA.put("商品混凝土供应合同-单据编号", "");
                DYNAMIC_DATA.put("商品混凝土供应合同-合同名称", "");
                DYNAMIC_DATA.put("商品混凝土供应合同-甲方", GStock.FIELD_VALUE.get("商品混凝土供应合同-甲方"));
                DYNAMIC_DATA.put("商品混凝土供应合同-乙方", GStock.FIELD_VALUE.get("商品混凝土供应合同-乙方"));
                DYNAMIC_DATA.put("商品混凝土供应合同-材料编码", GStock.FIELD_VALUE.get("商品混凝土供应合同-材料编码"));
                DYNAMIC_DATA.put("商品混凝土供应合同-商砼明细-含税单价", GStock.FIELD_VALUE.get("商品混凝土供应合同-商砼明细-含税单价"));
                DYNAMIC_DATA.put("商品混凝土供应合同-商砼明细-数量", GStock.FIELD_VALUE.get("商品混凝土供应合同-商砼明细-数量"));
                DYNAMIC_DATA.put("商品混凝土供应合同-商砼明细-税率(%)", GStock.FIELD_VALUE.get("商品混凝土供应合同-商砼明细-税率(%)"));

				DYNAMIC_DATA.put("材料到货点验单-单据编号", "");
				DYNAMIC_DATA.put("材料到货点验单-合同名称", GStock.FIELD_VALUE.get("材料到货点验单-合同名称"));
				DYNAMIC_DATA.put("材料到货点验单-到货材料", GStock.FIELD_VALUE.get("材料到货点验单-到货材料"));
				DYNAMIC_DATA.put("材料到货点验单-到货材料-单价", GStock.FIELD_VALUE.get("材料到货点验单-到货材料-单价"));
				DYNAMIC_DATA.put("材料到货点验单-到货材料-到货量", GStock.FIELD_VALUE.get("材料到货点验单-到货材料-到货量"));
				
				DYNAMIC_DATA.put("材料直入直出单-单据编号", "");//连接技能3
				DYNAMIC_DATA.put("材料直入直出单-供应商", GStock.FIELD_VALUE.get("材料直入直出单-供应商"));
				DYNAMIC_DATA.put("材料直入直出单-领料单位", GStock.FIELD_VALUE.get("材料直入直出单-领料单位"));
				DYNAMIC_DATA.put("材料直入直出单-材料编码", GStock.FIELD_VALUE.get("材料直入直出单-材料编码"));
				DYNAMIC_DATA.put("材料直入直出单-材料明细-含税单价", GStock.FIELD_VALUE.get("材料直入直出单-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料直入直出单-材料明细-数量", GStock.FIELD_VALUE.get("材料直入直出单-材料明细-数量"));
				DYNAMIC_DATA.put("材料直入直出单-材料明细-税率(%)", GStock.FIELD_VALUE.get("材料直入直出单-材料明细-税率(%)"));
				
				DYNAMIC_DATA.put("材料入库单-单据编号", "");//连接技能4
				DYNAMIC_DATA.put("材料入库单-供应商", GStock.FIELD_VALUE.get("材料入库单-供应商"));
				DYNAMIC_DATA.put("材料入库单-材料编码", GStock.FIELD_VALUE.get("材料入库单-材料编码"));
				DYNAMIC_DATA.put("材料入库单-材料明细-含税单价", GStock.FIELD_VALUE.get("材料入库单-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料入库单-材料明细-数量", GStock.FIELD_VALUE.get("材料入库单-材料明细-数量"));
				DYNAMIC_DATA.put("材料入库单-材料明细-税率(%)", GStock.FIELD_VALUE.get("材料入库单-材料明细-税率(%)"));
				

                DYNAMIC_DATA.put("商品混凝土小票-类型", GStock.FIELD_VALUE.get("商品混凝土小票-类型"));
                DYNAMIC_DATA.put("商品混凝土小票-使用单位", GStock.FIELD_VALUE.get("商品混凝土小票-使用单位"));
                DYNAMIC_DATA.put("商品混凝土小票-单据编号", "");//商品混凝土小票
                DYNAMIC_DATA.put("商品混凝土小票-供应商", GStock.FIELD_VALUE.get("商品混凝土小票-供应商"));
                DYNAMIC_DATA.put("商品混凝土小票-材料编码", GStock.FIELD_VALUE.get("商品混凝土小票-材料编码"));
                DYNAMIC_DATA.put("商品混凝土小票-商砼信息-数量", GStock.FIELD_VALUE.get("商品混凝土小票-商砼信息-数量"));
                
                DYNAMIC_DATA.put("商品混凝土对账单-单据编号", "");//商品混凝土对账单
                
                DYNAMIC_DATA.put("商品混凝土结算单-单据编号", "");//商品混凝土结算单
                
                DYNAMIC_DATA.put("商品混凝土调拨结算单-单据编号", "");//商品混凝土调拨结算单
                DYNAMIC_DATA.put("商品混凝土调拨结算单-收料单位", GStock.FIELD_VALUE.get("商品混凝土调拨结算单-收料单位"));
                
				DYNAMIC_DATA.put("材料退货单-单据编号", "");//连接技能5
				DYNAMIC_DATA.put("材料退货单-供应商", GStock.FIELD_VALUE.get("材料退货单-供应商"));
				DYNAMIC_DATA.put("材料退货单-材料编码", GStock.FIELD_VALUE.get("材料退货单-材料编码"));
				DYNAMIC_DATA.put("材料退货单-材料明细-含税单价", GStock.FIELD_VALUE.get("材料退货单-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料退货单-材料明细-数量", GStock.FIELD_VALUE.get("材料退货单-材料明细-数量"));
				DYNAMIC_DATA.put("材料退货单-材料明细-税率(%)", GStock.FIELD_VALUE.get("材料退货单-材料明细-税率(%)"));
				
				DYNAMIC_DATA.put("材料出库单-单据编号", "");//连接技能6
				DYNAMIC_DATA.put("材料出库单-供应商", GStock.FIELD_VALUE.get("材料出库单-供应商"));
				DYNAMIC_DATA.put("材料出库单-领料单位", GStock.FIELD_VALUE.get("材料出库单-领料单位"));
				DYNAMIC_DATA.put("材料出库单-材料编码", GStock.FIELD_VALUE.get("材料出库单-材料编码"));
				DYNAMIC_DATA.put("材料出库单-材料明细-数量", GStock.FIELD_VALUE.get("材料出库单-材料明细-数量"));
				
				DYNAMIC_DATA.put("材料退库单-单据编号", "");//连接技能7
				DYNAMIC_DATA.put("材料退库单-供应商", GStock.FIELD_VALUE.get("材料退库单-供应商"));
				DYNAMIC_DATA.put("材料退库单-退料单位", GStock.FIELD_VALUE.get("材料退库单-退料单位"));
				DYNAMIC_DATA.put("材料退库单-材料编码", GStock.FIELD_VALUE.get("材料退库单-材料编码"));
				DYNAMIC_DATA.put("材料退库单-材料明细-退库单价", GStock.FIELD_VALUE.get("材料退库单-材料明细-退库单价"));
				DYNAMIC_DATA.put("材料退库单-材料明细-退库数量", GStock.FIELD_VALUE.get("材料退库单-材料明细-退库数量"));

				DYNAMIC_DATA.put("材料库房报损单-单据编号", "");//连接技能10
				DYNAMIC_DATA.put("材料库房报损单-材料编码", GStock.FIELD_VALUE.get("材料库房报损单-材料编码"));
				DYNAMIC_DATA.put("材料库房报损单-在库材料-报损单价", GStock.FIELD_VALUE.get("材料库房报损单-在库材料-报损单价"));
				DYNAMIC_DATA.put("材料库房报损单-在库材料-报损数量", GStock.FIELD_VALUE.get("材料库房报损单-在库材料-报损数量"));
				
				DYNAMIC_DATA.put("材料库房调拨单-单据编号", "");//连接技能8
				DYNAMIC_DATA.put("材料库房调拨单-收料单位", GStock.FIELD_VALUE.get("材料库房调拨单-收料单位"));
				DYNAMIC_DATA.put("材料库房调拨单-在库材料", GStock.FIELD_VALUE.get("材料调库房拨单-在库材料"));
				DYNAMIC_DATA.put("材料库房调拨单-在库材料-调拨单价", GStock.FIELD_VALUE.get("材料库房调拨单-在库材料-调拨单价"));
				DYNAMIC_DATA.put("材料库房调拨单-在库材料-调拨数量", GStock.FIELD_VALUE.get("材料库房调拨单-在库材料-调拨数量"));
				
				DYNAMIC_DATA.put("材料调拨结算单-单据编号", "");//连接技能9
				DYNAMIC_DATA.put("材料调拨结算单-收料单位", GStock.FIELD_VALUE.get("材料调拨结算单-收料单位"));
				DYNAMIC_DATA.put("材料调拨结算单-材料编码", GStock.FIELD_VALUE.get("材料调拨结算单-材料编码"));
				DYNAMIC_DATA.put("材料调拨结算单-调拨材料-结算单价", GStock.FIELD_VALUE.get("材料调拨结算单-调拨材料-结算单价"));
				
				DYNAMIC_DATA.put("材料库房盘点单-单据编号", "");//连接技能11
				DYNAMIC_DATA.put("材料库房盘点单-材料编码", GStock.FIELD_VALUE.get("材料库房盘点单-材料编码"));
				DYNAMIC_DATA.put("材料库房盘点单-在库材料-实际单价", GStock.FIELD_VALUE.get("材料库房盘点单-在库材料-实际单价"));
				DYNAMIC_DATA.put("材料库房盘点单-在库材料-实际数量", GStock.FIELD_VALUE.get("材料库房盘点单-在库材料-实际数量"));
				
				DYNAMIC_DATA.put("材料采购计划-单据编号", "");
				DYNAMIC_DATA.put("材料采购计划-材料类型编码", GStock.FIELD_VALUE.get("材料采购计划-材料类型编码"));
				DYNAMIC_DATA.put("材料采购计划-材料编码", GStock.FIELD_VALUE.get("材料采购计划-材料编码"));
				DYNAMIC_DATA.put("材料采购计划-材料明细-计划单价", GStock.FIELD_VALUE.get("材料采购计划-材料明细-计划单价"));
				DYNAMIC_DATA.put("材料采购计划-材料明细-本次计划量", GStock.FIELD_VALUE.get("材料采购计划-材料明细-本次计划量"));
				
				DYNAMIC_DATA.put("材料采购比价单-单据编号", "");
				DYNAMIC_DATA.put("材料采购比价单-材料类型编码", GStock.FIELD_VALUE.get("材料采购比价单-材料类型编码"));
				DYNAMIC_DATA.put("材料采购比价单-材料编码", GStock.FIELD_VALUE.get("材料采购比价单-材料编码"));
				DYNAMIC_DATA.put("材料采购比价单-材料明细-数量", GStock.FIELD_VALUE.get("材料采购比价单-材料明细-数量"));
				
				DYNAMIC_DATA.put("材料采购订单-单据编号", "");
				DYNAMIC_DATA.put("材料采购订单-供应商", GStock.FIELD_VALUE.get("材料采购订单-供应商"));
				DYNAMIC_DATA.put("材料采购订单-材料类型编码", GStock.FIELD_VALUE.get("材料采购订单-材料类型编码"));
				DYNAMIC_DATA.put("材料采购订单-材料编码", GStock.FIELD_VALUE.get("材料采购订单-材料编码"));
				DYNAMIC_DATA.put("材料采购订单-材料明细-含税单价", GStock.FIELD_VALUE.get("材料采购订单-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料采购订单-材料明细-数量", GStock.FIELD_VALUE.get("材料采购订单-材料明细-数量"));
				DYNAMIC_DATA.put("材料采购订单-材料明细-税率(%)", GStock.FIELD_VALUE.get("材料采购订单-材料明细-税率(%)"));
				
				DYNAMIC_DATA.put("运杂费记录单-单据编号", "");
				DYNAMIC_DATA.put("运杂费记录单-往来单位", GStock.FIELD_VALUE.get("运杂费记录单-往来单位"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-费用项名称", GStock.FIELD_VALUE.get("运杂费记录单-费用项明细-费用项名称"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-含税单价", GStock.FIELD_VALUE.get("运杂费记录单-费用项明细-含税单价"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-数量", GStock.FIELD_VALUE.get("运杂费记录单-费用项明细-数量"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-税率(%)", GStock.FIELD_VALUE.get("运杂费记录单-费用项明细-税率(%)"));
				
				DYNAMIC_DATA.put("物资合同交底-单据编号", "");
				
				DYNAMIC_DATA.put("运杂费结算单-单据编号", "");
				DYNAMIC_DATA.put("运杂费结算单-结算单位", GStock.FIELD_VALUE.get("运杂费结算单-结算单位"));
				DYNAMIC_DATA.put("运杂费结算单-费用明细-含税结算金额", GStock.FIELD_VALUE.get("运杂费结算单-费用明细-含税结算金额"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-费用项名称", GStock.FIELD_VALUE.get("运杂费结算单-其他费用-费用项名称"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-含税单价", GStock.FIELD_VALUE.get("运杂费结算单-其他费用-含税单价"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-数量", GStock.FIELD_VALUE.get("运杂费结算单-其他费用-数量"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-税率(%)", GStock.FIELD_VALUE.get("运杂费结算单-其他费用-税率(%)"));
				
				DYNAMIC_DATA.put("材料付款申请单-单据编号", "");
				DYNAMIC_DATA.put("材料付款申请单-收款单位", GStock.FIELD_VALUE.get("材料付款申请单-收款单位"));
				break;
			}
			case "GDemandPlanQuantityOccupancy":{
				DYNAMIC_DATA.put("材料需用计划-单据编号", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料需用计划-单据编号"));
				DYNAMIC_DATA.put("材料需用计划-材料类型编码", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料需用计划-材料类型编码"));
				DYNAMIC_DATA.put("材料需用计划-材料编码", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料需用计划-材料编码"));
				DYNAMIC_DATA.put("材料需用计划-本期计划量", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料需用计划-本期计划量"));
				DYNAMIC_DATA.put("材料需用计划-本期计划量-剩余数量", "0");
				
				DYNAMIC_DATA.put("材料采购合同-单据编号", "");
				DYNAMIC_DATA.put("材料采购合同-合同名称", "");
				DYNAMIC_DATA.put("材料采购合同-材料编码", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料采购合同-材料编码"));
				DYNAMIC_DATA.put("材料采购合同-甲方", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料采购合同-甲方"));
				DYNAMIC_DATA.put("材料采购合同-乙方", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料采购合同-乙方"));
				DYNAMIC_DATA.put("材料采购合同-材料明细-含税单价", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料采购合同-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料采购合同-材料明细-数量", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料采购合同-材料明细-数量"));
				DYNAMIC_DATA.put("材料采购合同-材料明细-税率(%)", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料采购合同-材料明细-税率(%)"));
				
				DYNAMIC_DATA.put("材料采购合同-新建数量", "0");
				DYNAMIC_DATA.put("材料采购合同-材料明细-已占位数量", "0");
				break;
			}
			case "GSupplier":{
				DYNAMIC_DATA.put("物资供应商初评-单据编号", "");
				DYNAMIC_DATA.put("物资供应商黑名单-单据编号", "");
				DYNAMIC_DATA.put("物资供应商评价-单据编号", "");
				DYNAMIC_DATA.put("物资供应商名录-供应商编码", "");
				DYNAMIC_DATA.put("物资供应商名录-供应商名称", "");
				
                DYNAMIC_DATA.put("劳务分包商初评-单据编号", "");
                DYNAMIC_DATA.put("劳务分包商评价-单据编号", "");
                DYNAMIC_DATA.put("劳务分包商集中评价-单据编号", "");
                DYNAMIC_DATA.put("劳务分包商名录-分包商编码", GSupplier.FIELD_VALUE.get("劳务分包商名录-分包商编码"));
                DYNAMIC_DATA.put("劳务分包商名录-企业名称", "");

                DYNAMIC_DATA.put("劳务分包商类别-类别编码", GSupplier.FIELD_VALUE.get("劳务分包商类别-类别编码"));
                DYNAMIC_DATA.put("劳务分包商黑名单-分包商编码", "");
                DYNAMIC_DATA.put("劳务分包商黑名单-分包商名称", "");
                
                DYNAMIC_DATA.put("专业分包商初评-单据编号", "");
                DYNAMIC_DATA.put("专业分包商评价-单据编号", "");
                DYNAMIC_DATA.put("专业分包商集中评价-单据编号", "");
                DYNAMIC_DATA.put("专业分包商名录-企业编码", GSupplier.FIELD_VALUE.get("专业分包商名录-企业编码"));
                DYNAMIC_DATA.put("专业分包商名录-企业名称", "");
                
                DYNAMIC_DATA.put("专业分包商类别-类别编码", GSupplier.FIELD_VALUE.get("专业分包商类别-类别编码"));
                DYNAMIC_DATA.put("专业分包商黑名单-分包商编码", "");
                DYNAMIC_DATA.put("专业分包商黑名单-分包商名称", "");
				break;
			}
			case "GLease":{
				DYNAMIC_DATA.put("材料需用计划-单据编号", "");
				DYNAMIC_DATA.put("材料需用计划-材料类型编码", GLease.FIELD_VALUE.get("材料需用计划-材料类型编码"));
				DYNAMIC_DATA.put("材料需用计划-材料编码", GLease.FIELD_VALUE.get("材料需用计划-材料编码"));
				DYNAMIC_DATA.put("材料需用计划-本期计划量", GLease.FIELD_VALUE.get("材料需用计划-本期计划量"));
				
				DYNAMIC_DATA.put("周转材料租赁计划-单据编号", "");
				DYNAMIC_DATA.put("周转材料租赁计划-材料类型编码", GLease.FIELD_VALUE.get("材料总量计划-材料类型编码"));
				DYNAMIC_DATA.put("周转材料租赁计划-材料编码", GLease.FIELD_VALUE.get("材料总量计划-材料编码"));
				DYNAMIC_DATA.put("周转材料租赁计划-计划数量", GLease.FIELD_VALUE.get("材料总量计划-计划数量"));
				DYNAMIC_DATA.put("周转材料租赁计划-计费单价", GLease.FIELD_VALUE.get("周转材料租赁计划-计费单价"));
				
				DYNAMIC_DATA.put("周转材料租赁合同-单据编号", "");
				DYNAMIC_DATA.put("周转材料租赁合同-合同名称", GLease.FIELD_VALUE.get("周转材料租赁合同-合同名称"));
				DYNAMIC_DATA.put("周转材料租赁合同-甲方", GLease.FIELD_VALUE.get("周转材料租赁合同-甲方"));
				DYNAMIC_DATA.put("周转材料租赁合同-乙方", GLease.FIELD_VALUE.get("周转材料租赁合同-乙方"));
				DYNAMIC_DATA.put("周转材料租赁合同-计费方式", GLease.FIELD_VALUE.get("周转材料租赁合同-计费方式"));
				DYNAMIC_DATA.put("周转材料租赁合同-进场日期", GLease.FIELD_VALUE.get("周转材料租赁合同-进场日期"));
				DYNAMIC_DATA.put("周转材料租赁合同-出场日期", GLease.FIELD_VALUE.get("周转材料租赁合同-出场日期"));
				DYNAMIC_DATA.put("周转材料租赁合同-租赁天数", GLease.FIELD_VALUE.get("周转材料租赁合同-租赁天数"));
				DYNAMIC_DATA.put("周转材料租赁合同-含税日租单价", GLease.FIELD_VALUE.get("周转材料租赁合同-含税日租单价"));
				DYNAMIC_DATA.put("周转材料租赁合同-含税停租单价", GLease.FIELD_VALUE.get("周转材料租赁合同-含税停租单价"));
				DYNAMIC_DATA.put("周转材料租赁合同-含税赔偿单价", GLease.FIELD_VALUE.get("周转材料租赁合同-含税赔偿单价"));
				DYNAMIC_DATA.put("周转材料租赁合同-数量", GLease.FIELD_VALUE.get("周转材料租赁合同-数量"));
				DYNAMIC_DATA.put("周转材料租赁合同-税率", GLease.FIELD_VALUE.get("周转材料租赁合同-税率"));
				DYNAMIC_DATA.put("周转材料租赁合同-材料类型编码", GLease.FIELD_VALUE.get("周转材料租赁合同-材料类型编码"));
				DYNAMIC_DATA.put("周转材料租赁合同-材料编码", GLease.FIELD_VALUE.get("周转材料租赁合同-材料编码"));
				
				DYNAMIC_DATA.put("租赁周转材料进场单-单据编号", "");
				DYNAMIC_DATA.put("租赁周转材料进场单-供应商", GLease.FIELD_VALUE.get("租赁周转材料进场单-供应商"));
				DYNAMIC_DATA.put("租赁周转材料进场单-使用单位", GLease.FIELD_VALUE.get("租赁周转材料进场单-使用单位"));
				DYNAMIC_DATA.put("租赁周转材料进场单-材料类型编码", GLease.FIELD_VALUE.get("租赁周转材料进场单-材料类型编码"));
				DYNAMIC_DATA.put("租赁周转材料进场单-材料编码", GLease.FIELD_VALUE.get("租赁周转材料进场单-材料编码"));
				
				DYNAMIC_DATA.put("租赁周转材料内部调拨单-单据编号", "");
				DYNAMIC_DATA.put("租赁周转材料内部调拨单-调入单位", GLease.FIELD_VALUE.get("租赁周转材料内部调拨单-调入单位"));
				DYNAMIC_DATA.put("租赁周转材料内部调拨单-调出单位", GLease.FIELD_VALUE.get("租赁周转材料内部调拨单-调出单位"));
				DYNAMIC_DATA.put("租赁周转材料内部调拨单-材料类型编码", GLease.FIELD_VALUE.get("租赁周转材料内部调拨单-材料类型编码"));
				DYNAMIC_DATA.put("租赁周转材料内部调拨单-材料编码", GLease.FIELD_VALUE.get("租赁周转材料内部调拨单-材料编码"));
				DYNAMIC_DATA.put("租赁周转材料内部调拨单-调拨数量", GLease.FIELD_VALUE.get("租赁周转材料内部调拨单-调拨数量"));

				DYNAMIC_DATA.put("租赁周转材料停租单-单据编号", "");
				DYNAMIC_DATA.put("租赁周转材料停租单-供应商", GLease.FIELD_VALUE.get("租赁周转材料停租单-供应商"));
				DYNAMIC_DATA.put("租赁周转材料停租单-材料类型编码", GLease.FIELD_VALUE.get("租赁周转材料停租单-材料类型编码"));
				DYNAMIC_DATA.put("租赁周转材料停租单-材料编码", GLease.FIELD_VALUE.get("租赁周转材料停租单-材料编码"));
				DYNAMIC_DATA.put("租赁周转材料停租单-使用单位", GLease.FIELD_VALUE.get("租赁周转材料停租单-使用单位"));
				DYNAMIC_DATA.put("租赁周转材料停租单-停租单价", GLease.FIELD_VALUE.get("租赁周转材料停租单-停租单价"));
				DYNAMIC_DATA.put("租赁周转材料停租单-停租数量", GLease.FIELD_VALUE.get("租赁周转材料停租单-停租数量"));

				DYNAMIC_DATA.put("租赁周转材料出场单-单据编号", "");
				DYNAMIC_DATA.put("租赁周转材料出场单-供应商", GLease.FIELD_VALUE.get("租赁周转材料出场单-供应商"));
				DYNAMIC_DATA.put("租赁周转材料出场单-使用单位", GLease.FIELD_VALUE.get("租赁周转材料出场单-使用单位"));
				DYNAMIC_DATA.put("租赁周转材料出场单-材料类型编码", GLease.FIELD_VALUE.get("租赁周转材料出场单-材料类型编码"));
				DYNAMIC_DATA.put("租赁周转材料出场单-材料编码", GLease.FIELD_VALUE.get("租赁周转材料出场单-材料编码"));
				DYNAMIC_DATA.put("租赁周转材料出场单-出场数量", GLease.FIELD_VALUE.get("租赁周转材料出场单-出场数量"));
				
				DYNAMIC_DATA.put("周转材料租赁结算单-单据编号", "");
				DYNAMIC_DATA.put("周转材料租赁结算单-供应商", GLease.FIELD_VALUE.get("租赁周转材料结算单-供应商"));
				DYNAMIC_DATA.put("周转材料租赁结算单-供应商名称", GLease.FIELD_VALUE.get("租赁周转材料结算单-供应商名称"));
				DYNAMIC_DATA.put("周转材料租赁结算单-材料类型编码", GLease.FIELD_VALUE.get("租赁周转材料结算单-材料类型编码"));
				DYNAMIC_DATA.put("周转材料租赁结算单-材料编码", GLease.FIELD_VALUE.get("租赁周转材料结算单-材料编码"));
				break;
			}
			case "GPurchaseSettlementStockIn":{
				DYNAMIC_DATA.put("供应商单位", GPurchaseSettlementStockIn.FIELD_VALUE.get("供应商单位"));
				DYNAMIC_DATA.put("参考", GPurchaseSettlementStockIn.FIELD_VALUE.get("参考"));
				DYNAMIC_DATA.put("材料需用计划-单据编号", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料需用计划-单据编号"));
				DYNAMIC_DATA.put("材料需用计划-材料类型编码", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料需用计划-材料类型编码"));
				DYNAMIC_DATA.put("材料需用计划-材料编码", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料需用计划-材料编码"));
				DYNAMIC_DATA.put("材料需用计划-本期计划量", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料需用计划-本期计划量"));
				DYNAMIC_DATA.put("材料需用计划-本期计划量-剩余数量", "0");
				
				DYNAMIC_DATA.put("材料入库单-单据编号", "");
				DYNAMIC_DATA.put("材料入库单-供应商", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料入库单-供应商"));
				DYNAMIC_DATA.put("材料入库单-材料类型编码", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料入库单-材料类型编码"));
				DYNAMIC_DATA.put("材料入库单-材料编码", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料入库单-材料编码"));
				DYNAMIC_DATA.put("材料入库单-材料明细-含税单价", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料入库单-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料入库单-材料明细-数量", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料入库单-材料明细-数量"));
				DYNAMIC_DATA.put("材料入库单-材料明细-税率(%)", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料入库单-材料明细-税率(%)"));
				
				DYNAMIC_DATA.put("材料采购结算单-单据编号", "");
				DYNAMIC_DATA.put("材料采购结算单-供应商", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料采购结算单-供应商"));
				DYNAMIC_DATA.put("材料采购结算单-材料明细-含税结算单价", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料采购结算单-材料明细-含税结算单价"));
				DYNAMIC_DATA.put("材料采购结算单-材料明细-结算数量", GPurchaseSettlementStockIn.FIELD_VALUE.get("材料采购结算单-材料明细-结算数量"));
				DYNAMIC_DATA.put("材料采购结算单-材料明细-税率(%)", GDemandPlanQuantityOccupancy.FIELD_VALUE.get("材料采购结算单-材料明细-税率(%)"));
				break;
			}
			case "GMaterialPlan":{
				DYNAMIC_DATA.put("材料需用计划-单据编号", "");
				DYNAMIC_DATA.put("材料需用计划-材料类型编码", GMaterialPlan.FIELD_VALUE.get("材料需用计划-材料类型编码"));
				DYNAMIC_DATA.put("材料需用计划-材料编码", GMaterialPlan.FIELD_VALUE.get("材料需用计划-材料编码"));
				DYNAMIC_DATA.put("材料需用计划-本期计划量", GMaterialPlan.FIELD_VALUE.get("材料需用计划-本期计划量"));
				
				DYNAMIC_DATA.put("材料总量计划-单据编号", "");
				DYNAMIC_DATA.put("材料总量计划-材料类型编码", GMaterialPlan.FIELD_VALUE.get("材料总量计划-材料类型编码"));
				DYNAMIC_DATA.put("材料总量计划-材料编码", GMaterialPlan.FIELD_VALUE.get("材料总量计划-材料编码"));
				DYNAMIC_DATA.put("材料总量计划-计划数量", GMaterialPlan.FIELD_VALUE.get("材料总量计划-计划数量"));
				
				DYNAMIC_DATA.put("材料部位计划-单据编号", "");
				DYNAMIC_DATA.put("材料部位计划-材料类型编码", GMaterialPlan.FIELD_VALUE.get("材料部位计划-材料类型编码"));
				DYNAMIC_DATA.put("材料部位计划-材料编码", GMaterialPlan.FIELD_VALUE.get("材料部位计划-材料编码"));
				DYNAMIC_DATA.put("材料部位计划-部位名称", GMaterialPlan.FIELD_VALUE.get("材料部位计划-部位名称"));
				DYNAMIC_DATA.put("材料部位计划-计划数量", GMaterialPlan.FIELD_VALUE.get("材料部位计划-计划数量"));
				
				DYNAMIC_DATA.put("材料甲供计划-单据编号", "");
				DYNAMIC_DATA.put("材料甲供计划-材料类型编码", GMaterialPlan.FIELD_VALUE.get("材料甲供计划-材料类型编码"));
				DYNAMIC_DATA.put("材料甲供计划-材料编码", GMaterialPlan.FIELD_VALUE.get("材料甲供计划-材料编码"));
				DYNAMIC_DATA.put("材料甲供计划-本期计划量", GMaterialPlan.FIELD_VALUE.get("材料甲供计划-本期计划量"));
				break;
			}
			case "GMaterialPurchase":{
				DYNAMIC_DATA.put("材料采购计划-单据编号", "");
				DYNAMIC_DATA.put("材料采购计划-材料类型编码", GMaterialPurchase.FIELD_VALUE.get("材料采购计划-材料类型编码"));
				DYNAMIC_DATA.put("材料采购计划-材料编码", GMaterialPurchase.FIELD_VALUE.get("材料采购计划-材料编码"));
				DYNAMIC_DATA.put("材料采购计划-材料明细-计划单价", GMaterialPurchase.FIELD_VALUE.get("材料采购计划-材料明细-计划单价"));
				DYNAMIC_DATA.put("材料采购计划-材料明细-本次计划量", GMaterialPurchase.FIELD_VALUE.get("材料采购计划-材料明细-本次计划量"));
				
				DYNAMIC_DATA.put("材料采购比价单-单据编号", "");
				DYNAMIC_DATA.put("材料采购比价单-材料类型编码", GMaterialPurchase.FIELD_VALUE.get("材料采购比价单-材料类型编码"));
				DYNAMIC_DATA.put("材料采购比价单-材料编码", GMaterialPurchase.FIELD_VALUE.get("材料采购比价单-材料编码"));
				DYNAMIC_DATA.put("材料采购比价单-材料明细-数量", GMaterialPurchase.FIELD_VALUE.get("材料采购比价单-材料明细-数量"));
				
				DYNAMIC_DATA.put("材料采购订单-单据编号", "");
				DYNAMIC_DATA.put("材料采购订单-供应商", GMaterialPurchase.FIELD_VALUE.get("材料采购订单-供应商"));
				DYNAMIC_DATA.put("材料采购订单-材料类型编码", GMaterialPurchase.FIELD_VALUE.get("材料采购订单-材料类型编码"));
				DYNAMIC_DATA.put("材料采购订单-材料编码", GMaterialPurchase.FIELD_VALUE.get("材料采购订单-材料编码"));
				DYNAMIC_DATA.put("材料采购订单-材料明细-含税单价", GMaterialPurchase.FIELD_VALUE.get("材料采购订单-材料明细-含税单价"));
				DYNAMIC_DATA.put("材料采购订单-材料明细-数量", GMaterialPurchase.FIELD_VALUE.get("材料采购订单-材料明细-数量"));
				DYNAMIC_DATA.put("材料采购订单-材料明细-税率(%)", GMaterialPurchase.FIELD_VALUE.get("材料采购订单-材料明细-税率(%)"));
				
				DYNAMIC_DATA.put("运杂费记录单-单据编号", "");
				DYNAMIC_DATA.put("运杂费记录单-往来单位", GMaterialPurchase.FIELD_VALUE.get("运杂费记录单-往来单位"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-费用项名称", GMaterialPurchase.FIELD_VALUE.get("运杂费记录单-费用项明细-费用项名称"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-含税单价", GMaterialPurchase.FIELD_VALUE.get("运杂费记录单-费用项明细-含税单价"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-数量", GMaterialPurchase.FIELD_VALUE.get("运杂费记录单-费用项明细-数量"));
				DYNAMIC_DATA.put("运杂费记录单-费用项明细-税率(%)", GMaterialPurchase.FIELD_VALUE.get("运杂费记录单-费用项明细-税率(%)"));
				
				DYNAMIC_DATA.put("物资合同交底-单据编号", "");
				
				DYNAMIC_DATA.put("运杂费结算单-单据编号", "");
				DYNAMIC_DATA.put("运杂费结算单-结算单位", GMaterialPurchase.FIELD_VALUE.get("运杂费结算单-结算单位"));
				DYNAMIC_DATA.put("运杂费结算单-费用明细-含税结算金额", GMaterialPurchase.FIELD_VALUE.get("运杂费结算单-费用明细-含税结算金额"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-费用项名称", GMaterialPurchase.FIELD_VALUE.get("运杂费结算单-其他费用-费用项名称"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-含税单价", GMaterialPurchase.FIELD_VALUE.get("运杂费结算单-其他费用-含税单价"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-数量", GMaterialPurchase.FIELD_VALUE.get("运杂费结算单-其他费用-数量"));
				DYNAMIC_DATA.put("运杂费结算单-其他费用-税率(%)", GMaterialPurchase.FIELD_VALUE.get("运杂费结算单-其他费用-税率(%)"));
				
				DYNAMIC_DATA.put("材料付款申请单-单据编号", "");
				DYNAMIC_DATA.put("材料付款申请单-收款单位", GMaterialPurchase.FIELD_VALUE.get("材料付款申请单-收款单位"));
				
				DYNAMIC_DATA.put("材料最终结算单-供应商", GMaterialPurchase.FIELD_VALUE.get("材料最终结算单-供应商"));
				break;
			}
			
			default:{
				break;
			}	
		}
		
		GLog.logRecord(9, "系统提示", "res", "业务场景[" + sceneName + "]", 6000, 0, 0, "", "微软雅黑", 24, Color.BLUE);
	}
	
	/**
	 *  单据数量增加
	 *  
	 *  @param DynamicDataName 动态数据名称
	 *  @param DynamicDataCode 单据编号
	 */
	public static void billCountPlus(String DynamicDataName, String DynamicDataCode) {
		long dynamicDataCount = 0;
		//获得当前单据数量
		dynamicDataCount = Integer.valueOf(DYNAMIC_DATA.get(DynamicDataName)).longValue();
		//当前单据数量加1
		dynamicDataCount++;
		//加1后替换原数量
		DYNAMIC_DATA.replace(DynamicDataName, String.valueOf(dynamicDataCount));
		//添加新记录
		DYNAMIC_DATA.put(DynamicDataName + "-" + String.valueOf(dynamicDataCount), DynamicDataCode);
	}
	
	/**
	 *  材料数量增加
	 *  
	 *  @param DynamicDataName 动态数据名称
	 *  @param count 增加数量
	 */
	public static void materialCountPlus(String DynamicDataName, String count) {
		long dynamicDataCount = 0L;
		//获得当前单据数量
		dynamicDataCount = Integer.valueOf(DYNAMIC_DATA.get(DynamicDataName)).longValue();
		//当前单据数量增加
		dynamicDataCount = dynamicDataCount + Integer.valueOf(count).longValue();
		//增加后替换原数量
		DYNAMIC_DATA.replace(DynamicDataName, String.valueOf(dynamicDataCount));
	}
	
	/**
	 *  材料占位状态验证
	 */
	public static void materialCountStatusVerify() {
		GLog.logRecordTime(9, "[算法]占位状态=占位数量-本期计划量");
		GLog.logRecordTime(9, "[本期计划量]" + DYNAMIC_DATA.get("材料需用计划-本期计划量"));
		GLog.logRecordTime(9, "[已占位数量]" + DYNAMIC_DATA.get("材料采购合同-材料明细-已占位数量"));

		long dr = Integer.valueOf(DYNAMIC_DATA.get("材料采购合同-材料明细-已占位数量")).longValue();
		long dc = Integer.valueOf(DYNAMIC_DATA.get("材料需用计划-本期计划量")).longValue();
		long content = dr - dc;
		
		try {
			if(content + dc <= 0L) {
				GLog.logRecordTime(9, "材料采购合同-材料明细-已占位数量-未占位");
			}else if(content + dc > 0L && content < 0L) {
				GLog.logRecordTime(9, "材料采购合同-材料明细-已占位数量-占位未满");
			}else if(content == 0L) {
				GLog.logRecordTime(9, "材料采购合同-材料明细-已占位数量-占位刚满");
			}else if(content > 0L) {
				GLog.logRecordTime(9, "材料采购合同-材料明细-已占位数量-占位超限");
				throw new Exception("材料采购合同-材料明细-已占位数量-占位超限");
			}
		}catch(Exception e){
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
	}
	
	/**
	 *  材料剩余状态验证
	 */
	public static void materialCountSurplusVerify() {
		GLog.logRecordTime(9, "[算法]剩余数量=本期计划量-已占位数量");
		GLog.logRecordTime(9, "[本期计划量]" + DYNAMIC_DATA.get("材料需用计划-本期计划量"));
		GLog.logRecordTime(9, "[已占位数量]" + DYNAMIC_DATA.get("材料采购合同-材料明细-已占位数量"));

		long dr = Integer.valueOf(DYNAMIC_DATA.get("材料采购合同-材料明细-已占位数量")).longValue();
		long dc = Integer.valueOf(DYNAMIC_DATA.get("材料需用计划-本期计划量")).longValue();
		long content = dc - dr;
		
		try {
			long ac = Long.valueOf(DYNAMIC_DATA.get("材料需用计划-本期计划量-剩余数量"));
			
			if(content == ac) {
				GLog.logRecordTime(9, "[剩余数量]" + String.valueOf(ac));
			}else {
				GLog.logRecordTime(9, "已占位数量错误");
			}
		}catch(Exception e){
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
	}
}
