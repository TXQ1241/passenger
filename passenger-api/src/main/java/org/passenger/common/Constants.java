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
    
    /**
     *  @Description: 用户管理常量接口
     *  @author admin
     **/
    public interface UserConstants {
        /**
         * 用户类型
         */
        String SYSTEM_ADMIN = "0"; //系统管理员
        String GENERAL_USER = "1"; //普通用户
        String STATION = "2"; //车站管理
        String CARTRIP = "3"; //车次管理
        
    }
    
    /**
     * 线路常量
     * @author Administrator
     *
     */
    public interface RouteConstants {
    	/**
    	 * 路线中涉及的参数
    	 */
    	String CAR_TRIP_ID = "carTripId";
    }
    
    /**
     * 票数常量
     * @author Administrator
     *
     */
    public interface TicketConstants {
    	/**
    	 * 线路id
    	 */
    	String ROUTE_ID = "routeId";
    }
	
}
