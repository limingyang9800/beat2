
package com.yun.beat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yun.beat.bean.ScheduleJobLog;
import com.yun.beat.bean.ScheduleJobLogExample;
import com.yun.beat.dao.ScheduleJobLogMapper;
import com.yun.beat.service.ScheduleJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ScheduleJobLogServiceImpl implements ScheduleJobLogService {


	@Autowired
	private ScheduleJobLogMapper scheduleJobLogMapper;

	@Override
	public PageInfo queryPage(Map<String, Object> params) {
		Object jobId = params.get("jobId");
		int page = Integer.parseInt(params.getOrDefault("page", "1").toString());
		int pageSize = Integer.parseInt(params.getOrDefault("pageSize", "10").toString());

		PageHelper.startPage(page,pageSize);
		ScheduleJobLogExample scheduleJobLogExample = new ScheduleJobLogExample();
		ScheduleJobLogExample.Criteria criteria = scheduleJobLogExample.createCriteria();
		if (Objects.nonNull(jobId)) {
			criteria.andJobIdEqualTo(Long.parseLong(jobId.toString()));
		}

		List<ScheduleJobLog> scheduleJobLogs = scheduleJobLogMapper.selectByExample(scheduleJobLogExample);
		PageInfo pageInfo = new PageInfo<>(scheduleJobLogs);
		return pageInfo;
	}

}
