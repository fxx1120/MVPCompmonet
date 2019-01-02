package com.fxx.component.main.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.fxx.component.main.mvp.contract.MainConsultingBankContract;
import com.fxx.component.main.mvp.model.MainConsultingBankModel;


@Module
public class MainConsultingBankModule {
    private MainConsultingBankContract.View view;

    /**
     * 构建MainConsultingBankModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MainConsultingBankModule(MainConsultingBankContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MainConsultingBankContract.View provideMainConsultingBankView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MainConsultingBankContract.Model provideMainConsultingBankModel(MainConsultingBankModel model) {
        return model;
    }
}