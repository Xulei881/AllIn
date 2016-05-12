package com.xulei.allin.model;

/**
 * Created by xulei on 2016/5/12.
 */
public class IdCardModel {
    private String resultcode;
    private String reason;
    private IdCard result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public IdCard getResult() {
        return result;
    }

    public void setResult(IdCard result) {
        this.result = result;
    }

    public static class IdCard {
        private String area;
        private String sex;
        private String birthday;

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
