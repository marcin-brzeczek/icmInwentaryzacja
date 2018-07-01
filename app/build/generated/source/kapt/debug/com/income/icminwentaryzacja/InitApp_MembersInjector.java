// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.income.icminwentaryzacja;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class InitApp_MembersInjector implements MembersInjector<InitApp> {
  private final Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider;

  private final Provider<DispatchingAndroidInjector<BroadcastReceiver>>
      broadcastReceiverInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider;

  private final Provider<DispatchingAndroidInjector<ContentProvider>>
      contentProviderInjectorProvider;

  public InitApp_MembersInjector(
      Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>> broadcastReceiverInjectorProvider,
      Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider,
      Provider<DispatchingAndroidInjector<ContentProvider>> contentProviderInjectorProvider) {
    assert activityInjectorProvider != null;
    this.activityInjectorProvider = activityInjectorProvider;
    assert broadcastReceiverInjectorProvider != null;
    this.broadcastReceiverInjectorProvider = broadcastReceiverInjectorProvider;
    assert fragmentInjectorProvider != null;
    this.fragmentInjectorProvider = fragmentInjectorProvider;
    assert serviceInjectorProvider != null;
    this.serviceInjectorProvider = serviceInjectorProvider;
    assert contentProviderInjectorProvider != null;
    this.contentProviderInjectorProvider = contentProviderInjectorProvider;
  }

  public static MembersInjector<InitApp> create(
      Provider<DispatchingAndroidInjector<Activity>> activityInjectorProvider,
      Provider<DispatchingAndroidInjector<BroadcastReceiver>> broadcastReceiverInjectorProvider,
      Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider,
      Provider<DispatchingAndroidInjector<Service>> serviceInjectorProvider,
      Provider<DispatchingAndroidInjector<ContentProvider>> contentProviderInjectorProvider) {
    return new InitApp_MembersInjector(
        activityInjectorProvider,
        broadcastReceiverInjectorProvider,
        fragmentInjectorProvider,
        serviceInjectorProvider,
        contentProviderInjectorProvider);
  }

  @Override
  public void injectMembers(InitApp instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    dagger.android.DaggerApplication_MembersInjector.injectActivityInjector(
        instance, activityInjectorProvider);
    dagger.android.DaggerApplication_MembersInjector.injectBroadcastReceiverInjector(
        instance, broadcastReceiverInjectorProvider);
    dagger.android.DaggerApplication_MembersInjector.injectFragmentInjector(
        instance, fragmentInjectorProvider);
    dagger.android.DaggerApplication_MembersInjector.injectServiceInjector(
        instance, serviceInjectorProvider);
    dagger.android.DaggerApplication_MembersInjector.injectContentProviderInjector(
        instance, contentProviderInjectorProvider);
    dagger.android.DaggerApplication_MembersInjector.injectSetInjected(instance);
  }
}
