package com.incarcloud.rvm.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by bzheng on 2020/3/5.
 * 对应Phoenix表 saic:dq_statistics
 */
public class DqStatistics2Bean implements Serializable {

    @ApiModelProperty(value = "Vin码")
    private String vin;

    @ApiModelProperty(value = "车型")
    private String vehicleModel;

    @ApiModelProperty(value = "平台")
    private String platformCode;

    @ApiModelProperty(value = "报文数")
    private int messageCount;

    @ApiModelProperty(value = "统计日期")
    private String statisticsDate;

    @ApiModelProperty(value = "总里程--异常数")
    private int mileageAbnormal;
    @ApiModelProperty(value = "电池电量--异常数")
    private int socAbnormal;
    @ApiModelProperty(value = "总电流--异常数")
    private int countElectricityAbnormal;
    @ApiModelProperty(value = "总电压--异常数")
    private int countVoltageAbnormal;

    @ApiModelProperty(value = "驱动电机输入电压--异常数")
    private int driveMotorAbnormal;

    @ApiModelProperty(value = "电压列表--异常数")
    private int listVoltageAbnormal;

    @ApiModelProperty(value = "温度列表--异常数")
    private int listTemperatureAbnormal;

    @ApiModelProperty(value = "GPS位置信息--异常数")
    private int gpsAbnormal;

    @ApiModelProperty(value = "异常信息--异常数")
    private int alarmAbnormal;

    @ApiModelProperty(value = "充电状态指标--异常数")
    private int chargeAbnormal;

    @ApiModelProperty(value = "最高单体电压--异常数")
    private int voltageHighestAbnormal;

    @ApiModelProperty(value = "最低单体电压--异常数")
    private int voltageLowestAbnormal;
    @ApiModelProperty(value = "最高温度--异常数")
    private int temperatureHighestAbnormal;
    @ApiModelProperty(value = "最低温度--异常数")
    private int temperatureLowestAbnormal;
    @ApiModelProperty(value = "速度指标--异常数")
    private int speedAbnormal;
    @ApiModelProperty(value = "挡位指标--异常数")
    private int gearPositionAbnormal;
    @ApiModelProperty(value = "车辆状态--异常数")
    private int vehicleStateAbnormal;
    @ApiModelProperty(value = "加速踏板指标--异常数")
    private int acceleratorPedalAbnormal;
    @ApiModelProperty(value = "制动踏板指标--异常数")
    private int brakePedalAbnormal;
    @ApiModelProperty(value = "发动机状态--异常数")
    private int engineStatusAbnormal;
    @ApiModelProperty(value = "曲轴转速--异常数")
    private int crankshaftSpeedAbnormal;
    @ApiModelProperty(value = "燃料消耗率--异常数")
    private int consumptionAbnormal;
    @ApiModelProperty(value = "DC-DC 状态--异常数")
    private int dcdcStatusAbnormal;
    @ApiModelProperty(value = "运行模式--异常数")
    private int runModeAbnormal;
    @ApiModelProperty(value = "总里程--无效数")
    private int mileageInvalid;
    @ApiModelProperty(value = "电池电量--无效数")
    private int socInvalid;
    @ApiModelProperty(value = "总电流--无效数")
    private int countElectricityInvalid;

    @ApiModelProperty(value = "总电压--无效数")
    private int countVoltageInvalid;

    @ApiModelProperty(value = "驱动电机输入电压--无效数")
    private int driveMotorInvalid;

    @ApiModelProperty(value = "电压列表--无效数")
    private int listVoltageInvalid;

    @ApiModelProperty(value = "温度列表--无效数")
    private int listTemperatureInvalid;

    @ApiModelProperty(value = "GPS位置信息--无效数")
    private int gpsInvalid;

    @ApiModelProperty(value = "异常信息--无效数")
    private int alarmInvalid;

    @ApiModelProperty(value = "充电状态指标--无效数")
    private int chargeInvalid;

    @ApiModelProperty(value = "最高单体电压--无效数")
    private int voltageHighestInvalid;

