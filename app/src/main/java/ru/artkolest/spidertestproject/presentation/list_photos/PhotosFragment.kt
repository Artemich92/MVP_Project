package ru.artkolest.spidertestproject.presentation.list_photos

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.android.synthetic.main.fragment_photo_info.*
import kotlinx.android.synthetic.main.fragment_photos.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.BaseFragment
import ru.artkolest.spidertestproject.base.extensions.hide
import ru.artkolest.spidertestproject.databinding.FragmentPhotosBinding
import ru.artkolest.spidertestproject.domain.models.PhotoModel

class PhotosFragment : BaseFragment<PhotosContract.Presenter>(R.layout.fragment_photos),
    PhotosContract.View {

    private lateinit var navController: NavController
    private lateinit var adapter: PhotoAdapter
    private val binding by viewBinding(FragmentPhotosBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        initUi()
        initRecyclerView()
    }

    private fun initUi() = with(binding) {

        toolbar.ivClose.hide()
        toolbar.tvTitle.text = "Список фотографий"
    }

    private fun initRecyclerView() {
        val gridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvPhotos.layoutManager = gridLayoutManager
        rvPhotos.setHasFixedSize(true)
        adapter = PhotoAdapter(object : PhotoAdapter.Listener {
            override fun onClick(model: PhotoModel) {
                navController.navigate(R.id.action_photosFragment_to_photoInfoFragment)
            }
        })
        rvPhotos.adapter = adapter
    }

    override fun onSetData(photos: List<PhotoModel>) {
        adapter.setItems(photos)
    }

    override fun createComponent() = App.instance.getAppComponent()
        .createPhotosFragment().inject(this)
}



