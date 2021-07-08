package com.ruoyi.project.cms.type.mapper;

import com.ruoyi.project.cms.type.domain.CMSType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CAROL GU
 * @create 2021-07-05 3:08 PM
 * @desc
 */
@Mapper
public interface CMSTypeMapper {
    //传递实体对象
    List<CMSType> selectCMSTypeList(CMSType type);
    //检查内容是否唯一
    CMSType checkTypeNameUnique(String typeName);
    //添加
    int insertCMSType(CMSType type);

    CMSType selectCMSTypeById(Long typeId);

    int updateCMSType(CMSType type);

    int deleteCMSTypeByIds(@Param("typeIds")Long[] typeIds);
}
