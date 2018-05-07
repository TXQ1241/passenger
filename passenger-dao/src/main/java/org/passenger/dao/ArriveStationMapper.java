package org.passenger.dao;

import java.util.List;
import org.passenger.pojo.ArriveStation;
import org.passenger.vo.ArriveVo;
import org.springframework.stereotype.Repository;

@Repository("arriveMapper")
public interface ArriveStationMapper {
	
	List<ArriveStation> getArriveStationList(ArriveVo arriveVo);
	
	int getArriveStationCount(ArriveVo arriveVo);

    int insert(ArriveStation record);

    int update(ArriveStation record);
    
    void deleteArriveStationByIds(String[] ids);
}