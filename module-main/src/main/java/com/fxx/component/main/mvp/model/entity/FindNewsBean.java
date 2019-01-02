package com.fxx.component.main.mvp.model.entity;

import java.io.Serializable;
import java.util.List;

public class FindNewsBean implements Serializable {

    /**
     * status : 1
     * message : 获取成功
     * data : {"total":510,"rows":[{"id":"5bff4df17289dc0d3794fc6d","namecn":"关于部分重点城市执行大气污染物特别排放限值的公告","created_at":"2018-11-29 10:24","category":"湖北省","city":"全省","province":"湖北省","documentNum":"2018年第2号","pubDate":"2018-07-04","implDate":"2019-01-01","isFail":0,"type":1},{"id":"5bffab38485b7c25afab522b","namecn":"餐饮业大气污染物排放标准","created_at":"2018-11-29 17:02","category":"重庆市","city":"","province":"重庆市","documentNum":"DB50/859-2018","pubDate":"2018-07-12","implDate":"2019-01-01","isFail":0,"type":2},{"id":"5bff86751fd97c17314e26c8","namecn":"山东省水污染防治条例","created_at":"2018-11-29 14:25","category":"山东省","city":"全省","province":"山东省","documentNum":"山东省第十三届人大会常务委员会第五次会议","pubDate":"2018-09-21","implDate":"2018-12-01","isFail":0,"type":1},{"id":"5bffb02e75fdf62ab888ecc1","namecn":"广东省污染地块修复后土壤再利用技术指南（征求意见稿）","created_at":"2018-11-29 17:23","category":"广东省","city":"","province":"广东省","documentNum":"","pubDate":"2018-07-16","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffafe775fdf62ab888ec8b","namecn":"广东省污染地块治理与修复环境监理技术指南（征求意见稿）","created_at":"2018-11-29 17:22","category":"广东省","city":"","province":"广东省","documentNum":"无","pubDate":"2018-07-16","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa992485b7c25afab5147","namecn":"《电镀水污染物排放标准》","created_at":"2018-11-29 16:55","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/□□□□-201□","pubDate":"2018-09-27","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa973485b7c25afab5138","namecn":"城镇污水处理厂主要水污染物排放标准（征求意见稿）","created_at":"2018-11-29 16:55","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/□□□□□-□□□□","pubDate":"2018-06-15","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8c8485b7c25afab5080","namecn":"排污单位自行监测技术指南农药制造工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8c5485b7c25afab5079","namecn":"排污单位自行监测技术指南  平板玻璃工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8b9485b7c25afab506c","namecn":"排污单位自行监测技术指南有色金属冶炼工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8b3485b7c25afab5065","namecn":"排污单位自行监测技术指南农副食品加工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bff4b8f56b3280ad23e4d6a","namecn":"油田废弃油土综合利用污染控制（征求意见稿）","created_at":"2018-11-29 10:14","category":"吉林省","city":"","province":"全国","documentNum":"DB22/127-2016","pubDate":"2016-07-14","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bff452ae21d5c099b8ea294","namecn":"环境影响评价工作指导手册系列丛书--部长信箱回复汇编","created_at":"2018-11-29 09:47","category":"部长信箱","city":"","province":"全国","documentNum":"无","pubDate":"2018-11-05","implDate":"2018-11-05","isFail":0,"type":1},{"id":"5bffa957485b7c25afab5121","namecn":"燃煤电厂大气污染物排放标准","created_at":"2018-11-29 16:54","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/2147-2018","pubDate":"2018-09-30","implDate":"2018-11-01","isFail":0,"type":2},{"id":"5bffa95e485b7c25afab5127","namecn":"工业涂装工序大气污染物排放标准","created_at":"2018-11-29 16:54","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/2146-2018","pubDate":"2018-09-30","implDate":"2018-11-01","isFail":0,"type":2},{"id":"5bff4e6c7289dc0d3794fc93","namecn":"关于进一步规范电镀行业发展的意见","created_at":"2018-11-29 10:26","category":"四川省","city":"全省","province":"四川省","documentNum":"川办发[2018]83号","pubDate":"2018-10-25","implDate":"2018-10-25","isFail":0,"type":1},{"id":"5bff4506e21d5c099b8ea290","namecn":"关于部分农村小水电项目环境影响评价文件审批相关事项的复函","created_at":"2018-11-29 09:46","category":"政策解读","city":"","province":"全国","documentNum":"环办环评函[2018]1093","pubDate":"2018-10-09","implDate":"2018-10-09","isFail":0,"type":1},{"id":"5bffaa7c485b7c25afab51cd","namecn":"生态环境信息基本数据集编制规范","created_at":"2018-11-29 16:59","category":"生态技术规范","city":"","province":"全国","documentNum":"HJ966-2018","pubDate":"2018-09-22","implDate":"2018-09-22","isFail":0,"type":2},{"id":"5bff86091fd97c17314e26b8","namecn":"新疆维吾尔自治区环境保护条例","created_at":"2018-11-29 14:24","category":"新疆维吾尔自治区","city":"全省","province":"新疆维吾尔自治区","documentNum":"新疆维吾尔自治区第十三届人大常委第六次会议","pubDate":"2018-09-21","implDate":"2018-09-21","isFail":0,"type":1},{"id":"5bff4e527289dc0d3794fc8a","namecn":"天津市生态保护红线","created_at":"2018-11-29 10:26","category":"天津市","city":"全省","province":"天津市","documentNum":"津政发[2018]21号","pubDate":"2018-09-03","implDate":"2018-09-03","isFail":0,"type":1}]}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 510
         * rows : [{"id":"5bff4df17289dc0d3794fc6d","namecn":"关于部分重点城市执行大气污染物特别排放限值的公告","created_at":"2018-11-29 10:24","category":"湖北省","city":"全省","province":"湖北省","documentNum":"2018年第2号","pubDate":"2018-07-04","implDate":"2019-01-01","isFail":0,"type":1},{"id":"5bffab38485b7c25afab522b","namecn":"餐饮业大气污染物排放标准","created_at":"2018-11-29 17:02","category":"重庆市","city":"","province":"重庆市","documentNum":"DB50/859-2018","pubDate":"2018-07-12","implDate":"2019-01-01","isFail":0,"type":2},{"id":"5bff86751fd97c17314e26c8","namecn":"山东省水污染防治条例","created_at":"2018-11-29 14:25","category":"山东省","city":"全省","province":"山东省","documentNum":"山东省第十三届人大会常务委员会第五次会议","pubDate":"2018-09-21","implDate":"2018-12-01","isFail":0,"type":1},{"id":"5bffb02e75fdf62ab888ecc1","namecn":"广东省污染地块修复后土壤再利用技术指南（征求意见稿）","created_at":"2018-11-29 17:23","category":"广东省","city":"","province":"广东省","documentNum":"","pubDate":"2018-07-16","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffafe775fdf62ab888ec8b","namecn":"广东省污染地块治理与修复环境监理技术指南（征求意见稿）","created_at":"2018-11-29 17:22","category":"广东省","city":"","province":"广东省","documentNum":"无","pubDate":"2018-07-16","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa992485b7c25afab5147","namecn":"《电镀水污染物排放标准》","created_at":"2018-11-29 16:55","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/□□□□-201□","pubDate":"2018-09-27","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa973485b7c25afab5138","namecn":"城镇污水处理厂主要水污染物排放标准（征求意见稿）","created_at":"2018-11-29 16:55","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/□□□□□-□□□□","pubDate":"2018-06-15","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8c8485b7c25afab5080","namecn":"排污单位自行监测技术指南农药制造工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8c5485b7c25afab5079","namecn":"排污单位自行监测技术指南  平板玻璃工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8b9485b7c25afab506c","namecn":"排污单位自行监测技术指南有色金属冶炼工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bffa8b3485b7c25afab5065","namecn":"排污单位自行监测技术指南农副食品加工业（征求意见稿）","created_at":"2018-11-29 16:52","category":"自行监测技术指南","city":"","province":"全国","documentNum":"HJ□□□-201□","pubDate":"2018-11-29","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bff4b8f56b3280ad23e4d6a","namecn":"油田废弃油土综合利用污染控制（征求意见稿）","created_at":"2018-11-29 10:14","category":"吉林省","city":"","province":"全国","documentNum":"DB22/127-2016","pubDate":"2016-07-14","implDate":"2018-11-29","isFail":3,"type":2},{"id":"5bff452ae21d5c099b8ea294","namecn":"环境影响评价工作指导手册系列丛书--部长信箱回复汇编","created_at":"2018-11-29 09:47","category":"部长信箱","city":"","province":"全国","documentNum":"无","pubDate":"2018-11-05","implDate":"2018-11-05","isFail":0,"type":1},{"id":"5bffa957485b7c25afab5121","namecn":"燃煤电厂大气污染物排放标准","created_at":"2018-11-29 16:54","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/2147-2018","pubDate":"2018-09-30","implDate":"2018-11-01","isFail":0,"type":2},{"id":"5bffa95e485b7c25afab5127","namecn":"工业涂装工序大气污染物排放标准","created_at":"2018-11-29 16:54","category":"浙江省","city":"","province":"浙江省","documentNum":"DB33/2146-2018","pubDate":"2018-09-30","implDate":"2018-11-01","isFail":0,"type":2},{"id":"5bff4e6c7289dc0d3794fc93","namecn":"关于进一步规范电镀行业发展的意见","created_at":"2018-11-29 10:26","category":"四川省","city":"全省","province":"四川省","documentNum":"川办发[2018]83号","pubDate":"2018-10-25","implDate":"2018-10-25","isFail":0,"type":1},{"id":"5bff4506e21d5c099b8ea290","namecn":"关于部分农村小水电项目环境影响评价文件审批相关事项的复函","created_at":"2018-11-29 09:46","category":"政策解读","city":"","province":"全国","documentNum":"环办环评函[2018]1093","pubDate":"2018-10-09","implDate":"2018-10-09","isFail":0,"type":1},{"id":"5bffaa7c485b7c25afab51cd","namecn":"生态环境信息基本数据集编制规范","created_at":"2018-11-29 16:59","category":"生态技术规范","city":"","province":"全国","documentNum":"HJ966-2018","pubDate":"2018-09-22","implDate":"2018-09-22","isFail":0,"type":2},{"id":"5bff86091fd97c17314e26b8","namecn":"新疆维吾尔自治区环境保护条例","created_at":"2018-11-29 14:24","category":"新疆维吾尔自治区","city":"全省","province":"新疆维吾尔自治区","documentNum":"新疆维吾尔自治区第十三届人大常委第六次会议","pubDate":"2018-09-21","implDate":"2018-09-21","isFail":0,"type":1},{"id":"5bff4e527289dc0d3794fc8a","namecn":"天津市生态保护红线","created_at":"2018-11-29 10:26","category":"天津市","city":"全省","province":"天津市","documentNum":"津政发[2018]21号","pubDate":"2018-09-03","implDate":"2018-09-03","isFail":0,"type":1}]
         */

        private int total;
        private List<RowsBean> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * id : 5bff4df17289dc0d3794fc6d
             * namecn : 关于部分重点城市执行大气污染物特别排放限值的公告
             * created_at : 2018-11-29 10:24
             * category : 湖北省
             * city : 全省
             * province : 湖北省
             * documentNum : 2018年第2号
             * pubDate : 2018-07-04
             * implDate : 2019-01-01
             * isFail : 0
             * type : 1
             */

            private String id;
            private String namecn;
            private String created_at;
            private String category;
            private String city;
            private String province;
            private String documentNum;
            private String pubDate;
            private String implDate;
            private int isFail;
            private int type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNamecn() {
                return namecn;
            }

            public void setNamecn(String namecn) {
                this.namecn = namecn;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getDocumentNum() {
                return documentNum;
            }

            public void setDocumentNum(String documentNum) {
                this.documentNum = documentNum;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public String getImplDate() {
                return implDate;
            }

            public void setImplDate(String implDate) {
                this.implDate = implDate;
            }

            public int getIsFail() {
                return isFail;
            }

            public void setIsFail(int isFail) {
                this.isFail = isFail;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
