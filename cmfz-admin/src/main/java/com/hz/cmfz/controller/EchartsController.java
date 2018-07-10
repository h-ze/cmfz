package com.hz.cmfz.controller;
        import com.hz.cmfz.entity.CityCount;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

/**
 * Created by 11022 on 2018/7/9 0009.
 */
@Controller
@RequestMapping("/echarts")
public class EchartsController {

    @RequestMapping("/activeUser")
    @ResponseBody
    public Map<String, Object> getEchartsPic(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"1天","3天","7天","10天","15天"});
        map.put("counts",new int[]{5,10,18,15,3});
        return map;
    }

    @RequestMapping("/distributeMan")
    @ResponseBody
    public List<CityCount> getEcharts(){
        List<CityCount> list= new ArrayList<CityCount>();
        list.add(new CityCount("北京","100"));
        list.add(new CityCount("上海","200"));
        list.add(new CityCount("河北","300"));
        list.add(new CityCount("云南","200"));
        list.add(new CityCount("黑龙江","700"));
        list.add(new CityCount("安徽","500"));
        list.add(new CityCount("新疆","900"));
        list.add(new CityCount("浙江","1000"));
        list.add(new CityCount("湖北","150"));
        list.add(new CityCount("甘肃","190"));
        list.add(new CityCount("内蒙古","300"));
        list.add(new CityCount("吉林","600"));
        list.add(new CityCount("贵州","200"));
        list.add(new CityCount("青海","700"));
        list.add(new CityCount("四川","300"));
        list.add(new CityCount("海南","500"));
        list.add(new CityCount("香港","800"));
        list.add(new CityCount("澳门","100"));
        list.add(new CityCount("台湾","550"));
        list.add(new CityCount("宁夏","770"));
        list.add(new CityCount("天津","100"));
        list.add(new CityCount("重庆","430"));
        list.add(new CityCount("河南","2000"));
        list.add(new CityCount("辽宁","3000"));
        list.add(new CityCount("湖南","1000"));
        list.add(new CityCount("山东","2020"));
        list.add(new CityCount("江苏","800"));
        list.add(new CityCount("江西","102"));
        list.add(new CityCount("广西","134"));
        list.add(new CityCount("山西","256"));
        list.add(new CityCount("陕西","654"));
        list.add(new CityCount("福建","764"));
        list.add(new CityCount("广东","234"));
        list.add(new CityCount("西藏","543"));

        return list;
        /**/
    }

    @RequestMapping("/distributeWomen")
    @ResponseBody
    public List<CityCount> distributeWomen(){
        List<CityCount> list= new ArrayList<CityCount>();
        ;
        list.add(new CityCount("北京",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("上海",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("河北",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("云南",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("黑龙江",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("安徽",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("新疆",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("浙江",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("湖北",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("甘肃",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("内蒙古",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("吉林",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("贵州",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("青海",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("四川",String.valueOf((int)(Math.random()*1000))));
        list.add(new CityCount("海南",String.valueOf((int)(Math.random()*1000))));
        return list;
    }




}
