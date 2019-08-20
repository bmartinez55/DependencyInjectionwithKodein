package c.bmartinez.dependencyinjectionwithkodein.Data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import c.bmartinez.dependencyinjectionwithkodein.Data.model.Quote

class QuoteDaoFake: QuoteDao {
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init{
        quotes.value = quoteList
    }

    override fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    override fun getQuotes() = quotes as LiveData<List<Quote>>
}