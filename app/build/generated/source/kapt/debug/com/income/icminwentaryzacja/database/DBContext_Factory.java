// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.income.icminwentaryzacja.database;

import dagger.internal.Factory;

public final class DBContext_Factory implements Factory<DBContext> {
  private static final DBContext_Factory INSTANCE = new DBContext_Factory();

  @Override
  public DBContext get() {
    return new DBContext();
  }

  public static Factory<DBContext> create() {
    return INSTANCE;
  }
}
