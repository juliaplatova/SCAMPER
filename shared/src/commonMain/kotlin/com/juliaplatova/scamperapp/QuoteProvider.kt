package com.juliaplatova.scamperapp
import kotlin.random.Random

data class ScamperCategory(
        val letter: Char,
        val verbs: List<String>,
        val quotes: List<String>
)

class QuoteProvider {
        private var currentQuote: Pair<List<String>, String>? = null

        private val scamperCategories = listOf(
                ScamperCategory(
                        letter = 'S',
                        verbs = listOf("Увеличить", "Изменить", "Расширить"),
                        quotes = listOf(
                                "Увеличьте свою целеустремленность. - Аноним",
                                "Смотрите на вещи по-другому. - Аноним"
                        )
                ),
                ScamperCategory(
                        letter = 'C',
                        verbs = listOf("Сократить", "Упростить", "Сделать легче"),
                        quotes = listOf(
                                "Сократите шаги к вашей цели. - Аноним",
                                "Простота — это высшая форма изысканности. - Леонардо да Винчи"
                        )
                ),
                ScamperCategory(
                        letter = 'A',
                        verbs = listOf("Добавить", "Интегрировать", "Соединить"),
                        quotes = listOf(
                                "Добавьте немного творчества в вашу жизнь. - Аноним",
                                "Сотрудничество - ключ к успеху. - Аноним"
                        )
                ),
                ScamperCategory(
                        letter = 'M',
                        verbs = listOf("Изменить", "Модифицировать", "Преобразовать"),
                        quotes = listOf(
                                "Измените свою жизнь сегодня. - Аноним",
                                "Модификация - это искусство. - Аноним"
                        )
                ),
                ScamperCategory(
                        letter = 'P',
                        verbs = listOf("Заменить", "Переставить", "Использовать иначе"),
                        quotes = listOf(
                                "Замена может быть освежающей. - Аноним",
                                "Используйте ваши ресурсы разумно. - Аноним"
                        )
                ),
                ScamperCategory(
                        letter = 'E',
                        verbs = listOf("Устранить", "Сократить", "Оптимизировать"),
                        quotes = listOf(
                                "Устранение лишнего может привести к успеху. - Аноним",
                                "Оптимизация процессов - ключ к эффективности. - Аноним"
                        )
                ),
                ScamperCategory(
                        letter = 'R',
                        verbs = listOf("Переработать", "Переосмыслить", "Использовать снова"),
                        quotes = listOf(
                                "Переработка идей может привести к новым решениям. - Аноним",
                                "Переосмысленный подход может изменить все. - Аноним"
                        )
                )
        )

        fun newRandomQuoteForCategory(letter: Char) {
                val category = scamperCategories.find { it.letter == letter }
                category?.let {
                        val randomQuote = it.quotes[Random.nextInt(it.quotes.size)]
                        currentQuote = Pair(it.verbs, randomQuote)
                }
        }

        fun getVerbs(): List<String>? {
                return currentQuote?.first
        }

        fun getQuote(): String? {
                return currentQuote?.second
        }
}