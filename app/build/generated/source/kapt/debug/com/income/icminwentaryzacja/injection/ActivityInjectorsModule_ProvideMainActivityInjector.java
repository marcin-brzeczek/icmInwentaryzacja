package com.income.icminwentaryzacja.injection;

import android.app.Activity;
import com.income.icminwentaryzacja.activities.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityInjectorsModule_ProvideMainActivityInjector.MainActivitySubcomponent.class
)
public abstract class ActivityInjectorsModule_ProvideMainActivityInjector {
  private ActivityInjectorsModule_ProvideMainActivityInjector() {}

  @Binds
  @IntoMap
  @ActivityKey(MainActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Builder builder);

  @Subcomponent
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
  }
}
