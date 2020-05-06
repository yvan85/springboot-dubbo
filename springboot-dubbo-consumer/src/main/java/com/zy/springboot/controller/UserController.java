package com.zy.springboot.controller;
import com.google.common.collect.Sets;
import com.tujia.tns.price.api.bean.UserInfo;
import com.tujia.tns.price.api.bean.OPClientInfo;
import com.tujia.tns.price.api.bean.price.GetUnitPriceRequest;
import com.tujia.tns.price.api.service.price.OpenPriceRemote;
import com.zy.springboot.controller.AA.ToDateBean;
import com.zy.springboot.controller.AA.FromDateBean;
import com.zy.springboot.controller.AA.ClientInfoBean;
import com.zy.springboot.controller.AA.UserInfoBean;
import java.util.Date;
import com.tujia.framework.datetime.bean.ShortDate;
import com.tujia.tns.product.provider.vo.tujing.Operater;

import com.tujia.tns.product.api.service.ProductForOpenPriceService;
import com.tujia.tns.product.provider.vo.GetProductInventoryAndPriceRealInfoRequest;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {


    @Reference
    private ProductForOpenPriceService productForOpenPriceService;

    @Reference
    private OpenPriceRemote openPriceRemote;

    @RequestMapping("/getprice")
    public Object getprice(){

        GetUnitPriceRequest getUnitPriceRequest = new GetUnitPriceRequest();
        getUnitPriceRequest.setCityId(0);
        getUnitPriceRequest.setUnitId(89278L);
        getUnitPriceRequest.setGuestCount(1);
        getUnitPriceRequest.setRoomCount(1);
//        UserInfo userInfo =  new UserInfo();
//        userInfo.setUserId(0L);
//        userInfo.setGuestIdentityType(0);
//        userInfo.setOrderQuantities(0);
//        userInfo.setChannelCode("");
//        userInfo.setMemberLevel(0);
//        userInfo.setMemberSpecialAttribute(0);
//        userInfo.setThirdLevel(0);
/**
 * fromDate : {"month":5,"year":2020,"day":6}
 * roomCount : 1
 * userInfo : {"orderQuantities":0,"guestIdentityType":0,"userId":0}
 * wrapperId : waptujia001
 * toDate : {"month":5,"year":2020,"day":7}
 * clientInfo : {"shieldDiscountEntries":[0]}
 * unitId : ${op2[0].data.unitId}
 * guestCount : 1
 * cityId : 0
 */
//        getUnitPriceRequest.setUserInfo(userInfo);
//        OPClientInfo opClientInfo = new OPClientInfo();
//        opClientInfo.setShieldDiscountEntries(Sets.newHashSet());
//        opClientInfo.setuId("");
//        opClientInfo.setClientId("");
//        opClientInfo.setImei("");
//        opClientInfo.setClientFeatures(Sets.newHashSet());
//        opClientInfo.setCalDiscountActivityIds(Sets.newHashSet());
//
//        getUnitPriceRequest.setClientInfo(opClientInfo);
        getUnitPriceRequest.setWrapperId("waptujia002");
        ShortDate frromdate = new ShortDate();
        frromdate.setYear(2020);
        frromdate.setMonth(6);
        frromdate.setDay(1);

        getUnitPriceRequest.setFromDate(frromdate);
        getUnitPriceRequest.setWrapperId("");
        ShortDate todate = new ShortDate();
        todate.setYear(2020);
        todate.setMonth(6);
        todate.setDay(2);
        getUnitPriceRequest.setToDate(todate);
//        getUnitPriceRequest.setAccessType("");
//        getUnitPriceRequest.setTrafficReplay(false);

        openPriceRemote.getUnitPrice(getUnitPriceRequest);

        return null;
    }
@RequestMapping("/boot/user")
    public Object getUser(@RequestParam int id){

    GetProductInventoryAndPriceRealInfoRequest getProductInventoryAndPriceRealInfoRequest = new GetProductInventoryAndPriceRealInfoRequest();
    getProductInventoryAndPriceRealInfoRequest.setStartDate(new ShortDate());
    getProductInventoryAndPriceRealInfoRequest.setEndDate(new ShortDate());
    getProductInventoryAndPriceRealInfoRequest.setUnitId(0L);
    getProductInventoryAndPriceRealInfoRequest.setProductId(0L);
    getProductInventoryAndPriceRealInfoRequest.setLandlordId(0L);
    Operater operater = new Operater();
    operater.setName("");
    operater.setIp("");
    operater.setTime(new Date());
    operater.setMethod("");
    operater.setChannel(0);

    getProductInventoryAndPriceRealInfoRequest.setOperater(new Operater());
    getProductInventoryAndPriceRealInfoRequest.setReconfirmPostBack(false);

//
//    AA aa = new AA();
//    aa.setFromDate(new FromDateBean());
//    aa.setRoomCount(0);
//    aa.setUserInfo(new UserInfoBean());
//    aa.setWrapperId("");
//    aa.setToDate(new ToDateBean());
//    aa.setClientInfo(new ClientInfoBean());
//    aa.setUnitId("");
//    aa.setGuestCount(0);
//    aa.setCityId(0);


    productForOpenPriceService.getProductInventoryAndPriceRealInfo(getProductInventoryAndPriceRealInfoRequest);

    return null;
}

}
