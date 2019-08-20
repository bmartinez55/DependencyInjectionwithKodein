package c.bmartinez.dependencyinjectionwithkodein.UI.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import c.bmartinez.dependencyinjectionwithkodein.Data.model.Quote
import c.bmartinez.dependencyinjectionwithkodein.R
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    private val viewModelFactory: QuotesViewModelFactory = QuotesViewModelFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        //Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (Activity)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(QuotesViewModel::class.java)

        //Observing LiveData from the QuotesViewModel which is turn observes
        // LiveData from the repo, which observes LiveData from the DAO
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener{
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }
}
