package c.bmartinez.dependencyinjectionwithkodein

import android.app.Application
import c.bmartinez.dependencyinjectionwithkodein.Data.db.Database
import c.bmartinez.dependencyinjectionwithkodein.Data.db.DatabaseFakeImpl
import c.bmartinez.dependencyinjectionwithkodein.Data.db.QuoteDao
import c.bmartinez.dependencyinjectionwithkodein.Data.db.QuoteDaoFake
import c.bmartinez.dependencyinjectionwithkodein.Data.repository.QuoteRepository
import c.bmartinez.dependencyinjectionwithkodein.Data.repository.QuoteRespositoryImpl
import c.bmartinez.dependencyinjectionwithkodein.UI.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuotesApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        //singleton only provided a single instance
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRespositoryImpl(instance()) }
        //provider instantiates a new instants every time
        //this binding is the longer way
        //bind<QuotesViewModelFactory>() with provider { QuotesViewModelFactory(instance()) }
        //This is the shorter version using from keyword
        //This is when you're binding to the same class
        bind() from provider { QuotesViewModelFactory(instance()) }
    }
}