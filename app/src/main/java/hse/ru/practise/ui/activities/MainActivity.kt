package hse.ru.practise.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hse.ru.practise.R
import hse.ru.practise.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_activity, MainFragment())
            .commit()
    }
}
