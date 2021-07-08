package com.ruoyi.project.ums.employed.mapper;

import com.ruoyi.project.ums.employed.domain.UMSEmployed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UMSEmployedMapper {
    List<UMSEmployed> selectUMSEmployedList(UMSEmployed umsEmployed);
    //检查名字是否唯一
    UMSEmployed checkEmployedNameUnique(String employedName);
    //add info
    int addUMSEmployed(UMSEmployed umsEmployed);

    UMSEmployed selectUMSEmployedById(Long Id);

    int updateUMSEmployed(UMSEmployed umsEmployed);

    int deleteUMSEmployedByIds(@Param("umsEmployedIds") Long[] umsEmployedIds);
}
