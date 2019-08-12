package com.income.icminventory.fragments

enum class ModeCSV {
    ExportOrOpenNew,
    ExportAndOpenNew,
    ExportAndExitApp,
    ExportAndStartEpmtyInventory,
    GenerateEmptyPositionsCSV,
    GenerateEmptyLocationsCSV,
    ExportCSV,
    ExportAndLogout
}