package com.zy.springboot.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tujia.framework.api.APIResponse;
import com.tujia.framework.datetime.bean.ShortDate;
import com.tujia.ploutos.fcss.api.model.entity.SettlementItemBase;
import com.tujia.ploutos.fcss.api.model.req.PreSettlementItemReq;
import com.tujia.ploutos.fcss.api.service.SettlementItemService;
import com.tujia.tns.baseinfo.api.service.HouseApiService;
import com.tujia.tns.price.api.bean.price.GetUnitPriceRequest;
import com.tujia.tns.price.api.bean.price.GetUnitPriceResponse;
import com.tujia.tns.price.api.service.price.OpenPriceRemote;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.zy.springboot.controller.DeserializeObject.deserializeObjFromFile;

//import com.tujia.ploutos.fcss.api.service.SettlementItemService;
public class DubboTest {

    SettlementItemService settlementItemService;
    PreSettlementItemReq preSettlementItemReq;
    APIResponse<SettlementItemBase> result_getPreSettlementItem;
//   static OpenPriceRemote openPriceRemote;

    HouseApiService houseApiService;

    @BeforeClass
    public void init() {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-demo-providerFVT.xml"});
        context.start();

        settlementItemService = (SettlementItemService) context.getBean("settlementItemService");

        preSettlementItemReq = deserializeObjFromFile("/fcss/preSettlementItemReq.json", PreSettlementItemReq.class);

        houseApiService = (HouseApiService) context.getBean("houseApiService");

    }

    @Test
    public void test11(){

        result_getPreSettlementItem = settlementItemService.getPreSettlementItem(preSettlementItemReq);


        System.out.println(  JSONObject.toJSON(result_getPreSettlementItem));
        System.out.println(result_getPreSettlementItem.toString());
        System.out.println("111111111111111111");
    }

    @Test
    public void test222(){

        APIResponse<Long> hotelid = houseApiService.getHotelIdByHouseId(1000032L);


        System.out.println( hotelid);

    }


//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-demo-providerFVT.xml"});
//        context.start();
//
//        settlementItemService = (SettlementItemService) context.getBean("settlementItemService");
//
//        openPriceRemote = (OpenPriceRemote) context.getBean("openPriceRemote");
//
//        GetUnitPriceRequest getUnitPriceRequest = new GetUnitPriceRequest();
//        getUnitPriceRequest.setCityId(0);
//        getUnitPriceRequest.setUnitId(89278L);
//        getUnitPriceRequest.setGuestCount(1);
//        getUnitPriceRequest.setRoomCount(1);
////        UserInfo userInfo =  new UserInfo();
////        userInfo.setUserId(0L);
////        userInfo.setGuestIdentityType(0);
////        userInfo.setOrderQuantities(0);
////        userInfo.setChannelCode("");
////        userInfo.setMemberLevel(0);
////        userInfo.setMemberSpecialAttribute(0);
////        userInfo.setThirdLevel(0);
///**
// * fromDate : {"month":5,"year":2020,"day":6}
// * roomCount : 1
// * userInfo : {"orderQuantities":0,"guestIdentityType":0,"userId":0}
// * wrapperId : waptujia001
// * toDate : {"month":5,"year":2020,"day":7}
// * clientInfo : {"shieldDiscountEntries":[0]}
// * unitId : ${op2[0].data.unitId}
// * guestCount : 1
// * cityId : 0
// */
////        getUnitPriceRequest.setUserInfo(userInfo);
////        OPClientInfo opClientInfo = new OPClientInfo();
////        opClientInfo.setShieldDiscountEntries(Sets.newHashSet());
////        opClientInfo.setuId("");
////        opClientInfo.setClientId("");
////        opClientInfo.setImei("");
////        opClientInfo.setClientFeatures(Sets.newHashSet());
////        opClientInfo.setCalDiscountActivityIds(Sets.newHashSet());
////
////        getUnitPriceRequest.setClientInfo(opClientInfo);
//        getUnitPriceRequest.setWrapperId("waptujia002");
//        ShortDate frromdate = new ShortDate();
//        frromdate.setYear(2020);
//        frromdate.setMonth(6);
//        frromdate.setDay(1);
//
//        getUnitPriceRequest.setFromDate(frromdate);
//        getUnitPriceRequest.setWrapperId("");
//        ShortDate todate = new ShortDate();
//        todate.setYear(2020);
//        todate.setMonth(6);
//        todate.setDay(2);
//        getUnitPriceRequest.setToDate(todate);
////        getUnitPriceRequest.setAccessType("");
////        getUnitPriceRequest.setTrafficReplay(false);
//
////        openPriceRemote.getUnitPrice(getUnitPriceRequest);
//        APIResponse<GetUnitPriceResponse> res =  openPriceRemote.getUnitPrice(getUnitPriceRequest);
////        preSettlementItemReq = deserializeObjFromFile("/fcss/preSettlementItemReq.json", PreSettlementItemReq.class);

}
