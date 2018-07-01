package com.income.icminwentaryzacja.injection;

import android.app.Fragment;
import com.income.icminwentaryzacja.fragments.login.LoginFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeLoginFragment$app_debug.LoginFragmentSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeLoginFragment$app_debug {
  private FragmentInjectorsModule_ContributeLoginFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(LoginFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      LoginFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface LoginFragmentSubcomponent extends AndroidInjector<LoginFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LoginFragment> {}
  }
}
