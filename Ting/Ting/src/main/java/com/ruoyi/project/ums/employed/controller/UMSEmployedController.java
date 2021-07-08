package com.ruoyi.project.ums.employed.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cms.type.constant.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.ums.employed.constant.UMSEmployedConst;
import com.ruoyi.project.ums.employed.domain.UMSEmployed;
import com.ruoyi.project.ums.employed.service.IUMSEmployedSrevice;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CAROL GU
 * @create 2021-07-07 2:15 PM
 * @desc
 */
@Controller
@RequestMapping("/ums/employed")
public class UMSEmployedController extends BaseController {

    private String prefix = "ums/employed";

    @Autowired
    private IUMSEmployedSrevice umsEmployedSrevice;


    @RequiresPermissions("ums:employed:view")
    @GetMapping
    public String view(){
        return prefix +"/employed";
    }

    @RequiresPermissions("ums:employed:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list (UMSEmployed umsEmployed){
        startPage();
        List<UMSEmployed> list = umsEmployedSrevice.selectUMSEmployedList(umsEmployed);
        return getDataTable(list);
    }

    /**
     * 新增公告类型页面跳转
     */
    @GetMapping("/add")
    public String toAdd(){
        return prefix+ "/add";
    }

    /**
     * 检查公告类型名称是否唯一
     * @return
     *   字符串0 - 唯一数据，可以使用
     *   字符串1 - 非唯一数据，不可使用
     */
    @PostMapping("/checkEmployedNameUnique")
    @ResponseBody
    public String checkEmployedNameUnique(UMSEmployed umsEmployed){
        return umsEmployedSrevice.checkEmployedNameUnique(umsEmployed);
    }

    /**
     * 新增员工信息 需要有权限ums:employed:add才可以操作
     *  @param umsEmployed 要新增的类型
     *  @return
     */
    @RequiresPermissions("ums:employed:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@Validated UMSEmployed umsEmployed){
        if(UMSEmployedConst.EMPLOYED_NAME_NOT_UNIQUE.equals(umsEmployedSrevice.checkEmployedNameUnique(umsEmployed))){
            // 员工名字不可用。
            return error("员工名称'" + umsEmployed.getEmployedName() + "'失败，员工名称已存在，请加以区分");
        }

        // 调用服务逻辑，新增数据到数据库。
        // toAjax是父类型BaseController中定义的方法。 根据新增行数判断是否成功。新增数据行数大于0，成功。反之失败。
        return toAjax(umsEmployedSrevice.addUMSEmployed(umsEmployed));

    }
    /**
     * 修改员工信息
     */
    @GetMapping("/edit/{Id}")
    public String edit(@PathVariable("Id") Long Id, Model model)
    {
        UMSEmployed umsEmployed =umsEmployedSrevice.selectUMSEmployedById(Id);
        model.addAttribute("umsEmployed", umsEmployed);
        return prefix + "/edit";
    }

    /**
     * 修改保存公告类型
     */
    // @RequiresPermissions("ums:employed:edit")
    // @PostMapping("/edit")
    // @ResponseBody
    // public AjaxResult editSave(@Validated UMSEmployed umsEmployed)
    // {
    //     // if (UMSEmployedConst.EMPLOYED_NAME_NOT_UNIQUE.equals(umsEmployedSrevice.checkEmployedNameUnique(umsEmployed)))
    //     // {
    //     //     return error("修改员工名字'" + umsEmployed.getEmployedName() + "'失败，员工名称已存在，请加以区分");
    //     // }
    //
    //     return toAjax(umsEmployedSrevice.updateUMSEmployed(umsEmployed));
    // }

    /**
     * 删除公告类型
     * @param  ids 要删除的公告类型的主键，多个主键使用逗号分隔
     * @return
     */
    @PostMapping("/delete")
    @RequiresPermissions("ums:employed:delete")
    @ResponseBody
    public AjaxResult delete(String ids){
        try{
            return toAjax(umsEmployedSrevice.deleteUMSEmployedByIds(ids));
        }catch(Exception e){
            return error(e.getMessage());
        }
    }















}
