package com.incarcloud.rvm.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by bzheng on 2020/3/5.
 * 对应Phoenix表 saic:dq_statistics
 */
public class DqStatisticsBean implements Serializable {

    @ApiModelProperty(value = "Vin码")
    private String vin;

    @ApiModelProperty(value = "车型")
    private String vehicleModel;

    @ApiModelProperty(value = "平台")
    private String platformCode;

    @ApiModelProperty(value = "报文数")
    private String messageCount;

    @ApiModelProperty(value = "统计日期")
    private String statisticsDate;

    @ApiModelProperty(value = "总里程--异常数")
    private String mileageAbnormal;
    @ApiModelProperty(value = "电池电量--异常数")
    private String socAbnormal;
    @ApiModelProperty(value = "总电流--异常数")
    private String countElectricityAbnormal;

    @ApiModelProperty(value = "总电压--异常数")
    private String countVoltageAbnormal;

    @ApiModelProperty(value = "驱动电机输入电压--异常数")
    private String driveMotorAbnormal;

    @ApiModelProperty(value = "电压列表--异常数")
    private String listVoltageAbnormal;

    @ApiModelProperty(value = "温度列表--异常数")
    private String listTemperatureAbnormal;

    @ApiModelProperty(value = "GPS位置信息--异常数")
    private String gpsAbnormal;

    @ApiModelProperty(value = "异常信息--异常数")
    private String alarmAbnormal;

    @ApiModelProperty(value = "充电状态指标--异常数")
    private String chargeAbnormal;

    @ApiModelProperty(value = "最高单体电压--异常数")
    private String voltageHighestAbnormal;

    @ApiModelProperty(value = "最低单体电压--异常数")
    private String voltageLowestAbnormal;
    @ApiModelProperty(value = "最高温度--异常数")
    private String temperatureHighestAbnormal;
    @ApiModelProperty(value = "最低温度--异常数")
    private String temperatureLowestAbnormal;
    @ApiModelProperty(value = "速度指标--异常数")
    private String speedAbnormal;
    @ApiModelProperty(value = "挡位指标--异常数")
    private String gearPositionAbnormal;
    @ApiModelProperty(value = "车辆状态--异常数")
    private String vehicleStateAbnormal;
    @ApiModelProperty(value = "加速踏板指标--异常数")
    private String acceleratorPedalAbnormal;
    @ApiModelProperty(value = "制动踏板指标--异常数")
    private String brakePedalAbnormal;
    @ApiModelProperty(value = "发动机状态--异常数")
    private String engineStatusAbnormal;
    @ApiModelProperty(value = "曲轴转速--异常数")
    private String crankshaftSpeedAbnormal;
    @ApiModelProperty(value = "燃料消耗率--异常数")
    private String consumptionAbnormal;
    @ApiModelProperty(value = "DC-DC 状态--异常数")
    private String dcdcStatusAbnormal;
    @ApiModelProperty(value = "运行模式--异常数")
    private String runModeAbnormal;
    @ApiModelProperty(value = "总里程--无效数")
    private String mileageInvalid;
    @ApiModelProperty(value = "电池电量--无效数")
    private String socInvalid;
    @ApiModelProperty(value = "总电流--无效数")
    private String countElectricityInvalid;

    @ApiModelProperty(value = "总电压--无效数")
    private String countVoltageInvalid;

    @ApiModelProperty(value = "驱动电机输入电压--无效数")
    private String driveMotorInvalid;

    @ApiModelProperty(value = "电压列表--无效数")
    private String listVoltageInvalid;

    @ApiModelProperty(value = "温度列表--无效数")
    private String listTemperatureInvalid;

    @ApiModelProperty(value = "GPS位置信息--无效数")
    private String gpsInvalid;

    @ApiModelProperty(value = "异常信息--无效数")
    private String alarmInvalid;

    @ApiModelProperty(value = "充电状态指标--无效数")
    private String chargeInvalid;

    @ApiModelProperty(value = "最高单体电压--无效数")
    private String voltageHighestInvalid;

