package com.healthbrowser.config.filter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.archive.dto.JbxxjlbDto;
import com.healthbrowser.moudles.system.dao.SysReaderLogDao;
import com.healthbrowser.moudles.system.domain.SysReaderLog;
import com.healthbrowser.moudles.system.domain.SysUser;
import com.healthbrowser.until.UUIDUtil;
import com.healthbrowser.until.cache.EhCacheEmun;
import com.healthbrowser.until.cache.EhCacheUtils;

@Aspect
@Component
public class ReaderLogControllerAop {

	@Autowired
	private SysReaderLogDao sysReaderLogDao;
	
	/**
     * 指定切点
     * 匹配 com.example.demo.controller包及其子包下的所有类的所有方法
     */
	@Pointcut("execution(public * com.healthbrowser.moudles.residenthealth.archive.controller.*.*(..))")
	public void optlog(){
		//System.out.print("执行了");
	}
	
	/**
     * 处理完请求返回内容
     * @param ret
     * @throws Throwable
     */
	@AfterReturning(value = "within(com.healthbrowser.moudles.residenthealth.archive.controller.*)", returning = "ret")
	public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
		//代理的是哪一个方法
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		if("getArchiveDetail".equals(methodName) || "getArchiveDetailBySfzh".equals(methodName)) {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		    HttpServletRequest request = attributes.getRequest();
			String auth = StatelessParams.getAuth(request);
			//获取调阅者
			SysUser reader = (SysUser) EhCacheUtils.get(EhCacheEmun.SYS_CACHE, auth);
			JsonResult retModel = (JsonResult)ret;
			JbxxjlbDto archiveInfo = (JbxxjlbDto)retModel.getData();
			if(archiveInfo != null) {
				//组装调阅日志实体
				SysReaderLog log = new SysReaderLog();
				log.setId(UUIDUtil.getUUID());
				log.setReaderName(reader.getName());
				log.setName(archiveInfo.getHzmc());
				log.setReaderTime(new Date());
				log.setRemark(reader + "于" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "调阅" + archiveInfo.getHzmc() + "健康数据");
				sysReaderLogDao.save(log);
			}
		}
	}
	
}
