package ru.artkolest.spidertestproject.presentation.photo_info

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.android.synthetic.main.fragment_photo_info.*
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.BaseFragment
import ru.artkolest.spidertestproject.base.extensions.onClick
import ru.artkolest.spidertestproject.databinding.FragmentPhotoInfoBinding
import ru.artkolest.spidertestproject.domain.models.PhotoModel

class PhotoInfoFragment: BaseFragment<PhotoInfoContract.Presenter>(
    R.layout.fragment_photo_info), PhotoInfoContract.View {

    private val binding by viewBinding(FragmentPhotoInfoBinding::bind)
    private lateinit var navController: NavController
    private lateinit var adapter: CommentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        initUi()
        initRecyclerView()
    }

    private fun initUi() = with(binding) {

        toolbar.ivClose.onClick {
            navController.popBackStack()
        }
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        rvComments.layoutManager = linearLayoutManager
        rvComments.setHasFixedSize(true)
        rvComments.adapter = adapter
    }

    override fun onSetData(comment: List<PhotoModel>) {
        adapter.setComment(comment)
    }

    override fun createComponent() = App.instance.getAppComponent()
        .createPhotoInfoFragment().inject(this)


}