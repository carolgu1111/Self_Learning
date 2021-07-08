package com.ruoyi.project.ums.employed.service;

import com.ruoyi.project.ums.employed.domain.UMSEmployed;

import java.util.List;

public interface IUMSEmployedSrevice {

    List<UMSEmployed> selectUMSEmployedList(UMSEmployed umsEmployed);

    String checkEmployedNameUnique(UMSEmployed umsEmployed);

    int addUMSEmployed(UMSEmployed umsEmployed);

    UMSEmployed selectUMSEmployedById(Long Id);

    //更新
    int updateUMSEmployed(UMSEmployed umsEmployed);

    int deleteUMSEmployedByIds(String ids);
}
