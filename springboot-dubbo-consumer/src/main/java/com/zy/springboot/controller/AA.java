package com.zy.springboot.controller;

import java.util.List;

public class AA {

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

    private FromDateBean fromDate;
    private int roomCount;
    private UserInfoBean userInfo;
    private String wrapperId;
    private ToDateBean toDate;
    private ClientInfoBean clientInfo;
    private String unitId;
    private int guestCount;
    private int cityId;

    public FromDateBean getFromDate() {
        return fromDate;
    }

    public void setFromDate(FromDateBean fromDate) {
        this.fromDate = fromDate;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public String getWrapperId() {
        return wrapperId;
    }

    public void setWrapperId(String wrapperId) {
        this.wrapperId = wrapperId;
    }

    public ToDateBean getToDate() {
        return toDate;
    }

    public void setToDate(ToDateBean toDate) {
        this.toDate = toDate;
    }

    public ClientInfoBean getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfoBean clientInfo) {
        this.clientInfo = clientInfo;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public static class FromDateBean {
        /**
         * month : 5
         * year : 2020
         * day : 6
         */

        private int month;
        private int year;
        private int day;

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }
    }

    public static class UserInfoBean {
        /**
         * orderQuantities : 0
         * guestIdentityType : 0
         * userId : 0
         */

        private int orderQuantities;
        private int guestIdentityType;
        private int userId;

        public int getOrderQuantities() {
            return orderQuantities;
        }

        public void setOrderQuantities(int orderQuantities) {
            this.orderQuantities = orderQuantities;
        }

        public int getGuestIdentityType() {
            return guestIdentityType;
        }

        public void setGuestIdentityType(int guestIdentityType) {
            this.guestIdentityType = guestIdentityType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }

    public static class ToDateBean {
        /**
         * month : 5
         * year : 2020
         * day : 7
         */

        private int month;
        private int year;
        private int day;

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }
    }

    public static class ClientInfoBean {
        private List<Integer> shieldDiscountEntries;

        public List<Integer> getShieldDiscountEntries() {
            return shieldDiscountEntries;
        }

        public void setShieldDiscountEntries(List<Integer> shieldDiscountEntries) {
            this.shieldDiscountEntries = shieldDiscountEntries;
        }
    }
}
