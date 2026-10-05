package com.pemmob.Fariz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.Fariz.ui.screen.BasicInfoScreen
import com.pemmob.Fariz.ui.screen.DaftarProductScreen
import com.pemmob.Fariz.ui.screen.DetailProductScreen
import com.pemmob.Fariz.ui.screen.HubungiKamiScreen
import com.pemmob.Fariz.ui.viewmodel.ProductViewModel

object Routes {
    const val INFO = "info"
    const val DAFTAR = "daftar_produk"
    const val DETAIL = "detail/{productId}"
    const val HUBUNGI = "hubungi_kami"
    fun detail(id: Int) = "detail/$id"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.INFO) {
        composable(Routes.INFO) {
            BasicInfoScreen(
                onNavigateToContact = { navController.navigate(Routes.HUBUNGI) },
                onNavigateToProducts = { navController.navigate(Routes.DAFTAR) }
            )
        }
        composable(Routes.DAFTAR) {
            DaftarProductScreen(
                navController = navController,
                viewModel = productViewModel
            )
        }
        composable(
            route = Routes.DETAIL,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { entry ->
            DetailProductScreen(
                productId = entry.arguments?.getInt("productId") ?: 0,
                navController = navController,
                viewModel = productViewModel
            )
        }
        composable(Routes.HUBUNGI) {
            HubungiKamiScreen(navController)
        }
    }
}