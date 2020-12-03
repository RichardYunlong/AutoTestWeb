package AutoTestScene;

import java.util.HashMap;
import java.util.Map;


public class GSupplier {
    
    /**
     * 全局关键参数值
     */
    public static Map<String, String> FIELD_VALUE = null;
    
    public GSupplier(){
        
        FIELD_VALUE = new HashMap<String, String>();
        
        FIELD_VALUE.put("劳务分包商名录-分包商编码", "GATJT-LWFBSML-202011-0001");
        FIELD_VALUE.put("劳务分包商类别-类别编码", "LWFBS");
        
        FIELD_VALUE.put("专业分包商名录-企业编码", "GATJT-ZYFBSML-202011-0001");
        FIELD_VALUE.put("专业分包商类别-类别编码", "ZYFBS");
      
    }

}
