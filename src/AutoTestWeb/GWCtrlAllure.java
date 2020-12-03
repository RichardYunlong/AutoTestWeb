package AutoTestWeb;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;

/**
 * Allure测试报告美化
 * 
 * @Epic -Epics可用作您的产品或项目的大量需求的占位符。Epic将在适当的时候分为较小的用户故事。
 *用户故事可以拆分为较小的任务，并且可以是较大的Feature和Epic的一部分。
	@Epic
	@Features
	//是一个标注信息注解，但是改标注可以把相同的标注统一到相同模块下用于筛选
	@Stories/@Story
	//使用@Severity批注测试缺陷等级，例如BLOCKER（阻断），CRITICAL（警告），NORMAL（常规），MINOR（轻微），TRIVIAL（提示）
	@Severity(SeverityLevel.BLOCKER)
	//测试方法描述
	@Description("测试流程描述")
	//@Step注释是对任何（公共，私有，受保护）对任何方法进行注释。例如- @Step（“输入{0}和{1}”）
	@Step
	//@Attachment-附件只是带有注释的方法，@Attachment该方法返回String或byte []，应将其添加到报表中。我们可以将故障屏幕截图作为附件
	@Attachment
	//@Links-我们可以将测试链接到某些资源，例如TMS（测试管理系统）或错误跟踪器。将测试用例链接到测试方法总是有帮助的。
	@Link
*/
public class GWCtrlAllure {
	@Attachment("截图")
    public static byte[] makeScreenShot() {
         return ((TakesScreenshot) GParam.g_Dr).getScreenshotAs(OutputType.BYTES);
    }
 
    @Attachment("截图[{0}]")
    public static byte[] makeScreenShot(String strMark) {
        return ((TakesScreenshot) GParam.g_Dr).getScreenshotAs(OutputType.BYTES);
    }
    
    @Attachment("备注")
    public static String makeAttach() {
    	return "默认为空";
    }
 
    @Attachment("备注[{0}]")
    public static String makeAttach(String strMark) {
    	return strMark;
    }
    
    @Issue("csv")
    @Attachment(value = "Sample csv attachment", type = "text/csv")
    public byte[] saveCsvAttachment() throws URISyntaxException, IOException {
    	URL resource = getClass().getClassLoader().getResource("sample.csv");
    	if (resource == null) {
    		System.out.println("不能打开资源文件 'sample.csv'");
    	}
    	return Files.readAllBytes(Paths.get(resource.toURI()));
    }
}
