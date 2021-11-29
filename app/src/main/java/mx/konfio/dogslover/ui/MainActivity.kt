package mx.konfio.dogslover.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import mx.konfio.dogslover.core.data.DogsObject
import mx.konfio.dogslover.ui.adapter.DogsRecyclerAdapter
import mx.konfio.dogslover.databinding.ActivityMainBinding
import mx.konfio.dogslover.data.entities.DogsEntity
import mx.konfio.dogslover.ui.repository.DogRepository
import mx.konfio.dogslover.ui.viewmodel.DogViewModel
import mx.konfio.dogslover.ui.viewmodel.DogViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dogViewModel by viewModels<DogViewModel> {
        DogViewModelFactory(
            DogRepository(
                this@MainActivity
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
    }

    private fun observer() {
        dogViewModel.getAllDogs()
        dogViewModel.showAllDogs.observe(this, {
            if (it.size == 0) {
                dogViewModel.getAllDogsRemote()
            } else {
                showData(it)
            }
        })
        dogViewModel.showAllDogsRemote.observe(this, {
            showData(it)
        })
    }

    private fun showData(mutableList: MutableList<DogsEntity>) {
        binding.rvDog.adapter = DogsRecyclerAdapter(mutableList, this)
        binding.rvDog.layoutManager = LinearLayoutManager(this@MainActivity)
        (binding.rvDog.layoutManager as LinearLayoutManager).stackFromEnd = true
        (binding.rvDog.layoutManager as LinearLayoutManager).reverseLayout = true
    }

}