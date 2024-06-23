package com.sriram.mocknbc.domain.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sriram.mocknbc.data.model.Shelve
import com.sriram.mocknbc.domain.usecase.HomeScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCase: HomeScreenUseCase,
) : ViewModel() {
    private val _shelveList: MutableLiveData<List<Shelve>> = MutableLiveData()
    val shelveList: LiveData<List<Shelve>>
        get() = _shelveList

    fun getHomeScreenShelves(context: Context?) {
        viewModelScope.launch(Dispatchers.IO) {
            _shelveList.postValue(context?.let { useCase.getHomeScreenContent(context = it) })
        }
    }
}
