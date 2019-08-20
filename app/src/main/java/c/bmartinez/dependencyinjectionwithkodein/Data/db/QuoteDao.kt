package c.bmartinez.dependencyinjectionwithkodein.Data.db

import androidx.lifecycle.LiveData
import c.bmartinez.dependencyinjectionwithkodein.Data.model.Quote

interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}