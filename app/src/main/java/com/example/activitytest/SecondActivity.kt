package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytest.databinding.SecondLayoutBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        //intent实际上调用的是父类的getIntent()方法，该方法会获取用于启动SecondActivity的Intent。
//        //然后调用getStringExtra()方法并传入相应的键值，就可以得到传递的数据了。
//        //这里由于我们传递的是字符串，所以使用getStringExtra()方法来获取传递的数据。如果传递的是整型数据，则使用getIntExtra()方法，以此类推。
//        val extraData = intent.getStringExtra("extra_data")
//        Log.d("SecondActivity", "extra data is $extraData")


        //setResult()方法非常重要，专门用于向上一个Activity返回数据。setResult()方法接收两个参数：
        //第一个参数用于向上一个Activity返回处理结果，一般只使用RESULT_OK或RESULT_CANCELED这两个值；
        //第二个参数则把带有数据的Intent传递回去。
        //最后调用了finish()方法来销毁当前Activity。
        binding.button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return", "Hello FirstActivity")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

//    //通过在SecondActivity中重写onBackPressed()方法，当用户按下Back键后，就会执行onBackPressed()方法中的代码。
//    override fun onBackPressed() {
//        val intent = Intent()
//        intent.putExtra("data_return", "Hello FirstActivity")
//        setResult(RESULT_OK, intent)
//        finish()
//    }
}