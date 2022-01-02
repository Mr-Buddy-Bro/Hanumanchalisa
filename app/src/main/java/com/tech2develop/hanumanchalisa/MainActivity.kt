package com.tech2develop.hanumanchalisa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.tech2develop.hanumanchalisa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    lateinit var mAdView : com.google.android.gms.ads.AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        MobileAds.initialize(this){}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.setTitle("Sri hanuman chalisa")

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun item1(view: android.view.View) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 0)
        startActivity(i)
    }
    fun item2(view: android.view.View) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 1)
        startActivity(i)
    }
    fun item3(view: android.view.View) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 2)
        startActivity(i)
    }
    fun item4(view: android.view.View) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 3)
        startActivity(i)
    }
    fun item5(view: android.view.View) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 4)
        startActivity(i)
    }
    fun item6(view: android.view.View) {
        val i = Intent(this,PavithruNaam108::class.java)
        startActivity(i)
    }
    fun item7(view: android.view.View) {
        val i = Intent(this,JaiHanumanChithru::class.java)
        startActivity(i)
    }

    fun btnnav1(item: android.view.MenuItem) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 0)
        startActivity(i)
    }
    fun btnnav2(item: android.view.MenuItem) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 1)
        startActivity(i)
    }
    fun btnnav3(item: android.view.MenuItem) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 2)
        startActivity(i)
    }
    fun btnnav4(item: android.view.MenuItem) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 3)
        startActivity(i)
    }
    fun btnnav5(item: android.view.MenuItem) {
        val i = Intent(this,FragmentActivity::class.java)
        i.putExtra("itemCode", 4)
        startActivity(i)
    }
    fun btnnav6(item: android.view.MenuItem) {
        val i = Intent(this,PavithruNaam108::class.java)
        startActivity(i)
    }

}