    @ApiModelProperty(value = "最低单体电压--无效数")
    private String voltageLowestInvalid;
    @ApiModelProperty(value = "最高温度--无效数")
    private String temperatureHighestInvalid;
    @ApiModelProperty(value = "最低温度--无效数")
    private String temperatureLowestInvalid;
    @ApiModelProperty(value = "速度指标--无效数")
    private String speedInvalid;
    @ApiModelProperty(value = "挡位指标--无效数")
    private String gearPositionInvalid;
    @ApiModelProperty(value = "车辆状态--无效数")
    private String vehicleStateInvalid;
    @ApiModelProperty(value = "加速踏板指标--无效数")
    private String acceleratorPedalInvalid;
    @ApiModelProperty(value = "制动踏板指标--无效数")
    private String brakePedalInvalid;
    @ApiModelProperty(value = "发动机状态--无效数")
    private String engineStatusInvalid;
    @ApiModelProperty(value = "曲轴转速--无效数")
    private String crankshaftSpeedInvalid;
    @ApiModelProperty(value = "燃料消耗率--无效数")
    private String consumptionInvalid;
    @ApiModelProperty(value = "DC-DC 状态--无效数")
    private String dcdcStatusInvalid;
    @ApiModelProperty(value = "运行模式--无效数")
    private String runModeInvalid;
/*
    @ApiModelProperty(value = "总里程--未上报数")
    private String mileageNotContent;
    @ApiModelProperty(value = "电池电量--未上报数")
    private String socNotContent;
    @ApiModelProperty(value = "总电流--未上报数")
    private String countElectricityNotContent;

    @ApiModelProperty(value = "总电压--未上报数")
    private String countVoltageNotContent;

    @ApiModelProperty(value = "驱动电机输入电压--未上报数")
    private String driveMotorNotContent;

    @ApiModelProperty(value = "电压列表--未上报数")
    private String listVoltageNotContent;

    @ApiModelProperty(value = "温度列表--未上报数")
    private String listTemperatureNotContent;

    @ApiModelProperty(value = "GPS位置信息--未上报数")
    private String gpsNotContent;

    @ApiModelProperty(value = "异常信息--未上报数")
    private String alarmNotContent;

    @ApiModelProperty(value = "充电状态指标--未上报数")
    private String chargeNotContent;

    @ApiModelProperty(value = "最高单体电压--未上报数")
    private String voltageHighestNotContent;

    @ApiModelProperty(value = "最低单体电压--未上报数")
    private String voltageLowestNotContent;
    @ApiModelProperty(value = "最高温度--未上报数")
    private String temperatureHighestNotContent;
    @ApiModelProperty(value = "最低温度--未上报数")
    private String temperatureLowestNotContent;
    @ApiModelProperty(value = "速度指标--未上报数")
    private String speedNotContent;
    @ApiModelProperty(value = "挡位指标--未上报数")
    private String gearPositionNotContent;
    @ApiModelProperty(value = "车辆状态--未上报数")
    private String vehicleStateNotContent;
    @ApiModelProperty(value = "加速踏板指标--未上报数")
    private String acceleratorPedalNotContent;
    @ApiModelProperty(value = "制动踏板指标--未上报数")
    private String brakePedalNotContent;
    @ApiModelProperty(value = "发动机状态--未上报数")
    private String engineStatusNotContent;
    @ApiModelProperty(value = "曲轴转速--未上报数")
    private String crankshaftSpeedNotContent;
    @ApiModelProperty(value = "燃料消耗率--未上报数")
    private String consumptionNotContent;
    @ApiModelProperty(value = "DC-DC 状态--未上报数")
    private String dcdcStatusNotContent;
    @ApiModelProperty(value = "运行模式--未上报数")
    private String runModeNotContent;*/
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

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(String messageCount) {
        this.messageCount = messageCount;
    }

