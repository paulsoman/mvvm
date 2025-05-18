package com.opp.cashingapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.opp.cashingapi.domain.entity.Product
import com.opp.cashingapi.ui.products.ProductDetailFragment
import com.opp.cashingapi.ui.products.ProductListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val graph = createDynamicGraph(navController)

        navController.graph = graph
        // Optional: Tie action bar title and up button with navController
        setupActionBarWithNavController(navController)
    }

    private fun createDynamicGraph(navController: NavController): NavGraph =
        navController.createGraph(startDestination = "product_list") {
            fragment<ProductListFragment>("product_list") {
                label = "Product List"
            }
            fragment<ProductDetailFragment>("product_detail") {
                label = "Product Detail"
                argument("product") {
                    type = NavType.ParcelableType(Product::class.java)
                    nullable = true
                    defaultValue = null
                }
            }
        }

}