    @ApiModelProperty(value = "最低单体电压--无效数")
    private int voltageLowestInvalid;
    @ApiModelProperty(value = "最高温度--无效数")
    private int temperatureHighestInvalid;
    @ApiModelProperty(value = "最低温度--无效数")
    private int temperatureLowestInvalid;
    @ApiModelProperty(value = "速度指标--无效数")
    private int speedInvalid;
    @ApiModelProperty(value = "挡位指标--无效数")
    private int gearPositionInvalid;
    @ApiModelProperty(value = "车辆状态--无效数")
    private int vehicleStateInvalid;
    @ApiModelProperty(value = "加速踏板指标--无效数")
    private int acceleratorPedalInvalid;
    @ApiModelProperty(value = "制动踏板指标--无效数")
    private int brakePedalInvalid;
    @ApiModelProperty(value = "发动机状态--无效数")
    private int engineStatusInvalid;
    @ApiModelProperty(value = "曲轴转速--无效数")
    private int crankshaftSpeedInvalid;
    @ApiModelProperty(value = "燃料消耗率--无效数")
    private int consumptionInvalid;
    @ApiModelProperty(value = "DC-DC 状态--无效数")
    private int dcdcStatusInvalid;
    @ApiModelProperty(value = "运行模式--无效数")
    private int runModeInvalid;

    @ApiModelProperty(value = "总里程--无数据")
    private int mileageNotContent;
    @ApiModelProperty(value = "电池电量--无数据")
    private int socNotContent;
    @ApiModelProperty(value = "总电流--无数据")
    private int countElectricityNotContent;

    @ApiModelProperty(value = "总电压--无数据")
    private int countVoltageNotContent;

    @ApiModelProperty(value = "驱动电机输入电压--无数据")
    private int driveMotorNotContent;

    @ApiModelProperty(value = "电压列表--无数据")
    private int listVoltageNotContent;

    @ApiModelProperty(value = "温度列表--无数据")
    private int listTemperatureNotContent;

    @ApiModelProperty(value = "GPS位置信息--无数据")
    private int gpsNotContent;

    @ApiModelProperty(value = "异常信息--无数据")
    private int alarmNotContent;

    @ApiModelProperty(value = "充电状态指标--无数据")
    private int chargeNotContent;

    @ApiModelProperty(value = "最高单体电压--无数据")
    private int voltageHighestNotContent;

    @ApiModelProperty(value = "最低单体电压--无数据")
    private int voltageLowestNotContent;
    @ApiModelProperty(value = "最高温度--无数据")
    private int temperatureHighestNotContent;
    @ApiModelProperty(value = "最低温度--无数据")
    private int temperatureLowestNotContent;
    @ApiModelProperty(value = "速度指标--无数据")
    private int speedNotContent;
    @ApiModelProperty(value = "挡位指标--无数据")
    private int gearPositionNotContent;
    @ApiModelProperty(value = "车辆状态--无数据")
    private int vehicleStateNotContent;
    @ApiModelProperty(value = "加速踏板指标--无数据")
    private int acceleratorPedalNotContent;
    @ApiModelProperty(value = "制动踏板指标--无数据")
    private int brakePedalNotContent;
    @ApiModelProperty(value = "发动机状态--无数据")
    private int engineStatusNotContent;
    @ApiModelProperty(value = "曲轴转速--无数据")
    private int crankshaftSpeedNotContent;
    @ApiModelProperty(value = "燃料消耗率--无数据")
    private int consumptionNotContent;
    @ApiModelProperty(value = "DC-DC 状态--无数据")
    private int dcdcStatusNotContent;
    @ApiModelProperty(value = "运行模式--无数据")
    private int runModeNotContent;

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

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public String getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(String statisticsDate) {
        this.statisticsDate = statisticsDate;
    }

    public int getMileageAbnormal() {
        return mileageAbnormal;
    }

    public void setMileageAbnormal(int mileageAbnormal) {
        this.mileageAbnormal = mileageAbnormal;
    }

    public int getSocAbnormal() {
        return socAbnormal;
    }

    public void setSocAbnormal(int socAbnormal) {
        this.socAbnormal = socAbnormal;
    }

    public int getCountElectricityAbnormal() {
        return countElectricityAbnormal;
    }

    public void setCountElectricityAbnormal(int countElectricityAbnormal) {
        this.countElectricityAbnormal = countElectricityAbnormal;
    }

    public int getCountVoltageAbnormal() {
        return countVoltageAbnormal;
    }

    public void setCountVoltageAbnormal(int countVoltageAbnormal) {
        this.countVoltageAbnormal = countVoltageAbnormal;
    }

    public int getDriveMotorAbnormal() {
        return driveMotorAbnormal;
    }

    public void setDriveMotorAbnormal(int driveMotorAbnormal) {
        this.driveMotorAbnormal = driveMotorAbnormal;
    }

    public int getListVoltageAbnormal() {
        return listVoltageAbnormal;
    }

    public void setListVoltageAbnormal(int listVoltageAbnormal) {
        this.listVoltageAbnormal = listVoltageAbnormal;
    }

    public int getListTemperatureAbnormal() {
        return listTemperatureAbnormal;
    }

    public void setListTemperatureAbnormal(int listTemperatureAbnormal) {
        this.listTemperatureAbnormal = listTemperatureAbnormal;
    }

