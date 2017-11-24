package com.zhengpu.zhengpuandroid.bean.iflytekbean;

import java.util.List;

/**
 * sayid ....
 * Created by wengmf on 2017/11/23.
 */

public  class DataBean {
    private java.util.List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * category : 社会
         * content : 听闻时刻新鲜，世界就在耳边。大家好，我是听闻主播菲雪，欢迎收听这一时段的听闻播报，让我们来关注一组社会新闻：
         1.记者23日从山东省消防工作会议上了解到，2016年该省共发生火灾22954起，死亡33人，直接财产损失2.4亿元，火灾起数、火灾亡人数和直接财产损失数同比分别下降11.4%、42.1%和17.2%，未直接发生较大以上亡人火灾事故。各级公安消防部门共接警出动6.6万余起，抢救被困群众8647人，抢救财产价值32.4亿余元。
         2.记者23日从京昆高速雅西段交警部门获悉，受持续降雪影响，京昆高速四川雅西拖乌山路段积雪结冰严重，导致道路通行受阻。23日，因京昆高速雅西段雪情进一步扩大，已不具备安全通行条件，雅西高速和国道108线公路双向实施管制。为避免车辆滞留，交警紧急关闭沿途小站，并对前往成都的车辆进行劝导，提示车主就近休息，等待天气情况好转后再上路。
         3.湖北省秭归县2月23日凌晨发生M3.8级地震，据当地官方最新通报，经全面核查，没有人员伤亡，震中区域34户68间土坯房屋轻微受损，8户水池出现渗漏。
         4.23日，苏州工业园区教育局就园区内一幼儿园外教伤害儿童的事件进行通报。教育局表示，目前当事教师已被停职检查。通报称，2月20日上午未来城幼儿园大(七)班几名教师组织开展游戏课程。其中外籍教师Casilyn负责指导名为“小医生”的游戏。游戏期间，Casilyn通过自测血糖仪器向幼儿亲身示范如何检测血糖(用针头从手指取微量血液)，“并在幼儿要求下”，也分别用一次性针头给4名幼儿进行了测试。
         5.云南省怒江消防支队23日发布，当日，怒江州正在新建的德贡公路施工段因受持续降雪影响，导致公路被积雪覆盖暂时交通中断，40余名公路施工人员被困。
         6.广西梧州市女生陈丽(应要求化名)2015年5月捐献造血干细胞，挽救了一名白血病患者的生命；两年后该名患者病情复发，已成为教师的陈丽再次“出手”，23日捐献了淋巴细胞帮助其改善病情。
         7.吕某、李某组织多名印尼籍和菲律宾籍女性，非法来华从事家政服务一案23日在北京市丰台区人民法院开庭审理，2名被告人均对起诉书指控的犯罪事实没有异议，并当庭表示认罪。据悉，此案是北京法院开庭审理的首例组织印尼籍和菲律宾籍女性非法在京劳务案。
         本档听闻播报就到这里，更多有声资讯欢迎下载听闻APP.
         本档编辑：菲雪
         新闻来源：新华网 人民网 中新网
         * description : 国际新闻（国际政治向）、时政新闻主播
         * id : 8600
         * imgUrl : http://picture.tingwen.me/Uploads/2017-02-24/crop_58af0bf35467d.jpg
         * keyWords : 社会,民生热点
         * name : 菲雪
         * publishDateTime : 2017-02-24 00:21:47
         * source : 听闻
         * time : 216000
         * title : 【听闻播报】京昆高速四川雅西段持续降雪道路通行受阻
         * url : http://mp3.tingwen.me/data/upload/mp3/58af0c0f5e36c.mp3
         */

        private String category;
        private String content;
        private String description;
        private int id;
        private String imgUrl;
        private String keyWords;
        private String name;
        private String publishDateTime;
        private String source;
        private String time;
        private String title;
        private String url;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getKeyWords() {
            return keyWords;
        }

        public void setKeyWords(String keyWords) {
            this.keyWords = keyWords;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPublishDateTime() {
            return publishDateTime;
        }

        public void setPublishDateTime(String publishDateTime) {
            this.publishDateTime = publishDateTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}