package com.ruoyi.project.ums.employed.service;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.cms.type.constant.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.ums.employed.constant.UMSEmployedConst;
import com.ruoyi.project.ums.employed.domain.UMSEmployed;
import com.ruoyi.project.ums.employed.mapper.UMSEmployedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CAROL GU
 * @create 2021-07-07 4:45 PM
 * @desc
 */
@Service
public class UMSEmployedSreviceImpl implements IUMSEmployedSrevice{
    @Autowired
    private UMSEmployedMapper umsEmployedMapper;

    @Override
    public List<UMSEmployed> selectUMSEmployedList(UMSEmployed umsEmployed) {
        return umsEmployedMapper.selectUMSEmployedList(umsEmployed);
    }

    @Override
    public String checkEmployedNameUnique(UMSEmployed umsEmployed) {
        // 当前可能是在修改公告类型，也可能在新增公告类型。 如果是修改，则需要判定主键。
        Long employedId = StringUtils.isNull(umsEmployed.getEmployedId()) ? -1L : umsEmployed.getEmployedId();

        UMSEmployed info = umsEmployedMapper.checkEmployedNameUnique(umsEmployed.getEmployedName());
        if (StringUtils.isNotNull(info) && info.getEmployedId().longValue() != employedId.longValue())
        {
            return UMSEmployedConst.EMPLOYED_NAME_NOT_UNIQUE;
        }
        return UMSEmployedConst.EMPLOYED_NAME_UNIQUE;
    }

    @Override
    public int addUMSEmployed(UMSEmployed umsEmployed) {
        umsEmployed.setCreateBy(ShiroUtils.getLoginName());
        return umsEmployedMapper.addUMSEmployed(umsEmployed);
    }

    @Override
    public UMSEmployed selectUMSEmployedById(Long Id) {
        return umsEmployedMapper.selectUMSEmployedById(Id);
    }

    @Override
    public int updateUMSEmployed(UMSEmployed umsEmployed) {
        return umsEmployedMapper.updateUMSEmployed(umsEmployed);
    }

    @Override
    public int deleteUMSEmployedByIds(String ids) {
        Long[] UMSEmployedIds = Convert.toLongArray(ids);
        return umsEmployedMapper.deleteUMSEmployedByIds(UMSEmployedIds);
    }


}



