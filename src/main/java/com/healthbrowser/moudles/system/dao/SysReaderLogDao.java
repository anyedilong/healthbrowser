package com.healthbrowser.moudles.system.dao;


import javax.inject.Named;

import com.healthbrowser.moudles.common.dao.BaseDao;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.dao.repository.SysReaderLogRepository;
import com.healthbrowser.moudles.system.domain.SysReaderLog;
import com.healthbrowser.until.StringUtil;

@Named
public class SysReaderLogDao extends BaseDao<SysReaderLogRepository, SysReaderLog> {

	/**
	 * @Description: 调阅日志分页查询
	 * @param @param SysReaderLog
	 * @param @param page
	 * @return void
	 * @throws
	 */
	public void queryReaderLogPage(SysReaderLog sysReaderLog, PageModel page) {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.* ");
		sql.append(" from sys_reader_log a");
		sql.append(" where 1 = 1 ");
		if (!StringUtil.isNull(sysReaderLog.getReaderName())) {
			sql.append(" and a.reader_name like concat('%', concat(:readerName, '%')) ");
		}
		if(!StringUtil.isNull(sysReaderLog.getStartTime())) {
			sql.append(" and a.reader_time >= to_date(:startTime, 'yyyy-mm-dd') ");
		}
		if(!StringUtil.isNull(sysReaderLog.getEndTime())) {
			sql.append(" and a.reader_time <= (to_date(:endTime, 'yyyy-mm-dd')+1) ");
		}
		sql.append(" order by a.reader_time desc ");
		queryPage(sql.toString(), sysReaderLog, page, SysReaderLog.class);
	}
}
