package ru.artkolest.spidertestproject.presentation.list_photos

import android.Manifest
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.android.synthetic.main.fragment_photos.*
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.BaseFragment
import ru.artkolest.spidertestproject.base.extensions.hide
import ru.artkolest.spidertestproject.base.extensions.permissions
import ru.artkolest.spidertestproject.base.extensions.show
import ru.artkolest.spidertestproject.databinding.FragmentPhotosBinding
import ru.artkolest.spidertestproject.domain.models.pictures.ImageEntity

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
        permissions(Manifest.permission.INTERNET) {
            this.allGranted {
                presenter.start()
            }
            this.denied {
                Toast.makeText(requireContext(), R.string.error_permissions, Toast.LENGTH_SHORT)
                    .show()
                requireActivity().finish()
            }
        }
        toolbar.ivClose.hide()
        toolbar.tvTitle.setText(R.string.list_pictures)
    }

    private fun initRecyclerView() {
        val sGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        sGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        rvPhotos.layoutManager = sGridLayoutManager
        rvPhotos.setHasFixedSize(true)
        adapter = PhotoAdapter(object : PhotoAdapter.Listener {
            override fun onClick(image: ImageEntity) {
                val bundle = Bundle().apply {
                    putString(IMAGE_LINK, image.link)
                    putString(IMAGE_AUTHOR, image.author)
                    putString(DATA_ID, image.post_id)
                }
                navController.navigate(R.id.action_photosFragment_to_photoInfoFragment, bundle)
            }
        })
        rvPhotos.adapter = adapter
    }

    override fun onSetData(images: List<ImageEntity>) {
        adapter.setItems(images)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(requireContext(),
            "ERROR: ${throwable.message.toString()}",
            Toast.LENGTH_LONG).show()
    }

    override fun onShowLoad() = gLoad.show()

    override fun onHideLoad() = gLoad.hide()

    override fun onDestroyView() {
        presenter.dispose()
        super.onDestroyView()
    }

    override fun createComponent() = App.instance.getAppComponent()
        .createPhotosFragment().inject(this)

    companion object {
        private const val IMAGE_LINK = "imageLink"
        private const val IMAGE_AUTHOR = "imageAuthor"
        private const val DATA_ID = "data_id"
    }
}