    public int getGpsAbnormal() {
        return gpsAbnormal;
    }

    public void setGpsAbnormal(int gpsAbnormal) {
        this.gpsAbnormal = gpsAbnormal;
    }

    public int getAlarmAbnormal() {
        return alarmAbnormal;
    }

    public void setAlarmAbnormal(int alarmAbnormal) {
        this.alarmAbnormal = alarmAbnormal;
    }

    public int getChargeAbnormal() {
        return chargeAbnormal;
    }

    public void setChargeAbnormal(int chargeAbnormal) {
        this.chargeAbnormal = chargeAbnormal;
    }

    public int getVoltageHighestAbnormal() {
        return voltageHighestAbnormal;
    }

    public void setVoltageHighestAbnormal(int voltageHighestAbnormal) {
        this.voltageHighestAbnormal = voltageHighestAbnormal;
    }

    public int getVoltageLowestAbnormal() {
        return voltageLowestAbnormal;
    }

    public void setVoltageLowestAbnormal(int voltageLowestAbnormal) {
        this.voltageLowestAbnormal = voltageLowestAbnormal;
    }

    public int getTemperatureHighestAbnormal() {
        return temperatureHighestAbnormal;
    }

    public void setTemperatureHighestAbnormal(int temperatureHighestAbnormal) {
        this.temperatureHighestAbnormal = temperatureHighestAbnormal;
    }

    public int getTemperatureLowestAbnormal() {
        return temperatureLowestAbnormal;
    }

    public void setTemperatureLowestAbnormal(int temperatureLowestAbnormal) {
        this.temperatureLowestAbnormal = temperatureLowestAbnormal;
    }

    public int getSpeedAbnormal() {
        return speedAbnormal;
    }

    public void setSpeedAbnormal(int speedAbnormal) {
        this.speedAbnormal = speedAbnormal;
    }

    public int getGearPositionAbnormal() {
        return gearPositionAbnormal;
    }

    public void setGearPositionAbnormal(int gearPositionAbnormal) {
        this.gearPositionAbnormal = gearPositionAbnormal;
    }

    public int getVehicleStateAbnormal() {
        return vehicleStateAbnormal;
    }

    public void setVehicleStateAbnormal(int vehicleStateAbnormal) {
        this.vehicleStateAbnormal = vehicleStateAbnormal;
    }

    public int getAcceleratorPedalAbnormal() {
        return acceleratorPedalAbnormal;
    }

    public void setAcceleratorPedalAbnormal(int acceleratorPedalAbnormal) {
        this.acceleratorPedalAbnormal = acceleratorPedalAbnormal;
    }

    public int getBrakePedalAbnormal() {
        return brakePedalAbnormal;
    }

    public void setBrakePedalAbnormal(int brakePedalAbnormal) {
        this.brakePedalAbnormal = brakePedalAbnormal;
    }

    public int getEngineStatusAbnormal() {
        return engineStatusAbnormal;
    }

    public void setEngineStatusAbnormal(int engineStatusAbnormal) {
        this.engineStatusAbnormal = engineStatusAbnormal;
    }

    public int getCrankshaftSpeedAbnormal() {
        return crankshaftSpeedAbnormal;
    }

    public void setCrankshaftSpeedAbnormal(int crankshaftSpeedAbnormal) {
        this.crankshaftSpeedAbnormal = crankshaftSpeedAbnormal;
    }

    public int getConsumptionAbnormal() {
        return consumptionAbnormal;
    }

    public void setConsumptionAbnormal(int consumptionAbnormal) {
        this.consumptionAbnormal = consumptionAbnormal;
    }

    public int getDcdcStatusAbnormal() {
        return dcdcStatusAbnormal;
    }

    public void setDcdcStatusAbnormal(int dcdcStatusAbnormal) {
        this.dcdcStatusAbnormal = dcdcStatusAbnormal;
    }

    public int getMileageInvalid() {
        return mileageInvalid;
    }

    public void setMileageInvalid(int mileageInvalid) {
        this.mileageInvalid = mileageInvalid;
    }

    public int getSocInvalid() {
        return socInvalid;
    }

    public void setSocInvalid(int socInvalid) {
        this.socInvalid = socInvalid;
    }

    public int getCountElectricityInvalid() {
        return countElectricityInvalid;
    }

    public void setCountElectricityInvalid(int countElectricityInvalid) {
        this.countElectricityInvalid = countElectricityInvalid;
    }

    public int getCountVoltageInvalid() {
        return countVoltageInvalid;
    }

    public void setCountVoltageInvalid(int countVoltageInvalid) {
        this.countVoltageInvalid = countVoltageInvalid;
    }

