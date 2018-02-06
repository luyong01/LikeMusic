package com.ranze.component.api.template;


import com.ranze.component.api.ComponentOptions;

/**
 * {@link com.ranze.component.api.IComponent 组件}加载器
 *
 * @author xpleemoon
 */
public interface IComponentLoader {
    /**
     * 主要作用：加载{@link com.ranze.component.api.IComponent 组件}，并添加到{@code componentOptions}
     *
     * @param componentOptions {@link com.ranze.component.api.IComponent 组件}容器wrapper
     */
    void loadInto(ComponentOptions componentOptions);
}
