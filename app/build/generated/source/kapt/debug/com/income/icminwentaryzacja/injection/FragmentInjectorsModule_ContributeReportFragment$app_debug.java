package com.income.icminwentaryzacja.injection;

import android.app.Fragment;
import com.income.icminwentaryzacja.fragments.report.ReportFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeReportFragment$app_debug.ReportFragmentSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeReportFragment$app_debug {
  private FragmentInjectorsModule_ContributeReportFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(ReportFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ReportFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ReportFragmentSubcomponent extends AndroidInjector<ReportFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ReportFragment> {}
  }
}
