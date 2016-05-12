package com.xulei.allin.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xulei on 2016/5/12.
 */
public class LaughModel {
    private int error_code;
    private String reason;
    private LaughResult result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LaughResult getResult() {
        return result;
    }

    public void setResult(LaughResult result) {
        this.result = result;
    }

    public static class LaughResult implements Serializable {
        private List<LaughData> data;

        public List<LaughData> getData() {
            return data;
        }

        public void setData(List<LaughData> data) {
            this.data = data;
        }

        public static class LaughData implements Serializable {
            private String content;
            private String hashId;
            private String unixtime;
            private String updatetime;

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(String unixtime) {
                this.unixtime = unixtime;
            }
        }
    }
}
