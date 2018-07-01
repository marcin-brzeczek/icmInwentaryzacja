package com.income.icminwentaryzacja.database.dto;

import android.content.ContentValues;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.sql.QueryBuilder;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.language.property.Property;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.DatabaseStatement;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import java.lang.Class;
import java.lang.Double;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Number;
import java.lang.Override;
import java.lang.String;

/**
 * This is generated code. Please do not modify */
public final class Item_Table extends ModelAdapter<Item> {
  /**
   * Primary Key AutoIncrement */
  public static final Property<Long> Id = new Property<Long>(Item.class, "Id");

  public static final Property<String> Kod = new Property<String>(Item.class, "Kod");

  public static final Property<String> KodPomocniczy = new Property<String>(Item.class, "KodPomocniczy");

  public static final Property<String> NazwaSkrocona = new Property<String>(Item.class, "NazwaSkrocona");

  public static final Property<String> Nazwa = new Property<String>(Item.class, "Nazwa");

  public static final Property<String> LokalizacjaStara = new Property<String>(Item.class, "LokalizacjaStara");

  public static final Property<Double> IloscPoczatkowa = new Property<Double>(Item.class, "IloscPoczatkowa");

  public static final Property<Double> IloscKoncowa = new Property<Double>(Item.class, "IloscKoncowa");

  public static final Property<String> uzytkownik = new Property<String>(Item.class, "uzytkownik");

  public static final IProperty[] ALL_COLUMN_PROPERTIES = new IProperty[]{Id,Kod,KodPomocniczy,NazwaSkrocona,Nazwa,LokalizacjaStara,IloscPoczatkowa,IloscKoncowa,uzytkownik};

  public Item_Table(DatabaseDefinition databaseDefinition) {
    super(databaseDefinition);
  }

  @Override
  public final Class<Item> getModelClass() {
    return Item.class;
  }

  @Override
  public final String getTableName() {
    return "`items`";
  }

  @Override
  public final Item newInstance() {
    return new Item();
  }

  @Override
  public final Property getProperty(String columnName) {
    columnName = QueryBuilder.quoteIfNeeded(columnName);
    switch ((columnName)) {
      case "`Id`":  {
        return Id;
      }
      case "`Kod`":  {
        return Kod;
      }
      case "`KodPomocniczy`":  {
        return KodPomocniczy;
      }
      case "`NazwaSkrocona`":  {
        return NazwaSkrocona;
      }
      case "`Nazwa`":  {
        return Nazwa;
      }
      case "`LokalizacjaStara`":  {
        return LokalizacjaStara;
      }
      case "`IloscPoczatkowa`":  {
        return IloscPoczatkowa;
      }
      case "`IloscKoncowa`":  {
        return IloscKoncowa;
      }
      case "`uzytkownik`":  {
        return uzytkownik;
      }
      default: {
        throw new IllegalArgumentException("Invalid column name passed. Ensure you are calling the correct table's column");
      }
    }
  }

  @Override
  public final void updateAutoIncrement(Item model, Number id) {
    model.setId(id.longValue());
  }

  @Override
  public final Number getAutoIncrementingId(Item model) {
    return model.getId();
  }

  @Override
  public final String getAutoIncrementingColumnName() {
    return "Id";
  }

  @Override
  public final IProperty[] getAllColumnProperties() {
    return ALL_COLUMN_PROPERTIES;
  }

  @Override
  public final void bindToInsertValues(ContentValues values, Item model) {
    values.put("`Kod`", model.getCode() != null ? model.getCode() : null);
    values.put("`KodPomocniczy`", model.getSupportCode() != null ? model.getSupportCode() : null);
    values.put("`NazwaSkrocona`", model.getShortName() != null ? model.getShortName() : null);
    values.put("`Nazwa`", model.getName() != null ? model.getName() : null);
    values.put("`LokalizacjaStara`", model.getOldLocation() != null ? model.getOldLocation() : null);
    values.put("`IloscPoczatkowa`", model.getStartNumber());
    values.put("`IloscKoncowa`", model.getEndNumber());
    values.put("`uzytkownik`", model.getUser() != null ? model.getUser() : null);
  }

  @Override
  public final void bindToContentValues(ContentValues values, Item model) {
    values.put("`Id`", model.getId());
    bindToInsertValues(values, model);
  }

