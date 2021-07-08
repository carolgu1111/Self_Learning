package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

import java.util.List;

public interface ICMSTypeService {
    //读取记录并返回
    List<CMSType> selectCMSTypeList(CMSType type);

    //校验名字唯一性
    String checkTypeNameUnique(CMSType type);

    //添加
    int addCMSType(CMSType type);

    //根据id显示CMSType
    CMSType selectCMSTypeById(Long typeId);
    //更新type
    int updateCMSType(CMSType type);


    int removeCMSTypeByIds(String ids);
}

