package incarcloud.rvm.controller;

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

import java.util.Date;

/**
 * Created by bzheng on 2020/4/28.
 */
@RestController
@RequestMapping("/api/sm")
@Api(value = "同步pvo_basic表的数据 Client Restful API ", description = "同步pvo_basic表的数据 Client Restful API ", protocols = "application/json")
public class SmPvoBasicStatisticsController {

    @Autowired
    SmPvoBasicStatisticsService smPvoBasicStatisticsService;

    @RequestMapping(value = "/syncData", method = RequestMethod.GET)
    @ApiOperation(value = "同步数据", notes = "同步数据")
    @ApiResponse(code = 200, message = "同步数据")
    public Boolean syncStatisticalIndex(@ApiParam(value = "开始时间")
                                                     @RequestParam(value = "timeBegin") Date timeBegin,
                                                     @ApiParam(value = "结束时间")
                                                     @RequestParam(value = "timeEnd") Date timeEnd
                                        ) {

        return smPvoBasicStatisticsService.syncData(timeBegin, timeEnd);
    }
}
