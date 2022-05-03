package com.a.luxurycar.code_files.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a.luxurycar.code_files.repository.LoginRepository
import com.a.luxurycar.code_files.view_model.LoginViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository = repository as LoginRepository) as T


            else -> {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }


}