package ua.com.alevel.controller.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import ua.com.alevel.annotations.Controller;
import ua.com.alevel.annotations.ControllerMethod;
import ua.com.alevel.annotations.ControllerParam;
import ua.com.alevel.controller.ApplicationController;
import ua.com.alevel.controller.response.DataResponse;
import ua.com.alevel.controller.util.MethodParameterUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class ConsoleController implements ApplicationController {

    private final Map<Class<?>, Object> beanMap;
    private final Map<Integer, ControllerInfo> controllerMap = new HashMap<>();
    private final Set<String> dataSet = new HashSet<>();

    public ConsoleController(final Map<Class<?>, Object> beanMap, final Set<String> dataSet) {
        this.beanMap = beanMap;
        this.dataSet.addAll(dataSet);
        initControllerMap();
    }

    @Override
    public void start() {
        initView();
    }

    private void initView() {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Welcome to the application");
            System.out.println("Select options:");
            String select;
            menu();
            while ((select = bf.readLine()) != null) {
                if (StringUtils.isNumericSpace(select)) {
                    int controllerPosition = Integer.parseInt(select);
                    if (controllerPosition == (controllerMap.size() + 1)) {
                        System.exit(0);
                    } else {
                        System.out.println("Incorrect value!\n Please enter a valid selector");
                    }
                    observeControllerMethods(bf, controllerPosition, select);
                }
            }
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void menu() {
        System.out.println();
        controllerMap.forEach((k, v) -> System.out.println("If you want observe " + v.controller().getClass().getSimpleName() + ", please enter " + k));
        System.out.println("If you want close, please enter " + (controllerMap.size() + 1));
    }

    private void observeControllerMethods(final BufferedReader bf, Integer controllerPosition, String select) throws IOException {
        ControllerInfo controller = controllerMap.get(controllerPosition);
        if (controller != null) {
            navigateByMethod(controller);
            final Map<Integer, ControllerMethodInfo> methodInfoMap = controller.methodInfoMap();
            while ((select = bf.readLine()) != null) {
                if (StringUtils.isNumericSpace(select)) {
                    int methodPosition = Integer.parseInt(select);
                    if (methodPosition == (methodInfoMap.size() + 1)) {
                        menu();
                        return;
                    }
                    ControllerMethodInfo methodInfo = methodInfoMap.get(methodPosition);
                    if (methodInfo != null) {
                        try {
                            runMethod(bf, controller.controller(), methodInfo);
                        } catch (Exception e) {
                            System.out.println("problem with run method: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Incorrect value!\n Please enter a valid selector");
                    }
                    navigateByMethod(controller);
                }
            }
        }
        else {
            System.out.println("Incorrect value!\n Please enter a valid selector");
        }
    }

    private void navigateByMethod(final ControllerInfo controller) {
        System.out.println();
        System.out.println("Select method options of controller: " + controller.controller().getClass().getSimpleName());
        final Map<Integer, ControllerMethodInfo> methodInfoMap = controller.methodInfoMap();
        methodInfoMap.forEach((k, v) -> System.out.println("If you want run " + v.method().getName() + ", please enter " + k));
        System.out.println("If you want return to observe controllers, please enter " + (methodInfoMap.size() + 1));
        System.out.println();
    }

    private void runMethod(final BufferedReader bf, final Object controller, final ControllerMethodInfo methodInfo) throws InvocationTargetException, IllegalAccessException {
        System.out.println("method name = " + methodInfo.method().getName());
        final List<Class<?>> methodParams = methodInfo.methodParams();
        final List<Object> params = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(methodParams)) {
            methodParams.forEach(methodParam -> {
                System.out.println("methodParam = " + methodParam.getName());
                if (dataSet.stream().anyMatch(data -> data.equals(methodParam.getName()))) {
                    try {
                        Object fieldObject = MethodParameterUtil.initializeParameterFields(bf, methodParam);
                        params.add(fieldObject);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        System.out.println("problem with run method: " + e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        params.add(MethodParameterUtil.initializeParameterField(bf, methodParam));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        Method method = methodInfo.method();
        method.setAccessible(true);
        DataResponse<?> invoke;
        if (CollectionUtils.isEmpty(params)) {
            invoke = (DataResponse<?>) method.invoke(controller);
        } else {
            invoke = (DataResponse<?>) method.invoke(controller, params.toArray(new Object[0]));
        }
        System.out.println("Method " + method.getName() + " was successfully");
        System.out.println("data: " + invoke.getData());
    }

    private void initControllerMap() {
        final List<Object> controllers = beanMap.values()
                .stream()
                .filter(bean -> bean.getClass().isAnnotationPresent(Controller.class))
                .toList();
        for (int i = 1; i <= controllers.size(); i++) {
            final Object controller = controllers.get(i - 1);
            final List<Method> methods = Stream.of(controller.getClass().getDeclaredMethods())
                    .filter(method -> method.isAnnotationPresent(ControllerMethod.class))
                    .sorted(Comparator.comparingInt(method -> method.getAnnotation(ControllerMethod.class).position()))
                    .toList();
            final Map<Integer, ControllerMethodInfo> methodInfoMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(methods)) {
                for (int j = 1; j <= methods.size(); j++) {
                    List<Class<?>> methodParams = new ArrayList<>();
                    Parameter[] parameters = methods.get(j - 1).getParameters();
                    if (ArrayUtils.isNotEmpty(parameters)) {
                        Stream.of(parameters).forEach(parameter -> {
                            if (parameter.isAnnotationPresent(ControllerParam.class) && !parameter.getType().isPrimitive()) {
                                Class<?> paramClass = parameter.getType();
                                methodParams.add(paramClass);
                            }
                        });
                    }
                    methodInfoMap.put(j, new ControllerMethodInfo(methods.get(j - 1), methodParams));
                }
            }
            controllerMap.put(i, new ControllerInfo(controller, methodInfoMap));
        }
    }

    private record ControllerInfo(Object controller, Map<Integer, ControllerMethodInfo> methodInfoMap) { }
    private record ControllerMethodInfo(Method method, List<Class<?>> methodParams) { }
}
