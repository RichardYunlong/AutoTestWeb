package AutoTestWeb;

/**
 *  用例管理
 */
public class GTestCase {
	
	/**
	 *  用例名称或简单描述
	 */
	private static String TestScripstion = "";
	
	/**
	 * 设置用例名称或简单描述
	 */
	public static void setTestScripstion(String src) {
		TestScripstion = src;
	}
	
	/**
	 * 获得用例名称或简单描述
	 */
	public static String getTestScripstion() {
		return TestScripstion;
	}
}
