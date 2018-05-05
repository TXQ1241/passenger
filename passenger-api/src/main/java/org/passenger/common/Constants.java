package org.passenger.common;

/**项目中所用常量定义
 * 
 * @author Administrator
 *
 */
public class Constants {

	public static final String CURRENT_USER = "user";
    public static final String ZERO = "0";
    public static final String ONE = "1";
    public static final Integer ZERO_NUM = 0;
	
    /**
     * 请求状态定义
     * @author admin
     */
    public interface AjaxStatus {
         String AJAX_SUCCESS = "1";//请求成功
         String AJAX_FAIL = "0";//请求失败
    }
    
    /**
     *  数据请求状态码
     *  @author admin
     **/
    public interface DataCode {
        String FAIL = "0";//失败
        String SUCCESS = "1";//成功
    }
	
}
