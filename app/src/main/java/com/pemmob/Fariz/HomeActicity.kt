package com.pemmob.Fariz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.Fariz.ui.screen.DaftarProductScreen
import com.pemmob.Fariz.ui.screen.DetailProductScreen
import com.pemmob.Fariz.ui.screen.HubungiKamiScreen
import com.pemmob.Fariz.ui.theme.JualanPertemuan1Theme
import com.pemmob.Fariz.ui.viewmodel.ProductViewModel

class HomeActicity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanPertemuan1Theme {

                    val navController = rememberNavController()
                    val productViewModel: ProductViewModel = viewModel()
                    NavHost(navController = navController, startDestination = "daftar_produk") {
                        composable(route = "daftar_produk") {
                            DaftarProductScreen(
                                navController = navController,
                                viewModel = productViewModel
                            )
                        }
                        composable(
                            route = "detail/{productId}",
                            arguments = listOf(navArgument(name = "productId") {
                                type = NavType.IntType
                            })
                        ) { backStackEntry ->
                            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                            DetailProductScreen(
                                productId = productId,
                                navController = navController,
                                viewModel = productViewModel
                            )
                        }
                        composable(route = "hubungi_kami") {
                            HubungiKamiScreen(navController = navController)
                        }
                    }

            }
        }
    }
}

