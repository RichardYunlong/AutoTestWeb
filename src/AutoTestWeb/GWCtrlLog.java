package AutoTestWeb;

import java.io.File;

import org.openqa.selenium.OutputType;

import AutoTest.GFile;
import AutoTest.GLog;
import AutoTest.GPath;
import AutoTest.GTestCase;

/**
 *  日志处理
 */
public class GWCtrlLog {
	
	/**
	 *  默认截图或视频序号，每次保存成功后加1，用于区别结果
	 */
	public static int dSaveAsIndex = 0;
	
	/**
	 *  截屏
	 *  @param 保存文件名
	 */
	public static void TakesScreenshot(String imgName) {
		File srcFile = null;
		try {
			srcFile = ((org.openqa.selenium.TakesScreenshot) GParam.g_Dr).getScreenshotAs(OutputType.FILE);
			GFile.creatDir(GPath.IMAGE_PATH + GTestCase.getTestCaseSpt());
			if(imgName.equals("")) {
				imgName = "unNamed" + "_" + String.valueOf(dSaveAsIndex);
			}
			GFile.copyFile(srcFile, GPath.IMAGE_PATH + GTestCase.getTestCaseSpt(), GTestCase.getTestCaseSpt() + imgName);
			dSaveAsIndex++;
			GLog.logRecordTime(8, "保存截屏日志:" + GTestCase.getTestCaseSpt() + imgName);
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "截图失败", true);
		}
	}
}
