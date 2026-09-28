package com.pemmob.Fariz.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicInfoScreen(
    onNavigateToContact: () -> Unit,
    onNavigateToProducts: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tentang Jualan") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Info Icon",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Logo Aplikasi",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(96.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Tentang Jualan", fontSize = 24.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Aplikasi jualan adalah platform yang mewadahi produk lokal UMKM di wilayah Kabupaten Purbalingga, Jawa Tengah.",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp) // padding SETELAH background supaya teks tidak menempel
            )

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.onTertiary
                )
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Misi Kami:",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.weight(1f)
                    )
                    Text(text = "Memajukan UMKM Lokal", modifier = Modifier.weight(2f))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onNavigateToProducts,
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Lihat Produk", style = MaterialTheme.typography.labelLarge)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = onNavigateToContact,
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Hubungi Kami", style = MaterialTheme.typography.labelLarge)
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BasicInfoScreenPreview() {
    MaterialTheme {
        BasicInfoScreen(onNavigateToContact = {}, onNavigateToProducts = {})
    }
}