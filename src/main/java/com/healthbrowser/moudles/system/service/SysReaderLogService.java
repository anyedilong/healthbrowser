package com.healthbrowser.moudles.system.service;


import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.BaseService;
import com.healthbrowser.moudles.system.domain.SysReaderLog;


public interface SysReaderLogService extends BaseService<SysReaderLog>{


    //获取调阅日志数据(分页)
    void queryReaderLogPage(SysReaderLog sysReaderLog, PageModel page);

}
