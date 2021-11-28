package mx.konfio.dogslover.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import mx.konfio.dogslover.DogsRecyclerAdapter
import mx.konfio.dogslover.databinding.ActivityMainBinding
import mx.konfio.dogslover.core.data.DogsObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun showData(mutableList: MutableList<DogsObject>) {
        binding.rvDog.adapter = DogsRecyclerAdapter(mutableList, this)
        binding.rvDog.layoutManager = LinearLayoutManager(this@MainActivity)
        (binding.rvDog.layoutManager as LinearLayoutManager).stackFromEnd = true
        (binding.rvDog.layoutManager as LinearLayoutManager).reverseLayout = true
    }

}