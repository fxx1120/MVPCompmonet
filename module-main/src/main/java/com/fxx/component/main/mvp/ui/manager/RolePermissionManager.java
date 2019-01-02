package com.fxx.component.main.mvp.ui.manager;

import android.content.Context;

import com.fxx.component.commonsdk.manager.UIManager;
import com.fxx.component.commonsdk.utils.Constant;
import com.fxx.component.main.mvp.model.entity.RolePermissBean;
import com.jess.arms.utils.DataHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fxx on 2017/12/6.
 */

public class RolePermissionManager {

    private static List<String> roles = new ArrayList<>();

    public static boolean rolePermission(Context context, String s) {
        RolePermissBean bean = null;
        roles.clear();
        //无论是否为空都重新获取
        if (bean == null) {
            bean = UIManager.JsonToObject(DataHelper.getStringSF(context, Constant.COMMON_USER_ROLE), RolePermissBean.class);

                for (int i = 0; i < bean.getData().size(); i++) {
                    for (int j = 0; j < bean.getData().get(i).getPermissions().getData().size(); j++) {
                        roles.add(bean.getData().get(i).getPermissions().getData().get(j).getName());
                    }
                }

                //对比
                for (int i = 0; i < roles.size(); i++) {
                    if (s.equals(roles.get(i))) {
                        return true;
                    }
                }
                return false;


        }
        return false;
    }
}
