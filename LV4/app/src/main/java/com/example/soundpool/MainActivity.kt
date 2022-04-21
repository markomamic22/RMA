package com.example.soundpool

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.soundpool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    private lateinit var mSoundPool: SoundPool
    private var mLoaded: Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setUpUi()
        this.loadSounds()
    }
    private fun setUpUi() {
        binding.test.setOnClickListener({playSound(R.raw.test)})
        binding.test2.setOnClickListener({playSound(R.raw.test2)})
        binding.test3.setOnClickListener({playSound(R.raw.test3)})
    }
    private fun loadSounds() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mSoundPool = SoundPool.Builder().setMaxStreams(10).build()
        } else {
            this.mSoundPool = SoundPool(10, AudioManager.STREAM_MUSIC, 0)
        }
        this.mSoundPool.setOnLoadCompleteListener { _, _, _ -> mLoaded = true }
        this.mSoundMap[R.raw.test] = this.mSoundPool.load(this, R.raw.test, 1)
        this.mSoundMap[R.raw.test2] = this.mSoundPool.load(this, R.raw.test2, 1)
        this.mSoundMap[R.raw.test3] = this.mSoundPool.load(this, R.raw.test3, 1)
    }


    fun playSound(selectedSound: Int) {
        val soundID = this.mSoundMap[selectedSound] ?: 0
        this.mSoundPool.play(soundID, 1f, 1f, 1, 0, 1f)
    }


}