// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.income.icminwentaryzacja.injection;

import com.income.icminwentaryzacja.database.DBContext;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_ProvidesDBContextFactory implements Factory<DBContext> {
  private final ApplicationModule module;

  public ApplicationModule_ProvidesDBContextFactory(ApplicationModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public DBContext get() {
    return Preconditions.checkNotNull(
        module.providesDBContext(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<DBContext> create(ApplicationModule module) {
    return new ApplicationModule_ProvidesDBContextFactory(module);
  }
}
