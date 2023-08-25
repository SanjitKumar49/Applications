package com.sanjit49.music

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.os.postDelayed
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Delay

class MainActivity : AppCompatActivity() {

    private  var mediaPlayer:MediaPlayer?=null
    private  lateinit var  seekBar: SeekBar
    private  lateinit var runnable: Runnable
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fabstart=findViewById<FloatingActionButton>(R.id.fabStart)
        val fabstop=findViewById<FloatingActionButton>(R.id.fabStop)
        val  fabpause=findViewById<FloatingActionButton>(R.id.fabPause)
         seekBar=findViewById(R.id.seekBar)

        handler= Handler(Looper.getMainLooper())

        fabstart.setOnClickListener(View.OnClickListener {
        if(mediaPlayer==null){
            mediaPlayer=MediaPlayer.create(this,R.raw.terabin)
            initializeSeekbar()
        }
            mediaPlayer?.start()
        })

        fabpause.setOnClickListener(View.OnClickListener {
            mediaPlayer?.pause()
        })

        fabstop.setOnClickListener(View.OnClickListener {
          mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer=null
            handler.removeCallbacks(runnable)
            seekBar.progress=0;
        })

    }
    private  fun initializeSeekbar(){
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUSer: Boolean) {
            if(fromUSer) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

        })
        val start=findViewById<TextView>(R.id.start)
        val end=findViewById<TextView>(R.id.end)

        seekBar.max=mediaPlayer!!.duration
        runnable= Runnable {
            seekBar.progress=mediaPlayer!!.currentPosition
            val playedTime=mediaPlayer!!.currentPosition/1000
            start.text="$playedTime sec"
            val duration=mediaPlayer!!.duration/1000
            val duetime=duration-playedTime
            end.text="$duetime Sec"
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
    }
}