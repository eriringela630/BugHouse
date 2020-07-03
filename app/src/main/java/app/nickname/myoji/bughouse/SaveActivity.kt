package app.nickname.myoji.bughouse

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.nickname.myoji.bughouse.launcher.LauncherActivity
import kotlinx.android.synthetic.main.activity_save.*

class SaveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val dataStore : SharedPreferences = getSharedPreferences("Second", Context.MODE_PRIVATE)

        saveButton.setOnClickListener {
            val text = input.text.toString()

            val editor = dataStore.edit()
            editor.putString("Save", text)

            editor.apply()

            val intent = Intent(this, LauncherActivity::class.java)
            startActivity(intent)
        }
    }

}

