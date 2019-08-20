package c.bmartinez.dependencyinjectionwithkodein.Data.repository

import androidx.lifecycle.LiveData
import c.bmartinez.dependencyinjectionwithkodein.Data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>

}