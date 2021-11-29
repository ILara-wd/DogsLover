package mx.konfio.dogslover.ui.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import mx.konfio.dogslover.db.entities.DogsEntity
import mx.konfio.dogslover.ui.repository.DogRepository

class DogViewModel (
    private val repository: DogRepository
) : ViewModel() {

    var showAllDogs: LiveData<MutableList<DogsEntity>> = MutableLiveData()
    var showAllDogsRemote: MutableLiveData<MutableList<DogsEntity>> = MutableLiveData()

    fun saveDogs(dogsEntity: DogsEntity) {
        viewModelScope.launch {
            repository.saveDogs(dogsEntity = dogsEntity)
        }
    }

    fun getAllDogs() {
        viewModelScope.launch {
            showAllDogs = repository.getAllDogsLocal()
        }
    }

    fun getAllDogsRemote() {
        viewModelScope.launch {
            val listDogs = mutableListOf<DogsEntity>()
            repository.getAllDogsRemote().forEach { listDogs.add(DogsEntity(it)) }
            showAllDogsRemote.postValue(listDogs)
            repository.saveAllDogs(dogsList = listDogs)
        }
    }

}

class DogViewModelFactory(private val repository: DogRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass
            .getConstructor(DogRepository::class.java)
            .newInstance(repository)
    }
}