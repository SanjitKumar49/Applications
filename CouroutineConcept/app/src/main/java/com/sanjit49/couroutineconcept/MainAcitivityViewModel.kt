package com.sanjit49.couroutineconcept

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjit49.couroutineconcept.model.user
import com.sanjit49.couroutineconcept.model.userRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainAcitivityViewModel : ViewModel(){
//    private  val myjob= Job()
//    private val myscope= CoroutineScope(Dispatchers.IO)

    private  var userRepository=userRepository()
    var users : MutableLiveData<List<user>> = MutableLiveData()

    fun  getUserData(){
        viewModelScope.launch {  // myscope befor use viewmodel
     var result: List<user>?=null
            withContext(Dispatchers.IO){
                result=userRepository.getUsers()
            }
        }
    }

//    override fun onCleared() {
//        super.onCleared()
//        myscope.cancel()
//    }


}