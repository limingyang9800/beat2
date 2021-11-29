package com.yun.beat.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleJobExtandMapper {

    int updateBatch(@Param("ids") List ids, @Param("status") int status);

    int deleteBatch(@Param("ids") List<Long> ids);
}
