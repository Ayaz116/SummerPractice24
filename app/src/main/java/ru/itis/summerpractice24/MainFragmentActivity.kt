package ru.itis.summerpractice24

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.itis.summerpractice24.databinding.ActivityFragmentMainBinding

class MainFragmentActivity : AppCompatActivity() {
    private var binding: ActivityFragmentMainBinding? = null

    private  var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }


        val controller = (supportFragmentManager.findFragmentById(R.id.container) as? NavHostFragment)
            ?.navController
    }




    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}