package com.lator.tricker.mylator.crawler.task;

import com.lator.tricker.mylator.number.pojo.NumberGuessPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * 获取开奖数字
 */
@Component
public class NumResultProcessor implements PageProcessor {
    private String url="https://www.cjcp.com.cn/kaijiang/dlt/";
    @Autowired
    private NumResultPapeline numResultPapeline;


    @Override
    public void process(Page page) {
        Html html=page.getHtml();
        List<Selectable> nodes = html.css("div.num_div span").nodes();
        String version = html.css("div.kj_data span", "text").toString();
        String redNum="";
        String blueNum="";
        NumberGuessPojo pageBean=new NumberGuessPojo();
        //5+2顺序数字
        for (int i = 0; i < nodes.size(); i++) {
            String num = nodes.get(i).css("span", "text").toString();
            if(i<5){
                redNum=redNum+num+",";
            }else{
                blueNum=blueNum+num+",";
            }
        }
        //去除最后一个,
        redNum=redNum.substring(0,redNum.lastIndexOf(","));
        blueNum=blueNum.substring(0,blueNum.lastIndexOf(","));
        pageBean.setVersion(version.replace("期",""));
        pageBean.setRedNum(redNum);
        pageBean.setBlueNum(blueNum);
        page.putField("pageBean",pageBean);
    }

    private Site site=Site.me()
            .setCharset("gbk")
            .setTimeOut(2*60*1000)
            .setRetrySleepTime(3000)
            .setRetryTimes(3);

    @Override
    public Site getSite() {
        return site;
    }
    @Scheduled(initialDelay = 1000,fixedDelay = 24*60*60*1000)
    public void process(){
        Spider.create(new NumResultProcessor())
                .addUrl(url)
                .setScheduler(new QueueScheduler())
                .addPipeline(this.numResultPapeline)
                .run();
    }
}
