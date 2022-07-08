package com.lator.tricker.mylator.myGuess.controller;

import com.alibaba.fastjson.JSONObject;
import com.lator.tricker.mylator.myGuess.pojo.MyGuessPojo;
import com.lator.tricker.mylator.myGuess.service.Impl.MyGuessServiceImpl;
import com.lator.tricker.mylator.number.pojo.NumberGuessPojo;
import com.lator.tricker.mylator.number.service.Impl.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/wx/MyGuess")
public class MyGuessController {
    @Autowired
    private MyGuessServiceImpl myGuessService;
    @Autowired
    private NumberServiceImpl numberService;

    /**
     * 保存结果
     * @param bean
     * @return
     */
    @RequestMapping("/saveMyGuess")
    public String saveMyGuess(MyGuessPojo bean){
        String version=this.queryVersion();
        bean.setVersion(version);
        this.myGuessService.insertMyGuess(bean);
        return "ok";
    }

    @RequestMapping("/queryMyGuessResult")
    public String queryMyGuessResult(MyGuessPojo bean)throws Exception{
        JSONObject obj=new JSONObject();
        NumberGuessPojo numberGuessPojo=this.numberService.queryPrizeResult(new NumberGuessPojo());
        List<String> redNum= Arrays.asList(numberGuessPojo.getRedNum().split(","));
        List<String> blueNum= Arrays.asList(numberGuessPojo.getBlueNum().split(","));
        bean.setVersion(numberGuessPojo.getVersion());
        List<MyGuessPojo> myList=this.myGuessService.queryMyGuess(bean);
        myList.add(new MyGuessPojo().setMyRedNum("05,10,23,26,34").setMyBlueNum("03,04"));
        Integer[] reward={0,0,0,0,0,0,0,0,0};
        for (int i = 0; i < myList.size(); i++) {
            List<String> tempRed= Arrays.asList(myList.get(i).getMyRedNum().split(","));
            List<String> tempBlue= Arrays.asList(myList.get(i).getMyBlueNum().split(","));
            List<String> BlueInner=blueNum.stream().filter(item -> tempBlue.contains(item)).collect(toList());
            List<String> RedInner=redNum.stream().filter(item -> tempRed.contains(item)).collect(toList());
            if(BlueInner.size()==0){
              switch (RedInner.size()){
                  case 3:
                      reward[0]+=1;
                      continue;
                  case 4:
                      reward[2]+=1;
                      continue;
                  case 5:
                      reward[6]+=1;
                      continue;
                  default:
                      continue;
              }
            }else if(BlueInner.size()==1){
                switch (RedInner.size()){
                    case 2:
                        reward[0]+=1;
                        continue;
                    case 3:
                        reward[1]+=1;
                        continue;
                    case 4:
                        reward[4]+=1;
                        continue;
                    case 5:
                        reward[7]+=1;
                        continue;
                    default:
                        continue;
                }
            }else if(BlueInner.size()==2){
                switch (RedInner.size()){
                    case 2:
                        reward[1]+=1;
                        continue;
                    case 3:
                        reward[3]+=1;
                        continue;
                    case 4:
                        reward[5]+=1;
                        continue;
                    case 5:
                        reward[8]+=1;
                        continue;
                    default:
                        reward[0]+=1;
                        continue;
                }
            }
        }
        obj.put("rewardList",reward);
        return obj.toJSONString();
    }


    /**
     * 查询当前已开奖版号 并返回下一期板号
     * @return
     */
    public String queryVersion(){
        String version=this.myGuessService.queryVersion();
        version=String.valueOf(Integer.parseInt(version)+1);
        return version;
    }
}
