package org.passenger.service;

import org.passenger.pojo.ArriveStation;
import org.passenger.vo.ArriveVo;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public interface IArriveStationService {

    /**
     * 获取到达站信息
     * @param arrvieVo
     * @return
     */
    List<ArriveVo> getStations(ArriveVo arrvieVo);

    /**
     * 获取到达站记录数
     * @param arrvieVo
     * @return
     */
    Integer getStationCount(ArriveVo arrvieVo);

    /**
     * 保存站点信息及其相关信息
     * @param arriveVo
     */
    void saveArriveStation(ArriveVo arriveVo);

    /**
     * 保存站点信息
     * @param arriveStation
     */
    void save(ArriveStation arriveStation);

    /**
     * 批量删除站点信息
     * @param ids
     */
    void deleteArriveByIds(String [] ids);
}
