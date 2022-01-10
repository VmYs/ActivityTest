package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytest.databinding.SecondLayoutBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //intent实际上调用的是父类的getIntent()方法，该方法会获取用于启动SecondActivity的Intent。
        //然后调用getStringExtra()方法并传入相应的键值，就可以得到传递的数据了。
        //这里由于我们传递的是字符串，所以使用getStringExtra()方法来获取传递的数据。如果传递的是整型数据，则使用getIntExtra()方法，以此类推。
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "extra data is $extraData")
    }
}