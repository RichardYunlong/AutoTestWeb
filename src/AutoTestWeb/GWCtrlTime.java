package AutoTestWeb;

import AutoTest.GLog;

/**
 *  时间处理功能
 */
public class GWCtrlTime {
	private static int Timer = 0;
	
	/**
	 *  根据时间暂停，单位为秒(s)
	 *  @param mtime
	 */
	public static void Pause(int mtime) {
		GLog.logRecordTime(8, "等待" + mtime + "秒后再作处理");
		for(int i = mtime;i >= 0;i--) {
			try {
				Thread.sleep(1000);
				GLog.logRecordTime(8, "还剩" + i + "秒");
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "Pause Failed", true);
			}
		}
	}
	
	/**
	 *  定义Timer
	 */
	public static void setTimer(int dTime) {
		Timer = dTime;
		GLog.logRecordTime(8, "计时" + Timer + "秒");
	}
	
	/**
	 *  定义Timer
	 */
	public static int getTimer() {
		return Timer;
	}
	
	/**
	 *  Timer加1秒，单位为秒(s)
	 */
	public static int TimerPlus() {
		Timer++;
		if(Timer == 0) {
			GLog.logRecordTime(8, "计时结束");
			return 0;
		}else if(Timer < -30000) {
			GLog.logRecordTime(8, "计时格式错误");
			return -1;
		}else {
			GLog.logRecordTime(8, "还剩" + String.valueOf(Timer) + "秒");	
		}
		return Timer;
	}
	
	/**
	 *  Timer减1秒，单位为秒(s)
	 */
	public static int TimerMinus() {
		Timer--;
		if(Timer == 0) {
			GLog.logRecordTime(8, "计时结束");
			return 0;
		}else if(Timer < -30000) {
			GLog.logRecordTime(8, "计时格式错误");
			return -1;
		}else {
			GLog.logRecordTime(8, "还剩" + String.valueOf(Timer) + "秒");
		}
		return Timer;
	}
}
