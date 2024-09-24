package com.juliaplatova.scamperapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import com.juliaplatova.scamperapp.QuoteProvider

class MainActivity : ComponentActivity() {
    private val quoteProvider = QuoteProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScamperScreen()
        }
    }
}

@Composable
fun ScamperScreen() {
    val quoteProvider = QuoteProvider()

    var selectedLetter by remember { mutableStateOf<Char?>(null) }
    var verbs by remember { mutableStateOf<List<String>>(emptyList()) }
    var quote by remember { mutableStateOf<String>("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFEFEFEF)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (letter in listOf('S', 'C', 'A', 'M', 'P', 'E', 'R')) {
                val isSelected = letter == selectedLetter

                Button(
                    onClick = {
                        quoteProvider.newRandomQuoteForCategory(letter)
                        verbs = quoteProvider.getVerbs() ?: emptyList()
                        quote = quoteProvider.getQuote() ?: ""

                        selectedLetter = letter
                    },
                    modifier = Modifier
                        .padding(1.dp)
                ) {
                    Text(
                        text = letter.toString(),
                        fontSize = 8.sp,
                        color = if (isSelected) Color.White else Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        verbs?.let { verbs ->
            Card(
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Глаголы: ${verbs.joinToString(", ")}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        quote?.let { quote ->
        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Цитата: $quote",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
    }
}