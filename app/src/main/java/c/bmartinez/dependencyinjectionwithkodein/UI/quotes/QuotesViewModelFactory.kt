package c.bmartinez.dependencyinjectionwithkodein.UI.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import c.bmartinez.dependencyinjectionwithkodein.Data.repository.QuoteRepository

class QuotesViewModelFactory(private val quoteRepository: QuoteRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepository) as T
    }
}