    public int getDriveMotorInvalid() {
        return driveMotorInvalid;
    }

    public void setDriveMotorInvalid(int driveMotorInvalid) {
        this.driveMotorInvalid = driveMotorInvalid;
    }

    public int getListVoltageInvalid() {
        return listVoltageInvalid;
    }

    public void setListVoltageInvalid(int listVoltageInvalid) {
        this.listVoltageInvalid = listVoltageInvalid;
    }

    public int getListTemperatureInvalid() {
        return listTemperatureInvalid;
    }

    public void setListTemperatureInvalid(int listTemperatureInvalid) {
        this.listTemperatureInvalid = listTemperatureInvalid;
    }

    public int getGpsInvalid() {
        return gpsInvalid;
    }

    public void setGpsInvalid(int gpsInvalid) {
        this.gpsInvalid = gpsInvalid;
    }

    public int getAlarmInvalid() {
        return alarmInvalid;
    }

    public void setAlarmInvalid(int alarmInvalid) {
        this.alarmInvalid = alarmInvalid;
    }

    public int getChargeInvalid() {
        return chargeInvalid;
    }

    public void setChargeInvalid(int chargeInvalid) {
        this.chargeInvalid = chargeInvalid;
    }

    public int getVoltageHighestInvalid() {
        return voltageHighestInvalid;
    }

    public void setVoltageHighestInvalid(int voltageHighestInvalid) {
        this.voltageHighestInvalid = voltageHighestInvalid;
    }

    public int getVoltageLowestInvalid() {
        return voltageLowestInvalid;
    }

    public void setVoltageLowestInvalid(int voltageLowestInvalid) {
        this.voltageLowestInvalid = voltageLowestInvalid;
    }

    public int getTemperatureHighestInvalid() {
        return temperatureHighestInvalid;
    }

    public void setTemperatureHighestInvalid(int temperatureHighestInvalid) {
        this.temperatureHighestInvalid = temperatureHighestInvalid;
    }

    public int getTemperatureLowestInvalid() {
        return temperatureLowestInvalid;
    }

    public void setTemperatureLowestInvalid(int temperatureLowestInvalid) {
        this.temperatureLowestInvalid = temperatureLowestInvalid;
    }

    public int getSpeedInvalid() {
        return speedInvalid;
    }

    public void setSpeedInvalid(int speedInvalid) {
        this.speedInvalid = speedInvalid;
    }

    public int getGearPositionInvalid() {
        return gearPositionInvalid;
    }

    public void setGearPositionInvalid(int gearPositionInvalid) {
        this.gearPositionInvalid = gearPositionInvalid;
    }

    public int getVehicleStateInvalid() {
        return vehicleStateInvalid;
    }

    public void setVehicleStateInvalid(int vehicleStateInvalid) {
        this.vehicleStateInvalid = vehicleStateInvalid;
    }

    public int getAcceleratorPedalInvalid() {
        return acceleratorPedalInvalid;
    }

    public void setAcceleratorPedalInvalid(int acceleratorPedalInvalid) {
        this.acceleratorPedalInvalid = acceleratorPedalInvalid;
    }

    public int getBrakePedalInvalid() {
        return brakePedalInvalid;
    }

    public void setBrakePedalInvalid(int brakePedalInvalid) {
        this.brakePedalInvalid = brakePedalInvalid;
    }

    public int getEngineStatusInvalid() {
        return engineStatusInvalid;
    }

    public void setEngineStatusInvalid(int engineStatusInvalid) {
        this.engineStatusInvalid = engineStatusInvalid;
    }

    public int getCrankshaftSpeedInvalid() {
        return crankshaftSpeedInvalid;
    }

    public void setCrankshaftSpeedInvalid(int crankshaftSpeedInvalid) {
        this.crankshaftSpeedInvalid = crankshaftSpeedInvalid;
    }

    public int getConsumptionInvalid() {
        return consumptionInvalid;
    }

    public void setConsumptionInvalid(int consumptionInvalid) {
        this.consumptionInvalid = consumptionInvalid;
    }

    public int getDcdcStatusInvalid() {
        return dcdcStatusInvalid;
    }

    public void setDcdcStatusInvalid(int dcdcStatusInvalid) {
        this.dcdcStatusInvalid = dcdcStatusInvalid;
    }

    public int getRunModeAbnormal() {
        return runModeAbnormal;
    }

    public void setRunModeAbnormal(int runModeAbnormal) {
        this.runModeAbnormal = runModeAbnormal;
    }

    public int getRunModeInvalid() {
        return runModeInvalid;
    }

    public void setRunModeInvalid(int runModeInvalid) {
        this.runModeInvalid = runModeInvalid;
    }
}
