package com.example.kosan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kosan.ui.theme.KosanTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KosanTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination =  "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            onCariKosanClick = {
                                navController.navigate("list")
                            }
                        )
                    }

                    composable("list") {
                        ListKosanScreen(navController)
                    }

                    composable("detail/{kosanId}") { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("kosanId")?.toInt()
                        DetailKosanScreen(kosanId = id ?: 0)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onCariKosanClick: () -> Unit
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        HeaderSection()

        WelcomeCard(name = "Pengunjung Kosan Hanagakure")

        ActionButton(onClick = onCariKosanClick)
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
            text = "Hanagakure 🏠",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
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
fun ActionButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Cari Kosan")
    }
}

