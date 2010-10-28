package com.commsen.liferay.portlet.customglobalmarkup.service;

import com.commsen.liferay.portlet.customglobalmarkup.model.MarkupClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    public static final String SERVLET_CONTEXT_NAME = "custom-global-markup-portlet";
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static ClassLoader _classLoader;

    public static void setClassLoader(ClassLoader classLoader) {
        _classLoader = classLoader;
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(MarkupClp.class.getName())) {
            MarkupClp oldCplModel = (MarkupClp) oldModel;

            ClassLoader contextClassLoader = Thread.currentThread()
                                                   .getContextClassLoader();

            try {
                Thread.currentThread().setContextClassLoader(_classLoader);

                try {
                    Class<?> newModelClass = Class.forName("com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupImpl",
                            true, _classLoader);

                    Object newModel = newModelClass.newInstance();

                    Method method0 = newModelClass.getMethod("setId",
                            new Class[] { Long.TYPE });

                    Long value0 = new Long(oldCplModel.getId());

                    method0.invoke(newModel, value0);

                    Method method1 = newModelClass.getMethod("setCompanyId",
                            new Class[] { Long.TYPE });

                    Long value1 = new Long(oldCplModel.getCompanyId());

                    method1.invoke(newModel, value1);

                    Method method2 = newModelClass.getMethod("setGroupId",
                            new Class[] { Long.TYPE });

                    Long value2 = new Long(oldCplModel.getGroupId());

                    method2.invoke(newModel, value2);

                    Method method3 = newModelClass.getMethod("setMarkup",
                            new Class[] { String.class });

                    String value3 = oldCplModel.getMarkup();

                    method3.invoke(newModel, value3);

                    Method method4 = newModelClass.getMethod("setActive",
                            new Class[] { Boolean.TYPE });

                    Boolean value4 = new Boolean(oldCplModel.getActive());

                    method4.invoke(newModel, value4);

                    Method method5 = newModelClass.getMethod("setLocation",
                            new Class[] { Short.TYPE });

                    Short value5 = new Short(oldCplModel.getLocation());

                    method5.invoke(newModel, value5);

                    return newModel;
                } catch (Exception e) {
                    _log.error(e, e);
                }
            } finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.commsen.liferay.portlet.customglobalmarkup.model.impl.MarkupImpl")) {
            ClassLoader contextClassLoader = Thread.currentThread()
                                                   .getContextClassLoader();

            try {
                Thread.currentThread().setContextClassLoader(_classLoader);

                try {
                    MarkupClp newModel = new MarkupClp();

                    Method method0 = oldModelClass.getMethod("getId");

                    Long value0 = (Long) method0.invoke(oldModel,
                            (Object[]) null);

                    newModel.setId(value0);

                    Method method1 = oldModelClass.getMethod("getCompanyId");

                    Long value1 = (Long) method1.invoke(oldModel,
                            (Object[]) null);

                    newModel.setCompanyId(value1);

                    Method method2 = oldModelClass.getMethod("getGroupId");

                    Long value2 = (Long) method2.invoke(oldModel,
                            (Object[]) null);

                    newModel.setGroupId(value2);

                    Method method3 = oldModelClass.getMethod("getMarkup");

                    String value3 = (String) method3.invoke(oldModel,
                            (Object[]) null);

                    newModel.setMarkup(value3);

                    Method method4 = oldModelClass.getMethod("getActive");

                    Boolean value4 = (Boolean) method4.invoke(oldModel,
                            (Object[]) null);

                    newModel.setActive(value4);

                    Method method5 = oldModelClass.getMethod("getLocation");

                    Short value5 = (Short) method5.invoke(oldModel,
                            (Object[]) null);

                    newModel.setLocation(value5);

                    return newModel;
                } catch (Exception e) {
                    _log.error(e, e);
                }
            } finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }
}
