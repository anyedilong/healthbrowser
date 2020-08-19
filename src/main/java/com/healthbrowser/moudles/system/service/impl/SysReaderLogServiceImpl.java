package com.healthbrowser.moudles.system.service.impl;


import javax.inject.Named;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.impl.BaseServiceImpl;
import com.healthbrowser.moudles.system.dao.SysReaderLogDao;
import com.healthbrowser.moudles.system.domain.SysReaderLog;
import com.healthbrowser.moudles.system.service.SysReaderLogService;

@Named
public class SysReaderLogServiceImpl extends BaseServiceImpl<SysReaderLogDao, SysReaderLog> implements SysReaderLogService {


    @Override
    public void queryReaderLogPage(SysReaderLog sysReaderLog, PageModel page) {
       dao.queryReaderLogPage(sysReaderLog, page);
    }

}
