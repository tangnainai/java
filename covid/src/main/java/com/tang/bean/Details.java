package com.tang.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tang
 * @date 2022/5/14 19:18
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details {
    private Integer id;
    // province_name
    @TableField(value = "province_short_name")
    private String provinceShortName; // 省份短名称
    // current_onfirmedCount
    @TableField(value = "current_onfirmed_count")
    private Integer currentConfirmedCount; // 现有确诊
    private String time; // 数据获取时间
    public Details(String provinceShortName, Integer currentConfirmedCount, String time) {
        this.provinceShortName = provinceShortName;
        this.currentConfirmedCount = currentConfirmedCount;
        this.time = time;
    }
}
