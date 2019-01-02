package com.fxx.component.main.mvp.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fxx028 on 2018/12/4.
 */

public class RolePermissBean implements Serializable{

    /**
     * data : [{"id":"v37nz49ez98g0mao","name":"drf","description":"È«²¿È¨ÏÞ","display_name":"all","type":"consulting_user","is_default":0,"status":1,"top_order":1,"permissions":{"data":[{"id":"gv438z5l4lrjawxo","name":"consulting-view-total-data","description":"view total data","display_name":"²é¿´×ÜÊý¾Ý"},{"id":"e4q30krx6zrp6voy","name":"consulting-view-contract-compare","description":"view contract compare","display_name":"²é¿´ºÏÍ¬Í¬ÆÚ¶Ô±È"},{"id":"nw0zaq9086rxob67","name":"consulting-view-contract-statistics","description":"view contract statistics","display_name":"²é¿´ºÏÍ¬Í³¼Æ"},{"id":"vk3nw69nv4raxog7","name":"consulting-view-project-statistics","description":"view project statistics","display_name":"²é¿´ÏîÄ¿Í³¼Æ"},{"id":"6kvw4g5b6zr8peod","name":"consulting-create-role","description":"create a role","display_name":"ÐÂÔö"},{"id":"o803wk5pae54mg6d","name":"consulting-view-role","description":"view role","display_name":"²é¿´"},{"id":"xzqlew5oa6rn3mk6","name":"consulting-update-role","description":"update a role","display_name":"±à¼­"},{"id":"8z7ajn5kdm9bdxl0","name":"consulting-delete-role","description":"delete a role","display_name":"É¾³ý"},{"id":"0n8lay5j6494vopk","name":"consulting-create-staff","description":"create a staff","display_name":"ÐÂÔö"},{"id":"omx8kwrgjkraep3n","name":"consulting-view-staff","description":"view a staff","display_name":"²é¿´"},{"id":"0wqvk397aq9d6a8x","name":"consulting-update-staff","description":"update a staff","display_name":"±à¼­"},{"id":"67vleb96y35azydj","name":"consulting-create-department","description":"create a department","display_name":"ÐÂÔö"},{"id":"0n8lay5j6694vopk","name":"consulting-view-department","description":"view a department","display_name":"²é¿´"},{"id":"omx8kwrgjpraep3n","name":"consulting-update-department","description":"update a department","display_name":"±à¼­"},{"id":"0wqvk397am9d6a8x","name":"consulting-delete-department","description":"delete a department","display_name":"É¾³ý"},{"id":"67vleb96yz5azydj","name":"consulting-create-contact","description":"create a contact","display_name":"ÐÂÔö"},{"id":"0ex3zvrdw79wodky","name":"consulting-list-contact","description":"list all contact","display_name":"²é¿´ËùÓÐºÏÍ¬"},{"id":"d48qz65w3mrkomvp","name":"consulting-update-contact","description":"update a contact","display_name":"±à¼­"},{"id":"avnxyq5mmv5l7oz6","name":"consulting-list-project","description":"list all project","display_name":"²é¿´ËùÓÐÏîÄ¿"},{"id":"dkb4m6ryayrowny7","name":"consulting-create-device","description":"create a device","display_name":"ÐÂÔö"},{"id":"oz7vnm58p890e386","name":"consulting-view-device","description":"view a device","display_name":"²é¿´"},{"id":"7mpykzrqzprlq48v","name":"consulting-update-device","description":"update a device","display_name":"±à¼­"},{"id":"v37nz49em4r8g0ma","name":"consulting-handle-deviceLend","description":"handle all deviceLend","display_name":"´¦Àí½è³ö"},{"id":"ode0wzr3dl9437bm","name":"consulting-handle-deviceReturn","description":"handle all deviceReturn","display_name":"´¦Àí¹é»¹"},{"id":"dby8lj5vak563qv0","name":"consulting-view-archives","description":"view all archives","display_name":"²é¿´"},{"id":"lw7ykqr4we96ob84","name":"consulting-handle-archivesLend","description":"handle all archivesLend","display_name":"´¦Àí½èÔÄ"},{"id":"bp7wvg9a789308ez","name":"consulting-handle-archivesReturn","description":"handle all archivesReturn","display_name":"´¦Àí¹é»¹"},{"id":"wadozprz0a9qlvgy","name":"consulting-create-paper-archiving","description":"create paper archiving","display_name":"Ö½ÖÊ¹éµµ"},{"id":"gv438z5lgxrjawxo","name":"consulting-create-virtual-archiving","description":"create virtual archiving","display_name":"µç×Ó¹éµµ"},{"id":"e4q30krxdw9p6voy","name":"consulting-performance-archivingCheck","description":"performance archivingCheck","display_name":"¼¨Ð§µµ°¸ºËÊµ"},{"id":"nw0zaq90knrxob67","name":"consulting-performance-approveCheck","description":"performance approveCheck","display_name":"¼¨Ð§Åú¸´ºËÊµ"},{"id":"vk3nw69n6x5axog7","name":"consulting-handle-performanceApprove","description":"handle all performanceApprove","display_name":"¼¨Ð§ºË¶¨"},{"id":"6kvw4g5b4x98peod","name":"consulting-list-performanceCount","description":"list all performanceCount","display_name":"²é¿´¼¨Ð§Í³¼Æ"},{"id":"o803wk5pw8r4mg6d","name":"consulting-export-performanceCount","description":"export all performanceCount","display_name":"µ¼³ö¼¨Ð§Í³¼Æ"},{"id":"xzqlew5odqrn3mk6","name":"consulting-performance-approved","description":"performance approved","display_name":"¼¨Ð§ÉóÅú"},{"id":"8z7ajn5kja9bdxl0","name":"consulting-deliver-approved","description":"deliberate approved","display_name":"ËÍÉóÉóÅú"},{"id":"0n8lay5j3694vopk","name":"consulting-approved-approved","description":"approved approved","display_name":"±¨ÅúÉóÅú"},{"id":"omx8kwrgppraep3n","name":"consulting-list-funds","description":"list all funds","display_name":"²é¿´µ½ÕË"},{"id":"0wqvk3977m9d6a8x","name":"consulting-create-funds","description":"create a funds","display_name":"ÐÂÔöµ½ÕË"},{"id":"67vleb96gz5azydj","name":"consulting-handle-funds","description":"handle all funds","display_name":"´¦Àíµ½ÕË"},{"id":"0ex3zvrdo75wodky","name":"consulting-view-projectReceiptPlan","description":"view a projectReceiptPlan","display_name":"²é¿´ÊÕ¿î¼Æ»®"},{"id":"d48qz65w6mrkomvp","name":"consulting-handle-projectReceiptPlan","description":"handle a projectReceiptPlan","display_name":"´¦ÀíÊÕ¿î¼Æ»®"},{"id":"avnxyq5m7v5l7oz6","name":"consulting-view-projectBill","description":"view a projectBill","display_name":"²é¿´¿ªÆ±"},{"id":"dkb4m6rywy9owny7","name":"consulting-handle-projectBill","description":"handle a projectBill","display_name":"´¦Àí¿ªÆ±"},{"id":"oz7vnm5868r0e386","name":"consulting-view-monitorProgram","description":"view a monitorProgram","display_name":"²é¿´¼ì²â·½°¸"},{"id":"7mpykzrqmp5lq48v","name":"consulting-view-monitorReport","description":"view a monitorReport","display_name":"²é¿´¼ì²â±¨¸æ"},{"id":"v37nz49e3458g0ma","name":"consulting-view-service","description":"view service","display_name":"²é¿´"},{"id":"ode0wzr3yl9437bm","name":"consulting-handle-service","description":"handle service","display_name":"´¦Àí"},{"id":"dby8lj5v7k563qv0","name":"consulting-view-auth","description":"view auth","display_name":"²é¿´ÈÏÖ¤"},{"id":"lw7ykqr48e96ob84","name":"consulting-update-auth","description":"update auth","display_name":"±à¼­ÈÏÖ¤"},{"id":"bp7wvg9av89308ez","name":"consulting-view-bail","description":"view bail","display_name":"²é¿´±£Ö¤½ð"},{"id":"wadozprzma5qlvgy","name":"consulting-pay-bail","description":"pay bail","display_name":"Ö§¸¶±£Ö¤½ð"},{"id":"gv438z5lzx9jawxo","name":"consulting-return-bail","description":"return bail","display_name":"ÍË±£Ö¤½ð"},{"id":"e4q30krxgw9p6voy","name":"consulting-view-wallet","description":"view wallet","display_name":"²é¿´Óà¶î"},{"id":"nw0zaq90znrxob67","name":"consulting-recharge-wallet","description":"recharge wallet","display_name":"³äÖµ"},{"id":"vk3nw69nzx9axog7","name":"consulting-withdraw-wallet","description":"withdraw wallet","display_name":"ÌáÏÖ"},{"id":"6kvw4g5boxr8peod","name":"consulting-create-bankCard","description":"create a bankCard","display_name":"±à¼­ÒøÐÐ¿¨"},{"id":"o803wk5p3894mg6d","name":"consulting-quality-deliver-approved","description":"deliver approved","display_name":"ËÍÉóÉóÅú"},{"id":"xzqlew5o4qrn3mk6","name":"consulting-performance-manage","description":"performance manage","display_name":"¼¨Ð§¹ÜÀí"},{"id":"8z7ajn5kna5bdxl0","name":"consulting-official-deliver-approved","description":"deliver approved","display_name":"ËÍÉóÉóÅú"},{"id":"0n8lay5jz6r4vopk","name":"consulting-official-approved-approved","description":"approved approved","display_name":"±¨ÅúÉóÅú"},{"id":"omx8kwrgxp5aep3n","name":"consulting-qualification-deliver-approved","description":"deliver approved","display_name":"ËÍÉóÉóÅú"},{"id":"0wqvk397mm9d6a8x","name":"consulting-qualification-approved-approved","description":"approved approved","display_name":"±¨ÅúÉóÅú"},{"id":"67vleb96wzrazydj","name":"consulting-basic-permission","description":"basic permission","display_name":"»ù±¾È¨ÏÞ"},{"id":"bp7wvg9apn9308ez","name":"consulting-view-staff-login-logs","description":null,"display_name":"²é¿´Ô±¹¤µÇÂ¼ÈÕÖ¾"},{"id":"wadozprz8drqlvgy","name":"AP","description":"°²È«ÆÀ¼Û","display_name":"°²È«ÆÀ¼Û"},{"id":"gv438z5lky9jawxo","name":"HP","description":"»·¾³ÆÀ¼Û","display_name":"»·¾³ÆÀ¼Û"},{"id":"e4q30krxm09p6voy","name":"ZP","description":"ÖÊÁ¿ÆÀ¼Û","display_name":"ÖÊÁ¿ÆÀ¼Û"},{"id":"nw0zaq90q0rxob67","name":"consulting-view-project-files","description":"view project files","display_name":"²é¿´ÏîÄ¿ÎÄ¼þ"},{"id":"vk3nw69n3v5axog7","name":"consulting-create-public-resource","description":"create public resource","display_name":"ÉÏ´«"},{"id":"6kvw4g5bp698peod","name":"consulting-delete-public-resource","description":"delete public resource","display_name":"É¾³ý"},{"id":"o803wk5p4w54mg6d","name":"consulting-database-download-approved","description":"consulting-database-download-approved","display_name":"×ÊÁÏÏÂÔØÉóÅú"},{"id":"xzqlew5ov4rn3mk6","name":"consulting-task-view","description":"consulting task view","display_name":"²é¿´ÈÎÎñ¹ý³Ì"},{"id":"0n8lay5jy854vopk","name":"consulting-task-all-create","description":"consulting task create all","display_name":"·¢²¼ËùÓÐÈÎÎñ"},{"id":"omx8kwrgd6raep3n","name":"consulting-contract-review-financial","description":"²ÆÎñÉóÅú","display_name":"²ÆÎñÉóÅú"},{"id":"0wqvk397xjrd6a8x","name":"consulting-contract-review-signature","description":"¸ÇÕÂÉóÅú","display_name":"¸ÇÕÂÉóÅú"},{"id":"67vleb96xx9azydj","name":"consulting-contract-review-parallel","description":"²¢ÁªÆÀ¼Û","display_name":"²¢ÁªÆÀ¼Û"},{"id":"0ex3zvrdgdrwodky","name":"consulting-contract-review-AP","description":"°²È«ÆÀ¼Û","display_name":"°²È«ÆÀ¼Û"},{"id":"d48qz65wwp5komvp","name":"consulting-contract-review-HP","description":"»·¾³ÆÀ¼Û","display_name":"»·¾³ÆÀ¼Û"},{"id":"avnxyq5me6rl7oz6","name":"consulting-contract-review-ZP","description":"ÖÊÁ¿ÆÀ¼Û","display_name":"ÖÊÁ¿ÆÀ¼Û"},{"id":"ode0wzr3ve9437bm","name":"consulting-document-issued-manager","description":"¸±×Ü×ÜÖúÎÄ¼þÇ©·¢ÉóÅú","display_name":"¸±×Ü×ÜÖúÎÄ¼þÇ©·¢ÉóÅú"},{"id":"dby8lj5vb0r63qv0","name":"consulting-evaluation-type-AP","description":"°²È«ÆÀ¼Û","display_name":"°²È«ÆÀ¼Û"},{"id":"lw7ykqr4dpr6ob84","name":"consulting-evaluation-type-HP","description":"»·¾³ÆÀ¼Û","display_name":"»·¾³ÆÀ¼Û"},{"id":"bp7wvg9agn9308ez","name":"consulting-evaluation-type-ZP","description":"ÖÊÁ¿ÆÀ¼Û","display_name":"ÖÊÁ¿ÆÀ¼Û"},{"id":"wadozprzbdrqlvgy","name":"consulting-contract-special-approval-financial","description":"²ÆÎñ¸ºÔðÈËÉóÅú","display_name":"²ÆÎñ¸ºÔðÈËÉóÅú"},{"id":"gv438z5lvyrjawxo","name":"consulting-contract-special-approval-projectType","description":"ÆÀ¼ÛÀàÐÍ×Ü¸ºÔðÈËÉóÅú","display_name":"ÆÀ¼ÛÀàÐÍ×Ü¸ºÔðÈËÉóÅú"},{"id":"e4q30krxb05p6voy","name":"consulting-contract-special-approval-parallel","description":"²¢ÁªÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"²¢ÁªÆÀ¼Û¸ºÔðÈËÉóÅú"},{"id":"nw0zaq90j05xob67","name":"consulting-contract-special-approval-AP","description":"°²È«ÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"°²È«ÆÀ¼Û¸ºÔðÈËÉóÅú"},{"id":"vk3nw69navraxog7","name":"consulting-contract-special-approval-HP","description":"»·¾³ÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"»·¾³ÆÀ¼Û¸ºÔðÈËÉóÅú"},{"id":"6kvw4g5b7698peod","name":"consulting-contract-special-approval-ZP","description":"ÖÊÁ¿ÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"ÖÊÁ¿ÆÀ¼Û¸ºÔðÈËÉóÅú"}]}}]
     * meta : {"include":["permissions"],"custom":[]}
     */

