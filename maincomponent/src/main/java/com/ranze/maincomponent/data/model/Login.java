package com.ranze.maincomponent.data.model;

import com.ranze.basiclib.repository.remote.model.BaseModel;

import java.util.List;

/**
 * Created by luyong01 on 2018/2/12.
 */

public class Login extends BaseModel {


    /**
     * loginType : 1
     * clientId : f5e44811490f4e0b24e0523bc2521448cfd59173fe535bd827c661f885a2b4bf19af948b29126507fa192b2998cc387eee3eac5bb14e47db
     * effectTime : 2147483647
     * code : 200
     * account : {"id":446409,"userName":"0_luyong0506@163.com","type":0,"status":0,"whitelistAuthority":0,"createTime":0,"salt":"","tokenVersion":0,"ban":0,"baoyueVersion":0,"donateVersion":0,"vipType":0,"viptypeVersion":0,"anonimousUser":false}
     * profile : {"userId":446409,"vipType":0,"accountStatus":0,"nickname":"ranze","province":320000,"defaultAvatar":false,"avatarUrl":"http://p1.music.126.net/XlazzJgQ9eXhjWwWvCDo6g==/7985752953964355.jpg","gender":1,"birthday":-2209017600000,"city":320100,"mutual":false,"remarkName":null,"expertTags":null,"experts":{},"avatarImgId":7985752953964355,"backgroundImgId":2002210674180203,"userType":0,"authStatus":0,"backgroundUrl":"http://p1.music.126.net/bmA_ablsXpq3Tk9HlEg9sA==/2002210674180203.jpg","description":"","detailDescription":"","djStatus":0,"followed":false,"avatarImgIdStr":"7985752953964355","backgroundImgIdStr":"2002210674180203","signature":"","authority":0}
     * bindings : [{"url":"","tokenJsonStr":"{\"countrycode\":\"\",\"cellphone\":\"17621652365\",\"hasPassword\":true}","userId":446409,"expired":false,"expiresIn":2147483647,"refreshTime":1515167163,"id":6518920453,"type":1},{"url":"","tokenJsonStr":"{\"access_token\":\"iMnydpuoGHMilG6B_95W2RaAnvNFpTEMkHzf47jQZrRMKR83Ps3HNd_sRQwwzAUGEN8-kEOhgyFGHM5-RiPW3E9rcMa-wUEv8Rt6lH1P4Gk\",\"refresh_token\":\"Qf3Z8pQxE62fvuOmvFS9cM0ihprIJyQ-Gak7djg9PbSqD93uuVyezZS4UNRMHWF2RKIPlGk9NNB19CE-OKMMBuT5pY4Idm-tuOz8FYk-QfE\",\"unionid\":\"oZoefuJZWb43tqQXn3xH8JV7zQjA\",\"openid\":\"okvmMjvYUEXSspmivJ3T9QFWyVGI\",\"scope\":\"snsapi_userinfo\",\"nickname\":\"ly\",\"expires_in\":7200}","userId":446409,"expired":true,"expiresIn":7200,"refreshTime":1494250295,"id":2892579041,"type":10},{"url":"","tokenJsonStr":"{\"email\":\"luyong0506@163.com\"}","userId":446409,"expired":false,"expiresIn":2147483647,"refreshTime":1395744972,"id":3747716,"type":0}]
     */

    private int loginType;
    private String clientId;
    private int effectTime;
    private AccountBean account;
    private ProfileBean profile;
    private List<BindingsBean> bindings;

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(int effectTime) {
        this.effectTime = effectTime;
    }

