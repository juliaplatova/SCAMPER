package com.juliaplatova.scamperapp

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

object AppDI {
        val kodein = DI {
                bind<QuoteProvider>() with provider { QuoteProvider() }
        }
}