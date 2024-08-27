package com.example.samplelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.samplelist.ui.theme.SampleListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                SampleListTheme {
                    DisplaySales(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DisplaySales(modifier: Modifier = Modifier) {
    val sales = listOf(
        Item("Toothpaste", 10.00),
        Item("Toothbrush", 18.00),
        Item("Mouthwash", 15.00),
        Item("Hand Soap", 18.00),
        Item("Candles", 16.00),
        Item("Cotton", 10.00),
        Item("Body Wash", 20.00),
        Item("Floss", 13.00),
        Item("Electric Toothbrush", 30.00),
        Item("Cologne", 10.00)
    )

    var total = 0.0
    Column {
        Text(
            fontSize = 16.sp,
            color = Color.Blue,
            text = "Sale",
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        sales.forEach { item ->
            total += item.price
            DisplayItem(item)
        }

        DisplayTotal(total, modifier.padding(horizontal = 8.dp))

    }
}

@Composable
fun DisplayItem(item: Item, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = item.name, modifier = modifier
        )
        Text(
            text = "$ ${item.price}", modifier = modifier
        )
    }
}

@Composable
fun DisplayTotal(total: Double, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = "Total", modifier = modifier
        )
        Text(
            fontWeight = FontWeight.Bold,
            text = "$ $total", modifier = modifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    DisplaySales()
}
