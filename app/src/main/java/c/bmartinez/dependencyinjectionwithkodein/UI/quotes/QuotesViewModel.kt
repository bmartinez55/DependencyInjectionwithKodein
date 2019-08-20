package c.bmartinez.dependencyinjectionwithkodein.UI.quotes

import androidx.lifecycle.ViewModel
import c.bmartinez.dependencyinjectionwithkodein.Data.model.Quote
import c.bmartinez.dependencyinjectionwithkodein.Data.repository.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

    fun getQuotes() = quoteRepository.getQuotes()
}