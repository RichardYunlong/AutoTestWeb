package AutoTestWeb;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import AutoTest.GParam;
import AutoTest.GTestMission;
import AutoTest.GTime;
import io.qameta.allure.Step;

/**
 *  BI概要
 */
public class GWCtrlSummoryBI {
	
	/**
	 *  被测件版本号
	 */
	public static String TAR_VERSION = "";
	
	/**
	 *  被测件概述
	 */
	public static String TAR_SCR = "";
	
	/**
	 *  测试执行时间时间
	 */
	public static String TAR_DATE = "";
	
	/**
	 *  测试时间
	 */
	public static SimpleDateFormat TAR_DATEFORMAT = null;
	
	/**
	 *  测试开始时间
	 */
	public static String TAR_STARTDATE = "";
	
	/**
	 *  测试结束时间
	 */
	public static String TAR_ENDDATE = "";
	
	/**
	 *  测试耗时
	 */
	public static String TAR_SPENDTIME = "";
	
	/**
	 *  读取用例总数
	 */
	public static Integer TAR_LOADTOTALNO = 0;
	
	/**
	 *  执行用例总数
	 */
	public static Integer TAR_RUNTOTALNO = 0;
	
	/**
	 *  成功数
	 */
	public static Integer TAR_SUCCESS = 0;
	
	/**
	 *  失败数
	 */
	public static Integer TAR_FAILED = 0;
	
	
	/**
	 *  各类用例数占总用例数份额：0-执行用例总数；1-正常场景用例执行数；2-失败场景用例执行数；3-错误码场景用例执行数；4-异常中断场景用例执行数
	 */
	public static float[] Proportion_Total = {1.00f, 0.25f, 0.25f, 0.25f, 0.25f};
	
	/**
	 *  各类用例数占总用例数份额String类型：0-执行用例总数；1-正常场景用例执行数；2-失败场景用例执行数；3-错误码场景用例执行数；4-异常中断场景用例执行数
	 */
	public static String[] strProportion_Total = {"1.00", "0.25", "0.25", "0.25", "0.25"};
	
	/**
	 *  各类用例数实际执行失败数
	 */
	public static String[] strFailNum_Each = {"0", "0", "0", "0", "0"};
	
	/**
	 *  报告表格
	 *  <序号, 处理结果>
	 */
	public static Map<Integer, String> monitorBI = new HashMap<Integer, String>();
	
	/**
	 *  序号游标
	 */
	public static int biIndex = 0;

	/**
	 *  计算各类用例数占总用例数份额
	 */
	@Step("计算各类用例数占总用例数份额")
	private static void CalculateProportionTotal() {
		
		if(TAR_RUNTOTALNO > 0) {
			Proportion_Total[0] = (float)(
					(TAR_SUCCESS.floatValue() + TAR_FAILED.floatValue())
					/(TAR_RUNTOTALNO.floatValue()));
			Proportion_Total[1] = (float)(TAR_SUCCESS.floatValue()/(TAR_RUNTOTALNO.floatValue()));
			Proportion_Total[2] = (float)(TAR_FAILED.floatValue()/(TAR_RUNTOTALNO.floatValue()));
			Proportion_Total[3] = (float)(0.0);
			Proportion_Total[4] = (float)(0.0);
		}
		
		for(int i = 0; i<Proportion_Total.length; i++) {
			strProportion_Total[i] = String.valueOf(Proportion_Total[i]);
		}
		
	}
	
	/**
	 *  计数增加
	 *  
	 *  @param nIndex 序号
	 *  @param biInfo bi信息内容
	 *  @param bRes bi有效性标记
	 */
	@Step("计数增加")
	public static void addBIInfo(String biInfo, boolean bRes){
		
		if(GWCtrlSummoryBI.monitorBI.get(Integer.valueOf(biIndex)) != null){
			GWCtrlSummoryBI.monitorBI.replace(Integer.valueOf(biIndex), biInfo);
		}else {
			GWCtrlSummoryBI.monitorBI.put(Integer.valueOf(biIndex), biInfo);
		}
		
		if(bRes) {
			TAR_SUCCESS++;
		}else {
			TAR_FAILED++;
		}
		
		biIndex++;
	} 
	
	/**
	 *  加载概要
	 */
	@Step("加载报告摘要")
	public static void LoadSummary() {
		TAR_VERSION = GParam.strTestVersion;
		TAR_SCR = "广联达企业BI数据集有效性监控报告";
		TAR_DATE = GTime.getCurrentTime(GTime.FORMAT_14_TEXT);
		TAR_DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TAR_STARTDATE = TAR_DATEFORMAT.format(GTestMission.startSysTime);
		TAR_ENDDATE = TAR_DATEFORMAT.format(GTestMission.endSysTime);
		TAR_SPENDTIME = String.valueOf(GTestMission.endSysTime - GTestMission.startSysTime) + "MS";
		TAR_LOADTOTALNO = TAR_SUCCESS + TAR_FAILED;
		TAR_RUNTOTALNO = TAR_SUCCESS + TAR_FAILED;
		
		CalculateProportionTotal();
	}
}
