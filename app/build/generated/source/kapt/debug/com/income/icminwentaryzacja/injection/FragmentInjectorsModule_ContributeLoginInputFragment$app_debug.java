package com.income.icminwentaryzacja.injection;

import android.app.Fragment;
import com.income.icminwentaryzacja.fragments.positions_list.ListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeLoginInputFragment$app_debug.ListFragmentSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeLoginInputFragment$app_debug {
  private FragmentInjectorsModule_ContributeLoginInputFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(ListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ListFragmentSubcomponent extends AndroidInjector<ListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ListFragment> {}
  }
}