    public String getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(String statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    public String getMileageAbnormal() {
        return mileageAbnormal;
    }

    public void setMileageAbnormal(String mileageAbnormal) {
        this.mileageAbnormal = mileageAbnormal;
    }

    public String getSocAbnormal() {
        return socAbnormal;
    }

    public void setSocAbnormal(String socAbnormal) {
        this.socAbnormal = socAbnormal;
    }

    public String getCountElectricityAbnormal() {
        return countElectricityAbnormal;
    }

    public void setCountElectricityAbnormal(String countElectricityAbnormal) {
        this.countElectricityAbnormal = countElectricityAbnormal;
    }

    public String getCountVoltageAbnormal() {
        return countVoltageAbnormal;
    }

    public void setCountVoltageAbnormal(String countVoltageAbnormal) {
        this.countVoltageAbnormal = countVoltageAbnormal;
    }

    public String getDriveMotorAbnormal() {
        return driveMotorAbnormal;
    }

    public void setDriveMotorAbnormal(String driveMotorAbnormal) {
        this.driveMotorAbnormal = driveMotorAbnormal;
    }

    public String getListVoltageAbnormal() {
        return listVoltageAbnormal;
    }

    public void setListVoltageAbnormal(String listVoltageAbnormal) {
        this.listVoltageAbnormal = listVoltageAbnormal;
    }

    public String getListTemperatureAbnormal() {
        return listTemperatureAbnormal;
    }

    public void setListTemperatureAbnormal(String listTemperatureAbnormal) {
        this.listTemperatureAbnormal = listTemperatureAbnormal;
    }

    public String getGpsAbnormal() {
        return gpsAbnormal;
    }

    public void setGpsAbnormal(String gpsAbnormal) {
        this.gpsAbnormal = gpsAbnormal;
    }

    public String getAlarmAbnormal() {
        return alarmAbnormal;
    }

    public void setAlarmAbnormal(String alarmAbnormal) {
        this.alarmAbnormal = alarmAbnormal;
    }

    public String getChargeAbnormal() {
        return chargeAbnormal;
    }

    public void setChargeAbnormal(String chargeAbnormal) {
        this.chargeAbnormal = chargeAbnormal;
    }

    public String getVoltageHighestAbnormal() {
        return voltageHighestAbnormal;
    }

    public void setVoltageHighestAbnormal(String voltageHighestAbnormal) {
        this.voltageHighestAbnormal = voltageHighestAbnormal;
    }

    public String getVoltageLowestAbnormal() {
        return voltageLowestAbnormal;
    }

    public void setVoltageLowestAbnormal(String voltageLowestAbnormal) {
        this.voltageLowestAbnormal = voltageLowestAbnormal;
    }

    public String getTemperatureHighestAbnormal() {
        return temperatureHighestAbnormal;
    }

    public void setTemperatureHighestAbnormal(String temperatureHighestAbnormal) {
        this.temperatureHighestAbnormal = temperatureHighestAbnormal;
    }

    public String getTemperatureLowestAbnormal() {
        return temperatureLowestAbnormal;
    }

    public void setTemperatureLowestAbnormal(String temperatureLowestAbnormal) {
        this.temperatureLowestAbnormal = temperatureLowestAbnormal;
    }

    public String getSpeedAbnormal() {
        return speedAbnormal;
    }

    public void setSpeedAbnormal(String speedAbnormal) {
        this.speedAbnormal = speedAbnormal;
    }

    public String getGearPositionAbnormal() {
        return gearPositionAbnormal;
    }

    public void setGearPositionAbnormal(String gearPositionAbnormal) {
        this.gearPositionAbnormal = gearPositionAbnormal;
    }

    public String getVehicleStateAbnormal() {
        return vehicleStateAbnormal;
    }

    public void setVehicleStateAbnormal(String vehicleStateAbnormal) {
        this.vehicleStateAbnormal = vehicleStateAbnormal;
    }

    public String getAcceleratorPedalAbnormal() {
        return acceleratorPedalAbnormal;
    }

    public void setAcceleratorPedalAbnormal(String acceleratorPedalAbnormal) {
        this.acceleratorPedalAbnormal = acceleratorPedalAbnormal;
    }

    public String getBrakePedalAbnormal() {
        return brakePedalAbnormal;
    }

    public void setBrakePedalAbnormal(String brakePedalAbnormal) {
        this.brakePedalAbnormal = brakePedalAbnormal;
    }

    public String getEngineStatusAbnormal() {
        return engineStatusAbnormal;
    }

    public void setEngineStatusAbnormal(String engineStatusAbnormal) {
        this.engineStatusAbnormal = engineStatusAbnormal;
    }

    public String getCrankshaftSpeedAbnormal() {
        return crankshaftSpeedAbnormal;
    }

    public void setCrankshaftSpeedAbnormal(String crankshaftSpeedAbnormal) {
        this.crankshaftSpeedAbnormal = crankshaftSpeedAbnormal;
    }

    public String getConsumptionAbnormal() {
        return consumptionAbnormal;
    }

    public void setConsumptionAbnormal(String consumptionAbnormal) {
        this.consumptionAbnormal = consumptionAbnormal;
    }

    public String getDcdcStatusAbnormal() {
        return dcdcStatusAbnormal;
    }

    public void setDcdcStatusAbnormal(String dcdcStatusAbnormal) {
        this.dcdcStatusAbnormal = dcdcStatusAbnormal;
    }

    public String getMileageInvalid() {
        return mileageInvalid;
    }

    public void setMileageInvalid(String mileageInvalid) {
        this.mileageInvalid = mileageInvalid;
    }

    public String getSocInvalid() {
        return socInvalid;
    }

    public void setSocInvalid(String socInvalid) {
        this.socInvalid = socInvalid;
    }

    public String getCountElectricityInvalid() {
        return countElectricityInvalid;
    }

    public void setCountElectricityInvalid(String countElectricityInvalid) {
        this.countElectricityInvalid = countElectricityInvalid;
    }

    public String getCountVoltageInvalid() {
        return countVoltageInvalid;
    }

    public void setCountVoltageInvalid(String countVoltageInvalid) {
        this.countVoltageInvalid = countVoltageInvalid;
    }

    public String getDriveMotorInvalid() {
        return driveMotorInvalid;
    }

    public void setDriveMotorInvalid(String driveMotorInvalid) {
        this.driveMotorInvalid = driveMotorInvalid;
    }

    public String getListVoltageInvalid() {
        return listVoltageInvalid;
    }

    public void setListVoltageInvalid(String listVoltageInvalid) {
        this.listVoltageInvalid = listVoltageInvalid;
    }

    public String getListTemperatureInvalid() {
        return listTemperatureInvalid;
    }

    public void setListTemperatureInvalid(String listTemperatureInvalid) {
        this.listTemperatureInvalid = listTemperatureInvalid;
    }

    public String getGpsInvalid() {
        return gpsInvalid;
    }

    public void setGpsInvalid(String gpsInvalid) {
        this.gpsInvalid = gpsInvalid;
    }

    public String getAlarmInvalid() {
        return alarmInvalid;
    }

    public void setAlarmInvalid(String alarmInvalid) {
        this.alarmInvalid = alarmInvalid;
    }

    public String getChargeInvalid() {
        return chargeInvalid;
    }

    public void setChargeInvalid(String chargeInvalid) {
        this.chargeInvalid = chargeInvalid;
    }

    public String getVoltageHighestInvalid() {
        return voltageHighestInvalid;
    }

    public void setVoltageHighestInvalid(String voltageHighestInvalid) {
        this.voltageHighestInvalid = voltageHighestInvalid;
    }

    public String getVoltageLowestInvalid() {
        return voltageLowestInvalid;
    }

    public void setVoltageLowestInvalid(String voltageLowestInvalid) {
        this.voltageLowestInvalid = voltageLowestInvalid;
    }

    public String getTemperatureHighestInvalid() {
        return temperatureHighestInvalid;
    }

    public void setTemperatureHighestInvalid(String temperatureHighestInvalid) {
        this.temperatureHighestInvalid = temperatureHighestInvalid;
    }

    public String getTemperatureLowestInvalid() {
        return temperatureLowestInvalid;
    }

    public void setTemperatureLowestInvalid(String temperatureLowestInvalid) {
        this.temperatureLowestInvalid = temperatureLowestInvalid;
    }

    public String getSpeedInvalid() {
        return speedInvalid;
    }

    public void setSpeedInvalid(String speedInvalid) {
        this.speedInvalid = speedInvalid;
    }

    public String getGearPositionInvalid() {
        return gearPositionInvalid;
    }

    public void setGearPositionInvalid(String gearPositionInvalid) {
        this.gearPositionInvalid = gearPositionInvalid;
    }

    public String getVehicleStateInvalid() {
        return vehicleStateInvalid;
    }

    public void setVehicleStateInvalid(String vehicleStateInvalid) {
        this.vehicleStateInvalid = vehicleStateInvalid;
    }

    public String getAcceleratorPedalInvalid() {
        return acceleratorPedalInvalid;
    }

    public void setAcceleratorPedalInvalid(String acceleratorPedalInvalid) {
        this.acceleratorPedalInvalid = acceleratorPedalInvalid;
    }

    public String getBrakePedalInvalid() {
        return brakePedalInvalid;
    }

    public void setBrakePedalInvalid(String brakePedalInvalid) {
        this.brakePedalInvalid = brakePedalInvalid;
    }

    public String getEngineStatusInvalid() {
        return engineStatusInvalid;
    }

    public void setEngineStatusInvalid(String engineStatusInvalid) {
        this.engineStatusInvalid = engineStatusInvalid;
    }

    public String getCrankshaftSpeedInvalid() {
        return crankshaftSpeedInvalid;
    }

    public void setCrankshaftSpeedInvalid(String crankshaftSpeedInvalid) {
        this.crankshaftSpeedInvalid = crankshaftSpeedInvalid;
    }

    public String getConsumptionInvalid() {
        return consumptionInvalid;
    }

    public void setConsumptionInvalid(String consumptionInvalid) {
        this.consumptionInvalid = consumptionInvalid;
    }

    public String getDcdcStatusInvalid() {
        return dcdcStatusInvalid;
    }

    public void setDcdcStatusInvalid(String dcdcStatusInvalid) {
        this.dcdcStatusInvalid = dcdcStatusInvalid;
    }

    public String getRunModeAbnormal() {
        return runModeAbnormal;
    }

    public void setRunModeAbnormal(String runModeAbnormal) {
        this.runModeAbnormal = runModeAbnormal;
    }

    public String getRunModeInvalid() {
        return runModeInvalid;
    }

    public void setRunModeInvalid(String runModeInvalid) {
        this.runModeInvalid = runModeInvalid;
    }
}
