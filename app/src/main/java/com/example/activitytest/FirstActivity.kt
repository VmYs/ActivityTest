package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        //val button1: Button = findViewById(R.id.button1)
        //Kotlin编写的Android项目在app/build.gradle文件的头部默认引入了一个kotlin-android-extensions插件
        //这个插件会根据布局文件中定义的控件id自动生成一个具有相同名称的变量，我们可以在Activity里直接使用这个变量，而不用再调用findViewById()方法了
        button1.setOnClickListener {
            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}