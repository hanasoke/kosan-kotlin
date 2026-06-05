package com.example.kosan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kosan.ui.theme.KosanTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KosanTheme {
                Scaffold { padding ->
                    HomeScreen(
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        HeaderSection()

        WelcomeCard(name = "Pengunjung Kosan Hanagakure")

        ActionButton()
    }
}

@Composable
fun HeaderSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.hanagakure),
            contentDescription = "Logo Hanagakure",
            modifier = Modifier
                .size(300.dp)
                .padding(bottom = 1.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = "Temukan kosan terbaik dengan mudah",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

    }
    
}

@Composable
fun WelcomeCard(name: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Selamat Datang 👋",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun ActionButton() {
    Button(
        onClick = { /* TODO: Navigasi ke halaman list kosan */ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Cari Kosan")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    KosanTheme {
        HomeScreen()
    }
}