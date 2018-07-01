package com.income.icminwentaryzacja.injection;

import android.app.Fragment;
import com.income.icminwentaryzacja.fragments.abstraction.FragmentBase;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeFragmentGeneralBase$app_debug.FragmentBaseSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeFragmentGeneralBase$app_debug {
  private FragmentInjectorsModule_ContributeFragmentGeneralBase$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(FragmentBase.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      FragmentBaseSubcomponent.Builder builder);

  @Subcomponent
  public interface FragmentBaseSubcomponent extends AndroidInjector<FragmentBase> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FragmentBase> {}
  }
}
