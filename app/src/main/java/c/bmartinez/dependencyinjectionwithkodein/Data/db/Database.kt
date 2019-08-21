package c.bmartinez.dependencyinjectionwithkodein.Data.db

interface Database : QuoteDao {
    val quoteDao: QuoteDao
}