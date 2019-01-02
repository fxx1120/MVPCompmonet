package com.fxx.component.main.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.fxx.component.main.di.module.MainConsultingBankModule;

import com.jess.arms.di.scope.FragmentScope;
import com.fxx.component.main.mvp.ui.fragment.MainConsultingBankFragment;

@FragmentScope
@Component(modules = MainConsultingBankModule.class, dependencies = AppComponent.class)
public interface MainConsultingBankComponent {
    void inject(MainConsultingBankFragment fragment);
}