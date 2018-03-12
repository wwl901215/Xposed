package com.wwl.xposedtest.hook;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by wangwenliang on 2018/3/12.
 */

public class HooToast implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.wwl.xposedtest")) {
            Class clazz = loadPackageParam.classLoader.loadClass("com.wwl.xposedtest.MainActivity");
            XposedHelpers.findAndHookMethod(clazz, "toastMessage", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    param.setResult("你已被劫持");
                }
            });
        }
    }
}
