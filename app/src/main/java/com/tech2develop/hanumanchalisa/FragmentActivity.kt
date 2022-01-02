package com.tech2develop.hanumanchalisa

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tech2develop.hanumanchalisa.Adapters.ViewPagerAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class FragmentActivity : AppCompatActivity() {

    var code = 0
    var playing = false
    lateinit var player : MediaPlayer
    var duration : Int = 0
    lateinit var seekbar : SeekBar
    lateinit var runnable: Runnable
    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        code = intent.getIntExtra("itemCode",0)
        player = getMedia()
        player.isLooping = false

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val btnPrev = findViewById<ImageButton>(R.id.btnPrev)
        val btnPlay = findViewById<ImageButton>(R.id.btnPlay)
        val btnNext = findViewById<ImageButton>(R.id.btnNext)
        val btnLoop = findViewById<ImageButton>(R.id.btnLoop)
        val btnBell = findViewById<ImageView>(R.id.btnBell)
        seekbar = findViewById<SeekBar>(R.id.sbPrgrs)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle, code)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            run {
                when (position) {
                    0 -> tab.text = "BHAJAN"
                    1-> tab.text = "LYRICS"
                }
            }
        }.attach()

        btnPlay.setOnClickListener {
            if (!playing) {
                playMedia()
                btnPlay.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24)
                playing = true
            }else{
                pauseMeida()
                btnPlay.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
                playing = false
            }
        }
        btnBell.setOnClickListener {
            val playerTop = MediaPlayer.create(this,R.raw.bell)
            playerTop.start()
        }

        duration = getTotalDuration()
        seekbar.max = duration
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                player.seekTo(p1*1000)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        player.setOnCompletionListener {
            seekbar.progress = 0
        }
        btnLoop.setOnClickListener {
            if(!player.isLooping) {
                player.isLooping = true
                Toast.makeText(this,"Repeat in ON",Toast.LENGTH_SHORT).show()
            }else{
                player.isLooping = false
                Toast.makeText(this,"Repeat in OFF",Toast.LENGTH_SHORT).show()
            }
        }

//        runnable = Runnable {
//            val pos = player.currentPosition / 1000
//            seekbar.progress = pos
//            handler.postDelayed(runnable, 1000)
//        }
//        handler.postDelayed(runnable, 1000)

    }

    private fun getMedia(): MediaPlayer {
        when(code){
            0->{
                return MediaPlayer.create(this,R.raw.hanumanchalisa)
            }
            1->{
                return MediaPlayer.create(this,R.raw.aarti)
            }
            2->{
                return MediaPlayer.create(this,R.raw.bajrangbaan)
            }
            3->{
                return MediaPlayer.create(this,R.raw.hanumanashtak)
            }
            4->{
                return MediaPlayer.create(this,R.raw.kashtbhanjandev)
            }
            else-> return MediaPlayer.create(this,null)
        }

    }

    private fun getTotalDuration(): Int {
        val duration = player.duration/1000
        return duration
    }

    private fun pauseMeida() {
        player.pause()
    }

    private fun playMedia() {
        player.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    fun btnBackPress(view: android.view.View) {
        onBackPressed()
    }
}