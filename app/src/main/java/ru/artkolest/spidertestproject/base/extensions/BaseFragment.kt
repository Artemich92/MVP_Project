package ru.artkolest.spidertestproject.base.extensions

import androidx.fragment.app.Fragment

abstract class BaseFragment<P: BaseContract.Presenter>(contentLayoutId: Int)
    : Fragment(contentLayoutId){
}