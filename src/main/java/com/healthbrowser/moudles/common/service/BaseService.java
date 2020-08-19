package com.healthbrowser.moudles.common.service;


import com.healthbrowser.moudles.common.domain.BaseDomain;

public interface BaseService<T extends BaseDomain> {


    //保存数据（插入或更新）
    public void save(T entity);
    //删除数据
    public void delete(String id);
    //获取数据
    public T get(String id);

}