  @Override
  public final void bindToInsertStatement(DatabaseStatement statement, Item model, int start) {
    statement.bindStringOrNull(1 + start, model.getCode());
    statement.bindStringOrNull(2 + start, model.getSupportCode());
    statement.bindStringOrNull(3 + start, model.getShortName());
    statement.bindStringOrNull(4 + start, model.getName());
    statement.bindStringOrNull(5 + start, model.getOldLocation());
    statement.bindDouble(6 + start, model.getStartNumber());
    statement.bindDouble(7 + start, model.getEndNumber());
    statement.bindStringOrNull(8 + start, model.getUser());
  }

  @Override
  public final void bindToStatement(DatabaseStatement statement, Item model) {
    int start = 0;
    statement.bindLong(1 + start, model.getId());
    bindToInsertStatement(statement, model, 1);
  }

  @Override
  public final void bindToUpdateStatement(DatabaseStatement statement, Item model) {
    statement.bindLong(1, model.getId());
    statement.bindStringOrNull(2, model.getCode());
    statement.bindStringOrNull(3, model.getSupportCode());
    statement.bindStringOrNull(4, model.getShortName());
    statement.bindStringOrNull(5, model.getName());
    statement.bindStringOrNull(6, model.getOldLocation());
    statement.bindDouble(7, model.getStartNumber());
    statement.bindDouble(8, model.getEndNumber());
    statement.bindStringOrNull(9, model.getUser());
    statement.bindLong(10, model.getId());
  }

  @Override
  public final void bindToDeleteStatement(DatabaseStatement statement, Item model) {
    statement.bindLong(1, model.getId());
  }

  @Override
  public final String getInsertStatementQuery() {
    return "INSERT INTO `items`(`Kod`,`KodPomocniczy`,`NazwaSkrocona`,`Nazwa`,`LokalizacjaStara`,`IloscPoczatkowa`,`IloscKoncowa`,`uzytkownik`) VALUES (?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getCompiledStatementQuery() {
    return "INSERT INTO `items`(`Id`,`Kod`,`KodPomocniczy`,`NazwaSkrocona`,`Nazwa`,`LokalizacjaStara`,`IloscPoczatkowa`,`IloscKoncowa`,`uzytkownik`) VALUES (?,?,?,?,?,?,?,?,?)";
  }

  @Override
  public final String getUpdateStatementQuery() {
    return "UPDATE `items` SET `Id`=?,`Kod`=?,`KodPomocniczy`=?,`NazwaSkrocona`=?,`Nazwa`=?,`LokalizacjaStara`=?,`IloscPoczatkowa`=?,`IloscKoncowa`=?,`uzytkownik`=? WHERE `Id`=?";
  }

  @Override
  public final String getDeleteStatementQuery() {
    return "DELETE FROM `items` WHERE `Id`=?";
  }

  @Override
  public final String getCreationQuery() {
    return "CREATE TABLE IF NOT EXISTS `items`(`Id` INTEGER PRIMARY KEY AUTOINCREMENT, `Kod` TEXT, `KodPomocniczy` TEXT, `NazwaSkrocona` TEXT, `Nazwa` TEXT, `LokalizacjaStara` TEXT, `IloscPoczatkowa` REAL, `IloscKoncowa` REAL, `uzytkownik` TEXT)";
  }

  @Override
  public final void loadFromCursor(FlowCursor cursor, Item model) {
    model.setId(cursor.getLongOrDefault("Id"));
    model.setCode(cursor.getStringOrDefault("Kod"));
    model.setSupportCode(cursor.getStringOrDefault("KodPomocniczy"));
    model.setShortName(cursor.getStringOrDefault("NazwaSkrocona"));
    model.setName(cursor.getStringOrDefault("Nazwa"));
    model.setOldLocation(cursor.getStringOrDefault("LokalizacjaStara"));
    model.setStartNumber(cursor.getDoubleOrDefault("IloscPoczatkowa"));
    model.setEndNumber(cursor.getDoubleOrDefault("IloscKoncowa"));
    model.setUser(cursor.getStringOrDefault("uzytkownik"));
  }

  @Override
  public final boolean exists(Item model, DatabaseWrapper wrapper) {
    return model.getId() > 0
    && SQLite.selectCountOf()
    .from(Item.class)
    .where(getPrimaryConditionClause(model))
    .hasData(wrapper);
  }

  @Override
  public final OperatorGroup getPrimaryConditionClause(Item model) {
    OperatorGroup clause = OperatorGroup.clause();
    clause.and(Id.eq(model.getId()));
    return clause;
  }
}
