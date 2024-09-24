package com.juliaplatova.scamperapp

import org.kodein.di.instance

class IdeaGeneratorViewModel {
        val quoteProvider: QuoteProvider by AppDI.kodein.instance()
}