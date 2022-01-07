package com.example.activitytest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        //传统方法
//        setContentView(R.layout.first_layout)
//        val button1: Button = findViewById(R.id.button1)
//        button1.setOnClickListener {
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//        }

//        //通过在build.gradle中添加viewBinding的配置启用该功能
        val binding = FirstLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.button1.setOnClickListener {
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//        }

//        //显式intent
//        binding.button1.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

        //隐式intent
        //只有<action>和<category>中的内容同时匹配Intent中指定的action和category时，这个Activity才能响应该Intent
        //这里没有指定category，因为android.intent.category.DEFAULT是一种默认的category，在调用startActivity()方法的时候会自动将这个category添加到Intent中
        binding.button1.setOnClickListener {
            val intent = Intent("com.example.activitytest.ACTION_START")
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Kotlin中调用Java Bean这种语法结构的Java方法时，可以使用一种更加简便的写法。
        //在onCreateOptionsMenu()方法中编写的menuInflater就使用了这种语法糖，它实际上是调用了父类的getMenuInflater()方法。
        //getMenuInflater()方法能够得到一个MenuInflater对象，再调用它的inflate()方法，就可以给当前Activity创建菜单了。
        //inflate()方法接收两个参数：第一个参数用于指定我们通过哪一个资源文件来创建菜单，这里是传入R.menu.main；
        //第二个参数用于指定我们的菜单项将添加到哪一个Menu对象当中，这里直接使用onCreateOptionsMenu()方法中传入的menu参数；
        //最后给这个方法返回true，表示允许创建的菜单显示出来，如果返回了false，创建的菜单将无法显示。
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //这里的item.itemId同上menu使用了语法糖，这里实际上在背后调用的是item的getItemId()方法
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}