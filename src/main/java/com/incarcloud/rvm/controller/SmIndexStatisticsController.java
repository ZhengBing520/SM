package com.incarcloud.rvm.controller;

import com.incarcloud.rvm.service.SmIndexStatisticsService;
import com.incarcloud.rvm.service.SmPvoBasicStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Created by bzheng on 2020/4/28.
 */
@RestController
@RequestMapping("/api/sm/index/")
@Api(value = "同步dq_statistics表的数据 Client Restful API ", description = "同步dq_statistics表的数据 Client Restful API ", protocols = "application/json")
public class SmIndexStatisticsController {

    @Autowired
    SmIndexStatisticsService smIndexStatisticsService;

    @RequestMapping(value = "/syncData", method = RequestMethod.GET)
    @ApiOperation(value = "同步数据", notes = "同步数据")
    @ApiResponse(code = 200, message = "同步数据")
    public Boolean syncStatisticalIndex(@ApiParam(value = "时间")
                                        @RequestParam(value = "time") String time,
                                        @ApiParam(value = "平台")
                                        @RequestParam(value = "platCode") String platCode,
                                        @ApiParam(value = "文件目录")
                                        @RequestParam(value = "filePath") String filePath
    ) {

        return smIndexStatisticsService.syncData(time, platCode, filePath);
    }

    /**
     * 导入数据
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ApiOperation(value = "导入数据", notes = "导入数据")
    @ApiResponse(code = 200, message = "导入结果")
    public boolean importFromExcel(@ApiParam(value = "车型数据文件") MultipartFile file) {

        return smIndexStatisticsService.importFromExcel(file);
    }
}
