package com.zju.ad.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zju.ad.constant.CommonStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ad_plan")
public class AdPlan {

    @ApiModelProperty(name = "id", value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name = "userId", value = "用户id")
    @TableField(value = "user_id", insertStrategy = FieldStrategy.NOT_NULL)
    private Long userId;

    @ApiModelProperty(name = "planName", value = "计划名称")
    @TableField(value = "plan_name", insertStrategy = FieldStrategy.NOT_NULL)
    private String planName;

    @ApiModelProperty(name = "planStatus", value = "计划状态")
    @TableField(value = "plan_status", insertStrategy = FieldStrategy.NOT_NULL)
    private Byte planStatus;

    @ApiModelProperty(name = "startDate", value = "计划开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "start_date", insertStrategy = FieldStrategy.NOT_NULL)
    private Date startDate;

    @ApiModelProperty(name = "endDate", value = "计划结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "end_date", insertStrategy = FieldStrategy.NOT_NULL)
    private Date endDate;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "create_time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date createTime;

    @ApiModelProperty(name = "updateTime", value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "update_Time", insertStrategy = FieldStrategy.NOT_NULL)
    private Date updateTime;

    public AdPlan(Long userId, String planName, Date startDate, Date endDate) {
        this.userId = userId;
        this.planName = planName;
        this.planStatus = CommonStatus.VALID.getStatus();
        this.startDate = startDate;
        this.endDate = endDate;
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}