package com.lator.tricker.mylator.crawler.task;

import com.lator.tricker.mylator.number.pojo.NumberGuessPojo;
import com.lator.tricker.mylator.number.service.Impl.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

//保存数据到数据库
@Component
public class NumResultPapeline implements Pipeline {

    @Autowired
    private NumberServiceImpl numberService;


    @Override
    public void process(ResultItems resultItems, Task task) {
        NumberGuessPojo bean=resultItems.get("pageBean");
        if(bean!=null){
            //去重（后续更正计划时间 周一 周三 周日//春节会长期不发布）
            Integer count=this.numberService.queryIfExist(bean);
            if(count==0){
                this.numberService.insertResult(bean);
            }
        }
    }
}
