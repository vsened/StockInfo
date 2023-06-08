package com.vsened.stockinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.NavGraph
import com.vsened.stockinfo.presentation.company_info.CompanyInfoScreen
import com.vsened.stockinfo.presentation.company_listings.CompanyListingsScreen
import com.vsened.stockinfo.ui.theme.StockInfoTheme
import com.vsened.stockinfo.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CompanyListings.route
                    ) {
                        composable(route = Screen.CompanyListings.route) {
                            CompanyListingsScreen(navController = navController)
                        }
                        composable(route = Screen.CompanyInfo.route
                                + "?symbol={symbol}",
                            arguments = listOf(
                                navArgument(
                                    name = "symbol"
                                ) {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            val symbol = it.arguments?.getString("symbol") ?: ""
                            CompanyInfoScreen(
                                navController = navController,
                                symbol = symbol
                            )
                        }
                    }
                }
            }
        }
    }

}
