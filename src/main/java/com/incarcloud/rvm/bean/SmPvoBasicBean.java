package com.incarcloud.rvm.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by bzheng on 2020/5/6.
 */
public class SmPvoBasicBean implements Serializable {

    @ApiModelProperty(value = "VIN码")
    private String vin;

    @ApiModelProperty(value = "车型")
    private String vehicleModel;

    @ApiModelProperty(value = "总上线天数")
    private Integer totalDay;

    @ApiModelProperty(value = "总行驶时间(s)")
    private Double totalRuntime;

    @ApiModelProperty(value = "总行驶里程（Km）")
    private Double totalMileage;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Integer getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(Integer totalDay) {
        this.totalDay = totalDay;
    }

    public Double getTotalRuntime() {
        return totalRuntime;
    }

    public void setTotalRuntime(Double totalRuntime) {
        this.totalRuntime = totalRuntime;
    }

    public Double getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Double totalMileage) {
        this.totalMileage = totalMileage;
    }
}
