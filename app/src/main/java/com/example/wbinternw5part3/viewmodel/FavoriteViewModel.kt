package com.example.wbinternw5part3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wbinternw5part3.model.AppState
import com.example.wbinternw5part3.model.FavoriteData
import com.example.wbinternw5part3.model.remote.PostsService
import com.example.wbinternw5part3.utils.sortingVoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel : ViewModel() {
    private val service = PostsService.create()

    private val _data = MutableLiveData<AppState>()

    val liveData: LiveData<AppState> = _data

    fun getData() {
        _data.postValue(AppState.Loading)
        viewModelScope.launch { loadData() }
    }

    private suspend fun loadData() = withContext(Dispatchers.IO) {
        try {
            val voteResponse = service.getVoteList()
            val favoriteData = arrayListOf<FavoriteData>()
            for (item in voteResponse) {
                favoriteData.add(
                    FavoriteData(
                        item.created_at,
                        item.value,
                        service.getImageById(item.image_id).url
                    )
                )
            }
            _data.postValue(AppState.SuccessFavorite(sortingVoteList(favoriteData)))
        } catch (e: Throwable) {
            _data.postValue(AppState.Error(e))
        }
    }
}