    public AccountBean getAccount() {
        return account;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public List<BindingsBean> getBindings() {
        return bindings;
    }

    public void setBindings(List<BindingsBean> bindings) {
        this.bindings = bindings;
    }

    public static class AccountBean {
        /**
         * id : 446409
         * userName : 0_luyong0506@163.com
         * type : 0
         * status : 0
         * whitelistAuthority : 0
         * createTime : 0
         * salt :
         * tokenVersion : 0
         * ban : 0
         * baoyueVersion : 0
         * donateVersion : 0
         * vipType : 0
         * viptypeVersion : 0
         * anonimousUser : false
         */

        private int id;
        private String userName;
        private int type;
        private int status;
        private int whitelistAuthority;
        private int createTime;
        private String salt;
        private int tokenVersion;
        private int ban;
        private int baoyueVersion;
        private int donateVersion;
        private int vipType;
        private int viptypeVersion;
        private boolean anonimousUser;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getWhitelistAuthority() {
            return whitelistAuthority;
        }

        public void setWhitelistAuthority(int whitelistAuthority) {
            this.whitelistAuthority = whitelistAuthority;
        }

        public int getCreateTime() {
            return createTime;
        }

        public void setCreateTime(int createTime) {
            this.createTime = createTime;
        }

        public String getSalt() {
            return salt;
        }

        public void setSalt(String salt) {
            this.salt = salt;
        }

        public int getTokenVersion() {
            return tokenVersion;
        }

        public void setTokenVersion(int tokenVersion) {
            this.tokenVersion = tokenVersion;
        }

        public int getBan() {
            return ban;
        }

        public void setBan(int ban) {
            this.ban = ban;
        }

        public int getBaoyueVersion() {
            return baoyueVersion;
        }

        public void setBaoyueVersion(int baoyueVersion) {
            this.baoyueVersion = baoyueVersion;
        }

        public int getDonateVersion() {
            return donateVersion;
        }

        public void setDonateVersion(int donateVersion) {
            this.donateVersion = donateVersion;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getViptypeVersion() {
            return viptypeVersion;
        }

        public void setViptypeVersion(int viptypeVersion) {
            this.viptypeVersion = viptypeVersion;
        }

        public boolean isAnonimousUser() {
            return anonimousUser;
        }

        public void setAnonimousUser(boolean anonimousUser) {
            this.anonimousUser = anonimousUser;
        }
    }

    public static class ProfileBean {
        /**
         * userId : 446409
         * vipType : 0
         * accountStatus : 0
         * nickname : ranze
         * province : 320000
         * defaultAvatar : false
         * avatarUrl : http://p1.music.126.net/XlazzJgQ9eXhjWwWvCDo6g==/7985752953964355.jpg
         * gender : 1
         * birthday : -2209017600000
         * city : 320100
         * mutual : false
         * remarkName : null
         * expertTags : null
         * experts : {}
         * avatarImgId : 7985752953964355
         * backgroundImgId : 2002210674180203
         * userType : 0
         * authStatus : 0
         * backgroundUrl : http://p1.music.126.net/bmA_ablsXpq3Tk9HlEg9sA==/2002210674180203.jpg
         * description :
         * detailDescription :
         * djStatus : 0
         * followed : false
         * avatarImgIdStr : 7985752953964355
         * backgroundImgIdStr : 2002210674180203
         * signature :
         * authority : 0
         */

        private int userId;
        private int vipType;
        private int accountStatus;
        private String nickname;
        private int province;
        private boolean defaultAvatar;
        private String avatarUrl;
        private int gender;
        private long birthday;
        private int city;
        private boolean mutual;
        private Object remarkName;
        private Object expertTags;
        private ExpertsBean experts;
        private long avatarImgId;
        private long backgroundImgId;
        private int userType;
        private int authStatus;
        private String backgroundUrl;
        private String description;
        private String detailDescription;
        private int djStatus;
        private boolean followed;
        private String avatarImgIdStr;
        private String backgroundImgIdStr;
        private String signature;
        private int authority;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVipType() {
            return vipType;
        }

        public void setVipType(int vipType) {
            this.vipType = vipType;
        }

        public int getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(int accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public boolean isDefaultAvatar() {
            return defaultAvatar;
        }

        public void setDefaultAvatar(boolean defaultAvatar) {
            this.defaultAvatar = defaultAvatar;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
        }

        public Object getExpertTags() {
            return expertTags;
        }

        public void setExpertTags(Object expertTags) {
            this.expertTags = expertTags;
        }

        public ExpertsBean getExperts() {
            return experts;
        }

        public void setExperts(ExpertsBean experts) {
            this.experts = experts;
        }

        public long getAvatarImgId() {
            return avatarImgId;
        }

        public void setAvatarImgId(long avatarImgId) {
            this.avatarImgId = avatarImgId;
        }

        public long getBackgroundImgId() {
            return backgroundImgId;
        }

        public void setBackgroundImgId(long backgroundImgId) {
            this.backgroundImgId = backgroundImgId;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public String getBackgroundUrl() {
            return backgroundUrl;
        }

        public void setBackgroundUrl(String backgroundUrl) {
            this.backgroundUrl = backgroundUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDetailDescription() {
            return detailDescription;
        }

        public void setDetailDescription(String detailDescription) {
            this.detailDescription = detailDescription;
        }

        public int getDjStatus() {
            return djStatus;
        }

        public void setDjStatus(int djStatus) {
            this.djStatus = djStatus;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public String getAvatarImgIdStr() {
            return avatarImgIdStr;
        }

        public void setAvatarImgIdStr(String avatarImgIdStr) {
            this.avatarImgIdStr = avatarImgIdStr;
        }

        public String getBackgroundImgIdStr() {
            return backgroundImgIdStr;
        }

        public void setBackgroundImgIdStr(String backgroundImgIdStr) {
            this.backgroundImgIdStr = backgroundImgIdStr;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getAuthority() {
            return authority;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public static class ExpertsBean {
        }
    }

    public static class BindingsBean {
        /**
         * url :
         * tokenJsonStr : {"countrycode":"","cellphone":"17621652365","hasPassword":true}
         * userId : 446409
         * expired : false
         * expiresIn : 2147483647
         * refreshTime : 1515167163
         * id : 6518920453
         * type : 1
         */

        private String url;
        private String tokenJsonStr;
        private int userId;
        private boolean expired;
        private int expiresIn;
        private int refreshTime;
        private long id;
        private int type;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTokenJsonStr() {
            return tokenJsonStr;
        }

        public void setTokenJsonStr(String tokenJsonStr) {
            this.tokenJsonStr = tokenJsonStr;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public boolean isExpired() {
            return expired;
        }

        public void setExpired(boolean expired) {
            this.expired = expired;
        }

        public int getExpiresIn() {
            return expiresIn;
        }

        public void setExpiresIn(int expiresIn) {
            this.expiresIn = expiresIn;
        }

        public int getRefreshTime() {
            return refreshTime;
        }

        public void setRefreshTime(int refreshTime) {
            this.refreshTime = refreshTime;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
