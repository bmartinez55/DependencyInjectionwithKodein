package c.bmartinez.dependencyinjectionwithkodein.Data.db

import c.bmartinez.dependencyinjectionwithkodein.Data.model.Quote

class DatabaseFakeImpl: Database {
    override val quoteDao: QuoteDao = QuoteDaoFake()
}