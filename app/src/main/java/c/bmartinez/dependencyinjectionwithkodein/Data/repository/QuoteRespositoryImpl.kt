package c.bmartinez.dependencyinjectionwithkodein.Data.repository

import androidx.lifecycle.LiveData
import c.bmartinez.dependencyinjectionwithkodein.Data.db.QuoteDao
import c.bmartinez.dependencyinjectionwithkodein.Data.model.Quote

class QuoteRespositoryImpl(private val quoteDao: QuoteDao): QuoteRepository {
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> = quoteDao.getQuotes()
}