    private MetaBean meta;
    private List<DataBeanX> data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class MetaBean {
        private List<String> include;
        private List<?> custom;

        public List<String> getInclude() {
            return include;
        }

        public void setInclude(List<String> include) {
            this.include = include;
        }

        public List<?> getCustom() {
            return custom;
        }

        public void setCustom(List<?> custom) {
            this.custom = custom;
        }
    }

    public static class DataBeanX {
        /**
         * id : v37nz49ez98g0mao
         * name : drf
         * description : È«²¿È¨ÏÞ
         * display_name : all
         * type : consulting_user
         * is_default : 0
         * status : 1
         * top_order : 1
         * permissions : {"data":[{"id":"gv438z5l4lrjawxo","name":"consulting-view-total-data","description":"view total data","display_name":"²é¿´×ÜÊý¾Ý"},{"id":"e4q30krx6zrp6voy","name":"consulting-view-contract-compare","description":"view contract compare","display_name":"²é¿´ºÏÍ¬Í¬ÆÚ¶Ô±È"},{"id":"nw0zaq9086rxob67","name":"consulting-view-contract-statistics","description":"view contract statistics","display_name":"²é¿´ºÏÍ¬Í³¼Æ"},{"id":"vk3nw69nv4raxog7","name":"consulting-view-project-statistics","description":"view project statistics","display_name":"²é¿´ÏîÄ¿Í³¼Æ"},{"id":"6kvw4g5b6zr8peod","name":"consulting-create-role","description":"create a role","display_name":"ÐÂÔö"},{"id":"o803wk5pae54mg6d","name":"consulting-view-role","description":"view role","display_name":"²é¿´"},{"id":"xzqlew5oa6rn3mk6","name":"consulting-update-role","description":"update a role","display_name":"±à¼­"},{"id":"8z7ajn5kdm9bdxl0","name":"consulting-delete-role","description":"delete a role","display_name":"É¾³ý"},{"id":"0n8lay5j6494vopk","name":"consulting-create-staff","description":"create a staff","display_name":"ÐÂÔö"},{"id":"omx8kwrgjkraep3n","name":"consulting-view-staff","description":"view a staff","display_name":"²é¿´"},{"id":"0wqvk397aq9d6a8x","name":"consulting-update-staff","description":"update a staff","display_name":"±à¼­"},{"id":"67vleb96y35azydj","name":"consulting-create-department","description":"create a department","display_name":"ÐÂÔö"},{"id":"0n8lay5j6694vopk","name":"consulting-view-department","description":"view a department","display_name":"²é¿´"},{"id":"omx8kwrgjpraep3n","name":"consulting-update-department","description":"update a department","display_name":"±à¼­"},{"id":"0wqvk397am9d6a8x","name":"consulting-delete-department","description":"delete a department","display_name":"É¾³ý"},{"id":"67vleb96yz5azydj","name":"consulting-create-contact","description":"create a contact","display_name":"ÐÂÔö"},{"id":"0ex3zvrdw79wodky","name":"consulting-list-contact","description":"list all contact","display_name":"²é¿´ËùÓÐºÏÍ¬"},{"id":"d48qz65w3mrkomvp","name":"consulting-update-contact","description":"update a contact","display_name":"±à¼­"},{"id":"avnxyq5mmv5l7oz6","name":"consulting-list-project","description":"list all project","display_name":"²é¿´ËùÓÐÏîÄ¿"},{"id":"dkb4m6ryayrowny7","name":"consulting-create-device","description":"create a device","display_name":"ÐÂÔö"},{"id":"oz7vnm58p890e386","name":"consulting-view-device","description":"view a device","display_name":"²é¿´"},{"id":"7mpykzrqzprlq48v","name":"consulting-update-device","description":"update a device","display_name":"±à¼­"},{"id":"v37nz49em4r8g0ma","name":"consulting-handle-deviceLend","description":"handle all deviceLend","display_name":"´¦Àí½è³ö"},{"id":"ode0wzr3dl9437bm","name":"consulting-handle-deviceReturn","description":"handle all deviceReturn","display_name":"´¦Àí¹é»¹"},{"id":"dby8lj5vak563qv0","name":"consulting-view-archives","description":"view all archives","display_name":"²é¿´"},{"id":"lw7ykqr4we96ob84","name":"consulting-handle-archivesLend","description":"handle all archivesLend","display_name":"´¦Àí½èÔÄ"},{"id":"bp7wvg9a789308ez","name":"consulting-handle-archivesReturn","description":"handle all archivesReturn","display_name":"´¦Àí¹é»¹"},{"id":"wadozprz0a9qlvgy","name":"consulting-create-paper-archiving","description":"create paper archiving","display_name":"Ö½ÖÊ¹éµµ"},{"id":"gv438z5lgxrjawxo","name":"consulting-create-virtual-archiving","description":"create virtual archiving","display_name":"µç×Ó¹éµµ"},{"id":"e4q30krxdw9p6voy","name":"consulting-performance-archivingCheck","description":"performance archivingCheck","display_name":"¼¨Ð§µµ°¸ºËÊµ"},{"id":"nw0zaq90knrxob67","name":"consulting-performance-approveCheck","description":"performance approveCheck","display_name":"¼¨Ð§Åú¸´ºËÊµ"},{"id":"vk3nw69n6x5axog7","name":"consulting-handle-performanceApprove","description":"handle all performanceApprove","display_name":"¼¨Ð§ºË¶¨"},{"id":"6kvw4g5b4x98peod","name":"consulting-list-performanceCount","description":"list all performanceCount","display_name":"²é¿´¼¨Ð§Í³¼Æ"},{"id":"o803wk5pw8r4mg6d","name":"consulting-export-performanceCount","description":"export all performanceCount","display_name":"µ¼³ö¼¨Ð§Í³¼Æ"},{"id":"xzqlew5odqrn3mk6","name":"consulting-performance-approved","description":"performance approved","display_name":"¼¨Ð§ÉóÅú"},{"id":"8z7ajn5kja9bdxl0","name":"consulting-deliver-approved","description":"deliberate approved","display_name":"ËÍÉóÉóÅú"},{"id":"0n8lay5j3694vopk","name":"consulting-approved-approved","description":"approved approved","display_name":"±¨ÅúÉóÅú"},{"id":"omx8kwrgppraep3n","name":"consulting-list-funds","description":"list all funds","display_name":"²é¿´µ½ÕË"},{"id":"0wqvk3977m9d6a8x","name":"consulting-create-funds","description":"create a funds","display_name":"ÐÂÔöµ½ÕË"},{"id":"67vleb96gz5azydj","name":"consulting-handle-funds","description":"handle all funds","display_name":"´¦Àíµ½ÕË"},{"id":"0ex3zvrdo75wodky","name":"consulting-view-projectReceiptPlan","description":"view a projectReceiptPlan","display_name":"²é¿´ÊÕ¿î¼Æ»®"},{"id":"d48qz65w6mrkomvp","name":"consulting-handle-projectReceiptPlan","description":"handle a projectReceiptPlan","display_name":"´¦ÀíÊÕ¿î¼Æ»®"},{"id":"avnxyq5m7v5l7oz6","name":"consulting-view-projectBill","description":"view a projectBill","display_name":"²é¿´¿ªÆ±"},{"id":"dkb4m6rywy9owny7","name":"consulting-handle-projectBill","description":"handle a projectBill","display_name":"´¦Àí¿ªÆ±"},{"id":"oz7vnm5868r0e386","name":"consulting-view-monitorProgram","description":"view a monitorProgram","display_name":"²é¿´¼ì²â·½°¸"},{"id":"7mpykzrqmp5lq48v","name":"consulting-view-monitorReport","description":"view a monitorReport","display_name":"²é¿´¼ì²â±¨¸æ"},{"id":"v37nz49e3458g0ma","name":"consulting-view-service","description":"view service","display_name":"²é¿´"},{"id":"ode0wzr3yl9437bm","name":"consulting-handle-service","description":"handle service","display_name":"´¦Àí"},{"id":"dby8lj5v7k563qv0","name":"consulting-view-auth","description":"view auth","display_name":"²é¿´ÈÏÖ¤"},{"id":"lw7ykqr48e96ob84","name":"consulting-update-auth","description":"update auth","display_name":"±à¼­ÈÏÖ¤"},{"id":"bp7wvg9av89308ez","name":"consulting-view-bail","description":"view bail","display_name":"²é¿´±£Ö¤½ð"},{"id":"wadozprzma5qlvgy","name":"consulting-pay-bail","description":"pay bail","display_name":"Ö§¸¶±£Ö¤½ð"},{"id":"gv438z5lzx9jawxo","name":"consulting-return-bail","description":"return bail","display_name":"ÍË±£Ö¤½ð"},{"id":"e4q30krxgw9p6voy","name":"consulting-view-wallet","description":"view wallet","display_name":"²é¿´Óà¶î"},{"id":"nw0zaq90znrxob67","name":"consulting-recharge-wallet","description":"recharge wallet","display_name":"³äÖµ"},{"id":"vk3nw69nzx9axog7","name":"consulting-withdraw-wallet","description":"withdraw wallet","display_name":"ÌáÏÖ"},{"id":"6kvw4g5boxr8peod","name":"consulting-create-bankCard","description":"create a bankCard","display_name":"±à¼­ÒøÐÐ¿¨"},{"id":"o803wk5p3894mg6d","name":"consulting-quality-deliver-approved","description":"deliver approved","display_name":"ËÍÉóÉóÅú"},{"id":"xzqlew5o4qrn3mk6","name":"consulting-performance-manage","description":"performance manage","display_name":"¼¨Ð§¹ÜÀí"},{"id":"8z7ajn5kna5bdxl0","name":"consulting-official-deliver-approved","description":"deliver approved","display_name":"ËÍÉóÉóÅú"},{"id":"0n8lay5jz6r4vopk","name":"consulting-official-approved-approved","description":"approved approved","display_name":"±¨ÅúÉóÅú"},{"id":"omx8kwrgxp5aep3n","name":"consulting-qualification-deliver-approved","description":"deliver approved","display_name":"ËÍÉóÉóÅú"},{"id":"0wqvk397mm9d6a8x","name":"consulting-qualification-approved-approved","description":"approved approved","display_name":"±¨ÅúÉóÅú"},{"id":"67vleb96wzrazydj","name":"consulting-basic-permission","description":"basic permission","display_name":"»ù±¾È¨ÏÞ"},{"id":"bp7wvg9apn9308ez","name":"consulting-view-staff-login-logs","description":null,"display_name":"²é¿´Ô±¹¤µÇÂ¼ÈÕÖ¾"},{"id":"wadozprz8drqlvgy","name":"AP","description":"°²È«ÆÀ¼Û","display_name":"°²È«ÆÀ¼Û"},{"id":"gv438z5lky9jawxo","name":"HP","description":"»·¾³ÆÀ¼Û","display_name":"»·¾³ÆÀ¼Û"},{"id":"e4q30krxm09p6voy","name":"ZP","description":"ÖÊÁ¿ÆÀ¼Û","display_name":"ÖÊÁ¿ÆÀ¼Û"},{"id":"nw0zaq90q0rxob67","name":"consulting-view-project-files","description":"view project files","display_name":"²é¿´ÏîÄ¿ÎÄ¼þ"},{"id":"vk3nw69n3v5axog7","name":"consulting-create-public-resource","description":"create public resource","display_name":"ÉÏ´«"},{"id":"6kvw4g5bp698peod","name":"consulting-delete-public-resource","description":"delete public resource","display_name":"É¾³ý"},{"id":"o803wk5p4w54mg6d","name":"consulting-database-download-approved","description":"consulting-database-download-approved","display_name":"×ÊÁÏÏÂÔØÉóÅú"},{"id":"xzqlew5ov4rn3mk6","name":"consulting-task-view","description":"consulting task view","display_name":"²é¿´ÈÎÎñ¹ý³Ì"},{"id":"0n8lay5jy854vopk","name":"consulting-task-all-create","description":"consulting task create all","display_name":"·¢²¼ËùÓÐÈÎÎñ"},{"id":"omx8kwrgd6raep3n","name":"consulting-contract-review-financial","description":"²ÆÎñÉóÅú","display_name":"²ÆÎñÉóÅú"},{"id":"0wqvk397xjrd6a8x","name":"consulting-contract-review-signature","description":"¸ÇÕÂÉóÅú","display_name":"¸ÇÕÂÉóÅú"},{"id":"67vleb96xx9azydj","name":"consulting-contract-review-parallel","description":"²¢ÁªÆÀ¼Û","display_name":"²¢ÁªÆÀ¼Û"},{"id":"0ex3zvrdgdrwodky","name":"consulting-contract-review-AP","description":"°²È«ÆÀ¼Û","display_name":"°²È«ÆÀ¼Û"},{"id":"d48qz65wwp5komvp","name":"consulting-contract-review-HP","description":"»·¾³ÆÀ¼Û","display_name":"»·¾³ÆÀ¼Û"},{"id":"avnxyq5me6rl7oz6","name":"consulting-contract-review-ZP","description":"ÖÊÁ¿ÆÀ¼Û","display_name":"ÖÊÁ¿ÆÀ¼Û"},{"id":"ode0wzr3ve9437bm","name":"consulting-document-issued-manager","description":"¸±×Ü×ÜÖúÎÄ¼þÇ©·¢ÉóÅú","display_name":"¸±×Ü×ÜÖúÎÄ¼þÇ©·¢ÉóÅú"},{"id":"dby8lj5vb0r63qv0","name":"consulting-evaluation-type-AP","description":"°²È«ÆÀ¼Û","display_name":"°²È«ÆÀ¼Û"},{"id":"lw7ykqr4dpr6ob84","name":"consulting-evaluation-type-HP","description":"»·¾³ÆÀ¼Û","display_name":"»·¾³ÆÀ¼Û"},{"id":"bp7wvg9agn9308ez","name":"consulting-evaluation-type-ZP","description":"ÖÊÁ¿ÆÀ¼Û","display_name":"ÖÊÁ¿ÆÀ¼Û"},{"id":"wadozprzbdrqlvgy","name":"consulting-contract-special-approval-financial","description":"²ÆÎñ¸ºÔðÈËÉóÅú","display_name":"²ÆÎñ¸ºÔðÈËÉóÅú"},{"id":"gv438z5lvyrjawxo","name":"consulting-contract-special-approval-projectType","description":"ÆÀ¼ÛÀàÐÍ×Ü¸ºÔðÈËÉóÅú","display_name":"ÆÀ¼ÛÀàÐÍ×Ü¸ºÔðÈËÉóÅú"},{"id":"e4q30krxb05p6voy","name":"consulting-contract-special-approval-parallel","description":"²¢ÁªÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"²¢ÁªÆÀ¼Û¸ºÔðÈËÉóÅú"},{"id":"nw0zaq90j05xob67","name":"consulting-contract-special-approval-AP","description":"°²È«ÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"°²È«ÆÀ¼Û¸ºÔðÈËÉóÅú"},{"id":"vk3nw69navraxog7","name":"consulting-contract-special-approval-HP","description":"»·¾³ÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"»·¾³ÆÀ¼Û¸ºÔðÈËÉóÅú"},{"id":"6kvw4g5b7698peod","name":"consulting-contract-special-approval-ZP","description":"ÖÊÁ¿ÆÀ¼Û¸ºÔðÈËÉóÅú","display_name":"ÖÊÁ¿ÆÀ¼Û¸ºÔðÈËÉóÅú"}]}
         */

        private String id;
        private String name;
        private String description;
        private String display_name;
        private String type;
        private int is_default;
        private int status;
        private int top_order;
        private PermissionsBean permissions;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTop_order() {
            return top_order;
        }

        public void setTop_order(int top_order) {
            this.top_order = top_order;
        }

        public PermissionsBean getPermissions() {
            return permissions;
        }

        public void setPermissions(PermissionsBean permissions) {
            this.permissions = permissions;
        }

        public static class PermissionsBean {
            private List<DataBean> data;

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * id : gv438z5l4lrjawxo
                 * name : consulting-view-total-data
                 * description : view total data
                 * display_name : ²é¿´×ÜÊý¾Ý
                 */

                private String id;
                private String name;
                private String description;
                private String display_name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getDisplay_name() {
                    return display_name;
                }

                public void setDisplay_name(String display_name) {
                    this.display_name = display_name;
                }
            }
        }
    }
}
