package com.example.activitytest

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : BaseActivity() {

    //registerForActivityResult()方法接收两个参数：
    //第一个参数是一种Contract类型，由于我们是希望从另外一个Activity中请求数据，因此这里使用了StartActivityForResult这种Contract。
    //第二个参数是一个Lambda表达式，当有结果返回时则会回调到这里，然后我们在这里获取并处理数据即可。
    //registerForActivityResult()方法的返回值是一个ActivityResultLauncher对象，这个对象当中有一个launch()方法可以用于去启用Intent。
    private val requestDataLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            val returnedData = it.data?.getStringExtra("data_return")
            Log.d("FirstActivity", "returned data is $returnedData")
        }
    }

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
        Log.d("FirstActivity", this.toString())
//        binding.button1.setOnClickListener {
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()
//        }

//        //显式intent
//        binding.button1.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
//        }

//        //隐式intent
//        //只有<action>和<category>中的内容同时匹配Intent中指定的action和category时，这个Activity才能响应该Intent
//        //这里没有指定category，因为android.intent.category.DEFAULT是一种默认的category，在调用startActivity()方法的时候会自动将这个category添加到Intent中
//        binding.button1.setOnClickListener {
//            val intent = Intent("com.example.activitytest.ACTION_START")
//            startActivity(intent)
//        }

//        //首先指定了Intent的action是Intent.ACTION_VIEW，这是一个Android系统内置的动作。
//        //其常量值为android.intent.action.VIEW，用于显示用户的数据。比较通用，会根据用户的数据类型打开相应的Activity。
//        //然后通过Uri.parse()方法将一个网址字符串解析成一个Uri对象，再调用Intent的setData()方法将这个Uri对象传递进去。
//        //当然，这里再次使用了语法糖，看上去像是给Intent的data属性赋值一样。
//        binding.button1.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)
//        }

//        //首先指定了Intent的action是Intent.ACTION_DIAL，这又是一个Android系统的内置动作。
//        //然后在data部分指定了协议是tel，号码是10086。
//        binding.button1.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)
//        }

//        //向SecondActivity传递数据
//        binding.button1.setOnClickListener {
//            val data = "Hello SecondActivity"
//            val intent = Intent(this, SecondActivity::class.java)
//            //通过putExtra()方法传递了一个字符串。
//            //putExtra()方法接收两个参数，第一个参数是键，用于之后从Intent中取值，第二个参数才是真正要传递的数据。
//            intent.putExtra("extra_data", data)
//            startActivity(intent)
//        }

//        binding.button1.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            //该函数用来获取SecondActivity的intent数据，目前已被官方废弃。
//            startActivityForResult(intent, 1)
//        }

        binding.button1.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            //最开始通过registerForActivityResult()方法的返回值是一个ActivityResultLauncher对象，这个对象当中有一个launch()方法可以用于去启用Intent。
            //因此不需要再调用startActivityForResult()方法了，而是直接调用launch()方法，并把Intent传入即可。
            requestDataLauncher.launch(intent)
            startActivity(intent)
        }

//        //用于打印当前Activity实例，查看Activity的默认启动模式standard的情况。
//        //通过打印信息中可以看出，每点击一次按钮，就会创建出一个新的FirstActivity实例。
//        //此时返回栈中若存在3个FirstActivity的实例，则需要连按3次Back键才能退出程序。
//        Log.d("FirstActivity", this.toString())
//        binding.button1.setOnClickListener {
//            val intent = Intent(this, FirstActivity::class.java)
//            startActivity(intent)
//        }

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

//    //通过上面startActivityForResult函数获取SecondActivity的intent数据，但目前该函数已被官方废弃。
//    //onActivityResult()方法带有3个参数：
//    //第一个参数requestCode，即在启动Activity时传入的请求码；
//    //第二个参数resultCode，即我们在返回数据时传入的处理结果；
//    //第三个参数data，即携带着返回数据的Intent。
//    //由于在一个Activity中有可能调用startActivityForResult()方法去启动很多不同的Activity，每一个Activity返回的数据都会回调到onActivityResult()这个方法中,因此首先要做的就是通过检查requestCode的值来判断数据来源。
//    //确定数据是从SecondActivity返回的之后，再通过resultCode的值来判断处理结果是否成功。
//    //最后从data中取值并打印出来，这样就完成了向上一个Activity返回数据的工作。
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode) {
//            1 -> if (resultCode == RESULT_OK) {
//                val returnedData = data?.getStringExtra("data_return")
//                Log.d("FirstActivity", "returned data is $returnedData")
//            }
//        }
//    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity", "onRestart")
    }
}