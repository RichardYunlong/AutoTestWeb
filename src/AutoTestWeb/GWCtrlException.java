package AutoTestWeb;

import AutoTest.GException;
import AutoTest.GLog;

/**
 *  顶层页签
 */
public class GWCtrlException {

	/**
	 *  切换用例类型 当切换的用例类型后，用例执行结果的处理方式将按照切换后的类型进行处理
	 *  
	 *  @param e 所有异常
	 *  @param dTSStyle 切换至用例类型：1-失败；2-错误码；3-异常中断
	 *  @param logIndex 记录到的日志编号
	 *  @param eMsg 用例信息
	 *  @param bScreenShot 是否截图
	 *  
	 *  @return b2TSStyle 是否切换成功 true-切换成功，false-切换失败
	 */
	public static boolean SwtichTo (Exception e, int dTSStyle, int logIndex, String eMsg, boolean bScreenShot) {
		boolean b2TSStyle = false;
		
		
		try {
			//记录当前测试步骤信息至控制台和日志文件
			GLog.logRecordTime(logIndex, eMsg);
			//控制台打印错误堆栈信息
			e.printStackTrace();
			//用例类型判断
			if (AutoTest.GTestCase.dTSSTYLE == 1) {
				//如果预制的用例类型就是1，即失败用例，将错误堆栈信息作为返回信息
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			}else {
				//如果预制的用例类型不是1，即测试用例执行失败是计划外的，需要将测试用例类型置为1，即转变为失败用例，供用例执行完成后的数量变更
				AutoTest.GTestCase.dTSSTYLE = Integer.valueOf(1);
			}
			//需要截图时截图
			if(bScreenShot) {
				GWCtrlAllure.makeScreenShot(eMsg);
			}
			
			b2TSStyle = true;
		}catch (Exception ex) {
			b2TSStyle = false;
			GLog.logRecordTime(8, "用例类型切换失败，用例执行结果可能无法正常保存，请执行静态审查");
			e.printStackTrace();
		}
		
		return b2TSStyle;
	}
}
