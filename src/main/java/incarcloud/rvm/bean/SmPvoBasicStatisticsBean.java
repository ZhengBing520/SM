package incarcloud.rvm.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by bzheng on 2020/5/6.
 */
public class SmPvoBasicStatisticsBean implements Serializable {

    @ApiModelProperty(value = "VIN码")
    private String vin;

    @ApiModelProperty(value = "车型")
    private String vehicleModel;

    @ApiModelProperty(value = "单日行驶时间(s)")
    private Double todayRuntime;

    @ApiModelProperty(value = "单日行驶里程（Km）")
    private Double todayMileage;

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

    public Double getTodayRuntime() {
        return todayRuntime;
    }

    public void setTodayRuntime(Double todayRuntime) {
        this.todayRuntime = todayRuntime;
    }

    public Double getTodayMileage() {
        return todayMileage;
    }

    public void setTodayMileage(Double todayMileage) {
        this.todayMileage = todayMileage;
    }
}
