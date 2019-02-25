package com.iot.action;

import com.iot.bean.Eproject;
import com.iot.bean.Esensor;
import com.iot.runnable.DataRunnable;
import com.iot.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("/task")
public class TaskAction {
    @Resource
    private EdataService edataService;
    @Resource
    private EorderService eorderService;
    @Resource
    private EattrService eattrService;
    @Resource
    private EdeviceService edeviceService;
    @Resource
    private EuserdeviceService euserdeviceService;
    @Resource
    private EuserthresholdService euserthresholdService;
    @Resource
    private EroomService eroomService;
    @Resource
    private EbimService ebimService;
    @Resource
    private EthresholdService ethresholdService;
    @Resource
    private EsensorService esensorService;
    @Resource
    private EprojectService eprojectService;

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private List<ScheduledFuture<?>> futures = new ArrayList<ScheduledFuture<?>>();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(20);
        return scheduler;
    }

    @RequestMapping(value = "/start")
    public Map<Object, Object> start(){
        Map<Object, Object> map = new HashMap<Object, Object>();
        for(int i = 0; i < futures.size(); i++){
            if(futures.get(i) != null){
                futures.get(i).cancel(true);
            }
        }

        List<Eproject> projectList = eprojectService.selectBySql("servicename='security'");
        Integer projectid = -1;
        if(projectList.size() > 0)
            projectid = projectList.get(0).getId();
        futures = new ArrayList<ScheduledFuture<?>>();

        List<Esensor> sensorList = esensorService.selectSubAll(projectid);
        for(int i = 0; i < sensorList.size(); i++){
            Integer id = sensorList.get(i).getId();
            String protocol = sensorList.get(i).getProtocol();
            Integer timer = sensorList.get(i).getTimer();
            if(protocol.equals("DataRunnable")) {
                DataRunnable runnable = new DataRunnable(id, edataService, eorderService, eattrService, edeviceService, euserdeviceService, euserthresholdService, eroomService, ebimService, ethresholdService);
                futures.add(threadPoolTaskScheduler.schedule(runnable, new CronTrigger(getCron(timer))));
            }
        }

        return map;
    }

    @RequestMapping(value = "/stop")
    public Map<Object, Object> stop(){
        Map<Object, Object> map = new HashMap<Object, Object>();
        for(int i = 0; i < futures.size(); i++){
            if(futures.get(i) != null){
                futures.get(i).cancel(true);
            }
        }
        return map;
    }

    public String getCron(Integer timer){
        String cron = "";
        if(timer > 59 ) {
            cron += "0 ";
            if(timer/60 > 59){
                cron += "0 ";
                if(timer/60/60 >23) {
                    cron += "0 */1 * *";
                }else{
                    cron += "*/" + timer/60/60 + " * * *";
                }
            }else{
                cron += "*/" + timer/60 + " * * * *";
            }
        }else{
            cron = "*/" + timer + " * * * * *";
        }
        return cron;
    }
}