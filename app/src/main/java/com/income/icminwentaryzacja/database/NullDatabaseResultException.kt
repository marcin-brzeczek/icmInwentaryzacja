package com.income.icminwentaryzacja.database

class NullDatabaseResultException : Exception {
    constructor() : super("Query returned nothing!")
    constructor(message: String) : super(message)
}