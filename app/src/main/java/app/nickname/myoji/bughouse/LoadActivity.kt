package app.nickname.myoji.bughouse

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_count.*

class LoadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)


        val dataStore : SharedPreferences = getSharedPreferences("Second", Context.MODE_PRIVATE)
        textView.text = dataStore.getString("Save", "")
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        setContentView(R.layout.activity_load)
//
//
//        val dataStore : SharedPreferences = getSharedPreferences("Second", Context.MODE_PRIVATE)
//        textView.text = dataStore.getString("Save", "")
//    }
}
