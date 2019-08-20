package c.bmartinez.dependencyinjectionwithkodein.Data.db

class DatabaseFakeImpl: Database {
    override val quoteDao: QuoteDao = QuoteDaoFake()
}