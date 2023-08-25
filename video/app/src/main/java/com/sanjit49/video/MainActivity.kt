package com.sanjit49.video

import android.net.Uri
import android.net.Uri.parse
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoview=findViewById<VideoView>(R.id.videoView)
        val mediaController=MediaController(this)
        mediaController.setAnchorView(videoview)

        val url: Uri? =parse("android.resource://"+packageName+"/"+R.raw.v)
        videoview.setMediaController(mediaController)
        videoview.setVideoURI(url)
        videoview.requestFocus()
        videoview.start()

    }
}