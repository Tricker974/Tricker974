package com.lator.tricker.mylator.number.controller;

import com.alibaba.fastjson.JSONObject;
import com.lator.tricker.mylator.number.pojo.NumberGuessPojo;
import com.lator.tricker.mylator.number.service.Impl.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/wx/Number")
public class GuessController {
    @Autowired
    private NumberServiceImpl numberService;

    /**
     * 随机一注
     * @return
     */
    @RequestMapping("/getNumber")
    public String GetOneNormal(){
        JSONObject obj=new JSONObject();
        String resultNumber=this.outRed().toString()+this.outBlue().toString();
        obj.put("code",200);
        obj.put("number",resultNumber);
        obj.put("redNum",this.outRed());
        obj.put("blueNum",this.outBlue());
        return obj.toJSONString();
    }

    @RequestMapping("/getPrizeResult")
    public String getPrizeResult(NumberGuessPojo bean){
        JSONObject obj=new JSONObject();
        NumberGuessPojo numberGuessPojo=this.numberService.queryPrizeResult(bean);
        List<String> redNum= Arrays.asList(numberGuessPojo.getRedNum().split(","));
        List<String> blueNum= Arrays.asList(numberGuessPojo.getBlueNum().split(","));
        obj.put("redNum",redNum);
        obj.put("blueNum",blueNum);
        return obj.toJSONString();
    }



    public  List<String> outRed(){
        String[] numberList={"01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20","21","22","23",
                "24","25","26","27","28","29","30","31","32","33","34","35"};
        List<String> tempList=new ArrayList<>();
        for(int i=0;i<35;i++){
            tempList.add(numberList[i]);
        }
        List<String> redList=new ArrayList<>();
        for(int i=0;i<5;i++){
            int remain=34-i;
            int down_mark=(int)(Math.random()*remain);
            redList.add(tempList.get(down_mark));

            tempList.remove(down_mark);
        }
        redList=outMyNumber(redList);
        return redList;
    }
    public  List<String> outBlue(){
        String[] numberList={"01","02","03","04","05","06","07","08","09","10",
                "11","12"};
        List<String> tempList= new ArrayList<>();
        for(int i=0;i<12;i++){
            tempList.add(numberList[i]);
        }
        List<String> blueList=new ArrayList<>();
        for(int i=0;i<2;i++){
            int remain=11-i;
            int down_mark=(int)(Math.random()*remain);
            blueList.add(tempList.get(down_mark));
            tempList.remove(down_mark);
        }
        blueList=outMyNumber(blueList);
        return blueList;
    }
    public  List<String> outMyNumber(List<String> inList){
        for(int i=0;i<inList.size();i++){
            for(int j=i+1;j<inList.size();j++){
                if(Integer.valueOf(inList.get(i))>Integer.valueOf(inList.get(j))){
                    String temp=inList.get(i);
                    inList.set(i,inList.get(j));
                    inList.set(j,temp);
                }
            }
        }
        return inList;
    }
}
