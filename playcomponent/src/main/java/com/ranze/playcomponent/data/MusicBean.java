package com.ranze.playcomponent.data;

import com.ranze.basiclib.repository.remote.bean.BaseFeedBean;

import java.util.List;

/**
 * Created by ranze on 2018/3/3.
 */

public class MusicBean {

    /**
     * data : [{"id":26289183,"url":"http://m10.music.126.net/20180303225333/0780823aef3ef1b4ff0ca14f4715484b/ymusic/f104/f26f/3c77/e7597f12a3df95b572667a889dd3db1b.mp3","br":128000,"size":6264095,"md5":"e7597f12a3df95b572667a889dd3db1b","code":200,"expi":1200,"type":"mp3","gain":-2.0E-4,"fee":8,"uf":null,"payed":0,"flag":0,"canExtend":false},{"id":146561,"url":"http://m10.music.126.net/20180303225333/f5ca36a4ae2c0e9100f8912a43adc10e/ymusic/fb65/60fa/74a1/f927dbf4bc10df308fc2a4d07479551b.mp3","br":320000,"size":10617370,"md5":"f927dbf4bc10df308fc2a4d07479551b","code":200,"expi":1200,"type":"mp3","gain":-2.0E-4,"fee":0,"uf":null,"payed":0,"flag":0,"canExtend":false}]
     * code : 200
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends BaseFeedBean {
        /**
         * id : 26289183
         * url : http://m10.music.126.net/20180303225333/0780823aef3ef1b4ff0ca14f4715484b/ymusic/f104/f26f/3c77/e7597f12a3df95b572667a889dd3db1b.mp3
         * br : 128000
         * size : 6264095
         * md5 : e7597f12a3df95b572667a889dd3db1b
         * code : 200
         * expi : 1200
         * type : mp3
         * gain : -2.0E-4
         * fee : 8
         * uf : null
         * payed : 0
         * flag : 0
         * canExtend : false
         */

        private int id;
        private String url;
        private int br;
        private int size;
        private String md5;
        private int mCode;
        private int expi;
        private String type;
        private double gain;
        private int fee;
        private Object uf;
        private int payed;
        private int flag;
        private boolean canExtend;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getBr() {
            return br;
        }

        public void setBr(int br) {
            this.br = br;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public int getCode() {
            return mCode;
        }

        public void setCode(int code) {
            this.mCode = code;
        }

        public int getExpi() {
            return expi;
        }

        public void setExpi(int expi) {
            this.expi = expi;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getGain() {
            return gain;
        }

        public void setGain(double gain) {
            this.gain = gain;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public Object getUf() {
            return uf;
        }

        public void setUf(Object uf) {
            this.uf = uf;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public void setCanExtend(boolean canExtend) {
            this.canExtend = canExtend;
        }
    }
}
