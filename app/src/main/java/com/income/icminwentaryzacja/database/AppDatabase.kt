package com.income.icminwentaryzacja.database

import com.raizlabs.android.dbflow.annotation.Database


@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION,generatedClassSeparator = "_")

object AppDatabase {
    const val NAME: String = "app"
    const val VERSION = 2
}

/*****MIGRATION EXAMPLE*****/

//@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
//object AppDatabase {
//    const val NAME = "AnnDataBase"
//    const val VERSION = 6
//
//    @Migration(version = 2, database = AppDatabase::class)
//    class AddMoreWeightFieldsMigration : AlterTableMigration<WeightMeasurement>(WeightMeasurement::class.java) {
//        override fun onPreMigrate() {
//            addColumn(SQLiteType.REAL, "hydration")
//            addColumn(SQLiteType.REAL, "muscleMass")
//            addColumn(SQLiteType.REAL, "boneMass")
//            addColumn(SQLiteType.REAL, "fatTissue")
//        }
//    }
//
//    @Migration(version = 3, database = AppDatabase::class)
//    class AddMorePulseFieldsMigration : AlterTableMigration<PulseMeasurement>(PulseMeasurement::class.java) {
//        override fun onPreMigrate() {
//            addColumn(SQLiteType.REAL, "oxygenSaturation")
//            addColumn(SQLiteType.REAL, "aortaChamberVolume")
//            addColumn(SQLiteType.REAL, "aorticValve")
//            addColumn(SQLiteType.REAL, "pulsationIndex")
//            addColumn(SQLiteType.REAL, "k1k2indexChamber")
//            addColumn(SQLiteType.REAL, "arterialDynamics")
//        }
//    }
//    @Migration(version = 6, database = AppDatabase::class)
//    class AddMoreMedicalVisitFieldsMigration : AlterTableMigration<MedicalVisit>(MedicalVisit::class.java) {
//        override fun onPreMigrate() {
//            addColumn(SQLiteType.TEXT, "speciality")
//            addColumn(SQLiteType.TEXT, "city")
//
//        }
//    }